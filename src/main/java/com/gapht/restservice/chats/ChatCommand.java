package com.gapht.restservice.chats;


import org.jboss.logging.Logger;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;


@ShellComponent
public class ChatCommand {
    Logger log = Logger.getLogger(ChatCommand.class.getName());    
    
    @ShellMethod(key = "start-chat", value = "conversation starter")    
    public void ssh(@ShellOption(value = "-s") String text)    
    {    
        log.info(text);    
	} 
}
