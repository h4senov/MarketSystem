package org.example.service.inter;

import org.example.models.Product;
import org.example.models.Sale;
import org.example.models.SaleItem;

import java.util.List;

public interface SaleInter {
    Sale saleAdd(Product product, int count  ,int number  );
    Sale showSale();
    Sale byNumberSale(Integer  number);
    List<Sale> totalSale();
    Sale returnSale(Integer number,Integer countProduct);
    Sale byAmountShowSale(Double firstAmount, Double secondAmount);

}
