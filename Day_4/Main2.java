//2. Default and Static Methods in Interfaces


package Day_4;


interface Polygon {

 double getArea();

 
 default double getPerimeter(int... sides) {
     int sum = 0;
     for (int side : sides) {
         sum += side;
     }
     return sum;
 }

 
 static String shapeInfo() {
     return "Polygons are closed shapes with multiple sides.";
 }
}


class Rectangle implements Polygon {
 double length, width;

 Rectangle(double length, double width) {
     this.length = length;
     this.width = width;
 }

 public double getArea() {
     return length * width;
 }
}


class Triangle implements Polygon {
 double base, height;

 Triangle(double base, double height) {
     this.base = base;
     this.height = height;
 }

 public double getArea() {
     return 0.5 * base * height;
 }
}


public class Main2 {
 public static void main(String[] args) {

     Rectangle rect = new Rectangle(5, 3);
     Triangle tri = new Triangle(4, 6);

     System.out.println("Rectangle Area: " + rect.getArea());
     System.out.println("Rectangle Perimeter: " + rect.getPerimeter(5, 3, 5, 3));

     System.out.println("Triangle Area: " + tri.getArea());
     System.out.println("Triangle Perimeter: " + tri.getPerimeter(3, 4, 5));

     System.out.println(Polygon.shapeInfo());
 }
}