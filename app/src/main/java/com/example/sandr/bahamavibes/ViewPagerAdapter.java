package com.example.sandr.bahamavibes;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.sandr.bahamavibes.R;

/*
  Extend the pager adapter class
 */
public class ViewPagerAdapter  extends PagerAdapter{

    private Context context;

    private LayoutInflater layoutInflater;

    private Integer[] images = {R.drawable.junkanooculture,R.drawable.seafood,R.drawable.slavehouse,R.drawable.pigs};

    public ViewPagerAdapter(Context context){

        this.context = context;

    }

/*
  get the amount of images to display
 */
    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final View view = layoutInflater.inflate(R.layout.custom_layout,null);

        /*
          Make the images clickable
          Go to Main activity When pressed
         */
/*
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(),MainActivity.class);

                view.getContext().startActivity(intent);

            }
        });
        */

        ImageView imageView = (ImageView) view.findViewById(R.id.image_view);

        imageView.setImageResource(images[position]);

        ViewPager vp = (ViewPager) container;

        vp.addView(view,0);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        ViewPager vp = (ViewPager) container;

        View view = (View) object;

        vp.removeView(view);
    }
}
