package ued.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class UedView extends JPanel implements Observer {

    Vector users = null;

	/** Construct a UedView */
    public UedView(Vector vu) {

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
