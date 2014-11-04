import java.security.cert.PKIXRevocationChecker.Option;

import javax.swing.JOptionPane;
import javax.swing.plaf.OptionPaneUI;

import org.tempuri.Calculator;
import org.tempuri.CalculatorSoap;

import Controller.Controller;
import view.Gui;

/**
 * Create CalculatorSoap and put into Gui
 * @author Termchai Sadsaengchan 5510546042
 *
 */
public class Main {
	
	public static void main(String[]args)
	{
		try
		{
			Calculator calculator = new Calculator();
			CalculatorSoap calculatorSoap = calculator.getCalculatorSoap();
			Gui gui = new Gui(calculatorSoap);
			gui.run();
		} catch (Exception ex )
		{
			JOptionPane.showMessageDialog(null, "Can't connect to Calculator Webservice Server");
			return ;
		}

	}
}
