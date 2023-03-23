package mrk2.kunalpatel.com.demoapps;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Menu extends AppCompatActivity implements View.OnClickListener,NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawer;

    private CardView basicComputer,internet,shortcut,software,hardware;

    ListView listView;

    String[] fruitname = {"Basic Computer", "Internet and Networking", "Shortcut Keys", "Software", "Hardware"};
    String[] desc = {"Question 30", "Question 30", "Question 30", "Question 30", "Question 30"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        androidx.appcompat.widget.Toolbar toolbar1 = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar1);

        drawer = findViewById(R.id.draw_layout);
        getSupportActionBar().setTitle("Computer Quiz App");

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar1,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        basicComputer = (CardView) findViewById(R.id.basic_computer);
        internet = (CardView) findViewById(R.id.internet);
        shortcut = (CardView) findViewById(R.id.shortcut);
        software = (CardView) findViewById(R.id.software);
        hardware = (CardView) findViewById(R.id.hardware);

        basicComputer.setOnClickListener(this);
        internet.setOnClickListener(this);
        shortcut.setOnClickListener(this);
        software.setOnClickListener(this);
        hardware.setOnClickListener(this);



        //android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //getSupportActionBar().setTitle("Computer Quiz");


        /*listView = (ListView) findViewById(R.id.listview);
        CustomListview customListview = new CustomListview(this, fruitname, desc);
        listView.setAdapter(customListview);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent i = new Intent(view.getContext(), Basic_computer.class);
                    startActivityForResult(i, 0);
                }


                if (position == 1) {
                    Intent i = new Intent(view.getContext(), Internet_and_networking.class);
                    startActivityForResult(i, 1);
                }

                if (position == 2) {
                    Intent i = new Intent(view.getContext(), Shortcut_keys.class);
                    startActivityForResult(i, 2);
                }


                if (position == 3) {
                    Intent i = new Intent(view.getContext(), Software_Quiz.class);
                    startActivityForResult(i, 3);
                }

                if (position == 4) {
                    Intent i = new Intent(view.getContext(), Hardware_Quiz.class);
                    startActivityForResult(i, 4);
                }




            }
        });*/


    }





    @Override
    public void onClick(View v) {

        Intent i ;

        switch (v.getId()){

            case R.id.basic_computer :
                i = new Intent(this,Quiz.class);
                i.putExtra("pos",0);
                startActivity(i);
            break;
            case R.id.internet :
                i = new Intent(this,Quiz.class);
                i.putExtra("pos",1);
                startActivity(i);
                break;
            case R.id.shortcut :
                i = new Intent(this,Quiz.class);
                i.putExtra("pos",4);
                startActivity(i);
                break;
            case R.id.software :
                i = new Intent(this,Quiz.class);
                i.putExtra("pos",2);
                startActivity(i);
                break;
            case R.id.hardware :
                i = new Intent(this,Quiz.class);
                i.putExtra("pos",3);
                startActivity(i);
                break;
            default:break;
        }




    }



    @Override
    public void onBackPressed () {

        AlertDialog.Builder builder = new AlertDialog.Builder(Menu.this);
        builder.setMessage("Do you really want to exit?").setCancelable(
                false).setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        moveTaskToBack(true);
                        android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(1);


                    }
                }).setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.dismiss();

                    }
                });







        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);

        } else {
            //super.onBackPressed();
            AlertDialog alert = builder.create();
            alert.show();


        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_main:
                Intent i = new Intent(Menu.this, Quiz.class);
                startActivity(i);
                finish();

                break;
            case R.id.nav_basic_computer:
                Intent j = new Intent(Menu.this,Quiz.class);
                j.putExtra("pos",0);
                startActivity(j);
                finish();

                break;
            case R.id.nav_internet_and_networking:
                Intent k = new Intent(Menu.this,Quiz.class);
                k.putExtra("pos",1);
                startActivity(k);
                finish();

                break;
            case R.id.key_shortcut:
                Intent l = new Intent(Menu.this,Quiz.class);
                l.putExtra("pos",4);
                startActivity(l);
                finish();

                break;
            case R.id.nav_software:
                Intent m = new Intent(Menu.this,Quiz.class);
                m.putExtra("pos",2);
                startActivity(m);
                finish();
                break;

            case R.id.nav_hardware:
                Intent n = new Intent(Menu.this,Quiz.class);
                n.putExtra("pos",3);
                startActivity(n);
                finish();
                break;

            case R.id.exit:
                finish();
                break;

            case R.id.policy:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://sites.google.com/view/computerquiz/home"));
                startActivity(browserIntent);
                finish();
                break;


        }

        drawer.closeDrawer(GravityCompat.START);
        return false;
    }






    }

