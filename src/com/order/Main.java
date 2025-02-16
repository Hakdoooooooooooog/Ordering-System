package com.order;
public class Main {
    
    public static void main(String[] args){
        int j, k = 0;

			//Spacing
			System.out.println();

			//LOADING ANIMATION
		    while(k < 101) {
		        System.out.print("\t\t\t\t  [");
		        for (j=0;j<k;j++) {
		            System.out.print("=");
		        }

		        for (j=0;j<100-k;j++) {
		            System.out.print(" ");
		        }

		        System.out.print("] "+ k + "% Loading...");
		        if(k<101) {
		            System.out.print("\r");
					try {
						Thread.sleep(50);
					} catch (Exception e) {
						System.out.println(e);
					}
		            
		        }k++;
		    }

		    //Spacing
		    System.out.println();


        //Start of Program
        new Utilities().utility();

    }
}
