package edu.psu.sweng888.lessonsix_materialui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;

import edu.psu.sweng888.lessonsix_materialui.R;

public class MapsFragment extends Fragment implements OnMapReadyCallback {

        private MapView mMapView;
        private GoogleMap mGoogleMap;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_maps, container, false);
            mMapView = (MapView) view.findViewById(R.id.map_view);
            mMapView.onCreate(savedInstanceState);
            mMapView.getMapAsync(this);

            return view;
        }

        @Override
        public void onResume() {
            super.onResume();
            mMapView.onResume();
        }

        @Override
        public void onPause() {
            super.onPause();
            mMapView.onPause();
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            mMapView.onDestroy();
        }

        @Override
        public void onLowMemory() {
            super.onLowMemory();
            mMapView.onLowMemory();
        }

        @Override
        public void onMapReady(GoogleMap googleMap) {
            mGoogleMap = googleMap;
            // Add your code to initialize the map here
        }
}
