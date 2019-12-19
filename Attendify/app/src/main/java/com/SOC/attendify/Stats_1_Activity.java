package com.SOC.attendify;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class Stats_1_Activity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8,btn9,btn10;
    public int a = 0, b = 0, a1 = 0, b1 = 0,a2=0,a3=0,a4=0,a5=0,b2=0,b3=0,b4=0,b5=0;
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
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("server/saving-data/fireblog");
    PieChartView pieChartView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats1);

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
