/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.remotemanagement.dbContext;

/**
 *
 * @author cooper
 */
public class StaticMapTest {
    public static void main(String args[]) {
        SqlDaoCreditentialsFromHistory a = new SqlDaoCreditentialsFromHistory();
        System.out.println(a.dbCreditentialsMap.get("dbUrl"));
        System.out.println(a.dbCreditentialsMap.get("dbUser"));
        System.out.println(a.dbCreditentialsMap.get("dbPassword"));
        
        
//        System.out.println(a.getMap().get("dbUrl"));
//        System.out.println(a.getMap().get("dbUrl"));
        
    }
    
}
