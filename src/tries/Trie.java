package tries;

import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

/***
 @author: Pratiksha Kulkarni
 date: 9/3/2022
 */
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    private class TrieNode {
        private char data;
        private TrieNode[] children;
        private boolean endOfString;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.endOfString = false;
        }
    }

    public void insert(String word) {
        if (word == null || word.isEmpty())
            throw new IllegalArgumentException("Invalid string provided");

        word = word.toLowerCase(Locale.ROOT);

        //insertion in empty trie
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (currentNode.children[index] == null) {
                TrieNode node = new TrieNode();
                node.data=word.charAt(i);
                currentNode.children[index] = node;
                currentNode = node;
            } else {
                currentNode = currentNode.children[index];
            }
        }
        currentNode.endOfString = true;
        System.out.println("String inserted successfully");

        //insertion with no common prefix
        //insertion with common prefix
        //insertion with word already present in the trie
    }

    public void insertRec(TrieNode root , String word){
        //base case
        if(word.length()==0) {
            root.endOfString = true;
            return;
        }

        int index = word.charAt(0)-'a';
        TrieNode node;

        //Present
        if(root.children[index] != null){
            node=root.children[index];
        }
        //absent
        else{
            node = new TrieNode();
            root.children[index]=node;
        }

        insertRec(node,word.substring(1));

    }

    public boolean search(TrieNode root,String word) {

        if(word.length()==0)
            return root.endOfString;

        int index = word.charAt(0)-'a';
        TrieNode searchNode;

        if(root.children[index] != null){
            searchNode = root.children[index];
        }
        else
            return false;

        return search(searchNode,word.substring(1));
    }

    public void display(TrieNode root, String s){
        System.out.println(" s " + s);
        if(root.endOfString) {
            System.out.println(s);
        }
        for(int i=0;i<26;i++){
            if(root.children[i]!=null){
                s += String.valueOf(root.children[i].data);
                //System.out.println("ith char " +(char) (i + 'a'));
                display(root.children[i], s);
            }
        }

    }

    public boolean remove(TrieNode root, String s){
        if(s.length()==0){
            root.endOfString=false;
            return true;
        }
         int index = s.charAt(0)-'a';
        TrieNode removeNode;
        if(root.children[index] != null){
            removeNode = root.children[index];
        }
        else
            return false;

        return  remove(removeNode,s.substring(1));

    }


    public static void main(String[] args) {
        Trie t = new Trie();
        //t.insert("hi");
        t.insertRec(t.root,"bye");
        t.insertRec(t.root,"hello");
        t.insertRec(t.root,"hi");
        //t.display(t.root,"");
        System.out.println("Present? "+t.search(t.root,"hi"));
        System.out.println("removed? "+t.remove(t.root,"hi"));
        System.out.println("Present? "+t.search(t.root,"hi"));
    }

}
