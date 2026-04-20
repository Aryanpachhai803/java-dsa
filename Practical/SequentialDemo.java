package Practical;

import java.util.Scanner;

class Contact {
    String name;
    String phone;

    Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}

public class SequentialDemo {

    public static int searchContact(Contact[] contacts, String target) {
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i].name.equalsIgnoreCase(target)) {
                return i; 
            }
        }
        return -1; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Contact[] contacts = {
            new Contact("Alex", "9841000001"),
            new Contact("Birat", "9841000002"),
            new Contact("Chintan", "9841000003"),
            new Contact("David", "9841000004")
        };

        System.out.print("Enter name to search: ");
        String name = sc.nextLine();

        int result = searchContact(contacts, name);

        if (result != -1) {
            System.out.println("Contact Found!");
            System.out.println("Name: " + contacts[result].name);
            System.out.println("Phone: " + contacts[result].phone);
        } else {
            System.out.println("Contact not found.");
        }

        sc.close();
    }
}
