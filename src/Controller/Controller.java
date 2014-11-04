package Controller;

import org.tempuri.CalculatorSoap;

import view.Gui;
import model.CalculatorWorker;
/**
 * recieve value and operation from Gui and tell Worker to send request
 * @author Termchai Sadsaengchan 5510546042
 *
 */
public class Controller {
	CalculatorSoap cal;
	Gui gui;
	public Controller(CalculatorSoap cal, Gui gui) {
		this.gui = gui;
		this.cal = cal;
	}
	public void calculate(String[] problem) throws Exception
	{
		CalculatorWorker cw = new CalculatorWorker(cal,gui);
		cw.set(problem);
		cw.execute();
	}
}
