package org.visola.howthewebworks.serverside;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.visola.howthewebworks.serverside.datareader.CSVReader;
import org.visola.howthewebworks.serverside.datareader.DataFile;

public class ZipCodeLookupMain {

    public static void main (String [] args) throws IOException {
        List<AddressGroup> addressGroups = readAddressGroups();
    }

    private static List<AddressGroup> readAddressGroups() throws IOException {
        long start = System.currentTimeMillis();

        DataFile dataFile = new DataFile("city_of_boston.csv");
        FileReader fileReader = new FileReader(dataFile.getFile());

        List<AddressGroup> result = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(fileReader)) {
            String [] values;
            while ( (values = csvReader.readRecord()) != null ) {
                result.add(new AddressGroup(values));
            }
        }

        System.out.printf("Read zip codes in %dms\n", System.currentTimeMillis() - start);
        return result;
    }

}
