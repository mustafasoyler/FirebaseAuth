package com.example.firebaseauth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth auth;
    FirebaseUser user;
    Button çıkış,şifreDeğiş;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        if (user==null)
        {
            Intent  intent=new Intent(this,GirisYapActivity.class);
            startActivity(intent);
            finish();
        }
        else{
            Log.i("kullanıcı",user.getUid());
        }
        çıkış.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut();

                Intent  intent=new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        şifreDeğiş.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent=new Intent(MainActivity.this,SifreDegis.class);
                startActivity(intent);
                finish();
            }
        });
    }
    void tanimla()
    {
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
        çıkış=findViewById(R.id.cıkıs);
        şifreDeğiş=findViewById(R.id.sifreDeğis);
    }
}
