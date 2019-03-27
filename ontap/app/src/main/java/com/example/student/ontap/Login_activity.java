package com.example.student.ontap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Login_activity extends AppCompatActivity {
    Button btn_logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);

        btn_logout=findViewById(R.id.btn_Logout);

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(Login_activity.this, "Da dang xuat", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Login_activity.this,MainActivity.class);
                startActivity(intent);

            }
        });
    }
}
