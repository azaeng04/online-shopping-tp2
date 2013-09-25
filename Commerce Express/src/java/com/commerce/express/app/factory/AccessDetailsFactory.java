/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.app.factory;

import com.commerce.express.domain.AccessDetails;
import com.commerce.express.domain.Roles;
import java.util.List;

/**
 *
 * @author cna canal walk
 */
public class AccessDetailsFactory {

    public static AccessDetails getAccessDetails(String userName, String password, Boolean enabled, List<Roles> roles) {
        AccessDetails accessDetails = new AccessDetails();
        accessDetails.setUsername(userName);
        accessDetails.setPassword(password);
        accessDetails.setEnabled(enabled);
        accessDetails.setRoles(roles);
        return accessDetails;
    }
}
