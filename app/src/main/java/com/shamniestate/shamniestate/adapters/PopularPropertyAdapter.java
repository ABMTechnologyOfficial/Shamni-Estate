package com.shamniestate.shamniestate.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.animation.content.Content;
import com.shamniestate.shamniestate.R;
import com.shamniestate.shamniestate.databinding.PopularPropertyLayoutBinding;
import com.shamniestate.shamniestate.databinding.PropeertyTypeLayoutBinding;
import com.shamniestate.shamniestate.models.PropertyModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PopularPropertyAdapter extends RecyclerView.Adapter<PopularPropertyAdapter.ViewHolder>{

    Context context ;
    List<PropertyModel.PropertyData> models ;

    public PopularPropertyAdapter(Context context, List<PropertyModel.PropertyData> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return  new ViewHolder(LayoutInflater.from(context).inflate(R.layout.popular_property_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Picasso.get().load(models.get(position).getPropertyImage()).into(holder.binding.propertyImageBig);
        holder.binding.propertyArea.setText(models.get(position).getMaxUnitArea() + models.get(position).getAreaUnitType());
        holder.binding.propertyPrice.setText(models.get(position).getPropertyMaxPrice());
        holder.binding.planName.setText(models.get(position).getPropertyTitle());

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{
        PopularPropertyLayoutBinding binding ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = PopularPropertyLayoutBinding.bind(itemView);
        }
    }
}
