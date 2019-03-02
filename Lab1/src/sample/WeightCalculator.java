package sample;

public class WeightCalculator {

     public static double getDryProductWeight(double productWeight, double percentage)
     {
        return productWeight*percentage/100;
     }
    public static double getProductWeight(double dryWeight, double percentage)
    {
        return dryWeight/(percentage/100);
    }
}
