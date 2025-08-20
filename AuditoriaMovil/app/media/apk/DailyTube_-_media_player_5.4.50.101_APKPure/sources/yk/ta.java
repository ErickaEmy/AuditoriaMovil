package yk;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class ta {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f15411a;

    /* renamed from: gv  reason: collision with root package name */
    public final String f15412gv;

    /* renamed from: n3  reason: collision with root package name */
    public final int f15413n3;

    /* renamed from: v  reason: collision with root package name */
    public final String f15414v;
    public final int y;

    /* renamed from: zn  reason: collision with root package name */
    public final String f15415zn;

    public ta(int i, int i5, String str, String str2, String str3) {
        this.y = i;
        this.f15413n3 = i5;
        this.f15415zn = str;
        this.f15412gv = str2;
        this.f15414v = str3;
    }

    public void a(@Nullable Bitmap bitmap) {
        this.f15411a = bitmap;
    }

    public String gv() {
        return this.f15415zn;
    }

    public String n3() {
        return this.f15412gv;
    }

    public int v() {
        return this.y;
    }

    @Nullable
    public Bitmap y() {
        return this.f15411a;
    }

    public int zn() {
        return this.f15413n3;
    }
}
