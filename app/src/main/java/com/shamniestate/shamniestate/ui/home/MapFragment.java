package com.shamniestate.shamniestate.ui.home;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;

import android.location.Location;
import android.net.Uri;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.shamniestate.shamniestate.R;

public class MapFragment extends Fragment {

    double lat , lang ;
    boolean is_activity;

    
    public MapFragment(double lat , double lang, boolean isactiity){
        this.lat = lat ;
        this.lang = lang ;
        this.is_activity = isactiity ;
    }



    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {

            GoogleMap map = googleMap ;

            float zoom = 15f;
            LatLng indore = new LatLng(lat, lang);
            googleMap.addMarker(new MarkerOptions().position(indore).title("You are here"));
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(indore, zoom));
            if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            googleMap.setMyLocationEnabled(true);


            googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(Marker marker) {
                    String geoUri = "http://maps.google.com/maps?q=loc:" + lat + "," + lang +  ")";
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoUri));
                    if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                        startActivity(mapIntent);
                    }
                    return false;
                }
            });

            googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                @Override
                public void onMapClick(LatLng latLng) {
                    String geoUri = "http://maps.google.com/maps?q=loc:" + lat + "," + lang +  ")";
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoUri));
                    if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                        startActivity(mapIntent);
                    }
                }
            });

        }
    };



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_map, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}