package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.f;
import androidx.lifecycle.t;
import androidx.lifecycle.v;
import androidx.lifecycle.wz;
import androidx.savedstate.SavedStateRegistry;
import fb.y;
import gv.a;
import java.util.concurrent.atomic.AtomicInteger;
import rz.fb;
import y5.b;
import y5.co;
import y5.k5;
import y5.vl;
import y5.yt;
/* loaded from: classes.dex */
public class ComponentActivity extends fb implements co, k5, androidx.lifecycle.gv, g.y, a, a.zn {
    private final ActivityResultRegistry mActivityResultRegistry;
    private int mContentLayoutId;
    final v.y mContextAwareHelper;
    private wz.n3 mDefaultFactory;
    private final androidx.lifecycle.fb mLifecycleRegistry;
    private final AtomicInteger mNextLocalRequestCode;
    private final OnBackPressedDispatcher mOnBackPressedDispatcher;
    final androidx.savedstate.y mSavedStateRegistryController;
    private b mViewModelStore;

    /* loaded from: classes.dex */
    public static final class gv {

        /* renamed from: n3  reason: collision with root package name */
        public b f585n3;
        public Object y;
    }

    /* loaded from: classes.dex */
    public class n3 extends ActivityResultRegistry {

        /* renamed from: androidx.activity.ComponentActivity$n3$n3  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0010n3 implements Runnable {

            /* renamed from: v  reason: collision with root package name */
            public final /* synthetic */ IntentSender.SendIntentException f588v;
            public final /* synthetic */ int y;

            public RunnableC0010n3(int i, IntentSender.SendIntentException sendIntentException) {
                this.y = i;
                this.f588v = sendIntentException;
            }

            @Override // java.lang.Runnable
            public void run() {
                n3.this.n3(this.y, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", this.f588v));
            }
        }

        /* loaded from: classes.dex */
        public class y implements Runnable {

            /* renamed from: v  reason: collision with root package name */
            public final /* synthetic */ y.C0100y f590v;
            public final /* synthetic */ int y;

            public y(int i, y.C0100y c0100y) {
                this.y = i;
                this.f590v = c0100y;
            }

            @Override // java.lang.Runnable
            public void run() {
                n3.this.zn(this.y, this.f590v.y());
            }
        }

        public n3() {
        }

        @Override // androidx.activity.result.ActivityResultRegistry
        public <I, O> void a(int i, @NonNull fb.y<I, O> yVar, I i5, @Nullable rz.zn znVar) {
            Bundle bundle;
            ComponentActivity componentActivity = ComponentActivity.this;
            y.C0100y<O> synchronousResult = yVar.getSynchronousResult(componentActivity, i5);
            if (synchronousResult != null) {
                new Handler(Looper.getMainLooper()).post(new y(i, synchronousResult));
                return;
            }
            Intent createIntent = yVar.createIntent(componentActivity, i5);
            if (createIntent.getExtras() != null && createIntent.getExtras().getClassLoader() == null) {
                createIntent.setExtrasClassLoader(componentActivity.getClassLoader());
            }
            if (createIntent.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                Bundle bundleExtra = createIntent.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                createIntent.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                bundle = bundleExtra;
            } else {
                bundle = null;
            }
            if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(createIntent.getAction())) {
                String[] stringArrayExtra = createIntent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                if (stringArrayExtra == null) {
                    stringArrayExtra = new String[0];
                }
                rz.n3.i4(componentActivity, stringArrayExtra, i);
            } else if ("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(createIntent.getAction())) {
                IntentSenderRequest intentSenderRequest = (IntentSenderRequest) createIntent.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
                try {
                    rz.n3.rz(componentActivity, intentSenderRequest.gv(), i, intentSenderRequest.y(), intentSenderRequest.n3(), intentSenderRequest.zn(), 0, bundle);
                } catch (IntentSender.SendIntentException e2) {
                    new Handler(Looper.getMainLooper()).post(new RunnableC0010n3(i, e2));
                }
            } else {
                rz.n3.fh(componentActivity, createIntent, i, bundle);
            }
        }
    }

    /* loaded from: classes.dex */
    public class y implements Runnable {
        public y() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ComponentActivity.super.onBackPressed();
            } catch (IllegalStateException e2) {
                if (TextUtils.equals(e2.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    return;
                }
                throw e2;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class zn {
        public static void y(View view) {
            view.cancelPendingInputEvents();
        }
    }

    public ComponentActivity() {
        this.mContextAwareHelper = new v.y();
        this.mLifecycleRegistry = new androidx.lifecycle.fb(this);
        this.mSavedStateRegistryController = androidx.savedstate.y.y(this);
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new y());
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new n3();
        if (getLifecycle() != null) {
            int i = Build.VERSION.SDK_INT;
            getLifecycle().y(new androidx.lifecycle.a() { // from class: androidx.activity.ComponentActivity.3
                @Override // androidx.lifecycle.a
                public void onStateChanged(@NonNull co coVar, @NonNull v.n3 n3Var) {
                    View view;
                    if (n3Var == v.n3.ON_STOP) {
                        Window window = ComponentActivity.this.getWindow();
                        if (window != null) {
                            view = window.peekDecorView();
                        } else {
                            view = null;
                        }
                        if (view != null) {
                            zn.y(view);
                        }
                    }
                }
            });
            getLifecycle().y(new androidx.lifecycle.a() { // from class: androidx.activity.ComponentActivity.4
                @Override // androidx.lifecycle.a
                public void onStateChanged(@NonNull co coVar, @NonNull v.n3 n3Var) {
                    if (n3Var == v.n3.ON_DESTROY) {
                        ComponentActivity.this.mContextAwareHelper.n3();
                        if (!ComponentActivity.this.isChangingConfigurations()) {
                            ComponentActivity.this.getViewModelStore().y();
                        }
                    }
                }
            });
            getLifecycle().y(new androidx.lifecycle.a() { // from class: androidx.activity.ComponentActivity.5
                @Override // androidx.lifecycle.a
                public void onStateChanged(@NonNull co coVar, @NonNull v.n3 n3Var) {
                    ComponentActivity.this.ensureViewModelStore();
                    ComponentActivity.this.getLifecycle().zn(this);
                }
            });
            if (i <= 23) {
                getLifecycle().y(new ImmLeaksCleaner(this));
            }
            getSavedStateRegistry().gv("android:support:activity-result", new SavedStateRegistry.n3() { // from class: gv.n3
                @Override // androidx.savedstate.SavedStateRegistry.n3
                public final Bundle saveState() {
                    Bundle lambda$new$0;
                    lambda$new$0 = ComponentActivity.this.lambda$new$0();
                    return lambda$new$0;
                }
            });
            addOnContextAvailableListener(new v.n3() { // from class: gv.zn
                @Override // v.n3
                public final void onContextAvailable(Context context) {
                    ComponentActivity.this.lambda$new$1(context);
                }
            });
            return;
        }
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    private void initViewTreeOwners() {
        yt.n3(getWindow().getDecorView(), this);
        vl.y(getWindow().getDecorView(), this);
        g.n3.y(getWindow().getDecorView(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bundle lambda$new$0() {
        Bundle bundle = new Bundle();
        this.mActivityResultRegistry.s(bundle);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(Context context) {
        Bundle y2 = getSavedStateRegistry().y("android:support:activity-result");
        if (y2 != null) {
            this.mActivityResultRegistry.fb(y2);
        }
    }

    @Override // android.app.Activity
    public void addContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        super.addContentView(view, layoutParams);
    }

    public final void addOnContextAvailableListener(@NonNull v.n3 n3Var) {
        this.mContextAwareHelper.y(n3Var);
    }

    public void ensureViewModelStore() {
        if (this.mViewModelStore == null) {
            gv gvVar = (gv) getLastNonConfigurationInstance();
            if (gvVar != null) {
                this.mViewModelStore = gvVar.f585n3;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new b();
            }
        }
    }

    @Override // a.zn
    @NonNull
    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    @Override // androidx.lifecycle.gv
    @NonNull
    public wz.n3 getDefaultViewModelProviderFactory() {
        Bundle bundle;
        if (getApplication() != null) {
            if (this.mDefaultFactory == null) {
                Application application = getApplication();
                if (getIntent() != null) {
                    bundle = getIntent().getExtras();
                } else {
                    bundle = null;
                }
                this.mDefaultFactory = new t(application, this, bundle);
            }
            return this.mDefaultFactory;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    @Nullable
    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        gv gvVar = (gv) getLastNonConfigurationInstance();
        if (gvVar != null) {
            return gvVar.y;
        }
        return null;
    }

    @Override // rz.fb, y5.co
    @NonNull
    public v getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // gv.a
    @NonNull
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }

    @Override // g.y
    @NonNull
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.n3();
    }

    @Override // y5.k5
    @NonNull
    public b getViewModelStore() {
        if (getApplication() != null) {
            ensureViewModelStore();
            return this.mViewModelStore;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    @Override // android.app.Activity
    @Deprecated
    public void onActivityResult(int i, int i5, @Nullable Intent intent) {
        if (!this.mActivityResultRegistry.n3(i, i5, intent)) {
            super.onActivityResult(i, i5, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.mOnBackPressedDispatcher.gv();
    }

    @Override // rz.fb, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        this.mSavedStateRegistryController.zn(bundle);
        this.mContextAwareHelper.zn(this);
        super.onCreate(bundle);
        f.fb(this);
        int i = this.mContentLayoutId;
        if (i != 0) {
            setContentView(i);
        }
    }

    @Override // android.app.Activity
    @Deprecated
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (!this.mActivityResultRegistry.n3(i, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr)) && Build.VERSION.SDK_INT >= 23) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Nullable
    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // android.app.Activity
    @Nullable
    public final Object onRetainNonConfigurationInstance() {
        gv gvVar;
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        b bVar = this.mViewModelStore;
        if (bVar == null && (gvVar = (gv) getLastNonConfigurationInstance()) != null) {
            bVar = gvVar.f585n3;
        }
        if (bVar == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        gv gvVar2 = new gv();
        gvVar2.y = onRetainCustomNonConfigurationInstance;
        gvVar2.f585n3 = bVar;
        return gvVar2;
    }

    @Override // rz.fb, android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        v lifecycle = getLifecycle();
        if (lifecycle instanceof androidx.lifecycle.fb) {
            ((androidx.lifecycle.fb) lifecycle).xc(v.zn.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.gv(bundle);
    }

    @Nullable
    public Context peekAvailableContext() {
        return this.mContextAwareHelper.gv();
    }

    @NonNull
    public final <I, O> a.n3<I> registerForActivityResult(@NonNull fb.y<I, O> yVar, @NonNull ActivityResultRegistry activityResultRegistry, @NonNull a.y<O> yVar2) {
        return activityResultRegistry.i9("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, yVar, yVar2);
    }

    public final void removeOnContextAvailableListener(@NonNull v.n3 n3Var) {
        this.mContextAwareHelper.v(n3Var);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (pq.y.gv()) {
                pq.y.y("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            pq.y.n3();
        } catch (Throwable th) {
            pq.y.n3();
            throw th;
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        initViewTreeOwners();
        super.setContentView(i);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        super.startActivityForResult(intent, i);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, @Nullable Intent intent, int i5, int i6, int i8) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i, intent, i5, i6, i8);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i, @Nullable Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, @Nullable Intent intent, int i5, int i6, int i8, @Nullable Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i, intent, i5, i6, i8, bundle);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        initViewTreeOwners();
        super.setContentView(view);
    }

    @NonNull
    public final <I, O> a.n3<I> registerForActivityResult(@NonNull fb.y<I, O> yVar, @NonNull a.y<O> yVar2) {
        return registerForActivityResult(yVar, this.mActivityResultRegistry, yVar2);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        super.setContentView(view, layoutParams);
    }

    public ComponentActivity(int i) {
        this();
        this.mContentLayoutId = i;
    }
}
