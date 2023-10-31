package com.bytespacegames.teapotclient.Commands.impl;

import com.bytespacegames.teapotclient.Client;
import com.bytespacegames.teapotclient.Commands.Command;
import com.bytespacegames.teapotclient.Modules.Render.AntiJimppa;
import com.bytespacegames.teapotclient.Utils.ChatUtils;
import com.bytespacegames.teapotclient.Utils.ConfigUtils;

public class ListIgnore extends Command {

	public ListIgnore() {
		super("ListIgnore");
	}
	public void onCommandCalled(String[] args) {
		ChatUtils.displayClientMessage("------[ Blocked List ]------");
    for (String playerName : ((AntiJimppa)Client.Instance.getModuleByName("AntiJimppa")).blockedNames) {
      ChatUtils.displayClientMessage(playerName);
    }
		ChatUtils.displayClientMessage("----------------------------");
	}
}
