package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import hw.i4;
/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* renamed from: f  reason: collision with root package name */
    public TypedValue f1336f;

    /* renamed from: fb  reason: collision with root package name */
    public TypedValue f1337fb;

    /* renamed from: p  reason: collision with root package name */
    public y f1338p;

    /* renamed from: s  reason: collision with root package name */
    public TypedValue f1339s;

    /* renamed from: t  reason: collision with root package name */
    public TypedValue f1340t;

    /* renamed from: v  reason: collision with root package name */
    public TypedValue f1341v;

    /* renamed from: w  reason: collision with root package name */
    public final Rect f1342w;
    public TypedValue y;

    /* loaded from: classes.dex */
    public interface y {
        void onDetachedFromWindow();

        void y();
    }

    public ContentFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f1336f == null) {
            this.f1336f = new TypedValue();
        }
        return this.f1336f;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f1340t == null) {
            this.f1340t = new TypedValue();
        }
        return this.f1340t;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f1337fb == null) {
            this.f1337fb = new TypedValue();
        }
        return this.f1337fb;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f1339s == null) {
            this.f1339s = new TypedValue();
        }
        return this.f1339s;
    }

    public TypedValue getMinWidthMajor() {
        if (this.y == null) {
            this.y = new TypedValue();
        }
        return this.y;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f1341v == null) {
            this.f1341v = new TypedValue();
        }
        return this.f1341v;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        y yVar = this.f1338p;
        if (yVar != null) {
            yVar.y();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        y yVar = this.f1338p;
        if (yVar != null) {
            yVar.onDetachedFromWindow();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(y yVar) {
        this.f1338p = yVar;
    }

    public void y(int i, int i5, int i6, int i8) {
        this.f1342w.set(i, i5, i6, i8);
        if (i4.q9(this)) {
            requestLayout();
        }
    }

    public ContentFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1342w = new Rect();
    }
}
