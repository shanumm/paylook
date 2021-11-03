//package com.myapplication.permission;
////
////import android.content.Context;
////import android.view.LayoutInflater;
////import android.view.View;
////import android.view.ViewGroup;
////import android.widget.ImageView;
////import android.widget.TextView;
////import android.widget.Toast;
////
////import androidx.annotation.NonNull;
////import androidx.recyclerview.widget.RecyclerView;
////
////public class priceAdapter extends RecyclerView.Adapter<priceAdapter.ViewHolder> {
////
////    priceData[] PriceData;
////    Context context;
////
////
////    public priceAdapter(priceData[] PriceData, MainActivity activity) {
////        this.PriceData= PriceData;
////        this.context=activity;
////    }
////
////    @NonNull
////    @Override
////    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
////        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
////        View view=layoutInflater.inflate(R.layout.dashboard_item_1,parent,false);
////        ViewHolder viewHolder=new ViewHolder(view);
////
////        return viewHolder;
////    }
////
////    @Override
////    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
////        final  priceData PriceDataList=PriceData[position];
////        holder.textPriceAmount.setText(PriceDataList.getPriceAmount());
////        holder.textLocation.setText(PriceDataList.getSendReceived());
////        holder.textTime.setText(PriceDataList.getTime());
////
////        holder.itemView.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                Toast.makeText(context, PriceDataList.getPriceAmount(), Toast.LENGTH_SHORT).show();
////            }
////        });
////
////    }
////
////    @Override
////    public int getItemCount() {
////        return PriceData.length;
////    }
////
////    public class ViewHolder extends RecyclerView.ViewHolder{
////
////        TextView textPriceAmount;
////        TextView textLocation;
////        TextView textTime;
////        public ViewHolder(@NonNull View itemView) {
////            super(itemView);
////            textPriceAmount=itemView.findViewById(R.id.textAmount);
////            textLocation=itemView.findViewById(R.id.textLocation);
////            textTime=itemView.findViewById(R.id.textTime);
////        }
////    }
////}
//
//
package com.myapplication.permission;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyMovieAdapter extends RecyclerView.Adapter<MyMovieAdapter.ViewHolder> {

    MyMovieData[] myMovieData;
    Context context;

    public MyMovieAdapter(MyMovieData[] myMovieData,MainActivity activity) {
        this.myMovieData = myMovieData;
        this.context = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final MyMovieData myMovieDataList = myMovieData[position];
        holder.textViewName.setText(myMovieDataList.getMovieName());
        holder.textViewDate.setText(myMovieDataList.getMovieDate());
        holder.movieImage.setImageResource(myMovieDataList.getMovieImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, myMovieDataList.getMovieName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return myMovieData.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView movieImage;
        TextView textViewName;
        TextView textViewDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            movieImage = itemView.findViewById(R.id.imageview);
//            textViewName = itemView.findViewById(R.id.textName);
//            textViewDate = itemView.findViewById(R.id.textdate);

        }
    }

}


