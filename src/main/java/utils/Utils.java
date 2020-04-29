package utils;

import java.util.Scanner;

public class Utils {
	
	private final static Scanner SCANNER = new Scanner(System.in);
	
	
	private Utils() {}
	
	
	public static String getInput() {
		return SCANNER.nextLine();
	}
	
	public static Integer getInt() {
		return Integer.valueOf(getInput());
	}
	
	public static Double getDouble() {
		return Double.valueOf(getInput());
	}
}
