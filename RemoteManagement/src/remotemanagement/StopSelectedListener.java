package remotemanagement;

import com.remotemanagement.linuxCommands.StopSelectedListenerCommand;
import org.grep4j.core.command.linux.CommandExecutor;
import org.grep4j.core.command.linux.JschCommandExecutor;

public class StopSelectedListener {

    private StopSelectedListenerCommand command;

    public String ListenerStatus(String directory, String agentNo)
            throws Exception {
        JschCommandExecutor b = new JschCommandExecutor(RemoteManagementWindow.remoteConnectionDetails);
        command = new StopSelectedListenerCommand(directory, agentNo);
        return b.execute(command).andReturnResult();
    }
}
