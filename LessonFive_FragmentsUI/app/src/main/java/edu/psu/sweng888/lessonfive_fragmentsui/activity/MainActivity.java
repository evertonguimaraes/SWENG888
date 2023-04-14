package edu.psu.sweng888.lessonfive_fragmentsui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import edu.psu.sweng888.lessonfive_fragmentsui.R;
import edu.psu.sweng888.lessonfive_fragmentsui.fragments.GalleryFragment;
import edu.psu.sweng888.lessonfive_fragmentsui.fragments.HomeFragment;
import edu.psu.sweng888.lessonfive_fragmentsui.fragments.SettingsFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    /** Step 1: create a reference to the DrawerLayout */
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** Step 2: Get the DrawerLayout object from the layout XML file */
        mDrawerLayout = findViewById(R.id.nav_drawer_layout);

        /** Step 3: Get the NavigationView object from the layout SML file */
        mNavigationView = findViewById(R.id.nav_view);

        /** Step 4: Set the listener for the NvigationView. The Main Activity shuould
         * imeplement the interface NavigationView.OnNavigationItemSelectedListener */
        mNavigationView.setNavigationItemSelectedListener(this);

        /** Step 5: Set up the ActionBarDrawerToggle */
        mActionBarDrawerToggle = new ActionBarDrawerToggle(
                this, // Activity / Context
                mDrawerLayout, // DrawerLayout
                R.string.navigation_drawer_open, // String to open
                R.string.navigation_drawer_close // String to close
        );
        /** Step 6: Include the mActionBarDrawerToggle as the listener to the DrawerLayout.
         *  The synchState() method is used to synchronize the state of the navigation drawer */
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
        mActionBarDrawerToggle.syncState();

        /** Step 7:Set the default fragment to the HomeFragment */
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new HomeFragment()).commit();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {// Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                break;
            case R.id.nav_gallery:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new GalleryFragment()).commit();
                break;
            case R.id.nav_settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SettingsFragment()).commit();
                break;
        }

        // Close the navigation drawer
        mDrawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
        return false;
    }
//
//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//        actionBarDrawerToggle.onConfigurationChanged(newConfig);
//    }
//
//    @Override
//    protected void onPostCreate(Bundle savedInstanceState) {
//        super.onPostCreate(savedInstanceState);
//        actionBarDrawerToggle.syncState();
//    }
}