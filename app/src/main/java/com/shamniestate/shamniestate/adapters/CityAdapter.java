package com.shamniestate.shamniestate.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.ContentView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shamniestate.shamniestate.R;
import com.shamniestate.shamniestate.databinding.CityLayoutBinding;
import com.shamniestate.shamniestate.models.CityListModel;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder>{

    Context context ;
    List<CityListModel.CityData> models ;

    public CityAdapter(Context context, List<CityListModel.CityData> model) {
        this.context = context;
        this.models = model;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return  new ViewHolder(LayoutInflater.from(context).inflate(R.layout.city_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.binding.cityCheckbox.setText(models.get(position).getCityName());

        holder.itemView.setOnClickListener(v -> {
            if(models.get(holder.getAdapterPosition()).isSelected()){
                holder.binding.linear.setBackgroundResource(R.drawable.property_type_unselected_bg);
                holder.binding.cityCheckbox.setTextColor(context.getResources().getColor(R.color.light_black));
                models.get(holder.getAdapterPosition()).setSelected(false);
            }else {
                models.get(holder.getAdapterPosition()).setSelected(true);
                holder.binding.cityCheckbox.setTextColor(context.getResources().getColor(R.color.colorPrimary));
                holder.binding.linear.setBackgroundResource(R.drawable.property_type_selected_bg);
            }
        });

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public  class  ViewHolder extends RecyclerView.ViewHolder{
        CityLayoutBinding binding ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = CityLayoutBinding.bind(itemView);
        }
    }
}
