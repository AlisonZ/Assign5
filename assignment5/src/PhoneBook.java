
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PhoneBook{
	
	private BST tree;
	
	public PhoneBook(String fileName) {
		
		load(fileName);
	}
	
	private void load(String fileName) {
		try {
			Scanner sc = new Scanner(new File("fileName"));

			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				Scanner lineScanner = new Scanner(line);
				String name = sc.next();
				name += " " + sc.next();
				String phone = sc.next();
				
				tree.insert(name, phone);				
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
	}

	
	public void add(Contact contact) {
		tree.insert(contact.getName(), contact.getPhone());
	}
	
	public void remove(String name) {
		tree.remove(name);
	}
	
	public String search(String name) {
		return tree.search(name);
	}
	
	private void print() {
		tree.printPreOrder();
		System.out.println("Size:" + tree.size());
	}

}













