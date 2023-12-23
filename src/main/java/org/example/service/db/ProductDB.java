package org.example.service.db;

import jakarta.persistence.EntityManager;
import org.example.config.HibernateConfig;
import org.example.models.Category;
import org.example.models.Product;
import org.example.service.inter.ProductInter;

import java.util.List;


public class ProductDB extends HibernateConfig implements ProductInter {


    @Override
    public List<Product> addProduct(Product product) {
        return null;
    }

    @Override
    public List<Product> showProducts() {
        return null;
    }

    @Override
    public Product updateByProduct(Product product) {
        return null;
    }

    @Override
    public List<Product> findProductByCategory(Category category) {
        return null;
    }

    @Override
    public Product byAmountProduct(Double firstAmount, Double secondAmount) {
        return null;
    }

    @Override
    public Product findProductByName(String name) {
        return null;
    }

    @Override
    public Product deleteProductByBarCode(String barCode) {
        return null;
    }

    @Override
    public Product findProductByBarCode(String barCode) {
        return null;
    }
}
