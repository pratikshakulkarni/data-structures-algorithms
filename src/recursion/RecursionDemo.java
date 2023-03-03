package recursion;

/***
 @author: Pratiksha Kulkarni
 date: 3/3/2023
 */
public class RecursionDemo {
    public static void main(String[] args) {
//        System.out.println("printNameNTimes ");
//        printNameNTimes("Pratiksha",0);
//        System.out.println("print1ToN");
//        print1ToN(1,10);
//        System.out.println("printNTo1");
//        printNTo1(1,10);
        System.out.println("print1ToNUsingBackTrack");
        print1ToNUsingBackTrack(10);

        System.out.println("printNTo1UsingBackTrack");
        printNTo1UsingBackTrack(1);
    }

    private static void printNTo1(int i, int n) {
        if(n==i)
            return;
        System.out.println(n);
        printNTo1(i,n-1);
    }

    private static void print1ToN(int i, int n) {
        if(i==n)
            return;
        System.out.println(i);
        print1ToN(i+1,n);
    }

    private static void printNameNTimes(String name, int i) {
        if(i==5) return;

        System.out.println(name);
        printNameNTimes(name,i+1);
    }

    private static void print1ToNUsingBackTrack(int i){
        if(i<1)
            return;
        print1ToNUsingBackTrack(i-1);
        System.out.println(i);
    }

    private static void printNTo1UsingBackTrack(int i){
        if(i>10) return;
        printNTo1UsingBackTrack(i+1);
        System.out.println(i);
    }
}
