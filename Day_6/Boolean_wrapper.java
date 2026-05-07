//6.Create Boolean Wrapper usage

package Day_6;

public class Boolean_wrapper {
    public static void main(String[] args) {

        Boolean b1 = Boolean.valueOf("true");
        Boolean b2 = Boolean.valueOf("false");

        System.out.println("Boolean 1: " + b1);
        System.out.println("Boolean 2: " + b2);

        if (b1) {
            System.out.println("Condition is true");
        }
    }
}