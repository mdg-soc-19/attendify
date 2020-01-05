package com.SOC.attendify;

import android.content.Intent;
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

import lecho.lib.hellocharts.view.PieChartView;

public class S4 extends AppCompatActivity {
    public int a,b;
    public Button btn1,btn2,save;


    private TextView t,t1,t2,t3,t4;;
    int c=a;
    int d=b;
    private DatabaseReference mDatabaseReference;
    private DatabaseReference mDatabase;
    String currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid();

    PieChartView pieChartView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s4);
        mDatabase= FirebaseDatabase.getInstance().getReference().child(currentuser);
        btn1 = (Button) findViewById(R.id.button17);
        t1=(TextView) findViewById(R.id.textView34);
        t2=(TextView) findViewById(R.id.textView35);
        t3=(TextView) findViewById(R.id.textView36);
        t4=(TextView) findViewById(R.id.textView7);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView tv = (TextView) findViewById(R.id.textView33);
                if (b == d) {
                    b++;
                    a++;
                    tv.setText(a * 100 / b + "%");
                    btn1.setEnabled(false);
                    btn2.setEnabled(true);
                } else {
                    a++;
                    tv.setText(a * 100 / b + "%");
                    btn1.setEnabled(false);
                    btn2.setEnabled(true);
                }

            }});
        btn2 = (Button) findViewById(R.id.button18);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tv = (TextView) findViewById(R.id.textView33);

                if (a != c) {
                    a -= 1;
                    tv.setText(a * 100 / b + "%");
                    btn2.setEnabled(false);
                    btn1.setEnabled(true);
                } else {
                    b++;
                    tv.setText(a * 100 / b + "%");
                    btn2.setEnabled(false);
                    btn1.setEnabled(true);
                }


            }});
        save=(Button) findViewById(R.id.button35) ;
        save.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {



                                        mDatabase.child("Present4").setValue(a);
                                        mDatabase.child("total4").setValue(b);



                                        t1.setText("Total Classes :" + b);
                                        t2.setText("Attended :" + a);
                                        t3.setText("Absent :" + (b-a));


                                        if (b!=0)
                                        {
                                            if ((a * 100 / b) < 75) {
                                                int count = 0;

                                                while ((a*100/b<75)) {
                                                    a++;
                                                    b++;
                                                    count++;

                                                }
                                                t4.setText("Attend next " + (count) +" classes to get your attendance to 75%");
                                                a-=count;
                                                b-=count;
                                                count=0;
                                            }
                                            else if (( a* 100 / b) >75)

                                            {  int count = 0;


                                                while ((a * 100 / b) >75) {
                                                    b++;
                                                    count++;
                                                }
                                                t4.setText("You can bunk next " + (count-1) + "classes for >75% attendace");
                                                b-=count;
                                                count=0;}

                                            else if ((a*100/b)==75 )
                                            {t4.setText("You cannot bunk any class");
                                            }
                                        }
                                        Intent I=new Intent(S4.this,Stats_1_Activity.class);
                                        startActivity(I);

                                    }
                                }
        );

        t=(TextView) findViewById(R.id.textView32);

        mDatabase.addValueEventListener(new ValueEventListener() {
            private String converta, convertb,converta1, convertb1,converta2, convertb2,converta3, convertb3,converta4, convertb4;

            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String s;

                converta = dataSnapshot.child("Present4").getValue().toString();
                convertb=  dataSnapshot.child("total4").getValue().toString();
                s=  dataSnapshot.child("Subject 4").getValue().toString();
                t.setText(s);

                a = Integer.parseInt(converta);
                b = Integer.parseInt(convertb);
                c=a;
                d=b;



                t1.setText("Total Classes :" + b);
                t2.setText("Present :" + a );
                t3.setText("Absent :" + (b-a));


                if (b!=0)
                {

                    if ((a * 100 / b) < 75) {
                        int count = 0;

                        while ((a*100/b<75)) {
                            a++;
                            b++;
                            count++;

                        }
                        a-=count;
                        b-=count;
                        t4.setText("Attend next " + (count) +" classes to get your attendance to 75%");
                    } else if (( a* 100 / b )> 75)
                    {
                        int count = 0;

                        while ((a * 100 / b) >75) {
                            b++;
                            count++;
                        }
                        b-=count;
                        t4.setText("You can bunk next " + (count-1) + "classes for >75% attendace");
                        count=0;
                    }
                    else if ((a*100/b)==75 )
                    {t4.setText("You cannot bunk any class");
                    }
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });





    }}
