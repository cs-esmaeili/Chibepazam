package javad.esmaeili.chibepazam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;


public class Activity_Listnatayejantekhab extends AppCompatActivity {

    public ArrayAdapter adapter;


    @Override
    protected void onResume() {
        G.currentActivity = this;

        G.notes.clear();
        for (int i = 0; i < Activity_antekhab.antekhabhododi.size(); i++) {

            G.notes.add(Activity_antekhab.antekhabhododi.get(i));
        }

        adapter.notifyDataSetChanged();

        super.onResume();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listghaza);

        ListView lstContent = (ListView) findViewById(R.id.lstContent);
SearchView sr = (SearchView) findViewById(R.id.b);

        sr.setVisibility(View.GONE);

        adapter = new AdapterNote(G.notes);
        lstContent.setAdapter(adapter);

    }
}
