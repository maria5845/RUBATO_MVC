package com.ja.rubato.controller;

import java.util.HashMap;

import com.ja.rubato.controller.command.*;



public class CommandFactory {
	private HashMap<String, CommandHandler> commandMap;	
	public CommandFactory() {
		commandMap = new HashMap<String, CommandHandler>();
	    commandMap.put("/index.do", new IndexPageHandler());
	    commandMap.put("/board_list_page.do",new BoardListPageHandler());
	    commandMap.put("/join_member_page.do",new JoinMemberPageHandler());
        commandMap.put("/join_member_process.do",new JoinMemberProcessHandler()); 
        commandMap.put("/login_process_page.do",new LoginProcessHandler());
        commandMap.put("/logout_process_page.do", new LogoutProcessHandler());
        commandMap.put("/board_view_page.do",new BoardViewPageHandler());
        commandMap.put("/board_write_process.do",new BoardWriteProcessHandler());
        commandMap.put("/board_write_page.do", new BoardWritePageHandler());
        commandMap.put("/delete_content_process.do", new DeletContentProcessHandler()); 
	}

	public CommandHandler getCommandHandler(String command) {
		return commandMap.get(command);
	}
}

