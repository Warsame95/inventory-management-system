package utils;

import java.util.Scanner;

public class Utils {
	
	private final static Scanner SCANNER = new Scanner(System.in);
	
	
	public Utils() {}
	
	
	public String getInput() {
		return SCANNER.nextLine();
	}
	
	public Integer getInt() {
		return Integer.valueOf(getInput());
	}
	
	public Double getDouble() {
		return Double.valueOf(getInput());
	}
}
