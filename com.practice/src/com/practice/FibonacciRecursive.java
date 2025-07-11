package com.practice;

import java.util.Scanner;

public class FibonacciRecursive {

	static int a=0,b=1,c=0;
	
	public void fibo(int i) 
	{
		if(i>2) {
		c=a+b;
		System.out.print(c+",");
		a=b;
		b=c;		
		fibo(i-1);
		}
	}
	public static void main(String[] args) {
		
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the number u want in the series");
        int count=scan.nextInt();
        System.out.print(a+",");
        System.out.print(b+",");
        FibonacciRecursive fab=new FibonacciRecursive();
		fab.fibo(count);
	}

}
