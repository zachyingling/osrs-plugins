package com.3tickaction;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class 3TickActionPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(3TickActionPlugin.class);
		RuneLite.main(args);
	}
}