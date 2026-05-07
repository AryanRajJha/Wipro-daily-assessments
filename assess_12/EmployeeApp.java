//How will you use Serialization in Java to save and retrieve employee objects from files?

package assess_12;

import java.io.*;

class Employee implements Serializable {
 int id;
 String name;
 double salary;

 Employee(int id, String name, double salary) {
     this.id = id;
     this.name = name;
     this.salary = salary;
 }

 void display() {
     System.out.println(id + " " + name + " " + salary);
 }
}

public class EmployeeApp {
 public static void main(String[] args) {

     Employee emp = new Employee(1, "Aryan", 50000);

     
     try {
         ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("emp.txt"));
         oos.writeObject(emp);
         oos.close();
         System.out.println("Employee Saved!");

     } catch (IOException e) {
         System.out.println(e);
     }

     
     try {
         ObjectInputStream ois = new ObjectInputStream(new FileInputStream("emp.txt"));
         Employee e = (Employee) ois.readObject();
         ois.close();

         System.out.println("Employee Retrieved:");
         e.display();

     } catch (Exception e) {
         System.out.println(e);
     }
 }
}