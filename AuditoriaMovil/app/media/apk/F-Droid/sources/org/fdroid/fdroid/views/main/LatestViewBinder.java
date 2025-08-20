package org.fdroid.fdroid.views.main;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.fdroid.database.AppOverviewItem;
import org.fdroid.database.FDroidDatabase;
import org.fdroid.database.Repository;
import org.fdroid.fdroid.FDroidApp;
import org.fdroid.fdroid.Preferences;
import org.fdroid.fdroid.R;
import org.fdroid.fdroid.Utils;
import org.fdroid.fdroid.data.DBHelper;
import org.fdroid.fdroid.panic.HidingManager;
import org.fdroid.fdroid.views.apps.AppListActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class LatestViewBinder implements Observer, Preferences.ChangeListener {
    private final AppCompatActivity activity;
    private final RecyclerView appList;
    private final FDroidDatabase db;
    private final TextView emptyState;
    private final LatestAdapter latestAdapter;
    private CircularProgressIndicator progressBar;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LatestViewBinder(final AppCompatActivity appCompatActivity, FrameLayout frameLayout) {
        this.activity = appCompatActivity;
        appCompatActivity.getLifecycle().addObserver(new DefaultLifecycleObserver() { // from class: org.fdroid.fdroid.views.main.LatestViewBinder.1
            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* bridge */ /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
                Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* bridge */ /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
                Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* bridge */ /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
                Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* bridge */ /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
                Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public void onCreate(LifecycleOwner lifecycleOwner) {
                Preferences.get().registerAppsRequiringAntiFeaturesChangeListener(LatestViewBinder.this);
                Preferences.get().registerShowIncompatibleListener(LatestViewBinder.this);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public void onDestroy(LifecycleOwner lifecycleOwner) {
                Preferences.get().unregisterAppsRequiringAntiFeaturesChangeListener(LatestViewBinder.this);
                Preferences.get().unregisterShowIncompatibleListener(LatestViewBinder.this);
            }
        });
        FDroidDatabase db = DBHelper.getDb(appCompatActivity);
        this.db = db;
        Transformations.distinctUntilChanged(db.getAppDao().getAppOverviewItems(200)).observe(appCompatActivity, this);
        View inflate = appCompatActivity.getLayoutInflater().inflate(R.layout.main_tab_latest, (ViewGroup) frameLayout, true);
        LatestAdapter latestAdapter = new LatestAdapter(appCompatActivity);
        this.latestAdapter = latestAdapter;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(appCompatActivity, 2);
        gridLayoutManager.setSpanSizeLookup(latestAdapter.getSpanSizeLookup());
        this.emptyState = (TextView) inflate.findViewById(R.id.empty_state);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.app_list);
        this.appList = recyclerView;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(latestAdapter);
        final SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) inflate.findViewById(R.id.swipe_to_refresh);
        Utils.applySwipeLayoutColors(swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: org.fdroid.fdroid.views.main.LatestViewBinder$$ExternalSyntheticLambda1
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                LatestViewBinder.lambda$new$1(SwipeRefreshLayout.this, appCompatActivity);
            }
        });
        FloatingActionButton floatingActionButton = (FloatingActionButton) inflate.findViewById(R.id.fab_search);
        floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: org.fdroid.fdroid.views.main.LatestViewBinder$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LatestViewBinder.lambda$new$2(AppCompatActivity.this, view);
            }
        });
        floatingActionButton.setOnLongClickListener(new View.OnLongClickListener() { // from class: org.fdroid.fdroid.views.main.LatestViewBinder$$ExternalSyntheticLambda3
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean lambda$new$3;
                lambda$new$3 = LatestViewBinder.lambda$new$3(AppCompatActivity.this, view);
                return lambda$new$3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$1(SwipeRefreshLayout swipeRefreshLayout, final AppCompatActivity appCompatActivity) {
        swipeRefreshLayout.setRefreshing(false);
        Utils.runOffUiThread(new Runnable() { // from class: org.fdroid.fdroid.views.main.LatestViewBinder$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                LatestViewBinder.lambda$new$0(AppCompatActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0(AppCompatActivity appCompatActivity) {
        FDroidApp.getRepoUpdateManager(appCompatActivity).updateRepos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$2(AppCompatActivity appCompatActivity, View view) {
        appCompatActivity.startActivity(new Intent(appCompatActivity, AppListActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$new$3(AppCompatActivity appCompatActivity, View view) {
        if (Preferences.get().hideOnLongPressSearch()) {
            HidingManager.showHideDialog(appCompatActivity);
            return true;
        }
        return false;
    }

    @Override // androidx.lifecycle.Observer
    public void onChanged(List<AppOverviewItem> list) {
        filterApps(list);
        this.latestAdapter.setApps(list);
        if (this.latestAdapter.getItemCount() == 0) {
            this.emptyState.setVisibility(0);
            this.appList.setVisibility(8);
            explainEmptyStateToUser();
            return;
        }
        this.emptyState.setVisibility(8);
        this.appList.setVisibility(0);
    }

    @Override // org.fdroid.fdroid.Preferences.ChangeListener
    public void onPreferenceChange() {
        final LiveData appOverviewItems = this.db.getAppDao().getAppOverviewItems(200);
        appOverviewItems.observe(this.activity, new Observer() { // from class: org.fdroid.fdroid.views.main.LatestViewBinder.2
            @Override // androidx.lifecycle.Observer
            public void onChanged(List<AppOverviewItem> list) {
                LatestViewBinder.this.onChanged(list);
                appOverviewItems.removeObserver(this);
            }
        });
    }

    private void filterApps(List<AppOverviewItem> list) {
        List<String> asList = Arrays.asList(this.activity.getResources().getStringArray(R.array.antifeaturesValues));
        Set<String> showAppsWithAntiFeatures = Preferences.get().showAppsWithAntiFeatures();
        boolean contains = showAppsWithAntiFeatures.contains(this.activity.getResources().getString(R.string.antiothers_key));
        boolean z = !Preferences.get().showIncompatibleVersions();
        Iterator<AppOverviewItem> it = list.iterator();
        while (it.hasNext()) {
            AppOverviewItem next = it.next();
            if (isFilteredByAntiFeature(next, asList, showAppsWithAntiFeatures, contains)) {
                it.remove();
            } else if (z && !next.isCompatible()) {
                it.remove();
            }
        }
    }

    private boolean isFilteredByAntiFeature(AppOverviewItem appOverviewItem, List<String> list, Set<String> set, boolean z) {
        for (String str : appOverviewItem.getAntiFeatureKeys()) {
            if (list.contains(str)) {
                if (!set.contains(str)) {
                    return true;
                }
            } else if (!z) {
                return true;
            }
        }
        return false;
    }

    private void explainEmptyStateToUser() {
        if (Preferences.get().isIndexNeverUpdated() && ((Boolean) FDroidApp.getRepoUpdateManager(this.activity).isUpdating().getValue()).booleanValue()) {
            if (this.progressBar != null) {
                return;
            }
            CircularProgressIndicator circularProgressIndicator = new CircularProgressIndicator(this.activity);
            this.progressBar = circularProgressIndicator;
            circularProgressIndicator.setId(R.id.progress_bar);
            ((LinearLayout) this.appList.getParent()).addView(this.progressBar);
            this.emptyState.setVisibility(8);
            this.appList.setVisibility(8);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.activity.getString(R.string.latest__empty_state__no_recent_apps));
        sb.append("\n\n");
        int i = 0;
        Long l = null;
        for (Repository repository : FDroidApp.getRepoManager(this.activity).getRepositories()) {
            if (repository.getEnabled()) {
                i++;
                if (l == null && repository.getLastUpdated() != null) {
                    l = repository.getLastUpdated();
                } else if (l != null && repository.getLastUpdated() != null && repository.getLastUpdated().longValue() > l.longValue()) {
                    l = repository.getLastUpdated();
                }
            }
        }
        if (i == 0) {
            sb.append(this.activity.getString(R.string.latest__empty_state__no_enabled_repos));
        } else if (l == null) {
            sb.append(this.activity.getString(R.string.latest__empty_state__never_updated));
        } else {
            sb.append(Utils.formatLastUpdated(this.activity.getResources(), l.longValue()));
        }
        this.emptyState.setText(sb.toString());
    }
}
