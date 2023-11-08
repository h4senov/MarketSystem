package org.example.service.impl;

import org.example.models.Category;
import org.example.models.Product;
import org.example.service.inter.ProductInter;

import java.util.ArrayList;
import java.util.List;

public class ProductImpl implements ProductInter {
    static List<Product> productList = new ArrayList<>();
    Product product = new Product();

    @Override
    public Product addProduct(Product product) {
        productList.add(product);
        return product;
    }

    @Override
    public List<Product> showProducts() { //foreach versiyasinida yoxlayarsan
        for (Product products : productList
        ) {
            System.out.println(products);
        }
        return productList;
    }

    @Override
    public Product byBarCodeProduct(String barCode, String name, int count, Double price, Category category) {
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
    public List<Product> byCategoryProduct(Category category) {
// gah arada isleyir gah arada islemir
        for (Product products : productList) {
            if (products.getCategory().equals(category)) {
                System.out.println(products);
            } else {
                System.out.println(" Mehsul daxil edilmeyib ");
            }
        }
        return productList;
    }

    @Override
    public Product byAmountProduct(Double minPrice, Double maxPrice) {

        for (Product products : productList
        ) {
            double productPrice = products.getPrice();
            if (productPrice >= minPrice && productPrice <= maxPrice) {
                System.out.println(products);
            } else {

                System.out.println(" Mehsul tapilmadi "); // bunu duzelde bilmedim
            }
        }
        return product;
    }

    @Override
    public Product byNameProduct(String name) {
        for (Product products : productList
        ) {
            if (products.getName().equals(name)) {
                System.out.println(products);
            }
        }
        return product;
    }

    @Override
    public Product deleteProductByBarCode(String barCode) {
        for (Product products : productList
        ) {
            if (products.getBarCode().equals(barCode)) {
                products.equals(null);
            }
        }
        return product;
    }


}
