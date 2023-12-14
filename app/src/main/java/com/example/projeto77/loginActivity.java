package com.example.projeto77;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class loginActivity extends AppCompatActivity {
    EditText username, password;
    Button btnlogin;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);
        btnlogin = (Button) findViewById(R.id.buttaum);
        DB = new DBHelper(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if(user.equals("")||pass.equals(""))
                    Toast.makeText(loginActivity.this, "Favor digitar todos os dados!",
                            Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.verificaNomeSenha(user, pass);
                    if(checkuserpass==true){
                        Toast.makeText(loginActivity.this, "Login feito com sucesso!",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),
                                HomeActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(loginActivity.this, "Acesso não permitido!",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}