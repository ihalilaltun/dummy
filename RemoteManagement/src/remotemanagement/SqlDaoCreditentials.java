package remotemanagement;

import com.remotemanagement.dbContext.ContextHistory;
import com.remotemanagement.dbContext.XML2Obj;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author cooper
 */
public class SqlDaoCreditentials {

    /**
     *
     */
    private ContextHistory contextHistory;

    public static String DB_URL;
    public static String DB_USER_NAME;
    public static String DB_PASS;

    public SqlDaoCreditentials() throws Exception {
        this.contextHistory = loadProps();
        SqlDaoCreditentials.DB_URL = loadProps().getUrl();
        SqlDaoCreditentials.DB_USER_NAME = loadProps().getUsername();
        SqlDaoCreditentials.DB_PASS = CryptUtil.decrypt(loadProps().getPassword());
    }

    public String dbUrl() throws Exception {
        this.contextHistory = loadProps();
        return loadProps().getUrl();
    }

    public String dbUser() throws Exception {
        this.contextHistory = loadProps();
        return loadProps().getUsername();
    }

    private ContextHistory loadProps() throws Exception {
        ContextHistory tmpContextHist = new ContextHistory();
        tmpContextHist = tmpContextHist
                = ((ContextHistory) XML2Obj.xmlReadRoot(new ContextHistory(),
                        ".contextHistory"));
        return tmpContextHist;
    }

}
