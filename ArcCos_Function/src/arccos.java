import java.text.DecimalFormat;
import java.util.Scanner;

public class arccos {
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

	public static void main(String[] args) {
		arccos A=new arccos();
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter the value of x:");
		double x=scanner.nextDouble();
		double res=A.acos(x);
		DecimalFormat df=new DecimalFormat("0.0000000000");
		String formatted=df.format(res);
		double rad=Double.parseDouble(formatted);
		System.out.println("Answer in radian:"+rad);
		double deg=rad*180/_pi;
//		System.out.println("Answer in degrees:"+Math.toDegrees(rad));
		System.out.println("Degrees:"+deg);

	}

}
