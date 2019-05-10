package com.example.dusto.Remote;


import com.example.dusto.MyPlaces;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface IGoogleAPIService {

    @GET
    Call<MyPlaces> getNearbyPlaces (@Url String url);

    @GET
    Call<PlaceDetail> getDetailPlaces (@Url String url);

}

