package com.example.dharmendraverma.imageloader;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.dharmendraverma.imageloader.fragments.LoaderFragment;

public class MainActivity extends AppCompatActivity {

    LoaderFragment loaderFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment();
    }

    protected void loadFragment() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        loaderFragment = LoaderFragment.newInstance(null); // newInstance() is a static factory method.
        transaction.replace(R.id.container, loaderFragment);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.item1:
                loaderFragment.setSpanCount(2);
                return true;
            case R.id.item2:
                loaderFragment.setSpanCount(3);
                return true;
            case R.id.item3:
                loaderFragment.setSpanCount(4);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
