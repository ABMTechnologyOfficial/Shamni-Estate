package com.shamniestate.shamniestate.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shamniestate.shamniestate.R;
import com.shamniestate.shamniestate.RetrofitApis.ApiInterface;
import com.shamniestate.shamniestate.RetrofitApis.RetrofitClient;
import com.shamniestate.shamniestate.databinding.HomePropertyLayoutBinding;
import com.shamniestate.shamniestate.models.AmenitiesListModel;
import com.shamniestate.shamniestate.models.PropertyModel;
import com.shamniestate.shamniestate.ui.home.UserPropertyDetailsActivity;
import com.shamniestate.shamniestate.utils.Session;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PropertyAdapter extends RecyclerView.Adapter<PropertyAdapter.ViewHolder>{

    Context context ;
    List<PropertyModel.PropertyData> models  ;
    private Session session ;
    private List<AmenitiesListModel.AmenitiesData> amenitiesList = new ArrayList<>();

    public PropertyAdapter(Context context, List<PropertyModel.PropertyData> models) {
        this.context = context;
        this.models = models;
        session = new Session(context);
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
        holder.binding.propertyPrice.setText(calculate_price(Integer.parseInt(models.get(position).getPropertyMinPrice())));
        holder.binding.propertyPricePerFeet.setText(models.get(position).getPropertyPricePerUnit());

        Picasso.get().load(models.get(position).getPropertyImage()).into(holder.binding.image);

        holder.itemView.setOnClickListener(v -> context.startActivity(new Intent(context, UserPropertyDetailsActivity.class)
                .putExtra("property_id",  models.get(holder.getAdapterPosition()).getPropertyId())
                .putExtra("property_image",  models.get(holder.getAdapterPosition()).getPropertyImage())
                .putExtra("total_area",  models.get(holder.getAdapterPosition()).getMaxUnitArea())
        ));

//        holder.binding.animRecycler.setAdapter(new SearchResultAmenityAdapter(context, models.get(position).getAmenitiesDataArrayList()));
//        holder.binding.animRecycler.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));

    }


    private String calculate_price(int price) {

        String comnfir_price = "";
        if (price >= 100000 && price <= 10000000) {
            comnfir_price = String.valueOf(price / 100000) + " Lac";
        } else if (price >= 10000000) {
            comnfir_price = String.valueOf(price / 10000000) + " Cr";
        } else {
            comnfir_price = String.valueOf(price / 1000) + " K ";
        }

        return comnfir_price;

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
