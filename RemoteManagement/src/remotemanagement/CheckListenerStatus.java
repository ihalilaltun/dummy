package remotemanagement;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.remotemanagement.dbContext.ContextHistory;
import com.remotemanagement.dbContext.XML2Obj;
import com.remotemanagement.linuxCommands.CheckSelectedListenerCommand;
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
public class CheckListenerStatus {

    private CheckSelectedListenerCommand command;

    public String ListenerStatus(String directory, String agentNo)
            throws Exception {
        JschCommandExecutor b = new JschCommandExecutor(RemoteManagementWindow.remoteConnectionDetails);
        command = new CheckSelectedListenerCommand(directory, agentNo);
        return b.execute(command).andReturnResult();
    }
}
