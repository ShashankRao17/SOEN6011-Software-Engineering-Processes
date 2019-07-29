package arccos;

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
  private JTextField textField1;
  private JTextField textFieldRadian;
  private JTextField textFieldDegree;
  private JLabel lblAngleInRadians;
  private JLabel lblAngleInDegrees;
  /**Function to compute the value of PI.*/
  public static double piFunction() {
    double pi = 0;
    double s = 1;
    int n = 10000;
    for (int i = 1;i < n;i = i + 2) {
      pi += s / i;
      s = -s;
    }
    DecimalFormat df=new DecimalFormat("0.0000000000");
    String res=df.format(pi);
    double pi1=Double.parseDouble(res);
    pi1 = pi1 * 4; 
    return pi1;
  }
  /**Function to compute square root of a number passed as argument.*/  
  public static double squareRoot(double number) {
    double temp;
    double sqrt = number / 2;
    do {
      temp = sqrt;
      sqrt = (temp + (number / temp)) / 2;
    } while ((temp - sqrt) != 0);

    return sqrt;
  }
  /**Function to emulate Math.pow function.*/
  public static double power(double x,int n) {
    double result = 0;
    if (n == 0) {
      result = 1; 
    } else if (n % 2 == 0) {
      result = power(x,n / 2) * power(x,n / 2);
    } else {
      result = x * power(x,n / 2) * power(x,n / 2);
    }
    return result;
  }
  /**Function to compute the value of tanx for values greater than 0 and less than 1.*/
  public double calcX1(double x) {
    double result = 0;
    double a1 = power(x, 2);
    double a2 = 1 - a1;
    double a3 = squareRoot(a2); 
    double a4 = 1 + x;
    result = a3 / a4;
    return result;
  }
  /**Function to compute the value of tanx for values less than 0 and greater than -1.*/
  public double calcX2(double x) {
    double result = 0;
    double a1 = power(x, 2);
    double a2 = 1 - a1;
    double a3 = squareRoot(a2);
    double a4 = 1 + x;
    result = x / (1 + a3);
    return result;
  }
  /**Function to calculate inverse of Cosine for a number passed as argument.*/
  public double acos(double x) {
    double acos = 0;
    if (x == 1.0) {
      acos = 0;
    } else if (x == -1.0) {
      acos = piFunction();
    } else if (x == 0.0) {
      acos = (piFunction()) / 2;
    } else if (x > 0 && x < 1) {
      int n = 1;
      int sign = 1;
      int k = 10;
      double sum = 0.0;
      double res = calcX1(x);
      for (int i = 0;i <= k;i++) {
        sum = sum + sign * (power(res, n) / n);
        n = n + 2;
        sign = -sign;
      }
      acos = 2 * sum;
    } else {
      int n = 1;
      int sign = 1;
      int k = 10;
      double sum = 0.0;
      double res = calcX2(x);
      for (int i = 0;i <= k;i++) {
        sum = sum + sign * (power(res, n) / n);
        n = n + 2;
        sign = -sign;
      }
      acos = ((piFunction()) / 2) - (2 * sum);
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

    textField1 = new JTextField();
    textField1.setFont(new Font("Tahoma", Font.PLAIN, 20));
    textField1.setBounds(147, 60, 158, 32);
    frame.getContentPane().add(textField1);
    textField1.setColumns(10);
    
    JLabel lblArccos = new JLabel("arccos(x):x=");
    lblArccos.setFont(new Font("Tahoma", Font.BOLD, 15));
    lblArccos.setBounds(46, 61, 122, 29);
    frame.getContentPane().add(lblArccos);

    JButton btnCalculate = new JButton("Calculate");
    btnCalculate.setFont(new Font("Tahoma", Font.BOLD, 15));
    btnCalculate.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            double input;
            double result;
            double radian;
            double degree;
            double deg;
            String s;
            ArcCos a = new ArcCos();            
            s = textField1.getText();
            if (s.isEmpty()) {
              JOptionPane.showMessageDialog(frame, "Input cannot be blank. Please enter a value");
            } else if (!(isNumeric(s))) {
                JOptionPane.showMessageDialog(frame, "Invalid input. Please enter number in the range of -1.0 & 1.0");
            } else if (Double.parseDouble(s) < -1 || Double.parseDouble(s) > 1) {
              JOptionPane.showMessageDialog(frame, "Invalid input. Please enter number in range of -1.0 & 1.0");
            } else {
              input = Double.parseDouble(s);
              result = a.acos(input);
              DecimalFormat df = new DecimalFormat("0.0000000000");
              String res = df.format(result);
              radian = Double.parseDouble(res);
              deg = radian * 180 / piFunction();
              String res1 = df.format(deg);
              degree = Double.parseDouble(res1);
              textFieldRadian.setText(Double.toString(radian));
              textFieldDegree.setText(Double.toString(degree));
            }
          }
        });
    btnCalculate.setBounds(46, 112, 125, 38);
    frame.getContentPane().add(btnCalculate);

    JButton btnReset = new JButton("Reset");
    btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
    btnReset.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
            textField1.setText(null);
            textFieldRadian.setText(null);
            textFieldDegree.setText(null);
        }
    });
    btnReset.setBounds(178, 112, 125, 38);
    frame.getContentPane().add(btnReset);

    textFieldRadian = new JTextField();
    textFieldRadian.setFont(new Font("Tahoma", Font.PLAIN, 20));
    textFieldRadian.setBounds(46, 195, 259, 33);
    frame.getContentPane().add(textFieldRadian);
    textFieldRadian.setColumns(10);

    lblAngleInRadians = new JLabel("Angle in Radians:");
    lblAngleInRadians.setFont(new Font("Tahoma", Font.BOLD, 15));
    lblAngleInRadians.setBounds(46, 170, 143, 19);
    frame.getContentPane().add(lblAngleInRadians);

    lblAngleInDegrees = new JLabel("Angle in Degrees:");
    lblAngleInDegrees.setFont(new Font("Tahoma", Font.BOLD, 15));
    lblAngleInDegrees.setBounds(46, 230, 143, 29);
    frame.getContentPane().add(lblAngleInDegrees);

    textFieldDegree = new JTextField();
    textFieldDegree.setFont(new Font("Tahoma", Font.PLAIN, 20));
    textFieldDegree.setBounds(46, 256, 259, 32);
    frame.getContentPane().add(textFieldDegree);
    textFieldDegree.setColumns(10);
  }
  /**Function to check if input is a number.*/	
  public static boolean isNumeric(String str) { 
    try {  
      Double.parseDouble(str);  
      return true;
    } catch (NumberFormatException e) {  
      return false;  
    }  
  }
}
