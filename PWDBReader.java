import java.io.*;
import java.util.*;

public class PWDBReader extends PWReader {

	/** An un-named Static Code Block is performed as part of 
	 * per-class initialization, e.g., when the class is first loaded.
	 */
	static {
		System.loadLibrary("mypw");
	}

	public native PW getpwent();

	public native PW getpwnam(String name);

	public native PW getpwuid(int u);

	// CONSTRUCTORS
	/** Construct a PWDBReader object for the standard password file */
	public PWDBReader() {
		super();
	}
}
