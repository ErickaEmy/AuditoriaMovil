package dq;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.offline.StreamKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import v5.j5;
/* loaded from: classes.dex */
public class zn implements ea.y<zn> {

    /* renamed from: a  reason: collision with root package name */
    public final long f7419a;
    @Nullable

    /* renamed from: c5  reason: collision with root package name */
    public final mt f7420c5;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final Uri f7421f;

    /* renamed from: fb  reason: collision with root package name */
    public final long f7422fb;

    /* renamed from: gv  reason: collision with root package name */
    public final boolean f7423gv;
    @Nullable

    /* renamed from: i9  reason: collision with root package name */
    public final xc f7424i9;

    /* renamed from: n3  reason: collision with root package name */
    public final long f7425n3;

    /* renamed from: s  reason: collision with root package name */
    public final long f7426s;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    public final f f7427t;

    /* renamed from: tl  reason: collision with root package name */
    public final List<i9> f7428tl;

    /* renamed from: v  reason: collision with root package name */
    public final long f7429v;
    public final long y;

    /* renamed from: zn  reason: collision with root package name */
    public final long f7430zn;

    public zn(long j2, long j4, long j6, boolean z2, long j7, long j8, long j9, long j10, @Nullable f fVar, @Nullable mt mtVar, @Nullable xc xcVar, @Nullable Uri uri, List<i9> list) {
        List<i9> list2;
        this.y = j2;
        this.f7425n3 = j4;
        this.f7430zn = j6;
        this.f7423gv = z2;
        this.f7429v = j7;
        this.f7419a = j8;
        this.f7422fb = j9;
        this.f7426s = j10;
        this.f7427t = fVar;
        this.f7420c5 = mtVar;
        this.f7421f = uri;
        this.f7424i9 = xcVar;
        if (list == null) {
            list2 = Collections.emptyList();
        } else {
            list2 = list;
        }
        this.f7428tl = list2;
    }

    public static ArrayList<y> zn(List<y> list, LinkedList<StreamKey> linkedList) {
        StreamKey poll = linkedList.poll();
        int i = poll.y;
        ArrayList<y> arrayList = new ArrayList<>();
        do {
            int i5 = poll.f4332v;
            y yVar = list.get(i5);
            List<tl> list2 = yVar.f7418zn;
            ArrayList arrayList2 = new ArrayList();
            do {
                arrayList2.add(list2.get(poll.f4330fb));
                poll = linkedList.poll();
                if (poll.y != i) {
                    break;
                }
            } while (poll.f4332v == i5);
            arrayList.add(new y(yVar.y, yVar.f7416n3, arrayList2, yVar.f7415gv, yVar.f7417v, yVar.f7414a));
        } while (poll.y == i);
        linkedList.addFirst(poll);
        return arrayList;
    }

    public final long a(int i) {
        long j2;
        long j4;
        if (i == this.f7428tl.size() - 1) {
            j2 = this.f7425n3;
            if (j2 == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            j4 = this.f7428tl.get(i).f7365n3;
        } else {
            j2 = this.f7428tl.get(i + 1).f7365n3;
            j4 = this.f7428tl.get(i).f7365n3;
        }
        return j2 - j4;
    }

    public final long fb(int i) {
        return j5.xb(a(i));
    }

    public final i9 gv(int i) {
        return this.f7428tl.get(i);
    }

    @Override // ea.y
    /* renamed from: n3 */
    public final zn y(List<StreamKey> list) {
        long j2;
        LinkedList linkedList = new LinkedList(list);
        Collections.sort(linkedList);
        linkedList.add(new StreamKey(-1, -1, -1));
        ArrayList arrayList = new ArrayList();
        long j4 = 0;
        int i = 0;
        while (true) {
            j2 = -9223372036854775807L;
            if (i >= v()) {
                break;
            }
            if (((StreamKey) linkedList.peek()).y != i) {
                long a2 = a(i);
                if (a2 != -9223372036854775807L) {
                    j4 += a2;
                }
            } else {
                i9 gv2 = gv(i);
                arrayList.add(new i9(gv2.y, gv2.f7365n3 - j4, zn(gv2.f7367zn, linkedList), gv2.f7364gv));
            }
            i++;
        }
        long j6 = this.f7425n3;
        if (j6 != -9223372036854775807L) {
            j2 = j6 - j4;
        }
        return new zn(this.y, j2, this.f7430zn, this.f7423gv, this.f7429v, this.f7419a, this.f7422fb, this.f7426s, this.f7427t, this.f7420c5, this.f7424i9, this.f7421f, arrayList);
    }

    public final int v() {
        return this.f7428tl.size();
    }
}
