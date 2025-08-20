package hw;

import android.content.ClipData;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.ContentInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;
/* loaded from: classes.dex */
public final class zn {
    @NonNull
    public final a y;

    /* loaded from: classes.dex */
    public interface a {
        int getSource();

        @NonNull
        ClipData n3();

        int s();

        @Nullable
        ContentInfo y();
    }

    /* loaded from: classes.dex */
    public static final class fb implements a {
        @Nullable

        /* renamed from: gv  reason: collision with root package name */
        public final Uri f9000gv;

        /* renamed from: n3  reason: collision with root package name */
        public final int f9001n3;
        @Nullable

        /* renamed from: v  reason: collision with root package name */
        public final Bundle f9002v;
        @NonNull
        public final ClipData y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f9003zn;

        public fb(gv gvVar) {
            this.y = (ClipData) vl.s.fb(gvVar.y);
            this.f9001n3 = vl.s.zn(gvVar.f9005n3, 0, 5, "source");
            this.f9003zn = vl.s.a(gvVar.f9007zn, 1);
            this.f9000gv = gvVar.f9004gv;
            this.f9002v = gvVar.f9006v;
        }

        @Override // hw.zn.a
        public int getSource() {
            return this.f9001n3;
        }

        @Override // hw.zn.a
        @NonNull
        public ClipData n3() {
            return this.y;
        }

        @Override // hw.zn.a
        public int s() {
            return this.f9003zn;
        }

        @NonNull
        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("ContentInfoCompat{clip=");
            sb.append(this.y.getDescription());
            sb.append(", source=");
            sb.append(zn.v(this.f9001n3));
            sb.append(", flags=");
            sb.append(zn.y(this.f9003zn));
            String str2 = "";
            if (this.f9000gv == null) {
                str = "";
            } else {
                str = ", hasLinkUri(" + this.f9000gv.toString().length() + ")";
            }
            sb.append(str);
            if (this.f9002v != null) {
                str2 = ", hasExtras";
            }
            sb.append(str2);
            sb.append("}");
            return sb.toString();
        }

        @Override // hw.zn.a
        @Nullable
        public ContentInfo y() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static final class gv implements InterfaceC0111zn {
        @Nullable

        /* renamed from: gv  reason: collision with root package name */
        public Uri f9004gv;

        /* renamed from: n3  reason: collision with root package name */
        public int f9005n3;
        @Nullable

        /* renamed from: v  reason: collision with root package name */
        public Bundle f9006v;
        @NonNull
        public ClipData y;

        /* renamed from: zn  reason: collision with root package name */
        public int f9007zn;

        public gv(@NonNull ClipData clipData, int i) {
            this.y = clipData;
            this.f9005n3 = i;
        }

        @Override // hw.zn.InterfaceC0111zn
        @NonNull
        public zn build() {
            return new zn(new fb(this));
        }

        @Override // hw.zn.InterfaceC0111zn
        public void setExtras(@Nullable Bundle bundle) {
            this.f9006v = bundle;
        }

        @Override // hw.zn.InterfaceC0111zn
        public void y(@Nullable Uri uri) {
            this.f9004gv = uri;
        }

        @Override // hw.zn.InterfaceC0111zn
        public void zn(int i) {
            this.f9007zn = i;
        }
    }

    /* loaded from: classes.dex */
    public static final class n3 implements InterfaceC0111zn {
        @NonNull
        public final ContentInfo.Builder y;

        public n3(@NonNull ClipData clipData, int i) {
            this.y = new ContentInfo.Builder(clipData, i);
        }

        @Override // hw.zn.InterfaceC0111zn
        @NonNull
        public zn build() {
            return new zn(new v(this.y.build()));
        }

        @Override // hw.zn.InterfaceC0111zn
        public void setExtras(@Nullable Bundle bundle) {
            this.y.setExtras(bundle);
        }

        @Override // hw.zn.InterfaceC0111zn
        public void y(@Nullable Uri uri) {
            this.y.setLinkUri(uri);
        }

        @Override // hw.zn.InterfaceC0111zn
        public void zn(int i) {
            this.y.setFlags(i);
        }
    }

    /* loaded from: classes.dex */
    public static final class v implements a {
        @NonNull
        public final ContentInfo y;

        public v(@NonNull ContentInfo contentInfo) {
            this.y = (ContentInfo) vl.s.fb(contentInfo);
        }

        @Override // hw.zn.a
        public int getSource() {
            return this.y.getSource();
        }

        @Override // hw.zn.a
        @NonNull
        public ClipData n3() {
            return this.y.getClip();
        }

        @Override // hw.zn.a
        public int s() {
            return this.y.getFlags();
        }

        @NonNull
        public String toString() {
            return "ContentInfoCompat{" + this.y + "}";
        }

        @Override // hw.zn.a
        @NonNull
        public ContentInfo y() {
            return this.y;
        }
    }

    /* loaded from: classes.dex */
    public static final class y {
        @NonNull
        public final InterfaceC0111zn y;

        public y(@NonNull ClipData clipData, int i) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.y = new n3(clipData, i);
            } else {
                this.y = new gv(clipData, i);
            }
        }

        @NonNull
        public y gv(@Nullable Uri uri) {
            this.y.y(uri);
            return this;
        }

        @NonNull
        public y n3(@Nullable Bundle bundle) {
            this.y.setExtras(bundle);
            return this;
        }

        @NonNull
        public zn y() {
            return this.y.build();
        }

        @NonNull
        public y zn(int i) {
            this.y.zn(i);
            return this;
        }
    }

    /* renamed from: hw.zn$zn  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0111zn {
        @NonNull
        zn build();

        void setExtras(@Nullable Bundle bundle);

        void y(@Nullable Uri uri);

        void zn(int i);
    }

    public zn(@NonNull a aVar) {
        this.y = aVar;
    }

    @NonNull
    public static zn fb(@NonNull ContentInfo contentInfo) {
        return new zn(new v(contentInfo));
    }

    @NonNull
    public static String v(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return String.valueOf(i);
                            }
                            return "SOURCE_PROCESS_TEXT";
                        }
                        return "SOURCE_AUTOFILL";
                    }
                    return "SOURCE_DRAG_AND_DROP";
                }
                return "SOURCE_INPUT_METHOD";
            }
            return "SOURCE_CLIPBOARD";
        }
        return "SOURCE_APP";
    }

    @NonNull
    public static String y(int i) {
        if ((i & 1) != 0) {
            return "FLAG_CONVERT_TO_PLAIN_TEXT";
        }
        return String.valueOf(i);
    }

    @NonNull
    public ContentInfo a() {
        ContentInfo y2 = this.y.y();
        Objects.requireNonNull(y2);
        return y2;
    }

    public int gv() {
        return this.y.getSource();
    }

    @NonNull
    public ClipData n3() {
        return this.y.n3();
    }

    @NonNull
    public String toString() {
        return this.y.toString();
    }

    public int zn() {
        return this.y.s();
    }
}
