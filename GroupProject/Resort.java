import java.text.DecimalFormat;

public class Resort
{
    //Attributes
    private String custName;
    private String custEmail;
    private String custPhone;
    private int numOfCust;
    private int packageID;
    private double packagePrice;
    private char packageAddOn;
    private String paymentMethod;
    
    //normal constructor
    public Resort(String custName, String custEmail, String custPhone, int numOfCust, int packageID, double packagePrice,char packageAddOn, String paymentMethod)
    {
        this.custName = custName;
        this.custEmail = custEmail;
        this.custPhone = custPhone;
        this.numOfCust = numOfCust;
        this.packageID = packageID;
        this.packagePrice = packagePrice;
        this.packageAddOn = packageAddOn;
        this.paymentMethod = paymentMethod;
    }
    
    //setter
    public void setPackageAddOn(char packageAddOn){this.packageAddOn = packageAddOn;}
    
    //retriever
    public String getCustName(){return custName;}
    public String getCustEmail(){return custEmail;}
    public String getCusPhone(){return custPhone;}
    public int getNumOfCust(){return numOfCust;}
    public int getPackageID(){return packageID;}
    public double getPackagePrice(){return packagePrice;}
    public char getPackageAddOn(){return packageAddOn;}
    public String getPaymentMethod(){return paymentMethod;}
    
    //processor
    public double totalPayment()
    {
        double totalP = 0;
        
        totalP = packagePrice * numOfCust;
        
        return totalP;
    }
    
    //toString
    public String toString()
    {
        DecimalFormat df = new DecimalFormat("0.00");
        return String.format("%-20s%-30s%-27s%-24s%-21s%-26s%-17s%-20s", custName, custEmail, custPhone, numOfCust, packageID, df.format(packagePrice), packageAddOn, paymentMethod);
    }
}