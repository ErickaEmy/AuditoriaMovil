package sc1;

import com.uv.v7.R;
import java.io.IOException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class f {

    /* renamed from: gv  reason: collision with root package name */
    public static final f f13774gv;

    /* renamed from: n3  reason: collision with root package name */
    public static final byte[] f13775n3;
    public static final int[] y;

    /* renamed from: zn  reason: collision with root package name */
    public static final y f13776zn;

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: n3  reason: collision with root package name */
        public final int f13777n3;
        public final y[] y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f13778zn;

        public y() {
            this.y = new y[256];
        }

        public final int n3() {
            return this.f13777n3;
        }

        public final y[] y() {
            return this.y;
        }

        public final int zn() {
            return this.f13778zn;
        }

        public y(int i, int i5) {
            this.y = null;
            this.f13777n3 = i;
            int i6 = i5 & 7;
            this.f13778zn = i6 == 0 ? 8 : i6;
        }
    }

    static {
        f fVar = new f();
        f13774gv = fVar;
        y = new int[]{8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, 1016, 1017, 4090, 8185, 21, 248, 2042, 1018, 1019, 249, 2043, 250, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, 1020, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, R.styleable.AppCompatTheme_textAppearancePopupMenuHeader, 107, 108, 109, R.styleable.AppCompatTheme_textColorAlertDialogListItem, R.styleable.AppCompatTheme_textColorSearchUrl, R.styleable.AppCompatTheme_toolbarNavigationButtonStyle, R.styleable.AppCompatTheme_toolbarStyle, R.styleable.AppCompatTheme_tooltipForegroundColor, 252, R.styleable.AppCompatTheme_tooltipFrameBackground, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};
        byte[] bArr = {13, 23, 28, 28, 28, 28, 28, 28, 28, 24, 30, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 28, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, 19, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, 28, 20, 22, 20, 20, 22, 22, 22, 23, 22, 23, 23, 23, 23, 23, 24, 23, 24, 24, 22, 23, 24, 23, 23, 23, 23, 21, 22, 23, 22, 23, 23, 24, 22, 21, 20, 22, 22, 23, 23, 21, 23, 22, 22, 24, 21, 22, 23, 23, 21, 21, 22, 21, 23, 22, 23, 23, 20, 22, 22, 22, 23, 22, 22, 23, 26, 26, 20, 19, 22, 23, 22, 25, 26, 26, 26, 27, 27, 26, 24, 25, 19, 21, 26, 27, 27, 26, 27, 24, 21, 21, 26, 26, 28, 27, 27, 27, 20, 24, 20, 21, 22, 21, 21, 23, 22, 22, 25, 25, 24, 24, 26, 23, 26, 27, 26, 26, 27, 27, 27, 27, 27, 28, 27, 27, 27, 27, 27, 26};
        f13775n3 = bArr;
        f13776zn = new y();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            fVar.y(i, y[i], f13775n3[i]);
        }
    }

    public final int gv(zc1.s bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        int j2 = bytes.j();
        long j4 = 0;
        for (int i = 0; i < j2; i++) {
            j4 += f13775n3[lc1.n3.n3(bytes.s(i), 255)];
        }
        return (int) ((j4 + 7) >> 3);
    }

    public final void n3(zc1.fb source, long j2, zc1.a sink) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(sink, "sink");
        y yVar = f13776zn;
        int i = 0;
        int i5 = 0;
        for (long j4 = 0; j4 < j2; j4++) {
            i = (i << 8) | lc1.n3.n3(source.readByte(), 255);
            i5 += 8;
            while (i5 >= 8) {
                int i6 = i5 - 8;
                y[] y2 = yVar.y();
                Intrinsics.checkNotNull(y2);
                yVar = y2[(i >>> i6) & 255];
                Intrinsics.checkNotNull(yVar);
                if (yVar.y() == null) {
                    sink.writeByte(yVar.n3());
                    i5 -= yVar.zn();
                    yVar = f13776zn;
                } else {
                    i5 = i6;
                }
            }
        }
        while (i5 > 0) {
            y[] y7 = yVar.y();
            Intrinsics.checkNotNull(y7);
            y yVar2 = y7[(i << (8 - i5)) & 255];
            Intrinsics.checkNotNull(yVar2);
            if (yVar2.y() == null && yVar2.zn() <= i5) {
                sink.writeByte(yVar2.n3());
                i5 -= yVar2.zn();
                yVar = f13776zn;
            } else {
                return;
            }
        }
    }

    public final void y(int i, int i5, int i6) {
        y yVar = new y(i, i6);
        y yVar2 = f13776zn;
        while (i6 > 8) {
            i6 -= 8;
            int i8 = (i5 >>> i6) & 255;
            y[] y2 = yVar2.y();
            Intrinsics.checkNotNull(y2);
            y yVar3 = y2[i8];
            if (yVar3 == null) {
                yVar3 = new y();
                y2[i8] = yVar3;
            }
            yVar2 = yVar3;
        }
        int i10 = 8 - i6;
        int i11 = (i5 << i10) & 255;
        y[] y7 = yVar2.y();
        Intrinsics.checkNotNull(y7);
        ArraysKt.fill(y7, yVar, i11, (1 << i10) + i11);
    }

    public final void zn(zc1.s source, zc1.a sink) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(sink, "sink");
        int j2 = source.j();
        long j4 = 0;
        int i = 0;
        for (int i5 = 0; i5 < j2; i5++) {
            int n32 = lc1.n3.n3(source.s(i5), 255);
            int i6 = y[n32];
            byte b2 = f13775n3[n32];
            j4 = (j4 << b2) | i6;
            i += b2;
            while (i >= 8) {
                i = (i == true ? 1 : 0) - 8;
                sink.writeByte((int) (j4 >> i));
            }
        }
        if (i > 0) {
            sink.writeByte((int) ((j4 << (8 - i)) | (255 >>> i)));
        }
    }
}
