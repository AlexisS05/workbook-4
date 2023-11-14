package org.contract;

import java.io.*;
import java.util.ArrayList;

public class ContractFileManager {

    public ArrayList<Contract> getContracts() {
        ArrayList<Contract> contracts = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader("contracts.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);
            String input;
            // Read files



        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return contracts;
    }

    public void saveContract(Contract contract) {
        try {
            FileWriter fileWriter = new FileWriter("contracts.csv", true);
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);

            // Call the @Override String from Sale and Lease Class
            bufWriter.write(contract.getContractString());
            bufWriter.close();
            System.out.println("Contract saved to file!");
        } catch (IOException e) {
            System.err.println("Error saving contract");
        }
    }
}