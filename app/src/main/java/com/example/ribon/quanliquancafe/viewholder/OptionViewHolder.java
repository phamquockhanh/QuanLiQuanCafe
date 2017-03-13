package com.example.ribon.quanliquancafe.viewholder;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ChildViewHolder;
import com.example.ribon.quanliquancafe.R;
import com.example.ribon.quanliquancafe.model.Option;

/**
 * Created by Ribon on 13/03/2017.
 */

public class OptionViewHolder extends ChildViewHolder {
    public TextView option1,option2,option3;
    public OptionViewHolder(@NonNull View itemView) {
        super(itemView);
        option1 = (TextView)itemView.findViewById(R.id.option1);
       /* option2 = (TextView)itemView.findViewById(R.id.option2);
        option3 = (TextView)itemView.findViewById(R.id.option3);*/
    }
    public void bind(Option option) {
        option1.setText(option.getOption1());
        /*option2.setText(option.getOption2());
        option3.setText(option.getOption3());*/
    }
}
