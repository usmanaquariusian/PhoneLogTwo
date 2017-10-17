package com.example.usmanahmed.phonelogtwo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Usman Ahmed on 17/10/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter
        <RecyclerAdapter.MyViewHolder> {
    private List<Contact> list;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtName;
        ImageView dp;
        ImageView info;

        public MyViewHolder(View view) {
            super(view);
            txtName = (TextView) view.findViewById(R.id.name);
            info = (ImageView) view.findViewById(R.id.item_info);
            dp = (ImageView) view.findViewById(R.id.itemimage);
        }
    }


    public RecyclerAdapter(List<Contact> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, final int position) {
        Contact contact = list.get(position);
        viewHolder.txtName.setText(contact.getName());
        viewHolder.info.setTag(position);
        viewHolder.info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(position);

                notifyDataSetChanged();
                notifyItemRangeChanged(position,list.size());

            }
        });
        Picasso.with(context).load(Contact.getImgurl()).resize(150, 150).centerCrop().into(viewHolder.dp);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}
