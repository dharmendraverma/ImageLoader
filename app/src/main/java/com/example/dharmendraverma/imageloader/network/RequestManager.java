package com.example.dharmendraverma.imageloader.network;

import android.app.Activity;
import android.text.TextUtils;

import com.example.dharmendraverma.imageloader.interfaces.ApiResponseListener;

import java.util.HashMap;

public class RequestManager {

    static RequestManager sInstance;

    boolean isRequestRunning = false;

    public static RequestManager getInstance() {

        if (sInstance == null)
            sInstance = new RequestManager();

        return sInstance;
    }

    private RequestManager() {

    }

    GetResponseTask getResponseTask;

    public void submitQuery(final String query, Activity activity, final ApiResponseListener listener) {
//        String url = Utils.buildImageUrl(photo.getFarm(), photo.getServer(), photo.getId(), photo.getSecret());
        RequestManager.getInstance().cancelTask();

        String cachedResponse = checkIfSearchResuktExistsInCache(query);
        if (!TextUtils.isEmpty(cachedResponse)) {
            listener.onSuccess(query, cachedResponse);
            return;
        }

        String url = "add the query";
        getResponseTask = new GetResponseTask(query, url, activity, new ApiResponseListener() {
            @Override
            public void onSuccess(String key, String jsonObject) {
                updateResultInCache(query, jsonObject);
                listener.onSuccess(query, jsonObject);

            }

            @Override
            public void onFailure() {
            listener.onFailure();
            }
        });
        getResponseTask.execute();
    }

    public void cancelTask() {
        if (getResponseTask != null) {
            getResponseTask.removeListeners();
            if (!getResponseTask.isCancelled())
                getResponseTask.cancel(true);
        }
        getResponseTask = null;
    }

    private static String checkIfSearchResuktExistsInCache(String query) {
        return searchApiCache.get(query);
    }

    private void updateResultInCache(String query, String result) {
        searchApiCache.put(query, result);
    }

    private static HashMap<String, String> searchApiCache = new HashMap<>();

}
