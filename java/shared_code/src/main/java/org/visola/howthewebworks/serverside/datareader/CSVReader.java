package org.visola.howthewebworks.serverside.datareader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class CSVReader implements AutoCloseable  {

    private final BufferedReader reader;
    private final String [] header;

    public CSVReader(Reader readFrom) throws IOException {
        this(readFrom, true);
    }

    public CSVReader(Reader readFrom, boolean hasHeader) throws IOException {
        if (readFrom instanceof BufferedReader) {
            this.reader = (BufferedReader) readFrom;
        } else {
            this.reader = new BufferedReader(readFrom);
        }

        if (hasHeader) {
            String firstLine = this.reader.readLine();
            if (firstLine != null) {
                header = firstLine.split(",");
            } else {
                header = new String[0];
            }
        } else {
            header = new String[0];
        }
    }

    public void close() throws IOException {
        this.reader.close();
    }

    public String[] getHeader() {
        return this.header;
    }

    public String[] readRecord() throws IOException {
        String line = this.reader.readLine();
        if (line == null) {
            return null;
        }

        return line.split(",");
    }

}