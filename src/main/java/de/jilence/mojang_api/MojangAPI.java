package de.jilence.mojang_api;

import de.jilence.mojang_api.api.status.APIStatus;
import org.bukkit.plugin.java.JavaPlugin;

public class MojangAPI {

    public MojangAPI() {
    }

    public APIStatus getAPIStatus() {
        return new APIStatus();
    }

}
