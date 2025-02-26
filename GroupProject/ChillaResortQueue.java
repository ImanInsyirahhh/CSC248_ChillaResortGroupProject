import java.util.Comparator;
import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;
import java.text.DecimalFormat;
 
public class ChillaResortQueue
{
    public static void main(String[] args) throws IOException
    {
        File inputFile = new File("resortCustomer.txt");
        PrintWriter pw = null;
        Queue resortQueue = new Queue();
        Queue h = new Queue();
        try
        {
            pw = new PrintWriter (new FileWriter("ChilaResortQueueOutput.txt"));
            try (BufferedReader br = new BufferedReader(new FileReader(inputFile)))
            {
                String line;
            
                while((line = br.readLine()) != null)
                {
                   String delimiter = ",";
                   StringTokenizer st = new StringTokenizer(line, delimiter);
                
                   String custName = st.nextToken();
                   String custEmail = st.nextToken();
                   String custPhone = st.nextToken();
                   int numOfCust = Integer.parseInt(st.nextToken());
                   int packageID = Integer.parseInt(st.nextToken());
                   double packagePrice = Double.parseDouble(st.nextToken());
                   char packageAddOn = st.nextToken().charAt(0);
                   String paymentMethod = st.nextToken();
                
                   //Create a new Resort Object with the read data
                   Resort r = new Resort(custName, custEmail, custPhone, numOfCust, packageID, packagePrice, packageAddOn, paymentMethod);
                   resortQueue.enqueue(r);
                }
            }catch (FileNotFoundException e){
                System.out.println("Error: File not Found");
            }catch (Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        
            System.out.println("\t***************************************************************************************************************************************************************");
            System.out.println("\t***************************************************************************************************************************************************************");
            System.out.println("\t****************----*********----***--------***---*********------********------******-----*****-----***--------********-----------****------*******************");
            System.out.println("\t*****************---*********---****--------***---********--------*****----------****-----*****-----***--------********-----------**----------*****************");
            System.out.println("\t*****************---****-****---****---********---*******---****---****---****---****---*--***--*---***---*****************---******---****---*****************");
            System.out.println("\t*****************---***---***---****---********---*******---**********---******---***---*--***--*---***---*****************---*****---******---****************");
            System.out.println("\t******************--***---***--*****-------****---******----**********---******---***---**--*--**---***-------*************---*****---******---****************");
            System.out.println("\t******************---**---**---*****-------****---******----**********---******---***---**--*--**---***-------*************---*****---******---****************");
            System.out.println("\t******************---*-----*---*****---********---*******---****---***---******---***---*********---***---*****************---*****---******---****************");
            System.out.println("\t******************---*-----*   *****---********---*******---****---****---****---****---*********---***---*****************---******---****---*****************");
            System.out.println("\t*******************-----*-----******--------***--------***--------*****----------****---*********---***--------************---******----------*****************");
            System.out.println("\t*******************----***----******--------***--------****------********------******---*********---***--------************---********------*******************");
            System.out.println("\t***************************************************************************************************************************************************************");
            System.out.println("\t***************************************************************************************************************************************************************");
            System.out.println("\t******------*****---******---***---***---********---**********------***********--------******--------*****------********------******--------*****-----------***");
            System.out.println("\t*****--------****---******---***---***---********---*********---**---**********----**---*****--------****---------****----------****----**---****-----------***");
            System.out.println("\t****---****---***---******---***---***---********---********---****---*********---****---****---********---****---****---****---****---****---*******---*******");
            System.out.println("\t****---**********---******---***---***---********---********---****---*********---****---****---********-----********---******---***---****---*******---*******");
            System.out.println("\t***----**********------------***---***---********---********---****---*********----**---*****-------*******-----*****---******---***----**---********---*******");
            System.out.println("\t***----**********------------***---***---********---********----------*********--------******-------**********----***---******---***--------*********---*******");
            System.out.println("\t****---****---***---******---***---***---********---********---****---*********---***---*****---**************----***---******---***---***---********---*******");
            System.out.println("\t****---****---***---******---***---***---********---********---****---*********---****---****---********---****----***---****---****---****---*******---*******");
            System.out.println("\t*****--------****---******---***---***--------***--------***---****---*********---*****---***--------***----------*****--------*****---*****---******---*******");
            System.out.println("\t******------*****---******---***---***--------***--------***---****---*********---******---**--------****--------*******------******---******---*****---*******");
            System.out.println("\t***************************************************************************************************************************************************************");
            System.out.println("\t***************************************************************************************************************************************************************");

            
            String header = h.headerString();
            
            //Display data in the queue
            int count = 0;
            Queue temp = new Queue();
            System.out.println("\n\n=================================================================================================================================================================================");
            pw.write("\n=================================================================================================================================================================================\n");
            System.out.println("\t\t\t\t\tAll Chilla Resort Customers Records in Queue");
            pw.write("\t\t\t\t\t\tAll Resort Customers Records in Queue");
            System.out.println("=================================================================================================================================================================================");
            pw.write("\n=================================================================================================================================================================================\n");
        
            System.out.println(header);
            pw.write(header + "\n");
            
            while(!resortQueue.isEmpty())
            {
               Resort rs = (Resort)resortQueue.dequeue();
               temp.enqueue(rs);
               count++;
               System.out.println(rs.toString() + "\n");
               pw.write(rs.toString() + "\n");
            }
        
            while(!temp.isEmpty())
            {
               resortQueue.enqueue(temp.dequeue());
            }
        
            System.out.println("\nNumber of Customers: " + count);
            pw.write("\nNumber of Customers: " + count + "\n");
            
            //Question 1: Rearranging customers data based on customers name (custName)
            int queueSize = resortQueue.size();
            Resort[] custArray = new Resort[queueSize];
            Queue t = new Queue();

            System.out.println("\n\nQUESTION 1: REARRANGING CUSTOMERS DATA BASED ON CUSTOMERS NAME");
            pw.write("\n\nQUESTION 1: REARRANGING CUSTOMERS DATA BASED ON CUSTOMERS NAME\n");
            
            // Transfer queue data to array
            for (int i = 0; i < queueSize; i++) {
                custArray[i] = (Resort) resortQueue.dequeue();
            }

            // Sort array alphabetically by customer name
            for (int i = 0; i < custArray.length - 1; i++) {
                for (int j = 0; j < custArray.length - 1 - i; j++) {
                    if (custArray[j].getCustName().compareTo(custArray[j + 1].getCustName()) > 0) {
                        // Swap
                        Resort tempResort = custArray[j];
                        custArray[j] = custArray[j + 1];
                        custArray[j + 1] = tempResort;
                    }
                }
            }

            //Transfer sorted customers into array
            Queue sortedQueue = new Queue();
            for (Resort customer : custArray) {
                sortedQueue.enqueue(customer);
            }
            
            System.out.println("\n\n=================================================================================================================================================================================");
            pw.write("\n=================================================================================================================================================================================\n");
            System.out.println("\t\t\t\t\tSorted Customers Data");
            pw.write("\t\t\t\t\tSorted Customers Data");
            System.out.println("=================================================================================================================================================================================");
            pw.write("\n=================================================================================================================================================================================\n");

            //Print the data header
            System.out.println(header);
            pw.write(header + "\n");
            
            while (!sortedQueue.isEmpty()) 
            {
                Resort rs = (Resort) sortedQueue.dequeue();
                System.out.println(rs.toString());
                pw.write(rs.toString() + "\n");
                t.enqueue(rs);
            }
            
            while(!t.isEmpty())
            {
                resortQueue.enqueue(t.dequeue());
            }
            
            System.out.println("\nNumber of Customers: " + count);
            pw.write("\nNumber of Customers: " + count + "\n");
            
            //Display list of customers Q2
            
            System.out.println("\n\n=================================================================================================================================================================================");
            pw.write("\n=================================================================================================================================================================================\n");
            System.out.println("\t\t\t\t\tAll Chilla Resort Customers Records in Queue");
            pw.write("\t\t\t\t\t\tAll Resort Customers Records in Queue");
            System.out.println("=================================================================================================================================================================================");
            pw.write("\n=================================================================================================================================================================================\n");
        
            System.out.println(header);
            pw.write(header + "\n");
            
            while(!resortQueue.isEmpty())
            {
               Resort rs = (Resort)resortQueue.dequeue();
               temp.enqueue(rs);
               System.out.println(rs.toString() + "\n");
               pw.write(rs.toString() + "\n");
            }
        
            while(!temp.isEmpty())
            {
               resortQueue.enqueue(temp.dequeue());
            }
            
            System.out.println("\nNumber of Customers: " + count);
            pw.write("\nNumber of Customers: " + count + "\n");
            
            //Question 2: Find customer details with numOfCust above 3
            
            System.out.println("\n\nQUESTION 2: FIND CUSTOMER DETAILS WITH NUMBER OF CUSTOMERS ABOVE 3");
            pw.write("\n\nQUESTION 2: FIND CUSTOMER DETAILS WITH NUMBER OF CUSTOMERS ABOVE 3\n");

            System.out.println("\n\n=================================================================================================================================================================================");
            pw.write("\n=================================================================================================================================================================================\n");
            System.out.println("\t\t\t\t\tCustomers with more than 3 members");
            pw.write("\t\t\t\t\tCustomers with more than 3 members");
            System.out.println("=================================================================================================================================================================================");
            pw.write("\n=================================================================================================================================================================================\n");
            Queue tempQ = new Queue();
            int count2 = 0;
            
            System.out.println(header);
            pw.write(header + "\n");
        
            while (!resortQueue.isEmpty()) {
                Resort rs = (Resort) resortQueue.dequeue();
                if (rs.getNumOfCust() > 3) {
                    System.out.println(rs.toString());
                    pw.write(rs.toString() + "\n");
                    count2++;
                }
                tempQ.enqueue(rs);
            }
        
            while (!tempQ.isEmpty())
            {
                resortQueue.enqueue(tempQ.dequeue());
            }
        
            System.out.println("\nNumber of Customers: " + count2);
            pw.write("\nNumber of Customers: " + count2 + "\n");
            
            //Display list of customers Q3
            
            System.out.println("\n\n\n=================================================================================================================================================================================");
            pw.write("\n=================================================================================================================================================================================\n");
            System.out.println("\t\t\t\t\tAll Chilla Resort Customers Records in Queue");
            pw.write("\t\t\t\t\t\tAll Resort Customers Records in Queue");
            System.out.println("=================================================================================================================================================================================");
            pw.write("\n=================================================================================================================================================================================\n");
        
            System.out.println(header);
            pw.write(header + "\n");
            
            while(!resortQueue.isEmpty())
            {
               Resort rs = (Resort)resortQueue.dequeue();
               temp.enqueue(rs);
               System.out.println(rs.toString() + "\n");
               pw.write(rs.toString() + "\n");
            }
        
            while(!temp.isEmpty())
            {
               resortQueue.enqueue(temp.dequeue());
            }
            
            System.out.println("\nNumber of Customers: " + count);
            pw.write("\nNumber of Customers: " + count + "\n");
            
            //Question 3: Calculate total amount of people who booking each package (1- Deluxe Double / 2 - Deluxe Twin)
            int totalDD = 0;
            int totalDT = 0;
            Queue Temp = new Queue();
        
            while (!resortQueue.isEmpty())
            {
                Resort rs = (Resort) resortQueue.dequeue();
                Temp.enqueue(rs);
            
                if (rs.getPackageID() == 1)
                {
                    totalDD += rs.getNumOfCust();
                }
                else if (rs.getPackageID() == 2)
                {
                    totalDT += rs.getNumOfCust();
                }
            }
        
            while (!Temp.isEmpty())
            {
                resortQueue.enqueue(Temp.dequeue());
            }
            
            System.out.println("\n\nQUESTION 3: CALCULATE TOTAL AMOUNT OF PEOPLE WHO BOOKING EACH PACKAGE");
            pw.write("\n\nQUESTION 3: CALCULATE TOTAL AMOUNT OF PEOPLE WHO BOOKING EACH PACKAGE\n");
            
            System.out.println("\n\n================================================================================================================================================");
            pw.write("\n================================================================================================================================================\n");
            System.out.println("\t\t\t\t\tTotal number of people who booked each package");
            pw.write("\t\t\t\t\tTotal number of people who booked each package");
            System.out.println("================================================================================================================================================");
            pw.write("\n================================================================================================================================================\n");
            System.out.println("\tDeluxe Double: " + totalDD);
            System.out.println("\tDeluxe Twin: " + totalDT);
            pw.write("\tDeluxe Double: " + totalDD + "\n");
            pw.write("\tDeluxe Twin: " + totalDT + "\n");
        
            //Display list of customers Q4
            
            System.out.println("\n\n=================================================================================================================================================================================");
            pw.write("\n=================================================================================================================================================================================\n");
            System.out.println("\t\t\t\t\tAll Chilla Resort Customers Records in Queue");
            pw.write("\t\t\t\t\t\tAll Resort Customers Records in Queue");
            System.out.println("=================================================================================================================================================================================");
            pw.write("\n=================================================================================================================================================================================\n");
        
            System.out.println(header);
            pw.write(header + "\n");
            
            while(!resortQueue.isEmpty())
            {
               Resort rs = (Resort)resortQueue.dequeue();
               temp.enqueue(rs);
               System.out.println(rs.toString() + "\n");
               pw.write(rs.toString() + "\n");
            }
        
            while(!temp.isEmpty())
            {
               resortQueue.enqueue(temp.dequeue());
            }
            
            System.out.println("\nNumber of Customers: " + count);
            pw.write("\nNumber of Customers: " + count + "\n");
            
            //Question 4: Add packageAddOn for customers with packageID = ‘2’ to include “Breakfast” (A)
            Queue tempQueue = new Queue();
            int count4 = 0;
        
            System.out.println("\n\nQUESTION 4: ADD PACKAGE ADD-ON FOR CUSTOMERS WITH PACKAGE ID = '2' TO INCLUDE BREAKFAST(A)");
            pw.write("\n\nQUESTION 4: ADD PACKAGE ADD-ON FOR CUSTOMERS WITH PACKAGE ID = '2' TO INCLUDE BREAKFAST(A)\n");
            
            System.out.println("\n\n=============================================================================================================================================================================================================");
            pw.write("\n=============================================================================================================================================================================================================\n");
            System.out.println("\t\t\t\t\tAdd Package Add-On for customers with packageID = 2");
            pw.write("\t\t\t\t\tAdd Package Add-On for customers with packageID = 2");
            System.out.println("=============================================================================================================================================================================================================");
            pw.write("\n=============================================================================================================================================================================================================\n");
            
            System.out.println("UPDATED CUSTOMER:\n");
            pw.write("UPDATED CUSTOMERS:\n");
            System.out.println(header);
            pw.write(header + "\n");
            
            while (!resortQueue.isEmpty())
            {
                Resort rs = (Resort) resortQueue.dequeue();
            
                if (rs.getPackageID() == 2)
                {
                    System.out.println(rs.toString() + "[Free Breakfast(A)]");
                    pw.write(rs.toString() + "[Free Breakfast(A)]" + "\n");
                    count4++;
                }
            
                tempQueue.enqueue(rs);
            }
            
            while (!tempQueue.isEmpty())
            {
                    resortQueue.enqueue(tempQueue.dequeue());
            }
        
            System.out.println("\nNumber of Customers: " + count4);
            pw.write("\nNumber of Customers: " + count4 + "\n");
            
            //Display list of customers Q5
            
            System.out.println("\n\n\n=================================================================================================================================================================================");
            pw.write("\n=================================================================================================================================================================================\n");
            System.out.println("\t\t\t\t\tAll Chilla Resort Customers Records in Queue");
            pw.write("\t\t\t\t\t\tAll Resort Customers Records in Queue");
            System.out.println("=================================================================================================================================================================================");
            pw.write("\n=================================================================================================================================================================================\n");
        
            System.out.println(header);
            pw.write(header + "\n");
            
            while(!resortQueue.isEmpty())
            {
               Resort rs = (Resort)resortQueue.dequeue();
               temp.enqueue(rs);
               System.out.println(rs.toString() + "\n");
               pw.write(rs.toString() + "\n");
            }
        
            while(!temp.isEmpty())
            {
               resortQueue.enqueue(temp.dequeue());
            }
            
            System.out.println("\nNumber of Customers: " + count);
            pw.write("\nNumber of Customers: " + count + "\n");
            
            //Question 5: Remove records for customers that paymentMethod = ‘DuitNow’
            Queue tempQue = new Queue();
            int countR = 0, countL = 0;
            double total = 0;
        
            System.out.println("\n\nQUESTION 5: REMOVE RECORDS FOR CUSTOMERS THAT DUITNOW AS PAYMENT METHOD AND CALCULATE TOTAL PAYMENT FOR ON LIST CUSTOMERS");
            pw.write("\n\nQUESTION 5: REMOVE RECORDS FOR CUSTOMERS THAT DUITNOW AS PAYMENT METHOD AND CALCULATE TOTAL PAYMENT FOR ON LIST CUSTOMERS\n");
            
            System.out.println("\n\n=================================================================================================================================================================================");
            pw.write("\n=================================================================================================================================================================================\n");
            System.out.println("\t\t\t\t\tRemoving records for customers with paymentMethod = 'DuitNow' and calculate total payment for on list customers");
            pw.write("\t\t\t\t\tRemoving records for customers with paymentMethod = 'DuitNow' and calculate total payment for on list customers");
            System.out.println("=================================================================================================================================================================================");
            pw.write("\n=================================================================================================================================================================================\n");
        
            System.out.println("REMOVED CUSTOMERS:\n");
            pw.write("REMOVED CUSTOMERS:\n");
            System.out.println(header);
            pw.write(header + "\n");
            
            while (!resortQueue.isEmpty())
            {
                Resort rs = (Resort) resortQueue.dequeue();
            
                if(rs.getPaymentMethod().equalsIgnoreCase("DuitNow"))
                {
                    System.out.println( rs.toString());
                    pw.write( rs.toString() + "\n");
                    countR++;
                }
                else 
                {
                tempQue.enqueue(rs);
                }
            }
            
            System.out.println("\n\nNumber of Customers: " + countR); 
            pw.write("\nNumber of Customers: " + countR + "\n");
            System.out.println("\n\nON LIST CUSTOMERS:\n");
            pw.write("\nON LIST CUSTOMERS:\n");
            System.out.println(header);
            pw.write(header + "\n");
            
            while (!tempQue.isEmpty())
            {
                Resort rs = (Resort) tempQue.getFirst();
                resortQueue.enqueue(tempQue.dequeue());
                System.out.println(rs.toString());
                pw.write(rs.toString() + "\n");
                countL++;
                total += rs.totalPayment();
            }
            System.out.println("\nNumber of Customers: " + countL);
            pw.write("\nNumber of Customers: " + countL + "\n");
            
            DecimalFormat df = new DecimalFormat("0.00");
            System.out.println("\nTotal payment for on list customers: RM" + df.format(total));
            pw.write("\nTotal payment for on list customers: RM" + df.format(total));
            
            pw.close();
        }catch (FileNotFoundException e){
            System.out.println("Error: File not Found");
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    
    }
}
