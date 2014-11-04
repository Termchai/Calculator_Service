package model;

import javax.swing.SwingWorker;

import org.tempuri.CalculatorSoap;

import view.Gui;
/**
 * for send request to Webservice and return result
 * @author Termchai Sadsaengchan 5510546042
 *
 */
public class CalculatorWorker extends SwingWorker<String, Void> {
	final static public String OPERATION_PLUS = "+";
	final static public String OPERATION_MINUS = "-";
	final static public String OPERATION_MULTI = "x";
	final static public String OPERATION_DIVIDE = "/";
	
	private int a,b;
	private String op;
	private CalculatorSoap cal;
	private Gui gui;
	public CalculatorWorker(CalculatorSoap cal, Gui gui) {
		this.cal = cal;
		this.gui = gui;
	}
	
	/**
	 * set value and operation before sent request
	 * @param problem
	 * @throws Exception
	 */
	public void set(String[] problem) throws Exception
	{
		op = problem[1];
		try
		{
			a = Integer.parseInt(problem[0]);
		} catch (Exception ex)
		{
			a = 0;
			gui.setField1("0");
		}
		try
		{
			b = Integer.parseInt(problem[2]);
		} catch (Exception ex)
		{
			b = 0;
			gui.setField2("0");
		}
	}

	/**
	 * send request
	 */
	@Override
	protected String doInBackground() throws Exception {

		if (op == OPERATION_PLUS)
			return(cal.add(a, b) + "");
		else if (op == OPERATION_MINUS)
			return(cal.subtract(a, b) + "");
		else if (op == OPERATION_MULTI)
			return(cal.multiply(a, b) + "");
		else if (op == OPERATION_DIVIDE)
			try
			{
				return(cal.divide(a, b) + "");
			} catch (Exception ex)
			{
				return("Can't divide by Zero.");
			}
		return null;
	}

	/**
	 * do when reciev response from webservice
	 * set Reuslt to Gui
	 */
	@Override
	protected void done() {
		super.done();
		try {
			gui.setResult(get());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
