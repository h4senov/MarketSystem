package org.example.service.inter;

import org.example.models.Category;
import org.example.models.Product;

import java.util.List;

public interface ProductInter {


    Product addProduct(Product product);

    List<Product> showProducts();

    Product byBarCodeProduct(String barCode, String name, int count, Double price, Category category);

    List<Product> byCategoryProduct(Category category);

    Product byAmountProduct(Double firstAmount, Double secondAmount);

    Product byNameProduct(String name);
    Product deleteProductByBarCode(String barCode);
}
