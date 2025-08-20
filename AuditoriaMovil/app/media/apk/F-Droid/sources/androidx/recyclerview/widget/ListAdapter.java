package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
/* loaded from: classes.dex */
public abstract class ListAdapter extends RecyclerView.Adapter {
    final AsyncListDiffer mDiffer;
    private final AsyncListDiffer.ListListener mListener;

    public void onCurrentListChanged(List<Object> list, List<Object> list2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ListAdapter(DiffUtil.ItemCallback itemCallback) {
        AsyncListDiffer.ListListener listListener = new AsyncListDiffer.ListListener() { // from class: androidx.recyclerview.widget.ListAdapter.1
            @Override // androidx.recyclerview.widget.AsyncListDiffer.ListListener
            public void onCurrentListChanged(List list, List list2) {
                ListAdapter.this.onCurrentListChanged(list, list2);
            }
        };
        this.mListener = listListener;
        AsyncListDiffer asyncListDiffer = new AsyncListDiffer(new AdapterListUpdateCallback(this), new AsyncDifferConfig.Builder(itemCallback).build());
        this.mDiffer = asyncListDiffer;
        asyncListDiffer.addListListener(listListener);
    }

    public void submitList(List<Object> list) {
        this.mDiffer.submitList(list);
    }

    public void submitList(List<Object> list, Runnable runnable) {
        this.mDiffer.submitList(list, runnable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object getItem(int i) {
        return this.mDiffer.getCurrentList().get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mDiffer.getCurrentList().size();
    }

    public List<Object> getCurrentList() {
        return this.mDiffer.getCurrentList();
    }
}
