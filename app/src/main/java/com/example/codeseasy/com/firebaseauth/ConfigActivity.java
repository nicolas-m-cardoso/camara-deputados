package com.example.codeseasy.com.firebaseauth;

import androidx.appcompat.app.AppCompatActivity;
import com.example.codeseasy.com.firebaseauth.components.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ConfigActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;
    private FirebaseAuth auth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation_menu);
        bottomNavigation.setSelectedItemId(R.id.nav_config);
        bottomNavigation.setOnItemSelectedListener(item -> BottomNavigationMenu.listener(this, item));

        button = findViewById(R.id.logout);
        textView = findViewById(R.id.user_details);
        auth = FirebaseAuth.getInstance();

        user = auth.getCurrentUser();

        if (user == null){
            Intent intent = new Intent(getApplicationContext(), Welcome.class);
            startActivity(intent);
            finish();
        }
        else {
            textView.setText(user.getEmail());
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), Welcome.class);
                startActivity(intent);
                finish();
            }
        });
    }

}