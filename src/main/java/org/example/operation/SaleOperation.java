package org.example.operation;

import org.example.models.Category;
import org.example.models.Product;
import org.example.models.Sale;
import org.example.models.SaleItem;
import org.example.service.impl.ProductImpl;
import org.example.service.impl.SaleImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SaleOperation {
    static SaleImpl saleImpl = new SaleImpl();
    static ProductImpl productImpl = new ProductImpl();

    public void saleAddOperation() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int number = 1;


        productImpl.showProducts();

        System.out.println(" Satilicaq Mehsulun barcodunu ve sayini daxil et : ");

        String barcode = scanner.nextLine();

        Integer count = scanner.nextInt();

        Product product = productImpl.findProductByBarCode(barcode);

        Integer saleItemNumber = random.nextInt(100);

        SaleItem saleItem = new SaleItem(saleItemNumber, product, count);

        List<SaleItem> saleItemsList = new ArrayList<>();

        saleItemsList.add(saleItem);


        Sale sale = new Sale(number++, product.getPrice(), LocalDateTime.now(), saleItemsList);

        saleImpl.saleAdd(sale);
    }

    public void returnSale() {
        Scanner scanner = new Scanner(System.in);
        int count, number;

        System.out.println(" Satisin nomresini qeyd edin ");
        number = scanner.nextInt();

        System.out.println("\n" +
                " Qayatailacag  mehsulun sayini qeyd edin");
        count = scanner.nextInt();

//        saleImpl.returnSale(number, count);
    }

    public void deleteSaleByNumber() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        saleImpl.deleteSaleByNumber(number);
    }

    public void showSale() {
        System.out.println("  Satilan mehsullarin siyahi  \n" +
                " " + saleImpl.showSale());
    }

    public void byAmountShowSaleOperation() {
        Scanner scanner = new Scanner(System.in);
        Double firstAmount, secondAmount;
        System.out.println("  1-ci Meblegi qeyd edin ");
        firstAmount = scanner.nextDouble();

        System.out.println(" 2-ci Meblegi qeyd edin ");
        secondAmount = scanner.nextDouble();

        System.out.println(saleImpl.findSaleBetwenByAmount(firstAmount, secondAmount));
    }

    public void byNumberForSaleOperation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Satisin nomresini qeyd et ");
        Integer number = scanner.nextInt();
        System.out.println(saleImpl.deleteSaleByNumber(number));
    }
}
