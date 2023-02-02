package com.shamniestate.shamniestate.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shamniestate.shamniestate.R;
import com.shamniestate.shamniestate.ServiceActivity;
import com.shamniestate.shamniestate.databinding.ServiceLayoutBinding;
import com.shamniestate.shamniestate.models.ServiceModel;

import java.util.List;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ViewHolder>{

    Context context ;
    List<ServiceModel> model ;

    public ServiceAdapter(Context context, List<ServiceModel> model) {
        this.context = context;
        this.model = model;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       return  new ViewHolder(LayoutInflater.from(context).inflate(R.layout.service_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.binding.image.setImageResource(model.get(position).getImage());
        holder.binding.propertyTitle.setText(model.get(position).getName());

        if(position == 0 )
            holder.binding.linear.setBackgroundResource(R.drawable.purpla_bg);
        else if(position ==1 )
            holder.binding.linear.setBackgroundResource(R.drawable.pink_bg);
        else if(position ==2 )
            holder.binding.linear.setBackgroundResource(R.drawable.green_bg);
          else if(position ==3 )
            holder.binding.linear.setBackgroundResource(R.drawable.pink_bg);
         else if(position ==4 )
            holder.binding.linear.setBackgroundResource(R.drawable.purpla_bg);
         else if(position ==5 )
            holder.binding.linear.setBackgroundResource(R.drawable.green_bg);
         else if(position ==6 )
            holder.binding.linear.setBackgroundResource(R.drawable.green_bg);
         else if(position ==7 )
            holder.binding.linear.setBackgroundResource(R.drawable.purpla_bg);
         else
            holder.binding.linear.setBackgroundResource(R.drawable.pink_bg);


    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public  class  ViewHolder extends RecyclerView.ViewHolder{
        ServiceLayoutBinding binding ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ServiceLayoutBinding.bind(itemView);
        }
    }
}
