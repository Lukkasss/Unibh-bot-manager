package com.lucasgv.unibh_poc.parse;
import com.jayway.jsonpath.JsonPath;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Lucas Vilela
 * Date: 10/02/2019
 * Time: 01:26
 * To change this template use File | Settings | File and Code Templates.
 */
public class JSON {

    public static String parse(String json, String node, String child){
        final JSONObject objJSON = new JSONObject(json);
        return objJSON.getJSONObject(node).getString(child);
    }

    public static String parse(String json, String key){
        final JSONObject objJSON = new JSONObject(json);
        return objJSON.getString(key);
    }

    public static List<String> parseArray(String json, String node, String child){
        //final JSONObject objJSON = new JSONObject(json);
        //final JSONArray objArray = objJSON.getJSONArray(node);
        List<String> listaValores = new ArrayList<String>();

        Integer itinerarios = JsonPath.read(json, "$.entity.formativeItineraryList.length()");

        for (int i = 0; i < itinerarios ; i++){
            listaValores.add(JsonPath.read(json,new StringBuilder("$.entity.formativeItineraryList[").append(i).append("].name").toString()).toString());
        }
        return listaValores;
    }

}
