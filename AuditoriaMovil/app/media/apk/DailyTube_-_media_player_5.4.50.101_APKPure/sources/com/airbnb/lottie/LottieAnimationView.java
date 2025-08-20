package com.airbnb.lottie;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import br.gv;
import com.airbnb.lottie.LottieAnimationView;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import ne.v;
import uo.zn;
import yk.a8;
import yk.b;
import yk.d;
import yk.ej;
import yk.hw;
import yk.j5;
import yk.mg;
import yk.s;
import yk.ud;
import yk.vl;
import yk.w;
import yk.yt;
/* loaded from: classes.dex */
public class LottieAnimationView extends AppCompatImageView {

    /* renamed from: fh  reason: collision with root package name */
    public static final d<Throwable> f4008fh = new d() { // from class: yk.v
        @Override // yk.d
        public final void onResult(Object obj) {
            LottieAnimationView.z((Throwable) obj);
        }
    };

    /* renamed from: co  reason: collision with root package name */
    public boolean f4009co;
    @Nullable

    /* renamed from: d0  reason: collision with root package name */
    public s f4010d0;

    /* renamed from: f  reason: collision with root package name */
    public final mg f4011f;

    /* renamed from: f3  reason: collision with root package name */
    public final Set<ej> f4012f3;
    @Nullable

    /* renamed from: fb  reason: collision with root package name */
    public d<Throwable> f4013fb;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    public b<s> f4014n;

    /* renamed from: p  reason: collision with root package name */
    public boolean f4015p;

    /* renamed from: r  reason: collision with root package name */
    public final Set<n3> f4016r;

    /* renamed from: s  reason: collision with root package name */
    public int f4017s;

    /* renamed from: t  reason: collision with root package name */
    public String f4018t;

    /* renamed from: v  reason: collision with root package name */
    public final d<Throwable> f4019v;

    /* renamed from: w  reason: collision with root package name */
    public int f4020w;
    public final d<s> y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f4021z;

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new y();

        /* renamed from: f  reason: collision with root package name */
        public String f4022f;

        /* renamed from: fb  reason: collision with root package name */
        public float f4023fb;

        /* renamed from: s  reason: collision with root package name */
        public boolean f4024s;

        /* renamed from: t  reason: collision with root package name */
        public int f4025t;

        /* renamed from: v  reason: collision with root package name */
        public int f4026v;

        /* renamed from: w  reason: collision with root package name */
        public int f4027w;
        public String y;

        public /* synthetic */ SavedState(Parcel parcel, y yVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.y);
            parcel.writeFloat(this.f4023fb);
            parcel.writeInt(this.f4024s ? 1 : 0);
            parcel.writeString(this.f4022f);
            parcel.writeInt(this.f4025t);
            parcel.writeInt(this.f4027w);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.y = parcel.readString();
            this.f4023fb = parcel.readFloat();
            this.f4024s = parcel.readInt() == 1;
            this.f4022f = parcel.readString();
            this.f4025t = parcel.readInt();
            this.f4027w = parcel.readInt();
        }
    }

    /* loaded from: classes.dex */
    public enum n3 {
        SET_ANIMATION,
        SET_PROGRESS,
        SET_REPEAT_MODE,
        SET_REPEAT_COUNT,
        SET_IMAGE_ASSETS,
        PLAY_OPTION
    }

    /* loaded from: classes.dex */
    public class y implements d<Throwable> {
        public y() {
        }

        @Override // yk.d
        /* renamed from: y */
        public void onResult(Throwable th) {
            if (LottieAnimationView.this.f4017s != 0) {
                LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                lottieAnimationView.setImageResource(lottieAnimationView.f4017s);
            }
            (LottieAnimationView.this.f4013fb == null ? LottieAnimationView.f4008fh : LottieAnimationView.this.f4013fb).onResult(th);
        }
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.y = new d() { // from class: yk.fb
            @Override // yk.d
            public final void onResult(Object obj) {
                LottieAnimationView.this.setComposition((s) obj);
            }
        };
        this.f4019v = new y();
        this.f4017s = 0;
        this.f4011f = new mg();
        this.f4015p = false;
        this.f4009co = false;
        this.f4021z = true;
        this.f4016r = new HashSet();
        this.f4012f3 = new HashSet();
        w(attributeSet, R$attr.ffz);
    }

    private void setCompositionTask(b<s> bVar) {
        this.f4016r.add(n3.SET_ANIMATION);
        t();
        f();
        this.f4014n = bVar.gv(this.y).zn(this.f4019v);
    }

    public static /* synthetic */ void z(Throwable th) {
        if (br.s.f(th)) {
            gv.gv("Unable to load composition.", th);
            return;
        }
        throw new IllegalStateException("Unable to parse composition", th);
    }

    public final void c(float f4, boolean z2) {
        if (z2) {
            this.f4016r.add(n3.SET_PROGRESS);
        }
        this.f4011f.w2(f4);
    }

    public <T> void c5(v vVar, T t2, zn<T> znVar) {
        this.f4011f.w(vVar, t2, znVar);
    }

    public final /* synthetic */ a8 co(int i) throws Exception {
        if (this.f4021z) {
            return w.r(getContext(), i);
        }
        return w.x4(getContext(), i, null);
    }

    public final void f() {
        b<s> bVar = this.f4014n;
        if (bVar != null) {
            bVar.i9(this.y);
            this.f4014n.c5(this.f4019v);
        }
    }

    public void f3(String str, @Nullable String str2) {
        i4(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public boolean getClipToCompositionBounds() {
        return this.f4011f.ta();
    }

    @Nullable
    public s getComposition() {
        return this.f4010d0;
    }

    public long getDuration() {
        s sVar = this.f4010d0;
        if (sVar != null) {
            return sVar.gv();
        }
        return 0L;
    }

    public int getFrame() {
        return this.f4011f.ud();
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.f4011f.x();
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.f4011f.k5();
    }

    public float getMaxFrame() {
        return this.f4011f.yt();
    }

    public float getMinFrame() {
        return this.f4011f.vl();
    }

    @Nullable
    public yt getPerformanceTracker() {
        return this.f4011f.hw();
    }

    public float getProgress() {
        return this.f4011f.j5();
    }

    public vl getRenderMode() {
        return this.f4011f.qn();
    }

    public int getRepeatCount() {
        return this.f4011f.o();
    }

    public int getRepeatMode() {
        return this.f4011f.j();
    }

    public float getSpeed() {
        return this.f4011f.oz();
    }

    public void i4(InputStream inputStream, @Nullable String str) {
        setCompositionTask(w.wz(inputStream, str));
    }

    public void i9() {
        this.f4016r.add(n3.PLAY_OPTION);
        this.f4011f.co();
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        Drawable drawable = getDrawable();
        if ((drawable instanceof mg) && ((mg) drawable).qn() == vl.SOFTWARE) {
            this.f4011f.invalidateSelf();
        }
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable drawable2 = getDrawable();
        mg mgVar = this.f4011f;
        if (drawable2 == mgVar) {
            super.invalidateDrawable(mgVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public final /* synthetic */ a8 mt(String str) throws Exception {
        if (this.f4021z) {
            return w.t(getContext(), str);
        }
        return w.tl(getContext(), str, null);
    }

    public final void n() {
        boolean p2 = p();
        setImageDrawable(null);
        setImageDrawable(this.f4011f);
        if (p2) {
            this.f4011f.rb();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode() && this.f4009co) {
            this.f4011f.yg();
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        int i;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f4018t = savedState.y;
        Set<n3> set = this.f4016r;
        n3 n3Var = n3.SET_ANIMATION;
        if (!set.contains(n3Var) && !TextUtils.isEmpty(this.f4018t)) {
            setAnimation(this.f4018t);
        }
        this.f4020w = savedState.f4026v;
        if (!this.f4016r.contains(n3Var) && (i = this.f4020w) != 0) {
            setAnimation(i);
        }
        if (!this.f4016r.contains(n3.SET_PROGRESS)) {
            c(savedState.f4023fb, false);
        }
        if (!this.f4016r.contains(n3.PLAY_OPTION) && savedState.f4024s) {
            x4();
        }
        if (!this.f4016r.contains(n3.SET_IMAGE_ASSETS)) {
            setImageAssetsFolder(savedState.f4022f);
        }
        if (!this.f4016r.contains(n3.SET_REPEAT_MODE)) {
            setRepeatMode(savedState.f4025t);
        }
        if (!this.f4016r.contains(n3.SET_REPEAT_COUNT)) {
            setRepeatCount(savedState.f4027w);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.y = this.f4018t;
        savedState.f4026v = this.f4020w;
        savedState.f4023fb = this.f4011f.j5();
        savedState.f4024s = this.f4011f.en();
        savedState.f4022f = this.f4011f.x();
        savedState.f4025t = this.f4011f.j();
        savedState.f4027w = this.f4011f.o();
        return savedState;
    }

    public boolean p() {
        return this.f4011f.f7();
    }

    public void r() {
        this.f4009co = false;
        this.f4011f.ap();
    }

    public void setAnimation(int i) {
        this.f4020w = i;
        this.f4018t = null;
        setCompositionTask(xc(i));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        f3(str, null);
    }

    public void setAnimationFromUrl(String str) {
        b<s> f32;
        if (this.f4021z) {
            f32 = w.i4(getContext(), str);
        } else {
            f32 = w.f3(getContext(), str, null);
        }
        setCompositionTask(f32);
    }

    public void setApplyingOpacityToLayersEnabled(boolean z2) {
        this.f4011f.m(z2);
    }

    public void setCacheComposition(boolean z2) {
        this.f4021z = z2;
    }

    public void setClipToCompositionBounds(boolean z2) {
        this.f4011f.g(z2);
    }

    public void setComposition(@NonNull s sVar) {
        boolean z2 = yk.zn.y;
        this.f4011f.setCallback(this);
        this.f4010d0 = sVar;
        this.f4015p = true;
        boolean u02 = this.f4011f.u0(sVar);
        this.f4015p = false;
        if (getDrawable() == this.f4011f && !u02) {
            return;
        }
        if (!u02) {
            n();
        }
        onVisibilityChanged(this, getVisibility());
        requestLayout();
        for (ej ejVar : this.f4012f3) {
            ejVar.y(sVar);
        }
    }

    public void setDefaultFontFileExtension(String str) {
        this.f4011f.bk(str);
    }

    public void setFailureListener(@Nullable d<Throwable> dVar) {
        this.f4013fb = dVar;
    }

    public void setFallbackResource(int i) {
        this.f4017s = i;
    }

    public void setFontAssetDelegate(yk.y yVar) {
        this.f4011f.y4(yVar);
    }

    public void setFontMap(@Nullable Map<String, Typeface> map) {
        this.f4011f.tg(map);
    }

    public void setFrame(int i) {
        this.f4011f.pz(i);
    }

    public void setIgnoreDisabledSystemAnimations(boolean z2) {
        this.f4011f.pq(z2);
    }

    public void setImageAssetDelegate(yk.n3 n3Var) {
        this.f4011f.cr(n3Var);
    }

    public void setImageAssetsFolder(String str) {
        this.f4011f.o0(str);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        f();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        f();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        f();
        super.setImageResource(i);
    }

    public void setMaintainOriginalImageBounds(boolean z2) {
        this.f4011f.xb(z2);
    }

    public void setMaxFrame(int i) {
        this.f4011f.wf(i);
    }

    public void setMaxProgress(float f4) {
        this.f4011f.cy(f4);
    }

    public void setMinAndMaxFrame(String str) {
        this.f4011f.qj(str);
    }

    public void setMinFrame(int i) {
        this.f4011f.l(i);
    }

    public void setMinProgress(float f4) {
        this.f4011f.vp(f4);
    }

    public void setOutlineMasksAndMattes(boolean z2) {
        this.f4011f.oa(z2);
    }

    public void setPerformanceTrackingEnabled(boolean z2) {
        this.f4011f.w9(z2);
    }

    public void setProgress(float f4) {
        c(f4, true);
    }

    public void setRenderMode(vl vlVar) {
        this.f4011f.x5(vlVar);
    }

    public void setRepeatCount(int i) {
        this.f4016r.add(n3.SET_REPEAT_COUNT);
        this.f4011f.q5(i);
    }

    public void setRepeatMode(int i) {
        this.f4016r.add(n3.SET_REPEAT_MODE);
        this.f4011f.mp(i);
    }

    public void setSafeMode(boolean z2) {
        this.f4011f.le(z2);
    }

    public void setSpeed(float f4) {
        this.f4011f.cs(f4);
    }

    public void setTextDelegate(j5 j5Var) {
        this.f4011f.ix(j5Var);
    }

    public void setUseCompositionFrameRate(boolean z2) {
        this.f4011f.yk(z2);
    }

    public final void t() {
        this.f4010d0 = null;
        this.f4011f.z();
    }

    public void tl(boolean z2) {
        this.f4011f.n(z2);
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        mg mgVar;
        if (!this.f4015p && drawable == (mgVar = this.f4011f) && mgVar.f7()) {
            r();
        } else if (!this.f4015p && (drawable instanceof mg)) {
            mg mgVar2 = (mg) drawable;
            if (mgVar2.f7()) {
                mgVar2.ap();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    public final void w(@Nullable AttributeSet attributeSet, int i) {
        String string;
        boolean z2 = false;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.f4076rz, i, 0);
        this.f4021z = obtainStyledAttributes.getBoolean(R$styleable.f4079ta, true);
        int i5 = R$styleable.f4053hw;
        boolean hasValue = obtainStyledAttributes.hasValue(i5);
        int i6 = R$styleable.f4088x;
        boolean hasValue2 = obtainStyledAttributes.hasValue(i6);
        int i8 = R$styleable.f4069oz;
        boolean hasValue3 = obtainStyledAttributes.hasValue(i8);
        if (hasValue && hasValue2) {
            throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
        }
        if (hasValue) {
            int resourceId = obtainStyledAttributes.getResourceId(i5, 0);
            if (resourceId != 0) {
                setAnimation(resourceId);
            }
        } else if (hasValue2) {
            String string2 = obtainStyledAttributes.getString(i6);
            if (string2 != null) {
                setAnimation(string2);
            }
        } else if (hasValue3 && (string = obtainStyledAttributes.getString(i8)) != null) {
            setAnimationFromUrl(string);
        }
        setFallbackResource(obtainStyledAttributes.getResourceId(R$styleable.f4035a8, 0));
        if (obtainStyledAttributes.getBoolean(R$styleable.f4062mg, false)) {
            this.f4009co = true;
        }
        if (obtainStyledAttributes.getBoolean(R$styleable.f4093yt, false)) {
            this.f4011f.q5(-1);
        }
        int i10 = R$styleable.f4067o;
        if (obtainStyledAttributes.hasValue(i10)) {
            setRepeatMode(obtainStyledAttributes.getInt(i10, 1));
        }
        int i11 = R$styleable.f4072qn;
        if (obtainStyledAttributes.hasValue(i11)) {
            setRepeatCount(obtainStyledAttributes.getInt(i11, -1));
        }
        int i12 = R$styleable.f4056j;
        if (obtainStyledAttributes.hasValue(i12)) {
            setSpeed(obtainStyledAttributes.getFloat(i12, 1.0f));
        }
        int i13 = R$styleable.f4041d;
        if (obtainStyledAttributes.hasValue(i13)) {
            setClipToCompositionBounds(obtainStyledAttributes.getBoolean(i13, true));
        }
        int i14 = R$styleable.f4045ej;
        if (obtainStyledAttributes.hasValue(i14)) {
            setDefaultFontFileExtension(obtainStyledAttributes.getString(i14));
        }
        setImageAssetsFolder(obtainStyledAttributes.getString(R$styleable.f4060k5));
        int i15 = R$styleable.f4085vl;
        c(obtainStyledAttributes.getFloat(i15, 0.0f), obtainStyledAttributes.hasValue(i15));
        tl(obtainStyledAttributes.getBoolean(R$styleable.f4082ud, false));
        int i16 = R$styleable.f4095z6;
        if (obtainStyledAttributes.hasValue(i16)) {
            c5(new v("**"), ud.f15449x, new zn(new hw(c5.y.zn(getContext(), obtainStyledAttributes.getResourceId(i16, -1)).getDefaultColor())));
        }
        int i17 = R$styleable.f4057j5;
        if (obtainStyledAttributes.hasValue(i17)) {
            vl vlVar = vl.AUTOMATIC;
            int i18 = obtainStyledAttributes.getInt(i17, vlVar.ordinal());
            if (i18 >= vl.values().length) {
                i18 = vlVar.ordinal();
            }
            setRenderMode(vl.values()[i18]);
        }
        setIgnoreDisabledSystemAnimations(obtainStyledAttributes.getBoolean(R$styleable.f4036b, false));
        int i19 = R$styleable.f4083ut;
        if (obtainStyledAttributes.hasValue(i19)) {
            setUseCompositionFrameRate(obtainStyledAttributes.getBoolean(i19, false));
        }
        obtainStyledAttributes.recycle();
        mg mgVar = this.f4011f;
        if (br.s.a(getContext()) != 0.0f) {
            z2 = true;
        }
        mgVar.ro(Boolean.valueOf(z2));
    }

    public final b<s> wz(final String str) {
        if (isInEditMode()) {
            return new b<>(new Callable() { // from class: yk.gv
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    a8 mt2;
                    mt2 = LottieAnimationView.this.mt(str);
                    return mt2;
                }
            }, true);
        }
        if (this.f4021z) {
            return w.i9(getContext(), str);
        }
        return w.f(getContext(), str, null);
    }

    public void x4() {
        this.f4016r.add(n3.PLAY_OPTION);
        this.f4011f.yg();
    }

    public final b<s> xc(final int i) {
        if (isInEditMode()) {
            return new b<>(new Callable() { // from class: yk.a
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    a8 co2;
                    co2 = LottieAnimationView.this.co(i);
                    return co2;
                }
            }, true);
        }
        if (this.f4021z) {
            return w.co(getContext(), i);
        }
        return w.z(getContext(), i, null);
    }

    public void setMaxFrame(String str) {
        this.f4011f.ad(str);
    }

    public void setMinFrame(String str) {
        this.f4011f.gq(str);
    }

    public void setAnimation(String str) {
        this.f4018t = str;
        this.f4020w = 0;
        setCompositionTask(wz(str));
    }
}
