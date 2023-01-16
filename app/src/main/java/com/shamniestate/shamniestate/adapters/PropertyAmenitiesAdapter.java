package com.shamniestate.shamniestate.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shamniestate.shamniestate.R;
import com.shamniestate.shamniestate.databinding.PropeertyTypeLayoutBinding;
import com.shamniestate.shamniestate.models.AmenitiesListModel;

import java.util.List;

public class PropertyAmenitiesAdapter extends RecyclerView.Adapter<PropertyAmenitiesAdapter.ViewHolder>{

    Context context ;
    List<AmenitiesListModel.AmenitiesData> models ;

    public PropertyAmenitiesAdapter(Context context, List<AmenitiesListModel.AmenitiesData> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return  new ViewHolder(LayoutInflater.from(context).inflate(R.layout.propeerty_type_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.typeProperty.setText(models.get(position).getAmenitiesName());

        holder.itemView.setOnClickListener(v -> {
            if(models.get(holder.getAdapterPosition()).isSelected()){
                holder.binding.linear.setBackgroundResource(R.drawable.property_type_unselected_bg);
                holder.binding.image.setImageResource(R.drawable.ic_add);
                holder.binding.typeProperty.setTextColor(context.getResources().getColor(R.color.light_black));
                models.get(holder.getAdapterPosition()).setSelected(false);
            }else {
                models.get(holder.getAdapterPosition()).setSelected(true);
                holder.binding.typeProperty.setTextColor(context.getResources().getColor(R.color.colorPrimary));
                holder.binding.linear.setBackgroundResource(R.drawable.property_type_selected_bg);
                holder.binding.image.setImageResource(R.drawable.ic_baseline_check_24);
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public  class  ViewHolder extends RecyclerView.ViewHolder{
        PropeertyTypeLayoutBinding binding ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = PropeertyTypeLayoutBinding.bind(itemView);
        }
    }
}
