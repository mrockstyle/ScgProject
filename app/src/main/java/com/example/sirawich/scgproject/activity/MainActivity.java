package com.example.sirawich.scgproject.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sirawich.scgproject.R;
import com.example.sirawich.scgproject.fragment.LoginFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.contentContainer, LoginFragment.newInstance()).commit();
        }
    }
}
