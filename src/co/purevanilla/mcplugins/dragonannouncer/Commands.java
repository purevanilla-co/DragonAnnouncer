package co.purevanilla.mcplugins.dragonannouncer;

import org.bukkit.Sound;
import com.connorlinfoot.titleapi.TitleAPI;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class Commands implements CommandExecutor
{
    public boolean onCommand(final CommandSender commandSender, final Command command, final String s, final String[] args) {

        final String username = args[0];
        final String rank = args[1];
        for (final Player player : Bukkit.getServer().getOnlinePlayers()) {
            new BukkitRunnable() {
                public void run() {
                    TitleAPI.sendTitle(player, 10, 800, 10, "&7&l" + username, "just bought &e&l" + rank);
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1.0f, 0.0f);
                }
            }.runTaskLater(Main.plugin, 1L);
            new BukkitRunnable() {
                public void run() {
                    TitleAPI.sendTitle(player, 10, 200, 10, "", "&7&lGet your rank here");
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 0.0f);
                }
            }.runTaskLater(Main.plugin, 200L);
            new BukkitRunnable() {
                public void run() {
                    TitleAPI.sendTitle(player, 10, 60, 10, "", "&ehttps://purevanilla.es/store");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 0.0f);
                }
            }.runTaskLater(Main.plugin, 280L);
        }

        return true;
    }
}
