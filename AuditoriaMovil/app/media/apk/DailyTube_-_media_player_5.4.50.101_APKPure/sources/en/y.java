package en;

import android.content.res.AssetManager;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
/* loaded from: classes.dex */
public class y {

    /* renamed from: ap  reason: collision with root package name */
    public static final HashSet<String> f7658ap;

    /* renamed from: ct  reason: collision with root package name */
    public static final gv[] f7661ct;

    /* renamed from: dm  reason: collision with root package name */
    public static final gv[] f7664dm;

    /* renamed from: e  reason: collision with root package name */
    public static final HashMap<Integer, gv>[] f7665e;

    /* renamed from: eb  reason: collision with root package name */
    public static final gv[][] f7666eb;

    /* renamed from: en  reason: collision with root package name */
    public static final gv[] f7668en;

    /* renamed from: f7  reason: collision with root package name */
    public static final gv[] f7670f7;

    /* renamed from: g  reason: collision with root package name */
    public static final Pattern f7672g;

    /* renamed from: g3  reason: collision with root package name */
    public static final Pattern f7673g3;

    /* renamed from: j  reason: collision with root package name */
    public static SimpleDateFormat f7676j;

    /* renamed from: jz  reason: collision with root package name */
    public static final gv[] f7678jz;

    /* renamed from: kp  reason: collision with root package name */
    public static final byte[] f7681kp;

    /* renamed from: lc  reason: collision with root package name */
    public static final gv[] f7682lc;

    /* renamed from: m  reason: collision with root package name */
    public static final Pattern f7683m;

    /* renamed from: nf  reason: collision with root package name */
    public static final gv f7686nf;

    /* renamed from: o4  reason: collision with root package name */
    public static final gv[] f7688o4;

    /* renamed from: oz  reason: collision with root package name */
    public static SimpleDateFormat f7689oz;

    /* renamed from: ra  reason: collision with root package name */
    public static final gv f7693ra;

    /* renamed from: rb  reason: collision with root package name */
    public static final byte[] f7694rb;

    /* renamed from: rs  reason: collision with root package name */
    public static final gv[] f7695rs;

    /* renamed from: s8  reason: collision with root package name */
    public static final HashMap<String, gv>[] f7697s8;

    /* renamed from: u  reason: collision with root package name */
    public static final gv[] f7699u;

    /* renamed from: u0  reason: collision with root package name */
    public static final Pattern f7700u0;

    /* renamed from: xg  reason: collision with root package name */
    public static final gv f7706xg;

    /* renamed from: y5  reason: collision with root package name */
    public static final gv[] f7707y5;

    /* renamed from: yc  reason: collision with root package name */
    public static final Charset f7708yc;

    /* renamed from: yg  reason: collision with root package name */
    public static final HashMap<Integer, Integer> f7709yg;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, zn>[] f7712a;

    /* renamed from: c5  reason: collision with root package name */
    public boolean f7713c5;

    /* renamed from: co  reason: collision with root package name */
    public int f7714co;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7715f;

    /* renamed from: fb  reason: collision with root package name */
    public Set<Integer> f7716fb;

    /* renamed from: gv  reason: collision with root package name */
    public int f7717gv;

    /* renamed from: i9  reason: collision with root package name */
    public boolean f7718i9;

    /* renamed from: mt  reason: collision with root package name */
    public int f7719mt;

    /* renamed from: n3  reason: collision with root package name */
    public FileDescriptor f7720n3;

    /* renamed from: p  reason: collision with root package name */
    public int f7721p;

    /* renamed from: s  reason: collision with root package name */
    public ByteOrder f7722s;

    /* renamed from: t  reason: collision with root package name */
    public int f7723t;

    /* renamed from: tl  reason: collision with root package name */
    public int f7724tl;

    /* renamed from: v  reason: collision with root package name */
    public boolean f7725v;

    /* renamed from: w  reason: collision with root package name */
    public int f7726w;

    /* renamed from: wz  reason: collision with root package name */
    public byte[] f7727wz;

    /* renamed from: xc  reason: collision with root package name */
    public int f7728xc;
    public String y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f7729z;

    /* renamed from: zn  reason: collision with root package name */
    public AssetManager.AssetInputStream f7730zn;

    /* renamed from: r  reason: collision with root package name */
    public static final boolean f7692r = Log.isLoggable("ExifInterface", 3);

    /* renamed from: x4  reason: collision with root package name */
    public static final List<Integer> f7705x4 = Arrays.asList(1, 6, 3, 8);

    /* renamed from: i4  reason: collision with root package name */
    public static final List<Integer> f7675i4 = Arrays.asList(2, 7, 4, 5);

    /* renamed from: f3  reason: collision with root package name */
    public static final int[] f7669f3 = {8, 8, 8};

    /* renamed from: n  reason: collision with root package name */
    public static final int[] f7685n = {4};

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f7660c = {8};

    /* renamed from: d0  reason: collision with root package name */
    public static final byte[] f7663d0 = {-1, -40, -1};

    /* renamed from: fh  reason: collision with root package name */
    public static final byte[] f7671fh = {102, 116, 121, 112};

    /* renamed from: rz  reason: collision with root package name */
    public static final byte[] f7696rz = {109, 105, 102, 49};

    /* renamed from: mg  reason: collision with root package name */
    public static final byte[] f7684mg = {104, 101, 105, 99};

    /* renamed from: ta  reason: collision with root package name */
    public static final byte[] f7698ta = {79, 76, 89, 77, 80, 0};

    /* renamed from: d  reason: collision with root package name */
    public static final byte[] f7662d = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};

    /* renamed from: z6  reason: collision with root package name */
    public static final byte[] f7711z6 = {-119, 80, 78, 71, 13, 10, 26, 10};

    /* renamed from: ej  reason: collision with root package name */
    public static final byte[] f7667ej = {101, 88, 73, 102};

    /* renamed from: ud  reason: collision with root package name */
    public static final byte[] f7701ud = {73, 72, 68, 82};

    /* renamed from: a8  reason: collision with root package name */
    public static final byte[] f7657a8 = {73, 69, 78, 68};

    /* renamed from: x  reason: collision with root package name */
    public static final byte[] f7704x = {82, 73, 70, 70};

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f7659b = {87, 69, 66, 80};

    /* renamed from: k5  reason: collision with root package name */
    public static final byte[] f7680k5 = {69, 88, 73, 70};

    /* renamed from: yt  reason: collision with root package name */
    public static final byte[] f7710yt = {-99, 1, 42};

    /* renamed from: vl  reason: collision with root package name */
    public static final byte[] f7703vl = "VP8X".getBytes(Charset.defaultCharset());

    /* renamed from: hw  reason: collision with root package name */
    public static final byte[] f7674hw = "VP8L".getBytes(Charset.defaultCharset());

    /* renamed from: j5  reason: collision with root package name */
    public static final byte[] f7677j5 = "VP8 ".getBytes(Charset.defaultCharset());

    /* renamed from: qn  reason: collision with root package name */
    public static final byte[] f7691qn = "ANIM".getBytes(Charset.defaultCharset());

    /* renamed from: o  reason: collision with root package name */
    public static final byte[] f7687o = "ANMF".getBytes(Charset.defaultCharset());

    /* renamed from: ut  reason: collision with root package name */
    public static final String[] f7702ut = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};

    /* renamed from: q9  reason: collision with root package name */
    public static final int[] f7690q9 = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};

    /* renamed from: k  reason: collision with root package name */
    public static final byte[] f7679k = {65, 83, 67, 73, 73, 0, 0, 0};

    /* loaded from: classes.dex */
    public static class n3 extends InputStream implements DataInput {

        /* renamed from: f  reason: collision with root package name */
        public static final ByteOrder f7734f = ByteOrder.LITTLE_ENDIAN;

        /* renamed from: t  reason: collision with root package name */
        public static final ByteOrder f7735t = ByteOrder.BIG_ENDIAN;

        /* renamed from: fb  reason: collision with root package name */
        public final int f7736fb;

        /* renamed from: s  reason: collision with root package name */
        public int f7737s;

        /* renamed from: v  reason: collision with root package name */
        public ByteOrder f7738v;
        public DataInputStream y;

        public n3(InputStream inputStream) throws IOException {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.y.available();
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i) {
            this.y.mark(i);
        }

        public void mt(ByteOrder byteOrder) {
            this.f7738v = byteOrder;
        }

        public void p(long j2) throws IOException {
            int i = this.f7737s;
            if (i > j2) {
                this.f7737s = 0;
                this.y.reset();
                this.y.mark(this.f7736fb);
            } else {
                j2 -= i;
            }
            int i5 = (int) j2;
            if (skipBytes(i5) == i5) {
                return;
            }
            throw new IOException("Couldn't seek up to the byteCount");
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            this.f7737s++;
            return this.y.read();
        }

        @Override // java.io.DataInput
        public boolean readBoolean() throws IOException {
            this.f7737s++;
            return this.y.readBoolean();
        }

        @Override // java.io.DataInput
        public byte readByte() throws IOException {
            int i = this.f7737s + 1;
            this.f7737s = i;
            if (i <= this.f7736fb) {
                int read = this.y.read();
                if (read >= 0) {
                    return (byte) read;
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() throws IOException {
            this.f7737s += 2;
            return this.y.readChar();
        }

        @Override // java.io.DataInput
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i, int i5) throws IOException {
            int i6 = this.f7737s + i5;
            this.f7737s = i6;
            if (i6 <= this.f7736fb) {
                if (this.y.read(bArr, i, i5) != i5) {
                    throw new IOException("Couldn't read up to the length of buffer");
                }
                return;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public int readInt() throws IOException {
            int i = this.f7737s + 4;
            this.f7737s = i;
            if (i <= this.f7736fb) {
                int read = this.y.read();
                int read2 = this.y.read();
                int read3 = this.y.read();
                int read4 = this.y.read();
                if ((read | read2 | read3 | read4) >= 0) {
                    ByteOrder byteOrder = this.f7738v;
                    if (byteOrder == f7734f) {
                        return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                    }
                    if (byteOrder == f7735t) {
                        return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                    }
                    throw new IOException("Invalid byte order: " + this.f7738v);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public String readLine() throws IOException {
            return null;
        }

        @Override // java.io.DataInput
        public long readLong() throws IOException {
            int i = this.f7737s + 8;
            this.f7737s = i;
            if (i <= this.f7736fb) {
                int read = this.y.read();
                int read2 = this.y.read();
                int read3 = this.y.read();
                int read4 = this.y.read();
                int read5 = this.y.read();
                int read6 = this.y.read();
                int read7 = this.y.read();
                int read8 = this.y.read();
                if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                    ByteOrder byteOrder = this.f7738v;
                    if (byteOrder == f7734f) {
                        return (read8 << 56) + (read7 << 48) + (read6 << 40) + (read5 << 32) + (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                    }
                    if (byteOrder == f7735t) {
                        return (read << 56) + (read2 << 48) + (read3 << 40) + (read4 << 32) + (read5 << 24) + (read6 << 16) + (read7 << 8) + read8;
                    }
                    throw new IOException("Invalid byte order: " + this.f7738v);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public short readShort() throws IOException {
            int i = this.f7737s + 2;
            this.f7737s = i;
            if (i <= this.f7736fb) {
                int read = this.y.read();
                int read2 = this.y.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.f7738v;
                    if (byteOrder == f7734f) {
                        return (short) ((read2 << 8) + read);
                    }
                    if (byteOrder == f7735t) {
                        return (short) ((read << 8) + read2);
                    }
                    throw new IOException("Invalid byte order: " + this.f7738v);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public String readUTF() throws IOException {
            this.f7737s += 2;
            return this.y.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() throws IOException {
            this.f7737s++;
            return this.y.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() throws IOException {
            int i = this.f7737s + 2;
            this.f7737s = i;
            if (i <= this.f7736fb) {
                int read = this.y.read();
                int read2 = this.y.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.f7738v;
                    if (byteOrder == f7734f) {
                        return (read2 << 8) + read;
                    }
                    if (byteOrder == f7735t) {
                        return (read << 8) + read2;
                    }
                    throw new IOException("Invalid byte order: " + this.f7738v);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public long s() throws IOException {
            return readInt() & 4294967295L;
        }

        @Override // java.io.DataInput
        public int skipBytes(int i) throws IOException {
            int min = Math.min(i, this.f7736fb - this.f7737s);
            int i5 = 0;
            while (i5 < min) {
                i5 += this.y.skipBytes(min - i5);
            }
            this.f7737s += i5;
            return i5;
        }

        public int v() {
            return this.f7737s;
        }

        public int y() {
            return this.f7736fb;
        }

        public n3(InputStream inputStream, ByteOrder byteOrder) throws IOException {
            this.f7738v = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.y = dataInputStream;
            int available = dataInputStream.available();
            this.f7736fb = available;
            this.f7737s = 0;
            this.y.mark(available);
            this.f7738v = byteOrder;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i5) throws IOException {
            int read = this.y.read(bArr, i, i5);
            this.f7737s += read;
            return read;
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) throws IOException {
            int length = this.f7737s + bArr.length;
            this.f7737s = length;
            if (length <= this.f7736fb) {
                if (this.y.read(bArr, 0, bArr.length) != bArr.length) {
                    throw new IOException("Couldn't read up to the length of buffer");
                }
                return;
            }
            throw new EOFException();
        }

        public n3(byte[] bArr) throws IOException {
            this(new ByteArrayInputStream(bArr));
        }
    }

    /* loaded from: classes.dex */
    public static class v {

        /* renamed from: n3  reason: collision with root package name */
        public final long f7739n3;
        public final long y;

        public v(long j2, long j4) {
            if (j4 == 0) {
                this.y = 0L;
                this.f7739n3 = 1L;
                return;
            }
            this.y = j2;
            this.f7739n3 = j4;
        }

        public String toString() {
            return this.y + "/" + this.f7739n3;
        }

        public double y() {
            return this.y / this.f7739n3;
        }
    }

    /* loaded from: classes.dex */
    public static class zn {

        /* renamed from: gv  reason: collision with root package name */
        public final byte[] f7742gv;

        /* renamed from: n3  reason: collision with root package name */
        public final int f7743n3;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final long f7744zn;

        public zn(int i, int i5, byte[] bArr) {
            this(i, i5, -1L, bArr);
        }

        public static zn a(int i, ByteOrder byteOrder) {
            return fb(new int[]{i}, byteOrder);
        }

        public static zn fb(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[y.f7690q9[3] * iArr.length]);
            wrap.order(byteOrder);
            for (int i : iArr) {
                wrap.putShort((short) i);
            }
            return new zn(3, iArr.length, wrap.array());
        }

        public static zn gv(v vVar, ByteOrder byteOrder) {
            return v(new v[]{vVar}, byteOrder);
        }

        public static zn n3(long j2, ByteOrder byteOrder) {
            return zn(new long[]{j2}, byteOrder);
        }

        public static zn v(v[] vVarArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[y.f7690q9[5] * vVarArr.length]);
            wrap.order(byteOrder);
            for (v vVar : vVarArr) {
                wrap.putInt((int) vVar.y);
                wrap.putInt((int) vVar.f7739n3);
            }
            return new zn(5, vVarArr.length, wrap.array());
        }

        public static zn y(String str) {
            byte[] bytes = (str + (char) 0).getBytes(y.f7708yc);
            return new zn(2, bytes.length, bytes);
        }

        public static zn zn(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[y.f7690q9[4] * jArr.length]);
            wrap.order(byteOrder);
            for (long j2 : jArr) {
                wrap.putInt((int) j2);
            }
            return new zn(4, jArr.length, wrap.array());
        }

        public int c5(ByteOrder byteOrder) {
            Object f4 = f(byteOrder);
            if (f4 != null) {
                if (f4 instanceof String) {
                    return Integer.parseInt((String) f4);
                }
                if (f4 instanceof long[]) {
                    long[] jArr = (long[]) f4;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (f4 instanceof int[]) {
                    int[] iArr = (int[]) f4;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a integer value");
                }
            }
            throw new NumberFormatException("NULL can't be converted to a integer value");
        }

        /* JADX WARN: Not initialized variable reg: 5, insn: 0x0030: MOVE  (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:17:0x0030 */
        /* JADX WARN: Removed duplicated region for block: B:162:0x018f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object f(java.nio.ByteOrder r12) {
            /*
                Method dump skipped, instructions count: 436
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: en.y.zn.f(java.nio.ByteOrder):java.lang.Object");
        }

        public String i9(ByteOrder byteOrder) {
            Object f4 = f(byteOrder);
            if (f4 == null) {
                return null;
            }
            if (f4 instanceof String) {
                return (String) f4;
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            if (f4 instanceof long[]) {
                long[] jArr = (long[]) f4;
                while (i < jArr.length) {
                    sb.append(jArr[i]);
                    i++;
                    if (i != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (f4 instanceof int[]) {
                int[] iArr = (int[]) f4;
                while (i < iArr.length) {
                    sb.append(iArr[i]);
                    i++;
                    if (i != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (f4 instanceof double[]) {
                double[] dArr = (double[]) f4;
                while (i < dArr.length) {
                    sb.append(dArr[i]);
                    i++;
                    if (i != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (!(f4 instanceof v[])) {
                return null;
            } else {
                v[] vVarArr = (v[]) f4;
                while (i < vVarArr.length) {
                    sb.append(vVarArr[i].y);
                    sb.append('/');
                    sb.append(vVarArr[i].f7739n3);
                    i++;
                    if (i != vVarArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
        }

        public double s(ByteOrder byteOrder) {
            Object f4 = f(byteOrder);
            if (f4 != null) {
                if (f4 instanceof String) {
                    return Double.parseDouble((String) f4);
                }
                if (f4 instanceof long[]) {
                    long[] jArr = (long[]) f4;
                    if (jArr.length == 1) {
                        return jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (f4 instanceof int[]) {
                    int[] iArr = (int[]) f4;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (f4 instanceof double[]) {
                    double[] dArr = (double[]) f4;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (f4 instanceof v[]) {
                    v[] vVarArr = (v[]) f4;
                    if (vVarArr.length == 1) {
                        return vVarArr[0].y();
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a double value");
                }
            }
            throw new NumberFormatException("NULL can't be converted to a double value");
        }

        public String toString() {
            return "(" + y.f7702ut[this.y] + ", data length:" + this.f7742gv.length + ")";
        }

        public zn(int i, int i5, long j2, byte[] bArr) {
            this.y = i;
            this.f7743n3 = i5;
            this.f7744zn = j2;
            this.f7742gv = bArr;
        }
    }

    static {
        gv[] gvVarArr;
        gv[] gvVarArr2 = {new gv("NewSubfileType", 254, 4), new gv("SubfileType", 255, 4), new gv("ImageWidth", 256, 3, 4), new gv("ImageLength", 257, 3, 4), new gv("BitsPerSample", 258, 3), new gv("Compression", 259, 3), new gv("PhotometricInterpretation", 262, 3), new gv("ImageDescription", 270, 2), new gv("Make", 271, 2), new gv("Model", 272, 2), new gv("StripOffsets", 273, 3, 4), new gv("Orientation", 274, 3), new gv("SamplesPerPixel", 277, 3), new gv("RowsPerStrip", 278, 3, 4), new gv("StripByteCounts", 279, 3, 4), new gv("XResolution", 282, 5), new gv("YResolution", 283, 5), new gv("PlanarConfiguration", 284, 3), new gv("ResolutionUnit", 296, 3), new gv("TransferFunction", 301, 3), new gv("Software", 305, 2), new gv("DateTime", 306, 2), new gv("Artist", 315, 2), new gv("WhitePoint", 318, 5), new gv("PrimaryChromaticities", 319, 5), new gv("SubIFDPointer", 330, 4), new gv("JPEGInterchangeFormat", 513, 4), new gv("JPEGInterchangeFormatLength", 514, 4), new gv("YCbCrCoefficients", 529, 5), new gv("YCbCrSubSampling", 530, 3), new gv("YCbCrPositioning", 531, 3), new gv("ReferenceBlackWhite", 532, 5), new gv("Copyright", 33432, 2), new gv("ExifIFDPointer", 34665, 4), new gv("GPSInfoIFDPointer", 34853, 4), new gv("SensorTopBorder", 4, 4), new gv("SensorLeftBorder", 5, 4), new gv("SensorBottomBorder", 6, 4), new gv("SensorRightBorder", 7, 4), new gv("ISO", 23, 3), new gv("JpgFromRaw", 46, 7), new gv("Xmp", 700, 1)};
        f7670f7 = gvVarArr2;
        gv[] gvVarArr3 = {new gv("ExposureTime", 33434, 5), new gv("FNumber", 33437, 5), new gv("ExposureProgram", 34850, 3), new gv("SpectralSensitivity", 34852, 2), new gv("PhotographicSensitivity", 34855, 3), new gv("OECF", 34856, 7), new gv("SensitivityType", 34864, 3), new gv("StandardOutputSensitivity", 34865, 4), new gv("RecommendedExposureIndex", 34866, 4), new gv("ISOSpeed", 34867, 4), new gv("ISOSpeedLatitudeyyy", 34868, 4), new gv("ISOSpeedLatitudezzz", 34869, 4), new gv("ExifVersion", 36864, 2), new gv("DateTimeOriginal", 36867, 2), new gv("DateTimeDigitized", 36868, 2), new gv("OffsetTime", 36880, 2), new gv("OffsetTimeOriginal", 36881, 2), new gv("OffsetTimeDigitized", 36882, 2), new gv("ComponentsConfiguration", 37121, 7), new gv("CompressedBitsPerPixel", 37122, 5), new gv("ShutterSpeedValue", 37377, 10), new gv("ApertureValue", 37378, 5), new gv("BrightnessValue", 37379, 10), new gv("ExposureBiasValue", 37380, 10), new gv("MaxApertureValue", 37381, 5), new gv("SubjectDistance", 37382, 5), new gv("MeteringMode", 37383, 3), new gv("LightSource", 37384, 3), new gv("Flash", 37385, 3), new gv("FocalLength", 37386, 5), new gv("SubjectArea", 37396, 3), new gv("MakerNote", 37500, 7), new gv("UserComment", 37510, 7), new gv("SubSecTime", 37520, 2), new gv("SubSecTimeOriginal", 37521, 2), new gv("SubSecTimeDigitized", 37522, 2), new gv("FlashpixVersion", 40960, 7), new gv("ColorSpace", 40961, 3), new gv("PixelXDimension", 40962, 3, 4), new gv("PixelYDimension", 40963, 3, 4), new gv("RelatedSoundFile", 40964, 2), new gv("InteroperabilityIFDPointer", 40965, 4), new gv("FlashEnergy", 41483, 5), new gv("SpatialFrequencyResponse", 41484, 7), new gv("FocalPlaneXResolution", 41486, 5), new gv("FocalPlaneYResolution", 41487, 5), new gv("FocalPlaneResolutionUnit", 41488, 3), new gv("SubjectLocation", 41492, 3), new gv("ExposureIndex", 41493, 5), new gv("SensingMethod", 41495, 3), new gv("FileSource", 41728, 7), new gv("SceneType", 41729, 7), new gv("CFAPattern", 41730, 7), new gv("CustomRendered", 41985, 3), new gv("ExposureMode", 41986, 3), new gv("WhiteBalance", 41987, 3), new gv("DigitalZoomRatio", 41988, 5), new gv("FocalLengthIn35mmFilm", 41989, 3), new gv("SceneCaptureType", 41990, 3), new gv("GainControl", 41991, 3), new gv("Contrast", 41992, 3), new gv("Saturation", 41993, 3), new gv("Sharpness", 41994, 3), new gv("DeviceSettingDescription", 41995, 7), new gv("SubjectDistanceRange", 41996, 3), new gv("ImageUniqueID", 42016, 2), new gv("CameraOwnerName", 42032, 2), new gv("BodySerialNumber", 42033, 2), new gv("LensSpecification", 42034, 5), new gv("LensMake", 42035, 2), new gv("LensModel", 42036, 2), new gv("Gamma", 42240, 5), new gv("DNGVersion", 50706, 1), new gv("DefaultCropSize", 50720, 3, 4)};
        f7668en = gvVarArr3;
        gv[] gvVarArr4 = {new gv("GPSVersionID", 0, 1), new gv("GPSLatitudeRef", 1, 2), new gv("GPSLatitude", 2, 5, 10), new gv("GPSLongitudeRef", 3, 2), new gv("GPSLongitude", 4, 5, 10), new gv("GPSAltitudeRef", 5, 1), new gv("GPSAltitude", 6, 5), new gv("GPSTimeStamp", 7, 5), new gv("GPSSatellites", 8, 2), new gv("GPSStatus", 9, 2), new gv("GPSMeasureMode", 10, 2), new gv("GPSDOP", 11, 5), new gv("GPSSpeedRef", 12, 2), new gv("GPSSpeed", 13, 5), new gv("GPSTrackRef", 14, 2), new gv("GPSTrack", 15, 5), new gv("GPSImgDirectionRef", 16, 2), new gv("GPSImgDirection", 17, 5), new gv("GPSMapDatum", 18, 2), new gv("GPSDestLatitudeRef", 19, 2), new gv("GPSDestLatitude", 20, 5), new gv("GPSDestLongitudeRef", 21, 2), new gv("GPSDestLongitude", 22, 5), new gv("GPSDestBearingRef", 23, 2), new gv("GPSDestBearing", 24, 5), new gv("GPSDestDistanceRef", 25, 2), new gv("GPSDestDistance", 26, 5), new gv("GPSProcessingMethod", 27, 7), new gv("GPSAreaInformation", 28, 7), new gv("GPSDateStamp", 29, 2), new gv("GPSDifferential", 30, 3), new gv("GPSHPositioningError", 31, 5)};
        f7678jz = gvVarArr4;
        gv[] gvVarArr5 = {new gv("InteroperabilityIndex", 1, 2)};
        f7699u = gvVarArr5;
        gv[] gvVarArr6 = {new gv("NewSubfileType", 254, 4), new gv("SubfileType", 255, 4), new gv("ThumbnailImageWidth", 256, 3, 4), new gv("ThumbnailImageLength", 257, 3, 4), new gv("BitsPerSample", 258, 3), new gv("Compression", 259, 3), new gv("PhotometricInterpretation", 262, 3), new gv("ImageDescription", 270, 2), new gv("Make", 271, 2), new gv("Model", 272, 2), new gv("StripOffsets", 273, 3, 4), new gv("ThumbnailOrientation", 274, 3), new gv("SamplesPerPixel", 277, 3), new gv("RowsPerStrip", 278, 3, 4), new gv("StripByteCounts", 279, 3, 4), new gv("XResolution", 282, 5), new gv("YResolution", 283, 5), new gv("PlanarConfiguration", 284, 3), new gv("ResolutionUnit", 296, 3), new gv("TransferFunction", 301, 3), new gv("Software", 305, 2), new gv("DateTime", 306, 2), new gv("Artist", 315, 2), new gv("WhitePoint", 318, 5), new gv("PrimaryChromaticities", 319, 5), new gv("SubIFDPointer", 330, 4), new gv("JPEGInterchangeFormat", 513, 4), new gv("JPEGInterchangeFormatLength", 514, 4), new gv("YCbCrCoefficients", 529, 5), new gv("YCbCrSubSampling", 530, 3), new gv("YCbCrPositioning", 531, 3), new gv("ReferenceBlackWhite", 532, 5), new gv("Copyright", 33432, 2), new gv("ExifIFDPointer", 34665, 4), new gv("GPSInfoIFDPointer", 34853, 4), new gv("DNGVersion", 50706, 1), new gv("DefaultCropSize", 50720, 3, 4)};
        f7707y5 = gvVarArr6;
        f7706xg = new gv("StripOffsets", 273, 3);
        gv[] gvVarArr7 = {new gv("ThumbnailImage", 256, 7), new gv("CameraSettingsIFDPointer", 8224, 4), new gv("ImageProcessingIFDPointer", 8256, 4)};
        f7664dm = gvVarArr7;
        gv[] gvVarArr8 = {new gv("PreviewImageStart", 257, 4), new gv("PreviewImageLength", 258, 4)};
        f7661ct = gvVarArr8;
        gv[] gvVarArr9 = {new gv("AspectFrame", 4371, 3)};
        f7688o4 = gvVarArr9;
        gv[] gvVarArr10 = {new gv("ColorSpace", 55, 3)};
        f7695rs = gvVarArr10;
        gv[][] gvVarArr11 = {gvVarArr2, gvVarArr3, gvVarArr4, gvVarArr5, gvVarArr6, gvVarArr2, gvVarArr7, gvVarArr8, gvVarArr9, gvVarArr10};
        f7666eb = gvVarArr11;
        f7682lc = new gv[]{new gv("SubIFDPointer", 330, 4), new gv("ExifIFDPointer", 34665, 4), new gv("GPSInfoIFDPointer", 34853, 4), new gv("InteroperabilityIFDPointer", 40965, 4), new gv("CameraSettingsIFDPointer", 8224, 1), new gv("ImageProcessingIFDPointer", 8256, 1)};
        f7686nf = new gv("JPEGInterchangeFormat", 513, 4);
        f7693ra = new gv("JPEGInterchangeFormatLength", 514, 4);
        f7665e = new HashMap[gvVarArr11.length];
        f7697s8 = new HashMap[gvVarArr11.length];
        f7658ap = new HashSet<>(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        f7709yg = new HashMap<>();
        Charset forName = Charset.forName("US-ASCII");
        f7708yc = forName;
        f7681kp = "Exif\u0000\u0000".getBytes(forName);
        f7694rb = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(forName);
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale);
        f7676j = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        f7689oz = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
        int i = 0;
        while (true) {
            gv[][] gvVarArr12 = f7666eb;
            if (i < gvVarArr12.length) {
                f7665e[i] = new HashMap<>();
                f7697s8[i] = new HashMap<>();
                for (gv gvVar : gvVarArr12[i]) {
                    f7665e[i].put(Integer.valueOf(gvVar.y), gvVar);
                    f7697s8[i].put(gvVar.f7732n3, gvVar);
                }
                i++;
            } else {
                HashMap<Integer, Integer> hashMap = f7709yg;
                gv[] gvVarArr13 = f7682lc;
                hashMap.put(Integer.valueOf(gvVarArr13[0].y), 5);
                hashMap.put(Integer.valueOf(gvVarArr13[1].y), 1);
                hashMap.put(Integer.valueOf(gvVarArr13[2].y), 2);
                hashMap.put(Integer.valueOf(gvVarArr13[3].y), 3);
                hashMap.put(Integer.valueOf(gvVarArr13[4].y), 7);
                hashMap.put(Integer.valueOf(gvVarArr13[5].y), 8);
                f7673g3 = Pattern.compile(".*[1-9].*");
                f7683m = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                f7672g = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                f7700u0 = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
        }
    }

    public y(@NonNull InputStream inputStream) throws IOException {
        this(inputStream, 0);
    }

    public static boolean b(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length < bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr2.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean c(FileDescriptor fileDescriptor) {
        try {
            Os.lseek(fileDescriptor, 0L, OsConstants.SEEK_CUR);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean co(BufferedInputStream bufferedInputStream) throws IOException {
        byte[] bArr = f7681kp;
        bufferedInputStream.mark(bArr.length);
        byte[] bArr2 = new byte[bArr.length];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        int i = 0;
        while (true) {
            byte[] bArr3 = f7681kp;
            if (i < bArr3.length) {
                if (bArr2[i] != bArr3[i]) {
                    return false;
                }
                i++;
            } else {
                return true;
            }
        }
    }

    public static String n3(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            sb.append(String.format("%02x", Byte.valueOf(bArr[i])));
        }
        return sb.toString();
    }

    public static boolean r(byte[] bArr) throws IOException {
        int i = 0;
        while (true) {
            byte[] bArr2 = f7663d0;
            if (i < bArr2.length) {
                if (bArr[i] != bArr2[i]) {
                    return false;
                }
                i++;
            } else {
                return true;
            }
        }
    }

    public static long[] zn(Object obj) {
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            long[] jArr = new long[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                jArr[i] = iArr[i];
            }
            return jArr;
        } else if (obj instanceof long[]) {
            return (long[]) obj;
        } else {
            return null;
        }
    }

    @Nullable
    public final zn a(@NonNull String str) {
        if (str != null) {
            if ("ISOSpeedRatings".equals(str)) {
                str = "PhotographicSensitivity";
            }
            for (int i = 0; i < f7666eb.length; i++) {
                zn znVar = this.f7712a[i].get(str);
                if (znVar != null) {
                    return znVar;
                }
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    public final void a8(n3 n3Var, int i) throws IOException {
        zn znVar = this.f7712a[i].get("ImageLength");
        zn znVar2 = this.f7712a[i].get("ImageWidth");
        if (znVar == null || znVar2 == null) {
            zn znVar3 = this.f7712a[i].get("JPEGInterchangeFormat");
            zn znVar4 = this.f7712a[i].get("JPEGInterchangeFormatLength");
            if (znVar3 != null && znVar4 != null) {
                int c52 = znVar3.c5(this.f7722s);
                int c53 = znVar3.c5(this.f7722s);
                n3Var.p(c52);
                byte[] bArr = new byte[c53];
                n3Var.read(bArr);
                s(new n3(bArr), c52, i);
            }
        }
    }

    public final int c5(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (r(bArr)) {
            return 4;
        }
        if (f3(bArr)) {
            return 9;
        }
        if (z(bArr)) {
            return 12;
        }
        if (x4(bArr)) {
            return 7;
        }
        if (n(bArr)) {
            return 10;
        }
        if (i4(bArr)) {
            return 13;
        }
        if (rz(bArr)) {
            return 14;
        }
        return 0;
    }

    public final void d() {
        int i = 0;
        while (true) {
            HashMap<String, zn>[] hashMapArr = this.f7712a;
            if (i < hashMapArr.length) {
                for (Map.Entry<String, zn> entry : hashMapArr[i].entrySet()) {
                    entry.getValue();
                }
                i++;
            } else {
                return;
            }
        }
    }

    public final boolean d0(HashMap hashMap) throws IOException {
        zn znVar;
        zn znVar2 = (zn) hashMap.get("BitsPerSample");
        if (znVar2 != null) {
            int[] iArr = (int[]) znVar2.f(this.f7722s);
            int[] iArr2 = f7669f3;
            if (Arrays.equals(iArr2, iArr)) {
                return true;
            }
            if (this.f7717gv == 3 && (znVar = (zn) hashMap.get("PhotometricInterpretation")) != null) {
                int c52 = znVar.c5(this.f7722s);
                if ((c52 == 1 && Arrays.equals(iArr, f7660c)) || (c52 == 6 && Arrays.equals(iArr, iArr2))) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public final void ej(byte[] bArr, int i) throws IOException {
        n3 n3Var = new n3(bArr);
        ta(n3Var, bArr.length);
        ud(n3Var, i);
    }

    public final void f(n3 n3Var) throws IOException {
        n3Var.mark(0);
        n3Var.mt(ByteOrder.BIG_ENDIAN);
        byte[] bArr = f7711z6;
        n3Var.skipBytes(bArr.length);
        int length = bArr.length;
        while (true) {
            try {
                int readInt = n3Var.readInt();
                byte[] bArr2 = new byte[4];
                if (n3Var.read(bArr2) == 4) {
                    int i = length + 8;
                    if (i == 16 && !Arrays.equals(bArr2, f7701ud)) {
                        throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                    }
                    if (!Arrays.equals(bArr2, f7657a8)) {
                        if (Arrays.equals(bArr2, f7667ej)) {
                            byte[] bArr3 = new byte[readInt];
                            if (n3Var.read(bArr3) == readInt) {
                                int readInt2 = n3Var.readInt();
                                CRC32 crc32 = new CRC32();
                                crc32.update(bArr2);
                                crc32.update(bArr3);
                                if (((int) crc32.getValue()) == readInt2) {
                                    this.f7726w = i;
                                    ej(bArr3, 0);
                                    vl();
                                    x(new n3(bArr3));
                                    return;
                                }
                                throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + readInt2 + ", calculated CRC value: " + crc32.getValue());
                            }
                            throw new IOException("Failed to read given length for given PNG chunk type: " + n3(bArr2));
                        }
                        int i5 = readInt + 4;
                        n3Var.skipBytes(i5);
                        length = i + i5;
                    } else {
                        return;
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    public final boolean f3(byte[] bArr) throws IOException {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i = 0; i < bytes.length; i++) {
            if (bArr[i] != bytes[i]) {
                return false;
            }
        }
        return true;
    }

    public final void fb(n3 n3Var) throws IOException {
        String str;
        String str2;
        String str3;
        int i;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                mediaMetadataRetriever.setDataSource(new C0093y(n3Var));
            } else {
                FileDescriptor fileDescriptor = this.f7720n3;
                if (fileDescriptor != null) {
                    mediaMetadataRetriever.setDataSource(fileDescriptor);
                } else {
                    String str4 = this.y;
                    if (str4 != null) {
                        mediaMetadataRetriever.setDataSource(str4);
                    } else {
                        mediaMetadataRetriever.release();
                        return;
                    }
                }
            }
            String extractMetadata = mediaMetadataRetriever.extractMetadata(33);
            String extractMetadata2 = mediaMetadataRetriever.extractMetadata(34);
            String extractMetadata3 = mediaMetadataRetriever.extractMetadata(26);
            String extractMetadata4 = mediaMetadataRetriever.extractMetadata(17);
            if ("yes".equals(extractMetadata3)) {
                str = mediaMetadataRetriever.extractMetadata(29);
                str2 = mediaMetadataRetriever.extractMetadata(30);
                str3 = mediaMetadataRetriever.extractMetadata(31);
            } else if ("yes".equals(extractMetadata4)) {
                str = mediaMetadataRetriever.extractMetadata(18);
                str2 = mediaMetadataRetriever.extractMetadata(19);
                str3 = mediaMetadataRetriever.extractMetadata(24);
            } else {
                str = null;
                str2 = null;
                str3 = null;
            }
            if (str != null) {
                this.f7712a[0].put("ImageWidth", zn.a(Integer.parseInt(str), this.f7722s));
            }
            if (str2 != null) {
                this.f7712a[0].put("ImageLength", zn.a(Integer.parseInt(str2), this.f7722s));
            }
            if (str3 != null) {
                int parseInt = Integer.parseInt(str3);
                if (parseInt != 90) {
                    if (parseInt != 180) {
                        if (parseInt != 270) {
                            i = 1;
                        } else {
                            i = 8;
                        }
                    } else {
                        i = 3;
                    }
                } else {
                    i = 6;
                }
                this.f7712a[0].put("Orientation", zn.a(i, this.f7722s));
            }
            if (extractMetadata != null && extractMetadata2 != null) {
                int parseInt2 = Integer.parseInt(extractMetadata);
                int parseInt3 = Integer.parseInt(extractMetadata2);
                if (parseInt3 > 6) {
                    n3Var.p(parseInt2);
                    byte[] bArr = new byte[6];
                    if (n3Var.read(bArr) == 6) {
                        int i5 = parseInt2 + 6;
                        int i6 = parseInt3 - 6;
                        if (Arrays.equals(bArr, f7681kp)) {
                            byte[] bArr2 = new byte[i6];
                            if (n3Var.read(bArr2) == i6) {
                                this.f7726w = i5;
                                ej(bArr2, 0);
                            } else {
                                throw new IOException("Can't read exif");
                            }
                        } else {
                            throw new IOException("Invalid identifier");
                        }
                    } else {
                        throw new IOException("Can't read identifier");
                    }
                } else {
                    throw new IOException("Invalid exif length");
                }
            }
            mediaMetadataRetriever.release();
        } catch (Throwable th) {
            mediaMetadataRetriever.release();
            throw th;
        }
    }

    public final boolean fh(HashMap hashMap) throws IOException {
        zn znVar = (zn) hashMap.get("ImageLength");
        zn znVar2 = (zn) hashMap.get("ImageWidth");
        if (znVar != null && znVar2 != null) {
            int c52 = znVar.c5(this.f7722s);
            int c53 = znVar2.c5(this.f7722s);
            if (c52 <= 512 && c53 <= 512) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Nullable
    public String gv(@NonNull String str) {
        if (str != null) {
            zn a2 = a(str);
            if (a2 != null) {
                if (!f7658ap.contains(str)) {
                    return a2.i9(this.f7722s);
                }
                if (str.equals("GPSTimeStamp")) {
                    int i = a2.y;
                    if (i != 5 && i != 10) {
                        Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + a2.y);
                        return null;
                    }
                    v[] vVarArr = (v[]) a2.f(this.f7722s);
                    if (vVarArr != null && vVarArr.length == 3) {
                        v vVar = vVarArr[0];
                        Integer valueOf = Integer.valueOf((int) (((float) vVar.y) / ((float) vVar.f7739n3)));
                        v vVar2 = vVarArr[1];
                        Integer valueOf2 = Integer.valueOf((int) (((float) vVar2.y) / ((float) vVar2.f7739n3)));
                        v vVar3 = vVarArr[2];
                        return String.format("%02d:%02d:%02d", valueOf, valueOf2, Integer.valueOf((int) (((float) vVar3.y) / ((float) vVar3.f7739n3))));
                    }
                    Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(vVarArr));
                    return null;
                }
                try {
                    return Double.toString(a2.s(this.f7722s));
                } catch (NumberFormatException unused) {
                }
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    public final boolean i4(byte[] bArr) throws IOException {
        int i = 0;
        while (true) {
            byte[] bArr2 = f7711z6;
            if (i < bArr2.length) {
                if (bArr[i] != bArr2[i]) {
                    return false;
                }
                i++;
            } else {
                return true;
            }
        }
    }

    public final void i9(n3 n3Var) throws IOException {
        int i;
        int i5;
        tl(n3Var);
        zn znVar = this.f7712a[1].get("MakerNote");
        if (znVar != null) {
            n3 n3Var2 = new n3(znVar.f7742gv);
            n3Var2.mt(this.f7722s);
            byte[] bArr = f7698ta;
            byte[] bArr2 = new byte[bArr.length];
            n3Var2.readFully(bArr2);
            n3Var2.p(0L);
            byte[] bArr3 = f7662d;
            byte[] bArr4 = new byte[bArr3.length];
            n3Var2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                n3Var2.p(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                n3Var2.p(12L);
            }
            ud(n3Var2, 6);
            zn znVar2 = this.f7712a[7].get("PreviewImageStart");
            zn znVar3 = this.f7712a[7].get("PreviewImageLength");
            if (znVar2 != null && znVar3 != null) {
                this.f7712a[5].put("JPEGInterchangeFormat", znVar2);
                this.f7712a[5].put("JPEGInterchangeFormatLength", znVar3);
            }
            zn znVar4 = this.f7712a[8].get("AspectFrame");
            if (znVar4 != null) {
                int[] iArr = (int[]) znVar4.f(this.f7722s);
                if (iArr != null && iArr.length == 4) {
                    int i6 = iArr[2];
                    int i8 = iArr[0];
                    if (i6 > i8 && (i = iArr[3]) > (i5 = iArr[1])) {
                        int i10 = (i6 - i8) + 1;
                        int i11 = (i - i5) + 1;
                        if (i10 < i11) {
                            int i12 = i10 + i11;
                            i11 = i12 - i11;
                            i10 = i12 - i11;
                        }
                        zn a2 = zn.a(i10, this.f7722s);
                        zn a3 = zn.a(i11, this.f7722s);
                        this.f7712a[0].put("ImageWidth", a2);
                        this.f7712a[0].put("ImageLength", a3);
                        return;
                    }
                    return;
                }
                Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
            }
        }
    }

    public final void k5(int i, int i5) throws IOException {
        if (!this.f7712a[i].isEmpty() && !this.f7712a[i5].isEmpty()) {
            zn znVar = this.f7712a[i].get("ImageLength");
            zn znVar2 = this.f7712a[i].get("ImageWidth");
            zn znVar3 = this.f7712a[i5].get("ImageLength");
            zn znVar4 = this.f7712a[i5].get("ImageWidth");
            if (znVar != null && znVar2 != null && znVar3 != null && znVar4 != null) {
                int c52 = znVar.c5(this.f7722s);
                int c53 = znVar2.c5(this.f7722s);
                int c54 = znVar3.c5(this.f7722s);
                int c55 = znVar4.c5(this.f7722s);
                if (c52 < c54 && c53 < c55) {
                    HashMap<String, zn>[] hashMapArr = this.f7712a;
                    HashMap<String, zn> hashMap = hashMapArr[i];
                    hashMapArr[i] = hashMapArr[i5];
                    hashMapArr[i5] = hashMap;
                }
            }
        }
    }

    public final void mg(@NonNull InputStream inputStream) {
        if (inputStream != null) {
            for (int i = 0; i < f7666eb.length; i++) {
                try {
                    try {
                        this.f7712a[i] = new HashMap<>();
                    } catch (IOException e2) {
                        boolean z2 = f7692r;
                        if (z2) {
                            Log.w("ExifInterface", "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e2);
                        }
                        y();
                        if (!z2) {
                            return;
                        }
                    }
                } catch (Throwable th) {
                    y();
                    if (f7692r) {
                        d();
                    }
                    throw th;
                }
            }
            if (!this.f7725v) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
                this.f7717gv = c5(bufferedInputStream);
                inputStream = bufferedInputStream;
            }
            n3 n3Var = new n3(inputStream);
            if (!this.f7725v) {
                switch (this.f7717gv) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 11:
                        tl(n3Var);
                        break;
                    case 4:
                        s(n3Var, 0, 0);
                        y();
                        if (f7692r) {
                            d();
                            return;
                        }
                        return;
                    case 7:
                        i9(n3Var);
                        break;
                    case 9:
                        t(n3Var);
                        y();
                        if (f7692r) {
                            d();
                            return;
                        }
                        return;
                    case 10:
                        wz(n3Var);
                        y();
                        if (f7692r) {
                            d();
                            return;
                        }
                        return;
                    case 12:
                        fb(n3Var);
                        break;
                    case 13:
                        f(n3Var);
                        y();
                        if (f7692r) {
                            d();
                            return;
                        }
                        return;
                    case 14:
                        w(n3Var);
                        y();
                        if (f7692r) {
                            d();
                            return;
                        }
                        return;
                }
            } else {
                xc(n3Var);
            }
            n3Var.p(this.f7726w);
            x(n3Var);
            y();
            if (!f7692r) {
                return;
            }
            d();
            return;
        }
        throw new NullPointerException("inputstream shouldn't be null");
    }

    public final void mt(n3 n3Var, HashMap hashMap) throws IOException {
        zn znVar = (zn) hashMap.get("StripOffsets");
        zn znVar2 = (zn) hashMap.get("StripByteCounts");
        if (znVar != null && znVar2 != null) {
            long[] zn2 = zn(znVar.f(this.f7722s));
            long[] zn3 = zn(znVar2.f(this.f7722s));
            if (zn2 != null && zn2.length != 0) {
                if (zn3 != null && zn3.length != 0) {
                    if (zn2.length != zn3.length) {
                        Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
                        return;
                    }
                    long j2 = 0;
                    for (long j4 : zn3) {
                        j2 += j4;
                    }
                    int i = (int) j2;
                    byte[] bArr = new byte[i];
                    this.f7715f = true;
                    this.f7718i9 = true;
                    this.f7713c5 = true;
                    int i5 = 0;
                    int i6 = 0;
                    for (int i8 = 0; i8 < zn2.length; i8++) {
                        int i10 = (int) zn2[i8];
                        int i11 = (int) zn3[i8];
                        if (i8 < zn2.length - 1 && i10 + i11 != zn2[i8 + 1]) {
                            this.f7715f = false;
                        }
                        int i12 = i10 - i5;
                        if (i12 < 0) {
                            return;
                        }
                        long j6 = i12;
                        if (n3Var.skip(j6) != j6) {
                            return;
                        }
                        int i13 = i5 + i12;
                        byte[] bArr2 = new byte[i11];
                        if (n3Var.read(bArr2) != i11) {
                            return;
                        }
                        i5 = i13 + i11;
                        System.arraycopy(bArr2, 0, bArr, i6, i11);
                        i6 += i11;
                    }
                    this.f7727wz = bArr;
                    if (this.f7715f) {
                        this.f7723t = (int) zn2[0];
                        this.f7724tl = i;
                        return;
                    }
                    return;
                }
                Log.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
                return;
            }
            Log.w("ExifInterface", "stripOffsets should not be null or have zero length.");
        }
    }

    public final boolean n(byte[] bArr) throws IOException {
        boolean z2 = false;
        n3 n3Var = null;
        try {
            n3 n3Var2 = new n3(bArr);
            try {
                ByteOrder z62 = z6(n3Var2);
                this.f7722s = z62;
                n3Var2.mt(z62);
                if (n3Var2.readShort() == 85) {
                    z2 = true;
                }
                n3Var2.close();
                return z2;
            } catch (Exception unused) {
                n3Var = n3Var2;
                if (n3Var != null) {
                    n3Var.close();
                }
                return false;
            } catch (Throwable th) {
                th = th;
                n3Var = n3Var2;
                if (n3Var != null) {
                    n3Var.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void p(n3 n3Var, HashMap hashMap) throws IOException {
        zn znVar = (zn) hashMap.get("JPEGInterchangeFormat");
        zn znVar2 = (zn) hashMap.get("JPEGInterchangeFormatLength");
        if (znVar != null && znVar2 != null) {
            int c52 = znVar.c5(this.f7722s);
            int c53 = znVar2.c5(this.f7722s);
            if (this.f7717gv == 7) {
                c52 += this.f7721p;
            }
            int min = Math.min(c53, n3Var.y() - c52);
            if (c52 > 0 && min > 0) {
                this.f7713c5 = true;
                if (this.y == null && this.f7730zn == null && this.f7720n3 == null) {
                    byte[] bArr = new byte[min];
                    n3Var.skip(c52);
                    n3Var.read(bArr);
                    this.f7727wz = bArr;
                }
                this.f7723t = c52;
                this.f7724tl = min;
            }
        }
    }

    public final boolean rz(byte[] bArr) throws IOException {
        int i = 0;
        while (true) {
            byte[] bArr2 = f7704x;
            if (i < bArr2.length) {
                if (bArr[i] != bArr2[i]) {
                    return false;
                }
                i++;
            } else {
                int i5 = 0;
                while (true) {
                    byte[] bArr3 = f7659b;
                    if (i5 < bArr3.length) {
                        if (bArr[f7704x.length + i5 + 4] != bArr3[i5]) {
                            return false;
                        }
                        i5++;
                    } else {
                        return true;
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x0135, code lost:
        r19.mt(r18.f7722s);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x013a, code lost:
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0057 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0129 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s(en.y.n3 r19, int r20, int r21) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 440
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: en.y.s(en.y$n3, int, int):void");
    }

    public final void t(n3 n3Var) throws IOException {
        n3Var.mark(0);
        n3Var.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        n3Var.read(bArr);
        n3Var.read(bArr2);
        n3Var.read(bArr3);
        int i = ByteBuffer.wrap(bArr).getInt();
        int i5 = ByteBuffer.wrap(bArr2).getInt();
        int i6 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i5];
        n3Var.p(i);
        n3Var.read(bArr4);
        s(new n3(bArr4), i, 5);
        n3Var.p(i6);
        n3Var.mt(ByteOrder.BIG_ENDIAN);
        int readInt = n3Var.readInt();
        for (int i8 = 0; i8 < readInt; i8++) {
            int readUnsignedShort = n3Var.readUnsignedShort();
            int readUnsignedShort2 = n3Var.readUnsignedShort();
            if (readUnsignedShort == f7706xg.y) {
                short readShort = n3Var.readShort();
                short readShort2 = n3Var.readShort();
                zn a2 = zn.a(readShort, this.f7722s);
                zn a3 = zn.a(readShort2, this.f7722s);
                this.f7712a[0].put("ImageLength", a2);
                this.f7712a[0].put("ImageWidth", a3);
                return;
            }
            n3Var.skipBytes(readUnsignedShort2);
        }
    }

    public final void ta(n3 n3Var, int i) throws IOException {
        ByteOrder z62 = z6(n3Var);
        this.f7722s = z62;
        n3Var.mt(z62);
        int readUnsignedShort = n3Var.readUnsignedShort();
        int i5 = this.f7717gv;
        if (i5 != 7 && i5 != 10 && readUnsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
        }
        int readInt = n3Var.readInt();
        if (readInt >= 8 && readInt < i) {
            int i6 = readInt - 8;
            if (i6 > 0 && n3Var.skipBytes(i6) != i6) {
                throw new IOException("Couldn't jump to first Ifd: " + i6);
            }
            return;
        }
        throw new IOException("Invalid first Ifd offset: " + readInt);
    }

    public final void tl(n3 n3Var) throws IOException {
        zn znVar;
        ta(n3Var, n3Var.available());
        ud(n3Var, 0);
        yt(n3Var, 0);
        yt(n3Var, 5);
        yt(n3Var, 4);
        vl();
        if (this.f7717gv == 8 && (znVar = this.f7712a[1].get("MakerNote")) != null) {
            n3 n3Var2 = new n3(znVar.f7742gv);
            n3Var2.mt(this.f7722s);
            n3Var2.p(6L);
            ud(n3Var2, 9);
            zn znVar2 = this.f7712a[9].get("ColorSpace");
            if (znVar2 != null) {
                this.f7712a[1].put("ColorSpace", znVar2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0144  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void ud(en.y.n3 r27, int r28) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 640
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: en.y.ud(en.y$n3, int):void");
    }

    public int v(@NonNull String str, int i) {
        if (str != null) {
            zn a2 = a(str);
            if (a2 == null) {
                return i;
            }
            try {
                return a2.c5(this.f7722s);
            } catch (NumberFormatException unused) {
                return i;
            }
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    public final void vl() throws IOException {
        k5(0, 5);
        k5(0, 4);
        k5(5, 4);
        zn znVar = this.f7712a[1].get("PixelXDimension");
        zn znVar2 = this.f7712a[1].get("PixelYDimension");
        if (znVar != null && znVar2 != null) {
            this.f7712a[0].put("ImageWidth", znVar);
            this.f7712a[0].put("ImageLength", znVar2);
        }
        if (this.f7712a[4].isEmpty() && fh(this.f7712a[5])) {
            HashMap<String, zn>[] hashMapArr = this.f7712a;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap<>();
        }
        fh(this.f7712a[4]);
    }

    public final void w(n3 n3Var) throws IOException {
        n3Var.mark(0);
        n3Var.mt(ByteOrder.LITTLE_ENDIAN);
        n3Var.skipBytes(f7704x.length);
        int readInt = n3Var.readInt() + 8;
        int skipBytes = n3Var.skipBytes(f7659b.length) + 8;
        while (true) {
            try {
                byte[] bArr = new byte[4];
                if (n3Var.read(bArr) == 4) {
                    int readInt2 = n3Var.readInt();
                    int i = skipBytes + 8;
                    if (Arrays.equals(f7680k5, bArr)) {
                        byte[] bArr2 = new byte[readInt2];
                        if (n3Var.read(bArr2) == readInt2) {
                            this.f7726w = i;
                            ej(bArr2, 0);
                            x(new n3(bArr2));
                            return;
                        }
                        throw new IOException("Failed to read given length for given PNG chunk type: " + n3(bArr));
                    }
                    if (readInt2 % 2 == 1) {
                        readInt2++;
                    }
                    int i5 = i + readInt2;
                    if (i5 == readInt) {
                        return;
                    }
                    if (i5 <= readInt) {
                        int skipBytes2 = n3Var.skipBytes(readInt2);
                        if (skipBytes2 == readInt2) {
                            skipBytes = i + skipBytes2;
                        } else {
                            throw new IOException("Encountered WebP file with invalid chunk size");
                        }
                    } else {
                        throw new IOException("Encountered WebP file with invalid chunk size");
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    public final void wz(n3 n3Var) throws IOException {
        tl(n3Var);
        zn znVar = this.f7712a[0].get("JpgFromRaw");
        if (znVar != null) {
            s(new n3(znVar.f7742gv), (int) znVar.f7744zn, 5);
        }
        zn znVar2 = this.f7712a[0].get("ISO");
        zn znVar3 = this.f7712a[1].get("PhotographicSensitivity");
        if (znVar2 != null && znVar3 == null) {
            this.f7712a[1].put("PhotographicSensitivity", znVar2);
        }
    }

    public final void x(n3 n3Var) throws IOException {
        HashMap<String, zn> hashMap = this.f7712a[4];
        zn znVar = hashMap.get("Compression");
        if (znVar != null) {
            int c52 = znVar.c5(this.f7722s);
            this.f7728xc = c52;
            if (c52 != 1) {
                if (c52 != 6) {
                    if (c52 != 7) {
                        return;
                    }
                } else {
                    p(n3Var, hashMap);
                    return;
                }
            }
            if (d0(hashMap)) {
                mt(n3Var, hashMap);
                return;
            }
            return;
        }
        this.f7728xc = 6;
        p(n3Var, hashMap);
    }

    public final boolean x4(byte[] bArr) throws IOException {
        boolean z2 = false;
        n3 n3Var = null;
        try {
            n3 n3Var2 = new n3(bArr);
            try {
                ByteOrder z62 = z6(n3Var2);
                this.f7722s = z62;
                n3Var2.mt(z62);
                short readShort = n3Var2.readShort();
                z2 = (readShort == 20306 || readShort == 21330) ? true : true;
                n3Var2.close();
                return z2;
            } catch (Exception unused) {
                n3Var = n3Var2;
                if (n3Var != null) {
                    n3Var.close();
                }
                return false;
            } catch (Throwable th) {
                th = th;
                n3Var = n3Var2;
                if (n3Var != null) {
                    n3Var.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void xc(n3 n3Var) throws IOException {
        byte[] bArr = f7681kp;
        n3Var.skipBytes(bArr.length);
        byte[] bArr2 = new byte[n3Var.available()];
        n3Var.readFully(bArr2);
        this.f7726w = bArr.length;
        ej(bArr2, 0);
    }

    public final void y() {
        String gv2 = gv("DateTimeOriginal");
        if (gv2 != null && gv("DateTime") == null) {
            this.f7712a[0].put("DateTime", zn.y(gv2));
        }
        if (gv("ImageWidth") == null) {
            this.f7712a[0].put("ImageWidth", zn.n3(0L, this.f7722s));
        }
        if (gv("ImageLength") == null) {
            this.f7712a[0].put("ImageLength", zn.n3(0L, this.f7722s));
        }
        if (gv("Orientation") == null) {
            this.f7712a[0].put("Orientation", zn.n3(0L, this.f7722s));
        }
        if (gv("LightSource") == null) {
            this.f7712a[1].put("LightSource", zn.n3(0L, this.f7722s));
        }
    }

    public final void yt(n3 n3Var, int i) throws IOException {
        zn a2;
        zn a3;
        zn znVar = this.f7712a[i].get("DefaultCropSize");
        zn znVar2 = this.f7712a[i].get("SensorTopBorder");
        zn znVar3 = this.f7712a[i].get("SensorLeftBorder");
        zn znVar4 = this.f7712a[i].get("SensorBottomBorder");
        zn znVar5 = this.f7712a[i].get("SensorRightBorder");
        if (znVar != null) {
            if (znVar.y == 5) {
                v[] vVarArr = (v[]) znVar.f(this.f7722s);
                if (vVarArr != null && vVarArr.length == 2) {
                    a2 = zn.gv(vVarArr[0], this.f7722s);
                    a3 = zn.gv(vVarArr[1], this.f7722s);
                } else {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(vVarArr));
                    return;
                }
            } else {
                int[] iArr = (int[]) znVar.f(this.f7722s);
                if (iArr != null && iArr.length == 2) {
                    a2 = zn.a(iArr[0], this.f7722s);
                    a3 = zn.a(iArr[1], this.f7722s);
                } else {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                    return;
                }
            }
            this.f7712a[i].put("ImageWidth", a2);
            this.f7712a[i].put("ImageLength", a3);
        } else if (znVar2 != null && znVar3 != null && znVar4 != null && znVar5 != null) {
            int c52 = znVar2.c5(this.f7722s);
            int c53 = znVar4.c5(this.f7722s);
            int c54 = znVar5.c5(this.f7722s);
            int c55 = znVar3.c5(this.f7722s);
            if (c53 > c52 && c54 > c55) {
                zn a4 = zn.a(c53 - c52, this.f7722s);
                zn a5 = zn.a(c54 - c55, this.f7722s);
                this.f7712a[i].put("ImageLength", a4);
                this.f7712a[i].put("ImageWidth", a5);
            }
        } else {
            a8(n3Var, i);
        }
    }

    public final boolean z(byte[] bArr) throws IOException {
        n3 n3Var;
        long readInt;
        byte[] bArr2;
        long j2;
        n3 n3Var2 = null;
        try {
            n3Var = new n3(bArr);
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            readInt = n3Var.readInt();
            bArr2 = new byte[4];
            n3Var.read(bArr2);
        } catch (Exception unused2) {
            n3Var2 = n3Var;
            if (n3Var2 != null) {
                n3Var2.close();
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            n3Var2 = n3Var;
            if (n3Var2 != null) {
                n3Var2.close();
            }
            throw th;
        }
        if (!Arrays.equals(bArr2, f7671fh)) {
            n3Var.close();
            return false;
        }
        if (readInt == 1) {
            readInt = n3Var.readLong();
            j2 = 16;
            if (readInt < 16) {
                n3Var.close();
                return false;
            }
        } else {
            j2 = 8;
        }
        if (readInt > bArr.length) {
            readInt = bArr.length;
        }
        long j4 = readInt - j2;
        if (j4 < 8) {
            n3Var.close();
            return false;
        }
        byte[] bArr3 = new byte[4];
        boolean z2 = false;
        boolean z3 = false;
        for (long j6 = 0; j6 < j4 / 4; j6++) {
            if (n3Var.read(bArr3) != 4) {
                n3Var.close();
                return false;
            }
            if (j6 != 1) {
                if (Arrays.equals(bArr3, f7696rz)) {
                    z2 = true;
                } else if (Arrays.equals(bArr3, f7684mg)) {
                    z3 = true;
                }
                if (z2 && z3) {
                    n3Var.close();
                    return true;
                }
            }
        }
        n3Var.close();
        return false;
    }

    public final ByteOrder z6(n3 n3Var) throws IOException {
        short readShort = n3Var.readShort();
        if (readShort != 18761) {
            if (readShort == 19789) {
                return ByteOrder.BIG_ENDIAN;
            }
            throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
        }
        return ByteOrder.LITTLE_ENDIAN;
    }

    public y(@NonNull InputStream inputStream, int i) throws IOException {
        gv[][] gvVarArr = f7666eb;
        this.f7712a = new HashMap[gvVarArr.length];
        this.f7716fb = new HashSet(gvVarArr.length);
        this.f7722s = ByteOrder.BIG_ENDIAN;
        if (inputStream != null) {
            this.y = null;
            if (i == 1) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
                if (!co(bufferedInputStream)) {
                    Log.w("ExifInterface", "Given data does not follow the structure of an Exif-only data.");
                    return;
                }
                this.f7725v = true;
                this.f7730zn = null;
                this.f7720n3 = null;
                inputStream = bufferedInputStream;
            } else if (inputStream instanceof AssetManager.AssetInputStream) {
                this.f7730zn = (AssetManager.AssetInputStream) inputStream;
                this.f7720n3 = null;
            } else {
                if (inputStream instanceof FileInputStream) {
                    FileInputStream fileInputStream = (FileInputStream) inputStream;
                    if (c(fileInputStream.getFD())) {
                        this.f7730zn = null;
                        this.f7720n3 = fileInputStream.getFD();
                    }
                }
                this.f7730zn = null;
                this.f7720n3 = null;
            }
            mg(inputStream);
            return;
        }
        throw new NullPointerException("inputStream cannot be null");
    }

    /* loaded from: classes.dex */
    public static class gv {

        /* renamed from: gv  reason: collision with root package name */
        public final int f7731gv;

        /* renamed from: n3  reason: collision with root package name */
        public final String f7732n3;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f7733zn;

        public gv(String str, int i, int i5) {
            this.f7732n3 = str;
            this.y = i;
            this.f7733zn = i5;
            this.f7731gv = -1;
        }

        public boolean y(int i) {
            int i5;
            int i6 = this.f7733zn;
            if (i6 == 7 || i == 7 || i6 == i || (i5 = this.f7731gv) == i) {
                return true;
            }
            if ((i6 == 4 || i5 == 4) && i == 3) {
                return true;
            }
            if ((i6 == 9 || i5 == 9) && i == 8) {
                return true;
            }
            if ((i6 == 12 || i5 == 12) && i == 11) {
                return true;
            }
            return false;
        }

        public gv(String str, int i, int i5, int i6) {
            this.f7732n3 = str;
            this.y = i;
            this.f7733zn = i5;
            this.f7731gv = i6;
        }
    }

    /* renamed from: en.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0093y extends MediaDataSource {

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ n3 f7741v;
        public long y;

        public C0093y(n3 n3Var) {
            this.f7741v = n3Var;
        }

        @Override // android.media.MediaDataSource
        public long getSize() throws IOException {
            return -1L;
        }

        @Override // android.media.MediaDataSource
        public int readAt(long j2, byte[] bArr, int i, int i5) throws IOException {
            if (i5 == 0) {
                return 0;
            }
            if (j2 < 0) {
                return -1;
            }
            try {
                long j4 = this.y;
                if (j4 != j2) {
                    if (j4 >= 0 && j2 >= j4 + this.f7741v.available()) {
                        return -1;
                    }
                    this.f7741v.p(j2);
                    this.y = j2;
                }
                if (i5 > this.f7741v.available()) {
                    i5 = this.f7741v.available();
                }
                int read = this.f7741v.read(bArr, i, i5);
                if (read >= 0) {
                    this.y += read;
                    return read;
                }
            } catch (IOException unused) {
            }
            this.y = -1L;
            return -1;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }
    }
}
