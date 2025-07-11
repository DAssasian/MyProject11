package com.practice;

public class BubbleSort {

	public static void main(String[] args) {
		
		int temp=0;
		
		int[] a= {23,54,67,32,88,12,54,78};
		System.out.println("Array before sorting");
		for(int i=0;i<=a.length-1;i++)
		{
			System.out.print(a[i]+",");
		}

		for(int i=0 ; i<a.length;i++)
		{
			int flag=0;
			
			for(int j=0;j<a.length-1-i;j++)
			  {
		         	if(a[j]>a[j+1])
			          {
							temp=a[j];
							a[j]=a[j+1];
							a[j+1]=temp;
				            flag=1;
		             	}
			   }
			if(flag==0)
			{
				break;
			}
		}
		System.out.println();
		System.out.println("after bubble sorting the array");
		for(int i=0;i<=a.length-1;i++)
		{
			System.out.print(a[i]+",");
		}
		
		
	}

}
