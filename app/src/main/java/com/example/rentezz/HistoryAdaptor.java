package com.example.rentezz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HistoryAdaptor extends RecyclerView.Adapter<HistoryAdaptor.viewHolder> {
    List<HistoryModel> historyModels;
    Context context;

    public HistoryAdaptor( Context context,List<HistoryModel> historyModels) {
        this.historyModels = historyModels;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.history_card,parent,false);
        return  new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int n) {
        HistoryModel model=historyModels.get(n);
        holder.name.setText(model.getName());
        holder.rent.setText(Integer.toString(model.getRent()));
        holder.electric.setText(Integer.toString(model.getElectric()));
        holder.date.setText(model.getDate());

    }

    @Override
    public int getItemCount() {
        return historyModels.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView name,rent,electric,date;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            rent=itemView.findViewById(R.id.rent);
            electric=itemView.findViewById(R.id.electric);
            date=itemView.findViewById(R.id.date);
        }
    }
}
