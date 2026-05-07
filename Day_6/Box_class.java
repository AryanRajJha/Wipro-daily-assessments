//2.Create a class Box with a variable length. Write a method that modifies the value of length by passing the Box object. Show that the original object is modified.


package Day_6;

class Box {
    int length;

    Box(int length) {
        this.length = length;
    }
}

public class Box_class {

    static void modify(Box b) {
        b.length = b.length + 10;
        System.out.println("Inside method: " + b.length);
    }

    public static void main(String[] args) {
        Box box = new Box(5);

        System.out.println("Before method call: " + box.length);
        modify(box);
        System.out.println("After method call: " + box.length);
    }
}