package com.example.projeto77;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button signup;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        // CÓDIGO LOGIN
        login = findViewById(R.id.button2);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent busca2 = new Intent(MainActivity.this, loginActivity.class);
                startActivity(busca2);
            }
        });
        // CÓDIGO SIGNUP
        signup = findViewById(R.id.button);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent busca = new Intent (MainActivity.this, signupActivity.class);
                startActivity(busca);
            }
        });



    }
}