package com.mil.en2fr.dynamic_box_create;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter  extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    LayoutInflater layoutInflater;
    ArrayList<RecycleDataModel> myList;

    public RecyclerAdapter(ArrayList<RecycleDataModel> myList, MainActivity mainActivity) {
        this.myList=myList;
        layoutInflater=LayoutInflater.from(mainActivity);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= layoutInflater.inflate(R.layout.recycler_row_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RecycleDataModel model=myList.get(position);
        ViewHolder viewHolder=(ViewHolder) holder;
        viewHolder.txt_show.setText(model.getTitle());
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_show;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_show=itemView.findViewById(R.id.txt_show);

        }
    }
}
