package lc1;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kc1.fh;
import kc1.mg;
import kc1.n;
import kc1.p;
import kc1.r;
import kc1.rz;
import kc1.v;
import kc1.z;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import sc1.zn;
import zc1.a;
import zc1.fb;
import zc1.s;
import zc1.ta;
import zc1.z;
/* loaded from: classes.dex */
public final class n3 {

    /* renamed from: a  reason: collision with root package name */
    public static final TimeZone f10301a;

    /* renamed from: c5  reason: collision with root package name */
    public static final String f10302c5;

    /* renamed from: fb  reason: collision with root package name */
    public static final Regex f10303fb;

    /* renamed from: gv  reason: collision with root package name */
    public static final fh f10304gv;

    /* renamed from: n3  reason: collision with root package name */
    public static final z f10305n3 = z.f9958v.fb(new String[0]);

    /* renamed from: s  reason: collision with root package name */
    public static final boolean f10306s;

    /* renamed from: v  reason: collision with root package name */
    public static final zc1.z f10307v;
    public static final byte[] y;

    /* renamed from: zn  reason: collision with root package name */
    public static final mg f10308zn;

    /* renamed from: lc1.n3$n3  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class ThreadFactoryC0147n3 implements ThreadFactory {

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ boolean f10309v;
        public final /* synthetic */ String y;

        public ThreadFactoryC0147n3(String str, boolean z2) {
            this.y = str;
            this.f10309v = z2;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.y);
            thread.setDaemon(this.f10309v);
            return thread;
        }
    }

    /* loaded from: classes.dex */
    public static final class y implements p.zn {
        public final /* synthetic */ p y;

        public y(p pVar) {
            this.y = pVar;
        }

        @Override // kc1.p.zn
        public final p y(v it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return this.y;
        }
    }

    static {
        byte[] bArr = new byte[0];
        y = bArr;
        f10308zn = mg.n3.c5(mg.Companion, bArr, null, 1, null);
        f10304gv = fh.y.f(fh.Companion, bArr, null, 0, 0, 7, null);
        z.y yVar = zc1.z.fb;
        s.y yVar2 = s.fb;
        f10307v = yVar.gv(new s[]{yVar2.n3("efbbbf"), yVar2.n3("feff"), yVar2.n3("fffe"), yVar2.n3("0000ffff"), yVar2.n3("ffff0000")});
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        Intrinsics.checkNotNull(timeZone);
        f10301a = timeZone;
        f10303fb = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        f10306s = false;
        String name = n.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "OkHttpClient::class.java.name");
        f10302c5 = StringsKt.removeSuffix(StringsKt.removePrefix(name, "okhttp3."), "Client");
    }

    public static final boolean a(String canParseAsIpAddress) {
        Intrinsics.checkNotNullParameter(canParseAsIpAddress, "$this$canParseAsIpAddress");
        return f10303fb.matches(canParseAsIpAddress);
    }

    public static final int a8(zc1.v skipAll, byte b2) {
        Intrinsics.checkNotNullParameter(skipAll, "$this$skipAll");
        int i = 0;
        while (!skipAll.nf() && skipAll.ud(0L) == b2) {
            i++;
            skipAll.readByte();
        }
        return i;
    }

    public static final ThreadFactory b(String name, boolean z2) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new ThreadFactoryC0147n3(name, z2);
    }

    public static /* synthetic */ int c(String str, int i, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = 0;
        }
        if ((i6 & 2) != 0) {
            i5 = str.length();
        }
        return n(str, i, i5);
    }

    public static final void c5(long j2, long j4, long j6) {
        if ((j4 | j6) >= 0 && j4 <= j2 && j2 - j4 >= j6) {
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public static final long co(rz headersContentLength) {
        Intrinsics.checkNotNullParameter(headersContentLength, "$this$headersContentLength");
        String y2 = headersContentLength.b().y("Content-Length");
        if (y2 == null) {
            return -1L;
        }
        return o(y2, -1L);
    }

    public static final int d(char c2) {
        if ('0' <= c2 && '9' >= c2) {
            return c2 - '0';
        }
        if ('a' <= c2 && 'f' >= c2) {
            return c2 - 'W';
        }
        if ('A' <= c2 && 'F' >= c2) {
            return c2 - '7';
        }
        return -1;
    }

    public static final int d0(String indexOfNonWhitespace, int i) {
        Intrinsics.checkNotNullParameter(indexOfNonWhitespace, "$this$indexOfNonWhitespace");
        int length = indexOfNonWhitespace.length();
        while (i < length) {
            char charAt = indexOfNonWhitespace.charAt(i);
            if (charAt != ' ' && charAt != '\t') {
                return i;
            }
            i++;
        }
        return indexOfNonWhitespace.length();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0038, code lost:
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> T ej(java.lang.Object r4, java.lang.Class<T> r5, java.lang.String r6) {
        /*
            java.lang.String r0 = "instance"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "fieldType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "fieldName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.Class r0 = r4.getClass()
        L13:
            java.lang.Class<java.lang.Object> r1 = java.lang.Object.class
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            r3 = 0
            if (r2 != 0) goto L43
            java.lang.reflect.Field r1 = r0.getDeclaredField(r6)     // Catch: java.lang.NoSuchFieldException -> L39
            java.lang.String r2 = "field"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch: java.lang.NoSuchFieldException -> L39
            r2 = 1
            r1.setAccessible(r2)     // Catch: java.lang.NoSuchFieldException -> L39
            java.lang.Object r1 = r1.get(r4)     // Catch: java.lang.NoSuchFieldException -> L39
            boolean r2 = r5.isInstance(r1)     // Catch: java.lang.NoSuchFieldException -> L39
            if (r2 != 0) goto L34
            goto L38
        L34:
            java.lang.Object r3 = r5.cast(r1)     // Catch: java.lang.NoSuchFieldException -> L39
        L38:
            return r3
        L39:
            java.lang.Class r0 = r0.getSuperclass()
            java.lang.String r1 = "c.superclass"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            goto L13
        L43:
            java.lang.String r0 = "delegate"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r0)
            if (r2 != 0) goto L56
            java.lang.Object r4 = ej(r4, r1, r0)
            if (r4 == 0) goto L56
            java.lang.Object r4 = ej(r4, r5, r6)
            return r4
        L56:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: lc1.n3.ej(java.lang.Object, java.lang.Class, java.lang.String):java.lang.Object");
    }

    public static final void f(Socket closeQuietly) {
        Intrinsics.checkNotNullParameter(closeQuietly, "$this$closeQuietly");
        try {
            closeQuietly.close();
        } catch (AssertionError e2) {
            throw e2;
        } catch (RuntimeException e3) {
            if (Intrinsics.areEqual(e3.getMessage(), "bio == null")) {
                return;
            }
            throw e3;
        } catch (Exception unused) {
        }
    }

    public static /* synthetic */ int f3(String str, int i, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = 0;
        }
        if ((i6 & 2) != 0) {
            i5 = str.length();
        }
        return i4(str, i, i5);
    }

    public static final boolean fb(r canReuseConnectionFor, r other) {
        Intrinsics.checkNotNullParameter(canReuseConnectionFor, "$this$canReuseConnectionFor");
        Intrinsics.checkNotNullParameter(other, "other");
        if (Intrinsics.areEqual(canReuseConnectionFor.f(), other.f()) && canReuseConnectionFor.mt() == other.mt() && Intrinsics.areEqual(canReuseConnectionFor.x4(), other.x4())) {
            return true;
        }
        return false;
    }

    public static final String[] fh(String[] intersect, String[] other, Comparator<? super String> comparator) {
        Intrinsics.checkNotNullParameter(intersect, "$this$intersect");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        for (String str : intersect) {
            int length = other.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (comparator.compare(str, other[i]) == 0) {
                    arrayList.add(str);
                    break;
                } else {
                    i++;
                }
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public static final long gv(int i, long j2) {
        return i & j2;
    }

    public static /* synthetic */ String hw(r rVar, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        return vl(rVar, z2);
    }

    public static final int i4(String indexOfFirstNonAsciiWhitespace, int i, int i5) {
        Intrinsics.checkNotNullParameter(indexOfFirstNonAsciiWhitespace, "$this$indexOfFirstNonAsciiWhitespace");
        while (i < i5) {
            char charAt = indexOfFirstNonAsciiWhitespace.charAt(i);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i;
            }
            i++;
        }
        return i5;
    }

    public static final void i9(Closeable closeQuietly) {
        Intrinsics.checkNotNullParameter(closeQuietly, "$this$closeQuietly");
        try {
            closeQuietly.close();
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    public static final int j(String str, int i) {
        if (str != null) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (parseLong < 0) {
                    return 0;
                }
                return (int) parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        return i;
    }

    public static final <T> List<T> j5(List<? extends T> toImmutableList) {
        Intrinsics.checkNotNullParameter(toImmutableList, "$this$toImmutableList");
        List<T> unmodifiableList = Collections.unmodifiableList(CollectionsKt.toMutableList((Collection) toImmutableList));
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "Collections.unmodifiableList(toMutableList())");
        return unmodifiableList;
    }

    public static final void k(a writeMedium, int i) throws IOException {
        Intrinsics.checkNotNullParameter(writeMedium, "$this$writeMedium");
        writeMedium.writeByte((i >>> 16) & 255);
        writeMedium.writeByte((i >>> 8) & 255);
        writeMedium.writeByte(i & 255);
    }

    public static final List<zn> k5(kc1.z toHeaderList) {
        Intrinsics.checkNotNullParameter(toHeaderList, "$this$toHeaderList");
        IntRange until = RangesKt.until(0, toHeaderList.size());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            arrayList.add(new zn(toHeaderList.zn(nextInt), toHeaderList.c5(nextInt)));
        }
        return arrayList;
    }

    public static final boolean mg(Socket isHealthy, fb source) {
        Intrinsics.checkNotNullParameter(isHealthy, "$this$isHealthy");
        Intrinsics.checkNotNullParameter(source, "source");
        try {
            int soTimeout = isHealthy.getSoTimeout();
            try {
                isHealthy.setSoTimeout(1);
                boolean z2 = !source.nf();
                isHealthy.setSoTimeout(soTimeout);
                return z2;
            } catch (Throwable th) {
                isHealthy.setSoTimeout(soTimeout);
                throw th;
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public static final boolean mt(String[] hasIntersection, String[] strArr, Comparator<? super String> comparator) {
        Intrinsics.checkNotNullParameter(hasIntersection, "$this$hasIntersection");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (hasIntersection.length != 0 && strArr != null && strArr.length != 0) {
            for (String str : hasIntersection) {
                for (String str2 : strArr) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final int n(String indexOfLastNonAsciiWhitespace, int i, int i5) {
        Intrinsics.checkNotNullParameter(indexOfLastNonAsciiWhitespace, "$this$indexOfLastNonAsciiWhitespace");
        int i6 = i5 - 1;
        if (i6 >= i) {
            while (true) {
                char charAt = indexOfLastNonAsciiWhitespace.charAt(i6);
                if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                    return i6 + 1;
                }
                if (i6 == i) {
                    break;
                }
                i6--;
            }
        }
        return i;
    }

    public static final int n3(byte b2, int i) {
        return b2 & i;
    }

    public static final long o(String toLongOrDefault, long j2) {
        Intrinsics.checkNotNullParameter(toLongOrDefault, "$this$toLongOrDefault");
        try {
            return Long.parseLong(toLongOrDefault);
        } catch (NumberFormatException unused) {
            return j2;
        }
    }

    public static final String oz(String trimSubstring, int i, int i5) {
        Intrinsics.checkNotNullParameter(trimSubstring, "$this$trimSubstring");
        int i42 = i4(trimSubstring, i, i5);
        String substring = trimSubstring.substring(i42, n(trimSubstring, i42, i5));
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String p(String format, Object... args) {
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(args, "args");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Locale locale = Locale.US;
        Object[] copyOf = Arrays.copyOf(args, args.length);
        String format2 = String.format(locale, format, Arrays.copyOf(copyOf, copyOf.length));
        Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(locale, format, *args)");
        return format2;
    }

    public static final Throwable q9(Exception withSuppressed, List<? extends Exception> suppressed) {
        Intrinsics.checkNotNullParameter(withSuppressed, "$this$withSuppressed");
        Intrinsics.checkNotNullParameter(suppressed, "suppressed");
        if (suppressed.size() > 1) {
            System.out.println(suppressed);
        }
        for (Exception exc : suppressed) {
            ExceptionsKt.addSuppressed(withSuppressed, exc);
        }
        return withSuppressed;
    }

    public static final <K, V> Map<K, V> qn(Map<K, ? extends V> toImmutableMap) {
        Intrinsics.checkNotNullParameter(toImmutableMap, "$this$toImmutableMap");
        if (toImmutableMap.isEmpty()) {
            return MapsKt.emptyMap();
        }
        Map<K, V> unmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(toImmutableMap));
        Intrinsics.checkNotNullExpressionValue(unmodifiableMap, "Collections.unmodifiableMap(LinkedHashMap(this))");
        return unmodifiableMap;
    }

    public static final int r(String[] indexOf, String value, Comparator<String> comparator) {
        Intrinsics.checkNotNullParameter(indexOf, "$this$indexOf");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int length = indexOf.length;
        for (int i = 0; i < length; i++) {
            if (comparator.compare(indexOf[i], value) == 0) {
                return i;
            }
        }
        return -1;
    }

    public static final boolean rz(tc1.y isCivilized, File file) {
        Intrinsics.checkNotNullParameter(isCivilized, "$this$isCivilized");
        Intrinsics.checkNotNullParameter(file, "file");
        zc1.rz v2 = isCivilized.v(file);
        try {
            try {
                isCivilized.fb(file);
                CloseableKt.closeFinally(v2, null);
                return true;
            } catch (IOException unused) {
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(v2, null);
                isCivilized.fb(file);
                return false;
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(v2, th);
                throw th2;
            }
        }
    }

    public static final int s(String name, long j2, TimeUnit timeUnit) {
        boolean z2;
        boolean z3;
        boolean z4;
        Intrinsics.checkNotNullParameter(name, "name");
        boolean z5 = false;
        int i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if (timeUnit != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                long millis = timeUnit.toMillis(j2);
                if (millis <= Integer.MAX_VALUE) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z4) {
                    if ((millis != 0 || i <= 0) ? true : true) {
                        return (int) millis;
                    }
                    throw new IllegalArgumentException((name + " too small.").toString());
                }
                throw new IllegalArgumentException((name + " too large.").toString());
            }
            throw new IllegalStateException("unit == null");
        }
        throw new IllegalStateException((name + " < 0").toString());
    }

    public static final String[] t(String[] concat, String value) {
        Intrinsics.checkNotNullParameter(concat, "$this$concat");
        Intrinsics.checkNotNullParameter(value, "value");
        Object[] copyOf = Arrays.copyOf(concat, concat.length + 1);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        String[] strArr = (String[]) copyOf;
        strArr[ArraysKt.getLastIndex(strArr)] = value;
        return strArr;
    }

    public static final boolean ta(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (StringsKt.equals(name, "Authorization", true) || StringsKt.equals(name, "Cookie", true) || StringsKt.equals(name, "Proxy-Authorization", true) || StringsKt.equals(name, "Set-Cookie", true)) {
            return true;
        }
        return false;
    }

    public static final int tl(String delimiterOffset, char c2, int i, int i5) {
        Intrinsics.checkNotNullParameter(delimiterOffset, "$this$delimiterOffset");
        while (i < i5) {
            if (delimiterOffset.charAt(i) == c2) {
                return i;
            }
            i++;
        }
        return i5;
    }

    public static final int ud(fb readMedium) throws IOException {
        Intrinsics.checkNotNullParameter(readMedium, "$this$readMedium");
        return n3(readMedium.readByte(), 255) | (n3(readMedium.readByte(), 255) << 16) | (n3(readMedium.readByte(), 255) << 8);
    }

    public static /* synthetic */ String ut(String str, int i, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = 0;
        }
        if ((i6 & 2) != 0) {
            i5 = str.length();
        }
        return oz(str, i, i5);
    }

    public static final p.zn v(p asFactory) {
        Intrinsics.checkNotNullParameter(asFactory, "$this$asFactory");
        return new y(asFactory);
    }

    public static final String vl(r toHostHeader, boolean z2) {
        String f4;
        Intrinsics.checkNotNullParameter(toHostHeader, "$this$toHostHeader");
        if (StringsKt.contains$default((CharSequence) toHostHeader.f(), (CharSequence) ":", false, 2, (Object) null)) {
            f4 = '[' + toHostHeader.f() + ']';
        } else {
            f4 = toHostHeader.f();
        }
        if (z2 || toHostHeader.mt() != r.f9869t.zn(toHostHeader.x4())) {
            return f4 + ':' + toHostHeader.mt();
        }
        return f4;
    }

    public static final boolean w(ta discard, int i, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(discard, "$this$discard");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        try {
            return x(discard, i, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static final int wz(String delimiterOffset, String delimiters, int i, int i5) {
        Intrinsics.checkNotNullParameter(delimiterOffset, "$this$delimiterOffset");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        while (i < i5) {
            if (StringsKt.contains$default((CharSequence) delimiters, delimiterOffset.charAt(i), false, 2, (Object) null)) {
                return i;
            }
            i++;
        }
        return i5;
    }

    public static final boolean x(ta skipAll, int i, TimeUnit timeUnit) throws IOException {
        long j2;
        Intrinsics.checkNotNullParameter(skipAll, "$this$skipAll");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        long nanoTime = System.nanoTime();
        if (skipAll.timeout().a()) {
            j2 = skipAll.timeout().gv() - nanoTime;
        } else {
            j2 = Long.MAX_VALUE;
        }
        skipAll.timeout().v(Math.min(j2, timeUnit.toNanos(i)) + nanoTime);
        try {
            zc1.v vVar = new zc1.v();
            while (skipAll.read(vVar, 8192L) != -1) {
                vVar.s();
            }
            if (j2 == Long.MAX_VALUE) {
                skipAll.timeout().n3();
            } else {
                skipAll.timeout().v(nanoTime + j2);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (j2 == Long.MAX_VALUE) {
                skipAll.timeout().n3();
            } else {
                skipAll.timeout().v(nanoTime + j2);
            }
            return false;
        } catch (Throwable th) {
            if (j2 == Long.MAX_VALUE) {
                skipAll.timeout().n3();
            } else {
                skipAll.timeout().v(nanoTime + j2);
            }
            throw th;
        }
    }

    public static final int x4(String indexOfControlOrNonAscii) {
        Intrinsics.checkNotNullParameter(indexOfControlOrNonAscii, "$this$indexOfControlOrNonAscii");
        int length = indexOfControlOrNonAscii.length();
        for (int i = 0; i < length; i++) {
            char charAt = indexOfControlOrNonAscii.charAt(i);
            if (Intrinsics.compare((int) charAt, 31) <= 0 || Intrinsics.compare((int) charAt, 127) >= 0) {
                return i;
            }
        }
        return -1;
    }

    public static /* synthetic */ int xc(String str, char c2, int i, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i = 0;
        }
        if ((i6 & 4) != 0) {
            i5 = str.length();
        }
        return tl(str, c2, i, i5);
    }

    public static final <E> void y(List<E> addIfAbsent, E e2) {
        Intrinsics.checkNotNullParameter(addIfAbsent, "$this$addIfAbsent");
        if (!addIfAbsent.contains(e2)) {
            addIfAbsent.add(e2);
        }
    }

    public static final kc1.z yt(List<zn> toHeaders) {
        Intrinsics.checkNotNullParameter(toHeaders, "$this$toHeaders");
        z.y yVar = new z.y();
        for (zn znVar : toHeaders) {
            yVar.gv(znVar.y().dm(), znVar.n3().dm());
        }
        return yVar.a();
    }

    @SafeVarargs
    public static final <T> List<T> z(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object[] objArr = (Object[]) elements.clone();
        List<T> unmodifiableList = Collections.unmodifiableList(CollectionsKt.listOf(Arrays.copyOf(objArr, objArr.length)));
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "Collections.unmodifiable…istOf(*elements.clone()))");
        return unmodifiableList;
    }

    public static final Charset z6(fb readBomAsCharset, Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter(readBomAsCharset, "$this$readBomAsCharset");
        Intrinsics.checkNotNullParameter(charset, "default");
        int f4 = readBomAsCharset.f(f10307v);
        if (f4 != -1) {
            if (f4 != 0) {
                if (f4 != 1) {
                    if (f4 != 2) {
                        if (f4 != 3) {
                            if (f4 == 4) {
                                return Charsets.INSTANCE.UTF32_LE();
                            }
                            throw new AssertionError();
                        }
                        return Charsets.INSTANCE.UTF32_BE();
                    }
                    Charset UTF_16LE = StandardCharsets.UTF_16LE;
                    Intrinsics.checkNotNullExpressionValue(UTF_16LE, "UTF_16LE");
                    return UTF_16LE;
                }
                Charset UTF_16BE = StandardCharsets.UTF_16BE;
                Intrinsics.checkNotNullExpressionValue(UTF_16BE, "UTF_16BE");
                return UTF_16BE;
            }
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            return UTF_8;
        }
        return charset;
    }

    public static final int zn(short s2, int i) {
        return s2 & i;
    }
}
