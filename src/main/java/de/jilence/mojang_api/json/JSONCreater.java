package de.jilence.mojang_api.json;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;

public class JSONCreater {

    private static String readAll(Reader rd)  {
        StringBuilder sb = new StringBuilder();
        int cp = 0;
        while (true) {
            try {
                if ((cp = rd.read()) == -1) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject getJsonObject(String stringUrl) {
        String url = stringUrl;

        InputStream inputStream = null;
        try {
            inputStream = new URL(url).openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(inputStream == null) return null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            String jsonText = readAll(bufferedReader);
            return new JSONObject(jsonText);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static JSONArray getJsonArray(String stringUrl) {
        String url = stringUrl;
        InputStream inputStream = null;
        try {
            inputStream = new URL(url).openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(inputStream == null) return null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            String jsonText = readAll(bufferedReader);
            return new JSONArray(jsonText);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
