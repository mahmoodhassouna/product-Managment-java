package javaapplication20;
public class Wighted extends Product{

    public Wighted(float weight, int productId, String productName, String productDescription, float price) {
        super(productId, productName, productDescription, price);
        this.weight = weight;
    }
    private float weight;
    @Override
    public float totals() {
        float pay = (super.getPrice()*this.weight);
        return pay;
    }
    @Override
    public String printReport (){
        String report = super.printReport()+", Weight="+this.getWeight()+"}";
        return report;
    }
    public float getWeight() {
        return weight;
    }
    public void setWeight(float weight) {
        this.weight = weight;
    }   
}