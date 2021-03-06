package ued.view;

import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class HelpAbout {
	JFrame f;
	HelpAbout() {
		f = new JFrame("About UED");
		TextArea tf  = new TextArea(10,60);
		tf.setText("\t\tAbout UED\n" +
			"\n" +
			"Ued (Unix Editor) (c) by Ian Darwin\n" +
			"http://www.darwinsys.com/freeware\n");
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				setVisible(false);
				HelpAbout.this.f.dispose();
			}
		});
		f.add(tf);
		f.pack();
	}
	public void setVisible(boolean b) {
		f.setVisible(b);
	}
}
