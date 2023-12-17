package org.example.service.inter;

import org.example.models.Product;
import org.example.models.Sale;
import org.example.models.SaleItem;

import java.util.List;

public interface SaleInter {
    Sale saleAdd(Sale sale);

    List<Sale> showSale();

    Sale findSaleByNumber(Integer number);

    List<Sale> totalSale();

    public Sale returnProduct(String productBarcode, Integer productCount, Integer saleNumber );

    Sale findSaleBetwenByAmount(Double firstAmount, Double secondAmount);

    boolean deleteSaleByNumber(Integer numberSale);
 }
