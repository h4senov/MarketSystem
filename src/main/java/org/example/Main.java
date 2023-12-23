package org.example;

import org.example.models.Product;
import org.example.operation.ProductOperation;
import org.example.operation.SaleOperation;

import java.util.Scanner;


public class Main {
    private static SaleOperation saleOperation = new SaleOperation();
    private static ProductOperation productOperation = new ProductOperation();


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean sorgu = true;
        while (sorgu) {
            System.out.println(" Xoş gəlmisiz ! \n" +
                    " -1 Mehsullar uzerinde emeliyyat aparmaq\n" +
                    " -2 Satislar uzerinde emeliyyat aparmaq\n" +
                    " -3 Sistemden cixmaq");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    productOpeationMethod();
                    break;
                case 2:
                    saleOperationMethod();
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


        boolean sorgu = true;
        int choice;
        while (sorgu) {
            System.out.println(" - 1 Yeni mehsul elave et-\n" +
                    " - 2 Mehsul uzerinde duzelis et-\n" +
                    " - 3 Mehsulu sil -\n" +
                    " - 4 Butun mehsullari goster -\n" +
                    " - 5 Categoriyasina gore mehsullari goster -\n" +
                    " - 6 Qiymet araligina gore mehsullari goster -\n" +
                    " - 7 Mehsullar arasinda ada gore axtaris et -\n" +
                    " - 8 - Sistemden cix -");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    productOperation.addProductOperation();
                    break;
                case 2:
                    productOperation.byBarCodeProductUpdateOperation();
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

    public static void saleOperationMethod() {

        Scanner scanner = new Scanner(System.in);
        boolean sorgu = true;
        int choice;
        while (sorgu) {
            System.out.println("- 1 Yeni satis elave etmek -\n" +
                    "- 2 Satisdaki hansisa mehsulun geri qaytarilmasi( satisdan cixarilmasi) - \n" +
                    "- 3 Satisin silinmesi -\n" +
                    "- 4 Butun satislarin ekrana cixarilmasi\n" +
                    "- 5 Verilen tarix araligina gore satislarin gosterilmesi -\n" +
                    "- 6 Verilen mebleg araligina gore satislarin gosterilmesi -\n" +
                    "- 7 Verilmis bir tarixde olan satislarin gosterilmesi  -\n" +
                    "- 8 Verilmis nomreye esasen hemin nomreli satisin melumatlarinin gosterilmesi -\n" +
                    "- 9 Sistemden cixis ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    saleOperation.saleAddOperation();
                    break;
                case 2:
                    saleOperation.returnSaleOperation();
                    break;
                case 3:
                    saleOperation.deleteSaleByIDOperation();
                    break;
                case 4:
                    saleOperation.showSaleOperation();
                    break;
                case 5:
                    System.out.println("System eror");
                    break;
                case 6:
                    saleOperation.findSaleBetweenByAmountOperation();
                    break;
                case 7:
                     saleOperation.saleDateOperation();
                    break;
                case 8:
                    saleOperation.byIDForSaleOperation();
                    break;
                case 9:
                    sorgu = false;
                    break;
                default:
                    System.out.println(" Yanlis reqemi secdiniz ");
            }

        }
    }


}