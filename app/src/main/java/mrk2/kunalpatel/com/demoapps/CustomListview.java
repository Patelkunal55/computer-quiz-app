package mrk2.kunalpatel.com.demoapps;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListview extends ArrayAdapter<String> {

    private String[] fruitname;
    private String[] desc;
    private Activity context;


    public CustomListview(Activity context, String[] fruitname, String[] desc) {
        super(context, R.layout.listview_layout,fruitname);

        this.context=context;
        this.desc=desc;
        this.fruitname=fruitname;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r = convertView;
        ViewHolder viewHolder = null;
        if (r == null) {

            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.listview_layout, null, true);
            viewHolder = new ViewHolder(r);
            r.setTag(viewHolder);
        }

        else {
            viewHolder = (ViewHolder) r.getTag();

        }

        viewHolder.tvw1.setText(fruitname[position]);
        viewHolder.tvw2.setText(desc[position]);
        return r;
    }

    class ViewHolder
    {
        TextView tvw1;
        TextView tvw2;

        ViewHolder(View v)
        {
            tvw1=(TextView)v.findViewById(R.id.tvfruitname);
            tvw2=(TextView)v.findViewById(R.id.tvdescription);

        }

    }
}
