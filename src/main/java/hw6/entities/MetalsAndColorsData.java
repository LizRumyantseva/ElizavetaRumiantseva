package hw6.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MetalsAndColorsData {
   private String color;
   private String metals;
   private int[] summary;
   private String[] vegetables;
   private String[] elements;

   public String getColor() {
       return color;
   }

   public String getMetals() {
       return metals;
   }

   public int getSummaryOdd() {
       return summary[0];
   }

   public int getSummaryEven() {
       return summary[1];
   }

   public String[] getVegetables() {
       return vegetables;
   }

   public String[] getElements() {
       return elements;
   }


   public List<String> getListOfPageElements() {
       List<String> result = new ArrayList<>();
       result.add(color);
       result.add(metals);
       result.add(String.valueOf(summary[0] + summary[1]));
       result.add(Arrays.toString(vegetables));
       result.add((Arrays.toString(elements)));

       return result;
   }
}

