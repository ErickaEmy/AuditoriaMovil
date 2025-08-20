package androidx.appcompat.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.savedstate.SavedStateRegistry;
import rz.s;
import rz.wz;
import s.gv;
import s.zn;
import t.n3;
import wz.j;
import y5.vl;
import y5.yt;
/* loaded from: classes.dex */
public class AppCompatActivity extends FragmentActivity implements zn, wz.y {
    private gv mDelegate;
    private Resources mResources;

    /* loaded from: classes.dex */
    public class n3 implements v.n3 {
        public n3() {
        }

        @Override // v.n3
        public void onContextAvailable(@NonNull Context context) {
            gv delegate = AppCompatActivity.this.getDelegate();
            delegate.w();
            delegate.co(AppCompatActivity.this.getSavedStateRegistry().y("androidx:appcompat"));
        }
    }

    /* loaded from: classes.dex */
    public class y implements SavedStateRegistry.n3 {
        public y() {
        }

        @Override // androidx.savedstate.SavedStateRegistry.n3
        @NonNull
        public Bundle saveState() {
            Bundle bundle = new Bundle();
            AppCompatActivity.this.getDelegate().i4(bundle);
            return bundle;
        }
    }

    public AppCompatActivity() {
        initDelegate();
    }

    private void initDelegate() {
        getSavedStateRegistry().gv("androidx:appcompat", new y());
        addOnContextAvailableListener(new n3());
    }

    private void initViewTreeOwners() {
        yt.n3(getWindow().getDecorView(), this);
        vl.y(getWindow().getDecorView(), this);
        g.n3.y(getWindow().getDecorView(), this);
    }

    private boolean performMenuItemShortcut(KeyEvent keyEvent) {
        Window window;
        if (Build.VERSION.SDK_INT < 26 && !keyEvent.isCtrlPressed() && !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) && keyEvent.getRepeatCount() == 0 && !KeyEvent.isModifierKey(keyEvent.getKeyCode()) && (window = getWindow()) != null && window.getDecorView() != null && window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) {
            return true;
        }
        return false;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        getDelegate().gv(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(getDelegate().a(context));
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        s.y supportActionBar = getSupportActionBar();
        if (getWindow().hasFeature(0)) {
            if (supportActionBar == null || !supportActionBar.a()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // rz.fb, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        s.y supportActionBar = getSupportActionBar();
        if (keyCode == 82 && supportActionBar != null && supportActionBar.xc(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i) {
        return (T) getDelegate().i9(i);
    }

    @NonNull
    public gv getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = gv.fb(this, this);
        }
        return this.mDelegate;
    }

    @Nullable
    public s.n3 getDrawerToggleDelegate() {
        return getDelegate().t();
    }

    @Override // android.app.Activity
    @NonNull
    public MenuInflater getMenuInflater() {
        return getDelegate().wz();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.mResources == null && j.n3()) {
            this.mResources = new j(this, super.getResources());
        }
        Resources resources = this.mResources;
        if (resources == null) {
            return super.getResources();
        }
        return resources;
    }

    @Nullable
    public s.y getSupportActionBar() {
        return getDelegate().xc();
    }

    @Override // rz.wz.y
    @Nullable
    public Intent getSupportParentActivityIntent() {
        return s.y(this);
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        getDelegate().p();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
        getDelegate().mt(configuration);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        onSupportContentChanged();
    }

    public void onCreateSupportNavigateUpTaskStack(@NonNull wz wzVar) {
        wzVar.zn(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        getDelegate().z();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (performMenuItemShortcut(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, @NonNull MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        s.y supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() == 16908332 && supportActionBar != null && (supportActionBar.c5() & 4) != 0) {
            return onSupportNavigateUp();
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onNightModeChanged(int i) {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, @NonNull Menu menu) {
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public void onPostCreate(@Nullable Bundle bundle) {
        super.onPostCreate(bundle);
        getDelegate().r(bundle);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        getDelegate().x4();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        getDelegate().f3();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        getDelegate().n();
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public boolean onSupportNavigateUp() {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent != null) {
            if (supportShouldUpRecreateTask(supportParentActivityIntent)) {
                wz v2 = wz.v(this);
                onCreateSupportNavigateUpTaskStack(v2);
                onPrepareSupportNavigateUpTaskStack(v2);
                v2.fb();
                try {
                    rz.n3.mt(this);
                    return true;
                } catch (IllegalStateException unused) {
                    finish();
                    return true;
                }
            }
            supportNavigateUpTo(supportParentActivityIntent);
            return true;
        }
        return false;
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        getDelegate().ej(charSequence);
    }

    @Override // s.zn
    @Nullable
    public t.n3 onWindowStartingSupportActionMode(@NonNull n3.y yVar) {
        return null;
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        s.y supportActionBar = getSupportActionBar();
        if (getWindow().hasFeature(0)) {
            if (supportActionBar == null || !supportActionBar.w()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i) {
        initViewTreeOwners();
        getDelegate().rz(i);
    }

    public void setSupportActionBar(@Nullable Toolbar toolbar) {
        getDelegate().d(toolbar);
    }

    @Deprecated
    public void setSupportProgress(int i) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean z2) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean z2) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean z2) {
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        super.setTheme(i);
        getDelegate().z6(i);
    }

    @Nullable
    public t.n3 startSupportActionMode(@NonNull n3.y yVar) {
        return getDelegate().ud(yVar);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void supportInvalidateOptionsMenu() {
        getDelegate().p();
    }

    public void supportNavigateUpTo(@NonNull Intent intent) {
        s.v(this, intent);
    }

    public boolean supportRequestWindowFeature(int i) {
        return getDelegate().fh(i);
    }

    public boolean supportShouldUpRecreateTask(@NonNull Intent intent) {
        return s.a(this, intent);
    }

    public AppCompatActivity(int i) {
        super(i);
        initDelegate();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        initViewTreeOwners();
        getDelegate().mg(view);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        getDelegate().ta(view, layoutParams);
    }

    public void onPrepareSupportNavigateUpTaskStack(@NonNull wz wzVar) {
    }

    @Override // s.zn
    public void onSupportActionModeFinished(@NonNull t.n3 n3Var) {
    }

    @Override // s.zn
    public void onSupportActionModeStarted(@NonNull t.n3 n3Var) {
    }
}
