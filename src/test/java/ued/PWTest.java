package ued.test;

import org.junit.*;
import static org.junit.Assert.*;

import ued.unix.*;

/** Simple program to test the PW class */
public class PWTest {

	@Test
	public void testReader() {
		PWReader pr = new PWFileReader("./passwd.txt");

		PW root = pr.getpwnam("root");
		assertNotNull("Entry for 'root' missing?", root);
		System.out.println("Entry for 'root' = " + root);

		PW mrniceguy = pr.getpwuid(100);
		assertNotNull("Entry for user 100 missing?", mrniceguy);
		System.out.println("Self = " + mrniceguy);
	}
}
