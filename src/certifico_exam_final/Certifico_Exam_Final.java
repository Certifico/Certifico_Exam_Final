/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certifico_exam_final;

/**
 *
 * @author khian
 */


import java.util.Scanner;

import java.util.Scanner;
import java.util.Stack;

public class Certifico_Exam_Final {
    
class Product {
    private String name;
        private int quantity;

    public Product(String name, int quantity) {
        this.name = name;
            this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

    private Stack<Product> inventoryStack;

    public Certifico_Exam_Final() {
        inventoryStack = new Stack<>();
    }

    public void addProduct(String productName, int quantity) {
        Product product = new Product(productName, quantity);
            inventoryStack.push(product);
    }

    public void sellProduct(String productName, int quantity) {
        Product product = inventoryStack.pop();
        if (product != null && product.getName().equals(productName)) {
            product.setQuantity(product.getQuantity() - quantity);
            if (product.getQuantity() > 0) {
                inventoryStack.push(product);
            }
        } else {
            throw new IllegalArgumentException("Product not found in inventory: " + productName);
        }
    }

    public void displayInventory() {
        System.out.println("Inventory:");
            for (Product product : inventoryStack) {
                System.out.println(product.getName() + ": " + product.getQuantity());
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
            Certifico_Exam_Final inventoryManagementStack = new Certifico_Exam_Final();
                boolean menu = true;
        while(menu){
            System.out.println("Tindahan ni Aling Nena:");
                System.out.println("[1] Restock");
                    System.out.println("[2] Sell");
                        System.out.println("[3] Check Stock");
                            System.out.println("[4] Exit");
                                System.out.println("Choose Option: ");
     
        int choice = scn.nextInt();

        switch (choice) {
            case 1:
               
                System.out.println("Enter NameBrand: ");
                    String productName = scn.next();
                        System.out.println("Quantity: ");
                            int quantity = scn.nextInt();
                                inventoryManagementStack.addProduct(productName, quantity);
                break;
            case 2:             
                System.out.println("Which Product Would You like to Sell?: ");
                    productName = scn.next();
                        System.out.println("How Many?: ");
                            quantity = scn.nextInt();
                                inventoryManagementStack.sellProduct(productName, quantity);
                break;
            case 3:            
                inventoryManagementStack.displayInventory();
                break;
            case 4:
                menu = false;
                break;
            default:
                throw new AssertionError();
        }
    }
}

}
