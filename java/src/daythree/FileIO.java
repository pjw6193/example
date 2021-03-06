package daythree;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// POJO - Plain Old Java Object (data wrapper) 
/**
 * JavaBean - 
 * 		1. Encapsulated (getter/setters/private fields)
 * 		2. No-argument constructor
 * 		3. Getters/setters naming convention 
 * 		4. (optional) implements Serializable -- deprecated (no longer supported)
 *
 */
class User {
	private String firstName;
	private String lastName;
	private String email;
	
	public User() {
		super();
	}
	public User(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}

}


public class FileIO {
	
	private static String csvFile = "users.csv"; // hardcoding
	
	// InputStream, OutputStream, bytes, characters, strings/lines
	public static void main(String[] args) {
		System.out.println(readCsv(csvFile));
	}

	public static List<User> readCsv(String filename) {
		List<User> users = new LinkedList<>();
		File file = new File(filename);
		try (Scanner scanner = new Scanner(file)) {
			int row = 1;
			while (scanner.hasNextLine()) {
				scanner.useDelimiter(",");
				String firstName = scanner.next();
				String lastName = scanner.next();
				scanner.reset(); // \n
				String email = scanner.next();
				User user = new User(firstName, lastName, email);
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	public void tryWith() {
		File file = new File("data.txt");
		// "try-with" resources

		try (Scanner scanner = new Scanner(file)) {
			String content = scanner.nextLine();
			System.out.println(content);
		} catch (Exception e) {
			System.out.println(e.getClass());
		}

		// automatically close resources
		// anything that implements Autocloseable
	}

	public void tryFinally() {
		// not create a file on your file system
		// an object representation of some file
		Scanner scanner = null;
		try {
			File file = new File("bloop");
			scanner = new Scanner(file);
			String content = scanner.nextLine(); // returns token up to \n character
			System.out.println(content);
		} catch (Exception e) {
			System.out.println(e.getClass());
		} finally {
			// code executes no matter what
			// executes try goes well, OR exception is thrown
			// close out resources
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	public void readHello() throws FileNotFoundException {
		// not create a file on your file system
		// an object representation of some file
		File file = new File("text.txt");
		Scanner scanner = new Scanner(file);
		String content = scanner.nextLine(); // returns token up to \n character
		System.out.println(content);
		scanner.close();
	}

	public void writeHello(String fileName) throws FileNotFoundException {
		// Open file, r/w, close file
		PrintWriter writer = new PrintWriter(fileName);
		// writing to file that doesn't exists will create the file
		writer.println("Hello World");
		writer.close();
	}

}
