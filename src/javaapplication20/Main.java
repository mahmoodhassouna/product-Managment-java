package javaapplication20;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {

    static int id;
    static String name;
    static String Description;
    static float price = 0;

    static Scanner scanner;
    static String enternum;
    static Main main;
    static int number = 0;
    static Dimensional tmp;
    static Product p;

    public static void main(String[] args) throws IOException {
        tmp = (Dimensional) p;
     

        ArrayList<Product> products = new ArrayList<>();
      
        String fileDirectory1 = System.getProperty("user.dir");
        File file1 = new File(fileDirectory1 + "/data.txt");

        FileWriter fr1 = new FileWriter(file1);
        PrintWriter pr1 = new PrintWriter(fr1);
        for (Product p : products) {
            if (p instanceof Dimensional) {
                Dimensional d = (Dimensional) p;
                pr1.println(d.getProductId() + "," + d.getProductName() + "," + d.getProductDescription() + "," + (int) d.getPrice() + "," + (int) d.getWidth() + "," + (int) d.getLength() + ",D");
            } else if (p instanceof Wighted) {
                Wighted w = (Wighted) p;
                pr1.println(w.getProductId() + "," + w.getProductName() + "," + w.getProductDescription() + "," + (int) w.getPrice() + "," + (int) w.getWeight() + ",W");
            }
        }
        pr1.close();
        fr1.close();

        scanner = new Scanner(System.in);
        main = new Main();
        while (true) {
            System.out.println("1- Show All Products" + "\n" + "2- Add Product" + "\n" + "3- Delete Product" + "\n"
                    + "4- Edit Product" + "\n" + "5- Calculate Total Price" + "\n" + "6- Save data to file" + "\n" + "7- Exit");
            System.out.print("Enter your choice :");
            enternum = scanner.nextLine();

            try {
                number = Integer.parseInt(enternum);
                if (number > 7 || number <= 0) {
                    System.out.println("please, enter number between 1 and 7");
                }
            } catch (NumberFormatException e) {
                System.out.println("please, enter number !");
            }
            switch (number) {
                case 1: {
                    System.out.print("Enter product type: (D/W) :");
                    String type = scanner.nextLine();
//                    char type = c.charAt(0);
                    if (type.equalsIgnoreCase("d")) {
                        for (Product p : products) {
                            if (p instanceof Dimensional) {
                                Dimensional tmp = (Dimensional) p;
                                System.out.println(tmp.printReport());
                            }
                        }
                    } else if (type.equalsIgnoreCase("w")) {
                        for (Product p : products) {
                            if (p instanceof Wighted) {
                                Wighted tmp = (Wighted) p;
                                System.out.println(tmp.printReport());
                            }
                        }
                    } else {
                        System.out.println("please, enter D Or W");
                    }
                    break;
                }
                case 2: {
                    System.out.print("Enter product type: (D/W) :");
                    String type = scanner.nextLine();
                    if (type.equalsIgnoreCase("d")) {
                        float width = 0;
                        float length = 0;

                        try {
                            main.idnamedesc();

                            System.out.print("Enter product Width: ");
                            width = scanner.nextFloat();
                            System.out.print("Enter product Length: ");
                            length = scanner.nextFloat();
                            scanner.nextLine();

                            Dimensional dp = new Dimensional(width, length, id, name, Description, price);

                            products.add(dp);
                        } catch (InputMismatchException e) {
                            System.out.println("Please Enter Width,And Length");
                            break;
                        }
                    } else if (type.equalsIgnoreCase("w")) {
                        float weight = 0;

                        try {
                            main.idnamedesc();
                            System.out.print("Enter product Weight: ");
                            weight = scanner.nextFloat();
                            scanner.nextLine();
                            Wighted wp = new Wighted(weight, id, name, Description, price);

                            products.add(wp);
                        } catch (InputMismatchException e) {
                            System.out.println("Please Enter weight");
                            break;
                        }
                    } else {
                        System.out.println("please, enter a valid value....");
                    }
                    break;
                }
                case 3: {
                    System.out.print("Enter product Id: ");
                    int id = scanner.nextInt();
                    boolean isDeleted = false;
                    for (Product p : products) {
                        if (p.getProductId() == id) {
                            products.remove(p);
                            isDeleted = true;
                            break;
                        }
                    }
                    if (isDeleted == true) {
                        System.out.println("Done!");
                    } else {
                        System.out.println("Verify id please.");
                    }
                    break;
                }
                case 4: {
                    System.out.print("Enter product Id: ");
                    int id = scanner.nextInt();
                    products.forEach(new Consumer<Product>() {
                        @Override
                        public void accept(Product p) {
                            if (p.getProductId() == id) {
                                int index = products.indexOf(p);
                                if (p instanceof Dimensional) {
                                    Dimensional tmp = (Dimensional) p;
                                    System.out.println(tmp.printReport());
                                    System.out.print("Enter product Id: ");
                                    int newId = scanner.nextInt();
                                    System.out.print("Enter product Name: ");
                                    String newName = scanner.nextLine();
                                    System.out.print("Enter product Description: ");
                                    String newDescription = scanner.nextLine();
                                    System.out.print("Enter product  Price: ");
                                    float newPrice = scanner.nextFloat();
                                    System.out.print("Enter product Width: ");
                                    float newWidth = scanner.nextFloat();
                                    System.out.print("Enter product Length: ");
                                    float newLength = scanner.nextFloat();
                                    scanner.nextLine();
                                    tmp.setProductId(newId);
                                    tmp.setProductName(newName);
                                    tmp.setProductDescription(newDescription);
                                    tmp.setPrice(newPrice);
                                    tmp.setWidth(newWidth);
                                    tmp.setLength(newLength);
                                    products.set(index, tmp);
                                } else if (p instanceof Wighted) {
                                    Wighted tmp = (Wighted) p;
                                    System.out.println(tmp.printReport());
                                    System.out.print("Enter product Id: ");
                                    int newId = scanner.nextInt();
                                    System.out.print("Enter product Name: ");
                                    String newName = scanner.nextLine();
                                    System.out.print("Enter product Description: ");
                                    String newDescription = scanner.nextLine();
                                    System.out.print("Enter product  Price: ");
                                    float newPrice = scanner.nextFloat();
                                    System.out.print("Enter product Weight: ");
                                    float neWeight = scanner.nextFloat();
                                    scanner.nextLine();

                                    tmp.setProductId(newId);
                                    tmp.setProductName(newName);
                                    tmp.setProductDescription(newDescription);
                                    tmp.setPrice(newPrice);
                                    tmp.setWeight(neWeight);
                                    products.set(index, tmp);
                                }
                            } else if (p.getProductId() != id) {
                                System.out.println("This product cannot be modified because it does not exist.");
                            }
                        }
                    });
                    break;
                }
                case 5:
                    float totalPrice = 0;
                    for (Product p : products) {
                        totalPrice += p.totals();
                    }
                    System.out.println("TotalPrice: " + totalPrice);
                    break;
                case 6:
                    String fileDirectory = System.getProperty("user.dir");
                    File file = new File(fileDirectory + "/data.txt");
                    try {
                        FileWriter fr = new FileWriter(file);
                        PrintWriter pr = new PrintWriter(fr);
                        for (Product p : products) {
                            if (p instanceof Dimensional) {
                                Dimensional d = (Dimensional) p;
                                pr.println(d.getProductId() + "," + d.getProductName() + "," + d.getProductDescription() + "," + (int) d.getPrice() + "," + (int) d.getWidth() + "," + (int) d.getLength() + ",D");
                            } else if (p instanceof Wighted) {
                                Wighted w = (Wighted) p;
                                pr.println(w.getProductId() + "," + w.getProductName() + "," + w.getProductDescription() + "," + (int) w.getPrice() + "," + (int) w.getWeight() + ",W");
                            }
                        }
                        System.out.println(" save successful.");
                        pr.close();
                        fr.close();
                    } catch (Exception ex) {
                        System.out.println("File Not Found");
                    }
                    break;
                case 7:
                    break;
                default:
                    break;
            }
        }
    }

    public void idnamedesc() {
        System.out.print("Enter product Id: ");
        id = scanner.nextInt();
        System.out.print("Enter product Name: ");
         scanner.nextLine();
        name = scanner.nextLine();
        System.out.print("Enter product Description: ");
        Description = scanner.nextLine();
        System.out.print("Enter product  Price: ");
        price = scanner.nextFloat();

    }

}
