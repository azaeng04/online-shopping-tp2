/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.app.factory;

import com.commerce.express.domain.Roles;
import java.util.Map;

/**
 *
 * @author cna canal walk
 */
public class RolesFactory {

    public static Roles getRoles(Map<String, String> values) {
        Roles roles = new Roles();
        roles.setRoleName(values.get("roleName"));
        roles.setDescription(values.get("description"));
        roles.setUsername(values.get("userName"));
        return roles;
    }
}
