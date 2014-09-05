/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.remotemanagement.dbContext;

import remotemanagement.CryptUtil;

/**
 *
 * @author cooper
 */
public class XMLTest {

    private static ContextHistory contextHistory;

    public static void main(String args[]) throws Exception {
        contextHistory = new ContextHistory();
        contextHistory.setLastContext("deneme");
        contextHistory.setUsername("cumali");
        contextHistory.setPassword(CryptUtil.encrypt("evam"));
        contextHistory.setUrl("url_denemesi");
        XML2Obj.xmlWriterRoot(contextHistory,
                ".contextHistory");
        contextHistory
                = ((ContextHistory) XML2Obj.xmlReadRoot(new ContextHistory(),
                        ".contextHistory"));
        System.out.println(contextHistory.getUsername());
        System.out.println(CryptUtil.decrypt(contextHistory.getPassword()));
        System.out.println(contextHistory.getUrl());
    }

}
