package com.shamniestate.shamniestate.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shamniestate.shamniestate.R;
import com.shamniestate.shamniestate.databinding.PropertySlotsLayoutBinding;
import com.shamniestate.shamniestate.models.PropertyDetailsModel;

import java.util.List;

public class PropertySlotsAdapter extends RecyclerView.Adapter<PropertySlotsAdapter.ViewHolder> {

    Context context;
    List<PropertyDetailsModel.PropertyData.PropertySlot> dataList;

    public PropertySlotsAdapter(Context context, List<PropertyDetailsModel.PropertyData.PropertySlot> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.property_slots_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if (dataList.get(position).getSlotSellType().equalsIgnoreCase("1"))
            holder.binding.slotLinear.setBackgroundResource(R.drawable.available_slots);
        else if (dataList.get(position).getSlotSellType().equalsIgnoreCase("2"))
            holder.binding.slotLinear.setBackgroundResource(R.drawable.hold_slots_bg);
        else holder.binding.slotLinear.setBackgroundResource(R.drawable.not_available_slots);


        holder.binding.slotText.setText(dataList.get(position).getSlotNo());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        PropertySlotsLayoutBinding binding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = PropertySlotsLayoutBinding.bind(itemView);
        }
    }
}
