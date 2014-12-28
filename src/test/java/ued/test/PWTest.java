package ued.test;

import static org.junit.Assert.assertNotNull;

import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;

import ued.unix.PW;
import ued.unix.PWFileReader;
import ued.unix.PWReader;

/** Simple program to test the PW class */
public class PWTest {

	@Test
	public void testReader() {
		InputStream is = getClass().getResourceAsStream("/passwd.txt");
		PWReader pr = new PWFileReader(new InputStreamReader(is));

		PW root = pr.getpwnam("root");
		assertNotNull("Entry for 'root' missing?", root);
		System.out.println("Entry for 'root' = " + root);

		PW mrniceguy = pr.getpwuid(100);
		assertNotNull("Entry for user 100 missing?", mrniceguy);
		System.out.println("Self = " + mrniceguy);
	}
}
