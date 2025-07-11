package com.practice;

import java.util.Scanner;

public class numbRev {
	
	int rev=0,rem=1;
	
	int reverseNumber(int n) 
	{
		while(n!=0) {
		rem=n%10;
		n=n/10;
		rev=rev*10+rem;
		}
		return rev;   
	}

	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the number to be reversed");
		int number = scan.nextInt();
		numbRev ob=new numbRev();
		int newNumb=ob.reverseNumber(number);
		System.out.println("New reversed number is "+newNumb);
		
	}

}
