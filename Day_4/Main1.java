//1. Moveable Shapes Simulation


package Day_4;

//import java.util.*;


interface Movable {
 void moveUp();
 void moveDown();
 void moveLeft();
 void moveRight();
}


class MovablePoint implements Movable {
 int x, y, xSpeed, ySpeed;

 MovablePoint(int x, int y, int xSpeed, int ySpeed) {
     this.x = x;
     this.y = y;
     this.xSpeed = xSpeed;
     this.ySpeed = ySpeed;
 }

 public void moveUp() { y += ySpeed; }
 public void moveDown() { y -= ySpeed; }
 public void moveLeft() { x -= xSpeed; }
 public void moveRight() { x += xSpeed; }

 public String toString() {
     return "Point (" + x + ", " + y + ")";
 }
}


class MovableCircle implements Movable {
 int radius;
 MovablePoint center;

 MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
     this.center = new MovablePoint(x, y, xSpeed, ySpeed);
     this.radius = radius;
 }

 public void moveUp() { center.moveUp(); }
 public void moveDown() { center.moveDown(); }
 public void moveLeft() { center.moveLeft(); }
 public void moveRight() { center.moveRight(); }

 public String toString() {
     return "Circle center: " + center + ", Radius: " + radius;
 }
}


class MovableRectangle implements Movable {
 MovablePoint topLeft, bottomRight;

 MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
     topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
     bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
 }

 public void moveUp() {
     topLeft.moveUp();
     bottomRight.moveUp();
 }

 public void moveDown() {
     topLeft.moveDown();
     bottomRight.moveDown();
 }

 public void moveLeft() {
     topLeft.moveLeft();
     bottomRight.moveLeft();
 }

 public void moveRight() {
     topLeft.moveRight();
     bottomRight.moveRight();
 }

 public String toString() {
     return "Rectangle TopLeft: " + topLeft + ", BottomRight: " + bottomRight;
 }
}


public class Main1 {
 public static void main(String[] args) {

     MovablePoint p = new MovablePoint(0, 0, 2, 3);
     MovableCircle c = new MovableCircle(5, 5, 1, 1, 10);
     MovableRectangle r = new MovableRectangle(1, 1, 4, 4, 2, 2);

     System.out.println("Initial Positions:");
     System.out.println(p);
     System.out.println(c);
     System.out.println(r);

     
     p.moveRight();
     c.moveUp();
     r.moveLeft();

     System.out.println("\nAfter Movement:");
     System.out.println(p);
     System.out.println(c);
     System.out.println(r);
 }
}