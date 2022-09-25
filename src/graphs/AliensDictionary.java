package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/***
 @author: Pratiksha Kulkarni
 date: 9/25/2022
 */
public class AliensDictionary {
    /***
     * this dictionary will fail
     * 1 .if abc->abcd where abc is string with smaller length, and all the chars are
     * equal to the next abcd string. SO if such smaller string appears before the larger string
     * 2. cycle present i.e abc->bat->acd i.e.is a cycle = a->b->a
     * @param dict contains N words
     * @param N N number of words in the dict[] array
     * @param K k is the starting alphabets of standard dictionary
     * @return String
     */
    public String findOrder(String[] dict, int N, int K) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        //create the graph
        for (int i = 0; i < K; i++)
            adj.add(new ArrayList<Integer>());

        /**
         * now traverse through each word, compare 2 words
         * if their starting char are different create the edge between them
         * baa-abcd therefore create a edge between b->a
         * else find the next different chars and create the edge;
         */

        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int min = Math.min(s1.length(), s2.length());

            for (int j = 0; j < min; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }
        /**
         * Once the graph is ready implement the topological  sort and return the order;
         */

        return topoSort(adj, K);
    }

    private String topoSort(ArrayList<ArrayList<Integer>> adj, int K) {
        Queue<Integer> q = new LinkedList<>();
        int indegree[] = new int[K];
        String order = "";

        for (int i = 0; i < K; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            Integer node = q.remove();
            order += (char) (node + (int) 'a');

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0)
                    q.add(it);
            }
        }

        return order;
    }
}
