package com.android.sunny.booklisting;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by Sunny on 1/5/2017.
 */
public class ImageAdapter extends BaseAdapter {

    private Context mContext;
    private Integer[] mThumbsIds = {
            R.drawable.sample_image, R.drawable.sample_image, R.drawable.sample_image, R.drawable.sample_image,
            R.drawable.sample_image, R.drawable.sample_image, R.drawable.sample_image, R.drawable.sample_image
    };

    public ImageAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return mThumbsIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            //imageView.setLayoutParams(new GridLayout.LayoutParams(120, 120));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbsIds[position]);
        return imageView;
    }

}
