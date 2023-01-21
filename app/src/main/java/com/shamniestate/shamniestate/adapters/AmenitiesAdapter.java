package com.shamniestate.shamniestate.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shamniestate.shamniestate.R;
import com.shamniestate.shamniestate.databinding.AmenitiesListLayoutBinding;
import com.shamniestate.shamniestate.models.AmenitiesListModel;
import com.shamniestate.shamniestate.models.PropertyDetailsModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AmenitiesAdapter extends RecyclerView.Adapter<AmenitiesAdapter.ViewHolder>{

    Context context ;
    List<PropertyDetailsModel.PropertyData.PropertyAmenity> models ;

    public AmenitiesAdapter(Context context, List<PropertyDetailsModel.PropertyData.PropertyAmenity> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return  new ViewHolder(LayoutInflater.from(context).inflate(R.layout.amenities_list_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.amenitiesName.setText(models.get(position).getAmenitiesName());

        if(!models.get(position).getAmenitiesIcon().equalsIgnoreCase(""))
          Picasso.get().load(models.get(position).getAmenitiesIcon()).into(holder.binding.amenitiesImage);

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public  class  ViewHolder extends RecyclerView.ViewHolder{
        AmenitiesListLayoutBinding binding ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding =  AmenitiesListLayoutBinding.bind(itemView);
        }
    }
}
