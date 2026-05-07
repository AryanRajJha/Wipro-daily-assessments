//1.Write a program where a method accepts an integer parameter and tries to change its value. Print the value before and after the method call.

package Day_6;

public class PassByValue {

    static void changeValue(int num) {
        num = num + 10;
        System.out.println("Inside method: " + num);
    }

    public static void main(String[] args) {
        int x = 5;

        System.out.println("Before method call: " + x);
        changeValue(x);
        System.out.println("After method call: " + x);
    }
}