//package com.example.rentezz;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.CheckBox;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class LoginActivity extends AppCompatActivity {
//
//    private EditText emailInput, passwordInput;
//    private CheckBox rememberMe;
//    private Button loginButton;
//    private TextView forgotPassword;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//        // Initialize UI components
//        emailInput = findViewById(R.id.email_input);
//        passwordInput = findViewById(R.id.password_input);
//        rememberMe = findViewById(R.id.remember_me);
//        loginButton = findViewById(R.id.login_button);
//        forgotPassword = findViewById(R.id.forgot_password);
//
//        // Login button click listener
//        loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String email = emailInput.getText().toString().trim();
//                String password = passwordInput.getText().toString().trim();
//
//                if (email.isEmpty() || password.isEmpty()) {
//                    Toast.makeText(LoginActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(LoginActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//
//        // Forgot password click listener
//        forgotPassword.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(LoginActivity.this, "Forgot Password Clicked", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//}
