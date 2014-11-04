package view;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * for not allow to input non-integer in textfield
 * @author Termchai Sadsaengchan 5510546042
 *
 */
public class KeyAdapterInteger extends KeyAdapter {

	@Override
	public void keyTyped(KeyEvent e) {
	      char c = e.getKeyChar();
	      if (!((c >= '0') && (c <= '9') ||
	         (c == KeyEvent.VK_BACK_SPACE) ||
	         (c == KeyEvent.VK_DELETE))) {
	        e.consume();
	      }
	}
}
