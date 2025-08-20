package com.google.gson.stream;

import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
/* loaded from: classes.dex */
public class JsonReader implements Closeable {

    /* renamed from: fh  reason: collision with root package name */
    public static final char[] f6277fh = ")]}'\n".toCharArray();

    /* renamed from: c  reason: collision with root package name */
    public String[] f6278c;

    /* renamed from: co  reason: collision with root package name */
    public long f6279co;

    /* renamed from: d0  reason: collision with root package name */
    public int[] f6280d0;

    /* renamed from: f  reason: collision with root package name */
    public int f6281f;

    /* renamed from: f3  reason: collision with root package name */
    public int[] f6282f3;

    /* renamed from: fb  reason: collision with root package name */
    public final char[] f6283fb = new char[1024];

    /* renamed from: n  reason: collision with root package name */
    public int f6284n;

    /* renamed from: p  reason: collision with root package name */
    public int f6285p;

    /* renamed from: r  reason: collision with root package name */
    public String f6286r;

    /* renamed from: s  reason: collision with root package name */
    public int f6287s;

    /* renamed from: t  reason: collision with root package name */
    public int f6288t;

    /* renamed from: v  reason: collision with root package name */
    public boolean f6289v;

    /* renamed from: w  reason: collision with root package name */
    public int f6290w;
    public final Reader y;

    /* renamed from: z  reason: collision with root package name */
    public int f6291z;

    static {
        JsonReaderInternalAccess.INSTANCE = new JsonReaderInternalAccess() { // from class: com.google.gson.stream.JsonReader.1
            @Override // com.google.gson.internal.JsonReaderInternalAccess
            public void promoteNameToValue(JsonReader jsonReader) throws IOException {
                if (jsonReader instanceof JsonTreeReader) {
                    ((JsonTreeReader) jsonReader).promoteNameToValue();
                    return;
                }
                int i = jsonReader.f6285p;
                if (i == 0) {
                    i = jsonReader.s();
                }
                if (i == 13) {
                    jsonReader.f6285p = 9;
                } else if (i == 12) {
                    jsonReader.f6285p = 8;
                } else if (i == 14) {
                    jsonReader.f6285p = 10;
                } else {
                    throw new IllegalStateException("Expected a name but was " + jsonReader.peek() + jsonReader.co());
                }
            }
        };
    }

    public JsonReader(Reader reader) {
        int[] iArr = new int[32];
        this.f6282f3 = iArr;
        int i = this.f6284n;
        this.f6284n = i + 1;
        iArr[i] = 6;
        this.f6278c = new String[32];
        this.f6280d0 = new int[32];
        if (reader != null) {
            this.y = reader;
            return;
        }
        throw new NullPointerException("in == null");
    }

    public final void b(int i) {
        int i5 = this.f6284n;
        int[] iArr = this.f6282f3;
        if (i5 == iArr.length) {
            int i6 = i5 * 2;
            this.f6282f3 = Arrays.copyOf(iArr, i6);
            this.f6280d0 = Arrays.copyOf(this.f6280d0, i6);
            this.f6278c = (String[]) Arrays.copyOf(this.f6278c, i6);
        }
        int[] iArr2 = this.f6282f3;
        int i8 = this.f6284n;
        this.f6284n = i8 + 1;
        iArr2[i8] = i;
    }

    public void beginArray() throws IOException {
        int i = this.f6285p;
        if (i == 0) {
            i = s();
        }
        if (i == 3) {
            b(1);
            this.f6280d0[this.f6284n - 1] = 0;
            this.f6285p = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + peek() + co());
    }

    public void beginObject() throws IOException {
        int i = this.f6285p;
        if (i == 0) {
            i = s();
        }
        if (i == 1) {
            b(3);
            this.f6285p = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + peek() + co());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f6285p = 0;
        this.f6282f3[0] = 8;
        this.f6284n = 1;
        this.y.close();
    }

    public String co() {
        return " at line " + (this.f6288t + 1) + " column " + ((this.f6287s - this.f6290w) + 1) + " path " + getPath();
    }

    public final int d() throws IOException {
        String str;
        String str2;
        int i;
        char c2 = this.f6283fb[this.f6287s];
        if (c2 != 't' && c2 != 'T') {
            if (c2 != 'f' && c2 != 'F') {
                if (c2 != 'n' && c2 != 'N') {
                    return 0;
                }
                str = "null";
                str2 = "NULL";
                i = 7;
            } else {
                str = "false";
                str2 = "FALSE";
                i = 6;
            }
        } else {
            str = "true";
            str2 = "TRUE";
            i = 5;
        }
        int length = str.length();
        for (int i5 = 1; i5 < length; i5++) {
            if (this.f6287s + i5 >= this.f6281f && !p(i5 + 1)) {
                return 0;
            }
            char c4 = this.f6283fb[this.f6287s + i5];
            if (c4 != str.charAt(i5) && c4 != str2.charAt(i5)) {
                return 0;
            }
        }
        if ((this.f6287s + length < this.f6281f || p(length + 1)) && mt(this.f6283fb[this.f6287s + length])) {
            return 0;
        }
        this.f6287s += length;
        this.f6285p = i;
        return i;
    }

    public final IOException dm(String str) throws IOException {
        throw new MalformedJsonException(str + co());
    }

    public void endArray() throws IOException {
        int i = this.f6285p;
        if (i == 0) {
            i = s();
        }
        if (i == 4) {
            int i5 = this.f6284n;
            this.f6284n = i5 - 1;
            int[] iArr = this.f6280d0;
            int i6 = i5 - 2;
            iArr[i6] = iArr[i6] + 1;
            this.f6285p = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + peek() + co());
    }

    public void endObject() throws IOException {
        int i = this.f6285p;
        if (i == 0) {
            i = s();
        }
        if (i == 2) {
            int i5 = this.f6284n;
            int i6 = i5 - 1;
            this.f6284n = i6;
            this.f6278c[i6] = null;
            int[] iArr = this.f6280d0;
            int i8 = i5 - 2;
            iArr[i8] = iArr[i8] + 1;
            this.f6285p = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + peek() + co());
    }

    public String getPath() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i = this.f6284n;
        for (int i5 = 0; i5 < i; i5++) {
            int i6 = this.f6282f3[i5];
            if (i6 != 1 && i6 != 2) {
                if (i6 == 3 || i6 == 4 || i6 == 5) {
                    sb.append('.');
                    String str = this.f6278c[i5];
                    if (str != null) {
                        sb.append(str);
                    }
                }
            } else {
                sb.append('[');
                sb.append(this.f6280d0[i5]);
                sb.append(']');
            }
        }
        return sb.toString();
    }

    public boolean hasNext() throws IOException {
        int i = this.f6285p;
        if (i == 0) {
            i = s();
        }
        if (i != 2 && i != 4) {
            return true;
        }
        return false;
    }

    public final boolean isLenient() {
        return this.f6289v;
    }

    public final void j() throws IOException {
        char c2;
        do {
            if (this.f6287s < this.f6281f || p(1)) {
                char[] cArr = this.f6283fb;
                int i = this.f6287s;
                int i5 = i + 1;
                this.f6287s = i5;
                c2 = cArr[i];
                if (c2 == '\n') {
                    this.f6288t++;
                    this.f6290w = i5;
                    return;
                }
            } else {
                return;
            }
        } while (c2 != '\r');
    }

    public final boolean j5(String str) throws IOException {
        int length = str.length();
        while (true) {
            if (this.f6287s + length > this.f6281f && !p(length)) {
                return false;
            }
            char[] cArr = this.f6283fb;
            int i = this.f6287s;
            if (cArr[i] == '\n') {
                this.f6288t++;
                this.f6290w = i + 1;
            } else {
                for (int i5 = 0; i5 < length; i5++) {
                    if (this.f6283fb[this.f6287s + i5] != str.charAt(i5)) {
                        break;
                    }
                }
                return true;
            }
            this.f6287s++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
        y();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void jz() throws java.io.IOException {
        /*
            r4 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r4.f6287s
            int r2 = r1 + r0
            int r3 = r4.f6281f
            if (r2 >= r3) goto L51
            char[] r2 = r4.f6283fb
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L4b
            r2 = 10
            if (r1 == r2) goto L4b
            r2 = 12
            if (r1 == r2) goto L4b
            r2 = 13
            if (r1 == r2) goto L4b
            r2 = 32
            if (r1 == r2) goto L4b
            r2 = 35
            if (r1 == r2) goto L48
            r2 = 44
            if (r1 == r2) goto L4b
            r2 = 47
            if (r1 == r2) goto L48
            r2 = 61
            if (r1 == r2) goto L48
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L4b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L4b
            r2 = 58
            if (r1 == r2) goto L4b
            r2 = 59
            if (r1 == r2) goto L48
            switch(r1) {
                case 91: goto L4b;
                case 92: goto L48;
                case 93: goto L4b;
                default: goto L45;
            }
        L45:
            int r0 = r0 + 1
            goto L1
        L48:
            r4.y()
        L4b:
            int r1 = r4.f6287s
            int r1 = r1 + r0
            r4.f6287s = r1
            return
        L51:
            int r1 = r1 + r0
            r4.f6287s = r1
            r0 = 1
            boolean r0 = r4.p(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.jz():void");
    }

    public final char k5() throws IOException {
        int i;
        if (this.f6287s == this.f6281f && !p(1)) {
            throw dm("Unterminated escape sequence");
        }
        char[] cArr = this.f6283fb;
        int i5 = this.f6287s;
        int i6 = i5 + 1;
        this.f6287s = i6;
        char c2 = cArr[i5];
        if (c2 != '\n') {
            if (c2 != '\"' && c2 != '\'' && c2 != '/' && c2 != '\\') {
                if (c2 != 'b') {
                    if (c2 != 'f') {
                        if (c2 == 'n') {
                            return '\n';
                        }
                        if (c2 != 'r') {
                            if (c2 != 't') {
                                if (c2 == 'u') {
                                    if (i5 + 5 > this.f6281f && !p(4)) {
                                        throw dm("Unterminated escape sequence");
                                    }
                                    int i8 = this.f6287s;
                                    int i10 = i8 + 4;
                                    char c4 = 0;
                                    while (i8 < i10) {
                                        char c6 = this.f6283fb[i8];
                                        char c7 = (char) (c4 << 4);
                                        if (c6 >= '0' && c6 <= '9') {
                                            i = c6 - '0';
                                        } else if (c6 >= 'a' && c6 <= 'f') {
                                            i = c6 - 'W';
                                        } else if (c6 >= 'A' && c6 <= 'F') {
                                            i = c6 - '7';
                                        } else {
                                            throw new NumberFormatException("\\u" + new String(this.f6283fb, this.f6287s, 4));
                                        }
                                        c4 = (char) (c7 + i);
                                        i8++;
                                    }
                                    this.f6287s += 4;
                                    return c4;
                                }
                                throw dm("Invalid escape sequence");
                            }
                            return '\t';
                        }
                        return '\r';
                    }
                    return '\f';
                }
                return '\b';
            }
        } else {
            this.f6288t++;
            this.f6290w = i6;
        }
        return c2;
    }

    public final boolean mt(char c2) throws IOException {
        if (c2 != '\t' && c2 != '\n' && c2 != '\f' && c2 != '\r' && c2 != ' ') {
            if (c2 != '#') {
                if (c2 != ',') {
                    if (c2 != '/' && c2 != '=') {
                        if (c2 != '{' && c2 != '}' && c2 != ':') {
                            if (c2 != ';') {
                                switch (c2) {
                                    case '[':
                                    case ']':
                                        return false;
                                    case '\\':
                                        break;
                                    default:
                                        return true;
                                }
                            }
                        } else {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }
            y();
            return false;
        }
        return false;
    }

    public boolean nextBoolean() throws IOException {
        int i = this.f6285p;
        if (i == 0) {
            i = s();
        }
        if (i == 5) {
            this.f6285p = 0;
            int[] iArr = this.f6280d0;
            int i5 = this.f6284n - 1;
            iArr[i5] = iArr[i5] + 1;
            return true;
        } else if (i == 6) {
            this.f6285p = 0;
            int[] iArr2 = this.f6280d0;
            int i6 = this.f6284n - 1;
            iArr2[i6] = iArr2[i6] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + peek() + co());
        }
    }

    public double nextDouble() throws IOException {
        char c2;
        int i = this.f6285p;
        if (i == 0) {
            i = s();
        }
        if (i == 15) {
            this.f6285p = 0;
            int[] iArr = this.f6280d0;
            int i5 = this.f6284n - 1;
            iArr[i5] = iArr[i5] + 1;
            return this.f6279co;
        }
        if (i == 16) {
            this.f6286r = new String(this.f6283fb, this.f6287s, this.f6291z);
            this.f6287s += this.f6291z;
        } else if (i != 8 && i != 9) {
            if (i == 10) {
                this.f6286r = ta();
            } else if (i != 11) {
                throw new IllegalStateException("Expected a double but was " + peek() + co());
            }
        } else {
            if (i == 8) {
                c2 = '\'';
            } else {
                c2 = '\"';
            }
            this.f6286r = x4(c2);
        }
        this.f6285p = 11;
        double parseDouble = Double.parseDouble(this.f6286r);
        if (!this.f6289v && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + co());
        }
        this.f6286r = null;
        this.f6285p = 0;
        int[] iArr2 = this.f6280d0;
        int i6 = this.f6284n - 1;
        iArr2[i6] = iArr2[i6] + 1;
        return parseDouble;
    }

    public int nextInt() throws IOException {
        char c2;
        int i = this.f6285p;
        if (i == 0) {
            i = s();
        }
        if (i == 15) {
            long j2 = this.f6279co;
            int i5 = (int) j2;
            if (j2 == i5) {
                this.f6285p = 0;
                int[] iArr = this.f6280d0;
                int i6 = this.f6284n - 1;
                iArr[i6] = iArr[i6] + 1;
                return i5;
            }
            throw new NumberFormatException("Expected an int but was " + this.f6279co + co());
        }
        if (i == 16) {
            this.f6286r = new String(this.f6283fb, this.f6287s, this.f6291z);
            this.f6287s += this.f6291z;
        } else if (i != 8 && i != 9 && i != 10) {
            throw new IllegalStateException("Expected an int but was " + peek() + co());
        } else {
            if (i == 10) {
                this.f6286r = ta();
            } else {
                if (i == 8) {
                    c2 = '\'';
                } else {
                    c2 = '\"';
                }
                this.f6286r = x4(c2);
            }
            try {
                int parseInt = Integer.parseInt(this.f6286r);
                this.f6285p = 0;
                int[] iArr2 = this.f6280d0;
                int i8 = this.f6284n - 1;
                iArr2[i8] = iArr2[i8] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.f6285p = 11;
        double parseDouble = Double.parseDouble(this.f6286r);
        int i10 = (int) parseDouble;
        if (i10 == parseDouble) {
            this.f6286r = null;
            this.f6285p = 0;
            int[] iArr3 = this.f6280d0;
            int i11 = this.f6284n - 1;
            iArr3[i11] = iArr3[i11] + 1;
            return i10;
        }
        throw new NumberFormatException("Expected an int but was " + this.f6286r + co());
    }

    public long nextLong() throws IOException {
        char c2;
        int i = this.f6285p;
        if (i == 0) {
            i = s();
        }
        if (i == 15) {
            this.f6285p = 0;
            int[] iArr = this.f6280d0;
            int i5 = this.f6284n - 1;
            iArr[i5] = iArr[i5] + 1;
            return this.f6279co;
        }
        if (i == 16) {
            this.f6286r = new String(this.f6283fb, this.f6287s, this.f6291z);
            this.f6287s += this.f6291z;
        } else if (i != 8 && i != 9 && i != 10) {
            throw new IllegalStateException("Expected a long but was " + peek() + co());
        } else {
            if (i == 10) {
                this.f6286r = ta();
            } else {
                if (i == 8) {
                    c2 = '\'';
                } else {
                    c2 = '\"';
                }
                this.f6286r = x4(c2);
            }
            try {
                long parseLong = Long.parseLong(this.f6286r);
                this.f6285p = 0;
                int[] iArr2 = this.f6280d0;
                int i6 = this.f6284n - 1;
                iArr2[i6] = iArr2[i6] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        this.f6285p = 11;
        double parseDouble = Double.parseDouble(this.f6286r);
        long j2 = (long) parseDouble;
        if (j2 == parseDouble) {
            this.f6286r = null;
            this.f6285p = 0;
            int[] iArr3 = this.f6280d0;
            int i8 = this.f6284n - 1;
            iArr3[i8] = iArr3[i8] + 1;
            return j2;
        }
        throw new NumberFormatException("Expected a long but was " + this.f6286r + co());
    }

    public String nextName() throws IOException {
        String x42;
        int i = this.f6285p;
        if (i == 0) {
            i = s();
        }
        if (i == 14) {
            x42 = ta();
        } else if (i == 12) {
            x42 = x4('\'');
        } else if (i == 13) {
            x42 = x4('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + peek() + co());
        }
        this.f6285p = 0;
        this.f6278c[this.f6284n - 1] = x42;
        return x42;
    }

    public void nextNull() throws IOException {
        int i = this.f6285p;
        if (i == 0) {
            i = s();
        }
        if (i == 7) {
            this.f6285p = 0;
            int[] iArr = this.f6280d0;
            int i5 = this.f6284n - 1;
            iArr[i5] = iArr[i5] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + peek() + co());
    }

    public String nextString() throws IOException {
        String str;
        int i = this.f6285p;
        if (i == 0) {
            i = s();
        }
        if (i == 10) {
            str = ta();
        } else if (i == 8) {
            str = x4('\'');
        } else if (i == 9) {
            str = x4('\"');
        } else if (i == 11) {
            str = this.f6286r;
            this.f6286r = null;
        } else if (i == 15) {
            str = Long.toString(this.f6279co);
        } else if (i == 16) {
            str = new String(this.f6283fb, this.f6287s, this.f6291z);
            this.f6287s += this.f6291z;
        } else {
            throw new IllegalStateException("Expected a string but was " + peek() + co());
        }
        this.f6285p = 0;
        int[] iArr = this.f6280d0;
        int i5 = this.f6284n - 1;
        iArr[i5] = iArr[i5] + 1;
        return str;
    }

    public final boolean p(int i) throws IOException {
        int i5;
        int i6;
        char[] cArr = this.f6283fb;
        int i8 = this.f6290w;
        int i10 = this.f6287s;
        this.f6290w = i8 - i10;
        int i11 = this.f6281f;
        if (i11 != i10) {
            int i12 = i11 - i10;
            this.f6281f = i12;
            System.arraycopy(cArr, i10, cArr, 0, i12);
        } else {
            this.f6281f = 0;
        }
        this.f6287s = 0;
        do {
            Reader reader = this.y;
            int i13 = this.f6281f;
            int read = reader.read(cArr, i13, cArr.length - i13);
            if (read == -1) {
                return false;
            }
            i5 = this.f6281f + read;
            this.f6281f = i5;
            if (this.f6288t == 0 && (i6 = this.f6290w) == 0 && i5 > 0 && cArr[0] == 65279) {
                this.f6287s++;
                this.f6290w = i6 + 1;
                i++;
                continue;
            }
        } while (i5 < i);
        return true;
    }

    public JsonToken peek() throws IOException {
        int i = this.f6285p;
        if (i == 0) {
            i = s();
        }
        switch (i) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final int r(boolean z2) throws IOException {
        char[] cArr = this.f6283fb;
        int i = this.f6287s;
        int i5 = this.f6281f;
        while (true) {
            if (i == i5) {
                this.f6287s = i;
                if (!p(1)) {
                    if (!z2) {
                        return -1;
                    }
                    throw new EOFException("End of input" + co());
                }
                i = this.f6287s;
                i5 = this.f6281f;
            }
            int i6 = i + 1;
            char c2 = cArr[i];
            if (c2 == '\n') {
                this.f6288t++;
                this.f6290w = i6;
            } else if (c2 != ' ' && c2 != '\r' && c2 != '\t') {
                if (c2 == '/') {
                    this.f6287s = i6;
                    if (i6 == i5) {
                        this.f6287s = i;
                        boolean p2 = p(2);
                        this.f6287s++;
                        if (!p2) {
                            return c2;
                        }
                    }
                    y();
                    int i8 = this.f6287s;
                    char c4 = cArr[i8];
                    if (c4 != '*') {
                        if (c4 != '/') {
                            return c2;
                        }
                        this.f6287s = i8 + 1;
                        j();
                        i = this.f6287s;
                        i5 = this.f6281f;
                    } else {
                        this.f6287s = i8 + 1;
                        if (j5("*/")) {
                            i = this.f6287s + 2;
                            i5 = this.f6281f;
                        } else {
                            throw dm("Unterminated comment");
                        }
                    }
                } else if (c2 == '#') {
                    this.f6287s = i6;
                    y();
                    j();
                    i = this.f6287s;
                    i5 = this.f6281f;
                } else {
                    this.f6287s = i6;
                    return c2;
                }
            }
            i = i6;
        }
    }

    public int s() throws IOException {
        int r2;
        int[] iArr = this.f6282f3;
        int i = this.f6284n;
        int i5 = iArr[i - 1];
        if (i5 == 1) {
            iArr[i - 1] = 2;
        } else if (i5 == 2) {
            int r3 = r(true);
            if (r3 != 44) {
                if (r3 != 59) {
                    if (r3 == 93) {
                        this.f6285p = 4;
                        return 4;
                    }
                    throw dm("Unterminated array");
                }
                y();
            }
        } else if (i5 != 3 && i5 != 5) {
            if (i5 == 4) {
                iArr[i - 1] = 5;
                int r5 = r(true);
                if (r5 != 58) {
                    if (r5 == 61) {
                        y();
                        if (this.f6287s < this.f6281f || p(1)) {
                            char[] cArr = this.f6283fb;
                            int i6 = this.f6287s;
                            if (cArr[i6] == '>') {
                                this.f6287s = i6 + 1;
                            }
                        }
                    } else {
                        throw dm("Expected ':'");
                    }
                }
            } else if (i5 == 6) {
                if (this.f6289v) {
                    v();
                }
                this.f6282f3[this.f6284n - 1] = 7;
            } else if (i5 == 7) {
                if (r(false) == -1) {
                    this.f6285p = 17;
                    return 17;
                }
                y();
                this.f6287s--;
            } else if (i5 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        } else {
            iArr[i - 1] = 4;
            if (i5 == 5 && (r2 = r(true)) != 44) {
                if (r2 != 59) {
                    if (r2 == 125) {
                        this.f6285p = 2;
                        return 2;
                    }
                    throw dm("Unterminated object");
                }
                y();
            }
            int r6 = r(true);
            if (r6 != 34) {
                if (r6 != 39) {
                    if (r6 != 125) {
                        y();
                        this.f6287s--;
                        if (mt((char) r6)) {
                            this.f6285p = 14;
                            return 14;
                        }
                        throw dm("Expected name");
                    } else if (i5 != 5) {
                        this.f6285p = 2;
                        return 2;
                    } else {
                        throw dm("Expected name");
                    }
                }
                y();
                this.f6285p = 12;
                return 12;
            }
            this.f6285p = 13;
            return 13;
        }
        int r7 = r(true);
        if (r7 != 34) {
            if (r7 != 39) {
                if (r7 != 44 && r7 != 59) {
                    if (r7 != 91) {
                        if (r7 != 93) {
                            if (r7 != 123) {
                                this.f6287s--;
                                int d2 = d();
                                if (d2 != 0) {
                                    return d2;
                                }
                                int ud2 = ud();
                                if (ud2 != 0) {
                                    return ud2;
                                }
                                if (mt(this.f6283fb[this.f6287s])) {
                                    y();
                                    this.f6285p = 10;
                                    return 10;
                                }
                                throw dm("Expected value");
                            }
                            this.f6285p = 1;
                            return 1;
                        } else if (i5 == 1) {
                            this.f6285p = 4;
                            return 4;
                        }
                    } else {
                        this.f6285p = 3;
                        return 3;
                    }
                }
                if (i5 != 1 && i5 != 2) {
                    throw dm("Unexpected value");
                }
                y();
                this.f6287s--;
                this.f6285p = 7;
                return 7;
            }
            y();
            this.f6285p = 8;
            return 8;
        }
        this.f6285p = 9;
        return 9;
    }

    public final void setLenient(boolean z2) {
        this.f6289v = z2;
    }

    public void skipValue() throws IOException {
        int i = 0;
        do {
            int i5 = this.f6285p;
            if (i5 == 0) {
                i5 = s();
            }
            if (i5 == 3) {
                b(1);
            } else if (i5 == 1) {
                b(3);
            } else {
                if (i5 == 4) {
                    this.f6284n--;
                } else if (i5 == 2) {
                    this.f6284n--;
                } else {
                    if (i5 != 14 && i5 != 10) {
                        if (i5 != 8 && i5 != 12) {
                            if (i5 != 9 && i5 != 13) {
                                if (i5 == 16) {
                                    this.f6287s += this.f6291z;
                                }
                            } else {
                                yt('\"');
                            }
                        } else {
                            yt('\'');
                        }
                    } else {
                        jz();
                    }
                    this.f6285p = 0;
                }
                i--;
                this.f6285p = 0;
            }
            i++;
            this.f6285p = 0;
        } while (i != 0);
        int[] iArr = this.f6280d0;
        int i6 = this.f6284n;
        int i8 = i6 - 1;
        iArr[i8] = iArr[i8] + 1;
        this.f6278c[i6 - 1] = "null";
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
        y();
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String ta() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = 0
        L3:
            int r3 = r6.f6287s
            int r4 = r3 + r2
            int r5 = r6.f6281f
            if (r4 >= r5) goto L4e
            char[] r4 = r6.f6283fb
            int r3 = r3 + r2
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L5c
            r4 = 10
            if (r3 == r4) goto L5c
            r4 = 12
            if (r3 == r4) goto L5c
            r4 = 13
            if (r3 == r4) goto L5c
            r4 = 32
            if (r3 == r4) goto L5c
            r4 = 35
            if (r3 == r4) goto L4a
            r4 = 44
            if (r3 == r4) goto L5c
            r4 = 47
            if (r3 == r4) goto L4a
            r4 = 61
            if (r3 == r4) goto L4a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5c
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5c
            r4 = 58
            if (r3 == r4) goto L5c
            r4 = 59
            if (r3 == r4) goto L4a
            switch(r3) {
                case 91: goto L5c;
                case 92: goto L4a;
                case 93: goto L5c;
                default: goto L47;
            }
        L47:
            int r2 = r2 + 1
            goto L3
        L4a:
            r6.y()
            goto L5c
        L4e:
            char[] r3 = r6.f6283fb
            int r3 = r3.length
            if (r2 >= r3) goto L5e
            int r3 = r2 + 1
            boolean r3 = r6.p(r3)
            if (r3 == 0) goto L5c
            goto L3
        L5c:
            r1 = r2
            goto L7e
        L5e:
            if (r0 != 0) goto L6b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r0.<init>(r3)
        L6b:
            char[] r3 = r6.f6283fb
            int r4 = r6.f6287s
            r0.append(r3, r4, r2)
            int r3 = r6.f6287s
            int r3 = r3 + r2
            r6.f6287s = r3
            r2 = 1
            boolean r2 = r6.p(r2)
            if (r2 != 0) goto L2
        L7e:
            if (r0 != 0) goto L8a
            java.lang.String r0 = new java.lang.String
            char[] r2 = r6.f6283fb
            int r3 = r6.f6287s
            r0.<init>(r2, r3, r1)
            goto L95
        L8a:
            char[] r2 = r6.f6283fb
            int r3 = r6.f6287s
            r0.append(r2, r3, r1)
            java.lang.String r0 = r0.toString()
        L95:
            int r2 = r6.f6287s
            int r2 = r2 + r1
            r6.f6287s = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.ta():java.lang.String");
    }

    public String toString() {
        return getClass().getSimpleName() + co();
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0093, code lost:
        if (mt(r14) != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0095, code lost:
        if (r9 != 2) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0097, code lost:
        if (r10 == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x009d, code lost:
        if (r11 != Long.MIN_VALUE) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009f, code lost:
        if (r13 == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a5, code lost:
        if (r11 != 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a7, code lost:
        if (r13 != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00a9, code lost:
        if (r13 == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00ac, code lost:
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00ad, code lost:
        r18.f6279co = r11;
        r18.f6287s += r8;
        r18.f6285p = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00b8, code lost:
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00b9, code lost:
        if (r9 == 2) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00bc, code lost:
        if (r9 == 4) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00bf, code lost:
        if (r9 != 7) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00c2, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00c4, code lost:
        r18.f6291z = r8;
        r18.f6285p = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00ca, code lost:
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00cb, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int ud() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.ud():int");
    }

    public final void v() throws IOException {
        r(true);
        int i = this.f6287s - 1;
        this.f6287s = i;
        char[] cArr = f6277fh;
        if (i + cArr.length > this.f6281f && !p(cArr.length)) {
            return;
        }
        int i5 = 0;
        while (true) {
            char[] cArr2 = f6277fh;
            if (i5 < cArr2.length) {
                if (this.f6283fb[this.f6287s + i5] != cArr2[i5]) {
                    return;
                }
                i5++;
            } else {
                this.f6287s += cArr2.length;
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005a, code lost:
        if (r1 != null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005c, code lost:
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006a, code lost:
        r1.append(r0, r3, r2 - r3);
        r9.f6287s = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String x4(char r10) throws java.io.IOException {
        /*
            r9 = this;
            char[] r0 = r9.f6283fb
            r1 = 0
        L3:
            int r2 = r9.f6287s
            int r3 = r9.f6281f
        L7:
            r4 = r3
            r3 = r2
        L9:
            r5 = 16
            r6 = 1
            if (r2 >= r4) goto L5a
            int r7 = r2 + 1
            char r2 = r0[r2]
            if (r2 != r10) goto L28
            r9.f6287s = r7
            int r7 = r7 - r3
            int r7 = r7 - r6
            if (r1 != 0) goto L20
            java.lang.String r10 = new java.lang.String
            r10.<init>(r0, r3, r7)
            return r10
        L20:
            r1.append(r0, r3, r7)
            java.lang.String r10 = r1.toString()
            return r10
        L28:
            r8 = 92
            if (r2 != r8) goto L4d
            r9.f6287s = r7
            int r7 = r7 - r3
            int r2 = r7 + (-1)
            if (r1 != 0) goto L3e
            int r7 = r7 * 2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r4 = java.lang.Math.max(r7, r5)
            r1.<init>(r4)
        L3e:
            r1.append(r0, r3, r2)
            char r2 = r9.k5()
            r1.append(r2)
            int r2 = r9.f6287s
            int r3 = r9.f6281f
            goto L7
        L4d:
            r5 = 10
            if (r2 != r5) goto L58
            int r2 = r9.f6288t
            int r2 = r2 + r6
            r9.f6288t = r2
            r9.f6290w = r7
        L58:
            r2 = r7
            goto L9
        L5a:
            if (r1 != 0) goto L6a
            int r1 = r2 - r3
            int r1 = r1 * 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r4.<init>(r1)
            r1 = r4
        L6a:
            int r4 = r2 - r3
            r1.append(r0, r3, r4)
            r9.f6287s = r2
            boolean r2 = r9.p(r6)
            if (r2 == 0) goto L78
            goto L3
        L78:
            java.lang.String r10 = "Unterminated string"
            java.io.IOException r10 = r9.dm(r10)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.x4(char):java.lang.String");
    }

    public final void y() throws IOException {
        if (this.f6289v) {
            return;
        }
        throw dm("Use JsonReader.setLenient(true) to accept malformed JSON");
    }

    public final void yt(char c2) throws IOException {
        char[] cArr = this.f6283fb;
        do {
            int i = this.f6287s;
            int i5 = this.f6281f;
            while (i < i5) {
                int i6 = i + 1;
                char c4 = cArr[i];
                if (c4 == c2) {
                    this.f6287s = i6;
                    return;
                } else if (c4 == '\\') {
                    this.f6287s = i6;
                    k5();
                    i = this.f6287s;
                    i5 = this.f6281f;
                } else {
                    if (c4 == '\n') {
                        this.f6288t++;
                        this.f6290w = i6;
                    }
                    i = i6;
                }
            }
            this.f6287s = i;
        } while (p(1));
        throw dm("Unterminated string");
    }
}
