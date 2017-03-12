package com.example.ribon.quanliquancafe.viewholder;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;
import com.example.ribon.quanliquancafe.R;
import com.example.ribon.quanliquancafe.interfaces.ItemTouchHelperViewHolder;

/**
 * Created by Ribon on 12/03/2017.
 */

public class TitleParentViewHolder extends ParentViewHolder implements
        ItemTouchHelperViewHolder {
    public TextView _textView;
    public ImageButton _imageButton;
    public TitleParentViewHolder(View itemView) {
        super(itemView);
        _textView = (TextView)itemView.findViewById(R.id.tv_table);
        _imageButton = (ImageButton) itemView.findViewById(R.id.expandArrow);
    }

    @Override
    public void onItemSelected() {
        itemView.setBackgroundColor(Color.LTGRAY);
    }

    @Override
    public void onItemClear() {
        itemView.setBackgroundColor(0);
    }
}
