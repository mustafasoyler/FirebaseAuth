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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SifreDegis extends AppCompatActivity {
    EditText   şifreYeni;
    Button  yeiSifre;
    FirebaseAuth    auth;
    FirebaseUser    user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sifre_degis);
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
        şifreYeni=findViewById(R.id.sifreYeni);
        yeiSifre=findViewById(R.id.yeiSifre);
        yeiSifre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                degis(şifreYeni.getText().toString());
            }
        });
    }
    void degis(String  newPass )
    {
        user.updatePassword(newPass).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful())
                {
                    Intent intent=new Intent(SifreDegis.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
