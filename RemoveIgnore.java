package com.bytespacegames.teapotclient.Commands.impl;

import com.bytespacegames.teapotclient.Client;
import com.bytespacegames.teapotclient.Commands.Command;
import com.bytespacegames.teapotclient.Modules.Render.AntiJimppa;
import com.bytespacegames.teapotclient.Utils.ChatUtils;
import com.bytespacegames.teapotclient.Utils.ConfigUtils;

public class RemoveIgnore extends Command {

	public RemoveIgnore() {
		super("RemoveIgnore");
	}
	public void onCommandCalled(String[] args) {
		if (args.length < 2) {
			ChatUtils.displayClientMessage("You must specify a name to unavoid.");
			return;
		}
    AntiJimppa module = ((AntiJimppa)Client.Instance.getModuleByName("AntiJimppa"));
		if (!(blockedNames.contains(args[1]))){
      ChatUtils.displayClientMessage("Player with username \"" + args[1] + "\" was not found in the ignore list.");
			return;
    }
		ChatUtils.displayClientMessage("Removed \"" + args[1] + "\" from ignore list.");
	}
}
