package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        findViewById(R.id.register_btn).setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.register_btn:
                    signUp();
                    break;
            }
        }

    };

    private void signUp() {
        String id =
                ((EditText) findViewById(R.id.id_et)).getText().toString();
        String password =
                ((EditText) findViewById(R.id.pw_et)).getText().toString();
        String passwordCheck =
                ((EditText) findViewById(R.id.pw_check_et)).getText().toString();
        if (id.length() > 0 && password.length() > 0 && passwordCheck.length() > 0) {
            if (password.equals(passwordCheck)) {
                mAuth.createUserWithEmailAndPassword(id, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {

                                        if (task.isSuccessful()) {
                                            Toast.makeText(SignUpActivity.this, "회원가입 완료"
                                                    , Toast.LENGTH_SHORT).show();
                                        } else {
                                            if (task.getException().toString() != null) {
                                                Toast.makeText(SignUpActivity.this, "회원가입 실패"
                                                        , Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    }
                                });
            } else {
                Toast.makeText(SignUpActivity.this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(SignUpActivity.this, "아이디와 비밀번호를 확인하세요.", Toast.LENGTH_SHORT).show();
        }
    }
}





