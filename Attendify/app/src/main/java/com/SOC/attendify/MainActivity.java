package com.SOC.attendify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    public EditText emailId, passwd;
    Button btnSignUp,faculty;
    TextView signIn,username;
    String Name;
    ProgressBar progressBar;
    FirebaseAuth firebaseAuth;
    private DatabaseReference mDatabaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=(EditText) findViewById(R.id.username);
        Name=username.getText().toString();
        firebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.ETemail);
        passwd = findViewById(R.id.ETpassword);
        btnSignUp = findViewById(R.id.btnSignUp);
        progressBar=(ProgressBar) findViewById(R.id.simpleProgressBar);
        signIn = findViewById(R.id.TVSignIn);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailID = emailId.getText().toString();
                String paswd = passwd.getText().toString();
                if (emailID.isEmpty()) {
                    emailId.setError("Provide your Email first!");
                    emailId.requestFocus();
                } else if (paswd.isEmpty()) {
                    passwd.setError("Set your password");
                    passwd.requestFocus();
                } else if (emailID.isEmpty() && paswd.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Fields Empty!", Toast.LENGTH_SHORT).show();
                } else if (!(emailID.isEmpty() && paswd.isEmpty())) {
                    firebaseAuth.createUserWithEmailAndPassword(emailID, paswd).addOnCompleteListener(MainActivity.this, new OnCompleteListener() {
                        @Override
                        public void onComplete(@NonNull Task task) {

                            if (!task.isSuccessful()) {
                                Toast.makeText(MainActivity.this.getApplicationContext(),
                                        "SignUp unsuccessful: " + task.getException().getMessage(),
                                        Toast.LENGTH_SHORT).show();

                            } else {
                                startActivity(new Intent(MainActivity.this, UserActivity.class));
                                startActivity(new Intent(MainActivity.this, UserActivity.class));
                                String currentuser=FirebaseAuth.getInstance().getCurrentUser().getUid();
                                mDatabaseReference=FirebaseDatabase.getInstance().getReference().child(currentuser);
                                mDatabaseReference.child("Present1").setValue(0);
                                mDatabaseReference.child("total1").setValue(0);

                                mDatabaseReference.child("Present2").setValue(0);
                                mDatabaseReference.child("total2").setValue(0);

                                mDatabaseReference.child("Present3").setValue(0);
                                mDatabaseReference.child("total3").setValue(0);

                                mDatabaseReference.child("Present4").setValue(0);
                                mDatabaseReference.child("total4").setValue(0);

                                mDatabaseReference.child("Present5").setValue(0);
                                mDatabaseReference.child("total5").setValue(0);

                                mDatabaseReference.child("Present6").setValue(0);
                                mDatabaseReference.child("total6").setValue(0);

                                mDatabaseReference.child("Present7").setValue(0);
                                mDatabaseReference.child("total7").setValue(0);

                            mDatabaseReference.child("Subject 1").setValue("");
                                mDatabaseReference.child("Subject 2").setValue("");
                                mDatabaseReference.child("Subject 3").setValue("");
                                mDatabaseReference.child("Subject 4").setValue("");
                                mDatabaseReference.child("Subject 5").setValue("");
                                mDatabaseReference.child("Subject 6").setValue("");
                                mDatabaseReference.child("Subject 7").setValue("");
                                mDatabaseReference.child("status").setValue("");
                                Name=username.getText().toString();
                                mDatabaseReference.child("Name").setValue(Name);

progressBar.setVisibility(View.VISIBLE);

                            }
                        }
                    });
                } else {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }




            }
        });
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(MainActivity.this, ActivityLogin.class);
                startActivity(I);
            }
        });
        faculty= (Button) findViewById(R.id.button22);
        faculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();

                Intent I=new Intent (MainActivity.this,Faculty_login.class);
            startActivity(I);

            }
        });


    }
}