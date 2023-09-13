package io.th0rgal.oraxen.mechanics.provided.farming.bigmining;

import io.th0rgal.oraxen.mechanics.Mechanic;
import io.th0rgal.oraxen.mechanics.MechanicFactory;
import io.th0rgal.oraxen.utils.timers.Timer;
import io.th0rgal.oraxen.utils.timers.TimersFactory;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

public class BigMiningMechanic extends Mechanic {

    private final int radius;
    private final int depth;
    private final TimersFactory timersFactory;

    public BigMiningMechanic(MechanicFactory mechanicFactory, ConfigurationSection section) {
        super(mechanicFactory, section);
        radius = section.getInt("radius");
        depth = section.getInt("depth");

        this.timersFactory = new TimersFactory(section.isInt("cooldown") ? section.getInt("cooldown") : 0);
    }

    public int getRadius() {
        return this.radius;
    }

    public int getDepth() {
        return this.depth;
    }

    public Timer getTimer(Player player) {
        return timersFactory.getTimer(player);
    }
}