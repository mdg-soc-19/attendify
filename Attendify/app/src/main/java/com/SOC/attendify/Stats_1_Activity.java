package com.SOC.attendify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Stats_1_Activity extends AppCompatActivity {
Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;
        int a=0,b=0,a1=0,b1=0;
DatabaseReference rootRef;
    int c=a;
    int d=b;
    int c1=a1;
    int d1=b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats1);
        rootRef = FirebaseDatabase.getInstance().getReference();

        btn1=(Button) findViewById(R.id.button19);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                TextView tv = (TextView)findViewById(R.id.textView8);
                if (b==d)
                {b++;a++;
                tv.setText(a*100/b + "%");
                btn1.setEnabled(false);
                btn2.setEnabled(true);
            }
                else
                {a++;
                    tv.setText(a*100/b + "%");
                    btn1.setEnabled(false);
                    btn2.setEnabled(true);
                }
        }});
        btn2=(Button) findViewById(R.id.button20);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                TextView tv = (TextView)findViewById(R.id.textView8);
                if (a!=c)
                {
                a-=1;
                tv.setText(a*100/b + "%");
                btn2.setEnabled(false);
                btn1.setEnabled(true);}
                else
                {b++;
                tv.setText(a*100/b + "%");
                btn2.setEnabled(false);
                    btn1.setEnabled(true);
                }
            }
        ;

    });
        btn3=(Button) findViewById(R.id.button22);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                TextView tv = (TextView)findViewById(R.id.textView7);
                if (b1==d1)
                {b1++;a1++;
                    tv.setText(a1*100/b1 + "%");
                    btn3.setEnabled(false);
                    btn4.setEnabled(true);
                }
                else
                {a1++;
                    tv.setText(a1*100/b1 + "%");
                    btn3.setEnabled(false);
                    btn4.setEnabled(true);
                }
            }});




        btn4=(Button) findViewById(R.id.button23);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                TextView tv = (TextView)findViewById(R.id.textView7);
                if (a1!=c1)
                {
                    a1-=1;
                    tv.setText(a1*100/b1 + "%");
                    btn4.setEnabled(false);
                    btn3.setEnabled(true);}
                else
                {b1++;
                    tv.setText(a1*100/b1 + "%");
                    btn2.setEnabled(false);
                    btn1.setEnabled(true);
                }
            }
            ;

        });

    }}