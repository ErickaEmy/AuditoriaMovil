package com.google.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class UnsafeUtil {

    /* renamed from: c5  reason: collision with root package name */
    public static final long f6549c5;

    /* renamed from: co  reason: collision with root package name */
    public static final long f6550co;

    /* renamed from: f  reason: collision with root package name */
    public static final long f6551f;

    /* renamed from: i4  reason: collision with root package name */
    public static final boolean f6554i4;

    /* renamed from: i9  reason: collision with root package name */
    public static final long f6555i9;

    /* renamed from: mt  reason: collision with root package name */
    public static final long f6556mt;

    /* renamed from: p  reason: collision with root package name */
    public static final long f6558p;

    /* renamed from: r  reason: collision with root package name */
    public static final long f6559r;

    /* renamed from: s  reason: collision with root package name */
    public static final long f6560s;

    /* renamed from: t  reason: collision with root package name */
    public static final long f6561t;

    /* renamed from: tl  reason: collision with root package name */
    public static final long f6562tl;

    /* renamed from: w  reason: collision with root package name */
    public static final long f6564w;

    /* renamed from: wz  reason: collision with root package name */
    public static final long f6565wz;

    /* renamed from: x4  reason: collision with root package name */
    public static final int f6566x4;

    /* renamed from: xc  reason: collision with root package name */
    public static final long f6567xc;

    /* renamed from: z  reason: collision with root package name */
    public static final long f6568z;
    public static final Unsafe y = ud();

    /* renamed from: n3  reason: collision with root package name */
    public static final Class<?> f6557n3 = Android.n3();

    /* renamed from: zn  reason: collision with root package name */
    public static final boolean f6569zn = mt(Long.TYPE);

    /* renamed from: gv  reason: collision with root package name */
    public static final boolean f6553gv = mt(Integer.TYPE);

    /* renamed from: v  reason: collision with root package name */
    public static final MemoryAccessor f6563v = z6();

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f6548a = jz();

    /* renamed from: fb  reason: collision with root package name */
    public static final boolean f6552fb = en();

    /* loaded from: classes.dex */
    public static final class Android32MemoryAccessor extends MemoryAccessor {
        public Android32MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(long j2, byte[] bArr, long j4, long j6) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean getBoolean(Object obj, long j2) {
            return UnsafeUtil.f6554i4 ? UnsafeUtil.x4(obj, j2) : UnsafeUtil.i4(obj, j2);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(Object obj, long j2) {
            return UnsafeUtil.f6554i4 ? UnsafeUtil.c(obj, j2) : UnsafeUtil.d0(obj, j2);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public double getDouble(Object obj, long j2) {
            return Double.longBitsToDouble(getLong(obj, j2));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public float getFloat(Object obj, long j2) {
            return Float.intBitsToFloat(getInt(obj, j2));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public int getInt(long j2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public long getLong(long j2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public Object getStaticObject(Field field) {
            try {
                return field.get(null);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putBoolean(Object obj, long j2, boolean z2) {
            if (UnsafeUtil.f6554i4) {
                UnsafeUtil.vl(obj, j2, z2);
            } else {
                UnsafeUtil.hw(obj, j2, z2);
            }
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(Object obj, long j2, byte b2) {
            if (UnsafeUtil.f6554i4) {
                UnsafeUtil.o(obj, j2, b2);
            } else {
                UnsafeUtil.j(obj, j2, b2);
            }
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putDouble(Object obj, long j2, double d2) {
            putLong(obj, j2, Double.doubleToLongBits(d2));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putFloat(Object obj, long j2, float f4) {
            putInt(obj, j2, Float.floatToIntBits(f4));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putInt(long j2, int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putLong(long j2, long j4) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean supportsUnsafeByteBufferOperations() {
            return false;
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(byte[] bArr, long j2, long j4, long j6) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(long j2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(long j2, byte b2) {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes.dex */
    public static final class Android64MemoryAccessor extends MemoryAccessor {
        public Android64MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(long j2, byte[] bArr, long j4, long j6) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean getBoolean(Object obj, long j2) {
            return UnsafeUtil.f6554i4 ? UnsafeUtil.x4(obj, j2) : UnsafeUtil.i4(obj, j2);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(Object obj, long j2) {
            return UnsafeUtil.f6554i4 ? UnsafeUtil.c(obj, j2) : UnsafeUtil.d0(obj, j2);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public double getDouble(Object obj, long j2) {
            return Double.longBitsToDouble(getLong(obj, j2));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public float getFloat(Object obj, long j2) {
            return Float.intBitsToFloat(getInt(obj, j2));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public int getInt(long j2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public long getLong(long j2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public Object getStaticObject(Field field) {
            try {
                return field.get(null);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putBoolean(Object obj, long j2, boolean z2) {
            if (UnsafeUtil.f6554i4) {
                UnsafeUtil.vl(obj, j2, z2);
            } else {
                UnsafeUtil.hw(obj, j2, z2);
            }
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(Object obj, long j2, byte b2) {
            if (UnsafeUtil.f6554i4) {
                UnsafeUtil.o(obj, j2, b2);
            } else {
                UnsafeUtil.j(obj, j2, b2);
            }
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putDouble(Object obj, long j2, double d2) {
            putLong(obj, j2, Double.doubleToLongBits(d2));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putFloat(Object obj, long j2, float f4) {
            putInt(obj, j2, Float.floatToIntBits(f4));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putInt(long j2, int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putLong(long j2, long j4) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean supportsUnsafeByteBufferOperations() {
            return false;
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(byte[] bArr, long j2, long j4, long j6) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(long j2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(long j2, byte b2) {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes.dex */
    public static final class JvmMemoryAccessor extends MemoryAccessor {
        public JvmMemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(long j2, byte[] bArr, long j4, long j6) {
            this.y.copyMemory((Object) null, j2, bArr, UnsafeUtil.f6560s + j4, j6);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean getBoolean(Object obj, long j2) {
            return this.y.getBoolean(obj, j2);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(Object obj, long j2) {
            return this.y.getByte(obj, j2);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public double getDouble(Object obj, long j2) {
            return this.y.getDouble(obj, j2);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public float getFloat(Object obj, long j2) {
            return this.y.getFloat(obj, j2);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public int getInt(long j2) {
            return this.y.getInt(j2);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public long getLong(long j2) {
            return this.y.getLong(j2);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public Object getStaticObject(Field field) {
            return getObject(this.y.staticFieldBase(field), this.y.staticFieldOffset(field));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putBoolean(Object obj, long j2, boolean z2) {
            this.y.putBoolean(obj, j2, z2);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(Object obj, long j2, byte b2) {
            this.y.putByte(obj, j2, b2);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putDouble(Object obj, long j2, double d2) {
            this.y.putDouble(obj, j2, d2);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putFloat(Object obj, long j2, float f4) {
            this.y.putFloat(obj, j2, f4);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putInt(long j2, int i) {
            this.y.putInt(j2, i);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putLong(long j2, long j4) {
            this.y.putLong(j2, j4);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean supportsUnsafeArrayOperations() {
            if (!super.supportsUnsafeArrayOperations()) {
                return false;
            }
            try {
                Class<?> cls = this.y.getClass();
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getByte", Object.class, cls2);
                cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
                cls.getMethod("getBoolean", Object.class, cls2);
                cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
                cls.getMethod("getFloat", Object.class, cls2);
                cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
                cls.getMethod("getDouble", Object.class, cls2);
                cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
                return true;
            } catch (Throwable th) {
                UnsafeUtil.b(th);
                return false;
            }
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean supportsUnsafeByteBufferOperations() {
            if (!super.supportsUnsafeByteBufferOperations()) {
                return false;
            }
            try {
                Class<?> cls = this.y.getClass();
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getByte", cls2);
                cls.getMethod("putByte", cls2, Byte.TYPE);
                cls.getMethod("getInt", cls2);
                cls.getMethod("putInt", cls2, Integer.TYPE);
                cls.getMethod("getLong", cls2);
                cls.getMethod("putLong", cls2, cls2);
                cls.getMethod("copyMemory", cls2, cls2, cls2);
                cls.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
                return true;
            } catch (Throwable th) {
                UnsafeUtil.b(th);
                return false;
            }
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(byte[] bArr, long j2, long j4, long j6) {
            this.y.copyMemory(bArr, UnsafeUtil.f6560s + j2, (Object) null, j4, j6);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(long j2) {
            return this.y.getByte(j2);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(long j2, byte b2) {
            this.y.putByte(j2, b2);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class MemoryAccessor {
        public Unsafe y;

        public MemoryAccessor(Unsafe unsafe) {
            this.y = unsafe;
        }

        public final int arrayBaseOffset(Class<?> cls) {
            return this.y.arrayBaseOffset(cls);
        }

        public final int arrayIndexScale(Class<?> cls) {
            return this.y.arrayIndexScale(cls);
        }

        public abstract void copyMemory(long j2, byte[] bArr, long j4, long j6);

        public abstract void copyMemory(byte[] bArr, long j2, long j4, long j6);

        public abstract boolean getBoolean(Object obj, long j2);

        public abstract byte getByte(long j2);

        public abstract byte getByte(Object obj, long j2);

        public abstract double getDouble(Object obj, long j2);

        public abstract float getFloat(Object obj, long j2);

        public abstract int getInt(long j2);

        public final int getInt(Object obj, long j2) {
            return this.y.getInt(obj, j2);
        }

        public abstract long getLong(long j2);

        public final long getLong(Object obj, long j2) {
            return this.y.getLong(obj, j2);
        }

        public final Object getObject(Object obj, long j2) {
            return this.y.getObject(obj, j2);
        }

        public abstract Object getStaticObject(Field field);

        public final long objectFieldOffset(Field field) {
            return this.y.objectFieldOffset(field);
        }

        public abstract void putBoolean(Object obj, long j2, boolean z2);

        public abstract void putByte(long j2, byte b2);

        public abstract void putByte(Object obj, long j2, byte b2);

        public abstract void putDouble(Object obj, long j2, double d2);

        public abstract void putFloat(Object obj, long j2, float f4);

        public abstract void putInt(long j2, int i);

        public final void putInt(Object obj, long j2, int i) {
            this.y.putInt(obj, j2, i);
        }

        public abstract void putLong(long j2, long j4);

        public final void putLong(Object obj, long j2, long j4) {
            this.y.putLong(obj, j2, j4);
        }

        public final void putObject(Object obj, long j2, Object obj2) {
            this.y.putObject(obj, j2, obj2);
        }

        public boolean supportsUnsafeArrayOperations() {
            Unsafe unsafe = this.y;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("arrayBaseOffset", Class.class);
                cls.getMethod("arrayIndexScale", Class.class);
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getInt", Object.class, cls2);
                cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
                cls.getMethod("getLong", Object.class, cls2);
                cls.getMethod("putLong", Object.class, cls2, cls2);
                cls.getMethod("getObject", Object.class, cls2);
                cls.getMethod("putObject", Object.class, cls2, Object.class);
                return true;
            } catch (Throwable th) {
                UnsafeUtil.b(th);
                return false;
            }
        }

        public boolean supportsUnsafeByteBufferOperations() {
            Unsafe unsafe = this.y;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("getLong", Object.class, Long.TYPE);
                if (UnsafeUtil.n3() != null) {
                    return true;
                }
                return false;
            } catch (Throwable th) {
                UnsafeUtil.b(th);
                return false;
            }
        }
    }

    static {
        boolean z2;
        long tl2 = tl(byte[].class);
        f6560s = tl2;
        f6549c5 = tl(boolean[].class);
        f6555i9 = wz(boolean[].class);
        f6551f = tl(int[].class);
        f6561t = wz(int[].class);
        f6562tl = tl(long[].class);
        f6565wz = wz(long[].class);
        f6567xc = tl(float[].class);
        f6564w = wz(float[].class);
        f6558p = tl(double[].class);
        f6556mt = wz(double[].class);
        f6550co = tl(Object[].class);
        f6568z = wz(Object[].class);
        f6559r = z(xc());
        f6566x4 = (int) (tl2 & 7);
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            z2 = true;
        } else {
            z2 = false;
        }
        f6554i4 = z2;
    }

    public static boolean a8() {
        return f6552fb;
    }

    public static void b(Throwable th) {
        Logger logger = Logger.getLogger(UnsafeUtil.class.getName());
        Level level = Level.WARNING;
        logger.log(level, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    public static byte c(Object obj, long j2) {
        return (byte) ((mg(obj, (-4) & j2) >>> ((int) (((~j2) & 3) << 3))) & 255);
    }

    public static Field co(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static long d(Object obj, long j2) {
        return f6563v.getLong(obj, j2);
    }

    public static byte d0(Object obj, long j2) {
        return (byte) ((mg(obj, (-4) & j2) >>> ((int) ((j2 & 3) << 3))) & 255);
    }

    public static Object ej(Object obj, long j2) {
        return f6563v.getObject(obj, j2);
    }

    public static boolean en() {
        MemoryAccessor memoryAccessor = f6563v;
        if (memoryAccessor == null) {
            return false;
        }
        return memoryAccessor.supportsUnsafeArrayOperations();
    }

    public static long f(ByteBuffer byteBuffer) {
        return f6563v.getLong(byteBuffer, f6559r);
    }

    public static byte f3(long j2) {
        return f6563v.getByte(j2);
    }

    public static void f7(Object obj, long j2, Object obj2) {
        f6563v.putObject(obj, j2, obj2);
    }

    public static double fh(Object obj, long j2) {
        return f6563v.getDouble(obj, j2);
    }

    public static void hw(Object obj, long j2, boolean z2) {
        j(obj, j2, z2 ? (byte) 1 : (byte) 0);
    }

    public static boolean i4(Object obj, long j2) {
        if (d0(obj, j2) != 0) {
            return true;
        }
        return false;
    }

    public static void j(Object obj, long j2, byte b2) {
        long j4 = (-4) & j2;
        int i = (((int) j2) & 3) << 3;
        q9(obj, j4, ((255 & b2) << i) | (mg(obj, j4) & (~(255 << i))));
    }

    public static void j5(long j2, byte b2) {
        f6563v.putByte(j2, b2);
    }

    public static boolean jz() {
        MemoryAccessor memoryAccessor = f6563v;
        if (memoryAccessor == null) {
            return false;
        }
        return memoryAccessor.supportsUnsafeByteBufferOperations();
    }

    public static void k(Object obj, long j2, long j4) {
        f6563v.putLong(obj, j2, j4);
    }

    public static long k5(Field field) {
        return f6563v.objectFieldOffset(field);
    }

    public static int mg(Object obj, long j2) {
        return f6563v.getInt(obj, j2);
    }

    public static boolean mt(Class<?> cls) {
        if (!Android.zn()) {
            return false;
        }
        try {
            Class<?> cls2 = f6557n3;
            Class<?> cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class<?> cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static byte n(byte[] bArr, long j2) {
        return f6563v.getByte(bArr, f6560s + j2);
    }

    public static /* synthetic */ Field n3() {
        return xc();
    }

    public static void o(Object obj, long j2, byte b2) {
        long j4 = (-4) & j2;
        int mg2 = mg(obj, j4);
        int i = ((~((int) j2)) & 3) << 3;
        q9(obj, j4, ((255 & b2) << i) | (mg2 & (~(255 << i))));
    }

    public static void oz(Object obj, long j2, double d2) {
        f6563v.putDouble(obj, j2, d2);
    }

    public static void p(byte[] bArr, long j2, long j4, long j6) {
        f6563v.copyMemory(bArr, j2, j4, j6);
    }

    public static void q9(Object obj, long j2, int i) {
        f6563v.putInt(obj, j2, i);
    }

    public static void qn(byte[] bArr, long j2, byte b2) {
        f6563v.putByte(bArr, f6560s + j2, b2);
    }

    public static boolean r(Object obj, long j2) {
        return f6563v.getBoolean(obj, j2);
    }

    public static float rz(Object obj, long j2) {
        return f6563v.getFloat(obj, j2);
    }

    public static <T> T t(Class<T> cls) {
        try {
            return (T) y.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static long ta(long j2) {
        return f6563v.getLong(j2);
    }

    public static int tl(Class<?> cls) {
        if (f6552fb) {
            return f6563v.arrayBaseOffset(cls);
        }
        return -1;
    }

    public static Unsafe ud() {
        try {
            return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.protobuf.UnsafeUtil.1
                @Override // java.security.PrivilegedExceptionAction
                public Unsafe run() throws Exception {
                    Field[] declaredFields;
                    for (Field field : Unsafe.class.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object obj = field.get(null);
                        if (Unsafe.class.isInstance(obj)) {
                            return (Unsafe) Unsafe.class.cast(obj);
                        }
                    }
                    return null;
                }
            });
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void ut(Object obj, long j2, float f4) {
        f6563v.putFloat(obj, j2, f4);
    }

    public static void vl(Object obj, long j2, boolean z2) {
        o(obj, j2, z2 ? (byte) 1 : (byte) 0);
    }

    public static void w(long j2, byte[] bArr, long j4, long j6) {
        f6563v.copyMemory(j2, bArr, j4, j6);
    }

    public static int wz(Class<?> cls) {
        if (f6552fb) {
            return f6563v.arrayIndexScale(cls);
        }
        return -1;
    }

    public static boolean x() {
        return f6548a;
    }

    public static boolean x4(Object obj, long j2) {
        if (c(obj, j2) != 0) {
            return true;
        }
        return false;
    }

    public static Field xc() {
        Field co2;
        if (Android.zn() && (co2 = co(Buffer.class, "effectiveDirectAddress")) != null) {
            return co2;
        }
        Field co3 = co(Buffer.class, "address");
        if (co3 == null || co3.getType() != Long.TYPE) {
            return null;
        }
        return co3;
    }

    public static void yt(Object obj, long j2, boolean z2) {
        f6563v.putBoolean(obj, j2, z2);
    }

    public static long z(Field field) {
        MemoryAccessor memoryAccessor;
        if (field != null && (memoryAccessor = f6563v) != null) {
            return memoryAccessor.objectFieldOffset(field);
        }
        return -1L;
    }

    public static MemoryAccessor z6() {
        Unsafe unsafe = y;
        if (unsafe == null) {
            return null;
        }
        if (Android.zn()) {
            if (f6569zn) {
                return new Android64MemoryAccessor(unsafe);
            }
            if (!f6553gv) {
                return null;
            }
            return new Android32MemoryAccessor(unsafe);
        }
        return new JvmMemoryAccessor(unsafe);
    }
}
