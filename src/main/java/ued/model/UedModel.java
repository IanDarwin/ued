package ued.model;

import java.util.List;
import java.util.Observable;
import java.util.Vector;

import ued.unix.PW;
import ued.unix.PWFileReader;
import ued.unix.PWReader;

/** UedModel is the list of users and groups. */
public class UedModel extends Observable {
	/** The list of users */
	List<PW> u;
	/** The list of groups */
	List<?> g;

	public UedModel() {
		u = new Vector<PW>();
		PWReader p = new PWFileReader("./passwd.txt");
		PW user;
		while ((user=p.getpwent()) != null)
			u.add(user);
		// same for groups!
		// while ((group=...)) != null)
		//	v.addItem(group);
	}

	public List<PW> getUsers() {
		return u;
	}
}
