package com.learnoset.functions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MyConstants {

    public static String getStringFromJSONObject(JSONObject jsonObject, String jsonObjectKey) {
        String response = "";

        try {
            if (jsonObject.has(jsonObjectKey)) {
                response = jsonObject.getString(jsonObjectKey);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return response;
    }

    public static String getStringFromJSONArray(JSONArray jsonArray, int jsonObjectPosition, String jsonObjectKey) {
        String response = "";

        try {
            if (jsonObjectPosition < jsonArray.length()) {
                if (jsonArray.getJSONObject(jsonObjectPosition).has(jsonObjectKey)) {
                    response = jsonArray.getJSONObject(jsonObjectPosition).getString(jsonObjectKey);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return response;
    }

    public static JSONObject getJSONObjectFromJSONArray(JSONArray jsonArray, int jsonObjectPosition) {
        JSONObject response = null;

        try {
            response = new JSONObject("{}");
            if (jsonObjectPosition < jsonArray.length()) {
                response = jsonArray.getJSONObject(jsonObjectPosition);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return response;
    }

    public static JSONObject getJSONObjectFromJSONObject(JSONObject jsonObject, String jsonObjectKey) {
        JSONObject response = null;

        try {
            response = new JSONObject("{}");
            if (jsonObject.has(jsonObjectKey)) {
                response = jsonObject.getJSONObject(jsonObjectKey);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return response;
    }

    public static JSONArray getJSONOArrayFromJSONObject(JSONObject jsonObject, String jsonObjectKey) {
        JSONArray response = new JSONArray();

        try {
            if (jsonObject.has(jsonObjectKey)) {
                response = jsonObject.getJSONArray(jsonObjectKey);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return response;
    }
}

