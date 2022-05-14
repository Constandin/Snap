package com.woniuxy.day11;


    class Parent{
        static {
            System.out.println("Parent静态代码块");
        }

        {
            System.out.println("Parent代码块");
        }

        public Parent() {
            System.out.println("Parent");
        }
    }

    class Son extends Parent{

        static {
            System.out.println("Son静态代码块");
        }

        {
            System.out.println("Son代码块");
        }

//	public static int num = 10;

//	private static Son son=new Son();

        public Son() {
            System.out.println("Son");
        }
    }

    public class InitialDemo {
        public static void main(String[] args) {
            new Son();
            new Son();
//		System.out.println(Son.num);
        }
    }

