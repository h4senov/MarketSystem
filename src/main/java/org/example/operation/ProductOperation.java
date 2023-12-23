package org.example.operation;

import org.example.models.Category;
import org.example.models.Product;
import org.example.service.impl.ProductImpl;

import java.util.Scanner;

public class ProductOperation {
    static ProductImpl productImpl = new ProductImpl();
    static Integer idCount = 0;

    public void addProductOperation() {

        idCount++;

        Scanner scanner = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        System.out.println(" Mehsul elave et \n" +
                " ");
        System.out.println(" Mehsulun adi ");
        String name = scanner.nextLine();
        System.out.println(" Mehsulun qiymeti ");
        Double price = scanner.nextDouble();
        System.out.println(" Mehsulun sayini elave et ");
        Integer count = scanner.nextInt();
        System.out.println(" Barkodu elave et ");
        String barCode = input.nextLine();

        System.out.println(" Kateqoriyasini sec \n" +
                "    1.ELECTRONICS,\n" +
                "    2.CLOTHING,\n" +
                "    3.FOOD_AND_BEVERAGES,\n" +
                "    4.BEAUTY_AND_PERSONAL_CARE,\n" +
                "    5.BOOKS,\n" +
                "    6.TOYS_AND_GAMES,");


        Integer category = scanner.nextInt();
        switch (category) {
            case 1: {
                Product product = new Product(idCount, name, price, Category.ELECTRONICS, count, barCode, null);
                productImpl.addProduct(product);
                break;
            }
            case 2: {
                Product product = new Product(idCount, name, price, Category.CLOTHING, count, barCode, null);
                productImpl.addProduct(product);
                break;
            }
            case 3: {
                Product product = new Product(idCount, name, price, Category.FOOD_AND_BEVERAGES, count, barCode, null);
                productImpl.addProduct(product);
                break;
            }
            case 4: {
                Product product = new Product(idCount, name, price, Category.BEAUTY_AND_PERSONAL_CARE, count, barCode, null);
                productImpl.addProduct(product);
                break;
            }
            case 5: {
                Product product = new Product(idCount, name, price, Category.BOOKS, count, barCode, null);
                productImpl.addProduct(product);
                break;
            }
            case 6: {
                Product product = new Product(idCount, name, price, Category.TOYS_AND_GAMES, count, barCode, null);
                productImpl.addProduct(product);
                break;
            }
            default:

                System.out.println(" Daxil edilen reqem sehvdir. Zehmet olmasa duzgun ededi secin ");


        }


    }

    public void showProduct() {
        System.out.println("  Mehsullarimiz: ");

        System.out.println(productImpl.showProducts());
    }

    public void byBarCodeProductUpdateOperation() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(productImpl.showProducts());


        System.out.println(" \n" +
                "Axtardiginiz mehsulun barkodunu daxil et ");
        String barCode = scanner.nextLine();

//        productImpl.findProductByBarCode(barCode);

        System.out.println(" Mehsulun ID-ni deyis ");
        Integer productID = scanner.nextInt();

        System.out.println(" Mehsulun adini deyis ");
        String prductName = scanner.nextLine();

        System.out.println(" Mehsulun qiymetini deyis ");
        Double productPrice = scanner.nextDouble();

        System.out.println(" Mehsulun sayini deyis et ");
        Integer productCount = scanner.nextInt();

        System.out.println(" Kateqoriyasini sec \n" +
                "    1.ELECTRONICS,\n" +
                "    2.CLOTHING,\n" +
                "    3.FOOD_AND_BEVERAGES,\n" +
                "    4.BEAUTY_AND_PERSONAL_CARE,\n" +
                "    5.BOOKS,\n" +
                "    6.TOYS_AND_GAMES,");


        Integer category = scanner.nextInt();
        switch (category) {
            case 1: {
                Category category1 = Category.ELECTRONICS;
                Product product = new Product(productID, prductName, productPrice, category1, productCount, barCode, null);
                productImpl.updateByProduct(product);

                break;
            }
            case 2: {
                Category category2 = Category.CLOTHING;
                Product product2 = new Product(productID, prductName, productPrice, category2, productCount, barCode, null);
                productImpl.updateByProduct(product2);
                break;
            }
            case 3: {
                Category category3 = Category.FOOD_AND_BEVERAGES;
                Product product3 = new Product(productID, prductName, productPrice, category3, productCount, barCode, null);
                productImpl.updateByProduct(product3);
                break;
            }
            case 4: {
                Category category4 = Category.BEAUTY_AND_PERSONAL_CARE;
                Product product4 = new Product(productID, prductName, productPrice, category4, productCount, barCode, null);
                productImpl.updateByProduct(product4);
                break;
            }
            case 5: {
                Category category5 = Category.BOOKS;
                Product product5 = new Product(productID, prductName, productPrice, category5, productCount, barCode, null);
                productImpl.updateByProduct(product5);
                break;
            }
            case 6: {
                Category category6 = Category.TOYS_AND_GAMES;
                Product product6 = new Product(productID, prductName, productPrice, category6, productCount, barCode, null);
                productImpl.updateByProduct(product6);
                break;
            }
            default:

                System.out.println(" Daxil edilen reqem sehvdir. Zehmet olmasa duzgun ededi secin ");

        }


    }

    public void ByCategoryOpeartion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Kateqoriyasini sec \n" +
                "    1.ELECTRONICS,\n" +
                "    2.CLOTHING,\n" +
                "    3.FOOD_AND_BEVERAGES,\n" +
                "    4.BEAUTY_AND_PERSONAL_CARE,\n" +
                "    5.BOOKS,\n" +
                "    6.TOYS_AND_GAMES,");


        Integer category = scanner.nextInt();
        switch (category) {
            case 1: {
                System.out.println(productImpl.findProductByCategory(Category.ELECTRONICS));
                break;
            }
            case 2: {
                System.out.println(productImpl.findProductByCategory(Category.CLOTHING));
                ;
                break;
            }
            case 3: {
                System.out.println(productImpl.findProductByCategory(Category.FOOD_AND_BEVERAGES));
                ;
                break;
            }
            case 4: {
                System.out.println(productImpl.findProductByCategory(Category.BEAUTY_AND_PERSONAL_CARE));
                ;
                break;
            }
            case 5: {
                System.out.println(productImpl.findProductByCategory(Category.BOOKS));
                ;
                break;
            }
            case 6: {
                productImpl.findProductByCategory(Category.TOYS_AND_GAMES);
                break;
            }
            default:

                System.out.println(" Daxil edilen reqem sehvdir. Zehmet olmasa duzgun ededi secin ");

        }

    }

    public void minMaxAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Minumum ededi daxil et ");
        Double min = scanner.nextDouble();
        System.out.println(" Maksiumum ededi daxil et ");
        Double max = scanner.nextDouble();
        productImpl.byAmountProduct(min, max);
    }

    public void byNameProductOperation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Mehsulun adini daxil et ");
        String productName = scanner.nextLine();
        System.out.println(productImpl.findProductByName(productName));
    }

    public void ByDeleteProductBarCode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Silinecek mehsulun barkodunu daxil edin ");
        String barCode = scanner.nextLine();
        productImpl.deleteProductByBarCode(barCode);
    }

}


