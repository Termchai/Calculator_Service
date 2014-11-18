package ku.calws.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import ku.calws.model.CalculatorWorker;
import ku.calws.view.Gui;

import org.tempuri.CalculatorSoap;

import com.sun.prism.paint.Stop;
/**
 * recieve value and operation from Gui and tell Worker to send request
 * @author Termchai Sadsaengchan 5510546042
 *
 */
public class Controller {
	CalculatorSoap cal;
	Gui gui;
	Timer timer;
	CalculatorWorker cw;
	public Controller(CalculatorSoap cal, Gui gui) {
		this.gui = gui;
		this.cal = cal;
	}
	public void calculate(String[] problem) throws Exception
	{

		timer = new Timer(4000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				timer.stop();
				cw.cancel(true);
				gui.setStatus("Idle");
				JOptionPane.showMessageDialog(null, "Connection False!!");
			}
		});
		gui.setStatus("Calculating");

		cw = new CalculatorWorker(cal,gui,timer);
		cw.set(problem);
		cw.execute();

		timer.start();

	}
}
