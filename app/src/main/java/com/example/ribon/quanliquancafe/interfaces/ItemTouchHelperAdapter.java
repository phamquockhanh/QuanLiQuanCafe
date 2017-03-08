package com.example.ribon.quanliquancafe.interfaces;

/**
 * Created by Ribon on 08/03/2017.
 */

public interface ItemTouchHelperAdapter {

    boolean onItemMove(int fromPosition, int toPosition);

    void onItemDismiss(int position);
}
