
package salarydeductions;

import java.text.DecimalFormat;
import java.util.Scanner;


public class SalaryDeductions {

    
    public static void main(String[] args) {
        // TODO code application logic here
        int empNum = 0;
        double monthlySalary = 0.0;
        int empAge = 0;
        double pensionContribution;
        double unEmploymentContribution;
        double totDeductions;
        
        
        
        Scanner input = new Scanner(System.in);
        DecimalFormat dcFormater = new DecimalFormat("#####.##");
        
        System.out.print("Enter the employee number: ");
        empNum = input.nextInt();
        
        while(empNum != -1){
            System.out.print("Enter the monthly salary of employee: R");
            monthlySalary = input.nextDouble();
            
            System.out.print("Enter the age of the employee: ");
            empAge = input.nextInt();
            
            
            pensionContribution = pensionContribution(monthlySalary, empAge);
            unEmploymentContribution = unemploymentContribution(monthlySalary);
            
            totDeductions = totalDeductions(pensionContribution, unEmploymentContribution);
            
            System.out.println("The total deductions for employee number \"" + empNum + "\"" + " is R" + dcFormater.format(totDeductions));
            System.out.println("");
            System.out.print("Enter the employee number: ");
            empNum = input.nextInt();
            
        }
        System.out.println("Programm terminated");
               
        
    }
    
    public static double pensionContribution(double monSalary,int age){
        double pensionFund = 0.0;
        
        if(age >= 18 && age <= 25){
            pensionFund = monSalary * (15.6/100);
        }else if(age >= 26 && age <= 35){
            pensionFund = monSalary * (12.5/100);
        }else if(age >= 36 && age <= 50){
            pensionFund = monSalary * (9.2/100);
        }else if(age >= 51){
            pensionFund = monSalary * (7.5/100);
        }
        
        return pensionFund;
    }
    
    public static double unemploymentContribution(double monSalary){
        double unempContribution = 0.0;
        unempContribution = monSalary * 0.01;
        return unempContribution;
    }
    
    public static double totalDeductions(double pensionFundContr, double unEmpIF){
        double totDeductions = 0.0;
        totDeductions = pensionFundContr + unEmpIF;
        return totDeductions;
    }
    
}
