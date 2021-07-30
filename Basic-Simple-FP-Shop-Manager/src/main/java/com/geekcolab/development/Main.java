package com.geekcolab.development;

import com.geekcolab.development.beans.*;
import com.geekcolab.development.mock.*;
import com.geekcolab.development.util.FunctionUtil;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Instructions:");
            System.out.println("-----------------------------");
            System.out.println("Press 1 to get list of product names");
            System.out.println("Press 7 to get list of products That have \"shoes\" tag");
            System.out.println("Press 12 to get list of products That have \"min\" limit value");
            System.out.println("Press 3 to get list of Top Paying Customers Within A Year and Discounts");
            System.out.println("Press 4 to get list of Top Taxed Product in a specific year");
            System.out.println("Press 5 to get list of Top Tax Paying customers within in a specific year");
            System.out.println("Press 0 to exit");
            int input = scanner.nextInt();
            if(input == 1){
                System.out.println("List of product names");
                List<Shop> shops = ShopMock.getListOfShop();
                List<String> names = FunctionUtil.getALLProductName.apply(shops.get(0));
                names.stream().forEach(System.out::println);
            }

            if(input == 7){
                System.out.print("List of products which have \"shoes\" tag");
                List<Shop> shops = ShopMock.getListOfShop();
                List<Product> products = FunctionUtil.getProductListByTag.apply(shops.get(0), "shoes");
                products.stream().forEach(System.out::println);
            }

            if(input == 12){
                System.out.print("List of products that have minimum limit");
                List<Shop> shops = ShopMock.getListOfShop();
                List<Product> products = FunctionUtil.getALLProductsThatHaveMinLimit.apply(shops.get(0).getProducts());
                products.stream().forEach(System.out::println);
            }

            if(input == 3){
                System.out.print("List of Top 5 Paying Customers Within 2021 while having the most Discounts are");
                CustomerMock cM = new CustomerMock();
                System.out.println(" ");
                System.out.println(" ->" + FunctionUtil.topKPayingCustomersOnKDiscounts.apply(cM.getCustomers().stream().map(customer -> customer.getPerson()).collect(Collectors.toList()), 2021L, 0d, 5L));

            }

            if(input == 4){
                System.out.print("List of Top 4 Taxed Product of 2021 are: ");
                CustomerMock cM = new CustomerMock();
                System.out.println(" ");
                System.out.println(" ->" + FunctionUtil.topKMostTaxedProductOnKYear.apply(cM.getYamShopping(), 2021L, 4L));

            }

            if(input == 5){
                System.out.print("List of Top 4 Tax Paying customers of 2021 are: ");
                CustomerMock cM = new CustomerMock();
                System.out.println(" ");
                System.out.println(" ->" + FunctionUtil.topTaxPayingCustomerOnKYear.apply(cM.getYamShopping(), 2021L, 4L));

            }

            if(input == 0){
                System.out.println("Good Bye......");
                break;
            }
        }
    }
}
