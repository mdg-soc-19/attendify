package com.SOC.attendify;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.IOException;

public class Imageselector extends AppCompatActivity {

    // views for button
    private Button btnSelect, btnUpload, set;
    String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
    String name;
    TextView t1, t2, t3;
    // view for image view
    private ImageView imageView;
    private DatabaseReference mDatabase;

    // Uri indicates, where the image will be picked from
    private Uri filePath;


    // request code
    private final int PICK_IMAGE_REQUEST = 22;
    String currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid();

    // instance for firebase storage and StorageReference
    FirebaseStorage storage;
    StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageselect);

        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(
                Color.parseColor("#0F9D58"));

        t1 = (TextView) findViewById(R.id.textView71);
        t2 = (TextView) findViewById(R.id.textView72);
        t3 = (TextView) findViewById(R.id.edittext26);
        // initialise views
        btnSelect = findViewById(R.id.button25);
        set = (Button) findViewById(R.id.button28);
        btnUpload = findViewById(R.id.button26);
        imageView = findViewById(R.id.imageView2);
        mDatabase = FirebaseDatabase.getInstance().getReference().child(currentuser);
        // get the Firebase  storage reference
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        // on pressing btnSelect SelectImage() is called
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectImage();
            }
        });

        // on pressing btnUpload uploadImage() is called
        btnUpload.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             uploadImage(Uri.EMPTY);
                                         }
                                     }
        );


        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                name = dataSnapshot.child("Name").getValue().toString();
                t1.setText(name);
                String s = dataSnapshot.child("status").getValue().toString();
                t3.setText(s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String a = t3.getText().toString();
                mDatabase.child("status").setValue(a);
            }
        });

        t2.setText("Email id: " + email);


    }

    // Select Image method
    private void SelectImage() {

        // Defining Implicit Intent to mobile gallery
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(
                Intent.createChooser(
                        intent,
                        "Select Image from here..."),
                PICK_IMAGE_REQUEST);
    }

    // Override onActivityResult method
    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data) {

        super.onActivityResult(requestCode,
                resultCode,
                data);

        // checking request code and result code
        // if request code is PICK_IMAGE_REQUEST and
        // resultCode is RESULT_OK
        // then set image in the image view
        if (requestCode == PICK_IMAGE_REQUEST
                && resultCode == RESULT_OK
                && data != null
                && data.getData() != null) {

            // Get the Uri of data
            filePath = data.getData();
            try {

                // Setting image on image view using Bitmap
                Bitmap bitmap = MediaStore
                        .Images
                        .Media
                        .getBitmap(
                                getContentResolver(),
                                filePath);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                // Log the exception
                e.printStackTrace();
            }
        }
    }

    public void uploadImage(Uri uri) {
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference().child("users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        storageRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).putFile(filePath);
        // UploadImage method

    }


    }
