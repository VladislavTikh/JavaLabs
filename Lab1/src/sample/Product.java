package sample;

public class Product {
    private double productPercentage;
    private double productWeight;
    private double dryProductWeight;
    public double getProductWeight(){return productWeight;}
    public double getDryProductWeight(){return dryProductWeight;}
    public Product(double Weight, double percentage, double dryweight )
    {
        productWeight=Weight;
        productPercentage=percentage;
        dryProductWeight=dryweight;
    }
}
