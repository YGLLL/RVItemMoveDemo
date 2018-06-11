package com.example.minkin.RVItemMoveDemo;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/*
 *创建人:yanggl
 *创建时间:2018-6-7  9:57
 *类描述:
 *备注:
 */
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<String> mData;
    private Context mContext;
    public Adapter(Context context){
        mData=new ArrayList<>();
        mContext=context;
    }

    public void setData(List<String> list){
        mData=list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (mData.get(position).contains("将")){
            holder.mTv.setTextColor(Color.BLACK);
            holder.mIv.setBackgroundColor(Color.BLACK);
        }else {
            holder.mTv.setTextColor(Color.RED);
            holder.mIv.setBackgroundColor(Color.RED);
        }
        holder.mTv.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView mTv;
        ImageView mIv;
        public ViewHolder(View itemView) {
            super(itemView);
            mTv=(TextView)itemView.findViewById(R.id.tv);
            mIv=(ImageView)itemView.findViewById(R.id.iv);
        }
    }
}
