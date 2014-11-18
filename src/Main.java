


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import ku.calws.view.Gui;

import org.tempuri.Calculator;
import org.tempuri.CalculatorSoap;

/**
 * Create CalculatorSoap and put into Gui
 * @author Termchai Sadsaengchan 5510546042
 *
 */
public class Main {
	private static Timer timer;
	private static CalculatorSoap calculatorSoap;
	private static boolean isDialogShow = false;
	private static Calculator calculator;

	
	public static void main(String[]args)
	{
		try
		{
			
			timer = new Timer(3000, new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {

					if(calculatorSoap != null || isDialogShow)
					{	
						return;
					}
					timer.stop();
//					JOptionPane.showMessageDialog(null, "Can't connect to Calculator Webservice Server");
					int response = JOptionPane.showConfirmDialog(null, "Can't connect to Calculator Webservice Server, Want to retry?", "Confirm",
					        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					 if (response == JOptionPane.YES_OPTION) {
						 isDialogShow = false;
					      timer.start();
							calculatorSoap = calculator.getCalculatorSoap();
							Gui gui = new Gui(calculatorSoap);
							gui.run();
					    }
					else
						System.exit(0);
				}
			});
			timer.start();
			
			calculator = new Calculator();
			calculatorSoap = calculator.getCalculatorSoap();
			Gui gui = new Gui(calculatorSoap);
			gui.run();

		} catch (Exception ex )
		{	
			while(true)
			{
				try 
				{
					isDialogShow = true;
					timer.stop();
		//			JOptionPane.showMessageDialog(null, "Can't connect to Calculator Webservice Server");
					int response = JOptionPane.showConfirmDialog(null, "Can't connect to Calculator Webservice Server, Want to retry?", "Retry",
					        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					 if (response == JOptionPane.YES_OPTION) {
					      timer.start();
							calculator = new Calculator();
							calculatorSoap = calculator.getCalculatorSoap();
							Gui gui = new Gui(calculatorSoap);
							gui.run();
					    }
					else
						System.exit(0);
					return ;
				} catch(Exception ex2)
				{
					timer.start();
					isDialogShow = false;
					continue;
					
				}
			}
		}

	}
	
}
