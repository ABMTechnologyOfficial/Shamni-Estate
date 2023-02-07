package com.shamniestate.shamniestate.adapters;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shamniestate.shamniestate.R;
import com.shamniestate.shamniestate.databinding.BookHoldPropertyLayoutBinding;
import com.shamniestate.shamniestate.databinding.PropertySlotsLayoutBinding;
import com.shamniestate.shamniestate.models.PropertyBuilderModel;
import com.shamniestate.shamniestate.models.PropertyDetailsModel;
import com.shamniestate.shamniestate.ui.home.BookHoldPropertyActivity;

import java.util.List;

public class PropertySlotsAdapter extends RecyclerView.Adapter<PropertySlotsAdapter.ViewHolder> {

    Context context;
    List<PropertyDetailsModel.PropertyData.PropertySlot> dataList;
    PropertyBuilderModel model;

    public PropertySlotsAdapter(Context context, List<PropertyDetailsModel.PropertyData.PropertySlot> dataList, PropertyBuilderModel model) {
        this.context = context;
        this.dataList = dataList;
        this.model = model ;
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

        holder.itemView.setOnClickListener(v -> showDialog(dataList.get(position)));


    }

    private void showDialog(PropertyDetailsModel.PropertyData.PropertySlot propertySlot) {
        final Dialog dialog = new Dialog(context);

        BookHoldPropertyLayoutBinding binding ;
        binding = BookHoldPropertyLayoutBinding.inflate(LayoutInflater.from(context));
        dialog.setContentView(binding.getRoot());
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.white);
        dialog.getWindow().setDimAmount(0f);

        binding.propertyName.setText(model.getPropertyName());
        binding.accountHolderName.setText(model.getAccountHolderName());
        binding.bankName.setText(model.getBankName());
        binding.ifscCode.setText(model.getIfscCode());
        binding.accountNumber.setText(model.getAccountNumber());

        if(!propertySlot.getSlotSellType().equalsIgnoreCase("1")){
            binding.bookBtn.setVisibility(View.INVISIBLE);
            binding.holdBtn.setVisibility(View.INVISIBLE);
        }

        binding.slotName.setText(propertySlot.getSlotFacing());
        binding.unitName.setText(propertySlot.getUnitName());
        binding.unitNumber.setText(propertySlot.getSlotNo());
        binding.pericePerSqft.setText(propertySlot.getUnitSizePrice() );
        binding.unitSize.setText(propertySlot.getUnitSize()+" "+ propertySlot.getUnitSizeType());
        binding.unitExtraCharge.setText(propertySlot.getSlotMaintenanceCharges());

        binding.bankDetailsTv.setOnClickListener(v -> {
            binding.bankDetailsTv.setBackgroundResource(R.drawable.slot_selected_linear);
            binding.propertyDetailsTv.setBackgroundResource(R.drawable.slot_linear_bg);
            binding.bankDetailsTv.setTextColor(context.getResources().getColor(R.color.white));
            binding.propertyDetailsTv.setTextColor(context.getResources().getColor(R.color.black));
            binding.propertyDetailsLinear.setVisibility(View.GONE);
            binding.bankDetailsLinear.setVisibility(View.VISIBLE);
        });
        binding.propertyDetailsTv.setOnClickListener(v -> {
            binding.propertyDetailsTv.setBackgroundResource(R.drawable.slot_selected_linear);
            binding.bankDetailsTv.setBackgroundResource(R.drawable.slot_linear_bg);
            binding.bankDetailsTv.setTextColor(context.getResources().getColor(R.color.black));
            binding.propertyDetailsTv.setTextColor(context.getResources().getColor(R.color.white));
            binding.propertyDetailsLinear.setVisibility(View.VISIBLE);
            binding.bankDetailsLinear.setVisibility(View.GONE);
        });

        binding.close.setOnClickListener(v -> dialog.dismiss());

        binding.bookBtn.setOnClickListener(v -> {
            context.startActivity(new Intent(context, BookHoldPropertyActivity.class)
                    .putExtra("type", "book")
                    .putExtra("slotId", propertySlot.getSlotId())
            );
            dialog.dismiss();
        });

        binding.holdBtn.setOnClickListener(v -> {
            context.startActivity(new Intent(context, BookHoldPropertyActivity.class)
                    .putExtra("type", "hold")
                    .putExtra("slotId", propertySlot.getSlotId()));
            dialog.dismiss();
        });

        dialog.show();
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
