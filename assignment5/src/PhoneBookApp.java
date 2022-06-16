

import java.util.Scanner;

public class PhoneBookApp{
	
	private PhoneBook phoneBook;
	
	public PhoneBookApp(String fileName) {
		phoneBook = new PhoneBook(fileName);
	}

	public void displayMenu() {
		
		System.out.println("***MY PHONEBOOK APPLICATION***");
		String userInput;
		do {
			System.out.println("Please choose an operation:");
			System.out.print("A (Add) | S (Search) | P (Print) |R (Remove) | Q (Quit):");
			
			Scanner sc = new Scanner(System.in);
			userInput = sc.next();
			
			if (userInput.equals("A")) {
				add(phoneBook);
			} else if (userInput.equals("S")) {
				search(phoneBook);
			} else if (userInput.equals("P")) {
				print(phoneBook);
			} else if (userInput.equals("R")) {
				remove(phoneBook);
			} 
			System.out.println();
		
		} while (userInput.equals("Q"));
	
	}
	
	void add(PhoneBook phoneBook) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter name:");
		String name = sc.nextLine();
		System.out.print("Enter phone number:");
		String phone = sc.next();

		Contact newContact = new Contact(name, phone);
		
		phoneBook.add(newContact);
	}

	public void search(PhoneBook phoneBook) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter name:");
		String name = sc.next();

		String phone = search(name);
		
		if(phone != null)
			System.out.println("Phone: " + phone);
		else
			System.out.println("Not found!");
	}

	public void remove(PhoneBook phoneBook) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter name:");
		String name = sc.nextLine();

		phoneBook.remove(name);
	}
	
	public void print(PhoneBook phoneBook) {
		phoneBook.print();
	}

}
