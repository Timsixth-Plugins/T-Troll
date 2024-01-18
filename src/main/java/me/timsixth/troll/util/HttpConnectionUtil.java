package me.timsixth.troll.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import lombok.experimental.UtilityClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@UtilityClass
public class HttpConnectionUtil {

    public static Object connect(String urlStr, String method) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(method);
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);
        connection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:56.0) Gecko/20100101 Firefox/56.0");

        return doGetRequest(connection);
    }

    private static Object doGetRequest(HttpURLConnection connection) throws IOException {
        BufferedReader reader;
        String line;
        StringBuilder stringBuilder = new StringBuilder();

        if (connection.getResponseCode() == 200) {
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        } else {
            reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
        }
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        reader.close();

        String jsonString = stringBuilder.toString();

        Gson gson = new Gson();
        JsonElement jsonElement = gson.fromJson(jsonString, JsonElement.class);

        return jsonElement.getAsJsonObject();
    }
}
