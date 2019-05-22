package org.visola.howthewebworks.serverside;

public class AddressGroup {

    private final String zipCode;
    private final String street;

    public AddressGroup(String [] values) {
        this.street = values[3];
        this.zipCode = values[8];
    }

}