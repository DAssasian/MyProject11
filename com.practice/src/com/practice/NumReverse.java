package com.practice;

public class NumReverse {
	public static void main(String[]args)
	{
		int number=34566, rem=0, rev=0;
		
		while(number!=0)
		{	
			rem = number%10;
			rev=rev*10 + rem;
			number = number/10;
		}
		
		System.out.println(rev);
	}

}
