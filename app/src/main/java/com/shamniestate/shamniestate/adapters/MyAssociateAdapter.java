package com.shamniestate.shamniestate.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shamniestate.shamniestate.R;
import com.shamniestate.shamniestate.databinding.MyAssociateLayoutBinding;
import com.shamniestate.shamniestate.models.MyAssociateModel;

import java.util.List;

public class MyAssociateAdapter extends RecyclerView.Adapter<MyAssociateAdapter.ViewHolder>{
    Context context ;
    List<MyAssociateModel.MyAssocData> models ;

    public MyAssociateAdapter(Context context, List<MyAssociateModel.MyAssocData> models) {
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

        holder.binding.assocCity.setText(models.get(position).getAssociateCity());
        holder.binding.assocName.setText(models.get(position).getAssociateName());
        holder.binding.assocEmail.setText(models.get(position).getAssociateEmail());
        holder.binding.assocMobile.setText(models.get(position).getAssociateMobile());

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
