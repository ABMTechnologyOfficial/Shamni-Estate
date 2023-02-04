package com.shamniestate.shamniestate.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shamniestate.shamniestate.R;
import com.shamniestate.shamniestate.databinding.BookedPropertyLayoutBinding;
import com.shamniestate.shamniestate.models.HoldPropertyModel;

import java.util.List;

public class HoldPropertyAdapter extends RecyclerView.Adapter<HoldPropertyAdapter.ViewHolder>{

    Context context ;
    List<HoldPropertyModel.HoldPropertyData> models ;

    public HoldPropertyAdapter(Context context, List<HoldPropertyModel.HoldPropertyData> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.booked_property_layout, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        HoldPropertyModel.HoldPropertyData data = models.get(position);

        holder.binding.propertyCode.setText(data.getPropertyCode());
        holder.binding.propertyTitle.setText(data.getPropertyTitle());
        holder.binding.slotNumber.setText(data.getSlotNo());
        holder.binding.unitPrice.setText("Unit Price "+data.getUnitPrice());
        holder.binding.area.setText(data.getUnitSize() + " " + data.getAreaUnitType());

        holder.binding.address.setText(data.getApplicantPermanentAdd());
        holder.binding.city.setText(data.getApplicantCity());
        holder.binding.email.setText(data.getApplicantEmail());
        holder.binding.name.setText(data.getApplicantName());
        holder.binding.mobile.setText(data.getApplicantContactNo() + " , " + data.getApplicantContactSecondNo());

        holder.binding.facingCharge.setText(data.getFacingCharges());
        holder.binding.slotFacing.setText(data.getSlotFacing());
        holder.binding.slotMaintainCharge.setText(data.getSlotMaintenanceCharges());

        holder.binding.viewMore.setOnClickListener(v -> {
            if (data.isOpened()) {
                data.setOpened(false);
                holder.binding.viewMore.setImageResource(R.drawable.ic_baseline_expand_more_24);
                holder.binding.viewDetailsLinear.setVisibility(View.GONE);
            } else {
                data.setOpened(true);
                holder.binding.viewMore.setImageResource(R.drawable.ic_baseline_expand_less_24);
                holder.binding.viewDetailsLinear.setVisibility(View.VISIBLE);
            }
        });
        
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        BookedPropertyLayoutBinding binding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = BookedPropertyLayoutBinding.bind(itemView);
        }
    }
}
