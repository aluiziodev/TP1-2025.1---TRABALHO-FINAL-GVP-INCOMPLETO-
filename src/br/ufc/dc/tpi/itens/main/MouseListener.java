
package br.ufc.dc.tpi.itens.main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.JButton;

public class MouseListener extends MouseAdapter {
	public void mouseEntered(MouseEvent e) {
		 if (e.getSource() instanceof JButton) {
	            JButton button = (JButton) e.getSource();
	            Dimension original = button.getSize();
	            button.setSize(original.width+10, original.height+10);
	            button.setBackground(Color.decode("#418e8e"));
	            button.setCursor(new Cursor(Cursor.HAND_CURSOR));
	            
	         
	        }
	}
	
	public void mouseExited(MouseEvent e) {
       if (e.getSource() instanceof JButton) {
           JButton button = (JButton) e.getSource();
           Dimension original = button.getSize();
           button.setSize(original.width-10, original.height-10);
           button.setBackground(Color.decode("#536c8d"));
           button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
           
       }
   }
}
