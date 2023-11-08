package org.example.operation;

import org.example.models.Product;
import org.example.service.impl.ProductImpl;
import org.example.service.impl.SaleImpl;

import java.util.Scanner;

public class SaleOperation {
    static SaleImpl saleImpl = new SaleImpl();
    static ProductImpl productImpl = new ProductImpl();

    public void saleAddOperation() {
        Scanner scanner = new Scanner(System.in);

        productImpl.showProducts();

        System.out.println(" ALDIGINIZ  MEHSULLUN BARKODUNU SECIN ");



    }
}
