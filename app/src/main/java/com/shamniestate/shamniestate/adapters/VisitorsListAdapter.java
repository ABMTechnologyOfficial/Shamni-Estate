package com.shamniestate.shamniestate.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shamniestate.shamniestate.R;
import com.shamniestate.shamniestate.databinding.MyAssociateLayoutBinding;
import com.shamniestate.shamniestate.models.VisitorsListModel;
import com.shamniestate.shamniestate.visitors.VisitorProfileActivity;

import java.util.List;

public class VisitorsListAdapter extends RecyclerView.Adapter<VisitorsListAdapter.ViewHolder>{

    Context context ;
    List<VisitorsListModel.VisitorListData> models ;

    public VisitorsListAdapter(Context context, List<VisitorsListModel.VisitorListData> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      return  new ViewHolder(LayoutInflater.from(context).inflate(R.layout.my_associate_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.assocCity.setText(models.get(position).getVisitorDov());
        holder.binding.assocName.setText(models.get(position).getVisitorName());
        holder.binding.assocEmail.setText(models.get(position).getVisitorEmail());
        holder.binding.assocMobile.setText(models.get(position).getVisitorMob());

        holder.itemView.setOnClickListener(view -> context.startActivity(new Intent(context, VisitorProfileActivity.class).putExtra("visitorId",models.get(position).getVisitorId())));
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public  class  ViewHolder extends RecyclerView.ViewHolder{
        MyAssociateLayoutBinding binding ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = MyAssociateLayoutBinding.bind(itemView);
        }
    }
}
