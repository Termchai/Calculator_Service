package ku.calws.view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ku.calws.controller.Controller;

import org.tempuri.CalculatorSoap;

/**
 * Gui extends JFrame and add all Component
 * implement CalculatorActionListener and KeyAdapterInteger on textfield and button
 * @author Termchai Sadsaengchan 5510546042
 *
 */
public class Gui extends JFrame {

	final static public String OPERATION_PLUS = "+";
	final static public String OPERATION_MINUS = "-";
	final static public String OPERATION_MULTI = "x";
	final static public String OPERATION_DIVIDE = "/";
	
	private Controller controller;

	/* a and b for calculate 
	 * ex. a + b, a - b */
	private JTextField field1;
	private JTextField field2;
	
	/* result after calculate */
	private JTextField resultTextField;
	
	/* Panel on JFrame */
	private JPanel westPanel;
	private JPanel cenPanel;
	private JPanel eastPanel;
	
	/* ComboBox for choose Operation ex. + - x / */
	private JComboBox<String> operCombo;
	/* show string " = " */
	private JLabel equalLabel;
	private JLabel status;
	/* button for calculate */
	private JButton calculate;
	
	/**
	 * init Component, Size, Location
	 * @param cal receive Calculator from main
	 */
	public Gui(CalculatorSoap cal)
	{
		super("Calculator Service");
		this.controller = new Controller(cal,this);
		setLayout(new FlowLayout());
		initComponent();
		initSize();
		setLocation(200,100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void initComponent() {
		/* Init West Panel component */
		westPanel = new JPanel();
		field1 = new JTextField();
		field1.addKeyListener(new KeyAdapterInteger());
		operCombo = new JComboBox<String>(new String[]{OPERATION_PLUS,OPERATION_MINUS,OPERATION_MULTI,OPERATION_DIVIDE});
		
		/* Init Center Panel component */
		cenPanel = new JPanel();
		field2 = new JTextField();
		field2.addKeyListener(new KeyAdapterInteger());
		
		/* Init East Panel component */
		status = new JLabel("Idle");
		eastPanel = new JPanel();
		resultTextField = new JTextField();
		resultTextField.setForeground(Color.RED);
		resultTextField.setEditable(false);
		equalLabel = new JLabel("=");
		calculate = new JButton("Calculate");
		calculate.addActionListener(new CalculatorActionListener(this,controller));
		
		/* Add component to West Panel */
		westPanel.add(field1);
		westPanel.add(operCombo);
		
		/* Add component to West Panel */
		cenPanel.add(field2);
		
		/* Add component to West Panel */
		eastPanel.add(equalLabel);
		eastPanel.add(resultTextField);
		eastPanel.add(calculate);
		eastPanel.add(status);
		
		/* add panel to JFrame */
		add(westPanel);
		add(cenPanel);
		add(eastPanel);

	}
	
	/**
	 * init all component size
	 */
	private void initSize()
	{
		this.setPreferredSize(new Dimension(900, 90));
		field1.setPreferredSize(new Dimension(140, 30));
		field2.setPreferredSize(new Dimension(140, 30));
		resultTextField.setPreferredSize(new Dimension(180, 30));
		operCombo.setPreferredSize(new Dimension(50,30));
		equalLabel.setPreferredSize(new Dimension(50,30));
		calculate.setPreferredSize(new Dimension(120,30));
		status.setPreferredSize(new Dimension(70, 30));
	}
	
	/**
	 * Show Gui
	 */
	public void run()
	{
		pack();
		setVisible(true);
	}
	
	/**
	 * get value from textField(value) and combobox(operation)
	 * @return
	 */
	public String[] getProblem()
	{
		return new String[] {field1.getText(), operCombo.getSelectedItem().toString(), field2.getText()};
	}
	
	/**
	 * set value to ResultTextField
	 * @param result
	 */
	public void setResult(String result)
	{
		resultTextField.setText(result);
		setStatus("Idle");
	}
	
	
	public void setField1(String text)
	{
		field1.setText(text);
	}
	
	public void setField2(String text)
	{
		field2.setText(text);
	}
	
	public void setStatus(String text)
	{
		status.setText(text);
	}
}
