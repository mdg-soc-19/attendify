package com.SOC.attendify;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
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

import java.util.ArrayList;
import java.util.List;

public class preplanning_activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

TextView t1,t2,t3,t4,t5,t6,t7,tot,mis,stat;
Button go;
String s1,s2,s3,s4,s5,s6,s7;
String p1,p2,p3,p4,p5,p6,p7,T1,T2,T3,T4,T5,T6,T7;
int a,b;
     float   c,d;

private DatabaseReference mDatabase;
String currentuser= FirebaseAuth.getInstance().getCurrentUser().getUid();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preplanning);
        tot=(TextView) findViewById(R.id.edittext25);
        mis=(TextView) findViewById(R.id.edittext24);
        stat=(TextView) findViewById(R.id.textView69);
go=(Button) findViewById(R.id.button24);
mDatabase= FirebaseDatabase.getInstance().getReference().child(currentuser);
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
        p1=dataSnapshot.child("Present1").getValue().toString();
        p2=dataSnapshot.child("Present2").getValue().toString();
        p3=dataSnapshot.child("Present3").getValue().toString();
        p4=dataSnapshot.child("Present4").getValue().toString();
        p5=dataSnapshot.child("Present5").getValue().toString();
        p6=dataSnapshot.child("Present6").getValue().toString();
        p7=dataSnapshot.child("Present7").getValue().toString();
        T1=dataSnapshot.child("total1").getValue().toString();
        T2=dataSnapshot.child("total2").getValue().toString();
        T3 =dataSnapshot.child("total3").getValue().toString();
        T4=dataSnapshot.child("total4").getValue().toString();
        T5=dataSnapshot.child("total5").getValue().toString();
        T6=dataSnapshot.child("total6").getValue().toString();
        T7=dataSnapshot.child("total7").getValue().toString();


    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});


// Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner2);

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


        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String missed=mis.getText().toString();
                c=Float.parseFloat(missed);

                String total=tot.getText().toString();
                d=Float.parseFloat(total);

                if (((b-a+c)/d)>0.25)
                {
                    stat.setText("You can,t miss theses all classes ");


                }

else if (((b-a+c)/d)<=0.25)
                {
                    int count=0;
                    while(((b-a + c)/d)<0.25)
                    {
                        b++;
                        count++;

                    }
                    stat.setText("You are only allowed to miss "+(count) + " other classes fot >=75% attendance" );

                }




            }
        });















    }



    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        switch (position)
        { case 0:
        {Toast.makeText(parent.getContext(), "Selected: " + s1, Toast.LENGTH_LONG).show();
        a=Integer.parseInt(p1);
        b=Integer.parseInt(T1);

            break;}

            case 1:
            {Toast.makeText(parent.getContext(), "Selected: " + s2, Toast.LENGTH_LONG).show();

                a=Integer.parseInt(p2);
                b=Integer.parseInt(T2);


            break;}

            case 2:
            {Toast.makeText(parent.getContext(), "Selected: " + s3, Toast.LENGTH_LONG).show();

                a=Integer.parseInt(p3);
                b=Integer.parseInt(T3);


                break;}

            case 3:
            {Toast.makeText(parent.getContext(), "Selected: " + s4, Toast.LENGTH_LONG).show();

                a=Integer.parseInt(p4);
                b=Integer.parseInt(T4);

                break;}

            case 4:
            {Toast.makeText(parent.getContext(), "Selected: " + s5, Toast.LENGTH_LONG).show();

                a=Integer.parseInt(p5);
                b=Integer.parseInt(T5);

                break;}

            case 5:
            {Toast.makeText(parent.getContext(), "Selected: " + s6, Toast.LENGTH_LONG).show();

                a=Integer.parseInt(p6);
                b=Integer.parseInt(T6);

                break;}

            case 6:
            {Toast.makeText(parent.getContext(), "Selected: " + s7, Toast.LENGTH_LONG).show();
                a=Integer.parseInt(p7);
                b=Integer.parseInt(T7);


                break;}
        }



    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}









