package com.example11.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example11.myapp.R;
import net.tsz.afinal.FinalBitmap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by chendi on 2016/6/4.
 */
public class DoctorsAdapter extends BaseAdapter {

    Context Acontext;
    List<Map<String, Object>> Alist = new ArrayList<Map<String, Object>>();
    ViewHold_02 VH;
    LayoutInflater layoutInflater;

    FinalBitmap fb;

    boolean onScroll = false;

    public void onSetScrollState(boolean onScrolling) {
        onScroll = onScrolling;
    }

    public DoctorsAdapter(Context context,
                                    List<Map<String, Object>> list,FinalBitmap fb) {
        Acontext = context;
        this.fb = fb;
        Alist = list;
        layoutInflater = LayoutInflater.from(context);
    }



    @Override
    public int getCount() {
        return Alist.size();
    }

    @Override
    public Object getItem(int position) {
        if (Alist != null) {
            return Alist.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {

            convertView = layoutInflater.inflate(R.layout.list_item, null);

            VH = new ViewHold_02();
            VH.img_header = (ImageView) convertView.findViewById(R.id.img_header);

            VH.name = (TextView) convertView.findViewById(R.id.name);
            VH.descption = (TextView) convertView.findViewById(R.id.descption);

            convertView.setTag(VH);

        } else {
            VH = (ViewHold_02) convertView.getTag();
        }

        if(onScroll){
            fb.display(VH.img_header,Alist.get(position).get("headerURL").toString());
        }

        VH.name.setText( Alist.get(position).get("name").toString());
        VH.descption.setText( Alist.get(position).get("descption").toString());

        return convertView;
    }

    public static class ViewHold_02 {

        ImageView img_header;

        TextView name;
        TextView descption;

    }
}
