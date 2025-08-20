package com.bumptech.glide.integration.compose;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.ColorPainter;
import androidx.compose.ui.graphics.painter.Painter;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.integration.ktx.ResolvableGlideSize;
import com.bumptech.glide.integration.ktx.Status;
import com.google.accompanist.drawablepainter.DrawablePainter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;
/* compiled from: GlidePainter.kt */
/* loaded from: classes.dex */
public final class GlidePainter extends Painter implements RememberObserver {
    private final MutableState alpha$delegate;
    private final MutableState colorFilter$delegate;
    private final MutableState currentDrawable;
    private final MutableState delegate$delegate;
    private final RequestBuilder requestBuilder;
    private final CoroutineScope scope;
    private final ResolvableGlideSize size;
    private final MutableState status$delegate;

    public final MutableState getCurrentDrawable$compose_release() {
        return this.currentDrawable;
    }

    public GlidePainter(RequestBuilder requestBuilder, ResolvableGlideSize size, CoroutineScope scope) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        MutableState mutableStateOf$default5;
        Intrinsics.checkNotNullParameter(requestBuilder, "requestBuilder");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.requestBuilder = requestBuilder;
        this.size = size;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Status.CLEARED, null, 2, null);
        this.status$delegate = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.currentDrawable = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(1.0f), null, 2, null);
        this.alpha$delegate = mutableStateOf$default3;
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.colorFilter$delegate = mutableStateOf$default4;
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.delegate$delegate = mutableStateOf$default5;
        this.scope = CoroutineScopeKt.plus(CoroutineScopeKt.plus(scope, SupervisorKt.SupervisorJob(JobKt.getJob(scope.getCoroutineContext()))), Dispatchers.getMain().getImmediate());
    }

    private final void setAlpha(float f) {
        this.alpha$delegate.setValue(Float.valueOf(f));
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    /* renamed from: getIntrinsicSize-NH-jbRc */
    public long mo1072getIntrinsicSizeNHjbRc() {
        Painter delegate = getDelegate();
        return delegate != null ? delegate.mo1072getIntrinsicSizeNHjbRc() : Size.Companion.m750getUnspecifiedNHjbRc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.graphics.painter.Painter
    public void onDraw(DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        Painter delegate = getDelegate();
        if (delegate != null) {
            delegate.m1073drawx_KDEd0(drawScope, drawScope.mo1040getSizeNHjbRc(), getAlpha(), getColorFilter());
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
        Painter delegate = getDelegate();
        RememberObserver rememberObserver = delegate instanceof RememberObserver ? (RememberObserver) delegate : null;
        if (rememberObserver != null) {
            rememberObserver.onAbandoned();
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        Painter delegate = getDelegate();
        RememberObserver rememberObserver = delegate instanceof RememberObserver ? (RememberObserver) delegate : null;
        if (rememberObserver != null) {
            rememberObserver.onForgotten();
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
        Painter delegate = getDelegate();
        RememberObserver rememberObserver = delegate instanceof RememberObserver ? (RememberObserver) delegate : null;
        if (rememberObserver != null) {
            rememberObserver.onRemembered();
        }
        launchRequest();
    }

    private final void launchRequest() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new GlidePainter$launchRequest$1(this, null), 3, null);
    }

    private final Painter toPainter(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
            return new BitmapPainter(AndroidImageBitmap_androidKt.asImageBitmap(bitmap), 0L, 0L, 6, null);
        } else if (drawable instanceof ColorDrawable) {
            return new ColorPainter(ColorKt.Color(((ColorDrawable) drawable).getColor()), null);
        } else {
            Drawable mutate = drawable.mutate();
            Intrinsics.checkNotNullExpressionValue(mutate, "mutate()");
            return new DrawablePainter(mutate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateDelegate(Drawable drawable) {
        Painter painter = drawable != null ? toPainter(drawable) : null;
        Painter delegate = getDelegate();
        if (painter != delegate) {
            RememberObserver rememberObserver = delegate instanceof RememberObserver ? (RememberObserver) delegate : null;
            if (rememberObserver != null) {
                rememberObserver.onForgotten();
            }
            RememberObserver rememberObserver2 = painter instanceof RememberObserver ? (RememberObserver) painter : null;
            if (rememberObserver2 != null) {
                rememberObserver2.onRemembered();
            }
            this.currentDrawable.setValue(drawable);
            setDelegate(painter);
        }
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyAlpha(float f) {
        setAlpha(f);
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyColorFilter(ColorFilter colorFilter) {
        setColorFilter(colorFilter);
        return true;
    }

    public final Status getStatus$compose_release() {
        return (Status) this.status$delegate.getValue();
    }

    public final void setStatus$compose_release(Status status) {
        Intrinsics.checkNotNullParameter(status, "<set-?>");
        this.status$delegate.setValue(status);
    }

    private final float getAlpha() {
        return ((Number) this.alpha$delegate.getValue()).floatValue();
    }

    private final ColorFilter getColorFilter() {
        return (ColorFilter) this.colorFilter$delegate.getValue();
    }

    private final void setColorFilter(ColorFilter colorFilter) {
        this.colorFilter$delegate.setValue(colorFilter);
    }

    private final Painter getDelegate() {
        return (Painter) this.delegate$delegate.getValue();
    }

    private final void setDelegate(Painter painter) {
        this.delegate$delegate.setValue(painter);
    }
}
