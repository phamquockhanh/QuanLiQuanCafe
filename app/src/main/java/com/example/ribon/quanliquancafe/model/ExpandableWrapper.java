package com.example.ribon.quanliquancafe.model;

import android.support.annotation.NonNull;

import com.bignerdranch.expandablerecyclerview.model.Parent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ribon on 13/03/2017.
 */

public class ExpandableWrapper<P extends Parent<C>, C> {
    private P mParent;
    private C mChild;
    private boolean mWrappedParent;
    private boolean mExpanded;

    private List<ExpandableWrapper<P, C>> mWrappedChildList;

    public ExpandableWrapper(@NonNull P parent) {
        mParent = parent;
        mWrappedParent = true;
        mExpanded = false;

        mWrappedChildList = generateChildItemList(parent);
    }
    public ExpandableWrapper(@NonNull C child) {
        mChild = child;
        mWrappedParent = false;
        mExpanded = false;
    }
    public P getParent() {
        return mParent;
    }

    public void setParent(@NonNull P parent) {
        mParent = parent;
        mWrappedChildList = generateChildItemList(parent);
    }

    public C getChild() {
        return mChild;
    }

    public boolean isExpanded() {
        return mExpanded;
    }

    public void setExpanded(boolean expanded) {
        mExpanded = expanded;
    }

    public boolean isParent() {
        return mWrappedParent;
    }
    public boolean isParentInitiallyExpanded() {
        if (!mWrappedParent) {
            throw new IllegalStateException("Parent not wrapped");
        }

        return mParent.isInitiallyExpanded();
    }
    public List<ExpandableWrapper<P, C>> getWrappedChildList() {
        if (!mWrappedParent) {
            throw new IllegalStateException("Parent not wrapped");
        }

        return mWrappedChildList;
    }
    private List<ExpandableWrapper<P, C>> generateChildItemList(P parentListItem) {
        List<ExpandableWrapper<P, C>> childItemList = new ArrayList<>();

        for (C child : parentListItem.getChildList()) {
            childItemList.add(new ExpandableWrapper<P, C>(child));
        }

        return childItemList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final ExpandableWrapper<?, ?> that = (ExpandableWrapper<?, ?>) o;

        if (mParent != null ? !mParent.equals(that.mParent) : that.mParent != null)
            return false;
        return mChild != null ? mChild.equals(that.mChild) : that.mChild == null;

    }

    @Override
    public int hashCode() {
        int result = mParent != null ? mParent.hashCode() : 0;
        result = 31 * result + (mChild != null ? mChild.hashCode() : 0);
        return result;
    }
}
