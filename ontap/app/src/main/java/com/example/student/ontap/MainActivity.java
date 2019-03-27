package com.example.student.ontap;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {
    FirebaseAuth auth;
    private Button btn_Login,btn_logout,btn_Regiter;
    private EditText edt_Password,edt_UserName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Anh Xa :
        btn_Login = findViewById(R.id.btn_Login);
        btn_logout=findViewById(R.id.btn_Logout);
        btn_Regiter=findViewById(R.id.btn_Regiter);
        edt_Password = findViewById(R.id.edt_Password);
        edt_UserName = findViewById(R.id.edt_UserName);
        auth=FirebaseAuth.getInstance();
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edt_UserName.getText().toString().trim();
                String pass = edt_Password.getText().toString().trim();
                auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Thanh cong", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(MainActivity.this,Login_activity.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(MainActivity.this, "Ko thanh cong", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

//                auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if(task.isSuccessful()){
//                            Toast.makeText(MainActivity.this, "Dang Nhap Thanh Cong", Toast.LENGTH_SHORT).show();
//                        }
//                        else{
//                            Toast.makeText(MainActivity.this, "Dang Nhap Khong Thanh Cong", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
          }
       });

        btn_Regiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edt_UserName.getText().toString().trim();
                String pass = edt_Password.getText().toString().trim();
                auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Dang ki Thanh cong", Toast.LENGTH_SHORT).show();


                        }
                        else {
                            Toast.makeText(MainActivity.this, "DK Ko thanh cong", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
