package com.example.harmony.ui.practise;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.example.harmony.PractiseActivity;
import com.example.harmony.R;




public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String [] names;
    String [] descriptions;
    String[] numbers;
    int [] images;
    //boolean completes[];
    Context context;
    private Listener listener;

    interface Listener{
        void onClick(int position);
    }
    public MyAdapter(Context context, String []names, String []descriptions, String []numbers,int []images){
        this.context = context;
        this.names = names;
        this.descriptions = descriptions;
        this.numbers = numbers;
        this.images = images;
        //this.completes = completes;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.practise_card, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.name.setText(names[position]);
        holder.description.setText(descriptions[position]);
        holder.number.setText(numbers[position]);
        holder.image.setImageResource(images[position]);
        holder.image.setContentDescription(names[position]);

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(listener!=null){
                   listener.onClick(position);
               }
            }
        });

    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    public void setListener(Listener listener){
        this.listener=listener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView description;
        TextView number;
        ImageView image;
        Button button;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameOfPractice);
            description = itemView.findViewById(R.id.descriptionOfPractice);
            number = itemView.findViewById(R.id.numberOfPractice);
            image = itemView.findViewById(R.id.imageOfPractice);
            button = itemView.findViewById(R.id.practiseButton);
        }
    }
}
