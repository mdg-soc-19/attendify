package com.SOC.attendify;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Stats_activity extends Activity implements OnItemSelectedListener{

    int a;
    DatePicker picker;
    Button displayDate,go;
    TextView textview1,S1,S2,S3,S4,S5,S6,S7;
    String s1,s2,s3,s4,s5,s6,s7,q1,q2,q3,q4,q5,q6,q7;
DatabaseReference mDatabase;
String currentuser= FirebaseAuth.getInstance().getCurrentUser().getUid();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats);

mDatabase= FirebaseDatabase.getInstance().getReference().child(currentuser);

        textview1=(TextView)findViewById(R.id.textView1);
        picker=(DatePicker)findViewById(R.id.datePicker);
        displayDate=(Button)findViewById(R.id.button1);

        textview1.setText("Current Date: "+getCurrentDate());

        displayDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                textview1.setText("Change Date: "+getCurrentDate());
            }

        });

        go=(Button) findViewById(R.id.button6);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(Stats_activity.this, Stats_1_Activity.class);
                startActivity(I);


            }
        });
        S1=(TextView) findViewById(R.id.textView68);
        S2=(TextView) findViewById(R.id.textView69);
        S3=(TextView) findViewById(R.id.textView70);
        S4=(TextView) findViewById(R.id.textView71);
        S5=(TextView) findViewById(R.id.textView72);
        S6=(TextView) findViewById(R.id.textView73);
        S7=(TextView) findViewById(R.id.textView74);


        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                s1=dataSnapshot.child("Subject 1").getValue().toString();
                s2=dataSnapshot.child("Subject 2").getValue().toString();
                s3=dataSnapshot.child("Subject 3").getValue().toString();
                s4=dataSnapshot.child("Subject 4").getValue().toString();
                s5=dataSnapshot.child("Subject 5").getValue().toString();
                s6=dataSnapshot.child("Subject 6").getValue().toString();
                s7=dataSnapshot.child("Subject 7").getValue().toString();

               S1.setText(s1);
                S2.setText(s2);
                S3.setText(s3);
                S4.setText(s4);
                S5.setText(s5);
                S6.setText(s6);
                S7.setText(s7);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

















        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        q1=S1.getText().toString();
        q2=S2.getText().toString();
        q3=S3.getText().toString();
        q4=S4.getText().toString();
        q5=S5.getText().toString();
        q6=S6.getText().toString();
        q7=S7.getText().toString();

        List<String> categories = new ArrayList<String>();
        categories.add(q1);
        categories.add("Business Services");
        categories.add("Computers");
        categories.add("Education");
        categories.add("Personal");
        categories.add("Travel");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    public String getCurrentDate(){
        StringBuilder builder=new StringBuilder();;
        builder.append((picker.getMonth() + 1)+"/");//month is 0 based
        builder.append(picker.getDayOfMonth()+"/");
        builder.append(picker.getYear());

        return builder.toString();
    }

}