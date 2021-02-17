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

public class RegisterActivity extends AppCompatActivity {
    EditText txtusername;
    EditText txtpassword;
    EditText txtconfirmpass;
    Button btnreg;
    DatabaseHelper db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);
        txtusername = (EditText) findViewById(R.id.txtnewusername);
        txtpassword = (EditText) findViewById(R.id.txtnewpassword);
        txtconfirmpass =(EditText) findViewById(R.id.txtconfirmpass);
        btnreg = (Button) findViewById(R.id.btnreg);

        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = txtusername.getText().toString();
                String pass = txtpassword.getText().toString();
                String cnf = txtconfirmpass.getText().toString();

                if(pass.equals(cnf)) {
                    long val = db.addUser(user, pass);
                    if (val > 0) {
                        Toast.makeText(RegisterActivity.this, "Uspesno Registrovanje", Toast.LENGTH_SHORT).show();

                        Intent loginintent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(loginintent);
                    } else {
                        Toast.makeText(RegisterActivity.this, "Sifra nije ista", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(RegisterActivity.this, "Sifra nije ista", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}

