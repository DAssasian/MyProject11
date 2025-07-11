package com.practice;

import java.util.Scanner;

public class ArmstrongNumber {

	public static void main(String[] args) {
		
		int rem=0,arm=0;int length=0;
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the number you want to check for armstrong");
		int number=scan.nextInt();
		int temp=number;
		
		while(temp!=0)
		{
			temp=temp/10;
			length=length+1;
		}
		
		int numb=number;
		
		while(numb!=0)
		{   int mul=1;
			rem=numb%10;
			for(int i=0;i<length;i++)
			{
				mul=mul*rem;
			}
			arm=arm+mul;
			numb=numb/10;
		}
		if(number==arm) 
		{
			System.out.println("Entered number is armstrong number");
		}
		else
		System.out.println("Entered number is not armstrong number");

	}

}
