import java.text.DecimalFormat;
import java.util.Scanner;

public class arccos {
	public double calcX1(double x) {
		double result=0;
		double a1=Math.pow(x, 2);//x^2
		double a2=1-a1;//1-x^2
		double a3=Math.sqrt(a2);//sqrt of 1-x^2
		double a4=1+x;//1+x
		result=a3/a4;
		return result;
	}
	public double calcX2(double x) {
		double result=0;
		double a1=Math.pow(x, 2);//x^2
		double a2=1-a1;//1-x^2
		double a3=Math.sqrt(a2);//sqrt of 1-x^2
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
			acos=Math.PI;
		}
		else if(x==0.0) {
			acos=(Math.PI)/2;
		}
		else if(x>0&&x<1) {
			int i=1,n = 1,sign=1;
			int k=10;
			double sum=0.0;
			double res=calcX1(x);
			for(i=0;i<=k;i++) {
				sum=sum+sign*(Math.pow(res, n)/n);
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
				sum=sum+sign*(Math.pow(res, n)/n);
				n=n+2;
				sign=-sign;
			}
//			double tan=res-((Math.pow(res, 3)/3))+((Math.pow(res, 5)/5))-((Math.pow(res, 7)/7))+((Math.pow(res, 9)/9))-((Math.pow(res, 11)/11))
//					+((Math.pow(res, 13)/13))-((Math.pow(res, 15)/15))+((Math.pow(res, 17)/17))-((Math.pow(res, 19)/19))+((Math.pow(res, 21)/21));
			acos=((Math.PI)/2)-(2*sum);
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
//		double deg=(rad*180)/Math.PI;
//		String formatted1=df.format(deg);
//		double degree=Double.parseDouble(formatted1);
		System.out.println("Answer in radian:"+rad);
		System.out.println("Answer in degrees:"+Math.toDegrees(rad));

	}

}
