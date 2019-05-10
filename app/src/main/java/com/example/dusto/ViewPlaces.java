package com.example.dusto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dusto.Remote.IGoogleAPIService;
import com.example.dusto.Remote.PlaceDetail;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewPlaces extends AppCompatActivity {

    ImageView photo;
    TextView opening_hours,place_address,place_name;
    Button btnViewOnMap;

    IGoogleAPIService mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_places);

        mService = Common.getGoogleAPIServices();

        photo =(ImageView)findViewById(R.id.photo);


       if (Common.currentResult.getPhotos() !=null && Common.currentResult.getPhotos() .length >0){
           Picasso.with(this)
                   .load(getPhotosOfPlaces(Common.currentResult.getPhotos()[0].getPhoto_reference(),1000))
                   .into(photo);
       }

       //opening hours

       if (Common.currentResult .getOpening_hours() !=null){

          opening_hours.setText("Open Now : "+Common.currentResult.getOpeningHours().getOpen_now);{


           }else{

               opening_hours.setVisibility(View.GONE);
           }
           //user service to fetch address and name
           mService.getDetailPlaces(getPlaceDetailUrl(Common.currentResult.getPlace_id()))
                   .enqueue(new Callback<PlaceDetail>() {
                       @Override
                       public void onResponse(Call<PlaceDetail> call, Response<PlaceDetail> response) {
                           
                       }

                       @Override
                       public void onFailure(Call<PlaceDetail> call, Throwable t) {

                       }
                   });

       }
    }


    private String getPlaceDetailUrl(String place_id) {
    }

    private String getPhotosOfPlaces(String photo_reference,int maxWidth) {
        StringBuilder url = new StringBuilder("https://maps.googleapis.com/maps/api/place/photo");
        url.append("?maxwidth="+maxWidth);
        url.append("&photoreference="+photo_reference);
        url.append("&key="+getResources().getString(R.string.Dusto_key));
        return url.toString();
    }
}
