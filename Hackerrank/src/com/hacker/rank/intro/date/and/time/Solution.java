package com.hacker.rank.intro.date.and.time;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String month = in.next();
        String day = in.next();
        String year = in.next();
        
        GregorianCalendar cal = new GregorianCalendar();
        cal.set(Calendar.MONTH, Integer.parseInt(month));
        cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));
        cal.set(Calendar.YEAR, Integer.parseInt(year));
        
        System.out.println((cal.getDisplayName(Calendar.DAY_OF_WEEK, 
        		Calendar.LONG, Locale.getDefault())).toUpperCase());
    }
}
