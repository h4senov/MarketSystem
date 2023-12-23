package org.example.service.inter;

import org.example.models.Category;
import org.example.models.Product;

import java.util.List;

public interface ProductInter {


    List<Product>  addProduct(Product product);

    List<Product> showProducts();

    Product updateByProduct(Product product);

    List<Product> findProductByCategory(Category category);

    Product byAmountProduct(Double firstAmount, Double secondAmount);

    Product findProductByName(String name);
    Product deleteProductByBarCode(String barCode);

    Product findProductByBarCode(String barCode);
}
