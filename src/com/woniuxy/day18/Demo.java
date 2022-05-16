package com.woniuxy.day18;

public class Demo<T> {
    private T value;

    public static <T> T m1(T t){
        System.out.println(t);
        return t;
    }

    public static <T> T m2(Demo<T> t){
        System.out.println(t);
        return t.getValue();
    }

    public static void main(String[] args) {
        m1(1);
        m1("Tommmy");
        m2(new Demo<String>());
        m1("asd");
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
