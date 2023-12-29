package io.github.lucystudio.lucycorebungee.event

import io.github.lucystudio.lucycorebungee.Main
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerCommandPreprocessEvent

class OnCommand: Listener {

    @EventHandler
    fun onCommand(event: PlayerCommandPreprocessEvent) {
        if (Main.commandCooldown.containsKey(event.player.uniqueId.toString())){
            event.isCancelled = true
            event.player.sendMessage(Main.instance.config.getString("messages.prefix").toString() + " " + Main.instance.config.getString("messages.cannot_use_message").toString())
        }
    }
}