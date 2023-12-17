package org.example.operation;

import org.example.models.Category;
import org.example.models.Product;
import org.example.service.impl.ProductImpl;

import java.util.Scanner;

public class ProductOperation {
    static ProductImpl productImpl = new ProductImpl();

    public void addProductOperation() {

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
                Product product = new Product(name, price, Category.ELECTRONICS, count, barCode);
                productImpl.addProduct(product);
                break;
            }
            case 2: {
                Product product = new Product(name, price, Category.CLOTHING, count, barCode);
                productImpl.addProduct(product);
                break;
            }
            case 3: {
                Product product = new Product(name, price, Category.FOOD_AND_BEVERAGES, count, barCode);
                productImpl.addProduct(product);
                break;
            }
            case 4: {
                Product product = new Product(name, price, Category.BEAUTY_AND_PERSONAL_CARE, count, barCode);
                productImpl.addProduct(product);
                break;
            }
            case 5: {
                Product product = new Product(name, price, Category.BOOKS, count, barCode);
                productImpl.addProduct(product);
                break;
            }
            case 6: {
                Product product = new Product(name, price, Category.TOYS_AND_GAMES, count, barCode);
                productImpl.addProduct(product);
                break;
            }
            default:

                for (int i = 0; i < 3; i++) {
                    System.out.println(" Daxil edilen reqem sehvdir. Zehmet olmasa duzgun ededi secin ");

                }

        }


    }

    public void showProduct() {
        System.out.println("  Mehsullarimiz ");

        System.out.println(productImpl.showProducts());
    }

    public void byBarCodeProductUpdateOpearion() {
        Scanner scanner = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        System.out.println(" Axtardiginiz mehsulun barkodunu daxil et ");
        String barCode = scanner.nextLine();

        System.out.println(" Mehsulun adini deyis ");
        String name = scanner.nextLine();
        System.out.println(" Mehsulun qiymetini deyis ");
        Double price = scanner.nextDouble();
        System.out.println(" Mehsulun sayini deyis et ");
        Integer count = scanner.nextInt();

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
                productImpl.updateByBarCodeProduct(barCode, name, count, price, Category.ELECTRONICS);
                break;
            }
            case 2: {
                productImpl.updateByBarCodeProduct(barCode, name, count, price, Category.CLOTHING);
                break;
            }
            case 3: {
                productImpl.updateByBarCodeProduct(barCode, name, count, price, Category.FOOD_AND_BEVERAGES);
                break;
            }
            case 4: {
                productImpl.updateByBarCodeProduct(barCode, name, count, price, Category.BEAUTY_AND_PERSONAL_CARE);
                break;
            }
            case 5: {
                productImpl.updateByBarCodeProduct(barCode, name, count, price, Category.BOOKS);
                break;
            }
            case 6: {
                productImpl.updateByBarCodeProduct(barCode, name, count, price, Category.TOYS_AND_GAMES);
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
                System.out.println( productImpl.findProductByCategory(Category.CLOTHING));;
                break;
            }
            case 3: {
                System.out.println(productImpl.findProductByCategory(Category.FOOD_AND_BEVERAGES));;
                break;
            }
            case 4: {
                System.out.println(productImpl.findProductByCategory(Category.BEAUTY_AND_PERSONAL_CARE));;
                break;
            }
            case 5: {
                System.out.println( productImpl.findProductByCategory(Category.BOOKS));;
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


