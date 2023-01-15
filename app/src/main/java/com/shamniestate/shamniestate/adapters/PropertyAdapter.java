package com.shamniestate.shamniestate.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.recyclerview.widget.RecyclerView;

import com.shamniestate.shamniestate.R;
import com.shamniestate.shamniestate.databinding.HomePropertyLayoutBinding;
import com.shamniestate.shamniestate.models.PropertyModel;
import com.shamniestate.shamniestate.ui.home.UserPropertyDetailsActivity;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.List;

public class PropertyAdapter extends RecyclerView.Adapter<PropertyAdapter.ViewHolder>{

    Context context ;
    List<PropertyModel.PropertyData> models  ;

    public PropertyAdapter(Context context, List<PropertyModel.PropertyData> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return  new ViewHolder(LayoutInflater.from(context).inflate(R.layout.home_property_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.propertyName.setText(models.get(position).getPropertyTitle());
        holder.binding.propertyPrice.setText(models.get(position).getPropertyMinPrice());
        holder.binding.propertyPricePerFeet.setText(models.get(position).getPropertyPricePerUnit());

        Picasso.get().load(models.get(position).getPropertyImage()).into(holder.binding.image);

        holder.itemView.setOnClickListener(v -> context.startActivity(new Intent(context, UserPropertyDetailsActivity.class)
                .putExtra("data", (Serializable) models.get(holder.getAdapterPosition()))));
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public  class  ViewHolder extends RecyclerView.ViewHolder{
        HomePropertyLayoutBinding binding ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding  = HomePropertyLayoutBinding.bind(itemView);
        }
    }
}
