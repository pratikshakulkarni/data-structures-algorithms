package tries;

import java.util.Locale;

/***
 @author: Pratiksha Kulkarni
 date: 9/3/2022
 */
public class LongestCommonPrefixUsingTrie {

    private TrieNode root;

    public LongestCommonPrefixUsingTrie(){
        root=new TrieNode();
    }
    private class TrieNode{
        private char data;
        private TrieNode[] children= new TrieNode[26];
        private boolean endOfString;
        private int childCount;

        public TrieNode(){
            endOfString=false;
            childCount=0;
        }
    }

    public void insert(TrieNode root, String word){
        if(word.length()==0){
            root.endOfString=true;
            return;
        }
        word=word.toLowerCase(Locale.ROOT);
        TrieNode insertNode;
        int index = word.charAt(0)-'a';
        if(root.children[index] != null){
            insertNode = root.children[index];
        }
        else{
            insertNode = new TrieNode();
            insertNode.childCount++;
            insertNode.data=word.charAt(0);
            root.children[index]=insertNode;
        }

        insert(insertNode,word.substring(1));
    }

    public String findLongestCommonPrefix(String[] words,TrieNode root){
        String s="";
        for(int i=0;i<words[0].length();i++){
            char ch = words[0].charAt(i);
            if(root.childCount == 1){
                int index = ch-'a';
                s += String.valueOf(ch);
                root = root.children[index];
            }
            else{
                break;
            }
            if(root.endOfString)
                break;
        }
        return s;
    }

    public static void main(String[] args) {
        LongestCommonPrefixUsingTrie trie = new LongestCommonPrefixUsingTrie();
        String[] arr = {"codelove", "coder", "coding", "code"};
        for(String s : arr)
            trie.insert(trie.root,s);

        System.out.println("Longest prefix : "+ trie.findLongestCommonPrefix(arr, trie.root));

    }
}
