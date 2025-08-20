package mn;

import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import androidx.annotation.Nullable;
import v5.j5;
/* loaded from: classes.dex */
public final class n3 {

    /* renamed from: fb  reason: collision with root package name */
    public static final n3 f11509fb = new n3(-1, -16777216, 0, 0, -1, null);
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final Typeface f11510a;

    /* renamed from: gv  reason: collision with root package name */
    public final int f11511gv;

    /* renamed from: n3  reason: collision with root package name */
    public final int f11512n3;

    /* renamed from: v  reason: collision with root package name */
    public final int f11513v;
    public final int y;

    /* renamed from: zn  reason: collision with root package name */
    public final int f11514zn;

    public n3(int i, int i5, int i6, int i8, int i10, @Nullable Typeface typeface) {
        this.y = i;
        this.f11512n3 = i5;
        this.f11514zn = i6;
        this.f11511gv = i8;
        this.f11513v = i10;
        this.f11510a = typeface;
    }

    public static n3 n3(CaptioningManager.CaptionStyle captionStyle) {
        return new n3(captionStyle.foregroundColor, captionStyle.backgroundColor, 0, captionStyle.edgeType, captionStyle.edgeColor, captionStyle.getTypeface());
    }

    public static n3 y(CaptioningManager.CaptionStyle captionStyle) {
        if (j5.y >= 21) {
            return zn(captionStyle);
        }
        return n3(captionStyle);
    }

    public static n3 zn(CaptioningManager.CaptionStyle captionStyle) {
        int i;
        int i5;
        int i6;
        int i8;
        int i10;
        if (captionStyle.hasForegroundColor()) {
            i = captionStyle.foregroundColor;
        } else {
            i = f11509fb.y;
        }
        int i11 = i;
        if (captionStyle.hasBackgroundColor()) {
            i5 = captionStyle.backgroundColor;
        } else {
            i5 = f11509fb.f11512n3;
        }
        int i12 = i5;
        if (captionStyle.hasWindowColor()) {
            i6 = captionStyle.windowColor;
        } else {
            i6 = f11509fb.f11514zn;
        }
        int i13 = i6;
        if (captionStyle.hasEdgeType()) {
            i8 = captionStyle.edgeType;
        } else {
            i8 = f11509fb.f11511gv;
        }
        int i14 = i8;
        if (captionStyle.hasEdgeColor()) {
            i10 = captionStyle.edgeColor;
        } else {
            i10 = f11509fb.f11513v;
        }
        return new n3(i11, i12, i13, i14, i10, captionStyle.getTypeface());
    }
}
