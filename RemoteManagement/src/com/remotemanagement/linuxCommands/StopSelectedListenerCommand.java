package com.remotemanagement.linuxCommands;

import org.grep4j.core.command.ExecutableCommand;

public class StopSelectedListenerCommand
        implements ExecutableCommand {

    private static final String CD_COMMAND = "cd";
    private static final String BLANK = " ";
    private static final String SEPERATOR = "/";
    private static final String CONNECTOR = "&&";
    private static final String STOP_COMMAND = "sh stopEvamAgent.sh";
    private final String directory;
    private final String agentNo;

    public StopSelectedListenerCommand(String directory, String agentNo) {
        this.directory = directory;
        this.agentNo = agentNo;
    }

    public String getCommandToExecute() {
        StringBuilder command = new StringBuilder();
        command.append(CD_COMMAND);
        command.append(BLANK);
        command.append(directory);
        command.append(SEPERATOR);
        command.append(CONNECTOR);
        command.append(STOP_COMMAND);
        command.append(BLANK);
        command.append(agentNo);

        return command.toString();
    }
}
