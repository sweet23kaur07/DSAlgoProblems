package com.hacker.rank.oop.volume;

import java.io.IOException;
import java.security.Permission;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		DoNotTerminate.forbidExit();
		try {
			Calculate cal = new Calculate();
			int T = cal.get_int_val();
			while (T--> 0) {
				System.out.println("Value of While loop T is : " + T);
				double volume = 0.0;
				int ch = cal.get_int_val();
				if (ch == 1) {
					System.out.println("Character is : 1" );
					System.out.println("Need to enter one side only");
					int a = cal.get_int_val();
					volume = Calculate.do_calc().get_volume(a);
				} else if (ch == 2) {
					System.out.println("Character is : 2" );
					System.out.println("Need to enter length, breadth and height");
					int l = cal.get_int_val();
					int b = cal.get_int_val();
					int h = cal.get_int_val();
					volume = Calculate.do_calc().get_volume(l, b, h);

				} else if (ch == 3) {
					System.out.println("Character is : 3" );
					System.out.println("Need to enter radius only'");
					double r = cal.get_double_val();
					volume = Calculate.do_calc().get_volume(r);

				} else if (ch == 4) {
					System.out.println("Character is : 4" );
					System.out.println("Need to enter radius and height");
					double r = cal.get_double_val();
					double h = cal.get_double_val();
					volume = Calculate.do_calc().get_volume(r, h);

				}
				cal.output.display(volume);
			}

		} catch (NumberFormatException e) {
			System.out.print(e);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DoNotTerminate.ExitTrappedException e) {
			System.out.println("Unsuccessful Termination!!");
		}


	} //end of main
} //end of Solution

/**
 *This class prevents the user form using System.exit(0)
 * from terminating the program abnormally.
 *
 */
class DoNotTerminate {

	public static class ExitTrappedException extends SecurityException {}

	public static void forbidExit() {
		final SecurityManager securityManager = new SecurityManager() {
			@Override
			public void checkPermission(Permission permission) {
				if (permission.getName().contains("exitVM")) {
					throw new ExitTrappedException();
				}
			}
		};
		System.setSecurityManager(securityManager);
	}
} //end of Do_Not_Terminate


class Calculate{
	Scanner scan = new Scanner(System.in);
	private static final double PI = 3.14159265;
	Output output = new Output();

	class Output{
		public void display(double volume){
			System.out.printf("%.3f",volume);
			System.out.println();
		}
	}

	public int get_int_val() throws IOException{
		int input = scan.nextInt();
		if(input <= 0){
			throw new NumberFormatException("All the values must be positive");
		}
		return input;
	}

	public double get_double_val() throws IOException{
		double input = scan.nextDouble();
		if(input <= 0){
			throw new NumberFormatException("All the values must be positive");
		}
		return input;
	}

	public static Calculate do_calc(){
		return new Calculate();
	}

	public double get_volume(int a){
		return a*a*a;
	}

	public double get_volume(int l, int b, int h){
		return l * b * h;
	}

	public double get_volume(double r){
		return ((2 * PI * r * r * r)/3);
	}

	public double get_volume(double r, double h){
		return PI * r * r * h;
	}
}