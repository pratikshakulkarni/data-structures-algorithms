package tries;

/***
 @author: Pratiksha Kulkarni
 date: 9/3/2022
 */
public class LongestCommonPrefixWithoutTrie {

    private static String findLongestCommonPrefix(String[] arr) {
        String s = "";
        for (int i = 0; i < arr[0].length(); i++) {
            char ch = arr[0].charAt(i);
            boolean flag = true;
            for (int j = 1; j < arr.length; j++) {
                if (arr[j].charAt(i) != ch) {
                    flag = false;
                    break;
                }
            }
            if (!flag)
                break;
            else
                s += String.valueOf(ch);
        }
        return s;
    }

    public static void main(String[] args) {

        System.out.println(findLongestCommonPrefix(new String[]{"codelove", "coder", "coding", "code"}));

    }
}
