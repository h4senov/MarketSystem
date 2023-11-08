package org.example.service.impl;

import org.example.models.Product;
import org.example.models.Sale;
import org.example.models.SaleItem;
import org.example.service.inter.SaleInter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class SaleImpl implements SaleInter {
    Sale sales = new Sale();
    static List<Sale> saleItemList = new ArrayList<>();
    static ProductImpl product1 = new ProductImpl();
    static List<Product> productList = product1.productList;

    @Override
    public Sale saleAdd(Product product, int count, int number) {
        for (Product products : productList) {
            if (products.equals(product) && products.getCount() >= count && products.getCount() > 0 && count > 0) {

                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDateTime now = LocalDateTime.now();

                Sale sale = new Sale(number, product.getPrice(), null, new SaleItem(number, product, count));

                saleItemList.add(sale);

                int totalCount = products.getCount() - count;
                products.setCount(totalCount);
                return sale;

            }
        }

        return null;

    }

    @Override
    public Sale showSale() {
        for (Sale sales : saleItemList
        ) {

            System.out.println(sales);
        }
        return null;
    }

    @Override
    public Sale byNumberSale(Integer number) { // birinci daxil etdiyimizi gorur

        for (Sale sales : saleItemList
        ) {
            if (sales.getNumber().equals(number)) {
                System.out.println("if working");
                System.out.println(sales);
            }
            return sales;
        }
        return null;
    }

    @Override
    public List<Sale> totalSale() {
        for (Sale totalsale : saleItemList) {
            System.out.println(totalsale);
        }
        return saleItemList;
    }

    @Override
    public Sale returnSale(Integer number, Integer countProduct) {
        for (Sale sales : saleItemList) {

            if (sales.getNumber().equals(number) && sales.getSaleItem().getCount() >= countProduct) {

                int productCount = sales.getSaleItem().getProduct().getCount();

                int saleProductCount = sales.getSaleItem().getCount();

                int totalProductCount = countProduct + productCount; // umumi productun sayi
                System.out.println("product");
                int totalSaleProductionCount = saleProductCount - countProduct;
                sales.getSaleItem().setCount(totalSaleProductionCount);
                sales.getSaleItem().getProduct().setCount(totalProductCount);

            }
        }
        return null;
    }

    @Override
    public Sale byAmountShowSale(Double firstAmount, Double secondAmount) {
        for (Sale sales : saleItemList
        ) {
            if (sales.getAmount() >= firstAmount && sales.getAmount() < secondAmount) {
                System.out.println("if working");
                System.out.println(sales);
            }
        }
        return null;
    }


}
