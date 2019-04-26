package javad.esmaeili.chibepazam;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class activity_vaedei extends AppCompatActivity {


    public TextView          txtview;
    public TextView           txt;
    public int               low    = 0;
    public int               high   = G.kol.size() - 1;
    public int               rnd    = 0;
    public ArrayList<String> rozane = new ArrayList<String>();

    public ImageView         d;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaedei);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        txtview = (TextView) findViewById(R.id.txtview);
        txt = (TextView) findViewById(R.id.txt);

        d = (ImageView) findViewById(R.id.d);



        rnd = (int) (Math.random() * (high - low + 1)) + low;
        antekhab();
        // sample G.kol.get(rnd).setimage(d, G.kol.get(rnd).id);
        rozane.clear();


        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                rnd = (int) (Math.random() * (high - low + 1)) + low;
                antekhab();
                // sample G.kol.get(rnd).setimage(d, G.kol.get(rnd).id);
                rozane.clear();
            }
        });


    }

    public void antekhab() {
        d.setImageResource(G.kol.get(rnd).id);

        rozane.add(G.kol.get(rnd).desc);
        int index = 0;
        for (String h: G.kol.get(rnd).k) {
            rozane.add(G.kol.get(rnd).k.get(index));
            index++;

        }
        String akhar = "";
        int i = 0;
        for (String k: rozane) {
            if (i == 0) {
                i++;
                continue;

            } else {
                if (i == 1) {
                    akhar = k;

                } else {
                    akhar = akhar + "-" + k;
                }

            }
            i++;
        }
        txtview.setText(G.kol.get(rnd).title);
        //  txt.loadDataWithBaseURL("", G.kol.get(rnd).desc + akhar, "text/html", "UTF-8", "");
        txt.setText( G.kol.get(rnd).desc /*+ akhar*/);
        //txt.setText(Html.fromHtml(G.kol.get(rnd).desc));
    }
}
