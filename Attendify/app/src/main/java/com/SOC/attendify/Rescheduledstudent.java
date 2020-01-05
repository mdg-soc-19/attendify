package com.SOC.attendify;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Rescheduledstudent extends AppCompatActivity {
TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14;
private DatabaseReference mDatabase;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reschedulestudent);

        t1=(TextView) findViewById(R.id.textView78);
        t2=(TextView) findViewById(R.id.textView79);
        t3=(TextView) findViewById(R.id.textView80);
        t4=(TextView) findViewById(R.id.textView81);
        t5=(TextView) findViewById(R.id.textView82);
        t6=(TextView) findViewById(R.id.textView83);
        t7=(TextView) findViewById(R.id.textView84);
    t8=(TextView) findViewById(R.id.textView87);
    t9=(TextView) findViewById(R.id.textView89);
    t10=(TextView) findViewById(R.id.textView90);
    t11=(TextView) findViewById(R.id.textView91);
    t12=(TextView) findViewById(R.id.textView92);
    t13=(TextView) findViewById(R.id.textView93);
    t14=(TextView) findViewById(R.id.textView102);


    mDatabase= FirebaseDatabase.getInstance().getReference();

    mDatabase.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            String     str1 =dataSnapshot.child("new1").getValue().toString();
            t1.setText(str1);
            String     str2 =dataSnapshot.child("new2").getValue().toString();
            t2.setText(str2);
            String     str3 =dataSnapshot.child("new3").getValue().toString();
            t3.setText(str3);
            String     str4 =dataSnapshot.child("new4").getValue().toString();
            t4.setText(str4);
            String     str5 =dataSnapshot.child("new5").getValue().toString();
            t5.setText(str5);
            String     str6 =dataSnapshot.child("new6").getValue().toString();
            t6.setText(str6);
            String     str7 =dataSnapshot.child("new7").getValue().toString();
            t7.setText(str7);
            String     str8 =dataSnapshot.child("new8").getValue().toString();
            t8.setText(str8);
            String     str9 =dataSnapshot.child("new9").getValue().toString();
            t9.setText(str9);
            String     str10 =dataSnapshot.child("new10").getValue().toString();
            t10.setText(str10);
            String     str11 =dataSnapshot.child("new11").getValue().toString();
            t11.setText(str11);
            String     str12 =dataSnapshot.child("new12").getValue().toString();
            t12.setText(str12);
            String     str13 =dataSnapshot.child("new13").getValue().toString();
            t13.setText(str13);
            String     str14 =dataSnapshot.child("new14").getValue().toString();
            t14.setText(str14);







        }


        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });



}



}
