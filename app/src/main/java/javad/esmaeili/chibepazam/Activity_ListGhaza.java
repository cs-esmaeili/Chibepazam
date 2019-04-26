package javad.esmaeili.chibepazam;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;


public class Activity_ListGhaza extends AppCompatActivity {

    public ArrayAdapter adapter;
    boolean h = true;
    String g ;
    @Override
    protected void onResume() {
        G.notes.clear();
        G.currentActivity = this;

        if (G.notes.size() != 0) {

            return;
        }
        for (int i = 0; i < G.kol.size(); i++) {

            G.notes.add(G.kol.get(i));
        }

        adapter.notifyDataSetChanged();

        super.onResume();
    }

    /* Intent intent = new Intent(Activity_ListGhaza.this,  Natayejsearch.class);
                Activity_ListGhaza.this.startActivity(intent);
                intent.putExtra("INDEX_GHAZA",i);*/

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listghaza);

        ListView lstContent = (ListView) findViewById(R.id.lstContent);
       final SearchView b = (SearchView) findViewById(R.id.b);














b.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
    @Override
    public boolean onQueryTextSubmit(String query) {





        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {


        h = true;
boolean toastboolean = true;
        g = b.getQuery().toString();


       for (int i = 0; i < G.kol.size(); i++) {


            if (G.kol.get(i).title.equals(g)  ){



                G.notes.clear();
                G.notes.add(G.kol.get(i));
                adapter.notifyDataSetChanged();

                toastboolean = false;
                h= false;
                return false;
            }

        }



       for (int i = 0; i < G.kol.size(); i++) {
           if(i== 0 ){
               G.notes.clear();
           }
            if (G.kol.get(i).title.contains(g) && h==true  ){
                toastboolean= false;
                G.notes.add(G.kol.get(i));
                adapter.notifyDataSetChanged();

            }

        }

if(toastboolean) {

Toast.makeText(Activity_ListGhaza.this, "غذایی با این نام پیدا نشد"  , Toast.LENGTH_LONG).show();

}

        return false;
    }
});











        adapter = new AdapterNote(G.notes);
        lstContent.setAdapter(adapter);

    }
}
