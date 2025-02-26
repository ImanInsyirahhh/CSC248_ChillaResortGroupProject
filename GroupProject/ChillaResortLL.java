import java.util.Comparator;
import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;
import java.text.DecimalFormat;

public class ChillaResortLL
{
  public static void main(String[] args) throws IOException
  {
      File inputFile = new File("resortCustomer.txt");
      PrintWriter pw = null;
      LinkedList <Resort> ResortLL = new LinkedList <>();
      LinkedList h = new LinkedList();
      try
      { 
          pw = new PrintWriter (new FileWriter("ChillaResortLLOutput.txt"));
          try (BufferedReader br = new BufferedReader(new FileReader (inputFile)))
          { 
              String line;
              while ((line = br.readLine()) != null)
              {
                  String delimiter= ",";
                  StringTokenizer st = new StringTokenizer(line,delimiter);
                  //read from s using st
                  String custName = st.nextToken();
                  String custEmail = st.nextToken();
                  String custPhone = st.nextToken();
                  int numOfCust = Integer.parseInt(st.nextToken());
                  int packageID = Integer.parseInt(st.nextToken());
                  double packagePrice = Double.parseDouble(st.nextToken());
                  char packageAddOn = (st.nextToken()).charAt(0); 
                  String paymentMethod = st.nextToken();
          
                  //Create a new Resort Object with the read data
                  Resort r = new Resort(custName, custEmail, custPhone, numOfCust, packageID, packagePrice, packageAddOn, paymentMethod);
                  //Insert the resort object into the linked list
                  ResortLL.insertAtBack(r);
              }
            }catch (FileNotFoundException e) {
                System.out.println("Error: File not Found");
            }catch (Exception e) {
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
            
            //Display data in the LinkedList
            int count = 0;
            LinkedList<Resort> temp = new LinkedList<>();
            System.out.println("\n\n=================================================================================================================================================================================");
            pw.write("\n=================================================================================================================================================================================\n");
            System.out.println("\t\t\t\t\tAll Chilla Resort Customers Records in LinkedList");
            pw.write("\t\t\t\t\t\tAll Resort Customers Records in LinkedList");
            System.out.println("=================================================================================================================================================================================");
            pw.write("\n=================================================================================================================================================================================\n");
        
            System.out.println(header);
            pw.write(header + "\n");
            
           while(!ResortLL.isEmpty())
           {
            Resort rs = (Resort)ResortLL.getFirst();
            temp.insertAtBack(ResortLL.removeFromFront());
            count++;
            System.out.println(rs.toString() + "\n");
            pw.write(rs.toString() + "\n");
           }
           //restore data back to ResortLL
          while(!temp.isEmpty())
          {
            ResortLL.insertAtBack(temp.removeFromFront());
          }
          
          System.out.println("\nNumber of Customers: " + count);
          pw.write("\nNumber of Customers: " + count + "\n");

          //Question 1: Rearranging customers data based on customers name (custName)
          int llSize = ResortLL.size();
          Resort[] custArray = new Resort[llSize];
          LinkedList <Resort> t = new LinkedList<>();
          
          System.out.println("\n\nQUESTION 1: REARRANGING CUSTOMERS DATA BASED ON CUSTOMERS NAME");
          pw.write("\n\nQUESTION 1: REARRANGING CUSTOMERS DATA BASED ON CUSTOMERS NAME\n");
          
          //Transfer LL data to array
          for(int i = 0; i < llSize; i++)
          {
          custArray[i] = (Resort)ResortLL.removeFromFront();
          }
          
          //Sort array alphabetically by customer name
          for(int i = 0; i < custArray.length - 1; i++)
          {
              for(int j = 0; j < custArray.length - 1 - i; j++)
              {
                  if(custArray[j].getCustName().compareTo(custArray[j+1].getCustName()) > 0)
                  {
                  //swap
                  Resort tempR = custArray[j];
                  custArray[j] = custArray[j+1];
                  custArray[j+1] = tempR;
                  }
              }
          }
          
          //Transfer sorted customers into array
          LinkedList  sortedLL = new LinkedList();
          for (Resort customer : custArray) 
          {
            sortedLL.insertAtBack(customer);
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
          
          while(!sortedLL.isEmpty())
          {
            Resort rs = (Resort)sortedLL.removeFromFront();
            System.out.println(rs.toString());
            pw.write(rs.toString() + "\n");
            temp.insertAtBack(rs);
          }
          
          while(!temp.isEmpty())
          {
              ResortLL.insertAtBack(temp.removeFromFront());
          }
          
          System.out.println("\nNumber of Customers: " + count);
          pw.write("\nNumber of Customers: " + count + "\n");
          
          //Display list of customers Q2
            
          System.out.println("\n\n=================================================================================================================================================================================");
          pw.write("\n=================================================================================================================================================================================\n");
          System.out.println("\t\t\t\t\tAll Chilla Resort Customers Records in LinkedList");
          pw.write("\t\t\t\t\t\tAll Resort Customers Records in LinkedList");
          System.out.println("=================================================================================================================================================================================");
          pw.write("\n=================================================================================================================================================================================\n");
        
          System.out.println(header);
          pw.write(header + "\n");
          
          while(!ResortLL.isEmpty())
          {
            Resort rs = (Resort)ResortLL.removeFromFront();
            temp.insertAtBack(rs);
            System.out.println(rs.toString() + "\n");
            pw.write(rs.toString() + "\n");
          }
          
          while(!temp.isEmpty())
          {
            ResortLL.insertAtBack(temp.removeFromFront());
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
          LinkedList <Resort> templ = new LinkedList();
          int count2 = 0;
            
          System.out.println(header);
          pw.write(header + "\n");
          
          while (!ResortLL.isEmpty()) 
          {
            Resort rs = ResortLL.removeFromFront();
            if (rs.getNumOfCust() > 3) 
            {
              System.out.println(rs.toString());
              pw.write(rs.toString() + "\n");
              count2++;
            }
            templ.insertAtBack(rs);
          } 

          while (!templ.isEmpty())
          {
            ResortLL.insertAtBack(templ.removeFromFront());
          }
          
          System.out.println("\nNumber of Customers: " + count2);
          pw.write("\nNumber of Customers: " + count2 + "\n");
          
          //Display list of customers Q3
            
          System.out.println("\n\n\n=================================================================================================================================================================================");
          pw.write("\n=================================================================================================================================================================================\n");
          System.out.println("\t\t\t\t\tAll Chilla Resort Customers Records in LinkedList");
          pw.write("\t\t\t\t\t\tAll Resort Customers Records in LinkedList");
          System.out.println("=================================================================================================================================================================================");
          pw.write("\n=================================================================================================================================================================================\n");
        
          System.out.println(header);
          pw.write(header + "\n");
          
          while(!ResortLL.isEmpty())
          {
            Resort rs = (Resort)ResortLL.removeFromFront();
            temp.insertAtBack(rs);
            System.out.println(rs.toString() + "\n");
            pw.write(rs.toString() + "\n");
          }
        
          while(!temp.isEmpty())
          {
            ResortLL.insertAtBack(temp.removeFromFront());
          }
            
          System.out.println("\nNumber of Customers: " + count);
          pw.write("\nNumber of Customers: " + count + "\n");
          
          //Question 3: Calculate total amount of people who booking each package (1- Deluxe Double / 2 - Deluxe Twin)
          int totalDD = 0;
          int totalDT = 0;
          LinkedList <Resort> Temp = new LinkedList();
            
          while (!ResortLL.isEmpty())
          {
            Resort rs = (Resort) ResortLL.removeFromFront();
            Temp.insertAtBack(rs);
            
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
            ResortLL.insertAtBack(Temp.removeFromFront());
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
          System.out.println("\t\t\t\t\tAll Chilla Resort Customers Records in LinkedList");
          pw.write("\t\t\t\t\t\tAll Resort Customers Records in LinkedList");
          System.out.println("=================================================================================================================================================================================");
          pw.write("\n=================================================================================================================================================================================\n");
        
          System.out.println(header);
          pw.write(header + "\n");
          
          while(!ResortLL.isEmpty())
          {
               Resort rs = (Resort)ResortLL.removeFromFront();
               temp.insertAtBack(rs);
               System.out.println(rs.toString() + "\n");
               pw.write(rs.toString() + "\n");
          }
        
          while(!temp.isEmpty())
          {
            ResortLL.insertAtBack(temp.removeFromFront());
          }
          
          System.out.println("\nNumber of Customers: " + count);
          pw.write("\nNumber of Customers: " + count + "\n");
            
          //Question 4: Add packageAddOn for customers with packageID = ‘2’ to include “Breakfast” (A)
          LinkedList<Resort> tempLL = new LinkedList();
          int count4 = 0;
          
          System.out.println("\n\nQUESTION 4: ADD PACKAGE ADD-ON FOR CUSTOMERS WITH PACKAGE ID = '2' TO INCLUDE BREAKFAST(A)");
          pw.write("\n\nQUESTION 4: ADD PACKAGE ADD-ON FOR CUSTOMERS WITH PACKAGE ID = '2' TO INCLUDE BREAKFAST(A)\n");
            
          System.out.println("\n\n=================================================================================================================================================================================================================");
          pw.write("\n=================================================================================================================================================================================================================\n");
          System.out.println("\t\t\t\t\tAdd Package Add-On for customers with packageID = 2");
          pw.write("\t\t\t\t\tAdd Package Add-On for customers with packageID = 2");
          System.out.println("=================================================================================================================================================================================================================");
          pw.write("\n=================================================================================================================================================================================================================\n");
            
          System.out.println("UPDATED CUSTOMER:\n");
          pw.write("UPDATED CUSTOMERS:\n");
          System.out.println(header);
          pw.write(header + "\n");
          
          while (!ResortLL.isEmpty())
          {
            Resort rs = ResortLL.removeFromFront();
            
            if (rs.getPackageID() == 2)
            {
                System.out.println(rs.toString() + "\tFree Breakfast(A)");
                pw.write(rs.toString() + "\tFree Breakfast(A)");
                count4++;
            }
        
            tempLL.insertAtBack(rs);
          }   
        
          while (!tempLL.isEmpty())
          {
            ResortLL.insertAtBack(tempLL.removeFromFront());
          }
          
          System.out.println("\nNumber of Customers: " + count4);
          pw.write("\nNumber of Customers: " + count4 + "\n");
          
          //Display list of customers Q5
            
          System.out.println("\n\n\n=================================================================================================================================================================================");
          pw.write("\n=================================================================================================================================================================================\n");
          System.out.println("\t\t\t\t\tAll Chilla Resort Customers Records in LinkedList");
          pw.write("\t\t\t\t\t\tAll Resort Customers Records in LinkedList");
          System.out.println("=================================================================================================================================================================================");
          pw.write("\n=================================================================================================================================================================================\n");
        
          System.out.println(header);
          pw.write(header + "\n");
          
          while(!ResortLL.isEmpty())
          {
            Resort rs = (Resort)ResortLL.removeFromFront();
            temp.insertAtBack(rs);
            System.out.println(rs.toString() + "\n");
            pw.write(rs.toString() + "\n");
          }
        
          while(!temp.isEmpty())
          {
            ResortLL.insertAtBack(temp.removeFromFront());
          }
          
          System.out.println("\nNumber of Customers: " + count);
          pw.write("\nNumber of Customers: " + count + "\n");
            
          //Question 5: Remove records for customers that paymentMethod = ‘DuitNow’
          LinkedList<Resort> templl = new LinkedList();
          int countR = 0, countL = 0;
          double total = 0.0;
          
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
          
          while (!ResortLL.isEmpty())
          {
                Resort rs = (Resort) ResortLL.removeFromFront();
            
                if(rs.getPaymentMethod().equalsIgnoreCase("DuitNow"))
                {
                    System.out.println( rs.toString());
                    pw.write( rs.toString() + "\n");
                    countR++;
                }
                else 
                {
                templl.insertAtBack(rs);
                }
          }
          
          System.out.println("\n\nNumber of Customers: " + countR); 
          pw.write("\nNumber of Customers: " + countR + "\n");
          System.out.println("\n\nON LIST CUSTOMERS:\n");
          pw.write("\nON LIST CUSTOMERS:\n");
          System.out.println(header);
          pw.write(header + "\n");
            
          while (!templl.isEmpty())
          {
            Resort rs = (Resort) templl.removeFromFront();
            ResortLL.insertAtBack(rs);
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
      
      
      

