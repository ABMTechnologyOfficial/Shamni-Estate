package com.shamniestate.shamniestate.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shamniestate.shamniestate.R;
import com.shamniestate.shamniestate.models.PropertyModel;
import com.shamniestate.shamniestate.databinding.HomeCityLayoutBinding;
import com.shamniestate.shamniestate.models.PropertyPlanModel;

import java.util.List;

public class HomePlanAdapter extends RecyclerView.Adapter<HomePlanAdapter.ViewHolder>{

    Context context ;
    List<PropertyPlanModel.PropertyPlanData> model ;

    public HomePlanAdapter(Context context, List<PropertyPlanModel.PropertyPlanData> model) {
        this.context = context;
        this.model = model;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return  new ViewHolder(LayoutInflater.from(context).inflate(R.layout.home_city_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.binding.planName.setText(model.get(position).getPropertyPlanName());
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public  class  ViewHolder extends RecyclerView.ViewHolder{

        HomeCityLayoutBinding binding ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding  = HomeCityLayoutBinding.bind(itemView);
        }
    }
}
