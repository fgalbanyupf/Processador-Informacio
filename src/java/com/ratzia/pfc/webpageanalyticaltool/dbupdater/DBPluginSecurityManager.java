/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ratzia.pfc.webpageanalyticaltool.dbupdater;

import java.security.Permission;
//http://stackoverflow.com/questions/3947558/java-security-sandboxing-plugins-loaded-via-urlclassloader
/**
 *
 * @author frans
 */
public class DBPluginSecurityManager extends SecurityManager {
    private boolean _sandboxed; 

    @Override
    public void checkPermission(Permission perm, Object context) {
        check(perm, context);
    }

    private void check(Permission perm, Object context) {
        if (!_sandboxed) {
            return;
        }
        System.out.println("Classe*****");
        System.out.println(perm.getClass());
        System.out.println("OBJ*****");
        System.out.println(context.getClass());
        // I *could* check FilePermission here, but why doesn't
        // URLClassLoader handle it like it says it does?

        //throw new SecurityException("Permission denied");
    }

    void enableSandbox() {
    _sandboxed = true;
    }

    void disableSandbox() {
        _sandboxed = false;
    }
}
