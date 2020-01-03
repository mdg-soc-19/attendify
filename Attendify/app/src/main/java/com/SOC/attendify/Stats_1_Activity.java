package com.SOC.attendify;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.BoolRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class Stats_1_Activity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8,btn9,btn10;
    private Button save;
    TextView t1,t2,t3,t4,t5,t6,t7;




    private DatabaseReference mDatabaseReference;
private DatabaseReference mDatabase;
    String currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid();

    PieChartView pieChartView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats1);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child(currentuser);
         mDatabase=FirebaseDatabase.getInstance().getReference().child(currentuser);


        t1=(TextView) findViewById(R.id.textView56);
        t2=(TextView) findViewById(R.id.textView57);
        t3=(TextView) findViewById(R.id.textView58);
        t4=(TextView) findViewById(R.id.textView59);
        t5=(TextView) findViewById(R.id.textView60);
        t6=(TextView) findViewById(R.id.textView61);
        t7=(TextView) findViewById(R.id.textView62);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I=new Intent(Stats_1_Activity.this,S1.class);
                startActivity(I);
            }
        });


        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I=new Intent(Stats_1_Activity.this,S2.class);
                startActivity(I);
            }
        });


        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I=new Intent(Stats_1_Activity.this,S3.class);
                startActivity(I);
            }
        });



        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I=new Intent(Stats_1_Activity.this,S4.class);
                startActivity(I);
            }
        });



        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I=new Intent(Stats_1_Activity.this,S5.class);
                startActivity(I);
            }
        });


        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I=new Intent(Stats_1_Activity.this,S6.class);
                startActivity(I);
            }
        });


        t7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I=new Intent(Stats_1_Activity.this,S7.class);
                startActivity(I);}
        });
mDatabaseReference.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        String s1,s2,s3,s4,s5,s6,s7;
        s1=dataSnapshot.child("Subject 1").getValue().toString();
        s2=dataSnapshot.child("Subject 2").getValue().toString();
        s3=dataSnapshot.child("Subject 3").getValue().toString();
        s4=dataSnapshot.child("Subject 4").getValue().toString();
        s5=dataSnapshot.child("Subject 5").getValue().toString();
        s6=dataSnapshot.child("Subject 6").getValue().toString();
        s7=dataSnapshot.child("Subject 7").getValue().toString();


   t1.setText(s1);
   t2.setText(s2);
   t3.setText(s3);
   t4.setText(s4);
   t5.setText(s5);
   t6.setText(s6);
   t7.setText(s7);
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});


}}
