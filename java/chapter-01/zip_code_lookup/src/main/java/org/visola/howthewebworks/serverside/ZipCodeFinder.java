package org.visola.howthewebworks.serverside;

import java.util.List;
import java.util.Scanner;

import org.visola.howthewebworks.serverside.datareader.addressgroup.AddressGroup;

public class ZipCodeFinder {

    private final List<AddressGroup> addressGroups;
    private final Scanner scanner;

    public ZipCodeFinder(List<AddressGroup> addressGroups, Scanner scanner) {
        this.addressGroups = addressGroups;
        this.scanner = scanner;
    }

    public void findLoop() {
        System.out.print("Type a number: ");
        String number = scanner.nextLine();
        int recordNumber = 0;
        for (AddressGroup address : addressGroups) {
            if (address.getZipCode().contains(number)) {
                recordNumber++;
                System.out.printf("Found %s with zipcode %s\n", address.getStreet(), address.getZipCode());
                if (recordNumber % 10 == 0) {
                    System.out.printf("\nRecords printed so far: %d\n", recordNumber);
                    System.out.print("- Press Enter to Continue or type S (or s) to leave > ");
                    String input = scanner.nextLine();
                    if ("S".equalsIgnoreCase(input)) {
                        System.out.println();
                        break;
                    }
                }
            }
        }
    }

}
