package com.SOC.attendify;

import android.graphics.Color;
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

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class S3 extends AppCompatActivity {
    public int a,b;
    public Button btn1,btn2,save;


    private TextView t;
    int c=a;
    int d=b;
    private DatabaseReference mDatabaseReference;
    private DatabaseReference mDatabase;
    String currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid();

    PieChartView pieChartView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s3);
        mDatabase= FirebaseDatabase.getInstance().getReference().child(currentuser);
        btn1 = (Button) findViewById(R.id.button14);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView tv = (TextView) findViewById(R.id.textView27);
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
                List pieData = new ArrayList<>();
                if (b == 0) {
                    pieData.add(new SliceValue(0, Color.GREEN).setLabel("Attend"));
                    pieData.add(new SliceValue(0, Color.RED).setLabel("Absent"));
                } else {
                    pieData.add(new SliceValue(a / b, Color.GREEN));
                    pieData.add(new SliceValue(1 - a / b, Color.RED));

                }
                pieChartView = findViewById(R.id.chart7);

                PieChartData pieChartData = new PieChartData(pieData);
                pieChartData.setHasLabels(true).setValueLabelTextSize(0);
                pieChartData.setHasCenterCircle(true);
                pieChartView.setPieChartData(pieChartData);

            }});
        btn2 = (Button) findViewById(R.id.button15);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tv = (TextView) findViewById(R.id.textView27);

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
                List pieData = new ArrayList<>();
                if (b==0)
                {
                    pieData.add(new SliceValue(0, Color.GREEN));
                    pieData.add(new SliceValue(0, Color.RED));}
                else{
                    pieData.add(new SliceValue(a/b,Color.GREEN));
                    pieData.add(new SliceValue(1-a/b, Color.RED));

                }

                pieChartView = findViewById(R.id.chart7);


                PieChartData pieChartData = new PieChartData(pieData);
                pieChartData.setHasLabels(true);
                pieChartData.setHasCenterCircle(true);
                pieChartView.setPieChartData(pieChartData);

            }});
        save=(Button) findViewById(R.id.button16) ;
        save.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {



                                        mDatabase.child("Present3").setValue(a);
                                        mDatabase.child("total3").setValue(b);




                                    }
                                }
        );

        t=(TextView) findViewById(R.id.textView26);

        mDatabase.addValueEventListener(new ValueEventListener() {
            private String converta, convertb,converta1, convertb1,converta2, convertb2,converta3, convertb3,converta4, convertb4;

            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String s;

                converta = dataSnapshot.child("Present3").getValue().toString();
                convertb = dataSnapshot.child("total3").getValue().toString();
                s=  dataSnapshot.child("Subject 3").getValue().toString();
                t.setText(s);

                a = Integer.parseInt(converta);
                b = Integer.parseInt(convertb);
                c=a;
                d=b;





            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });





    }}
