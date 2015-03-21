package com.commerce.express.app.factory;

import com.commerce.express.domain.AccessDetails;
import com.commerce.express.domain.Roles;
import com.commerce.express.service.general.encryption.PasswordEncrypt;
import java.util.List;

/**
 *
 * @author cna canal walk
 */
public class AccessDetailsFactory {

    private AccessDetailsFactory() {
    }

    public static AccessDetails getAccessDetails(String username, String password, Boolean enabled, List<Roles> roles) {
        AccessDetails accessDetails = new AccessDetails();
        accessDetails.setUsername(username);
        accessDetails.setPassword(PasswordEncrypt.encrypt(password));
        accessDetails.setEnabled(enabled);
        accessDetails.setRoles(roles);
        return accessDetails;
    }
}
