package javad.esmaeili.chibepazam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

private   DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        LinearLayout ly1 = (LinearLayout) findViewById(R.id.ly1);
        LinearLayout ly2 = (LinearLayout) findViewById(R.id.ly2);
        LinearLayout ly3 = (LinearLayout) findViewById(R.id.ly3);
        LinearLayout ly4 = (LinearLayout) findViewById(R.id.ly4);
        ImageView img =(ImageView) findViewById(R.id.img);



        ly3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Activity_antekhab.class);
                MainActivity.this.startActivity(intent);

            }
        });
        ly1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, activity_vaedei.class);
                MainActivity.this.startActivity(intent);
            }
        });
        ly2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Activity_Rozaneimageview.class);
                MainActivity.this.startActivity(intent);
            }
        });
        ly4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Activity_ListGhaza.class);
                MainActivity.this.startActivity(intent);
            }
        });


        G.rnd = (int) (Math.random() * (G.kol.size() - 1 - 0 + 1)) + 0;

        img.setImageResource(G.kol.get(G.rnd).id);







        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("");
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);



         ;



        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.END)) {
            drawer.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            drawer.openDrawer(GravityCompat.END);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.updatehayebadi) {

            Intent intent = new Intent(MainActivity.this, updatehayebadi.class);
            MainActivity.this.startActivity(intent);

        } else if (id == R.id.darbareyema) {
            Intent intent = new Intent(MainActivity.this, darbareyema.class);
            MainActivity.this.startActivity(intent);
        }


        drawer.closeDrawer(GravityCompat.END);
        return true;
    }
}
