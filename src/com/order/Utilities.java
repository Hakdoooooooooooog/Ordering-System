package com.order;

import java.util.ArrayList;
import java.util.Scanner;

public final class Utilities extends Products{

    //Order Array
    private ArrayList<String> orderName;
    private ArrayList<Integer> orderQty;
    private ArrayList<Integer> orderPrice;
    private ArrayList<Integer> totalPrice;
    private ArrayList<String> text;

    Scanner in = new Scanner(System.in);
    Scanner oScan = new Scanner(System.in);

    String cName, oName = "";
    int total, oPrice;
    
    public Utilities(){
        this.orderQty = new ArrayList<>();
        this.orderName = new ArrayList<>();
        this.orderPrice = new ArrayList<>();
        this.totalPrice = new ArrayList<>();
        this.text = new ArrayList<>();
   
    }

    public void utility(){
        int choices;
        boolean exit = true;

        System.out.print("Enter your name: ");
        cName = in.nextLine();
        
        
        do{
            System.out.printf("\n\t\t\t=============================================================UTILITIES=========================================================");
            System.out.print("\n\t\t\t| [1]Display Menu | [2]Ordering | [3]Add Item | [4]Remove Item | [5]Your Orders | [6]Print Receipt | [7]Terminate the Program |");
            System.out.printf("\n\t\t\t===============================================================================================================================");
            System.out.print("\n\nChoose Utility you want to use: ");
            choices = in.nextInt();
            
            switch(choices){
                case 1 -> displayItems(menuName, menuPrice, menuQty);
                case 2 -> order(menuName, menuPrice, menuQty);
                case 3 -> addItem(menuName, menuPrice, menuQty);
                case 4 -> removeItem(menuName, menuPrice, menuQty);
                case 5 -> displayOrder(orderName, orderPrice, orderQty, totalPrice);
                case 6 -> printReceipt(orderName, orderPrice, totalPrice);
                case 7 -> exit = false; //Exiting Message 
                default -> System.out.println("Invalid input. Try again!");
            }
            
        }while(exit);
    }
    
    public void displayItems(ArrayList<String> menuName, ArrayList<Integer> menuPrice, ArrayList<Integer> menuQty){
        System.out.print("\t\t\t\t=================================================COMPUTER PARTS================================================");
        System.out.print("\n\t\t\t        |\t   Product No.\t\t|\t   Product Name\t\t|\t Price\t     |\t     Quantity         |");
        System.out.print("\n\t\t\t\t===============================================================================================================");
        
        for(int i = 1; i < getMenuNameSize(); i++){
            System.out.printf("\n\t\t\t\t|\t       [%d]\t\t|\t %-15s\t|\tP %,4d\t     |\t\t%2d\t      |",i, getMenuName(i), getMenuPrice(i), getMenuQty(i));
        }

        System.out.print("\n\t\t\t\t===============================================================================================================");
    }
    
    public void order(ArrayList<String> menuName, ArrayList<Integer> menuPrice, ArrayList<Integer> menuQty){
        String choose, name;
        int qty, stock = 0;
        boolean ordering = true, exitOrder = true;

		System.out.print("\t\t\t\t====================================================ORDERING===================================================");
       
        do{
            do{
                System.out.print("\nWhat product name would you like to order?: ");
                name = oScan.nextLine();

                //Validating Menu Name
                for(int i = 1; i < getMenuNameSize(); i++){

                    if (getMenuName(i).equalsIgnoreCase(name)){
                        oName = getMenuName(i);
                        stock = getMenuQty(i);
                        oPrice = getMenuPrice(i);
                        ordering = false; 
                    }
                }
                
                if(ordering == false){
                    System.out.println("Ordered Successfully."); 

                    System.out.print("\nHow many would you like to order?: ");
                    qty = in.nextInt();
    
                    //Validating Quantity
                    if (qty < stock){
                        System.out.println("Ordered Successfully. Adding to your ordered list.");
                        orderName.add(oName);
                        orderQty.add(qty);
                        orderPrice.add(oPrice);
                    }else{
                        System.out.printf("\nOnly %2d are in stock at the moment.", stock);
                    }
                    
                }else{
                    System.out.printf("Theres no such \"%s\" item.\n", name);
                }

            }while(ordering);
            

            do{
                System.out.print("\nDo you want to order again? (Yes or No): ");
                choose = in.next();

                if (choose.equalsIgnoreCase("Yes")){
                    ordering = true;
                    break;
                }else if (choose.equalsIgnoreCase("No")){
                    exitOrder = false;
                }else{
                    System.out.println("Incorrect input.");
                }

            }while(exitOrder);
            
        }while(exitOrder);

        System.out.print("\t\t\t\t===============================================================================================================");
    }
    
    public void addItem(ArrayList<String> menuName, ArrayList<Integer> menuPrice, ArrayList<Integer> menuQty){
        String validity, item;
        int price, pieces;
        
        do{
            System.out.print("\n\t\t\t\t==================================================ADDING ITEM==================================================");
            System.out.print("\n\nDo you want to add any item? (Yes or No) ");
            validity = in.next();
            if (validity.equalsIgnoreCase("Yes")){
                System.out.print("What product do you want to add?: ");
                item = in.next();
                System.out.print("How much this item will cost?: ");
                price = in.nextInt();
                System.out.print("How many of this item will be added to the list?: ");
                pieces = in.nextInt();
                System.out.println("Item added successfully!");
                
                addMenuName(item);
                addMenuPrice(price);
                addMenuQty(pieces);
                
            }    
        }while (!validity.equalsIgnoreCase("No"));
        
        System.out.print("\t\t\t\t=================================================COMPUTER PARTS================================================");
        System.out.print("\n\t\t\t        |\t   Product No.\t\t|\t   Product Name\t\t|\t Price\t     |\t     Quantity         |");
        System.out.print("\n\t\t\t\t===============================================================================================================");
        
        for(int i = 1; i < getMenuNameSize(); i++){
            System.out.printf("\n\t\t\t\t|\t       [%d]\t\t|\t %-15s\t|\tP %,4d\t     |\t\t%2d\t      |",i, getMenuName(i), getMenuPrice(i), getMenuQty(i));
        }

        System.out.print("\n\t\t\t\t===============================================================================================================");
        
        //Spacing
        System.out.println();
        
    }
    
    public void removeItem(ArrayList<String> menuName, ArrayList<Integer> menuPrice, ArrayList<Integer> menuQty){
        String validity;
        boolean item = true;
        int count = 0;

        do{
            if (count == 0){
                System.out.print("\n\t\t\t\t=================================================REMOVING ITEM=================================================");
                System.out.print("\n\nDo you want to remove an item? Yes or No?: ");    
            }else if (count > 0){
                System.out.print("\n\nDo you want to remove an another item? Yes or No?: ");
            }
                validity = in.next();
           
            do{
                if (validity.equalsIgnoreCase("Yes")){
                    in.nextLine();
                    System.out.print("What product name would you like to remove? ");
                    String prodName = in.nextLine();
    
                    for(int i = 1; i < getMenuNameSize(); i++){
                        if (getMenuName(i).equals(prodName)){
                            removeMenuName(i);
                            removeMenuPrice(i);
                            removeMenuQty(i);
                            item = false;
                        }
                    }
    
                    if(item == false){
                        System.out.println("Item removed successfully!");
                    }else{
                        System.out.printf("Theres no such \"%s\" item.\n", prodName);
                    }
                }

            count++;

            }while(item);
            
        }while (!validity.equalsIgnoreCase("No"));

        System.out.print("\t\t\t\t=================================================COMPUTER PARTS================================================");
        System.out.print("\n\t\t\t        |\t   Product No.\t\t|\t   Product Name\t\t|\t Price\t     |\t     Quantity         |");
        System.out.print("\n\t\t\t\t===============================================================================================================");
        
        for(int i = 1; i <= 10; i++){
            System.out.printf("\n\t\t\t\t|\t       [%d]\t\t|\t %-15s\t|\tP %,4d\t     |\t\t%2d\t      |",i, getMenuName(i), getMenuPrice(i), getMenuQty(i));
        }

        System.out.print("\n\t\t\t\t===============================================================================================================");

        //Spacing
        System.out.println();	
    }

    public void displayOrder(ArrayList<String> orderName, ArrayList<Integer> orderPrice, ArrayList<Integer> orderQty, ArrayList<Integer> totalPrice){
        
        System.out.print("\n\t\t\t\t===================================================YOUR ORDERS===================================================");
        System.out.print("\n\t\t\t\t|   Order No.   |\t      Product\t\t|\tPrice\t   |\t  Quantity\t|      Total Price\t|");
        System.out.print("\n\t\t\t\t=================================================================================================================");
        
        
        //Display product, price, quantity and total price each item
        for (int i = 0; i < orderName.size(); i++){
            totalPrice.add(getMenuPrice(getIndexOfMenuName(oName)) * orderQty.get(i));
            System.out.printf("\n\t\t\t\t|      [%d] \t|      %-15s\t\t|     %,5d PHP    |\t     %d\t\t|      %,6d PHP\t|", i, orderName.get(i), orderPrice.get(i), orderQty.get(i), totalPrice.get(i)); 
        }
    
        for (int i = 0; i < orderName.size(); i++){
            total += totalPrice.get(i);
        }
        
        System.out.print("\n\t\t\t\t-----------------------------------------------------------------------------------------------------------------");
        System.out.printf("\n\t\t\t\tCustomer Name: %-20s \t\t\t\t\t\t\t   Total: %,6d PHP",cName, total);

        //Reset Total value
        total = 0;
        
        //Spacing
        System.out.println();
    }
    
    public void printReceipt(ArrayList<String> orderName, ArrayList<Integer> orderQty, ArrayList<Integer> totalPrice){
        int payment;

        for (int i = 0; i < orderName.size(); i++){
            total += totalPrice.get(i);
        }
        
        System.out.print("\t\t\t\t================================================PRINTING RECEIPT===============================================");

        
        //Getting Payment
        do{System.out.print("\n\nPlease enter your Payment: ");
        payment = in.nextInt();
            if (payment < total){
                System.out.print("Insufficient Payment.");
            }
        }while(payment < total);
    
        //Computation change
        int change = payment - total;

        text.add("\t\t\t\t\t\t\t\t************************************************\n");
        text.add("\t\t\t\t\t\t\t\t*              =-COMPUTER STORE-=              *\n");
        text.add(String.format("\t\t\t\t\t\t\t\t*Customer Name:           %20s *\n", cName));
        text.add("\t\t\t\t\t\t\t\t*----------------------------------------------*\n");
        text.add("\t\t\t\t\t\t\t\t*   ORDERS           QUANTITY          PRICE   *\n");
        text.add("\t\t\t\t\t\t\t\t************************************************\n");
        text.add(String.format("\t\t\t\t\t\t\t\t*Total Cost :                       %,6d PHP *\n", total));
        text.add(String.format("\t\t\t\t\t\t\t\t*Payment :                          %,6d PHP *\n",payment));
        text.add("\t\t\t\t\t\t\t\t*----------------------------------------------*\n");
        text.add(String.format("\t\t\t\t\t\t\t\t*Change :                           %,6d PHP *\n", change));
        text.add("\t\t\t\t\t\t\t\t*                                              *\n");
        text.add("\t\t\t\t\t\t\t\t*    Thank you for Purchasing our Product!!    *\n");
        text.add("\t\t\t\t\t\t\t\t*                                              *\n");
        text.add("\t\t\t\t\t\t\t\t*                                              *\n");
        text.add("\t\t\t\t\t\t\t\t************************************************\n");   
    
        for(int i = 0; i < text.size(); i++){
            if(i == 4){
                for (int k = 0; k < orderName.size(); k++) {
                    String text1 = String.format("\t\t\t\t\t\t\t\t* %-15s\t %2d\t    %,6d PHP *\n", orderName.get(k), orderQty.get(k), totalPrice.get(k));
                    for(int l = 0; l < text1.length(); l++){
                        System.out.printf("%c", text1.charAt(l));
                        try{
                            Thread.sleep(5);//0.005s pause between characters
                        }catch(InterruptedException ex){
                            System.out.println(ex);
                        }
                    }
                }
            }else{
                for(int j = 0;j < text.get(i).length(); j++){
                    System.out.printf("%c",  text.get(i).charAt(j));
                    try{
                        Thread.sleep(25);
                    }catch(InterruptedException ex){
                        System.out.println(ex);
                    }
                }
            }
        }
        //Clearing Item from orderName and orderQty
        orderName.clear();
        orderQty.clear();
        totalPrice.clear();
        text.clear();
    }

}

    