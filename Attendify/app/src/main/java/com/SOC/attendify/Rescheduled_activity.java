package com.SOC.attendify;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Rescheduled_activity extends AppCompatActivity {
    Button save;
    TextView a,b,c,d,e,f,g,h,i,j,k,l,m,n;
    private DatabaseReference mDatabase;
    String currentuser= FirebaseAuth.getInstance().getCurrentUser().getUid();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rescheduled);

a=(EditText) findViewById(R.id.edittext2);
        b=(EditText) findViewById(R.id.edittext3);
        c=(EditText) findViewById(R.id.edittext4);
        d=(EditText) findViewById(R.id.edittext5);
        e=(EditText) findViewById(R.id.edittext6);
        f=(EditText) findViewById(R.id.edittext7);
        g=(EditText) findViewById(R.id.edittext14);
        h=(EditText) findViewById(R.id.edittext17);
        i=(EditText) findViewById(R.id.edittext18);
        j=(EditText) findViewById(R.id.edittext19);
        k=(EditText) findViewById(R.id.edittext20);
        l=(EditText) findViewById(R.id.edittext21);
        m=(EditText) findViewById(R.id.edittext22);
        n=(EditText) findViewById(R.id.edittext23);



        mDatabase= FirebaseDatabase.getInstance().getReference();
         save=(Button) findViewById(R.id.button20);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String A,B,C,D,E,F,G,H,I,J,K,L,M,N;
                A=a.getText().toString();
                B=b.getText().toString();
               C=c.getText().toString();
                D=d.getText().toString();
                E=e.getText().toString();
                F=f.getText().toString();
                G=g.getText().toString();
                H=h.getText().toString();
                I=i.getText().toString();
                J=j.getText().toString();
                K=k.getText().toString();
                L=l.getText().toString();
                M=m.getText().toString();
                N=n.getText().toString();

                mDatabase.child("new1").setValue(A);
                mDatabase.child("new2").setValue(B);
                mDatabase.child("new3").setValue(C);
                mDatabase.child("new4").setValue(D);
                mDatabase.child("new5").setValue(E);
                mDatabase.child("new6").setValue(F);
                mDatabase.child("new7").setValue(G);
                mDatabase.child("new8").setValue(H);
                mDatabase.child("new9").setValue(I);
                mDatabase.child("new10").setValue(J);
                mDatabase.child("new11").setValue(K);
                mDatabase.child("new12").setValue(L);
                mDatabase.child("new13").setValue(M);
                mDatabase.child("new14").setValue(N);


                Intent Z=new Intent(Rescheduled_activity.this,MainActivity.class);
                startActivity(Z);

            }
        });


        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String     str1 =dataSnapshot.child("new1").getValue().toString();
                a.setText(str1);
                String     str2 =dataSnapshot.child("new2").getValue().toString();
                b.setText(str2);
                String     str3 =dataSnapshot.child("new3").getValue().toString();
                c.setText(str3);
                String     str4 =dataSnapshot.child("new4").getValue().toString();
                d.setText(str4);
                String     str5 =dataSnapshot.child("new5").getValue().toString();
                e.setText(str5);
                String     str6 =dataSnapshot.child("new6").getValue().toString();
                f.setText(str6);
                String     str7 =dataSnapshot.child("new7").getValue().toString();
                g.setText(str7);
                String     str8 =dataSnapshot.child("new8").getValue().toString();
                h.setText(str8);
                String     str9 =dataSnapshot.child("new9").getValue().toString();
                i.setText(str9);
                String     str10 =dataSnapshot.child("new10").getValue().toString();
                j.setText(str10);
                String     str11 =dataSnapshot.child("new11").getValue().toString();
                k.setText(str11);
                String     str12 =dataSnapshot.child("new12").getValue().toString();
                l.setText(str12);
                String     str13=dataSnapshot.child("new13").getValue().toString();
                m.setText(str13);
                String     str14 =dataSnapshot.child("new14").getValue().toString();
                n.setText(str14);



            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });





    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            onBackPressed();
        }

        return false;
    }

    @Override
    public void onBackPressed() {
        Intent I=new Intent(Rescheduled_activity.this,MainActivity.class);
        startActivity(I);
        //this is only needed if you have specific things
        //that you want to do when the user presses the back button.
        /* your specific things...*/
        super.onBackPressed();
    }

}