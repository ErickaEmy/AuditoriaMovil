package org.fdroid.fdroid.views.categories;

import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collections;
import java.util.List;
import org.fdroid.database.AppOverviewItem;
import org.fdroid.fdroid.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class AppPreviewAdapter extends RecyclerView.Adapter {
    private final AppCompatActivity activity;
    private List<AppOverviewItem> items = Collections.emptyList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppPreviewAdapter(AppCompatActivity appCompatActivity) {
        this.activity = appCompatActivity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public AppCardController onCreateViewHolder(ViewGroup viewGroup, int i) {
        AppCompatActivity appCompatActivity = this.activity;
        return new AppCardController(appCompatActivity, appCompatActivity.getLayoutInflater().inflate(R.layout.app_card_normal, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(AppCardController appCardController, int i) {
        appCardController.bindApp(this.items.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAppCursor(List<AppOverviewItem> list) {
        if (this.items == list) {
            return;
        }
        this.items = list;
        notifyDataSetChanged();
    }
}
