package org.visola.howthewebworks.serverside;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

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

        Map<String, List<AddressGroup>> groupsByZipCode = addressGroups.stream()
            .filter(a -> a.getZipCode().contains(number))
            .collect(Collectors.groupingBy(AddressGroup::getZipCode));

        System.out.printf("Found %d zipcodes with %s%n", groupsByZipCode.size(), number);

        if (groupsByZipCode.size() == 0) {
            System.out.println();
            return;
        }

        Optional<String> maybeExplore = printAndPickZipCode(groupsByZipCode);
        if (!maybeExplore.isPresent()) {
            System.out.println();
            return;
        }

        System.out.printf("Exploring %s%n%n", maybeExplore.get());
    }

    private Optional<String> printAndPickZipCode(Map<String, List<AddressGroup>> groupsByZipCode) {
        int total = 0;
        for (String zipCode : groupsByZipCode.keySet()) {
            int countInZipCode = groupsByZipCode.get(zipCode).size();
            total += countInZipCode;
            System.out.printf("- %d address groups in %s%n", countInZipCode, zipCode);
        }
        System.out.printf("%d total address groups found%n%n", total);

        System.out.println("Type a zipcode to explore or [Enter] to leave: ");
        String zipCode = scanner.nextLine();

        if (groupsByZipCode.containsKey(zipCode)) {
            return Optional.of(zipCode);
        }

        return Optional.empty();
    }

}
