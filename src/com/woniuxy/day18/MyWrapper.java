package com.woniuxy.day18_20220518;

public class MyWrapper<T> {
	private T value;

	public static void main(String[] args) {
		MyWrapper<String> myWrapper = new MyWrapper<>();
		myWrapper.setValue("Tom");
		String o = myWrapper.getValue();

		MyWrapper<Integer> myWrapper2 = new MyWrapper<>();
		myWrapper2.setValue(1);
		myWrapper2.getValue();

	}

	public T getValue() {
		return value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}

}
