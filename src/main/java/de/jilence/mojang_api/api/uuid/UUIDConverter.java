package de.jilence.mojang_api.api.uuid;

import de.jilence.mojang_api.json.JSONCreator;
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
     * @Nullable the uuid can be null
     */
    public String getUUIDStringWithoutDashes() {
        JSONObject jsonObject = JSONCreator.getJsonObject("https://api.mojang.com/users/profiles/minecraft/" + playerName);
        if(jsonObject == null) return null;
        return jsonObject.getString("id");
    }

    /**
     * get the uuid with dashes
     *
     * @return the uuid in string with dashes
     * @Nullable the uuid can be null
     */
    public String getUUIDStringWithDashes() {
        if(getUUIDStringWithoutDashes() == null) return null;
        return UUID.fromString(getUUIDStringWithoutDashes().replaceFirst("(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})", "$1-$2-$3-$4-$5")).toString();
    }

    /**
     * get the uuid with dashes
     *
     * @return the uuid with dashes
     * @Nullable the uuid can be null
     */
    public UUID getUUIDWithDashes() {
        if(getUUIDStringWithoutDashes() == null) return null;
        return UUID.fromString(getUUIDStringWithoutDashes().replaceFirst("(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})", "$1-$2-$3-$4-$5"));
    }

    /**
     * get the uuid without dashes
     *
     * @return the uuid without dashes
     * @Nullable the uuid can be null
     */
    public UUID getUUIDWithoutDashes() {
        if(getUUIDStringWithoutDashes() == null) return null;
        return UUID.fromString(getUUIDStringWithoutDashes());
    }

}
