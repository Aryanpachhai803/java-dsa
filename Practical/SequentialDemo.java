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
    }
}
