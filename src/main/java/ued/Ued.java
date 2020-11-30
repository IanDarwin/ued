package ued;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import ued.model.UedModel;
import ued.view.UedMenuCtl;
import ued.view.UedView;

/** Ued is the simple main program for Ued */
public class Ued {

	/** This main program builds and connects Model, View and Controller */
    public static void main(String[] args) {

		// Construct a Frame to contain the View
		JFrame f = new JFrame("Ued: A Unix User Editor Wannabe");

		// Construct the data model
		UedModel m = new UedModel();

		// Construct the User View
		UedView uv = new UedView(m.getUsers());

		// XXX Construct the Group View
		// GroupView gv = new GroupView(??);

		// XXX Construct the Properties View
		// PropsView gv = new PropsView(??);

		// Build the Menu Controller and install it
		UedMenuCtl mc = new UedMenuCtl(m, f, uv);
		f.setMenuBar(mc);

		m.addObserver(uv);	// tell model about its view

		f.addWindowListener(new WindowAdapter() {
	        public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
	    });

		// The Main Screen is a tabbed panel with several views
		JTabbedPane mainPane = new JTabbedPane();
		f.getContentPane().add(BorderLayout.CENTER, mainPane);
		mainPane.addTab("Users", uv);
		mainPane.addTab("Groups", new JLabel("Not Written Yet", JLabel.CENTER));
		mainPane.addTab("Properties", new JLabel("Not Written Yet", JLabel.CENTER));
		f.pack();
		f.setVisible(true);
		mainPane.setSelectedIndex(mainPane.indexOfTab("Users"));
    }
}
