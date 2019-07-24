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
	static double _pi=3.1415926536;
	public static double squareRoot(double number) {
		double temp;

		double sr = number / 2;

		do {
			temp = sr;
			sr = (temp + (number / temp)) / 2;
		} while ((temp - sr) != 0);

		return sr;
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
		double a1=power(x, 2);//x^2
		double a2=1-a1;//1-x^2
//		double a3=Math.sqrt(a2);//sqrt of 1-x^2
		double a3=squareRoot(a2);//sqrt of 1-x^2 
		double a4=1+x;//1+x
		result=a3/a4;
		return result;
	}
	public double calcX2(double x) {
		double result=0;
		double a1=power(x, 2);//x^2
		double a2=1-a1;//1-x^2
//		double a3=Math.sqrt(a2);//sqrt of 1-x^2
		double a3=squareRoot(a2);//sqrt of 1-x^2
		double a4=1+x;//1+x
		result=x/(1+a3);
		return result;
	}
	public double acos(double x) {
		double acos=0;
		if(x==1.0) {
			acos=0;
		}
		else if(x==-1.0) {
			acos=_pi;
		}
		else if(x==0.0) {
			acos=(_pi)/2;
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
//			double tan=res-((power(res, 3)/3))+((power(res, 5)/5))-((power(res, 7)/7))+((power(res, 9)/9))-((power(res, 11)/11))
//					+((power(res, 13)/13))-((power(res, 15)/15))+((power(res, 17)/17))-((power(res, 19)/19))+((power(res, 21)/21));
			acos=((_pi)/2)-(2*sum);
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
		
		textField_input = new JTextField();
		textField_input.setBounds(147, 60, 115, 32);
		frame.getContentPane().add(textField_input);
		textField_input.setColumns(10);
		
		JLabel lblArccos = new JLabel("arccos(x):x=");
		lblArccos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblArccos.setBounds(46, 61, 122, 29);
		frame.getContentPane().add(lblArccos);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				double input,result,radian,degree;
					ArcCos A=new ArcCos();
					String s;
					 s=textField_input.getText();
					if(s.isEmpty()) {
						JOptionPane.showMessageDialog(frame, "No input passed. Please enter a value to start computation.");
					}
					else if(!(isNumeric(s))) {
						JOptionPane.showMessageDialog(frame, "Input not a number. Please enter valid input in the range of -1 and 1.");
					}
					else {
						input=Double.parseDouble(s);
						if(input<-1||input>1) {
							JOptionPane.showMessageDialog(frame, "Invalid input. Please enter number in range of -1 and 1.");
						}
						result=A.acos(input);
						DecimalFormat df=new DecimalFormat("0.0000000000");
						String res=df.format(result);
						radian=Double.parseDouble(res);
						degree=radian*180/_pi;
						textField_radian.setText(Double.toString(radian));
						textField_degree.setText(Double.toString(degree));
					}
				
			}
		});
		btnCalculate.setBounds(46, 112, 97, 38);
		frame.getContentPane().add(btnCalculate);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_input.setText(null);
				textField_radian.setText(null);
				textField_degree.setText(null);
			}
		});
		btnReset.setBounds(165, 112, 97, 38);
		frame.getContentPane().add(btnReset);
		
		textField_radian = new JTextField();
		textField_radian.setBounds(46, 181, 169, 33);
		frame.getContentPane().add(textField_radian);
		textField_radian.setColumns(10);
		
		lblAngleInRadians = new JLabel("Angle in Radians:");
		lblAngleInRadians.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAngleInRadians.setBounds(46, 163, 122, 16);
		frame.getContentPane().add(lblAngleInRadians);
		
		lblAngleInDegrees = new JLabel("Angle in Degrees:");
		lblAngleInDegrees.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAngleInDegrees.setBounds(46, 227, 122, 16);
		frame.getContentPane().add(lblAngleInDegrees);
		
		textField_degree = new JTextField();
		textField_degree.setBounds(46, 245, 169, 32);
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
