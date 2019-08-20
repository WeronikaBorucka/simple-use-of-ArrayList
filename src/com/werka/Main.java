package com.werka;

import java.util.Scanner;


// Create a program that implements a simple mobile phone with the following capabilities.
// Able to store, modify, remove and query contact names.
// You will want to create a separate class for Contacts (nameList and phone number).
// Create a master class (MobilePhone) that holds the ArrayList of Contacts
// The MobilePhone class has the functionality listed above.
// Add a menu of options that are available.
// Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
// and search/find contact.
// When adding or updating be sure to check if the contact already exists (use nameList)
// Be sure not to expose the inner workings of the ArrayList to MobilePhone
// e.g. no ints, no .get(i) etc
// MobilePhone should do everything with Contact objects only.

public class Main {

    private static Contacts contactList = new Contacts();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean flag = true;

        contactList.addContact("Weronika", "123456789");
        contactList.addContact("Ola", "987654321");
        contactList.addContact("Anna", "111222333");
        contactList.showContactList();
        contactList.modifyContact("Ola", "Asia");
        contactList.modifyContact("Asia", 876);
        contactList.addContact("Agatka", "666333555");
        contactList.removeContact("Asia");
        contactList.showContactList();

        showMenu();

        while (flag) {
            System.out.println("Enter your choice:");
            int number = scanner.nextInt();
            scanner.nextLine();
            switch (number) {
                case 1:
                    showContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    modifyContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    findContact();
                    break;
                case 6:
                    showMenu();
                    break;
                case 7:
                    flag = false;
                    scanner.close();
                    break;
                default:
                    break;
            }
        }
    }

    private static void showMenu() {
        System.out.println("Pick one option:");
        System.out.println("1. Show all contacts");
        System.out.println("2. Add contact");
        System.out.println("3. Modify contact");
        System.out.println("4. Remove contact");
        System.out.println("5. Search for contact");
        System.out.println("6. Show menu");
        System.out.println("7. Quit\n");
    }

    private static void showContacts() {
        contactList.showContactList();
    }

    private static void addContact() {
        System.out.println("Type in name for contact:");
        String name = scanner.nextLine();
        System.out.println("Type in number for contact:");
        String number = scanner.nextLine();
        contactList.addContact(name, number);
    }

    private static void modifyContact() {
        System.out.println("Enter current name for contact:\n");
        String currentName = scanner.nextLine();

        if (contactList.showContact(currentName)) {
            System.out.println("For changing name of contact press 1\nFor changing number of contact press 2.");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter new name for contact\n");
                    String newName = scanner.nextLine();
                    contactList.modifyContact(currentName, newName);
                    break;
                case 2:
                    System.out.println("Enter new number for contact\n");
                    int newNumber = scanner.nextInt();
                    scanner.nextLine();
                    contactList.modifyContact(currentName,newNumber);
                    break;
            }
        } else {
            System.out.println("This contact doesn't exist, can't modify it.");
        }
    }

    private static void removeContact(){
        System.out.println("Enter contact name you would like to delete:\n");
        contactList.removeContact(scanner.nextLine());
    }

    private static void findContact(){
        System.out.println("Enter contact name to find:\n");
        contactList.showContact(scanner.nextLine());
    }
}
