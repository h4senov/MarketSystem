package org.example;

import lombok.Data;
import org.example.models.Category;
import org.example.models.Product;
import org.example.models.Sale;
import org.example.models.SaleItem;
import org.example.operation.ProductOperation;
import org.example.operation.SaleOperation;
import org.example.service.impl.ProductImpl;
import org.example.service.impl.SaleImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static org.example.models.Category.FOOD_AND_BEVERAGES;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean sorgu = true;
        while (sorgu) {
            System.out.println(" Xoş gəlmisiz ! \n" +
                    " -1 Mehsullar uzerinde emeliyyat aparmaq\n" +
                    " -2 Satislar uzerinde emeliyyat aparmaq\n" +
                    " -3 Sistemden cixmaq");
            Integer choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    productOpeationMethod();
                    break;
                case 2:

                    break;
                case 3:
                    sorgu = false;
                    break;
                default: {
                    System.out.println(" Sehv reqemi secmisiz ");
                }

            }
        }


    }

    public static void productOpeationMethod() {
        Scanner scanner = new Scanner(System.in);
        ProductOperation productOperation = new ProductOperation();

        boolean sorgu = true;
        while (sorgu) {
            System.out.println("- 1 Yeni mehsul elave et-\n" +
                    " - 2 Mehsul uzerinde duzelis et-\n" +
                    " - 3 Mehsulu sil -\n" +
                    " - 4 Butun mehsullari goster -\n" +
                    " - 5 Categoriyasina gore mehsullari goster -\n" +
                    " - 6 Qiymet araligina gore mehsullari goster -\n" +
                    " - 7 Mehsullar arasinda ada gore axtaris et -\n" +
                    " - 8 - Sistemden cix -");
            Integer choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    productOperation.addProductOperation();
                    break;
                case 2:
                    productOperation.byBarCodeProductUpdateOpearion();
                    break;
                case 3:
                    productOperation.ByDeleteProductBarCode();
                    break;
                case 4:
                    productOperation.showProduct();
                    break;
                case 5:
                    productOperation.ByCategoryOpeartion();
                    break;
                case 6:
                    productOperation.minMaxAmount();
                    break;
                case 7:
                    productOperation.byNameProductOperation();
                    break;
                case 8:
                    sorgu = false;
                    break;
                default:
                    System.out.println(" DUZGUN EDEDI SECIN! ");


            }
        }
    }
}