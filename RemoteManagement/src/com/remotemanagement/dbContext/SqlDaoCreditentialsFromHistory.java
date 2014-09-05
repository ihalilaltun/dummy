/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.remotemanagement.dbContext;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import remotemanagement.CryptUtil;

public class SqlDaoCreditentialsFromHistory {

    public final Map<String, String> dbCreditentialsMap = createMap();
    public ContextHistory contextHistory;

    private Map<String, String> createMap() {
        try {
            Map result = new HashMap();
            contextHistory = new ContextHistory();
            contextHistory = ((ContextHistory) XML2Obj.xmlReadRoot(new ContextHistory(), ".contextHistory"));

            if ((contextHistory.getLastContext() != null) 
                    && (contextHistory.getLastContext().length() != 0) 
                    && (!contextHistory.getLastContext().isEmpty())) {
                result.put("dbUrl", contextHistory.getUrl());
                result.put("dbUser", contextHistory.getUsername());
                result.put("dbPassword", CryptUtil.decrypt(contextHistory.getPassword()));
            }

            return result;
        } catch (Exception ex) {
            Logger.getLogger(SqlDaoCreditentialsFromHistory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
