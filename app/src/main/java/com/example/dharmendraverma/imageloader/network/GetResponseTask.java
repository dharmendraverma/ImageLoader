package com.example.dharmendraverma.imageloader.network;

import android.app.Activity;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;


import com.example.dharmendraverma.imageloader.interfaces.ApiResponseListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;


/**
 * Async task class to get json by making HTTP call
 */
public class GetResponseTask extends AsyncTask<Void, Void, String> {

    private String url;
    private WeakReference<Activity> context;
    private ApiResponseListener apiResponseListener;
    private String key;


    public GetResponseTask(String key, String url, Activity context, ApiResponseListener apiResponseListener) {
        this.url = url;
        this.context = new WeakReference<>(context);
        this.apiResponseListener = apiResponseListener;
        this.key = key;

    }

    private final static String TAG = GetResponseTask.class.getSimpleName();


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Void... arg0) {
        HttpHandler sh = new HttpHandler();

        // Making a request to url and getting response
        String jsonStr = sh.makeServiceCall(url);

        Log.d(TAG, "Response from url: " + jsonStr);

        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);

                // Getting JSON Array node
//                JSONArray contacts = jsonObj.getJSONArray("contacts");

                return jsonStr;

            } catch (final JSONException e) {
                Log.e(TAG, "Json parsing error: " + e.getMessage());
                return null;

            }
        } else {
            Log.e(TAG, "Couldn't get json from server.");
            return null;

        }
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (apiResponseListener != null) {
            if (isResultValid(result))
                apiResponseListener.onSuccess(key, result);
            else apiResponseListener.onFailure();
        }
    }
    public static boolean isResultValid(String result) {
        return !TextUtils.isEmpty(result);
    }

    public void removeListeners() {
        this.apiResponseListener = null;
    }
}