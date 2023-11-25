import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shopping {

    public static void main(String[] args) {
        int n = 4;

        List<Map<String, Object>> basket = new ArrayList<>();

        
        String[] products = {"Leather wallet", "Umbrella", "Cigarette", "Honey"};
        double[] Prices = {1100, 900, 200, 100};
        int[] gst = {18, 12, 28, 0};
        int[] quant = {1, 4, 3, 2};

        for (int i = 0; i < n; i++) {
            basket.add(create(products[i], Prices[i], gst[i], quant[i]));
        }

        Map<String, Object> maxGSTProduct = MaxGSTP(basket);
        System.out.println("\nProduct with maximum GST amount: " + maxGSTProduct.get("Product"));

        double total = TotalAmount(basket);
        double discount = DiscountedAmount(basket, 500);
        double finalamount = total - discount;

        System.out.println("\nTotal amount to be paid after discount: Rs. " + finalamount);
    }

    private static Map<String, Object> create(String productname, double unitprice, int gstpercentage, int quantity) {
        Map<String, Object> product = new HashMap<>();
        product.put("Product", productname);
        product.put("Unit Price", unitprice);
        product.put("GST (%)", gstpercentage);
        product.put("Quantity", quantity);
        return product;
    }

    private static Map<String, Object> MaxGSTP(List<Map<String, Object>> basket) {
        double maxGSTAmount = -1;
        Map<String, Object> maxGSTProduct = null;

        for (Map<String, Object> product : basket) {
            double gstAmount = (double) product.get("Unit Price") * (int) product.get("GST (%)") / 100 * (int) product.get("Quantity");

            if (gstAmount > maxGSTAmount) {
                maxGSTAmount = gstAmount;
                maxGSTProduct = product;
            }
        }

        return maxGSTProduct;
    }

    private static double TotalAmount(List<Map<String, Object>> basket) {
        double totalAmount = 0;

        for (Map<String, Object> product : basket) {
            totalAmount += ((double) product.get("Unit Price") * (1 + (int) product.get("GST (%)") / 100)) * (int) product.get("Quantity");
        }

        return totalAmount;
    }

    private static double DiscountedAmount(List<Map<String, Object>> basket, double discountThreshold) {
        double discountedAmount = 0;

        for (Map<String, Object> product : basket) {
            double unitPrice = (double) product.get("Unit Price");
            int quantity = (int) product.get("Quantity");

            if (unitPrice >= discountThreshold) {
                discountedAmount += unitPrice * quantity * 0.05;
            }
        }

        return discountedAmount;
    }
}


/*add products
public static void extra(){
     ArrayList<String>s=new ArrayList<String>();
     s.add("Leather wallet");
     s.add("umbrella");
     s.add("cigarette");
     s.add("honey");
     System.out.println();
     System.out.println("More product to basket:");
     System.out.print(s);
  } */

/* user input
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Shopping {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        
        System.out.print("Enter the number of products in the basket: ");
        int n = in.nextInt();

        List<Map<String, Object>> basket = new ArrayList<>();

        
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Product " + (i + 1));
            System.out.print("Product Name: ");
            String productName = in.next();
            System.out.print("Unit Price: ");
            double unitPrice = in.nextDouble();
            System.out.print("GST Percentage: ");
            int gstPercentage =in.nextInt();
            System.out.print("Quantity: ");
            int quantity = in.nextInt();

            basket.add(createProduct(productName, unitPrice, gstPercentage, quantity));
        }

        
        Map<String, Object> maxGSTProduct = getMaxGSTProduct(basket);
        System.out.println("\nProduct with maximum GST amount: " + maxGSTProduct.get("Product"));

        
        double totalAmount = getTotalAmount(basket);
        double discountedAmount = getDiscountedAmount(basket, 500);
        double finalAmount = totalAmount - discountedAmount;

        System.out.println("\nTotal amount to be paid after discount: " + finalAmount);

        
        in.close();
    }

    private static Map<String, Object> createProduct(String productName, double unitPrice, int gstPercentage, int quantity) {
        Map<String, Object> product = new HashMap<>();
        product.put("Product", productName);
        product.put("Unit Price", unitPrice);
        product.put("GST (%)", gstPercentage);
        product.put("Quantity", quantity);
        return product;
    }

    private static Map<String, Object> getMaxGSTProduct(List<Map<String, Object>> basket) {
        double maxGSTAmount = -1;
        Map<String, Object> maxGSTProduct = null;

        for (Map<String, Object> product : basket) {
            double gstAmount = (double) product.get("Unit Price") * (int) product.get("GST (%)") / 100 * (int) product.get("Quantity");

            if (gstAmount > maxGSTAmount) {
                maxGSTAmount = gstAmount;
                maxGSTProduct = product;
            }
        }

        return maxGSTProduct;
    }

    private static double getTotalAmount(List<Map<String, Object>> basket) {
        double totalAmount = 0;

        for (Map<String, Object> product : basket) {
            totalAmount += ((double) product.get("Unit Price") * (1 + (int) product.get("GST (%)") / 100)) * (int) product.get("Quantity");
        }

        return totalAmount;
    }

    private static double getDiscountedAmount(List<Map<String, Object>> basket, double discountThreshold) {
        double discountedAmount = 0;

        for (Map<String, Object> product : basket) {
            double unitPrice = (double) product.get("Unit Price");
            int quantity = (int) product.get("Quantity");

            if (unitPrice >= discountThreshold) {
                discountedAmount += unitPrice * quantity * 0.05;
            }
        }

        return discountedAmount;
    }
}
*/
