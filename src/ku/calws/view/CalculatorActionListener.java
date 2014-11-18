package ku.calws.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ku.calws.controller.Controller;

import org.tempuri.CalculatorSoap;

/**
 * ActionListener of Calculate Button on Gui
 * send value and operation to Controller
 * @author Termchai Sadsaengchan 5510546042
 *
 */
public class CalculatorActionListener implements ActionListener {
	private Gui gui;
	private CalculatorSoap cal;
	Controller cc;
	public CalculatorActionListener(Gui gui, Controller cc) {
		this.gui = gui;
		this.cc = cc;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			cc.calculate(gui.getProblem());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
