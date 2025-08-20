package mt;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public final class y {
    @Nullable

    /* renamed from: gv  reason: collision with root package name */
    public final Integer f11546gv;
    @Nullable

    /* renamed from: n3  reason: collision with root package name */
    public final Integer f11547n3;
    @Nullable
    public final Integer y;
    @Nullable

    /* renamed from: zn  reason: collision with root package name */
    public final Integer f11548zn;

    /* renamed from: mt.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0156y {
        @Nullable

        /* renamed from: gv  reason: collision with root package name */
        public Integer f11549gv;
        @Nullable

        /* renamed from: n3  reason: collision with root package name */
        public Integer f11550n3;
        @Nullable
        public Integer y;
        @Nullable

        /* renamed from: zn  reason: collision with root package name */
        public Integer f11551zn;

        @NonNull
        public C0156y n3(int i) {
            this.y = Integer.valueOf(i | (-16777216));
            return this;
        }

        @NonNull
        public y y() {
            return new y(this.y, this.f11550n3, this.f11551zn, this.f11549gv);
        }
    }

    public y(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4) {
        this.y = num;
        this.f11547n3 = num2;
        this.f11548zn = num3;
        this.f11546gv = num4;
    }

    @NonNull
    public Bundle y() {
        Bundle bundle = new Bundle();
        Integer num = this.y;
        if (num != null) {
            bundle.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", num.intValue());
        }
        Integer num2 = this.f11547n3;
        if (num2 != null) {
            bundle.putInt("android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR", num2.intValue());
        }
        Integer num3 = this.f11548zn;
        if (num3 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_COLOR", num3.intValue());
        }
        Integer num4 = this.f11546gv;
        if (num4 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_DIVIDER_COLOR", num4.intValue());
        }
        return bundle;
    }
}
