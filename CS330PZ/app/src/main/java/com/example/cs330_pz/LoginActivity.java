package com.example.cs330_pz;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText txtusername;
    EditText txtpassword;
    Button btnLogin;
    Button btnreg;
    DatabaseHelper db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(this);
        txtusername = (EditText) findViewById(R.id.txtusername);
        txtpassword = (EditText) findViewById(R.id.txtpassword);
        btnLogin = (Button) findViewById(R.id.btnlogin);
        btnreg = (Button) findViewById(R.id.btnreg);



        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View e) {
                String user = txtusername.getText().toString();
                String pass = txtusername.getText().toString();
                Boolean res = db.checkUser(user,pass);
                if(res == true) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(LoginActivity.this,"Neuspesno logovanje",Toast.LENGTH_SHORT).show();
            }
        });



    }


}
