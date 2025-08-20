package ha;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData;
import e4.d0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import m1.ne;
import v5.rz;
/* loaded from: classes.dex */
public final class tl {

    /* renamed from: gv  reason: collision with root package name */
    public static final w0.mt f8894gv = w0.mt.gv(':');

    /* renamed from: v  reason: collision with root package name */
    public static final w0.mt f8895v = w0.mt.gv('*');

    /* renamed from: zn  reason: collision with root package name */
    public int f8897zn;
    public final List<y> y = new ArrayList();

    /* renamed from: n3  reason: collision with root package name */
    public int f8896n3 = 0;

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: n3  reason: collision with root package name */
        public final long f8898n3;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f8899zn;

        public y(int i, long j2, int i5) {
            this.y = i;
            this.f8898n3 = j2;
            this.f8899zn = i5;
        }
    }

    public static SlowMotionData a(rz rzVar, int i) throws ne {
        ArrayList arrayList = new ArrayList();
        List<String> a2 = f8895v.a(rzVar.ta(i));
        for (int i5 = 0; i5 < a2.size(); i5++) {
            List<String> a3 = f8894gv.a(a2.get(i5));
            if (a3.size() == 3) {
                try {
                    arrayList.add(new SlowMotionData.Segment(Long.parseLong(a3.get(0)), Long.parseLong(a3.get(1)), 1 << (Integer.parseInt(a3.get(2)) - 1)));
                } catch (NumberFormatException e2) {
                    throw ne.y(null, e2);
                }
            } else {
                throw ne.y(null, null);
            }
        }
        return new SlowMotionData(arrayList);
    }

    public static int n3(String str) throws ne {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1711564334:
                if (str.equals("SlowMotion_Data")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1332107749:
                if (str.equals("Super_SlowMotion_Edit_Data")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1251387154:
                if (str.equals("Super_SlowMotion_Data")) {
                    c2 = 2;
                    break;
                }
                break;
            case -830665521:
                if (str.equals("Super_SlowMotion_Deflickering_On")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1760745220:
                if (str.equals("Super_SlowMotion_BGM")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 2192;
            case 1:
                return 2819;
            case 2:
                return 2816;
            case 3:
                return 2820;
            case 4:
                return 2817;
            default:
                throw ne.y("Invalid SEF name", null);
        }
    }

    public void fb() {
        this.y.clear();
        this.f8896n3 = 0;
    }

    public final void gv(e4.tl tlVar, d0 d0Var) throws IOException {
        long length = tlVar.getLength();
        int i = this.f8897zn - 20;
        rz rzVar = new rz(i);
        tlVar.readFully(rzVar.v(), 0, i);
        for (int i5 = 0; i5 < i / 12; i5++) {
            rzVar.ut(2);
            short i42 = rzVar.i4();
            if (i42 != 2192 && i42 != 2816 && i42 != 2817 && i42 != 2819 && i42 != 2820) {
                rzVar.ut(8);
            } else {
                this.y.add(new y(i42, (length - this.f8897zn) - rzVar.r(), rzVar.r()));
            }
        }
        if (this.y.isEmpty()) {
            d0Var.y = 0L;
            return;
        }
        this.f8896n3 = 3;
        d0Var.y = this.y.get(0).f8898n3;
    }

    public final void v(e4.tl tlVar, List<Metadata.Entry> list) throws IOException {
        long position = tlVar.getPosition();
        int length = (int) ((tlVar.getLength() - tlVar.getPosition()) - this.f8897zn);
        rz rzVar = new rz(length);
        tlVar.readFully(rzVar.v(), 0, length);
        for (int i = 0; i < this.y.size(); i++) {
            y yVar = this.y.get(i);
            rzVar.oz((int) (yVar.f8898n3 - position));
            rzVar.ut(4);
            int r2 = rzVar.r();
            int n32 = n3(rzVar.ta(r2));
            int i5 = yVar.f8899zn - (r2 + 8);
            if (n32 != 2192) {
                if (n32 != 2816 && n32 != 2817 && n32 != 2819 && n32 != 2820) {
                    throw new IllegalStateException();
                }
            } else {
                list.add(a(rzVar, i5));
            }
        }
    }

    public final void y(e4.tl tlVar, d0 d0Var) throws IOException {
        rz rzVar = new rz(8);
        tlVar.readFully(rzVar.v(), 0, 8);
        this.f8897zn = rzVar.r() + 8;
        if (rzVar.p() != 1397048916) {
            d0Var.y = 0L;
            return;
        }
        d0Var.y = tlVar.getPosition() - (this.f8897zn - 12);
        this.f8896n3 = 2;
    }

    public int zn(e4.tl tlVar, d0 d0Var, List<Metadata.Entry> list) throws IOException {
        int i = this.f8896n3;
        long j2 = 0;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        v(tlVar, list);
                        d0Var.y = 0L;
                    } else {
                        throw new IllegalStateException();
                    }
                } else {
                    gv(tlVar, d0Var);
                }
            } else {
                y(tlVar, d0Var);
            }
        } else {
            long length = tlVar.getLength();
            if (length != -1 && length >= 8) {
                j2 = length - 8;
            }
            d0Var.y = j2;
            this.f8896n3 = 1;
        }
        return 1;
    }
}
