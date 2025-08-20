package o;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public final class zn {
    public final InterfaceC0170zn y;

    /* renamed from: o.zn$zn  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0170zn {
        @NonNull
        ClipDescription getDescription();

        @Nullable
        Uri gv();

        @NonNull
        Uri n3();

        @Nullable
        Object y();

        void zn();
    }

    public zn(@NonNull Uri uri, @NonNull ClipDescription clipDescription, @Nullable Uri uri2) {
        if (Build.VERSION.SDK_INT >= 25) {
            this.y = new y(uri, clipDescription, uri2);
        } else {
            this.y = new n3(uri, clipDescription, uri2);
        }
    }

    @Nullable
    public static zn a(@Nullable Object obj) {
        if (obj == null || Build.VERSION.SDK_INT < 25) {
            return null;
        }
        return new zn(new y(obj));
    }

    public void gv() {
        this.y.zn();
    }

    @NonNull
    public ClipDescription n3() {
        return this.y.getDescription();
    }

    @Nullable
    public Object v() {
        return this.y.y();
    }

    @NonNull
    public Uri y() {
        return this.y.n3();
    }

    @Nullable
    public Uri zn() {
        return this.y.gv();
    }

    /* loaded from: classes.dex */
    public static final class y implements InterfaceC0170zn {
        @NonNull
        public final InputContentInfo y;

        public y(@NonNull Object obj) {
            this.y = (InputContentInfo) obj;
        }

        @Override // o.zn.InterfaceC0170zn
        @NonNull
        public ClipDescription getDescription() {
            return this.y.getDescription();
        }

        @Override // o.zn.InterfaceC0170zn
        @Nullable
        public Uri gv() {
            return this.y.getLinkUri();
        }

        @Override // o.zn.InterfaceC0170zn
        @NonNull
        public Uri n3() {
            return this.y.getContentUri();
        }

        @Override // o.zn.InterfaceC0170zn
        @NonNull
        public Object y() {
            return this.y;
        }

        @Override // o.zn.InterfaceC0170zn
        public void zn() {
            this.y.requestPermission();
        }

        public y(@NonNull Uri uri, @NonNull ClipDescription clipDescription, @Nullable Uri uri2) {
            this.y = new InputContentInfo(uri, clipDescription, uri2);
        }
    }

    public zn(@NonNull InterfaceC0170zn interfaceC0170zn) {
        this.y = interfaceC0170zn;
    }

    /* loaded from: classes.dex */
    public static final class n3 implements InterfaceC0170zn {
        @NonNull

        /* renamed from: n3  reason: collision with root package name */
        public final ClipDescription f12058n3;
        @NonNull
        public final Uri y;
        @Nullable

        /* renamed from: zn  reason: collision with root package name */
        public final Uri f12059zn;

        public n3(@NonNull Uri uri, @NonNull ClipDescription clipDescription, @Nullable Uri uri2) {
            this.y = uri;
            this.f12058n3 = clipDescription;
            this.f12059zn = uri2;
        }

        @Override // o.zn.InterfaceC0170zn
        @NonNull
        public ClipDescription getDescription() {
            return this.f12058n3;
        }

        @Override // o.zn.InterfaceC0170zn
        @Nullable
        public Uri gv() {
            return this.f12059zn;
        }

        @Override // o.zn.InterfaceC0170zn
        @NonNull
        public Uri n3() {
            return this.y;
        }

        @Override // o.zn.InterfaceC0170zn
        @Nullable
        public Object y() {
            return null;
        }

        @Override // o.zn.InterfaceC0170zn
        public void zn() {
        }
    }
}
