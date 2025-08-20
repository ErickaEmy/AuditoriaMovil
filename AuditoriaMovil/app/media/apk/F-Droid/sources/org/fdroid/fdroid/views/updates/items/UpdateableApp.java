package org.fdroid.fdroid.views.updates.items;

import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate;
import java.util.List;
import org.fdroid.fdroid.R;
import org.fdroid.fdroid.data.Apk;
import org.fdroid.fdroid.data.App;
/* loaded from: classes2.dex */
public class UpdateableApp extends AppUpdateData {
    public final Apk apk;
    public final App app;

    public UpdateableApp(AppCompatActivity appCompatActivity, App app, Apk apk) {
        super(appCompatActivity);
        this.app = app;
        this.apk = apk;
    }

    /* loaded from: classes2.dex */
    public static class Delegate extends AdapterDelegate {
        private final AppCompatActivity activity;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.hannesdorfmann.adapterdelegates4.AdapterDelegate
        public /* bridge */ /* synthetic */ void onBindViewHolder(Object obj, int i, RecyclerView.ViewHolder viewHolder, List list) {
            onBindViewHolder((List) obj, i, viewHolder, (List<Object>) list);
        }

        public Delegate(AppCompatActivity appCompatActivity) {
            this.activity = appCompatActivity;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.hannesdorfmann.adapterdelegates4.AdapterDelegate
        public boolean isForViewType(List<AppUpdateData> list, int i) {
            return list.get(i) instanceof UpdateableApp;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.hannesdorfmann.adapterdelegates4.AdapterDelegate
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
            AppCompatActivity appCompatActivity = this.activity;
            return new UpdateableAppListItemController(appCompatActivity, appCompatActivity.getLayoutInflater().inflate(R.layout.updateable_app_list_item, viewGroup, false));
        }

        protected void onBindViewHolder(List<AppUpdateData> list, int i, RecyclerView.ViewHolder viewHolder, List<Object> list2) {
            UpdateableApp updateableApp = (UpdateableApp) list.get(i);
            ((UpdateableAppListItemController) viewHolder).bindModel(updateableApp.app, updateableApp.apk, null);
        }
    }
}
