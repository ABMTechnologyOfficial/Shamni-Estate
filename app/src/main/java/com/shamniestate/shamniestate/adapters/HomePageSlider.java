package com.shamniestate.shamniestate.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shamniestate.shamniestate.R;
import com.shamniestate.shamniestate.databinding.HomeSliderLayoutBinding;
import com.shamniestate.shamniestate.databinding.MainSliderLayoutBinding;
import com.shamniestate.shamniestate.models.HomeSliderModel;
import com.shamniestate.shamniestate.ui.home.MyAssociatesActivity;
import com.shamniestate.shamniestate.ui.home.MyBookedPropertyActivity;
import com.shamniestate.shamniestate.ui.home.MyHoldProperyActivity;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;

public class HomePageSlider extends SliderViewAdapter<HomePageSlider.SlideView> {


    List<HomeSliderModel.HomeSliderData> model;
    Context context;

    public HomePageSlider(List<HomeSliderModel.HomeSliderData> model, Context context) {
        this.model = model;
        this.context = context;

    }

    @Override
    public SlideView onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.main_slider_layout, parent, false);
        return new SlideView(view);
    }

    @Override
    public void onBindViewHolder(SlideView viewHolder, int position) {

        HomeSliderModel.HomeSliderData homeBannerData = model.get(position);
        viewHolder.binding.totalCount.setText(String.valueOf(homeBannerData.getTotalMembers()));

        if (position == 0)
            viewHolder.binding.titleText.setText("Team Members");
        else if (position == 1)
            viewHolder.binding.titleText.setText("Hold Property");
        else viewHolder.binding.titleText.setText("Booked Property");

        viewHolder.binding.textLogin.setOnClickListener(view -> {
            Intent intent;
            if (position == 0) intent = new Intent(context, MyAssociatesActivity.class);
            else if (position == 1) intent = new Intent(context, MyHoldProperyActivity.class);
            else intent = new Intent(context, MyBookedPropertyActivity.class);

            context.startActivity(intent);
        });

    }

    @Override
    public int getCount() {
        return model.size();
    }

    public class SlideView extends ViewHolder {
        MainSliderLayoutBinding binding;

        public SlideView(View itemView) {
            super(itemView);
            binding = MainSliderLayoutBinding.bind(itemView);

        }
    }
}
