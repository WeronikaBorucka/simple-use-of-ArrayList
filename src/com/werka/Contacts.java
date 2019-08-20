package com.werka;

import java.util.ArrayList;

public class Contacts {

    private ArrayList<String> nameList = new ArrayList<String>();
    private ArrayList<String> phoneNumberList = new ArrayList<String>();

    public void addContact(String name, String number){
        if (isValidPhoneNumber(number)) {
            phoneNumberList.add(number);
            nameList.add(name);
            System.out.println("Added contact:");
            showContact(name);
        } else {
            System.out.println("Phone number you have given is not valid. Try again.");
        }
    }

    public void modifyContact(String name, String newName){
        if (nameList.contains(name)){
            nameList.set(findContact(name),newName);
            System.out.println("Contact is now:");
            showContact(newName);
        } else {
            System.out.println("Sorry, didn't find "+name+" position on the list. You cannot modify it.");
        }
    }

    public void modifyContact(String name, int number){
        String numberString = String.valueOf(number);
        boolean isValid = isValidPhoneNumber(numberString);
        if (isValid && phoneNumberList.contains(numberString)){
            phoneNumberList.set(findContact(name),numberString);
            System.out.println("Contact is now:");
            showContact(name);
        } else if(!isValid){
            System.out.println("Sorry, this phone number is invalid. "+ name + " contact wasn't modified.");
        } else {
            System.out.println("Sorry, didn't find "+name+" position on the list. You cannot modify it.");
        }
    }

    public void removeContact(String name){
        int position = findContact(name);
        if (position!=-1){
            System.out.println("Contact:");
            showContact(name);
            System.out.println("is now removed");
            nameList.remove(position);
            phoneNumberList.remove(position);
        } else {
            System.out.println("Didn't find "+name+" contact. Can't remove it.");
        }

    }

    public boolean showContact(String name){
        int position = findContact(name);
        boolean isCompleted = false;

        if (position!=-1){
            System.out.println("#"+(position+1)+" "+nameList.get(position)+"\t"+phoneNumberList.get(position));
            isCompleted = true;
        } else {
            System.out.println("Sorry, didn't find "+name+" position on the list.");
        }
        return isCompleted;
    }

    public void showContactList(){
        if (!nameList.isEmpty()) {
            for (int i=0; i < nameList.size(); i++) {
                showContact(nameList.get(i));
            }
        } else {
            System.out.println("Sorry, this Contact List is empty.");
        }
    }

    private int findContact(String name){
       return nameList.indexOf(name);
    }

    private boolean isValidPhoneNumber(String phoneNumber){
        int number = 0;
        try {
            number = Integer.parseInt(phoneNumber);
        } catch (NumberFormatException e){
            return false;
        }

        if (number>=100000000 && number<=999999999){
            return true;
        } else {
            return false;
        }
    }

}