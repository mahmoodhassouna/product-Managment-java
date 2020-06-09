
package javaapplication20;

import java.io.Serializable;


public abstract class Product implements Serializable{
    private int productId;
    private String productName;
    private String productDescription;
    private float price;

    public Product(int productId, String productName, String productDescription, float price) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
    }

    
    public abstract float totals();
    
    
    public String printReport (){
        String report = "Prodect{Id="+this.productId+", Name="+this.productName+", Description="+this.productDescription+", Price="+this.price;
        return report;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
}
