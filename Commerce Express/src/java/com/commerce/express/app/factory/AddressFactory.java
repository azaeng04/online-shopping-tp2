/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.app.factory;

import com.commerce.express.domain.Address;
import java.util.Map;

/**
 *
 * @author cna canal walk
 */
public class AddressFactory {

    public static Address getAddress(Map<String, String> values) {
        Address address = new Address();
        address.setPostalAddress(values.get("postalAddress"));
        address.setPhysicalAddress(values.get("physicalAddress"));
        address.setPostalCode(values.get("postalCode"));
        return address;
    }
}
