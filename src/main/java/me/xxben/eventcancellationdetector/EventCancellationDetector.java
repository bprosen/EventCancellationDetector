package me.xxben.eventcancellationdetector;

import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class EventCancellationDetector extends JavaPlugin {

    /*
        To listen to another class, simple change the event in this array!
     */
    private Detector<BlockPlaceEvent> detector = new Detector<>(BlockPlaceEvent.class);

    @Override
    public void onEnable() {

        detector.addListener((plugin, event) -> getLogger().info(event + " cancelled by " + plugin));

        getLogger().info("EventCancellationDetector Enabled");
    }

    @Override
    public void onDisable() {

        detector.close();

        getLogger().info("EventCancellationDetector Disabled");
    }
}
