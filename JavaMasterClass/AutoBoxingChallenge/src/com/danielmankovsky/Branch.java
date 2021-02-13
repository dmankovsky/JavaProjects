package com.danielmankovsky;

import java.util.ArrayList;

public class Branch {
        private String branchName;
        private ArrayList<Customer> customers;

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public Branch(String branchName) {
        this.branchName = branchName;
        this.customers = new ArrayList<Customer>();
    }

    public String getBranchName() {
        return branchName;
    }

    public boolean newCustomer (String customerName, double initialAmount){ //boolean: if we pass a name of a customer already on file, will return false
        if (findCustomer(customerName)==null){
            this.customers.add(new Customer(customerName,initialAmount));
            return true;
        }
        return false;
    }

    public boolean addCustomerTransaction(String customerName, double amount){
        Customer existingCustomer = findCustomer(customerName);
        if (existingCustomer!=null){
            existingCustomer.addTransaction(amount);
            return true;
        }
        return false;
    }


    private Customer findCustomer(String customerName){ //make sure, this one is private
        for (int i =0; i<this.customers.size();i++){
            Customer checkedCustomer = this.customers.get(i);
            if (checkedCustomer.getName().equals(customerName)){
                return checkedCustomer;
            }
        }
        return null;
    }

}
