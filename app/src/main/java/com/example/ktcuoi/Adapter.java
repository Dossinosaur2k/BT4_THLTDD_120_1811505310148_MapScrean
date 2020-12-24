package com.example.ktcuoi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.itemViewholder> {
    Context context;
    List<itemmap> itemmapList;

    public Adapter(Context context, List<itemmap> itemmapList) {
        this.context = context;
        this.itemmapList = itemmapList;
    }

    @NonNull
    @Override
    public Adapter.itemViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rowmapitem,parent,false);
        return new Adapter.itemViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.itemViewholder holder, int position) {
        holder.image.setImageResource(itemmapList.get(position).getImage());
        holder.title.setText(itemmapList.get(position).getNamestore());
        holder.text.setText(itemmapList.get(position).getMota());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,MainActivity.class);
                intent.putExtra("X",itemmapList.get(position).getX());
                intent.putExtra("Y",itemmapList.get(position).getY());
                intent.putExtra("namequan",itemmapList.get(position).getNamestore());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemmapList.size();
    }
public static final class itemViewholder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title,text;
        public itemViewholder(View itemView){
            super(itemView);
            image=itemView.findViewById(R.id.image1);
            title=itemView.findViewById(R.id.title1);
            text=itemView.findViewById(R.id.text1);
        }
}
}
