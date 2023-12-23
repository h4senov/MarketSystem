package org.example.service.inter;

import org.example.models.Product;
import org.example.models.Sale;
import org.example.models.SaleItem;

import java.time.LocalDateTime;
import java.util.List;

public interface SaleInter {
Sale findSaleByDate(LocalDateTime saleDate);

    Sale saleAdd( Sale sale );

    List<Sale> showSale();

    Sale findSaleByID(Integer ID);

    List<Sale> totalSale();

    public Sale returnProduct(String productBarcode, Integer productCount, Integer saleNumber);

    Sale findSaleBetwenByAmount(Double firstAmount, Double secondAmount);

    boolean deleteSaleByID(Integer ID);
}
