package com.hacker.rank.intro.currency.formatter;

import java.util.*;
import java.text.*;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double payment = scanner.nextDouble();
		scanner.close();

		Locale indiaL = new Locale("en", "in");
		
		String us = NumberFormat.getCurrencyInstance(Locale.US).format(payment);
		String india = NumberFormat.getCurrencyInstance(indiaL).format(payment);
		String china = NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
		String france = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment);
//		String us = usSymbol + payment;
//		String india  = indiaSymbol + payment;
//		String china = chinaSymbol + payment;
//		String france = franceSymbol  +payment;
		System.out.println("US: " + us);
		System.out.println("India: " + india);
		System.out.println("China: " + china);
		System.out.println("France: " + france);
	}
}

