package org.example.service.impl;

import org.example.models.Product;
import org.example.models.Sale;
import org.example.models.SaleItem;
import org.example.service.inter.SaleInter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public class SaleImpl implements SaleInter {

    static List<Sale> saleList = new ArrayList<>();
    private static ProductImpl productImpl = new ProductImpl();

    @Override
    public Sale saleAdd(Sale sale) {

        saleList.add(sale);

        return sale;

    }

    @Override
    public List<Sale> showSale() {

        return saleList;
    }


    @Override
    public List<Sale> totalSale() {

        return saleList;
    }

    @Override
    public Sale returnProduct(String productBarcode, Integer productCount, Integer saleNumber) {

        Product product = productImpl.findProductByBarCode(productBarcode);
        product.setCount(product.getCount() + productCount);
        productImpl.deleteProductByBarCode(productBarcode);
        productImpl.addProduct(product);


        Sale sales = saleList.stream().filter(sale -> sale.getNumber().equals(saleNumber)).findFirst().get();

        SaleItem saleItems = sales.getSaleItem().stream().filter(saleItem -> saleItem.getProduct()
                .getBarCode().equals(productBarcode)).findFirst().get();

        saleList.remove(sales);
        saleItems.setCount(saleItems.getCount() - productCount);

        sales.setAmount(sales.getAmount()-productCount*product.getPrice()); // qiymet meselesi
        sales.getSaleItem().add(saleItems);
        saleList.add(sales);

        return sales;
    }


    @Override
    public Sale findSaleBetwenByAmount(Double firstAmount, Double secondAmount) {// test

        return saleList.stream().filter(sale -> sale.getAmount() >= firstAmount && sale.getAmount() <= secondAmount).
                findFirst().orElseThrow(() -> new NoSuchElementException(" verilmis reqem araliginda " + firstAmount + " - " + secondAmount + " satis daxil edilmeyib "));
    }

    @Override
    public boolean deleteSaleByNumber(Integer numberSale) { // test
        Sale sale = findSaleByNumber(numberSale);
        saleList.remove(sale);
        return true;
    }

    @Override
    public Sale findSaleByNumber(Integer Number) {

        return saleList.stream().filter(sale -> sale.getNumber().equals(Number))
                .findFirst().orElseThrow(() -> new NoSuchElementException(" Bele bir nomrede satis tapilmadir "));
    }


}
