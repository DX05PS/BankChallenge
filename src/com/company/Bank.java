package com.company;

import java.util.ArrayList;

public class Bank {
    private String bankName;
    private ArrayList<Branch> branches;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.branches = new ArrayList<>();
    }

    public boolean addBranch(String branchName) {
        if (findBranch(branchName) == null) {
            branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double amount) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            branch.newCustomer(customerName, amount);
        }
        return false;
    }

    public boolean addTransaction(String branchName, String customerName, double amount) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            branch.addCustomerTransaction(customerName, amount);
        }
        return  false;
    }

    public Branch findBranch(String name) {
        for (int i = 0; i < branches.size(); i++) {
            Branch checkedBranch = branches.get(i);
            if (checkedBranch.getBranchName().toLowerCase().equals(name.toLowerCase())) {
                return checkedBranch;
            }
        }
        return null;
    }

    public boolean showBranchCustomers(String branchName, boolean showTransaction) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            System.out.println("Showing list of Customers for branch " + branch.getBranchName());
            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for (int i = 0; i < branchCustomers.size(); i++) {
                Customer customer = branchCustomers.get(i);
                System.out.println("Customer #" + (i + 1) + " --> " + customer.getCustomerName());
                if (showTransaction) {
                    ArrayList<Double> customerTransactions = customer.getTransactions();
                    for (int j = 0; j < customerTransactions.size(); j++) {
                        System.out.println((j + 1) + " - " + customerTransactions.get(j));
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
