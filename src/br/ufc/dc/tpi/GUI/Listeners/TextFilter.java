package br.ufc.dc.tpi.GUI.Listeners;
import javax.swing.text.*;

public class TextFilter extends DocumentFilter{
    public void insereString(FilterBypass fb, int offset, String text, AttributeSet attr)
    throws BadLocationException{
        if (text == null) return;

        if (text.matches("[a-zA-ZÀ-ÿ ]+")) {
            super.insertString(fb, offset, text, attr);
        }
    }

    public void replace(FilterBypass fb, int offset, int tam, String text, AttributeSet attrs)
            throws BadLocationException {

        if (text == null) return;

        if (text.isEmpty() || text.matches("[a-zA-ZÀ-ÿ ]+")) {
            super.replace(fb, offset, tam, text, attrs);
        }
    }
    
}
