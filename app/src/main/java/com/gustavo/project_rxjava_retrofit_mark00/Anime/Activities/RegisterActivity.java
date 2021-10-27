package com.gustavo.project_rxjava_retrofit_mark00.Anime.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.gustavo.project_rxjava_retrofit_mark00.Anime.Activities.Model.User;
import com.gustavo.project_rxjava_retrofit_mark00.R;

public class RegisterActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnRegister;
    private User user;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        
        setupViewRegister();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recoveryData();
                createUser();
            }
        });
    }

    private void setupViewRegister() {
        user = new User();
        mAuth = FirebaseAuth.getInstance();
        etEmail = findViewById(R.id.txt_email);
        etPassword = findViewById(R.id.txt_password);
        btnRegister = findViewById(R.id.txt_register);
    }

    private void recoveryData() {
        user.setEmail(etEmail.getText().toString());
        user.setPassword(etPassword.getText().toString());
    }

    private void createUser() {
        mAuth.createUserWithEmailAndPassword(user.getEmail(), user.getPassword())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser fireBaseUser = mAuth.getCurrentUser();
                            user.setId(fireBaseUser.getUid());
                            user.saveData();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        }  else {
                            Toast.makeText(getApplicationContext(), "Error to create login", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}