package com.commerce.express.app.factory;

import com.commerce.express.domain.Roles;

/**
 *
 * @author cna canal walk
 */
public class RolesFactory {

    private RolesFactory() {
    }

    public static Roles getRoles(String roleName, String description, String username) {
        Roles roles = new Roles();
        roles.setRoleName(roleName);
        roles.setDescription(description);
        roles.setUsername(username);
        return roles;
    }
}
