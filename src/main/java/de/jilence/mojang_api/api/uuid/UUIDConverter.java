package de.jilence.mojang_api.api.uuid;

import de.jilence.mojang_api.json.JSONCreater;
import de.jilence.mojang_api.json.JSONObject;

import java.util.UUID;

public class UUIDConverter {

    private final String playerName;

    /**
     * get the uuid from the offline player
     *
     * @param playerName to get the uuid
     */
    public UUIDConverter(String playerName) {
        this.playerName = playerName;
    }

    /**
     * get the uuid without dashes
     *
     * @return the uuid in string without dashes
     */
    public String getUUIDStringWithoutDashes() {
        JSONObject jsonObject = JSONCreater.getJsonObject("https://api.mojang.com/users/profiles/minecraft/" + playerName);
        if(jsonObject == null) throw new IllegalArgumentException("player name not found");
        return jsonObject.getString("id");
    }

    /**
     * get the uuid with dashes
     *
     * @return the uuid in string with dashes
     */
    public String getUUIDStringWithDashes() {
        return UUID.fromString(getUUIDStringWithoutDashes().replaceFirst("(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})", "$1-$2-$3-$4-$5")).toString();
    }

    /**
     * get the uuid with dashes
     *
     * @return the uuid with dashes
     */
    public UUID getUUIDWithDashes() {
        return UUID.fromString(getUUIDStringWithoutDashes().replaceFirst("(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})", "$1-$2-$3-$4-$5"));
    }

    /**
     * get the uuid without dashes
     *
     * @return the uuid without dashes
     */
    public UUID getUUIDWithoutDashes() {
        return UUID.fromString(getUUIDStringWithoutDashes());
    }

}
