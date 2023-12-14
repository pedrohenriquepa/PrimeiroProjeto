package com.example.projeto77;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class signupActivity extends AppCompatActivity {
    EditText nome, senha, resenha, email;
    //Button signup, signin;
    Button cadastrar, acessar;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);
        nome = (EditText) findViewById(R.id.editTextTextPersonName5);
        senha = (EditText) findViewById(R.id.editTextTextPersonName2);
        email = (EditText) findViewById(R.id.editTextTextPersonName4);
        resenha = (EditText) findViewById(R.id.editTextTextPersonName);
        DB = new DBHelper(this);
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = nome.getText().toString();
                String pass = senha.getText().toString();
                String repass = resenha.getText().toString();
                if(user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(signupActivity.this, "Por favor, digite os dados!", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.verificaNome(user);
                        if(checkuser==false){
                            Boolean insert = DB.cadastra(user, pass , repass );
                            if(insert==true){
                                Toast.makeText(signupActivity.this, "Dados armazenados com sucesso!",
                                        Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(signupActivity.this, "Falha durante a operação de registro!",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(signupActivity.this, "Usuário existente! Favor Logar",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(signupActivity.this, "Senhas são diferentes!", Toast.LENGTH_SHORT).show();
                    }
                } }
        });

    }
}