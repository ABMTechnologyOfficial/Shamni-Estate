package com.shamniestate.shamniestate.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shamniestate.shamniestate.R;
import com.shamniestate.shamniestate.databinding.HomeSliderLayoutBinding;
import com.shamniestate.shamniestate.models.HomeSliderModel;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;

public class HomePageSlider extends SliderViewAdapter<HomePageSlider.SlideView> {


    List<HomeSliderModel.HomeSliderData> model;
    Context context;
    String url;

    List<String> images;

    public HomePageSlider(List<HomeSliderModel.HomeSliderData> model, Context context) {
        this.model = model;
        this.context = context;

    }

    @Override
    public SlideView onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_slider_layout, parent, false);
        return new SlideView(view);
    }

    @Override
    public void onBindViewHolder(SlideView viewHolder, int position) {

        HomeSliderModel.HomeSliderData homeBannerData = model.get(position);
        viewHolder.binding.totalCount.setText(String.valueOf(homeBannerData.getTotalMembers()));

    }

    @Override
    public int getCount() {
        return model.size();
    }

    public class SlideView extends ViewHolder {
        HomeSliderLayoutBinding binding;

        public SlideView(View itemView) {
            super(itemView);
            binding = HomeSliderLayoutBinding.bind(itemView);

        }
    }
}
