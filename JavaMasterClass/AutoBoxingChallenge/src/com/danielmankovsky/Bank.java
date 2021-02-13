package com.danielmankovsky;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Branch> branches = new ArrayList<Branch>();

    public boolean addBranch (String branchName){
        if (findBranch(branchName)==null){
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomerToBranch (String customerName, String branchName, double amount){
        Branch checkedBranch = findBranch(branchName);
        if (checkedBranch!=null){
            System.out.println(customerName + branchName + amount);
            return checkedBranch.newCustomer(customerName,amount);
        }
        return false;
    }

    public boolean addTransactionToCustomer (String customerName, String branchName, double amount){
        for (int i = 0; i < branches.size();i++){
            if (branches.get(i).getBranchName()==branchName){
            branches.get(i).addCustomerTransaction(customerName,amount);
            return true;
            }
        }
        return false;
    }

    public boolean listCustomersOfBranch (String branchName, boolean showTransactions){
        Branch checkedBranch = findBranch(branchName);
        //checkedBranch = new Branch(findBranch(branchName));
        if (checkedBranch!=null){
            System.out.println("Customer details for branch " + checkedBranch.getBranchName());

            ArrayList<Customer> branchCustomers = checkedBranch.getCustomers();

            for (int i = 0; i < branchCustomers.size();i++){
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer: " + branchCustomer.getName() + "[" + (i+1) + "]");
                if (showTransactions){
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for (int j = 0; j< transactions.size();j++){
                        System.out.println("[" + (j+1) + "] Amount " + transactions.get(j));
                    }
                }
            }
            return true;
            } else {
            return false;
        }
    }

    private Branch findBranch(String branchName){
        for (int i =0; i<branches.size();i++){
            Branch checkedBranch = this.branches.get(i);
            if (checkedBranch.getBranchName().equals(branchName)){
                return checkedBranch;
            }
        }
        return null;
    }



    //addBranch
    //addCustomerToBranch with initial transaction
    //addTransaction for existing customer for that branch
    //show list of customers for a particular branch and optionally a list of their transactions
}
