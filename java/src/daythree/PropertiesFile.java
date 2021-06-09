package daythree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// inherits Hashtable
		Properties props = new Properties();
		// byte, char, str/lines
		props.load(new FileInputStream("hello.properties"));
		System.out.println(props.get("en.hello.world"));
		
		
		loadClassPath();
	}

	public static void loadClassPath() throws IOException {
		Properties props = new Properties();
		// reflection
		InputStream stream = PropertiesFile.class.getClassLoader()
				.getResourceAsStream("insourcefolder.properties");
		props.load(stream);
		System.err.println(props.get("en.hello.world"));
		
	}

}
