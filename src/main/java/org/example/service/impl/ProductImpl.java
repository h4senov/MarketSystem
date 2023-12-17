package org.example.service.impl;

import org.example.models.Category;
import org.example.models.Product;
import org.example.operation.ProductOperation;
import org.example.service.inter.ProductInter;

import javax.xml.crypto.NoSuchMechanismException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class ProductImpl implements ProductInter {
    public final static List<Product> productList = new ArrayList<>();
    static Product product = new Product();

    @Override
    public List<Product> addProduct(Product product) { //test
        productList.add(product);
        return productList;
    }

    @Override
    public List<Product> showProducts() {
        return productList;
    }

    @Override
    public Product updateByBarCodeProduct(String barCode, String name, int count, Double price, Category category) {

        for (Product products : productList
        ) {
            if (products.getBarCode().equals(barCode)) {
                products.setName(name);
                products.setCount(count);
                products.setPrice(price);
                products.setCategory(category);
            }
        }
        return product;
    }

    @Override
    public List<Product> findProductByCategory(Category category) {
        return productList.stream().filter(product1 -> product1.getCategory().equals(category)).toList();
    }

    @Override
    public Product byAmountProduct(Double minPrice, Double maxPrice) {

        for (Product products : productList
        ) {

            if (products.getPrice() >= minPrice && products.getPrice() <= maxPrice) {
                System.out.println(products);
            }
        }
        return product;
    }

    @Override
    public Product findProductByName(String name) {
      return   productList.stream().filter(product1 -> product1.getName().equals(name))
                      .findFirst().orElseThrow(() -> new NoSuchElementException(" Mehsul tapilmadi "));
    }

//HashMap
    @Override
    public Product deleteProductByBarCode(String barCode) {

        Product product1 = findProductByBarCode(barCode);
        productList.remove(product1);

        return product1;
    }

    @Override
    public Product findProductByBarCode(String barCode) {
         return productList.stream().filter(product1 -> product1.getBarCode().equals(barCode))
                .findFirst().orElseThrow(() -> new NoSuchElementException(" Bele bir element tapila bilmedi "));
    }


}
