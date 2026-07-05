package net.kaleidoscope.cookery.util;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

public final class TeleportUtils {
    private static final boolean FOLIA = detectFolia();

    private TeleportUtils() {}

    public static void teleport(Entity entity, Location location) {
        if (FOLIA) {
            entity.teleportAsync(location);
        } else {
            entity.teleport(location);
        }
    }

    private static boolean detectFolia() {
        try {
            Class.forName("io.papermc.paper.threadedregions.RegionizedServer");
            return true;
        } catch (ClassNotFoundException ignored) {
            return false;
        }
    }
}
