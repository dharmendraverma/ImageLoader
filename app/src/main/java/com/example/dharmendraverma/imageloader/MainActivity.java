package com.example.dharmendraverma.imageloader;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dharmendraverma.imageloader.fragments.LoaderFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment();
    }

    protected void loadFragment() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        LoaderFragment containerFragment = LoaderFragment.newInstance(null);
        transaction.add(containerFragment, FragmentTransaction.class.getSimpleName()); // newInstance() is a static factory method.
        transaction.commit();
    }
}
