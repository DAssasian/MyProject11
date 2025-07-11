package com.practice;

import java.util.Scanner;

public class RevString {

	public static void main(String[] args) {
		
		Scanner scan= new Scanner(System.in);
        
		System.out.println("Enter the string you want to reverse");
		
        String str=scan.nextLine();
		
        String str1="";
		
        for(int i=str.length()-1;i>=0;i--)
		{
			str1=str1+str.charAt(i);
		}
        
        System.out.println("Reversed string is "+str1);
		
	}

}
