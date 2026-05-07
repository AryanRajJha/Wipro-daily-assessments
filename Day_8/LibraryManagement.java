//Library Management
//Use Map<Book, Boolean> to track availability.

package Day_8;

import java.util.*;

class Book {
    String name;

    Book(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Book)) return false;
        Book b = (Book) obj;
        return name.equals(b.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Book, Boolean> library = new HashMap<>();

        library.put(new Book("Java"), true);
        library.put(new Book("Python"), true);
        library.put(new Book("Data Structures"), true);

        System.out.print("Enter book name to borrow: ");
        String input = sc.nextLine();

        Book searchBook = new Book(input);

        if (library.containsKey(searchBook)) {
            if (library.get(searchBook)) {
                library.put(searchBook, false);
                System.out.println("Book issued successfully.");
            } else {
                System.out.println("Book is not available.");
            }
        } else {
            System.out.println("Book not found in library.");
        }
        sc.close();
    }
    
}
