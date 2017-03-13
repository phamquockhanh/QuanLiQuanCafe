package com.example.ribon.quanliquancafe.viewholder;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ParentViewHolder;
import com.example.ribon.quanliquancafe.R;
import com.example.ribon.quanliquancafe.model.Table;

/**
 * Created by Ribon on 13/03/2017.
 */

public class TableViewHolder extends ParentViewHolder {
    public TextView mTableTextView;
    public ImageButton _imageButton;
    public TableViewHolder(@NonNull View itemView) {
        super(itemView);
        mTableTextView = (TextView)itemView.findViewById(R.id.tv_table);
        _imageButton = (ImageButton) itemView.findViewById(R.id.expandArrow);
    }
    public void bind(Table table) {
        mTableTextView.setText(table.getTableName());
    }
}
