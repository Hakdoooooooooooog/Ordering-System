package com.order;

import java.util.ArrayList;

public class Products{
    
    //Menu Array
    protected final ArrayList<String> menuName;
    protected final ArrayList<Integer> menuPrice;
    protected final ArrayList<Integer> menuQty;
    

    public Products(){
        
        menuName = new ArrayList<>();
            menuName.add("");
            menuName.add("CPU");
            menuName.add("Hard Disk Drive");
            menuName.add("Headset");    
            menuName.add("Keyboard");
            menuName.add("Monitor");
            menuName.add("Motherboard");
            menuName.add("Mouse");
            menuName.add("Power Supply");
            menuName.add("Ram");
            menuName.add("Graphics Card");

        menuPrice = new ArrayList<>();
            menuPrice.add(0);
            menuPrice.add(3100);
            menuPrice.add(2250);
            menuPrice.add(1560);
            menuPrice.add(1090);
            menuPrice.add(5138);
            menuPrice.add(4797);
            menuPrice.add(489);
            menuPrice.add(2080);
            menuPrice.add(2024);
            menuPrice.add(3651);

        menuQty = new ArrayList<>();
            menuQty.add(0);
            menuQty.add(18);
            menuQty.add(20);
            menuQty.add(15);
            menuQty.add(27);
            menuQty.add(5);
            menuQty.add(12);
            menuQty.add(30);
            menuQty.add(10);
            menuQty.add(25);
            menuQty.add(10);

    }

    public String getMenuName(int num){
        return menuName.get(num);
    }

    public int getMenuPrice(int num){
        return menuPrice.get(num);
    }

    public int getMenuQty(int num){
        return menuQty.get(num);
    }

    public int getMenuNameSize(){
        return menuName.size();
    }

    public void addMenuName(String item){
        menuName.add(item);
    }

    public void addMenuPrice(int price){
        menuPrice.add(price);
    }

    public void addMenuQty(int pieces){
        menuQty.add(pieces);
    }

    public void removeMenuName(int num){
        menuName.remove(num);
    }

    public void removeMenuPrice(int num){
        menuPrice.remove(num);
    }

    public void removeMenuQty(int num){
        menuQty.remove(num);
    }

    public int getIndexOfMenuName(String name){
        return menuName.indexOf(name);
    }
}
