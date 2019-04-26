package javad.esmaeili.chibepazam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Natayejsearch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaedei);


       TextView txt1 = (TextView) findViewById(R.id.txtview);
        TextView txt2 = (TextView) findViewById(R.id.txt);

        ImageView  img = (ImageView) findViewById(R.id.d);



        Bundle extras = getIntent().getExtras();
        int index = 0;
        if (extras != null) {
            index = extras.getInt("INDEX_GHAZA");
        }


        img.setImageResource(G.kol.get(index).id);
        txt1.setText(G.kol.get(index).title);



        String mavad = "";

        for(int i = 0;  i< G.kol.get(index).k.size(); i++) {

mavad =  mavad +  G.kol.get(index).k.get(i) + " ";
        }
     //   txt2.setText(G.kol.get(index).desc + "          " + mavad);
        txt2.setText(Html.fromHtml(G.kol.get(index).desc + "          " + mavad));
    }


    }

