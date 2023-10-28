package com.bytespacegames.teapotclient.Modules.Render;

import java.util.ArrayList;
import java.util.List;

import com.bytespacegames.teapotclient.Events.Event;
import com.bytespacegames.teapotclient.Events.listeners.EventRecieveChat;
import com.bytespacegames.teapotclient.Events.listeners.EventUpdate;
import com.bytespacegames.teapotclient.Modules.Category;
import com.bytespacegames.teapotclient.Modules.Module;
import com.bytespacegames.teapotclient.Modules.Settings.BoolSetting;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class AntiJimppa extends Module {
	public List<String> blockedNames = new ArrayList<String>();
	public BoolSetting blockMessages = new BoolSetting("Block Messages", true);
	public AntiJimppa() {
		super("AntiJimppa", Category.RENDER);
		this.addSetting(blockMessages);
		blockedNames.add("Jimppa");
	}
	public void onEvent(Event e) {
		if (e instanceof EventRecieveChat) {
			if (!blockMessages.enabled) {
				return;
			}
			for (String name : blockedNames) {
				if (((EventRecieveChat) e).getMessage().contains(name)) {
					e.setCancelled(true);
				}
			}
		}
		if (e instanceof EventUpdate) {
			Entity toRemove = null;
			for (Entity entity : new ArrayList<Entity>(mc.theWorld.loadedEntityList)) {
				for (String name : blockedNames) {
					if (entity instanceof EntityPlayer && entity.getDisplayName().getUnformattedText().contains(name)) {
						mc.theWorld.removeEntityFromWorld(entity.getEntityId());
					}
				}
			}
		}
	}
}
