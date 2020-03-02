package controller;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.CustomerService;
import view.CustomerView;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CustomerController {

    @Autowired
    CustomerView view;
    @Autowired
    CustomerService customerService;

    public void runApp() {

        InputStream stream;
        try {
            // Fetch file with customers from resources folder
            stream = getCustomerFile("prospects.txt");
            if (stream != null) {
                ArrayList<Customer> customers = parseContent(stream);
                view.printCustomers(customers);
                for (Customer customer : customers) {
                    System.out.println("Adding prospect " + customer.getName() + " to database");
                    customerService.addCustomerToDatabase(customer);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: prospects.txt file not found. Exception: " + e.toString());
        } catch (UnsupportedEncodingException e) {
            System.out.println("Error: Unsupported charset. Exception: " + e.toString());
        } catch (IOException e) {
            System.out.println("Error: Could not read file. Exception: " + e.toString());
        }
    }

    /***
     * Find prospect.txt file and return it as a stream
     * @param fileName Name of the file inside resources folder
     * @return InputStream of the file
     * @throws FileNotFoundException if the specified file is not found in the resource folder
     */
    private InputStream getCustomerFile(String fileName) throws FileNotFoundException {
        try {
            return getClass().getClassLoader().getResourceAsStream("prospects.txt");
        } catch (NullPointerException e) {
            throw new FileNotFoundException();
        }
    }

    /***
     * Parses the InputStream and adds all customers found into a ArrayList
     * which is returned. If input contains double quotes, check string inside quotes for comma (,) operator
     * and replace with empty space (continue if no comma operator). When input is corrected, replace with original line.
     *
     * @param stream InputStream of customer data to be parsed
     * @return ArrayList of customers found inside the file
     * @throws IOException if unable to read file
     */
    public ArrayList<Customer> parseContent(InputStream stream) throws IOException {
        ArrayList<Customer> customers = new ArrayList<>();
        String charset = "UTF-8";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream, charset));
        bufferedReader.readLine(); // Skip header line
        for (String line; (line = bufferedReader.readLine()) != null;) { // Starts from line two
            if (!line.isEmpty()) {
                String name;
                double totalLoan;
                double interest;
                double years;
                Pattern pattern = Pattern.compile("\"([^\"]*)\""); // Regex for double finding double quotes
                Matcher matcher = pattern.matcher(line);
                StringBuffer buffer = new StringBuffer();

                // If input contains double quotes
                while (matcher.find()) {
                    String temp;
                    if (matcher.group(1).indexOf(",") > 0) { // If double quotes string contains comma
                        temp = matcher.group(1).replace(",", " ");
                    }
                    else {
                        temp = matcher.group(1);
                    }
                    matcher.appendReplacement(buffer, matcher.group(1).replaceFirst(Pattern.quote(matcher.group(1)), temp));
                }
                String revisedLine = matcher.appendTail(buffer).toString();
                String[] customerDetails = revisedLine.split(","); // Split input with every comma operator

                // Remove invalid input from text file
                if (customerDetails.length == 4) {
                    name = customerDetails[0];
                    totalLoan = Double.parseDouble(customerDetails[1]);
                    interest = Double.parseDouble(customerDetails[2]);
                    years = Double.parseDouble(customerDetails[3]);
                    Customer customer = new Customer(name, totalLoan, interest, years);
                    customers.add(customer);
                }
            }
        }
        return customers;
    }
}
