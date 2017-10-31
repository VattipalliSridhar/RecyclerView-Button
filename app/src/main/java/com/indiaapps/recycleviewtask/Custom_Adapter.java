package com.indiaapps.recycleviewtask;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by 2136 on 10/31/2017.
 */

public class Custom_Adapter extends RecyclerView.Adapter<Custom_Adapter.ViewHolder>
{
    String[] items;
    private Context mContext;
    private int width, height;

    public Custom_Adapter(MainActivity activity, String[] fruitlist)
    {
        mContext = activity;
        DisplayMetrics metrics = activity.getResources().getDisplayMetrics();
        width = metrics.widthPixels;
        height = metrics.heightPixels;

        items=fruitlist;

    }

    @Override
    public Custom_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(mContext).inflate(R.layout.items, parent, false);
        Custom_Adapter.ViewHolder vh = new Custom_Adapter.ViewHolder(v);
        v.getLayoutParams().height =(height*20) / 100;

        // Return the ViewHolder
        return vh;
    }

    @Override
    public void onBindViewHolder(Custom_Adapter.ViewHolder holder, final int position)
    {
            holder.item_textView.setText(""+items[position]);

        holder.item_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.e("msg"," "+position);
                Toast.makeText(mContext,"item :"+items[position]+" possition: "+position,Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return items.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView item_textView;
        Button item_button;
        RelativeLayout relativeLayout;


        public ViewHolder(View itemView)
        {
            super(itemView);

            item_textView=(TextView)itemView.findViewById(R.id.item_txt);
            item_button=(Button)itemView.findViewById(R.id.item_button);
            item_button.setOnClickListener(this);

            relativeLayout=(RelativeLayout)itemView.findViewById(R.id.item_layout) ;

            relativeLayout.getLayoutParams().height =(height*20) / 100;
        }

        @Override
        public void onClick(View v)
        {


        }
    }

}
