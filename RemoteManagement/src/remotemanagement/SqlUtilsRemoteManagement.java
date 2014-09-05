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

public class SqlUtilsRemoteManagement {

    public static final String INSERT_QUERY = "INSERT INTO REMOTE_MANAGEMENT VALUES (?,?,?,?)";
    public static final String TRUNCATE_QUERY = "TRUNCATE TABLE REMOTE_MANAGEMENT";
    public static final String CREATE_QUERY = "CREATE TABLE REMOTE_MANAGEMENT(USERNAME VARCHAR2(100 BYTE),PASSWORD VARCHAR2(100 BYTE),HOST VARCHAR2(100 BYTE),DIRECTORY VARCHAR2(100 BYTE))";
    public static final String CHECK_QUERY = "SELECT COUNT(1) FROM ALL_TABLES WHERE TABLE_NAME = 'REMOTE_MANAGEMENT'";

    public void SaveUserCreditentialstoDb(String userName, String password, String host, String directory) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int tableCnt = -1;
        String db_url;
        String db_user;
        String db_pass;
        ContextHistory contextHistory;

        try {
            contextHistory = new ContextHistory();
            contextHistory
                    = ((ContextHistory) XML2Obj.xmlReadRoot(new ContextHistory(),
                            ".contextHistory"));
            db_url = contextHistory.getUrl();
            db_user = contextHistory.getUsername();
            db_pass = CryptUtil.decrypt(contextHistory.getPassword());
            conn = DriverManager.getConnection(db_url, db_user, db_pass);
//            conn = DriverManager.getConnection(SqlDaoCreditentials.DB_URL, SqlDaoCreditentials.DB_USER_NAME, SqlDaoCreditentials.DB_PASS);
            ps = conn.prepareStatement(CHECK_QUERY);
            rs = ps.executeQuery();
            while (rs.next()) {
                tableCnt = rs.getInt(1);
            }
            if (tableCnt == 0) {
                ps = conn.prepareStatement(CREATE_QUERY);
                rs = ps.executeQuery();
                conn.commit();
            } else {
                ps = conn.prepareStatement(TRUNCATE_QUERY);
                rs = ps.executeQuery();
                conn.commit();
            }
            ps = conn.prepareStatement(INSERT_QUERY);
            ps.setString(1, userName);
            ps.setString(2, CryptUtil.encrypt(password));
            ps.setString(3, host);
            ps.setString(4, directory);
            rs = ps.executeQuery();
            conn.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            ps.close();
            conn.close();
        }
    }

}
