package org.example.operation;

import org.example.models.Product;
import org.example.models.Sale;
import org.example.models.SaleItem;
import org.example.service.impl.ProductImpl;
import org.example.service.impl.SaleImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SaleOperation {
    static int idCount = 1;
    static SaleImpl saleImpl = new SaleImpl();
    static ProductImpl productImpl = new ProductImpl();


    public void saleDateOperation() {

        Scanner scanner = new Scanner(System.in);
        System.out.println(" Tarixi daxil et : IL AY GUN ");
        Integer year = scanner.nextInt();
        Integer month = scanner.nextInt();
        Integer dayOfMonth = scanner.nextInt();
        LocalDate date = LocalDate.of(year, month, dayOfMonth);
        saleImpl.findSaleByDate(date.atStartOfDay());
    }

    public void saleAddOperation() {
        idCount++;

        Scanner input =  new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);

        LocalDate date = LocalDate.of(2023, 12, 23);
        boolean b = true;
        Sale sale = new Sale(idCount, null, date.atStartOfDay(), null);
        List<SaleItem> saleItemsList = new ArrayList<>();
        Double endPrice = 0.0;

        while (b) {

            System.out.println("Mehsul satmaq isdeyirsense -1-\n" +
                    "Eks halda satis bitecek");
            Integer s = scanner.nextInt();
            if (s.equals(1)) {
                System.out.println(productImpl.showProducts());

                System.out.println(" Satilicaq Mehsulun barcodunu ve sayini daxil et : ");
                System.out.println(" test PRODUCTBARCODE ");

                String productBarCode = input.nextLine();

                System.out.println(" test COUNT ");
                Integer productCount = scanner.nextInt();




                 Product product = productImpl.findProductByBarCode(productBarCode);

                product.setCount(product.getCount() - productCount);

                productImpl.updateByProduct(product);


                SaleItem saleItem = new SaleItem(idCount, productCount, null, product);

                saleItemsList.add(saleItem);
                endPrice += product.getPrice() * productCount;

            } else {
                b = false;
            }


        }
        sale.setSaleItems(saleItemsList);
        sale.setAmount(endPrice);
        saleImpl.saleAdd(sale);
    }

    public void returnSaleOperation() {
        Scanner scanner = new Scanner(System.in);
        Scanner input =  new Scanner(System.in);
        int productCount, saleID;

        System.out.println(" Satisin ID-ni daxil et : ");
        saleID = scanner.nextInt();

        System.out.println(" Mehsulun barkodunu daxil edin ");
        String productBarCode = input.nextLine();

        System.out.println("\n" +
                " Qayatailacag  mehsulun sayini qeyd edin : ");

        productCount = scanner.nextInt();

        saleImpl.returnProduct(productBarCode, productCount, saleID);

    }

    public void deleteSaleByIDOperation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Silinen mehsulun ID-ni daxil et: ");
        int saleID = scanner.nextInt();
        saleImpl.deleteSaleByID(saleID);
    }

    public void showSaleOperation() {
        System.out.println("  Satilan mehsullarin siyahi  \n" +
                " " + saleImpl.showSale());
    }

    public void findSaleBetweenByAmountOperation() {
        Scanner scanner = new Scanner(System.in);
        Double firstAmount, secondAmount;
        System.out.println("  1-ci Meblegi qeyd edin: ");
        firstAmount = scanner.nextDouble();

        System.out.println(" 2-ci Meblegi qeyd edin: ");
        secondAmount = scanner.nextDouble();
        System.out.println(saleImpl.findSaleBetwenByAmount(firstAmount, secondAmount));
    }

    public void byIDForSaleOperation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Satisin ID-ni daxil et ");
        Integer saleID = scanner.nextInt();
        System.out.println(saleImpl.deleteSaleByID(saleID));
    }
}
