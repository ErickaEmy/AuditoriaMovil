package com.hannesdorfmann.adapterdelegates4;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
/* loaded from: classes.dex */
public abstract class AdapterDelegate {
    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean isForViewType(Object obj, int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void onBindViewHolder(Object obj, int i, RecyclerView.ViewHolder viewHolder, List list);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup);

    protected boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        return false;
    }

    protected void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
    }

    protected void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
    }

    protected void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
    }
}
