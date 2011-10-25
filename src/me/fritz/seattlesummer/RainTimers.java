package me.fritz.seattlesummer;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

import org.bukkit.World;

/** Maintains list of timers for each world
 *
 * @author Fritz
 *
 */
public class RainTimers {
	
	private static SeattleSummer plugin;
	private Map<String,Timer> timers = new HashMap<String,Timer>();
	
	/** Maintains list of timers for each world
	* 
	* @param instance the main SeattleSummer instance.
	*/
	public RainTimers (SeattleSummer instance) {
		plugin = instance;
	}
	
	/** Starts timer for the given world
	 * 
	 * @param world targeted world
	 */
	public void start(World world) {
		timers.put(world.getName(), new Timer());
		timers.get(world.getName()).schedule(new RainStopper(world),plugin.config.rainDuration());
	}
	
	/** Stops timer for the given world, if one exists
	 * 
	 * @param world targeted world
	*/
	public void cancel(World world) {
		if(timers.containsKey(world.getName())) {
			timers.get(world.getName()).cancel();
		}
	}
	
}
