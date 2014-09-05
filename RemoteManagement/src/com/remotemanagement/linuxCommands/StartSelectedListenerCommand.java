/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.remotemanagement.linuxCommands;

import org.grep4j.core.command.ExecutableCommand;

/**
 *
 * @author cooper
 */
public class StartSelectedListenerCommand implements ExecutableCommand {

    //"cd " + directory + "/" + "&&" + "sh startEvamAgent.sh " + agentNo
    private static final String CD_COMMAND = "cd";
    private static final String BLANK = " ";
    private static final String SEPERATOR = "/";
    private static final String CONNECTOR = "&&";
    private static final String START_COMMAND = "sh startEvamAgent.sh";
    private final String directory;
    private final String agentNo;

    public StartSelectedListenerCommand(String directory, String agentNo) {
        this.directory = directory;
        this.agentNo = agentNo;
    }

    @Override
    public String getCommandToExecute() {
        StringBuilder command = new StringBuilder();
        command.append(CD_COMMAND);
        command.append(BLANK);
        command.append(directory);
        command.append(SEPERATOR);
        command.append(CONNECTOR);
        command.append(START_COMMAND);
        command.append(BLANK);
        command.append(agentNo);

        return command.toString();
    }
}
