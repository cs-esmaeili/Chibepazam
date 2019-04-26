package javad.esmaeili.chibepazam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class Activity_atelaatghaza extends AppCompatActivity {

    @Override
    protected void onResume() {
        G.currentActivity = this;
        super.onResume();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atelaatghaza);

        ImageView img = (ImageView) findViewById(R.id.img);
        TextView txttitle = (TextView) findViewById(R.id.txttitle);
        TextView txtdesc = (TextView) findViewById(R.id.txtdesc);
        TextView txtmavad = (TextView) findViewById(R.id.txtmavad);

        Bundle extras = getIntent().getExtras();
        int position = 0;
        int BARAYEHAZFJOMEYESHOMAHAMERODARIDTOLIST = 0;
        if (extras != null) {
            position = extras.getInt("POSITION");
            BARAYEHAZFJOMEYESHOMAHAMERODARIDTOLIST = extras.getInt("BARAYEHAZFJOMEYESHOMAHAMERODARIDTOLIST");
        }

        final ghaza note = G.notes.get(position);
        txttitle.setText(note.title);



        img.setImageResource(note.id);
        String g = "";
        String h = "";
        String kol = "";

        for (int i = 0; i < note.onhaeikedare.size(); i++) {
            if (i == 0) {
                g = note.onhaeikedare.get(i);
            } else {
                g = g + " " + note.onhaeikedare.get(i);
            }
        }

        for (int i = 0; i < note.k.size(); i++) {

            if (i == 0) {
                kol = note.k.get(i);
                if ( !g.contains(note.k.get(i))) {
                    h = note.k.get(i);
                }
            } else {
                kol = kol + " " + note.k.get(i);
                if ( !g.contains(note.k.get(i))) {
                    h = h + " " + note.k.get(i);
                }
            }
        }
        if (g != "" && h != "") {
         //   web.loadDataWithBaseURL("", note.desc + " dare = " + g + " nadare = " + h, "text/html", "UTF-8", "");
           // txtdesc.setText(note.desc + "\n" + " موادی که شما دارید : " +  g + "\n  <font color=red> "+" موادی که شما ندارید: " + h);


            txtmavad.setVisibility(View.VISIBLE);
            txtdesc.setText(note.desc);
            txtmavad.setText( Html.fromHtml(  "<br>  <font color=Green>  موادی که دارید: " + g + "</font>" + "<br> <font color=red> موادی که شما ندارید: " + h +"</font>"  ));

        } else {
           // web.loadDataWithBaseURL("", note.desc + kol, "text/html", "UTF-8", "");

            if(BARAYEHAZFJOMEYESHOMAHAMERODARIDTOLIST == -20) {

               // txtdesc.setText(Html.fromHtml(note.desc));

                txtdesc.setText(note.desc);
              }else {
                txtmavad.setVisibility(View.VISIBLE);
                txtdesc.setText(note.desc);
                txtmavad.setText( Html.fromHtml( "<font color=Green> شما تمام مواد را دارید "));


            }
            }
        }
        //  web.setBackgroundColor(990000);
        //  web.setBackgroundResource(ff3333)web.set
    }
