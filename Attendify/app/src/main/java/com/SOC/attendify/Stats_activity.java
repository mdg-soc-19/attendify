
package com.SOC.attendify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Stats_activity<mDatabase> extends Activity implements OnItemSelectedListener{

    public int a;
    DatePicker picker;
    Button displayDate,go;
    TextView textview1,S1,S2,S3,S4,S5,S6,S7;
    String s1,s2,s3,s4,s5,s6,s7,q1,q2,q3,q4,q5,q6,q7;
    public DatabaseReference mDatabase;
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

if (a==0)
{Intent J = new Intent(Stats_activity.this, S1.class);
    startActivity(J);
}


                if (a==1)
                {Intent K= new Intent(Stats_activity.this, S2.class);
                    startActivity(K);
                }

                if (a==2)
                {Intent J = new Intent(Stats_activity.this, S3.class);
                    startActivity(J);
                }

                if (a==3)
                {Intent J = new Intent(Stats_activity.this, S4.class);
                    startActivity(J);
                }

                if (a==4)
                {Intent J = new Intent(Stats_activity.this, S5.class);
                    startActivity(J);
                }

                if (a==5)
                {Intent J = new Intent(Stats_activity.this, S6.class);
                    startActivity(J);
                }

                if (a==6)
                {Intent J = new Intent(Stats_activity.this, S7.class);
                    startActivity(J);
                }
                int d=  (picker.getMonth()+1);
                int b=picker.getDayOfMonth();
                int c=picker.getYear();
                mDatabase.child(d+"/"+b+"/"+c+a ).setValue(d+"/"+b+"/"+c);
        }});
















        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements


        List<String> categories = new ArrayList<String>();
        categories.add("Subject 1");
        categories.add("Subject 2");
        categories.add("Subject 3");
        categories.add("Subject 4");
        categories.add("Subject 5");
        categories.add("Subject 6");
        categories.add("Subject 7");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);


    mDatabase.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
           s1= dataSnapshot.child("Subject 1").getValue().toString();
            s2= dataSnapshot.child("Subject 2").getValue().toString();
            s3= dataSnapshot.child("Subject 3").getValue().toString();
            s4= dataSnapshot.child("Subject 4").getValue().toString();
            s5= dataSnapshot.child("Subject 5").getValue().toString();
            s6= dataSnapshot.child("Subject 6").getValue().toString();
            s7= dataSnapshot.child("Subject 7").getValue().toString();


        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        switch (position)
        { case 0:
        {Toast.makeText(parent.getContext(), "Selected: " + s1, Toast.LENGTH_LONG).show();
        break;}

            case 1:
        {Toast.makeText(parent.getContext(), "Selected: " + s2, Toast.LENGTH_LONG).show();
            break;}

            case 2:
        {Toast.makeText(parent.getContext(), "Selected: " + s3, Toast.LENGTH_LONG).show();
            break;}

            case 3:
        {Toast.makeText(parent.getContext(), "Selected: " + s4, Toast.LENGTH_LONG).show();
            break;}

            case 4:
        {Toast.makeText(parent.getContext(), "Selected: " + s5, Toast.LENGTH_LONG).show();
            break;}

            case 5:
        {Toast.makeText(parent.getContext(), "Selected: " + s6, Toast.LENGTH_LONG).show();
            break;}

            case 6:
        {Toast.makeText(parent.getContext(), "Selected: " + s7, Toast.LENGTH_LONG).show();
            break;}
    }


     a=position;
    }
    public String getCurrentDate(){
        StringBuilder builder=new StringBuilder();;
        builder.append((picker.getMonth() + 1)+"/");//month is 0 based
        builder.append(picker.getDayOfMonth()+"/");
        builder.append(picker.getYear());

        return builder.toString();
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }




}