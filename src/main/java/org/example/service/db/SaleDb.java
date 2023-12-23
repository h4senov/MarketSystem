package org.example.service.db;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.config.HibernateConfig;
import org.example.models.Sale;
import org.example.service.inter.SaleInter;

import java.time.LocalDateTime;
import java.util.List;

public class SaleDb extends HibernateConfig implements SaleInter {


    @Override
    public Sale findSaleByDate(LocalDateTime saleDate) {
        return null;
    }

    @Override
    public Sale saleAdd(Sale sale) {
        return null;
    }

    @Override
    public List<Sale> showSale() {
        return null;
    }

    @Override
    public Sale findSaleByID(Integer number) {
        return null;
    }

    @Override
    public List<Sale> totalSale() {
        return null;
    }

    @Override
    public Sale returnProduct(String productBarcode, Integer productCount, Integer saleNumber) {
        return null;
    }

    @Override
    public Sale findSaleBetwenByAmount(Double firstAmount, Double secondAmount) {
        return null;
    }

    @Override
    public boolean deleteSaleByID(Integer numberSale) {
        return false;
    }
}
