package com.example.ribon.quanliquancafe.viewholder;

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.example.ribon.quanliquancafe.R;

/**
 * Created by Ribon on 12/03/2017.
 */

public class TitleChildViewHolder extends ChildViewHolder {
    public TextView option1,option2,option3;
    public TitleChildViewHolder(View itemView) {
        super(itemView);
        option1 = (TextView)itemView.findViewById(R.id.option1);
        option2 = (TextView)itemView.findViewById(R.id.option2);
        option3 = (TextView)itemView.findViewById(R.id.option3);
    }
}
