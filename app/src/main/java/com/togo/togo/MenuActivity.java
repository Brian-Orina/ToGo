package com.togo.togo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.GridView;

import com.google.firebase.auth.FirebaseAuth;

public class MenuActivity extends AppCompatActivity {


    GridLayout gridView;
    CardView mProfile, mTrip, mHire, mHistory, mPasssword, mLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        gridView = (GridLayout)findViewById(R.id.gridView);

        mProfile = (CardView) findViewById(R.id.edit_profile);
        mTrip = (CardView) findViewById(R.id.trip_history);
        mHire = (CardView) findViewById(R.id.hire_bike);
        mHistory = (CardView) findViewById(R.id.hire_history);
        mPasssword = (CardView) findViewById(R.id.change_password);
        mLogout = (CardView) findViewById(R.id.logout);

        mProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(MenuActivity.this, EditProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(MenuActivity.this, SplashActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(MenuActivity.this, CustomerMapActivity.class);
        startActivity(intent);
        finish();
    }
}
