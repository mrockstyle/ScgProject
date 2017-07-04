package com.example.sirawich.scgproject.fragment;

import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sirawich.scgproject.R;
import com.example.sirawich.scgproject.activity.MainActivity;
import com.example.sirawich.scgproject.models.Constants;
import com.example.sirawich.scgproject.models.User;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class ProfileFragment extends Fragment implements View.OnClickListener {

    private TextView tv_name,tv_email;
    private SharedPreferences pref;
    private AppCompatButton btn_change_password,btn_logout;

    public ProfileFragment() {
        super();
    }

    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        initInstances(rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        pref = Contextor.getInstance().getContext().getSharedPreferences("MyPref",0);
        tv_name.setText("Welcome : "+pref.getString(Constants.NAME,""));
        tv_email.setText(pref.getString(Constants.EMAIL,""));
        System.out.println("Name : "+ Constants.NAME );

    }

    private void initInstances(View rootView) {
        // Init 'View' instance(s) with rootView.findViewById here
        tv_name = (TextView) rootView.findViewById(R.id.tv_name);
        tv_email = (TextView) rootView.findViewById(R.id.tv_email);
        btn_change_password = (AppCompatButton)rootView.findViewById(R.id.btn_chg_password);
        btn_logout = (AppCompatButton)rootView.findViewById(R.id.btn_logout);
        btn_change_password.setOnClickListener(this);
        btn_logout.setOnClickListener(this);



    }

    private void logout() {
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(Constants.IS_LOGGED_IN,false);
        editor.putString(Constants.EMAIL,"");
        editor.putString(Constants.NAME,"");
        editor.putString(Constants.UNIQUE_ID,"");
        editor.apply();
        goToLogin();
    }

    private void goToLogin(){

        Fragment login = new LoginFragment();
        android.support.v4.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.contentContainer,login);
        ft.commit();
        Intent i = new Intent(getActivity(), MainActivity.class);
        startActivity(i);
        getActivity().finish();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    /*
     * Save Instance State Here
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance State here
    }

    /*
     * Restore Instance State Here
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore Instance State here
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_logout:
                logout();
                break;
        }
    }
}
