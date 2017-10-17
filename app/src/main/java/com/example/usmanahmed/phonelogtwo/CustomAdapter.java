package com.example.usmanahmed.phonelogtwo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Usman Ahmed on 17/10/2017.
 */

public class CustomAdapter extends ArrayAdapter<Contact> implements View.OnClickListener
        private ArrayList<Contact> dataSet;
        Context mContext;
        ImageView imageView;
        boolean anim = false;


private static class ViewHolder {
    TextView txtName;
    ImageView dp;
    ImageView info;
}


    public CustomAdapter(ArrayList<Contact> data, Context context) {
        super(context, R.layout.row_item, data);
        this.dataSet = data;
        this.mContext = context;
    }


    @Override
    public void onClick(View v) {


        int position = (Integer) v.getTag();
        Object object = getItem(position);
        Contact dataModel = (Contact) object;
        switch (v.getId()) {
            case R.id.item_info:

                dataSet.remove(position);
                anim = true;
                if (anim) {
                    Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.left);

                    v.startAnimation(animation);
                    anim=false;
                }
                this.notifyDataSetChanged();
                break;
        }
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Contact contact = getItem(position);
        ViewHolder viewHolder;

        final View result;

        if (convertView == null) {
            viewHolder = new ViewHolder();

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_item, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.name);
            viewHolder.info = (ImageView) convertView.findViewById(R.id.item_info);
            viewHolder.dp = (ImageView) convertView.findViewById(R.id.itemimage);
            result = convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        lastPosition = position;
        viewHolder.txtName.setText(contact.getName());
        viewHolder.info.setOnClickListener(this);
        viewHolder.info.setTag(position);
        viewHolder.dp.setImageResource(android.R.drawable.btn_plus);
        return convertView;
    }


}
