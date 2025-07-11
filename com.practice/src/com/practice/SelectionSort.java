package com.practice;

import java.util.Scanner;

public class SelectionSort {

	public static void main(String[] args) {

//In selection sort we pick first and compare it with the smallest and for that we find minimum of remaining numbers
		
		int[] a= new int[5];
		int min=0;
		int temp=0;
		
//User Input
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the array one by one");
		for(int i=0;i<a.length;i++)
		{
			a[i]=scan.nextInt();
		}
		
//Printing unsorted array
		System.out.println("Array Before sorting");	
		for(int i=0;i<=a.length-1;i++) 
		{
		System.out.println(a[i]+" ");
		}
		
//Sorting logic
		for(int i=0;i<a.length;i++)
		{
			min=i;
			for(int j=i+1;j<a.length;j++)
			{
				if(a[j]<a[min])
				{
					min=j;
				}
				
			}
			
			temp=a[i];
			a[i]=a[min];
			a[min]=temp;
			
		}
		
//Printing Sorted Array
		System.out.println("Array After sorting");
		for(int i=0;i<=a.length-1;i++) 
		{
		System.out.println(a[i]+" ");
		}
	}

}
