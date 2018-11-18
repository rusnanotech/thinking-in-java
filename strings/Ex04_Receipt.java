/****************** Exercise 4 ******************
 * Modify Receipt.java so that the widths are all
 * controlled by a single set of constant values.
 * The goal is to allow you to easily change a
 * width by changing a single value in one place.
 ************************************************/
package biz.markov.thinking.strings;

import java.util.*;

public class Ex04_Receipt {
   private final String title_row, middle_row, total_row;
   private double total = 0;
   private Formatter f = new Formatter(System.out);
   
   public Ex04_Receipt(int scale_factor) {
      int item_width = 3 * scale_factor,
          qty_width = scale_factor,
          price_width = 2 * scale_factor;
      
      title_row = String.format("%%%ds %%%ds %%%ds\n",
                                -item_width, qty_width, price_width);
      middle_row = String.format("%%%d.%ds %%%dd %%%d.2f\n",
                                -item_width, item_width, qty_width, price_width);
      total_row = String.format("%%%ds %%%ds %%%d.2f\n",
                                -item_width, qty_width, price_width);
      System.out.println(middle_row);
   }
   
   public Ex04_Receipt() {
      this(5);
   }
   
   public void printTitle() {
      f.format(title_row, "Item", "Qty", "Price");
      f.format(title_row, "----", "---", "-----");
   }
   public void print(String name, int qty, double price) {
      f.format(middle_row, name, qty, price);
      total += price;
   }
   public void printTotal() {
      f.format(total_row, "Tax", "", total*0.06);
      f.format(title_row, "", "", "-----");
      f.format(total_row, "Total", "",
         total * 1.06);
   }
   public static void main(String[] args) {
      Ex04_Receipt receipt = new Ex04_Receipt();
      receipt.printTitle();
      receipt.print("Jack's Magic Beans", 4, 4.25);
      receipt.print("Princess Peas", 3, 5.1);
      receipt.print("Three Bears Porridge", 1, 14.29);
      receipt.printTotal();
   }
}
