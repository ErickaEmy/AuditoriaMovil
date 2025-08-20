package w0;
/* loaded from: classes.dex */
public abstract class gv implements w<Character> {

    /* renamed from: w0.gv$gv  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0241gv extends zn {

        /* renamed from: v  reason: collision with root package name */
        public static final C0241gv f14502v = new C0241gv();

        public C0241gv() {
            super("CharMatcher.none()");
        }

        @Override // w0.gv
        public boolean v(char c2) {
            return false;
        }

        @Override // w0.gv
        public int zn(CharSequence charSequence, int i) {
            xc.w(i, charSequence.length());
            return -1;
        }
    }

    /* loaded from: classes.dex */
    public static final class n3 extends y {
        public final char y;

        public n3(char c2) {
            this.y = c2;
        }

        public String toString() {
            String fb2 = gv.fb(this.y);
            StringBuilder sb = new StringBuilder(String.valueOf(fb2).length() + 18);
            sb.append("CharMatcher.is('");
            sb.append(fb2);
            sb.append("')");
            return sb.toString();
        }

        @Override // w0.gv
        public boolean v(char c2) {
            if (c2 == this.y) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class y extends gv {
        @Override // w0.w
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.n3(ch);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class zn extends y {
        public final String y;

        public zn(String str) {
            this.y = (String) xc.wz(str);
        }

        public final String toString() {
            return this.y;
        }
    }

    public static gv a() {
        return C0241gv.f14502v;
    }

    public static String fb(char c2) {
        char[] cArr = new char[6];
        cArr[0] = '\\';
        cArr[1] = 'u';
        cArr[2] = 0;
        cArr[3] = 0;
        cArr[4] = 0;
        cArr[5] = 0;
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = "0123456789ABCDEF".charAt(c2 & 15);
            c2 = (char) (c2 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    public static gv gv(char c2) {
        return new n3(c2);
    }

    @Deprecated
    public boolean n3(Character ch) {
        return v(ch.charValue());
    }

    public abstract boolean v(char c2);

    public int zn(CharSequence charSequence, int i) {
        int length = charSequence.length();
        xc.w(i, length);
        while (i < length) {
            if (v(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
