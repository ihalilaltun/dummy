package remotemanagement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author cooper
 */
import com.remotemanagement.dbContext.ContextHistory;
import com.remotemanagement.dbContext.XML2Obj;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListenerHosts {

    private ContextHistory contextHistory;
    public static final String INSERT_QUERY = "select property_value from INT_GLOBAL_PROPERTIES where property_name = 'listenerHosts'";

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String hosts = null;
    String db_url;
    String db_user;
    String db_pass;

    public ArrayList<String> getListenerHostsFromDB() throws SQLException, Exception {
        contextHistory = new ContextHistory();
        contextHistory
                = ((ContextHistory) XML2Obj.xmlReadRoot(new ContextHistory(),
                        ".contextHistory"));
        db_url = contextHistory.getUrl();
        db_user = contextHistory.getUsername();
        db_pass = CryptUtil.decrypt(contextHistory.getPassword());
        conn = DriverManager.getConnection(db_url, db_user, db_pass);
        ps = conn.prepareStatement(INSERT_QUERY);

        rs = ps.executeQuery();
        while (rs.next()) {
            hosts = rs.getString(1);
        }

        ArrayList<String> array = new ArrayList<String>();
        String[] splittedArray = hosts.split(";");
        for (int i = 0; i < splittedArray.length; i++) {
            array.add(splittedArray[i]);
        }
        return array;
        //return hosts;
    }

    private static ArrayList<String> getHostsFromDb(String hosts) {
        ArrayList<String> array = new ArrayList<String>();
        String[] splittedArray = hosts.split(";");
        for (int i = 0; i < splittedArray.length; i++) {
            array.add(splittedArray[i]);
        }
        return array;
    }
}
