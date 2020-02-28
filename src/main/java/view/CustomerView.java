package view;

import model.Customer;

import java.util.ArrayList;

public class CustomerView {
    /***
     * Prints out the result of each customer in the ArrayList
     * @param customers ArrayList of customers to be printed
     */
    public void printCustomers(ArrayList<Customer> customers) {
        int counter = 1;
        for (Customer customer : customers) {
            System.out.println("*****************************************************************************************************");
            System.out.println("Prospect " + counter + " " + customer.getName() + " wants to borrow "
                    + customer.getTotalLoan() + "€ for a period of "
                    + customer.getYears() + " years and pay " + customer.getMonthlyPayment() + "€ each month.");
            System.out.println("*****************************************************************************************************");
            counter++;
        }
    }
}
