package remotemanagement;

import com.jcraft.jsch.Channel;
import com.remotemanagement.linuxCommands.RetreiveAllAgentsCommand;
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
public class RetreiveAllAgentsOnHost {
    private RetreiveAllAgentsCommand command;

    public String LoginToRemoteHost(String agentDirectory) {
        JschCommandExecutor b = new JschCommandExecutor(RemoteManagementWindow.remoteConnectionDetails);
        command = new RetreiveAllAgentsCommand(agentDirectory);
        return (b.execute(command).andReturnResult());
    }
}
