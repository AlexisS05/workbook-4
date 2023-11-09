package org.contract;

import org.dealership.Dealership;
import org.dealership.DealershipFileManager;

import java.io.*;
import java.util.ArrayList;

public class ContractFileManager {
    Dealership dealership;

    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        dealership = fileManager.getDealership();
    }

    public ArrayList<Contract> getContracts() {
        init();
        ArrayList<Contract> contracts = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader("contracts.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);
            String input;



        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return contracts;
    }

    public void saveContract(Contract contract) {
        try {
            FileWriter fileWriter = new FileWriter("contracts.csv", true);
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);

            // Need to pass contract param

            // bufWriter.append();
            bufWriter.close();

            System.out.println("Contract saved to file!");
        } catch (IOException e) {
            System.err.println("Error saving contract");
        }
    }
}