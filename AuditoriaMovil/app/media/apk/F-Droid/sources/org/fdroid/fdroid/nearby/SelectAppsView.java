package org.fdroid.fdroid.nearby;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.fdroid.fdroid.R;
import org.fdroid.fdroid.nearby.SelectAppsView;
/* loaded from: classes2.dex */
public class SelectAppsView extends SwapView {
    private AppListAdapter adapter;
    private ListView listView;

    public SelectAppsView(Context context) {
        super(context);
    }

    public SelectAppsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SelectAppsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SelectAppsView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.listView = (ListView) findViewById(R.id.list);
        AppListAdapter appListAdapter = new AppListAdapter(this.listView, getContext().getPackageManager().getInstalledPackages(0));
        this.adapter = appListAdapter;
        this.listView.setAdapter((ListAdapter) appListAdapter);
        this.listView.setChoiceMode(2);
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: org.fdroid.fdroid.nearby.SelectAppsView$$ExternalSyntheticLambda0
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                SelectAppsView.this.lambda$onFinishInflate$0(adapterView, view, i, j);
            }
        });
        afterAppsLoaded();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onFinishInflate$0(AdapterView adapterView, View view, int i, long j) {
        toggleAppSelected(i);
    }

    @Override // org.fdroid.fdroid.nearby.SwapView
    public void setCurrentFilterString(String str) {
        super.setCurrentFilterString(str);
        this.adapter.setSearchTerm(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleAppSelected(int i) {
        String str = this.adapter.getItem(i).packageName;
        if (getActivity().getSwapService().hasSelectedPackage(str)) {
            getActivity().getSwapService().deselectPackage(str);
        } else {
            getActivity().getSwapService().selectPackage(str);
        }
        LocalRepoService.create(getContext(), getActivity().getSwapService().getAppsToSwap());
    }

    public void afterAppsLoaded() {
        for (int i = 0; i < this.listView.getCount(); i++) {
            InstalledApp installedApp = (InstalledApp) this.listView.getItemAtPosition(i);
            getActivity().getSwapService().ensureFDroidSelected();
            for (String str : getActivity().getSwapService().getAppsToSwap()) {
                if (TextUtils.equals(installedApp.packageName, str)) {
                    this.listView.setItemChecked(i, true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class AppListAdapter extends BaseAdapter {
        private final List<InstalledApp> allPackages;
        private final Context context;
        private Drawable defaultAppIcon;
        private final List<InstalledApp> filteredPackages = new ArrayList();
        private LayoutInflater inflater;
        private final ListView listView;

        AppListAdapter(ListView listView, List<PackageInfo> list) {
            this.context = SelectAppsView.this.getContext();
            this.listView = listView;
            this.allPackages = new ArrayList(list.size());
            for (PackageInfo packageInfo : list) {
                this.allPackages.add(new InstalledApp(this.context, packageInfo));
            }
            this.filteredPackages.addAll(this.allPackages);
        }

        void setSearchTerm(String str) {
            this.filteredPackages.clear();
            if (TextUtils.isEmpty(str)) {
                this.filteredPackages.addAll(this.allPackages);
            } else {
                Objects.requireNonNull(str);
                String lowerCase = str.toLowerCase(Locale.US);
                for (InstalledApp installedApp : this.allPackages) {
                    if (installedApp.name.toLowerCase(Locale.US).contains(lowerCase)) {
                        this.filteredPackages.add(installedApp);
                    }
                }
            }
            notifyDataSetChanged();
        }

        private LayoutInflater getInflater(Context context) {
            if (this.inflater == null) {
                this.inflater = (LayoutInflater) ContextCompat.getSystemService(new ContextThemeWrapper(context, R.style.SwapTheme_AppList_ListItem), LayoutInflater.class);
            }
            return this.inflater;
        }

        private Drawable getDefaultAppIcon(Context context) {
            if (this.defaultAppIcon == null) {
                this.defaultAppIcon = ContextCompat.getDrawable(context, 17301651);
            }
            return this.defaultAppIcon;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = getInflater(this.context).inflate(R.layout.select_local_apps_list_item, viewGroup, false);
            }
            bindView(view, this.context, i);
            return view;
        }

        public void bindView(View view, Context context, final int i) {
            Drawable defaultAppIcon;
            InstalledApp item = getItem(i);
            TextView textView = (TextView) view.findViewById(R.id.package_name);
            TextView textView2 = (TextView) view.findViewById(R.id.application_label);
            ImageView imageView = (ImageView) view.findViewById(16908294);
            try {
                defaultAppIcon = context.getPackageManager().getApplicationIcon(item.packageName);
            } catch (PackageManager.NameNotFoundException unused) {
                defaultAppIcon = getDefaultAppIcon(context);
            }
            textView.setText(item.packageName);
            textView2.setText(item.name);
            imageView.setImageDrawable(defaultAppIcon);
            View findViewById = view.findViewById(R.id.checkbox);
            if (findViewById != null) {
                CheckBox checkBox = (CheckBox) findViewById;
                checkBox.setOnCheckedChangeListener(null);
                checkBox.setChecked(this.listView.isItemChecked(i));
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: org.fdroid.fdroid.nearby.SelectAppsView$AppListAdapter$$ExternalSyntheticLambda0
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        SelectAppsView.AppListAdapter.this.lambda$bindView$0(i, compoundButton, z);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$bindView$0(int i, CompoundButton compoundButton, boolean z) {
            this.listView.setItemChecked(i, z);
            SelectAppsView.this.toggleAppSelected(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.filteredPackages.size();
        }

        @Override // android.widget.Adapter
        public InstalledApp getItem(int i) {
            return this.filteredPackages.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return getItem(i).hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class InstalledApp {
        final String name;
        final String packageName;

        InstalledApp(String str, String str2) {
            this.packageName = str;
            this.name = str2;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        InstalledApp(android.content.Context r1, android.content.pm.PackageInfo r2) {
            /*
                r0 = this;
                java.lang.String r2 = r2.packageName
                java.lang.String r1 = org.fdroid.fdroid.Utils.getApplicationLabel(r1, r2)
                r0.<init>(r2, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.fdroid.fdroid.nearby.SelectAppsView.InstalledApp.<init>(android.content.Context, android.content.pm.PackageInfo):void");
        }
    }
}
