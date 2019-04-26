package javad.esmaeili.chibepazam;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class AdapterNote extends ArrayAdapter<ghaza> {

    public AdapterNote(ArrayList<ghaza> array) {
        super(G.context, R.layout.adapter_notes, array);
    }


    private static class ViewHolder {

        public LinearLayout lay;
        public TextView  txtTitle;
        public ImageView imgview;


        public ViewHolder(View view) {
            txtTitle = (TextView) view.findViewById(R.id.txtTitle);
            lay = (LinearLayout) view.findViewById(R.id.lay);
            imgview = (ImageView) view.findViewById(R.id.imgview);

        }


        public void fill(final ArrayAdapter<ghaza> adapter, final ghaza item, final int position) {
            txtTitle.setText("" + item.title);
            imgview.setImageResource(item.id);
            lay.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(G.currentActivity, Activity_atelaatghaza.class);
                    intent.putExtra("POSITION", position);
                    intent.putExtra("BARAYEHAZFJOMEYESHOMAHAMERODARIDTOLIST", -20);
                    G.currentActivity.startActivity(intent);

                }
            });

            if (item.tedad != 0) {
                txtTitle.setTextColor(Color.RED);
            } else {
                txtTitle.setTextColor(Color.BLACK);

            }
        }
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        ghaza item = getItem(position);
        if (convertView == null) {
            convertView = G.inflater.inflate(R.layout.adapter_notes, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.fill(this, item, position);
        return convertView;
    }
}
