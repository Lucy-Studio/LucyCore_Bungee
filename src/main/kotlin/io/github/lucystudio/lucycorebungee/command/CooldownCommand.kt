package io.github.lucystudio.lucycorebungee.command

import io.github.lucystudio.lucycorebungee.Main
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class CooldownCommand: CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        return if (sender is Player) {
            if (sender.hasPermission(Main.instance.config.getString("permissions.cooldown_setting_command").toString())) {
                if (args?.get(0) != null) {
                    when (args[0]) {
                        "리로드" -> {
                            Main.instance.reloadConfig()
                            sender.sendMessage(Main.instance.config.getString("messages.prefix").toString() + " " + Main.instance.config.getString("messages.config_reload"))
                            true
                        } else -> {
                            sender.sendMessage(Main.instance.config.getString("messages.prefix").toString() + " " + Main.instance.config.getString("messages.incorrect_command"))
                            false
                        }
                    }
                } else {
                    sender.sendMessage(Main.instance.config.getString("messages.prefix").toString() + " " + Main.instance.config.getString("messages.incorrect_command"))
                    false
                }
            } else {
                sender.sendMessage(Main.instance.config.getString("messages.prefix").toString() + " " + Main.instance.config.getString("messages.no_permission"))
                false
            }
        } else {
            sender.sendMessage(Main.instance.config.getString("messages.prefix").toString() + " " + Main.instance.config.getString("messages.cannot_use_in_console").toString())
            return false
        }
    }
}