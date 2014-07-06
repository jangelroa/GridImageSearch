package com.jangelroa.mymodule.gridimagesearch.app;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by jroagome on 6/30/14.
 */
public class ImageResult {
    private String fullUrl;
    private String thumbUrl;

    public ImageResult(JSONObject json) {
        try{
            this.fullUrl = json.getString("url");
            this.thumbUrl = json.getString("tbUrl");
        }catch (JSONException e){
            this.fullUrl = null;
            this.thumbUrl = null;
        }
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }


    @Override
    public String toString() {
        return this.thumbUrl;
    }

    public static ArrayList<ImageResult> fromJSONArray(JSONArray array) {
        ArrayList<ImageResult> results = new ArrayList<ImageResult>();
        for(int x = 0; x < array.length(); x++){
            try{
                results.add(new ImageResult(array.getJSONObject(x)));
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return results;
    }
}
