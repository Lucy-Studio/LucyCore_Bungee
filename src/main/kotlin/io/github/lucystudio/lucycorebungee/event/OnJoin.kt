package io.github.lucystudio.lucycorebungee.event

import io.github.lucystudio.lucycorebungee.Main
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class OnJoin: Listener {

    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        Main.commandCooldown[event.player.uniqueId.toString()] = 1
        Bukkit.getServer().scheduler.scheduleAsyncDelayedTask(Main.instance,
            { Main.commandCooldown.remove(event.player.uniqueId.toString()) }, (Main.instance.config.getInt("settings.cooldown_seconds") * 20).toLong()
        )
    }
}