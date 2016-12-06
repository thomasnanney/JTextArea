package jText;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.Element;
import javax.swing.text.StyledDocument;
import javax.swing.text.Utilities;

public class JTextStatusView {
	private JTextField status;
	
	public JTextStatusView(final JTextPane textPane, Container contentPane){
		textPane.addCaretListener(new CaretListener() {
            // Each time the caret is moved, it will trigger the listener and its method caretUpdate.
            // It will then pass the event to the update method including the source of the event (which is our textarea control)
            public void caretUpdate(CaretEvent e) {
                JTextPane editArea = (JTextPane)e.getSource();

                // Lets start with some default values for the line and column.
                int linenum = 1;
                int columnnum = 1;

                // Try to catch exceptions
                try {
                    // First we find the position of the caret. This is the number of where the caret is in relation to the start of the JTextPane                    
                	// in the upper left corner. We use this position to find offset values (eg what line we are on for the given position as well as
                    // what position that line starts on.
                    int caretpos = editArea.getCaretPosition();
                    linenum = (caretpos == 0) ? 1 : 0;
                    for (int offset = caretpos; offset > 0;) {
                        offset = Utilities.getRowStart(textPane, offset) - 1;
                        linenum++;
                    }
                    StyledDocument doc = textPane.getStyledDocument();
                    Element line = doc.getParagraphElement(caretpos);
                    columnnum = caretpos - line.getStartOffset() + 1;
                }
                catch(Exception ex) { }

                // Once we know the position of the line and the column, pass it to a helper function for updating the status bar.
                updateStatus(linenum, columnnum);
            }
        });
		// Add the fields to the layout, the editor in the middle and the status at the bottom.

        status = new JTextField();
        contentPane.add(status, BorderLayout.SOUTH);

        // Give the status update value
        updateStatus(1,1);
    }

    // This helper function updates the status bar with the line number and column number.
    private void updateStatus(int linenumber, int columnnumber) {
        status.setText("Line: " + linenumber + " Column: " + columnnumber);
    }

}
