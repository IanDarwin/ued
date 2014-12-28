package ued.unix;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class PWReader {
	/** The file we use for reading */
	protected BufferedReader pwf;
	/** The name of the standard password file */
	public static final String PWFILE = "/etc/passwd";

	public abstract PW getpwent();

	public abstract PW getpwnam(String name);

	public abstract PW getpwuid(int u);

	// CONSTRUCTORS
	/** Construct a PWReader object for the standard password file */
	public PWReader() {
		this(PWFILE);
	}
	
	/** Construct a PWReader object for a given password file */
	public PWReader(String pwfName) {
		try {
			pwf = new BufferedReader(new FileReader(pwfName));
		} catch(IOException e) {
			throw new IllegalArgumentException("Can't open PWReaderfile " +
				pwfName + "(" + e.getMessage() + ")");
		}
	}

	public PWReader(InputStreamReader inputStreamReader) {
		pwf = new BufferedReader(inputStreamReader);
	}
}
