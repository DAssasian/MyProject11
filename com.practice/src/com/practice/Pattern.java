package com.practice;

public class Pattern {
	public static void main(String[]args) {
		/*
	Pattern	 * 
		 ** 
		 ***
		 **** 					
		 ***** 
		 ****** 
		 ******* 
		 ******** 
		  */
//	1	
		for(int i=1;i<=3;i++)
		{
			for(int j=1;j<=i;j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
//2		
		for(int i=1;i<=4;i++)
		{
			for(int j=4;j>=i;j--)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		System.out.println(" ");
//3		
		for(int i=1;i<=4;i++)
		{
			for(int j=3;j>=i;j--)
			{
				System.out.print(" ");
			}
			for(int k=1;k<=i;k++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println(" ");//if we remove this we get combination of two pattern that makes another pattern
	
		
		for(int i=1;i<=3;i++)
		{
			for(int k=1;k<=i;k++)
			{
				System.out.print(" ");
			}
			for(int j=i;j<=3;j++)
			{
				System.out.print("*");
			}
			System.out.println();
			
		}
		
         System.out.println("    ");
//4         
         for(int i=1;i<=4;i++)
         {
        	 for(int j=3;j>=i;j--)
        	 {
        		 System.out.print(" ");
        	 }
        	 for(int k=1;k<=i;k++)
        	 {
        		 System.out.print(" *");
        	}
        	 System.out.println();
         }
         
         System.out.println(" ");
 
// 5
         for(int i=1;i<=4;i++)
         {
        	 for(int j=3;j>=i;j--)
        	 {
        		 System.out.print(" ");
        	 }
        	 for(int k=1;k<=i;k++)
        	 {
        		System.out.print("*"); 
        	 }
        	 for(int l=1;l<i;l++)
        	 {
        	    System.out.print("*");
              }
        	 System.out.println();
          }
		
//   6
         
         for(int i=1;i<=3;i++)
         {
        	 for(int j=1;j<=i;j++)
        	 {
        		 System.out.print(" ");
        	 }
        	 for(int k=3;k>=i;k--)
        	 {
        		System.out.print("*"); 
        	 }
        	 for(int l=2;l>=i;l--)
        	 {
        		 System.out.print("*");
        	 }
        	 System.out.println("");
         }
         
//         7
         
         for(int i=0;i<=3;i++)
 		{
 			for(int j=0;j<=3;j++)
 			{
 				if(j==i) {
 					System.out.print("*");	
 				}
 				else
 					System.out.print(" ");
 				
 			}
 			System.out.println("");
 		}
         
//         8
         
         for(int i=1;i<=5;i++)
         {
        	 for(int j=5;j>=i;j--)
        	 {
        		 if(j==i)
        		 {System.out.print("*");
        		 }
        		 else {System.out.print(" ");
        		 }
        		 
        	 }
         System.out.println();
         }
         System.out.println("   ");
         
//         9
         
         for(int i=1;i<=4;i++)
         {
        	 for(int j=3;j>=i;j--)
        	 {
        		 System.out.print("*");
        	 }
        	 for(int k=2;k<(i*2);k++)
        	 {
        		 System.out.print(" ");
        	 }
        	 for(int l=i;l<=3;l++)
        	 {
        		 System.out.print("*");
        	 }
        	 System.out.println();
         }

	}

}
