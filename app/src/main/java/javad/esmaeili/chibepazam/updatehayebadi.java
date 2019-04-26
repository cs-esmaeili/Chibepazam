package javad.esmaeili.chibepazam;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Javad on 4/2/2017.
 */
public class updatehayebadi  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatehayebadi);

      TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("شما درآپدیت های بعدی خواهید دید\n" +
                "1.\tقسمت آنلاین برای نظر دهی برای هر غذا\n" +
                "2.\tاضافه شدن غذاهای بیشتر\n" +
                "3.\tاضافه شدن قسمت دسرها\n" +
                "4.\tاضافه شدن قسمت کیک ها\n" +
                "5.\tاضافه شدن قسمت غذاهای رژیمی\n" +
                "6.\tاضافه شدن قسمت غذاهای فوری\n" +
                "7.\tاضافه شدن قسمت ارسال غذا توسط کاربر\n" +
                "8.\tاضاقه شدن قسمت تنظیمات برای شخصی سازی برنامه\n");


    }
}