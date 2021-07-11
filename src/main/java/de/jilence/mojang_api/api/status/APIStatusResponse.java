package de.jilence.mojang_api.api.status;

import de.jilence.mojang_api.json.JSONArray;
import de.jilence.mojang_api.json.JSONObject;

public class APIStatusResponse {

    private final JSONArray jsonArray;
    private JSONObject jsonObject;

    /**
     * @param jsonArray the json object for the status
     */
    public APIStatusResponse(JSONArray jsonArray) {
        this.jsonArray = jsonArray;
    }

    /**
     * @return the status of minecraft.net
     */
    public Status getMinecraftStatus() {
        jsonObject = jsonArray.getJSONObject(0);
        return jsonObject.getString("minecraft.net").equalsIgnoreCase("green") ? Status.ONLINE : Status.OFFLINE;
    }

    /**
     * @return the status of session.minecraft.net
     */
    public Status getMinecraftSessionStatus() {
        jsonObject = jsonArray.getJSONObject(1);
        return jsonObject.getString("session.minecraft.net").equalsIgnoreCase("green") ? Status.ONLINE : Status.OFFLINE;
    }

    /**
     * @return the status of account.mojang.com
     */
    public Status getMojangAccountStatus() {
        jsonObject = jsonArray.getJSONObject(2);
        return jsonObject.getString("account.mojang.com").equalsIgnoreCase("green") ? Status.ONLINE : Status.OFFLINE;
    }

    /**
     * @return the status of authserver.mojang.com
     */
    public Status getMojangAuthserverStatus() {
        jsonObject = jsonArray.getJSONObject(3);
        return jsonObject.getString("authserver.mojang.com").equalsIgnoreCase("green") ? Status.ONLINE : Status.OFFLINE;
    }

    /**
     * @return the status of sessionserver.mojang.com
     */
    public Status getMojangSessionServerStatus() {
        jsonObject = jsonArray.getJSONObject(4);
        return jsonObject.getString("sessionserver.mojang.com").equalsIgnoreCase("green") ? Status.ONLINE : Status.OFFLINE;
    }

    /**
     * @return the status of api.mojang.com
     */
    public Status getMojangApiStatus() {
        jsonObject = jsonArray.getJSONObject(5);
        return jsonObject.getString("api.mojang.com").equalsIgnoreCase("green") ? Status.ONLINE : Status.OFFLINE;
    }

    /**
     * @return the status of textures.minecraft.net
     */
    public Status getMinecraftTexturesStatus() {
        jsonObject = jsonArray.getJSONObject(6);
        return jsonObject.getString("textures.minecraft.net").equalsIgnoreCase("green") ? Status.ONLINE : Status.OFFLINE;
    }

    /**
     * @return the status of mojang.com
     */
    public Status getMojangStatus() {
        jsonObject = jsonArray.getJSONObject(7);
        return jsonObject.getString("mojang.com").equalsIgnoreCase("green") ? Status.ONLINE : Status.OFFLINE;
    }


    enum Status {
        /**
         * return status online when the status is online
         */
        ONLINE,
        /**
         * return offline otherwise
         */
        OFFLINE;
    }

}
