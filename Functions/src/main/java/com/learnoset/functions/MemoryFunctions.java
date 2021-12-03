package com.learnoset.functions;

import android.content.Context;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MemoryFunctions {

    public static void saveData(String filename, String data, Context context) {
        try {
            FileOutputStream fileOutputStream = context.openFileOutput(filename, Context.MODE_PRIVATE);
            fileOutputStream.write(data.getBytes());
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param filename        txt Filename to store data into Memory
     * @param jsonObjectKey   jsonObject key in which value of jsonObjectValue parameter will be save and will be accessible by using this key
     * @param jsonObjectValue This is new JSONObject & will be added into oldData parameter
     * @param oldData         Old data is in which new JSONArray going to be added
     */
    public static void appendStringIntoJSONObject(String filename, String jsonObjectKey, String jsonObjectValue, JSONObject oldData, Context context) {
        try {

            oldData.put(jsonObjectKey, jsonObjectValue);

            FileOutputStream fileOutputStream = context.openFileOutput(filename, Context.MODE_PRIVATE);
            fileOutputStream.write(oldData.toString().getBytes());
            fileOutputStream.close();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param filename      txt Filename to store data into Memory
     * @param jsonObjectKey jsonObject key in which value of jsonObject parameter will be save and will be accessible by using this key
     * @param jsonObject    This is new JSONObject & will be added into oldData parameter
     * @param oldData       Old data is in which new JSONArray going to be added
     */
    public static void appendJSONObjectIntoJSONObject(String filename, String jsonObjectKey, JSONObject jsonObject, JSONObject oldData, Context context) {
        try {

            oldData.put(jsonObjectKey, jsonObject);

            FileOutputStream fileOutputStream = context.openFileOutput(filename, Context.MODE_PRIVATE);
            fileOutputStream.write(oldData.toString().getBytes());
            fileOutputStream.close();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param filename      txt Filename to store data into Memory
     * @param jsonObjectKey jsonObject key in which data will be save and will be accessible by using this key
     * @param jsonArray     This is new JSONArray & will be added into oldData parameter
     * @param oldData       Old data is in which new JSONArray going to be added
     */
    public static void appendJSONOArrayIntoJSONObject(String filename, String jsonObjectKey, JSONArray jsonArray, JSONObject oldData, Context context) {
        try {

            oldData.put(jsonObjectKey, jsonArray);

            FileOutputStream fileOutputStream = context.openFileOutput(filename, Context.MODE_PRIVATE);
            fileOutputStream.write(oldData.toString().getBytes());
            fileOutputStream.close();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    public static String getData(String filename, String defaultValue, Context context) {
        String data = defaultValue;
        try {
            FileInputStream fileInputStream = context.openFileInput(filename);
            InputStreamReader isr = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            data = sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static JSONObject getDataInJSONObjectForm(String filename, Context context) {
        JSONObject data = null;
        try {
            data = new JSONObject("{}");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileInputStream = context.openFileInput(filename);
            InputStreamReader isr = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            data = new JSONObject(sb.toString());

        } catch (IOException | JSONException e) {
            e.printStackTrace();
            Toast.makeText(context, "Something went wrong!!!", Toast.LENGTH_SHORT).show();
        }
        return data;
    }

    public static JSONObject updateJSONObject(String filename, String jsonObjectKey, String value, Context context) {
        JSONObject data = null;
        try {
            data = new JSONObject("{}");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileInputStream = context.openFileInput(filename);
            InputStreamReader isr = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            data = new JSONObject(sb.toString());
            data.put(jsonObjectKey, value);

            // save updated jsonObject to memory
            saveData(filename, data.toString(), context);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            Toast.makeText(context, "Something went wrong!!!", Toast.LENGTH_SHORT).show();
        }
        return data;
    }

    public static JSONArray getDataInJSOArrayForm(String filename, Context context) {
        JSONArray data = null;
        try {
            data = new JSONArray("[]");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fileInputStream = context.openFileInput(filename);
            InputStreamReader isr = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            data = new JSONArray(sb.toString());

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return data;
    }

}
