package org.visola.howthewebworks.serverside.datareader.addressgroup;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.visola.howthewebworks.serverside.datareader.CSVReader;
import org.visola.howthewebworks.serverside.datareader.DataFile;

public class AddressGroupReader {

    private final DataFile dataFile;

    public AddressGroupReader(String dataFile) throws IOException {
        this.dataFile = new DataFile(dataFile);
    }  

    public List<AddressGroup> readAddressGroups() throws IOException {
        long start = System.currentTimeMillis();
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