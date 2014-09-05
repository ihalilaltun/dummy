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
public class RetreiveAllAgentsCommand implements ExecutableCommand {

    private static final String LS_COMMAND = "ls";
    private static final String BLANK = " ";
    private static final String CONF_DIR="/conf";
    private final String directory;

    public RetreiveAllAgentsCommand(String directory) {
        this.directory = directory;
    }

    @Override
    public String getCommandToExecute() {
        StringBuilder command = new StringBuilder();
        command.append(LS_COMMAND);
        command.append(BLANK);
        command.append(directory);
        command.append(CONF_DIR);
        return command.toString();
    }

    public String getCommandToExecute(String directory) {
        //ls /appdata/evam/fileListener_3.1.6/conf
        StringBuilder command = new StringBuilder();
        command.append(LS_COMMAND);
        command.append(BLANK);
        command.append(directory);
        return command.toString();
    }

}
