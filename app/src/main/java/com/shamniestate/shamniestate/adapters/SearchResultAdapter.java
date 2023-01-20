package com.shamniestate.shamniestate.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.shamniestate.shamniestate.databinding.ItemSearchResultLayBinding;
import com.shamniestate.shamniestate.models.PropertyModel;

import java.util.List;

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.ViewHolder> {
    private final Context context;
    private final List<PropertyModel.PropertyData> data;

    public SearchResultAdapter(Context context, List<PropertyModel.PropertyData> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemSearchResultLayBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (data.get(position) != null) {
            PropertyModel.PropertyData current = data.get(position);

            holder.binding.textName.setText(current.getPropertyTitle());
            holder.binding.textAddress.setText(" in " + current.getCityName());
//            if (current.getPropertyFurnishingStatus().equalsIgnoreCase("0"))
//                holder.binding.textRooms.setText("Unfurnished Property");
//            else
//                holder.binding.textRooms.setText("Furnished Property");

            holder.binding.textRooms.setText(current.getNoOfBedroom() + " BHK");
            Glide.with(context).load(current.getPropertyImage())
                    .placeholder(AppCompatResources.getDrawable(context, com.denzcoskun.imageslider.R.drawable.loading))
                    .into(holder.binding.imageProperty);

            holder.binding.textPrice.setText("₹ " + current.getPropertyMaxPrice());
            holder.binding.textPricePerUnit.setText("@ " + current.getPropertyPricePerUnit() + "/ " + current.getAreaUnitType());

            holder.binding.textArea.setText(current.getMaxUnitArea() + " " + current.getAreaUnitType());
            holder.binding.textPincode.setText("Pincode: " + current.getPropertyZipCode());

            holder.binding.textLocality.setText(current.getLocalityName());
            holder.binding.textPropertyCode.setText("Property Code: " + current.getPropertyCode());
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ItemSearchResultLayBinding binding;

        public ViewHolder(@NonNull ItemSearchResultLayBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}
