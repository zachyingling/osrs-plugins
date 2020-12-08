package net.runelite.client.plugins.threetickaction;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import org.pf4j.Extension;

@Extension
@PluginDescriptor(
	name = "3Tick Actions",
	description = "Does herb tar action",
	type = PluginType.MISCELLANEOUS
)
@Slf4j
public class ThreeTickPlugin extends Plugin
{
	// Injects our config
	@Inject
	private ThreeTickConfig config;

	@Inject
	private Client client;

	// Provides our config
	@Provides
	ThreeTickConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ThreeTickConfig.class);
	}

	@Override
	protected void startUp()
	{
		// runs on plugin startup
		log.info("Plugin started");

		// example how to use config items
		if (config.example())
		{
			// do stuff
			log.info("The value of 'config.example()' is ${config.example()}");
		}
	}

	@Override
	protected void shutDown()
	{
		// runs on plugin shutdown
		log.info("Plugin stopped");
	}

	@Subscribe
	private void onMenuOptionClicked(MenuOptionClicked event){
		log.info(event.getOption());
		if (event.getOption().equals("Use-rod")) log.info("fishing");
	}

	@Subscribe
	private void onGameTick(GameTick gameTick)
	{

	}

	public String isFishing(){
		return "fishing";
	}
}