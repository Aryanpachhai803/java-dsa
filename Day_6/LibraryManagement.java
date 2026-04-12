package Day_6;
import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;
    Book next;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.next = null;
    }
}

class Library {
    Book head = null;

    public void addBook(int id, String title, String author) {
        Book newBook = new Book(id, title, author);
        if (head == null) {
            head = newBook;
        } else {
            Book temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newBook;
        }
        System.out.println("Book added successfully!");
    }

    public void displayBooks() {
        if (head == null) {
            System.out.println("No books available.");
            return;
        }

        Book temp = head;
        while (temp != null) {
            System.out.println("ID: " + temp.id +
                               ", Title: " + temp.title +
                               ", Author: " + temp.author);
            temp = temp.next;
        }
    }

}

public class LibraryManagement {
    public static void main(String[] args) {
    }
}