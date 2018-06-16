package com.example.salomoncastro.beta03;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Salomon Castro on 6/15/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    private Context mContext;
    private  ArrayList<Notice> mData;

    public RecyclerViewAdapter(Context mContext, List<Notice> mData) {
        this.mContext = mContext;
        this.mData = (ArrayList<Notice>) mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item_notice,parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.tv_notice_title.setText(mData.get(position).getTitle());
        holder.img_notice_thumbnail.setImageResource(mData.get(position).getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext,Notice_Activity.class);

                //Passing data to the notice activity

                intent.putExtra("Title",mData.get(position).getTitle());
                intent.putExtra("Description",mData.get(position).getDescription());
                intent.putExtra("Thumbnail",mData.get(position).getThumbnail());

                //start activity

                mContext.startActivity(intent);

            }
        });

        //Set On Clic Listener



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_notice_title;
        ImageView img_notice_thumbnail;
        CardView cardView;



        public MyViewHolder(View itemView){
            super(itemView);

            tv_notice_title = (TextView) itemView.findViewById(R.id.notice_title_id);
            img_notice_thumbnail = (ImageView) itemView.findViewById(R.id.notice_img_id);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);

        }
    }

    //ESTO TAMBIEN

    public void setFilter(ArrayList<Notice> newList) {

        mData = new ArrayList<>();
        mData.addAll(newList);
        notifyDataSetChanged();

    }

}
