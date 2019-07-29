package arccos_SEP;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ArcCos {

	private JFrame frame;
	private JTextField textField_input;
	private JTextField textField_radian;
	private JTextField textField_degree;
	private JLabel lblAngleInRadians,lblAngleInDegrees;
	public static double pi_function() {
		double pi=0;
		double s=1;
		int n=10000;
		for(int i=1;i<n;i=i+2) {
			pi+=s/i;
			s=-s;
		}
		pi=pi*4;
		return pi;
	}
	public static double squareRoot(double number) {
		double temp;

		double sqrt = number / 2;

		do {
			temp = sqrt;
			sqrt = (temp + (number / temp)) / 2;
		} while ((temp - sqrt) != 0);

		return sqrt;
    }
	public static double power(double x,int n) {
		double result=0;
		if(n==0) {
			result=1;
		}
		else if(n%2==0) {
			result=power(x,n/2)*power(x,n/2);
		}
		else {
			result=x*power(x,n/2)*power(x,n/2);
		}
		return result;
	}
	public double calcX1(double x) {
		double result=0;
		double a1=power(x, 2);
		double a2=1-a1;
		double a3=squareRoot(a2); 
		double a4=1+x;
		result=a3/a4;
		return result;
	}
	public double calcX2(double x) {
		double result=0;
		double a1=power(x, 2);
		double a2=1-a1;
		double a3=squareRoot(a2);
		double a4=1+x;
		result=x/(1+a3);
		return result;
	}
	public double acos(double x) {
		double acos=0;
		if(x==1.0) {
			acos=0;
		}
		else if(x==-1.0) {
			acos=pi_function();
		}
		else if(x==0.0) {
			acos=(pi_function())/2;
		}
		else if(x>0&&x<1) {
			int i=1,n = 1,sign=1;
			int k=10;
			double sum=0.0;
			double res=calcX1(x);
			for(i=0;i<=k;i++) {
				sum=sum+sign*(power(res, n)/n);
				n=n+2;
				sign=-sign;
			}
			acos=2*sum;
		}
		else {
			int i=1,n = 1,sign=1;
			int k=10;
			double sum=0.0;
			double res=calcX2(x);
			for(i=0;i<=k;i++) {
				sum=sum+sign*(power(res, n)/n);
				n=n+2;
				sign=-sign;
			}
			acos=((pi_function())/2)-(2*sum);
	}
		return acos;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArcCos window = new ArcCos();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ArcCos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 356, 383);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		textField_input = new JTextField();
		textField_input.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_input.setBounds(147, 60, 158, 32);
		frame.getContentPane().add(textField_input);
		textField_input.setColumns(10);
		
		JLabel lblArccos = new JLabel("arccos(x):x=");
		lblArccos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblArccos.setBounds(46, 61, 122, 29);
		frame.getContentPane().add(lblArccos);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				double input,result,radian,degree,deg;
					ArcCos A=new ArcCos();
					String s;
					 s=textField_input.getText();
					if(s.isEmpty()) {
						JOptionPane.showMessageDialog(frame, "No input passed. Please enter a value to start computation.");
					}
					else if(!(isNumeric(s))) {
						JOptionPane.showMessageDialog(frame, "Input not a number. Please enter valid input in the range of -1.0 and 1.0");
					}
					else if(Double.parseDouble(s)<-1||Double.parseDouble(s)>1) {
						JOptionPane.showMessageDialog(frame, "Invalid input. Please enter number in range of -1.0 and 1.0");
					}
					else {
						input=Double.parseDouble(s);
						result=A.acos(input);
						DecimalFormat df=new DecimalFormat("0.0000000000");
						String res=df.format(result);
						radian=Double.parseDouble(res);
						deg=radian*180/pi_function();
						String res1=df.format(deg);
						degree=Double.parseDouble(res1);
						textField_radian.setText(Double.toString(radian));
						textField_degree.setText(Double.toString(degree));
					}
				
			}
		});
		btnCalculate.setBounds(46, 112, 125, 38);
		frame.getContentPane().add(btnCalculate);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_input.setText(null);
				textField_radian.setText(null);
				textField_degree.setText(null);
			}
		});
		btnReset.setBounds(178, 112, 125, 38);
		frame.getContentPane().add(btnReset);
		
		textField_radian = new JTextField();
		textField_radian.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_radian.setBounds(46, 195, 259, 33);
		frame.getContentPane().add(textField_radian);
		textField_radian.setColumns(10);
		
		lblAngleInRadians = new JLabel("Angle in Radians:");
		lblAngleInRadians.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAngleInRadians.setBounds(46, 170, 143, 19);
		frame.getContentPane().add(lblAngleInRadians);
		
		lblAngleInDegrees = new JLabel("Angle in Degrees:");
		lblAngleInDegrees.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAngleInDegrees.setBounds(46, 230, 143, 29);
		frame.getContentPane().add(lblAngleInDegrees);
		
		textField_degree = new JTextField();
		textField_degree.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_degree.setBounds(46, 256, 259, 32);
		frame.getContentPane().add(textField_degree);
		textField_degree.setColumns(10);
	}
	
	public static boolean isNumeric(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
}
