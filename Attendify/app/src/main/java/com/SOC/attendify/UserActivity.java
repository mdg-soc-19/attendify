package com.SOC.attendify;
import android.content.Intent;;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserActivity extends AppCompatActivity {
    Button btnLogOut,stats,preplanning,notification,aboutus,reschedule;
    FirebaseAuth firebaseAuth;
    private TextView username;
    private FirebaseAuth.AuthStateListener authStateListener;
    private DatabaseReference mDatabaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("Present");

        username=(TextView) findViewById(R.id.Welcome);
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        String name= dataSnapshot.getValue().toString();
        username.setText("Welcome" + name);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        btnLogOut = (Button) findViewById(R.id.btnLogOut);
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseAuth.getInstance().signOut();
                Intent I = new Intent(UserActivity.this, ActivityLogin.class);
                startActivity(I);

            }
        });
        stats=(Button) findViewById(R.id.button);
        stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseAuth.getInstance().signOut();
                Intent I = new Intent(UserActivity.this, Subjects.class);
                startActivity(I);

            }
        });
        stats=(Button) findViewById(R.id.button);
        stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(UserActivity.this, Subjects.class);
                startActivity(I);

            }
        });
        preplanning=(Button) findViewById(R.id.button2);
        preplanning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent I = new Intent(UserActivity.this, preplanning_activity.class);
                startActivity(I);

            }
        });
        notification=(Button) findViewById(R.id.button3);
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent I = new Intent(UserActivity.this, Notification_activity.class);
                startActivity(I);

            }
        });

        reschedule=(Button) findViewById(R.id.button4);
       reschedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent I = new Intent(UserActivity.this, Rescheduled_activity.class);
                startActivity(I);

            }
        });
        aboutus=(Button) findViewById(R.id.button5);
        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent I = new Intent(UserActivity.this, Aboutus_activity.class);
                startActivity(I);

            }
        });
    }



}