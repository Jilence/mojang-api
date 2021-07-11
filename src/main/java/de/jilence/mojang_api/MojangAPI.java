package de.jilence.mojang_api;

import de.jilence.mojang_api.api.status.APIStatus;
import de.jilence.mojang_api.api.uuid.UUIDConverter;

public class MojangAPI {

    public MojangAPI() {
    }

    public APIStatus getAPIStatus() {
        return new APIStatus();
    }

    public UUIDConverter getUsernameConverter(String playerName) {
        return new UUIDConverter(playerName);
    }

}
