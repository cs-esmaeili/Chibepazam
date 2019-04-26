package javad.esmaeili.chibepazam;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_Rozaneimageview extends AppCompatActivity {
    public int aval;
    public int doom;



    ImageView id1 ;
    ImageView id2 ;
    TextView txt1;
    TextView txt2 ;

    int adadshansiaval= -1 ;
    int adadshansidovom=-1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rozaneimageview);
         id1 = (ImageView)findViewById(R.id.id1);
         id2 = (ImageView)findViewById(R.id.id2);
         txt1 = (TextView)findViewById(R.id.txt1);
         txt2 = (TextView)findViewById(R.id.txt2);

r();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                  //      .setAction("Action", null).show();

r();

            }
        });




    }
    private void r (){



        aval = (int) (Math.random() * (G.kol.size() - 1 - 0 + 1)) + 0;
        while(true){

            if(aval  != adadshansiaval) {

                break;
            }else{
                aval = (int) (Math.random() * (G.kol.size() - 1 - 0 + 1)) + 0;

            }

        }


        id1.setImageResource(G.kol.get(aval).id);
        txt1.setText(G.kol.get(aval).title);





        doom= (int) (Math.random() * (G.kol.size() - 1 - 0 + 1)) + 0;
        while(true){

            if(doom  != adadshansidovom && doom != aval) {

                break;
            }else{
                doom = (int) (Math.random() * (G.kol.size() - 1 - 0 + 1)) + 0;

            }

        }



        adadshansiaval= aval;
        adadshansidovom = doom;


        id2.setImageResource(G.kol.get(doom).id);
        txt2.setText(G.kol.get(doom).title);

        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                ImageView j = (ImageView) view;

                Intent intent = new Intent(Activity_Rozaneimageview.this, Activity_Rozanetakghaza.class);
                if (j.getTag() == "id1") {
                    intent.putExtra("INDEX_GHAZAYE_AVAL", aval);
                } else {
                    intent.putExtra("INDEX_GHAZAYE_DOOM", doom);

                }

                Activity_Rozaneimageview.this.startActivity(intent);

            }
        };

        id1.setOnClickListener(onClickListener);
        id2.setOnClickListener(onClickListener);
        id1.setTag("id1");
        id2.setTag("id2");


    }

}
