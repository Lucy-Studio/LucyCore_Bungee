package io.github.lucystudio.lucycorebungee

import io.github.lucystudio.lucycorebungee.command.CooldownCommand
import io.github.lucystudio.lucycorebungee.command.CooldownTab
import io.github.lucystudio.lucycorebungee.event.OnCommand
import io.github.lucystudio.lucycorebungee.event.OnJoin
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin


class Main: JavaPlugin() {
    // MAIN INSTANCE
    companion object{
        lateinit var instance: Main

        var commandCooldown = HashMap<String, Int>()
    }
    init {
        instance = this
    }

    override fun onEnable() {
        println("LucyCore_Bungee이(가) 활성화되었습니다.")

        Bukkit.getPluginManager().registerEvents(OnCommand(), this)
        Bukkit.getPluginManager().registerEvents(OnJoin(), this)
        getCommand("접속쿨다운")?.setExecutor(CooldownCommand())
        getCommand("접속쿨다운")?.tabCompleter = CooldownTab()
    }

    override fun onDisable() {
        println("LucyCore_Bungee이(가) 비활성화됩니다.")
    }
}