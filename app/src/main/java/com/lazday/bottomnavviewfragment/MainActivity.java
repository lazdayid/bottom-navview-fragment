package com.lazday.bottomnavviewfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.lazday.bottomnavviewfragment.fragment.DashboardFragment;
import com.lazday.bottomnavviewfragment.fragment.HomeFragment;
import com.lazday.bottomnavviewfragment.fragment.NotifFragment;

public class MainActivity extends AppCompatActivity {

    final Fragment homeFragment = new HomeFragment();
    final Fragment dashboardFragment = new DashboardFragment();
    final Fragment notifFragment = new NotifFragment();

    final FragmentManager fragmentManager = getSupportFragmentManager();
    Fragment fragmentActive = homeFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragmentManager.beginTransaction().hide(fragmentActive).show(homeFragment).commit();
                    fragmentActive = homeFragment;
                    return true;
                case R.id.navigation_dashboard:
                    fragmentManager.beginTransaction().hide(fragmentActive).show(dashboardFragment).commit();
                    fragmentActive = dashboardFragment;
                    return true;
                case R.id.navigation_notifications:
                    fragmentManager.beginTransaction().hide(fragmentActive).show(notifFragment).commit();
                    fragmentActive = notifFragment;
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fragmentManager.beginTransaction().add(R.id.frameLayout, notifFragment, "3").hide(notifFragment).commit();
        fragmentManager.beginTransaction().add(R.id.frameLayout, dashboardFragment, "2").hide(dashboardFragment).commit();
        fragmentManager.beginTransaction().add(R.id.frameLayout, homeFragment, "1").commit();
    }

}
