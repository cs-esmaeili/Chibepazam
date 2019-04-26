package javad.esmaeili.chibepazam;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class Activity_Rozanetakghaza extends AppCompatActivity {

    private int ghaza;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaedei);

        ImageView d = (ImageView) findViewById(R.id.d);
        TextView txtview = (TextView) findViewById(R.id.txtview);
        TextView txt = (TextView) findViewById(R.id.txt);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setVisibility(View.GONE);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("INDEX_GHAZAYE_AVAL")) {
                ghaza = extras.getInt("INDEX_GHAZAYE_AVAL");
            }

            if (extras.containsKey("INDEX_GHAZAYE_DOOM")) {
                ghaza = extras.getInt("INDEX_GHAZAYE_DOOM");
            }

        }

        String akhar = "";
        int i = 0;
        for (String g: G.kol.get(ghaza).k) {
            if (i == 0) {
                akhar = g;
            } else {
                akhar = akhar + "-" + g;
            }

            i++;
        }

        d.setImageResource(G.kol.get(ghaza).id);
        txtview.setText(G.kol.get(ghaza).title);

      //  txt.loadDataWithBaseURL("", G.kol.get(ghaza).desc + akhar, "text/html", "UTF-8", "");
       txt.setText( G.kol.get(ghaza).desc /*+ akhar*/);
      //  txt.setText(Html.fromHtml(G.kol.get(ghaza).desc));

    }
}
