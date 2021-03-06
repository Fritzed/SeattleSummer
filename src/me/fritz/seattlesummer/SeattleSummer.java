package me.fritz.seattlesummer;

import java.util.logging.Logger;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/** Main SeattleSummer Class
 *  
 * @Author Fritz
 * @version 1.5.1
 */
public class SeattleSummer extends JavaPlugin{

    /**
     * Config object
     */
    public SeattleSummerConfigHandler config;
    private SeattleSummerWeatherListener weatherListener = new SeattleSummerWeatherListener(this);
    static final Logger log = Logger.getLogger("Minecraft");

    /** Called when the plugin is enabled
     */
    @Override
    public void onEnable() {
        config = new SeattleSummerConfigHandler(this);

        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvent(Event.Type.WEATHER_CHANGE, weatherListener, Event.Priority.Normal, this);

        log.info("[SeattleSummer] plugin enabled.");
    }

    /** Called when the plugin is disabled
     */
    @Override
    public void onDisable() {
        log.info("[SeattleSummer] plugin disabled.");
    }
}