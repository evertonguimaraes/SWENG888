package edu.psu.sweng888.lessonsix_googlemaps;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.widget.SearchView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import com.google.android.libraries.places.api.net.PlacesClient;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private final String YOUR_API_KEY = "AIzaSyBcA4lmH3hbZy8v20-QZVwh72kovT7YJN8";

    // creating a variable
    // for search view.
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        /** NEW LINES - BEGIN **/
        Places.initialize(getApplicationContext(), YOUR_API_KEY);
        AutocompleteSessionToken token = AutocompleteSessionToken.newInstance();
        /** NEW LINES - END **/


        // initializing our search view.
        searchView = findViewById(R.id.idSearchView);

        // Obtain the SupportMapFragment and get notified
        // when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.map);

        // adding on query listener for our search view.
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // on below line we are getting the
                // location name from search view.
                String location = searchView.getQuery().toString();

                // below line is to create a list of address
                // where we will store the list of all address.
                List<Address> addressList = null;

                // checking if the entered location is null or not.
                if (location != null || location.equals("")) {
                    // on below line we are creating and initializing a geo coder.
                    Geocoder geocoder = new Geocoder(MapsActivity.this);
                    try {
                        // on below line we are getting location from the
                        // location name and adding that location to address list.
                        addressList = geocoder.getFromLocationName(location, 1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    // on below line we are getting the location
                    // from our list a first position.
                    Address address = addressList.get(0);

                    // on below line we are creating a variable for our location
                    // where we will add our locations latitude and longitude.
                    LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());

                    // on below line we are adding marker to that position.
                    mMap.addMarker(new MarkerOptions().position(latLng).title(location));

                    // below line is to animate camera to that position.
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (!newText.isEmpty()) {
                    List<Place.Field> fields = Arrays.asList(Place.Field.ID, Place.Field.NAME);
                    FindAutocompletePredictionsRequest request =
                            FindAutocompletePredictionsRequest.builder()
                                    .setCountry("US") // Limit suggestions to the US
                                    .setTypeFilter(TypeFilter.ADDRESS) // Limit suggestions to addresses only
                                    .setSessionToken(token)
                                    .setQuery(newText)
                                    .build();
                    PlacesClient placesClient = Places.createClient(MapsActivity.this);
                    placesClient.findAutocompletePredictions(request)
                            .addOnSuccessListener((response) -> {
                                // Display up to 5 suggestions to the user
                                List<AutocompletePrediction> predictions = response.getAutocompletePredictions();
                                for (int i = 0; i < Math.min(predictions.size(), 5); i++) {
                                    Log.d("AutocompletePrediction", predictions.get(i).getFullText(null).toString());
                                    // Display the suggestion to the user
                                    // ...
                                }
                            })
                            .addOnFailureListener((exception) -> {
                                // Handle error
                                Log.e("TAG", "Autocomplete prediction fetch failed.", exception);
                            });
                }
                return false;
            }

        });
        // at last we calling our map fragment to update.
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }
}