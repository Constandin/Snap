package com.woniuxy.day18_20220518;

public class GenericMethodDemo {
	
	public static <T> T m1() {
		return null;
	}

	public static void main(String[] args) {
		
		m1();
		String s=m1();
		
//		m1("Tom");
	}

}
