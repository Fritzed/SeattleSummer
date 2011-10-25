package me.fritz.seattlesummer;

import java.util.TimerTask;
import java.util.logging.Logger;

import org.bukkit.World;

/** Defines timer task to stop the storm in a given world.
 * 
 * @author Fritz
 *
 */
public class RainStopper extends TimerTask {

	private World world;
	Logger log = Logger.getLogger("Minecraft");
	
	/** Defines timer task to stop the storm in a given world.
	 * 
	 * @param target The world which the timer is started for.
	 */
	public RainStopper(World target) {
		world = target;
	}
	
	/** Called automatically when the timer completes count down
	 */
	public void run() {
		log.info("[SeattleSummer] Stopping Rain in world: " + world.getName());
		world.setStorm(false);
	}

}