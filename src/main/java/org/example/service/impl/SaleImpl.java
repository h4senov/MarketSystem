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
    public Sale findSaleByDate(LocalDateTime saleDate) {
        return saleList.stream().filter(sale -> sale.getTime().equals(saleDate)).
                findFirst().orElseThrow(() -> new NoSuchElementException(" Bele bir mehsul tapilmadi "));
    }

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
    public Sale returnProduct(String productBarcode, Integer productCount, Integer saleID) {

        Product product = productImpl.findProductByBarCode(productBarcode); // barCoduna gore mehsulu tap
        product.setCount(product.getCount() + productCount); //qaytarilan mehsulun sayini set eleyib ,
        productImpl.deleteProductByBarCode(productBarcode);  // silib ve
        productImpl.addProduct(product); // elave eleyirik ki listde yenilensin


        Sale sales = saleList.stream().filter(sale -> sale.getId().equals(saleID)).findFirst().get(); // sale de id'e gore satisi tapmag

        SaleItem saleItems = sales.getSaleItems().stream().filter(saleItem -> saleItem.getProduct()
                .getBarCode().equals(productBarcode)).findFirst().get(); // barcoduna gore saleitems tapmaq

        saleList.remove(sales);
        saleItems.setCount(saleItems.getCount() - productCount);

        sales.setAmount(sales.getAmount() - productCount * product.getPrice()); // qaytarilacaq  mehsulun sayi qiymet meselesi
        sales.getSaleItems().add(saleItems);
        saleList.add(sales);

        return sales;
    }


    @Override
    public Sale findSaleBetwenByAmount(Double firstAmount, Double secondAmount) {// test

        return saleList.stream().filter(sale -> sale.getAmount() >= firstAmount && sale.getAmount() <= secondAmount).
                findFirst().orElseThrow(() -> new NoSuchElementException(" verilmis reqem araliginda " + firstAmount + " - " + secondAmount + " satis daxil edilmeyib "));
    }

    @Override
    public boolean deleteSaleByID(Integer ID) { // test
        Sale sale = findSaleByID(ID);
        saleList.remove(sale);
        return true;
    }

    @Override
    public Sale findSaleByID(Integer ID) {

        return saleList.stream().filter(sale -> sale.getId().equals(ID))
                .findFirst().orElseThrow(() -> new NoSuchElementException(" Bele bir nomrede satis tapilmadir "));
    }


}
