package org.visola.howthewebworks.serverside.datareader;

import java.io.BufferedReader;
import java.io.StringReader;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CSVReaderTest {

    @Test
    public void testEmptyFile() throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(""));
        try (CSVReader csvReader = new CSVReader(reader)) {
            String [] record = csvReader.readRecord();
            assertThat(record).isNull();
        }
    }

    @Test
    public void testReadCSVWithHeader() throws Exception {
        StringBuilder data = new StringBuilder();
        data.append("id,name,age\n");
        data.append("1,John,10\n");
        data.append("2,Jane,20\n");
        data.append("3,Michael,30\n");
        data.append("4,Rachel,40\n");
        
        StringReader reader = new StringReader(data.toString());

        try (CSVReader csvReader = new CSVReader(reader)) {
            String [] header = csvReader.getHeader();
            assertThat(header[0]).isEqualTo("id");
            assertThat(header[1]).isEqualTo("name");
            assertThat(header[2]).isEqualTo("age");

            String [] record = null;
            int counter = 0;
            while ( (record = csvReader.readRecord()) != null ) {
                counter++;
                assertThat(record[0]).isEqualTo(Integer.toString(counter));
                assertThat(record[2]).isEqualTo(Integer.toString(counter * 10));
            }
        }
    }

    @Test
    public void testReadCSVWithNoHeader() throws Exception {
        StringBuilder data = new StringBuilder();
        data.append("1,John,10\n");
        data.append("2,Jane,20\n");
        data.append("3,Michael,30\n");
        data.append("4,Rachel,40\n");
        
        StringReader reader = new StringReader(data.toString());

        try (CSVReader csvReader = new CSVReader(reader, false)) {
            String [] record = null;
            int counter = 0;
            while ( (record = csvReader.readRecord()) != null ) {
                counter++;
                assertThat(record[0]).isEqualTo(Integer.toString(counter));
                assertThat(record[2]).isEqualTo(Integer.toString(counter * 10));
            }
        }
    }

}