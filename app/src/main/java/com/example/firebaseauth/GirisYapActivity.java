package com.example.firebaseauth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class GirisYapActivity extends AppCompatActivity {
    EditText   kadi,şifre;
    Button  kayıt;
    FirebaseAuth   auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_yap);
        tanimla();
        action();
    }
    void tanimla()
    {
        kadi=findViewById(R.id.kadi);
        şifre=findViewById(R.id.sifre);
        kayıt=findViewById(R.id.kayit);
        auth=FirebaseAuth.getInstance();
    }
    void action()
    {
        kayıt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                girisYap(kadi.getText().toString(),şifre.getText().toString());

            }
        });
    }
    void girisYap(String mail,String pass)
    {
        auth.signInWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Intent intent=new Intent(GirisYapActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
