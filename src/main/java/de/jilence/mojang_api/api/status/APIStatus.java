package de.jilence.mojang_api.api.status;

import de.jilence.mojang_api.json.JSONCreator;

public class APIStatus {

    public APIStatus() {
    }

    /**
     * get the api status for:
     * - minecraft.net
     * - session.minecraft.net
     * - account.mojang.com
     * - authserver.mojang.com
     * - sessionserver.mojang.com
     * - api.mojang.com
     * - textures.minecraft.net
     * - mojang.com
     *
     * @return the status
     */
    public APIStatusResponse getStatus() {
        return new APIStatusResponse(JSONCreator.getJsonArray("https://status.mojang.com/check"));
    }

}
