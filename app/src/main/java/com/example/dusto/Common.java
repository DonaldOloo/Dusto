package com.example.dusto;

import android.database.CursorJoiner;

import com.example.dusto.Remote.IGoogleAPIService;
import com.example.dusto.Remote.RetrofitClient;

public class Common {

    public static Results currentResult;

    private static final String GOOGLE_API_URL = "https://maps.googleapis.com/";


    public static IGoogleAPIService getGoogleAPIServices(){

        return RetrofitClient.getClient(GOOGLE_API_URL).create(IGoogleAPIService.class);
    }
}
