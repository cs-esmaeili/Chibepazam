package javad.esmaeili.chibepazam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;


public class Activity_antekhab extends AppCompatActivity {

    private ArrayList<CheckBox>    chk1           = new ArrayList<CheckBox>();

    private ArrayList<String>      chk2           = new ArrayList<String>();

    public static ArrayList<ghaza> antekhabhododi = new ArrayList<ghaza>();
    public ArrayList<String>       j              = new ArrayList<String>();
    public String                  daref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_antekhab);

        chk1.add((CheckBox) findViewById(R.id.chk1));
        chk1.add((CheckBox) findViewById(R.id.chk2));
        chk1.add((CheckBox) findViewById(R.id.chk3));
        chk1.add((CheckBox) findViewById(R.id.chk4));
        chk1.add((CheckBox) findViewById(R.id.chk5));
        chk1.add((CheckBox) findViewById(R.id.chk6));
        chk1.add((CheckBox) findViewById(R.id.chk7));
        chk1.add((CheckBox) findViewById(R.id.chk8));
        chk1.add((CheckBox) findViewById(R.id.chk9));
        chk1.add((CheckBox) findViewById(R.id.chk10));
        chk1.add((CheckBox) findViewById(R.id.chk11));
        chk1.add((CheckBox) findViewById(R.id.chk12));
        chk1.add((CheckBox) findViewById(R.id.chk13));
        chk1.add((CheckBox) findViewById(R.id.chk14));
        chk1.add((CheckBox) findViewById(R.id.chk15));
        chk1.add((CheckBox) findViewById(R.id.chk16));
        chk1.add((CheckBox) findViewById(R.id.chk17));
        chk1.add((CheckBox) findViewById(R.id.chk18));
        chk1.add((CheckBox) findViewById(R.id.chk19));
        chk1.add((CheckBox) findViewById(R.id.chk20));
        chk1.add((CheckBox) findViewById(R.id.chk21));
        chk1.add((CheckBox) findViewById(R.id.chk22));
        chk1.add((CheckBox) findViewById(R.id.chk23));
        chk1.add((CheckBox) findViewById(R.id.chk24));
        chk1.add((CheckBox) findViewById(R.id.chk25));
        chk1.add((CheckBox) findViewById(R.id.chk26));
        chk1.add((CheckBox) findViewById(R.id.chk27));
        chk1.add((CheckBox) findViewById(R.id.chk28));
        chk1.add((CheckBox) findViewById(R.id.chk29));
        chk1.add((CheckBox) findViewById(R.id.chk30));
        chk1.add((CheckBox) findViewById(R.id.chk31));
        chk1.add((CheckBox) findViewById(R.id.chk32));
        chk1.add((CheckBox) findViewById(R.id.chk33));
        chk1.add((CheckBox) findViewById(R.id.chk34));
        chk1.add((CheckBox) findViewById(R.id.chk35));
        chk1.add((CheckBox) findViewById(R.id.chk36));
        chk1.add((CheckBox) findViewById(R.id.chk37));
        chk1.add((CheckBox) findViewById(R.id.chk38));
        chk1.add((CheckBox) findViewById(R.id.chk39));
        chk1.add((CheckBox) findViewById(R.id.chk40));
        chk1.add((CheckBox) findViewById(R.id.chk41));
        chk1.add((CheckBox) findViewById(R.id.chk42));




        Button btnok = (Button) findViewById(R.id.btnok);
        Button btnr = (Button) findViewById(R.id.btnr);


        btnr.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                for(CheckBox g :chk1) {

                    g.setChecked(false);

                }
            }
        });


        assert btnok != null;
        btnok.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {

                antekhabhododi.clear();

                chk2.clear();

                for (int i = 0; i < chk1.size(); i++) {
                    if (chk1.get(i).isChecked() == true) {
                        chk2.add(chk1.get(i).getText().toString());
                    }
                }
                if (chk2.size() == 0 || chk2.size() < 2) {
                    Toast.makeText(Activity_antekhab.this, "لطفا مواد مورد نیازبرای پیشنهاد غذا انتخاب کنید", Toast.LENGTH_LONG).show();
                    return;
                }
                int c = 0;
                for (int i = 0; i < G.kol.size(); i++) {


                    for (int b = 0; b < G.kol.get(i).k.size(); b++) {
                        for (int h = 0; h < chk2.size(); h++) {
                            if (G.kol.get(i).k.get(b).equals(chk2.get(h))) {
                                c++;
                                j.add(G.kol.get(i).k.get(b));
                            }
                        }




                    }

                    String dare = "";
                    for (String g : j) {

                        dare = dare + " " + g;

                    }
                    daref = dare;


                    if(c == chk2.size()){

                        ghaza h = new ghaza();
                        h.title = G.kol.get(i).title;
                        h.tedad = 0;
                        h.id = G.kol.get(i).id;
                        h.desc = G.kol.get(i).desc;
                        h.onhaeikedare.add(daref);
                        h.k = G.kol.get(i).k;
                        antekhabhododi.add(h);
                    }



                    c = 0;
                    daref = "";
                    j.clear();







                }
                if(antekhabhododi.size() == 0){
                    Toast.makeText(Activity_antekhab.this, "غذایی پیدا نشد", Toast.LENGTH_SHORT).show();

                    return;
                }
                Intent intent = new Intent(Activity_antekhab.this, Activity_Listnatayejantekhab.class);
                Activity_antekhab.this.startActivity(intent);
            }
        });

    }
}
