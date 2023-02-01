package com.shamniestate.shamniestate.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shamniestate.shamniestate.databinding.ItemSearchAmenityLayBinding;
import com.shamniestate.shamniestate.models.AmenitiesListModel;

import java.util.ArrayList;

public class SearchResultAmenityAdapter extends RecyclerView.Adapter<SearchResultAmenityAdapter.Viewholder> {

    private  Context context;
    private  ArrayList<AmenitiesListModel.AmenitiesData> data;

    public SearchResultAmenityAdapter(Context context, ArrayList<AmenitiesListModel.AmenitiesData> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Viewholder(ItemSearchAmenityLayBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        if (data.get(position) != null) {
            AmenitiesListModel.AmenitiesData current = data.get(position);

            holder.binding.typeProperty.setText(current.getAmenitiesName());
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        public ItemSearchAmenityLayBinding binding;

        public Viewholder(@NonNull ItemSearchAmenityLayBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}
