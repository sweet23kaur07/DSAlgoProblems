import java.text.DecimalFormat;
import java.util.Scanner;

public class HalfAreaPoint {
	public double findHalfAreaPoint(Curve curve, double p) {
		//say H is half of P
		double h = p/2;
		double areOfP = curve.areaUnderCurve(p);
		double areaExpectedOfH = areOfP/2;
		
		areaExpectedOfH =Double.parseDouble(new DecimalFormat("##.####").format(areaExpectedOfH));
		System.out.println("are : " + areaExpectedOfH);
		while(true){
			System.out.println(h);
			double areaOfH = curve.areaUnderCurve(h);
			areaOfH =Double.parseDouble(new DecimalFormat("##.####").format(areaOfH));
			System.out.println("are actual : " + areaOfH);
			if(areaOfH == areaExpectedOfH){
				break;
			}
			else if(areaOfH < areaExpectedOfH){
				h= (h+p)/2;
				System.out.println("less");
			}else if(areaOfH > areaExpectedOfH){
				p=h;
				h= (0+p)/2;
				System.out.println("greater");
			}
		}
		
		return h;
	}
	
	

    // DO NOT MODIFY CODE BELOW THIS LINE
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] tokens = line.split(" ");
			Curve c = null;
			switch (tokens[0]) {
			case "LINE":
				c = new Line(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
				break;
			case "EXP":
				c = new Exp();
				break;
			case "POWER":
				c = new Power(Double.parseDouble(tokens[1]));
				break;
			}

			if (c == null) {
				break;
			}
			HalfAreaPoint t=new HalfAreaPoint();
			double p = 10.0d;
			double h = t.findHalfAreaPoint(c, p);
			System.out.println(Math.round(h*1000d));
		}

		scanner.close();
	}
}

	interface Curve {
		double areaUnderCurve(double x);
	}

	class Line implements Curve {
		private double m;
		private double c;

		public Line(double m, double c) {
			this.m = m;
			this.c = c;
		}

		@Override
		public double areaUnderCurve(double x) {
			return m * x + c;
		}
	}

	class Exp implements Curve {
		@Override
		public double areaUnderCurve(double x) {
			return Math.exp(x);
		}
	}

	class Power implements Curve {
		private double power;

		public Power(double power) {
			this.power = power;
		}

		@Override
		public double areaUnderCurve(double x) {
			return Math.pow(x, power);
		}
	}
