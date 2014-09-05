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
public class TailSelectedListenerCommand implements ExecutableCommand {

    //tail -50  " + directory + "/log/evam.log" + getAgentNo()
    private static final String TAIL_COMMAND = "tail -50";
    private static final String BLANK = " ";
    private static final String LOG_DIR = "/log/evam.log";
    private final String directory;
    private final String agentNo;

    public TailSelectedListenerCommand(String directory, String agentNo) {
        this.directory = directory;
        this.agentNo = agentNo;
    }

    @Override
    public String getCommandToExecute() {
        StringBuilder command = new StringBuilder();
        command.append(TAIL_COMMAND);
        command.append(BLANK);
        command.append(directory);
        command.append(LOG_DIR);
        command.append(agentNo);

        return command.toString();
    }
}
