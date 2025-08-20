package lw;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.offline.StreamKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import m1.m;
/* loaded from: classes.dex */
public class s extends c5 {

    /* renamed from: wz  reason: collision with root package name */
    public static final s f10484wz = new s("", Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, Collections.emptyList(), false, Collections.emptyMap(), Collections.emptyList());

    /* renamed from: a  reason: collision with root package name */
    public final List<y> f10485a;

    /* renamed from: c5  reason: collision with root package name */
    public final List<y> f10486c5;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final List<m> f10487f;

    /* renamed from: fb  reason: collision with root package name */
    public final List<y> f10488fb;

    /* renamed from: gv  reason: collision with root package name */
    public final List<Uri> f10489gv;
    @Nullable

    /* renamed from: i9  reason: collision with root package name */
    public final m f10490i9;

    /* renamed from: s  reason: collision with root package name */
    public final List<y> f10491s;

    /* renamed from: t  reason: collision with root package name */
    public final Map<String, String> f10492t;

    /* renamed from: tl  reason: collision with root package name */
    public final List<DrmInitData> f10493tl;

    /* renamed from: v  reason: collision with root package name */
    public final List<n3> f10494v;

    /* loaded from: classes.dex */
    public static final class n3 {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public final String f10495a;
        @Nullable

        /* renamed from: gv  reason: collision with root package name */
        public final String f10496gv;

        /* renamed from: n3  reason: collision with root package name */
        public final m f10497n3;
        @Nullable

        /* renamed from: v  reason: collision with root package name */
        public final String f10498v;
        public final Uri y;
        @Nullable

        /* renamed from: zn  reason: collision with root package name */
        public final String f10499zn;

        public n3(Uri uri, m mVar, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
            this.y = uri;
            this.f10497n3 = mVar;
            this.f10499zn = str;
            this.f10496gv = str2;
            this.f10498v = str3;
            this.f10495a = str4;
        }

        public static n3 n3(Uri uri) {
            return new n3(uri, new m.n3().oz("0").k5("application/x-mpegURL").z6(), null, null, null, null);
        }

        public n3 y(m mVar) {
            return new n3(this.y, mVar, this.f10499zn, this.f10496gv, this.f10498v, this.f10495a);
        }
    }

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: gv  reason: collision with root package name */
        public final String f10500gv;

        /* renamed from: n3  reason: collision with root package name */
        public final m f10501n3;
        @Nullable
        public final Uri y;

        /* renamed from: zn  reason: collision with root package name */
        public final String f10502zn;

        public y(@Nullable Uri uri, m mVar, String str, String str2) {
            this.y = uri;
            this.f10501n3 = mVar;
            this.f10502zn = str;
            this.f10500gv = str2;
        }
    }

    public s(String str, List<String> list, List<n3> list2, List<y> list3, List<y> list4, List<y> list5, List<y> list6, @Nullable m mVar, @Nullable List<m> list7, boolean z2, Map<String, String> map, List<DrmInitData> list8) {
        super(str, list, z2);
        List<m> list9;
        this.f10489gv = Collections.unmodifiableList(a(list2, list3, list4, list5, list6));
        this.f10494v = Collections.unmodifiableList(list2);
        this.f10485a = Collections.unmodifiableList(list3);
        this.f10488fb = Collections.unmodifiableList(list4);
        this.f10491s = Collections.unmodifiableList(list5);
        this.f10486c5 = Collections.unmodifiableList(list6);
        this.f10490i9 = mVar;
        if (list7 != null) {
            list9 = Collections.unmodifiableList(list7);
        } else {
            list9 = null;
        }
        this.f10487f = list9;
        this.f10492t = Collections.unmodifiableMap(map);
        this.f10493tl = Collections.unmodifiableList(list8);
    }

    public static List<Uri> a(List<n3> list, List<y> list2, List<y> list3, List<y> list4, List<y> list5) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            Uri uri = list.get(i).y;
            if (!arrayList.contains(uri)) {
                arrayList.add(uri);
            }
        }
        n3(list2, arrayList);
        n3(list3, arrayList);
        n3(list4, arrayList);
        n3(list5, arrayList);
        return arrayList;
    }

    public static <T> List<T> gv(List<T> list, int i, List<StreamKey> list2) {
        ArrayList arrayList = new ArrayList(list2.size());
        for (int i5 = 0; i5 < list.size(); i5++) {
            T t2 = list.get(i5);
            int i6 = 0;
            while (true) {
                if (i6 < list2.size()) {
                    StreamKey streamKey = list2.get(i6);
                    if (streamKey.f4332v == i && streamKey.f4330fb == i5) {
                        arrayList.add(t2);
                        break;
                    }
                    i6++;
                }
            }
        }
        return arrayList;
    }

    public static void n3(List<y> list, List<Uri> list2) {
        for (int i = 0; i < list.size(); i++) {
            Uri uri = list.get(i).y;
            if (uri != null && !list2.contains(uri)) {
                list2.add(uri);
            }
        }
    }

    public static s v(String str) {
        return new s("", Collections.emptyList(), Collections.singletonList(n3.n3(Uri.parse(str))), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, null, false, Collections.emptyMap(), Collections.emptyList());
    }

    @Override // ea.y
    /* renamed from: zn */
    public s y(List<StreamKey> list) {
        return new s(this.y, this.f10387n3, gv(this.f10494v, 0, list), Collections.emptyList(), gv(this.f10488fb, 1, list), gv(this.f10491s, 2, list), Collections.emptyList(), this.f10490i9, this.f10487f, this.f10388zn, this.f10492t, this.f10493tl);
    }
}
