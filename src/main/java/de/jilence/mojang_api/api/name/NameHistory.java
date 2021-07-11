package de.jilence.mojang_api.api.name;

import de.jilence.mojang_api.json.JSONArray;
import de.jilence.mojang_api.json.JSONCreator;
import de.jilence.mojang_api.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class NameHistory {

    private final String uuid;

    public NameHistory(String uuid) {
        this.uuid = uuid;
    }

    /**
     * get a list of all names the player had
     *
     * @return a list of names
     */
    public ArrayList<String> getNameList() {
        JSONArray jsonArray = JSONCreator.getJsonArray("https://api.mojang.com/user/profiles/" + uuid + "/names");
        if(jsonArray == null) return null;
        ArrayList<String> nameList = new ArrayList<>();
        jsonArray.forEach(o -> { JSONObject jsonObject = new JSONObject(o); nameList.add(jsonObject.getString("name")); });
        return nameList;
    }

    /**
     * get the player name and date when the name was changed
     *
     * @return a hashmap with player name and date
     * @see java.text.SimpleDateFormat to format the date
     */
    public HashMap<String, Integer> getList() {
        JSONArray jsonArray = JSONCreator.getJsonArray("https://api.mojang.com/user/profiles/" + uuid + "/names");
        if(jsonArray == null) return null;
        HashMap<String, Integer> list = new HashMap<>();
        jsonArray.forEach(o -> { JSONObject jsonObject = new JSONObject(o); list.put(jsonObject.getString("name"), jsonObject.getInt("changedToAt")); });
        return list;
    }

    /**
     * get the list of dates when the name was changed to a specific name
     *
     * @param playerName that search when the name was changed
     * @return a list of dates
     * @see java.text.SimpleDateFormat to format the date
     */
    public ArrayList<Integer> getChangedAt(String playerName) {
        JSONArray jsonArray = JSONCreator.getJsonArray("https://api.mojang.com/user/profiles/" + uuid + "/names");
        ArrayList<Integer> changedAt = new ArrayList<>();
        if(jsonArray == null) return null;
        jsonArray.forEach(o -> { JSONObject jsonObject = new JSONObject(o);
        if(jsonObject.getString("name").equalsIgnoreCase(playerName)) { changedAt.add(jsonObject.getInt("changedToAt"));}});
        return changedAt;
    }

}
