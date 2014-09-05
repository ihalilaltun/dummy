package remotemanagement;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.remotemanagement.dbContext.ContextHistory;
import com.remotemanagement.dbContext.XML2Obj;
import com.remotemanagement.linuxCommands.StartSelectedListenerCommand;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.grep4j.core.command.linux.JschCommandExecutor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author cooper
 */
public class StartSelectedListener {

    private StartSelectedListenerCommand command;

    public String ListenerStatus(String directory, String agentNo) throws Exception {

        JschCommandExecutor b = new JschCommandExecutor(RemoteManagementWindow.remoteConnectionDetails);
        command = new StartSelectedListenerCommand(directory,agentNo);
        return (b.execute(command).andReturnResult());
    }

//        Connection conn = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        ContextHistory contextHistory;
//        String db_url;
//        String db_user;
//        String db_pass;
//
//        try {
//            contextHistory = new ContextHistory();
//            contextHistory
//                    = ((ContextHistory) XML2Obj.xmlReadRoot(new ContextHistory(),
//                            ".contextHistory"));
//            db_url = contextHistory.getUrl();
//            db_user = contextHistory.getUsername();
//            db_pass = CryptUtil.decrypt(contextHistory.getPassword());
//            conn = DriverManager.getConnection(db_url, db_user, db_pass);
////            conn = DriverManager.getConnection(SqlDaoCreditentials.DB_URL, SqlDaoCreditentials.DB_USER_NAME, SqlDaoCreditentials.DB_PASS);
//            ps = conn.prepareStatement(RETREIVE_QUERY);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                user = rs.getString(1);
//                password = CryptUtil.decrypt(rs.getString(2));
//                host = rs.getString(3);
//                directory = rs.getString(4);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            java.util.Properties config = new java.util.Properties();
//            config.put("StrictHostKeyChecking", "no");
//            JSch jsch = new JSch();
//            //Session session = jsch.getSession(user, a.getListenerHostsFromDB().get(0).split("#")[0], 22);
//            //System.out.println(a.getListenerHostsFromDB().get(0).split("#")[1]);
//            Session session = jsch.getSession(user, host, 22);
//            session.setPassword(password);
//            session.setConfig(config);
//            session.connect();
//            System.out.println("Connected");
//
//            Channel channel = session.openChannel("exec");
////			((ChannelExec) channel)
////			.setCommand("cd " + a.getListenerHostsFromDB().get(0).split("#")[1] + "/" + "&&" + "sh checkEvamAgent.sh 0");
////			((ChannelExec) channel)
////			.setCommand("sh checkEvamAgent.sh 0");
//
//            ((ChannelExec) channel)
//                    .setCommand("cd " + directory + "/" + "&&" + "sh startEvamAgent.sh " + agentNo);
////			((ChannelExec) channel)
////			.setCommand(EngineCommands.CHECK_ENGINE);
//            channel.setInputStream(null);
//            ((ChannelExec) channel).setErrStream(System.err);
//
//            InputStream in = channel.getInputStream();
//            channel.connect();
//            byte[] tmp = new byte[1024];
//            while (true) {
//                while (in.available() > 0) {
//                    int i = in.read(tmp, 0, 1024);
//                    if (i < 0) {
//                        break;
//                    }
//                    System.out.print(new String(tmp, 0, i));
//                    response = new String(tmp, 0, i);
//                }
//                if (channel.isClosed()) {
//                    System.out.println("exit-status: "
//                            + channel.getExitStatus());
//                    break;
//                }
//                try {
//                    Thread.sleep(1000);
//                } catch (Exception ee) {
//                }
//            }
//            channel.disconnect();
//            session.disconnect();
////			System.out.println("There are " + listenerCount
////					+ " listeners running!");
////			System.out.println("DONE");
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            conn.close();
//            ps.close();
//            rs.close();
//        }
//
//        return response;
//    }
}
