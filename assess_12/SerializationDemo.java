package assess_12;

import java.io.*;


class Student implements Serializable {
 int id;
 String name;


 Student(int id, String name) {
     this.id = id;
     this.name = name;
 }

 
 void display() {
     System.out.println("ID: " + id + ", Name: " + name);
 }
}

public class SerializationDemo {
 public static void main(String[] args) {

     
     Student s1 = new Student(101, "Aryan");

   
     try {
         FileOutputStream fos = new FileOutputStream("student.txt");
         ObjectOutputStream oos = new ObjectOutputStream(fos);

         oos.writeObject(s1);  
         oos.close();
         fos.close();

         System.out.println("Object Serialized Successfully!");

     } catch (IOException e) {
         System.out.println(e);
     }

   
     try {
         FileInputStream fis = new FileInputStream("student.txt");
         ObjectInputStream ois = new ObjectInputStream(fis);

         Student s2 = (Student) ois.readObject(); 
         ois.close();
         fis.close();

         System.out.println("Object Deserialized Successfully!");
         s2.display();

     } catch (IOException | ClassNotFoundException e) {
         System.out.println(e);
     }
 }
}