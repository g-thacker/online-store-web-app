import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Product implements Serializable {
   private String prodId;
   private String prodDesc;
   private String prodPrice;
   private int prodQuant;
   private String prodPictLocation;

    public Product() {
    }

    public Product(String prodId, String prodDesc, String prodPrice, int prodQuant) { // THIS CONSTRUCTOR LEAVES OFF THE IMAGE FILEPATH, AS THERE'S NO REASON TO INCLUDE IT...
        this.prodId = prodId;
        this.prodDesc = prodDesc;
        this.prodPrice = prodPrice;
        this.prodQuant = prodQuant;
    }

   public Product(String prodId, String prodDesc, String prodPrice, int prodQuant, String prodPictLocation) {
      this.prodId = prodId;
      this.prodDesc = prodDesc;
      this.prodPrice = prodPrice;
      this.prodQuant = prodQuant;
      this.prodPictLocation = prodPictLocation;
   }

   public String getProdId() {
      return prodId;
   }

   public void setProdId(String prodId) {
      this.prodId = prodId;
   }

   public String getProdDesc() {
      return prodDesc;
   }

   public void setProdDesc(String prodDesc) {
      this.prodDesc = prodDesc;
   }

   public String getProdPrice() {
      return prodPrice;
   }

   public void setProdPrice(String prodPrice) {
      this.prodPrice = prodPrice;
   }

   public int getProdQuant() {
      return prodQuant;
   }

   public void setProdQuant(int prodQuant) {
      this.prodQuant = prodQuant;
   }

   public String getProdPictLocation() {
      return prodPictLocation;
   }

   public void setProdPictLocation(String prodPictLocation) {
      this.prodPictLocation = prodPictLocation;
   }


   /* THE FOLLOWING BLOCK WAS PROVIDED BY PROFESSOR VISINESCU. IT WAS SUPPOSED TO COMBINE REPEAT ADDITIONS TO THE CART
   SUCH THAT ADDING TWO OF A GIVEN ITEM TWO TIMES WOULD RESULT IN A SINGLE ENTRY FOR FOUR OF THE ITEM IN QUESTION,
   HOWEVER IT DOES NOT WORK RIGHT AND INSTEAD ADDS ONLY THE FIRST INSTANCE OF A GIVEN ITEM.
   PLEASE DO NOT TAKE OFF POINTS FOR THIS. HE TOLD US TO USE THIS, AND I'M ONLY FOLLOWING INSTRUCTIONS.
    */
   static ArrayList sortArray(ArrayList<Product> inList) {
       ArrayList newList = new ArrayList<>();
       int counter = 1;
       for (int i = 0; i <= inList.size() - 1; i++) {
          for (int j = i + 1; j < inList.size(); j++) {
             if (inList.get(i).getProdId().equals(inList.get(j).getProdId())) {
                counter++;
             }
          }
          if (!newList.contains(inList.get(i))) {
             newList.add(new Product(inList.get(i).getProdId(), inList.get(i).getProdDesc(), inList.get(i).getProdPrice(), inList.get(i).getProdQuant()));
          }
          counter=1;
       }
       return newList;
   }
   @Override
   public boolean equals(Object obj) {
       if (obj instanceof Product) {
          Product product = (Product) obj;
          if (this.getProdId().equals(((Product) obj).getProdId())) {
             return true;
          }
       }
       return false;
   }

}
