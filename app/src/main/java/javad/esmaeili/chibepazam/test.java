package javad.esmaeili.chibepazam;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.SearchView;

/**
 * Created by Javad on 2/9/2017.
 */
public class test extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        SearchView a = (SearchView) findViewById(R.id.a);

        a.setQuery("salam" , false);
    }
}
