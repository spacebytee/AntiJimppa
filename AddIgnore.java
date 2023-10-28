package com.bytespacegames.teapotclient.Commands.impl;

import com.bytespacegames.teapotclient.Client;
import com.bytespacegames.teapotclient.Commands.Command;
import com.bytespacegames.teapotclient.Modules.Render.AntiJimppa;
import com.bytespacegames.teapotclient.Utils.ChatUtils;
import com.bytespacegames.teapotclient.Utils.ConfigUtils;

public class AddIgnore extends Command {

	public AddIgnore() {
		super("AddIgnore");
	}
	public void onCommandCalled(String[] args) {
		if (args.length < 2) {
			ChatUtils.displayClientMessage("You must specify a name to avoid.");
			return;
		}
		((AntiJimppa)Client.Instance.getModuleByName("AntiJimppa")).blockedNames.add(args[1]);
		ChatUtils.displayClientMessage("Avoiding all players who's names contain \"" + args[1] + "\".");
	}
}
