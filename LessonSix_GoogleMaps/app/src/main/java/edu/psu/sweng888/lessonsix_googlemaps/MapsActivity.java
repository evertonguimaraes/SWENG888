package edu.psu.sweng888.lessonsix_googlemaps;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Dot;
import com.google.android.gms.maps.model.Gap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.SquareCap;

import java.util.Arrays;

import edu.psu.sweng888.lessonsix_googlemaps.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available. This callback is triggered when the map is ready to
     * be used. This is where we can add markers or lines, add listeners or move the camera.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        /** Add the two LatLng objects to the PolylineOptions object */
        LatLng sydney = new LatLng(-34, 151);
        LatLng tokyo = new LatLng(35.67, 139.65);
        LatLng singapore = new LatLng(1.35, 103.81);

        /** Add a marker in Sydney and move the camera */
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.addMarker(new MarkerOptions().position(tokyo)).setTitle("Marker in Tokyo");
        mMap.addMarker(new MarkerOptions().position(singapore).title("Marker in Singapore"));

        /** Create a PolylineOptions object. It will be represented using Dots */
        PolylineOptions polylineOptionsDot = new PolylineOptions()
                .width(20)
                .color(Color.RED)
                .pattern(Arrays.asList(new Dot(), new Gap(10f)));
        polylineOptionsDot.add(sydney, tokyo);

        /** Create a PolylineOptions object. It will be represented using Square */
        PolylineOptions polylineOptionsSquare = new PolylineOptions()
                .width(10)
                .color(Color.RED)
                .startCap(new SquareCap())
                .endCap(new SquareCap());
                //.add(new LatLng(37.35, -122.0), new LatLng(37.45, -122.0));
        polylineOptionsSquare.add(tokyo, singapore);


        /** Create Polygons */
        LatLng columbus = new LatLng(39.9612, -82.9988);
        LatLng new_york =  new LatLng(40.7128, -74.0060);
        LatLng philadelphia =  new LatLng(39.9526, -75.1652);
        LatLng nashville = new LatLng(36.1627, -86.7816);

        Polygon polygon1 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true).add(columbus, new_york, philadelphia, nashville));

        /** Store a data object with the polygon, used here to indicate an arbitrary type. */
        polygon1.setTag("alpha");

        Polygon polygon2 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(-31.673, 128.892),
                        new LatLng(-31.952, 115.857),
                        new LatLng(-17.785, 122.258),
                        new LatLng(-12.4258, 130.7932)));
        polygon2.setTag("beta");

        /** Create a Polygon style */
        /** TODO Create setPolygonStyle method */
        //stylePolygon(polygon1);
        //stylePolygon(polygon2);

        /** Add the PolylineOptions object to the GoogleMap object */
        mMap.addPolyline(polylineOptionsSquare);
        mMap.addPolyline(polylineOptionsDot);

       /** Move Camera to a specific LatLgn */
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}