package com.shamniestate.shamniestate.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shamniestate.shamniestate.R;
import com.shamniestate.shamniestate.databinding.CityLayoutBinding;
import com.shamniestate.shamniestate.models.CityListModel;
import com.shamniestate.shamniestate.models.FilterInterface;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {

    private final Context context;
    private final List<CityListModel.CityData> models;
    private final FilterInterface filterInterface;

    public CityAdapter(Context context, List<CityListModel.CityData> model, FilterInterface filterInterface) {
        this.filterInterface = filterInterface;
        this.context = context;
        this.models = model;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.city_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final CityListModel.CityData current = models.get(position);

        holder.binding.cityCheckbox.setText(models.get(position).getCityName());

        holder.itemView.setOnClickListener(v -> {
            if (models.get(holder.getAdapterPosition()).isSelected()) {
                holder.binding.linear.setBackgroundResource(R.drawable.property_type_unselected_bg);
                holder.binding.cityCheckbox.setTextColor(context.getResources().getColor(R.color.light_black));
                models.get(holder.getAdapterPosition()).setSelected(false);

                filterInterface.deleteItem(current.getCityId(), 0);
            } else {
                models.get(holder.getAdapterPosition()).setSelected(true);
                holder.binding.cityCheckbox.setTextColor(context.getResources().getColor(R.color.colorPrimary));
                holder.binding.linear.setBackgroundResource(R.drawable.property_type_selected_bg);

                filterInterface.addItem(current.getCityId(), 0);
            }
        });

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CityLayoutBinding binding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = CityLayoutBinding.bind(itemView);
        }
    }
}
