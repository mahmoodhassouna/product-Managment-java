package javaapplication20;
import java.util.Scanner;
import javaapplication20.Product;
public class Dimensional extends Product{

    public Dimensional(float width, float length, int productId, String productName, String productDescription, float price) {
        super(productId, productName, productDescription, price);
        this.width = width;
        this.length = length;
    }



    private float width;
    private float length;
    Scanner x=new Scanner(System.in);
    @Override
    public float totals() {
        float pay = (super.getPrice()*this.width*this.length);
        return pay;
    }
    @Override
    public String printReport (){
        String report = super.printReport()+", Width="+this.getWidth()+", Length="+this.getLength()+"}";
        return report;
    }
    public float getWidth() {
        return width;
    }
    public void setWidth(float width) {
        this.width = width;
    }
    public float getLength() {
        return length;
    }
    public void setLength(float length) {
        this.length = length;
    }
}