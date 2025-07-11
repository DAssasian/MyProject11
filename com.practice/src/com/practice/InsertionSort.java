package com.practice;

public class InsertionSort {

	public static void main(String[] args) {

			int[] a= {34,56,23,90,12,76};
			int temp;
			int j;
		
// Printing unsorted array
			System.out.println("Array before sorting");
		
		for(int i=0; i<a.length;i++)
		{
			System.out.println(a[i]+" ");
		}
			
// Sorting process
			for(int i=1;i<a.length;i++)
			{
				temp=a[i];
				j=i;
				while( j>0 && a[j-1]>temp )
				{
					a[j]=a[j-1];
					j--;
				}
				
				a[j]=temp;
				
			}
		
//Printing sorted array
			System.out.println("Array after sorting");
			for(int i=0;i<a.length;i++)
			{
				System.out.println(a[i]+" ");
				
			}
			
	}

}
