package com.SOC.attendify;
import android.content.Intent;;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import androidx.annotation.RequiresApi;


import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.drawerlayout.widget.DrawerLayout.DrawerListener;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
public class UserActivity extends AppCompatActivity {
    Button btnLogOut,stats,preplanning,notification,aboutus,reschedule,fab,resch;
    FirebaseAuth firebaseAuth;
    private TextView username;
    private FirebaseAuth.AuthStateListener authStateListener;
    String currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid();
    private DatabaseReference mDatabaseReference;

    private String[] mNavigationDrawerItemTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    Toolbar toolbar;
    String s1,s2,s3,s4,s5,s6,s7;
TextView t1,t2,t3,t4,t5,t6,t7;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    androidx.appcompat.app.ActionBarDrawerToggle       mDrawerToggle;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        mDatabaseReference=FirebaseDatabase.getInstance().getReference().child(currentuser);
        t1=(TextView) findViewById(R.id.edittext);
        t2=(TextView) findViewById(R.id.edittext8);
        t3=(TextView) findViewById(R.id.edittext9);
        t4=(TextView) findViewById(R.id.edittext10);
        t5=(TextView) findViewById(R.id.edittext11);
        t6=(TextView) findViewById(R.id.edittext12);
        t7=(TextView) findViewById(R.id.edittext13);

        resch=(Button) findViewById(R.id.button21);
        resch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I=new Intent (UserActivity.this,Rescheduledstudent.class);
                startActivity(I);
            }
        });




        mTitle = mDrawerTitle = getTitle();
        mNavigationDrawerItemTitles= getResources().getStringArray(R.array.navigation_drawer_items_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);




        setupToolbar();
        Datamodel[] drawerItem = new Datamodel[3];
        drawerItem[0] = new Datamodel(R.drawable.contract, "Subjects");
        drawerItem[1] = new Datamodel(R.drawable.calendar, "Select Date");
        drawerItem[2]=new Datamodel(R.drawable.barchart,"Preplanning");

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);

         DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.item_view_list_toolbar, drawerItem);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        setupDrawerToggle();



        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_recents:
                        Toast.makeText(UserActivity.this, "Date", Toast.LENGTH_SHORT).show();
                        Intent I=new Intent(UserActivity.this,Stats_activity.class);
                        startActivity(I);
                        break;
                    case R.id.action_favorites:
                        Toast.makeText(UserActivity.this, "Subjects", Toast.LENGTH_SHORT).show();
                        Intent J=new Intent(UserActivity.this,Stats_1_Activity.class);
                        startActivity(J);
                        break;
                    case R.id.action_nearby:
                        Toast.makeText(UserActivity.this, "About us", Toast.LENGTH_SHORT).show();
                        Intent K=new Intent(UserActivity.this,Aboutus_activity.class);
                        startActivity(K);
                        break;
                }
                return true;
            }
        });






        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child(currentuser);

        username=(TextView) findViewById(R.id.Welcome);
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        String name= dataSnapshot.child("Name").getValue().toString();
        username.setText("Welcome " +name);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
          Intent I=new Intent(UserActivity.this,Subjects.class);
          startActivity(I);
            }
        });



        btnLogOut = (Button) findViewById(R.id.btnLogOut);
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseAuth.getInstance().signOut();
                Intent I = new Intent(UserActivity.this, ActivityLogin.class);
                startActivity(I);

            }
        });

        stats=(Button) findViewById(R.id.button);
        stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(UserActivity.this, Subjects.class);
                startActivity(I);

            }
        });
        preplanning=(Button) findViewById(R.id.button2);
        preplanning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent I = new Intent(UserActivity.this, preplanning_activity.class);
                startActivity(I);
            }
        });
        notification=(Button) findViewById(R.id.button3);
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent I = new Intent(UserActivity.this, Notification_activity.class);
                startActivity(I);

            }
        });

        reschedule=(Button) findViewById(R.id.button4);
       reschedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent I = new Intent(UserActivity.this, Rescheduled_activity.class);
                startActivity(I);
            }
        });
        aboutus=(Button) findViewById(R.id.button5);
        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent I = new Intent(UserActivity.this, Aboutus_activity.class);
                startActivity(I);

            }
        });
    }





    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }

    }

    private void selectItem(int position) {

        Fragment fragment = null;

        switch (position) {
            case 0:
                Intent I = new Intent(UserActivity.this, Stats_1_Activity.class);
                startActivity(I);
                break;
            case 1:
                Intent J = new Intent(UserActivity.this, Stats_activity.class);
                startActivity(J);
                break;
            case 2:
                Intent K = new Intent(UserActivity.this,preplanning_activity.class);
                startActivity(K);
                break;
            case 3:
                Intent L = new Intent(UserActivity.this, S1.class);
                startActivity(L);
                break;


            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(mNavigationDrawerItemTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);

        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    void setupToolbar(){


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    void setupDrawerToggle(){
        mDrawerToggle = new androidx.appcompat.app.ActionBarDrawerToggle  (this,mDrawerLayout,toolbar,R.string.app_name, R.string.app_name);
        //This is necessary to change the icon of the Drawer Toggle upon state change.
        mDrawerToggle.syncState();
    }
}






