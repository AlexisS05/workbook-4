package org.contract;

import org.dealership.Dealership;
import org.dealership.DealershipFileManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
}