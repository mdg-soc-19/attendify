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
    public int a = 0, b = 0, a1 = 0, b1 = 0,a2=0,a3=0,a4=0,a5=0,b2=0,b3=0,b4=0,b5=0,initial;
    String s1,s2,s3,s4,s5,s6,s7;
    TextView t1,t2,t3,t4,t5,t6,t7;

    int c = a;

    int d = b;
    int c1 = a1;
    int d1 = b1;
    int c2 = a2;
    int d2 = b2;
    int c3 = a3;
    int d3 = b3;
    int c4 = a4;
    int d4 = b4;
    int c5 = a5;
    int d5 = b5;

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
t1=(TextView) findViewById(R.id.textView6);
        t2=(TextView) findViewById(R.id.textView5);
        t3=(TextView) findViewById(R.id.textView9);
        t4=(TextView) findViewById(R.id.textView11);
        t5=(TextView) findViewById(R.id.textView13);






save=(Button) findViewById(R.id.button34);
        save.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        initial++;


                                      mDatabaseReference.child("Present1").setValue(a);
                                      mDatabaseReference.child("total1").setValue(b);

                                        mDatabaseReference.child("Present2").setValue(a1);
                                        mDatabaseReference.child("total2").setValue(b1);

                                        mDatabaseReference.child("Present3").setValue(a2);
                                        mDatabaseReference.child("total3").setValue(b2);

                                        mDatabaseReference.child("Present4").setValue(a3);
                                        mDatabaseReference.child("total4").setValue(b3);

                                        mDatabaseReference.child("Present5").setValue(a4);
                                        mDatabaseReference.child("total5").setValue(b4);



                                    }
                                }
        );
         mDatabase.addValueEventListener(new ValueEventListener() {
            private String converta, convertb,converta1, convertb1,converta2, convertb2,converta3, convertb3,converta4, convertb4;

            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                    converta = dataSnapshot.child("Present1").getValue().toString();
                    convertb = dataSnapshot.child("total1").getValue().toString();
                converta1 = dataSnapshot.child("Present2").getValue().toString();
                convertb1 = dataSnapshot.child("total2").getValue().toString();
                converta2 = dataSnapshot.child("Present3").getValue().toString();
                convertb2 = dataSnapshot.child("total3").getValue().toString();
                converta3 = dataSnapshot.child("Present4").getValue().toString();
                convertb3 = dataSnapshot.child("total4").getValue().toString();
                converta4 = dataSnapshot.child("Present5").getValue().toString();
                convertb4 = dataSnapshot.child("total5").getValue().toString();
                s1=dataSnapshot.child("Subject 1").getValue().toString();
                s2=dataSnapshot.child("Subject 2").getValue().toString();
                s3=dataSnapshot.child("Subject 3").getValue().toString();
                s4=dataSnapshot.child("Subject 4").getValue().toString();
                s5=dataSnapshot.child("Subject 5").getValue().toString();

                t1.setText(s1);
                t2.setText(s2);
                t3.setText(s3);
                t4.setText(s4);
                t5.setText(s5);
                a = Integer.parseInt(converta);
                b = Integer.parseInt(convertb);
                c=a;
                d=b;


                a1 = Integer.parseInt(converta1);
                b1 = Integer.parseInt(convertb1);
                c1=a1;
                d1 =b1;


                a4= Integer.parseInt(converta4);
                b4 = Integer.parseInt(convertb4);
                c4=a4;
                d4 =b4;


                a2 = Integer.parseInt(converta2);
                b2 = Integer.parseInt(convertb2);
                c2=a2;
                d2=b2;


                a3 = Integer.parseInt(converta3);
                b3 = Integer.parseInt(convertb3);
                c3=a3;
                d3=b3;


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        TextView txt1= (TextView) findViewById(R.id.textView8);
if (b!=0)
{txt1.setText(a*100/b);}
        btn1 = (Button) findViewById(R.id.button19);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView tv = (TextView) findViewById(R.id.textView8);
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
                if (b==0) {
                    pieData.add(new SliceValue(0, Color.GREEN).setLabel("Attend"));
                    pieData.add(new SliceValue(0, Color.RED).setLabel("Absent"));
                }
                else{
                    pieData.add(new SliceValue(a/b, Color.GREEN).setLabel("Attend"));
                    pieData.add(new SliceValue(1-a/b, Color.RED).setLabel("Absent"));

                }
                pieChartView = findViewById(R.id.chart);

                PieChartData pieChartData = new PieChartData(pieData);
                pieChartData.setHasLabels(true).setValueLabelTextSize(0);
                pieChartData.setHasCenterCircle(true);
                pieChartView.setPieChartData(pieChartData);
            }
        }
        );
        btn2 = (Button) findViewById(R.id.button20);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tv = (TextView) findViewById(R.id.textView8);

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
                    pieData.add(new SliceValue(a/b, Color.GREEN));
                    pieData.add(new SliceValue(1-a/b, Color.RED));

                }

                pieChartView = findViewById(R.id.chart);


                PieChartData pieChartData = new PieChartData(pieData);
                pieChartData.setHasLabels(true).setValueLabelTextSize(0);
                pieChartData.setHasCenterCircle(true);
                pieChartView.setPieChartData(pieChartData);
            }

            ;

        });
        btn3 = (Button) findViewById(R.id.button22);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tv = (TextView) findViewById(R.id.textView7);
                if (b1 == d1) {
                    b1++;
                    a1++;
                    tv.setText(a1 * 100 / b1 + "%");
                    btn3.setEnabled(false);
                    btn4.setEnabled(true);
                } else {
                    a1++;
                    tv.setText(a1 * 100 / b1 + "%");
                    btn3.setEnabled(false);
                    btn4.setEnabled(true);
                }
                List pieData = new ArrayList<>();
                if (b2==0) {
                    pieData.add(new SliceValue(0, Color.GREEN));
                    pieData.add(new SliceValue(0, Color.RED));
                }
                else{
                    pieData.add(new SliceValue(a1/b1, Color.GREEN));
                    pieData.add(new SliceValue(1-a1 /b1, Color.RED));

                }
                pieChartView = findViewById(R.id.chart1);

                PieChartData pieChartData = new PieChartData(pieData);
                pieChartData.setHasLabels(true).setValueLabelTextSize(0);
                pieChartData.setHasCenterCircle(true);
                pieChartView.setPieChartData(pieChartData);
            }
        });


        btn4 = (Button) findViewById(R.id.button23);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tv = (TextView) findViewById(R.id.textView7);
                if (a1 != c1) {
                    a1 -= 1;
                    tv.setText(a1 * 100 / b1 + "%");
                    btn4.setEnabled(false);
                    btn3.setEnabled(true);
                } else {
                    b1++;
                    tv.setText(a1 * 100 / b1 + "%");
                    btn4.setEnabled(false);
                    btn3.setEnabled(true);
                }
                List pieData = new ArrayList<>();
                if (b1 == 0) {
                    pieData.add(new SliceValue(0, Color.GREEN));
                    pieData.add(new SliceValue(0, Color.RED));
                } else {
                    pieData.add(new SliceValue(a1 / b1, Color.GREEN));
                    pieData.add(new SliceValue(1 - a1 / b1, Color.RED));

                }

                pieChartView = findViewById(R.id.chart1);


                PieChartData pieChartData = new PieChartData(pieData);
                pieChartData.setHasLabels(true).setValueLabelTextSize(0);
                pieChartData.setHasCenterCircle(true);
                pieChartView.setPieChartData(pieChartData);

            }


        });

        btn5 = (Button) findViewById(R.id.button25);
        btn5.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        TextView tv = (TextView) findViewById(R.id.textView10);
                                        if (b2 == d2) {
                                            b2++;
                                            a2++;
                                            tv.setText(a2 * 100 / b2 + "%");
                                            btn5.setEnabled(false);
                                            btn6.setEnabled(true);
                                        } else {
                                            a2++;
                                            tv.setText(a2 * 100 / b2 + "%");
                                            btn5.setEnabled(false);
                                            btn6.setEnabled(true);
                                        }
                                        List pieData = new ArrayList<>();
                                        if (b2==0) {
                                            pieData.add(new SliceValue(0, Color.GREEN));
                                            pieData.add(new SliceValue(0, Color.RED));
                                        }
                                        else{
                                            pieData.add(new SliceValue(a2/b2, Color.GREEN));
                                            pieData.add(new SliceValue(1-a2 /b2, Color.RED));

                                        }
                                        pieChartView = findViewById(R.id.chart2);

                                        PieChartData pieChartData = new PieChartData(pieData);
                                        pieChartData.setHasLabels(true).setValueLabelTextSize(0);
                                        pieChartData.setHasCenterCircle(true);
                                        pieChartView.setPieChartData(pieChartData);
                                    }
                                }
        );
        btn6 = (Button) findViewById(R.id.button26);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tv = (TextView) findViewById(R.id.textView10);
                if (a2 != c2) {
                    a2 -= 1;
                    tv.setText(a2 * 100 / b2 + "%");
                    btn6.setEnabled(false);
                    btn5.setEnabled(true);
                } else {
                    b2++;
                    tv.setText(a2 * 100 / b2 + "%");
                    btn6.setEnabled(false);
                    btn5.setEnabled(true);
                }
                List pieData = new ArrayList<>();
                if (b2==0)
                {
                    pieData.add(new SliceValue(0, Color.GREEN));
                    pieData.add(new SliceValue(0, Color.RED));}
                else{
                    pieData.add(new SliceValue(a2/b2, Color.GREEN));
                    pieData.add(new SliceValue(1-a2/b2, Color.RED));

                }

                pieChartView = findViewById(R.id.chart2);


                PieChartData pieChartData = new PieChartData(pieData);
                pieChartData.setHasLabels(true).setValueLabelTextSize(0);
                pieChartData.setHasCenterCircle(true);
                pieChartView.setPieChartData(pieChartData);
            }

            ;

        });
        btn7 = (Button) findViewById(R.id.button28);
        btn7.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        TextView tv = (TextView) findViewById(R.id.textView12);
                                        if (b3 == d3) {
                                            b3++;
                                            a3++;
                                            tv.setText(a3 * 100 / b3 + "%");
                                            btn7.setEnabled(false);
                                            btn8.setEnabled(true);
                                        } else {
                                            a3++;
                                            tv.setText(a3 * 100 / b3 + "%");
                                            btn7.setEnabled(false);
                                            btn8.setEnabled(true);
                                        }
                                        List pieData = new ArrayList<>();
                                        if (b3==0) {
                                            pieData.add(new SliceValue(0, Color.GREEN));
                                            pieData.add(new SliceValue(0, Color.RED));
                                        }
                                        else{
                                            pieData.add(new SliceValue(a3/b3, Color.GREEN));
                                            pieData.add(new SliceValue(1-a3 /b3, Color.RED));

                                        }
                                        pieChartView = findViewById(R.id.chart3);

                                        PieChartData pieChartData = new PieChartData(pieData);
                                        pieChartData.setHasLabels(true).setValueLabelTextSize(0);
                                        pieChartData.setHasCenterCircle(true);
                                        pieChartView.setPieChartData(pieChartData);
                                    }
                                }
        );
        btn8 = (Button) findViewById(R.id.button29);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tv = (TextView) findViewById(R.id.textView12);
                if (a3 != c3) {
                    a3 -= 1;
                    tv.setText(a3 * 100 / b3 + "%");
                    btn8.setEnabled(false);
                    btn7.setEnabled(true);
                } else {
                    b3++;
                    tv.setText(a3 * 100 / b3 + "%");
                    btn8.setEnabled(false);
                    btn7.setEnabled(true);
                }
                List pieData = new ArrayList<>();
                if (b3==0)
                {
                    pieData.add(new SliceValue(0, Color.GREEN));
                    pieData.add(new SliceValue(0, Color.RED));}
                else{
                    pieData.add(new SliceValue(a3/b3, Color.GREEN));
                    pieData.add(new SliceValue(1-a3/b3, Color.RED));

                }

                pieChartView = findViewById(R.id.chart3);


                PieChartData pieChartData = new PieChartData(pieData);
                pieChartData.setHasLabels(true).setValueLabelTextSize(0);
                pieChartData.setHasCenterCircle(true);
                pieChartView.setPieChartData(pieChartData);
            }

            ;

        });
        btn9 = (Button) findViewById(R.id.button31);
        btn9.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        TextView tv = (TextView) findViewById(R.id.textView14);
                                        if (b4 == d4) {
                                            b4++;
                                            a4++;
                                            tv.setText(a4 * 100 / b4 + "%");
                                            btn9.setEnabled(false);
                                            btn10.setEnabled(true);
                                        } else {
                                            a4++;
                                            tv.setText(a4 * 100 / b4 + "%");
                                            btn9.setEnabled(false);
                                            btn10.setEnabled(true);
                                        }
                                        List pieData = new ArrayList<>();
                                        if (b4==0) {
                                            pieData.add(new SliceValue(0, Color.GREEN));
                                            pieData.add(new SliceValue(0, Color.RED));
                                        }
                                        else{
                                            pieData.add(new SliceValue(a4/b4, Color.GREEN));
                                            pieData.add(new SliceValue(1-a4 /b4, Color.RED));

                                        }
                                        pieChartView = findViewById(R.id.chart4);

                                        PieChartData pieChartData = new PieChartData(pieData);
                                        pieChartData.setHasLabels(true).setValueLabelTextSize(0);
                                        pieChartData.setHasCenterCircle(true);
                                        pieChartView.setPieChartData(pieChartData);
                                    }
                                }
        );
        btn10 = (Button) findViewById(R.id.button32);
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tv = (TextView) findViewById(R.id.textView14);
                if (a4 != c4) {
                    a4 -= 1;
                    tv.setText(a4 * 100 / b4 + "%");
                    btn10.setEnabled(false);
                    btn9.setEnabled(true);
                } else {
                    b4++;
                    tv.setText(a4 * 100 / b4 + "%");
                    btn10.setEnabled(false);
                    btn9.setEnabled(true);
                }
                List pieData = new ArrayList<>();
                if (b4==0)
                {
                    pieData.add(new SliceValue(0, Color.GREEN));
                    pieData.add(new SliceValue(0, Color.RED));}
                else{
                    pieData.add(new SliceValue(a4/b4, Color.GREEN));
                    pieData.add(new SliceValue(1-a4/b4, Color.RED));

                }

                pieChartView = findViewById(R.id.chart4);


                PieChartData pieChartData = new PieChartData(pieData);
                pieChartData.setHasLabels(true).setValueLabelTextSize(0);
                pieChartData.setHasCenterCircle(true);
                pieChartView.setPieChartData(pieChartData);
            }

            ;

        });


    }


}
