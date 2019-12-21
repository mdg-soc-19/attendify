package com.SOC.attendify;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;

import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Subjects extends AppCompatActivity {
   int a;
    private TextView s1,s2,s3,s4,s5,s6,s7;
   Button btn,btn2,S1,S2,S3,S4,S5,S6,S7;
   private DatabaseReference mDatabase;
    String currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subjects);
        mDatabase= FirebaseDatabase.getInstance().getReference().child(currentuser);
        s1 = (EditText) findViewById(R.id.edittext);
        s2 = (EditText) findViewById(R.id.edittext8);
        s3 = (EditText) findViewById(R.id.edittext9);
        s4 = (EditText) findViewById(R.id.edittext10);
        s5 = (EditText) findViewById(R.id.edittext11);
        s6 = (EditText) findViewById(R.id.edittext12);
        s7 = (EditText) findViewById(R.id.edittext13);
        btn = (Button) findViewById(R.id.button7);


        btn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                a++;
                String str1 = s1.getText().toString();
                String str2 = s2.getText().toString();
                String str3 = s3.getText().toString();
                String str4 = s4.getText().toString();
                String str5 = s5.getText().toString();
                String str6 = s6.getText().toString();
                String str7 = s7.getText().toString();

                mDatabase.child("Subject 1").setValue(str1);
                mDatabase.child("Subject 2").setValue(str2);
                mDatabase.child("Subject 3").setValue(str3);
                mDatabase.child("Subject 4").setValue(str4);
                mDatabase.child("Subject 5").setValue(str5);
                mDatabase.child("Subject 6").setValue(str6);
                mDatabase.child("Subject 7").setValue(str7);
mDatabase.child("a").setValue(a);
                Intent I = new Intent(Subjects.this, Stats_activity.class);
                startActivity(I);



            }
        });









        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
          String     str1 =dataSnapshot.child("Subject 1").getValue().toString();
          s1.setText(str1);
                String     str2 =dataSnapshot.child("Subject 2").getValue().toString();
                s2.setText(str2);
                String     str3 =dataSnapshot.child("Subject 3").getValue().toString();
                s3.setText(str3);
                String     str4 =dataSnapshot.child("Subject 4").getValue().toString();
                s4.setText(str4);
                String     str5 =dataSnapshot.child("Subject 5").getValue().toString();
                s5.setText(str5);
                String     str6 =dataSnapshot.child("Subject 6").getValue().toString();
                s6.setText(str6);
                String     str7 =dataSnapshot.child("Subject 7").getValue().toString();
                s7.setText(str7);
            String str8=dataSnapshot.child("a").getValue().toString();
            a=Integer.parseInt(str8);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        if (a==0)
        { mDatabase.child("Subject 1").setValue("Add the subject 1");
            mDatabase.child("Subject 2").setValue("Add the subject 2");
            mDatabase.child("Subject 3").setValue("Add the subject 3");
            mDatabase.child("Subject 4").setValue("Add the subject 4");
            mDatabase.child("Subject 5").setValue("Add the subject 5");
            mDatabase.child("Subject 6").setValue("Add the subject 6");
            mDatabase.child("Subject 7").setValue("Add the subject 7");
            mDatabase.child("a").setValue(0);}


    }

}