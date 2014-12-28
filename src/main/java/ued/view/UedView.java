package ued.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import ued.unix.PW;

public class UedView extends JPanel implements Observer {

	List<PW> users = null;

	/** Construct a UedView */
    public UedView(List<PW> vu) {

		users = vu;
		setBorder(BorderFactory.createTitledBorder("User Editor View (read-only)"));

		UedTableModel dtm = new UedTableModel(users);
		JTable table = new JTable(dtm);
        table.setCellEditor(new DefaultCellEditor(new JTextField())); 

        // Construct a scroll pane and add the JTable into it. 
		JScrollPane scrollPane = new JScrollPane(table);

		// Add the scroll pane to this panel.
		setLayout(new GridLayout(1, 0)); 
        add(scrollPane);

    }

	public Dimension getPreferredSize() {
		return new Dimension(600, 300);
	}

	/** update is called by the Model when its data changes */
	public void update(Observable o, Object arg) {
	}
}
