package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.gv;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public class zn {

    /* renamed from: gv  reason: collision with root package name */
    public static final int[] f1936gv = {0, 4, 8};

    /* renamed from: v  reason: collision with root package name */
    public static SparseIntArray f1937v;
    public HashMap<String, androidx.constraintlayout.widget.y> y = new HashMap<>();

    /* renamed from: n3  reason: collision with root package name */
    public boolean f1938n3 = true;

    /* renamed from: zn  reason: collision with root package name */
    public HashMap<Integer, y> f1939zn = new HashMap<>();

    /* loaded from: classes.dex */
    public static class gv {

        /* renamed from: n3  reason: collision with root package name */
        public int f1941n3;
        public boolean y;

        /* renamed from: zn  reason: collision with root package name */
        public int f1943zn;

        /* renamed from: gv  reason: collision with root package name */
        public float f1940gv = 1.0f;

        /* renamed from: v  reason: collision with root package name */
        public float f1942v = Float.NaN;

        public void n3(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f1885xp);
            this.y = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R$styleable.f1762hu) {
                    this.f1940gv = obtainStyledAttributes.getFloat(index, this.f1940gv);
                } else if (index == R$styleable.f1822ps) {
                    this.f1941n3 = obtainStyledAttributes.getInt(index, this.f1941n3);
                    this.f1941n3 = zn.f1936gv[this.f1941n3];
                } else if (index == R$styleable.f1785l9) {
                    this.f1943zn = obtainStyledAttributes.getInt(index, this.f1943zn);
                } else if (index == R$styleable.f1813oh) {
                    this.f1942v = obtainStyledAttributes.getFloat(index, this.f1942v);
                }
            }
            obtainStyledAttributes.recycle();
        }

        public void y(gv gvVar) {
            this.y = gvVar.y;
            this.f1941n3 = gvVar.f1941n3;
            this.f1940gv = gvVar.f1940gv;
            this.f1942v = gvVar.f1942v;
            this.f1943zn = gvVar.f1943zn;
        }
    }

    /* loaded from: classes.dex */
    public static class n3 {

        /* renamed from: nf  reason: collision with root package name */
        public static SparseIntArray f1944nf;

        /* renamed from: c  reason: collision with root package name */
        public float f1948c;

        /* renamed from: ct  reason: collision with root package name */
        public String f1951ct;

        /* renamed from: dm  reason: collision with root package name */
        public int[] f1954dm;

        /* renamed from: eb  reason: collision with root package name */
        public boolean f1955eb;

        /* renamed from: gv  reason: collision with root package name */
        public int f1963gv;

        /* renamed from: i4  reason: collision with root package name */
        public String f1965i4;

        /* renamed from: j  reason: collision with root package name */
        public int f1967j;

        /* renamed from: n  reason: collision with root package name */
        public int f1975n;

        /* renamed from: n3  reason: collision with root package name */
        public boolean f1976n3;

        /* renamed from: o  reason: collision with root package name */
        public int f1977o;

        /* renamed from: o4  reason: collision with root package name */
        public String f1978o4;

        /* renamed from: oz  reason: collision with root package name */
        public int f1979oz;

        /* renamed from: qn  reason: collision with root package name */
        public int f1982qn;

        /* renamed from: rs  reason: collision with root package name */
        public boolean f1984rs;
        public boolean y;

        /* renamed from: y5  reason: collision with root package name */
        public int f2001y5;

        /* renamed from: zn  reason: collision with root package name */
        public int f2005zn;

        /* renamed from: v  reason: collision with root package name */
        public int f1993v = -1;

        /* renamed from: a  reason: collision with root package name */
        public int f1945a = -1;

        /* renamed from: fb  reason: collision with root package name */
        public float f1961fb = -1.0f;

        /* renamed from: s  reason: collision with root package name */
        public int f1986s = -1;

        /* renamed from: c5  reason: collision with root package name */
        public int f1949c5 = -1;

        /* renamed from: i9  reason: collision with root package name */
        public int f1966i9 = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f1958f = -1;

        /* renamed from: t  reason: collision with root package name */
        public int f1987t = -1;

        /* renamed from: tl  reason: collision with root package name */
        public int f1989tl = -1;

        /* renamed from: wz  reason: collision with root package name */
        public int f1996wz = -1;

        /* renamed from: xc  reason: collision with root package name */
        public int f1999xc = -1;

        /* renamed from: w  reason: collision with root package name */
        public int f1995w = -1;

        /* renamed from: p  reason: collision with root package name */
        public int f1980p = -1;

        /* renamed from: mt  reason: collision with root package name */
        public int f1974mt = -1;

        /* renamed from: co  reason: collision with root package name */
        public int f1950co = -1;

        /* renamed from: z  reason: collision with root package name */
        public int f2003z = -1;

        /* renamed from: r  reason: collision with root package name */
        public float f1983r = 0.5f;

        /* renamed from: x4  reason: collision with root package name */
        public float f1998x4 = 0.5f;

        /* renamed from: f3  reason: collision with root package name */
        public int f1959f3 = -1;

        /* renamed from: d0  reason: collision with root package name */
        public int f1953d0 = -1;

        /* renamed from: fh  reason: collision with root package name */
        public int f1962fh = -1;

        /* renamed from: rz  reason: collision with root package name */
        public int f1985rz = -1;

        /* renamed from: mg  reason: collision with root package name */
        public int f1973mg = -1;

        /* renamed from: ta  reason: collision with root package name */
        public int f1988ta = -1;

        /* renamed from: d  reason: collision with root package name */
        public int f1952d = -1;

        /* renamed from: z6  reason: collision with root package name */
        public int f2004z6 = -1;

        /* renamed from: ej  reason: collision with root package name */
        public int f1956ej = -1;

        /* renamed from: ud  reason: collision with root package name */
        public int f1991ud = -1;

        /* renamed from: a8  reason: collision with root package name */
        public int f1946a8 = -1;

        /* renamed from: x  reason: collision with root package name */
        public int f1997x = -1;

        /* renamed from: b  reason: collision with root package name */
        public int f1947b = -1;

        /* renamed from: k5  reason: collision with root package name */
        public int f1971k5 = -1;

        /* renamed from: yt  reason: collision with root package name */
        public int f2002yt = -1;

        /* renamed from: vl  reason: collision with root package name */
        public int f1994vl = -1;

        /* renamed from: hw  reason: collision with root package name */
        public float f1964hw = -1.0f;

        /* renamed from: j5  reason: collision with root package name */
        public float f1968j5 = -1.0f;

        /* renamed from: ut  reason: collision with root package name */
        public int f1992ut = -1;

        /* renamed from: q9  reason: collision with root package name */
        public int f1981q9 = -1;

        /* renamed from: k  reason: collision with root package name */
        public int f1970k = -1;

        /* renamed from: f7  reason: collision with root package name */
        public int f1960f7 = -1;

        /* renamed from: en  reason: collision with root package name */
        public float f1957en = 1.0f;

        /* renamed from: jz  reason: collision with root package name */
        public float f1969jz = 1.0f;

        /* renamed from: u  reason: collision with root package name */
        public int f1990u = -1;

        /* renamed from: xg  reason: collision with root package name */
        public int f2000xg = -1;

        /* renamed from: lc  reason: collision with root package name */
        public boolean f1972lc = true;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1944nf = sparseIntArray;
            sparseIntArray.append(R$styleable.f1792m1, 24);
            f1944nf.append(R$styleable.f1749fj, 25);
            f1944nf.append(R$styleable.f1728da, 28);
            f1944nf.append(R$styleable.f1707a9, 29);
            f1944nf.append(R$styleable.f1781ku, 35);
            f1944nf.append(R$styleable.f1736e4, 34);
            f1944nf.append(R$styleable.a0, 4);
            f1944nf.append(R$styleable.nw, 3);
            f1944nf.append(R$styleable.or, 1);
            f1944nf.append(R$styleable.f1845sc, 6);
            f1944nf.append(R$styleable.f1878x1, 7);
            f1944nf.append(R$styleable.nb, 17);
            f1944nf.append(R$styleable.bu, 18);
            f1944nf.append(R$styleable.jg, 19);
            f1944nf.append(R$styleable.oj, 26);
            f1944nf.append(R$styleable.f1746f8, 31);
            f1944nf.append(R$styleable.f1734dx, 32);
            f1944nf.append(R$styleable.ns, 10);
            f1944nf.append(R$styleable.ki, 9);
            f1944nf.append(R$styleable.f1886y3, 13);
            f1944nf.append(R$styleable.f1760hd, 16);
            f1944nf.append(R$styleable.f1803n6, 14);
            f1944nf.append(R$styleable.f1759ha, 11);
            f1944nf.append(R$styleable.f1756h3, 15);
            f1944nf.append(R$styleable.f1799mv, 12);
            f1944nf.append(R$styleable.f1834qx, 38);
            f1944nf.append(R$styleable.km, 37);
            f1944nf.append(R$styleable.ar, 39);
            f1944nf.append(R$styleable.f1854tq, 40);
            f1944nf.append(R$styleable.fa, 20);
            f1944nf.append(R$styleable.f1740ek, 36);
            f1944nf.append(R$styleable.lq, 5);
            f1944nf.append(R$styleable.b8, 76);
            f1944nf.append(R$styleable.f1789ls, 76);
            f1944nf.append(R$styleable.f1727d9, 76);
            f1944nf.append(R$styleable.i5, 76);
            f1944nf.append(R$styleable.q4, 76);
            f1944nf.append(R$styleable.r5, 23);
            f1944nf.append(R$styleable.gy, 27);
            f1944nf.append(R$styleable.aj, 30);
            f1944nf.append(R$styleable.ah, 8);
            f1944nf.append(R$styleable.pk, 33);
            f1944nf.append(R$styleable.s0, 2);
            f1944nf.append(R$styleable.iv, 22);
            f1944nf.append(R$styleable.xd, 21);
            f1944nf.append(R$styleable.gp, 61);
            f1944nf.append(R$styleable.mk, 62);
            f1944nf.append(R$styleable.yb, 63);
            f1944nf.append(R$styleable.f1818p0, 69);
            f1944nf.append(R$styleable.yx, 70);
            f1944nf.append(R$styleable.sg, 71);
            f1944nf.append(R$styleable.xe, 72);
            f1944nf.append(R$styleable.ex, 73);
            f1944nf.append(R$styleable.lm, 74);
            f1944nf.append(R$styleable.zv, 75);
        }

        public void n3(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.yz);
            this.f1976n3 = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                int i5 = f1944nf.get(index);
                if (i5 != 80) {
                    if (i5 != 81) {
                        switch (i5) {
                            case 1:
                                this.f1995w = zn.p(obtainStyledAttributes, index, this.f1995w);
                                continue;
                            case 2:
                                this.f2004z6 = obtainStyledAttributes.getDimensionPixelSize(index, this.f2004z6);
                                continue;
                            case 3:
                                this.f1999xc = zn.p(obtainStyledAttributes, index, this.f1999xc);
                                continue;
                            case 4:
                                this.f1996wz = zn.p(obtainStyledAttributes, index, this.f1996wz);
                                continue;
                            case 5:
                                this.f1965i4 = obtainStyledAttributes.getString(index);
                                continue;
                            case 6:
                                this.f1953d0 = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1953d0);
                                continue;
                            case 7:
                                this.f1962fh = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1962fh);
                                continue;
                            case 8:
                                this.f1956ej = obtainStyledAttributes.getDimensionPixelSize(index, this.f1956ej);
                                continue;
                            case 9:
                                this.f2003z = zn.p(obtainStyledAttributes, index, this.f2003z);
                                continue;
                            case 10:
                                this.f1950co = zn.p(obtainStyledAttributes, index, this.f1950co);
                                continue;
                            case 11:
                                this.f1971k5 = obtainStyledAttributes.getDimensionPixelSize(index, this.f1971k5);
                                continue;
                            case 12:
                                this.f2002yt = obtainStyledAttributes.getDimensionPixelSize(index, this.f2002yt);
                                continue;
                            case 13:
                                this.f1946a8 = obtainStyledAttributes.getDimensionPixelSize(index, this.f1946a8);
                                continue;
                            case 14:
                                this.f1947b = obtainStyledAttributes.getDimensionPixelSize(index, this.f1947b);
                                continue;
                            case 15:
                                this.f1994vl = obtainStyledAttributes.getDimensionPixelSize(index, this.f1994vl);
                                continue;
                            case 16:
                                this.f1997x = obtainStyledAttributes.getDimensionPixelSize(index, this.f1997x);
                                continue;
                            case 17:
                                this.f1993v = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1993v);
                                continue;
                            case 18:
                                this.f1945a = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1945a);
                                continue;
                            case 19:
                                this.f1961fb = obtainStyledAttributes.getFloat(index, this.f1961fb);
                                continue;
                            case 20:
                                this.f1983r = obtainStyledAttributes.getFloat(index, this.f1983r);
                                continue;
                            case 21:
                                this.f1963gv = obtainStyledAttributes.getLayoutDimension(index, this.f1963gv);
                                continue;
                            case 22:
                                this.f2005zn = obtainStyledAttributes.getLayoutDimension(index, this.f2005zn);
                                continue;
                            case 23:
                                this.f1973mg = obtainStyledAttributes.getDimensionPixelSize(index, this.f1973mg);
                                continue;
                            case 24:
                                this.f1986s = zn.p(obtainStyledAttributes, index, this.f1986s);
                                continue;
                            case 25:
                                this.f1949c5 = zn.p(obtainStyledAttributes, index, this.f1949c5);
                                continue;
                            case 26:
                                this.f1985rz = obtainStyledAttributes.getInt(index, this.f1985rz);
                                continue;
                            case 27:
                                this.f1988ta = obtainStyledAttributes.getDimensionPixelSize(index, this.f1988ta);
                                continue;
                            case 28:
                                this.f1966i9 = zn.p(obtainStyledAttributes, index, this.f1966i9);
                                continue;
                            case 29:
                                this.f1958f = zn.p(obtainStyledAttributes, index, this.f1958f);
                                continue;
                            case 30:
                                this.f1991ud = obtainStyledAttributes.getDimensionPixelSize(index, this.f1991ud);
                                continue;
                            case 31:
                                this.f1980p = zn.p(obtainStyledAttributes, index, this.f1980p);
                                continue;
                            case 32:
                                this.f1974mt = zn.p(obtainStyledAttributes, index, this.f1974mt);
                                continue;
                            case 33:
                                this.f1952d = obtainStyledAttributes.getDimensionPixelSize(index, this.f1952d);
                                continue;
                            case 34:
                                this.f1989tl = zn.p(obtainStyledAttributes, index, this.f1989tl);
                                continue;
                            case 35:
                                this.f1987t = zn.p(obtainStyledAttributes, index, this.f1987t);
                                continue;
                            case 36:
                                this.f1998x4 = obtainStyledAttributes.getFloat(index, this.f1998x4);
                                continue;
                            case 37:
                                this.f1968j5 = obtainStyledAttributes.getFloat(index, this.f1968j5);
                                continue;
                            case 38:
                                this.f1964hw = obtainStyledAttributes.getFloat(index, this.f1964hw);
                                continue;
                            case 39:
                                this.f1982qn = obtainStyledAttributes.getInt(index, this.f1982qn);
                                continue;
                            case 40:
                                this.f1977o = obtainStyledAttributes.getInt(index, this.f1977o);
                                continue;
                            default:
                                switch (i5) {
                                    case 54:
                                        this.f1967j = obtainStyledAttributes.getInt(index, this.f1967j);
                                        continue;
                                    case 55:
                                        this.f1979oz = obtainStyledAttributes.getInt(index, this.f1979oz);
                                        continue;
                                    case 56:
                                        this.f1992ut = obtainStyledAttributes.getDimensionPixelSize(index, this.f1992ut);
                                        continue;
                                    case 57:
                                        this.f1981q9 = obtainStyledAttributes.getDimensionPixelSize(index, this.f1981q9);
                                        continue;
                                    case 58:
                                        this.f1970k = obtainStyledAttributes.getDimensionPixelSize(index, this.f1970k);
                                        continue;
                                    case 59:
                                        this.f1960f7 = obtainStyledAttributes.getDimensionPixelSize(index, this.f1960f7);
                                        continue;
                                    default:
                                        switch (i5) {
                                            case 61:
                                                this.f1959f3 = zn.p(obtainStyledAttributes, index, this.f1959f3);
                                                continue;
                                            case 62:
                                                this.f1975n = obtainStyledAttributes.getDimensionPixelSize(index, this.f1975n);
                                                continue;
                                            case 63:
                                                this.f1948c = obtainStyledAttributes.getFloat(index, this.f1948c);
                                                continue;
                                            default:
                                                switch (i5) {
                                                    case 69:
                                                        this.f1957en = obtainStyledAttributes.getFloat(index, 1.0f);
                                                        continue;
                                                    case 70:
                                                        this.f1969jz = obtainStyledAttributes.getFloat(index, 1.0f);
                                                        continue;
                                                    case 71:
                                                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                                        continue;
                                                    case 72:
                                                        this.f1990u = obtainStyledAttributes.getInt(index, this.f1990u);
                                                        continue;
                                                    case 73:
                                                        this.f2001y5 = obtainStyledAttributes.getDimensionPixelSize(index, this.f2001y5);
                                                        continue;
                                                    case 74:
                                                        this.f1951ct = obtainStyledAttributes.getString(index);
                                                        continue;
                                                    case 75:
                                                        this.f1972lc = obtainStyledAttributes.getBoolean(index, this.f1972lc);
                                                        continue;
                                                    case 76:
                                                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f1944nf.get(index));
                                                        continue;
                                                    case 77:
                                                        this.f1978o4 = obtainStyledAttributes.getString(index);
                                                        continue;
                                                    default:
                                                        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f1944nf.get(index));
                                                        continue;
                                                        continue;
                                                        continue;
                                                        continue;
                                                }
                                        }
                                }
                        }
                    } else {
                        this.f1955eb = obtainStyledAttributes.getBoolean(index, this.f1955eb);
                    }
                } else {
                    this.f1984rs = obtainStyledAttributes.getBoolean(index, this.f1984rs);
                }
            }
            obtainStyledAttributes.recycle();
        }

        public void y(n3 n3Var) {
            this.y = n3Var.y;
            this.f2005zn = n3Var.f2005zn;
            this.f1976n3 = n3Var.f1976n3;
            this.f1963gv = n3Var.f1963gv;
            this.f1993v = n3Var.f1993v;
            this.f1945a = n3Var.f1945a;
            this.f1961fb = n3Var.f1961fb;
            this.f1986s = n3Var.f1986s;
            this.f1949c5 = n3Var.f1949c5;
            this.f1966i9 = n3Var.f1966i9;
            this.f1958f = n3Var.f1958f;
            this.f1987t = n3Var.f1987t;
            this.f1989tl = n3Var.f1989tl;
            this.f1996wz = n3Var.f1996wz;
            this.f1999xc = n3Var.f1999xc;
            this.f1995w = n3Var.f1995w;
            this.f1980p = n3Var.f1980p;
            this.f1974mt = n3Var.f1974mt;
            this.f1950co = n3Var.f1950co;
            this.f2003z = n3Var.f2003z;
            this.f1983r = n3Var.f1983r;
            this.f1998x4 = n3Var.f1998x4;
            this.f1965i4 = n3Var.f1965i4;
            this.f1959f3 = n3Var.f1959f3;
            this.f1975n = n3Var.f1975n;
            this.f1948c = n3Var.f1948c;
            this.f1953d0 = n3Var.f1953d0;
            this.f1962fh = n3Var.f1962fh;
            this.f1985rz = n3Var.f1985rz;
            this.f1973mg = n3Var.f1973mg;
            this.f1988ta = n3Var.f1988ta;
            this.f1952d = n3Var.f1952d;
            this.f2004z6 = n3Var.f2004z6;
            this.f1956ej = n3Var.f1956ej;
            this.f1991ud = n3Var.f1991ud;
            this.f1946a8 = n3Var.f1946a8;
            this.f1997x = n3Var.f1997x;
            this.f1947b = n3Var.f1947b;
            this.f1971k5 = n3Var.f1971k5;
            this.f2002yt = n3Var.f2002yt;
            this.f1994vl = n3Var.f1994vl;
            this.f1964hw = n3Var.f1964hw;
            this.f1968j5 = n3Var.f1968j5;
            this.f1982qn = n3Var.f1982qn;
            this.f1977o = n3Var.f1977o;
            this.f1967j = n3Var.f1967j;
            this.f1979oz = n3Var.f1979oz;
            this.f1992ut = n3Var.f1992ut;
            this.f1981q9 = n3Var.f1981q9;
            this.f1970k = n3Var.f1970k;
            this.f1960f7 = n3Var.f1960f7;
            this.f1957en = n3Var.f1957en;
            this.f1969jz = n3Var.f1969jz;
            this.f1990u = n3Var.f1990u;
            this.f2001y5 = n3Var.f2001y5;
            this.f2000xg = n3Var.f2000xg;
            this.f1978o4 = n3Var.f1978o4;
            int[] iArr = n3Var.f1954dm;
            if (iArr != null) {
                this.f1954dm = Arrays.copyOf(iArr, iArr.length);
            } else {
                this.f1954dm = null;
            }
            this.f1951ct = n3Var.f1951ct;
            this.f1984rs = n3Var.f1984rs;
            this.f1955eb = n3Var.f1955eb;
            this.f1972lc = n3Var.f1972lc;
        }
    }

    /* loaded from: classes.dex */
    public static class v {

        /* renamed from: wz  reason: collision with root package name */
        public static SparseIntArray f2006wz;

        /* renamed from: c5  reason: collision with root package name */
        public float f2008c5;

        /* renamed from: f  reason: collision with root package name */
        public float f2009f;

        /* renamed from: gv  reason: collision with root package name */
        public float f2011gv;

        /* renamed from: i9  reason: collision with root package name */
        public float f2012i9;

        /* renamed from: n3  reason: collision with root package name */
        public float f2013n3;

        /* renamed from: t  reason: collision with root package name */
        public boolean f2015t;

        /* renamed from: tl  reason: collision with root package name */
        public float f2016tl;
        public boolean y;

        /* renamed from: zn  reason: collision with root package name */
        public float f2018zn;

        /* renamed from: v  reason: collision with root package name */
        public float f2017v = 1.0f;

        /* renamed from: a  reason: collision with root package name */
        public float f2007a = 1.0f;

        /* renamed from: fb  reason: collision with root package name */
        public float f2010fb = Float.NaN;

        /* renamed from: s  reason: collision with root package name */
        public float f2014s = Float.NaN;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f2006wz = sparseIntArray;
            sparseIntArray.append(R$styleable.f1796mo, 1);
            f2006wz.append(R$styleable.f1767i7, 2);
            f2006wz.append(R$styleable.f1729de, 3);
            f2006wz.append(R$styleable.f1769ig, 4);
            f2006wz.append(R$styleable.f1788lf, 5);
            f2006wz.append(R$styleable.f1815oq, 6);
            f2006wz.append(R$styleable.f1881x9, 7);
            f2006wz.append(R$styleable.f1710ao, 8);
            f2006wz.append(R$styleable.f1852tn, 9);
            f2006wz.append(R$styleable.f1849td, 10);
            f2006wz.append(R$styleable.f1829qg, 11);
        }

        public void n3(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f1857u4);
            this.y = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                switch (f2006wz.get(index)) {
                    case 1:
                        this.f2013n3 = obtainStyledAttributes.getFloat(index, this.f2013n3);
                        break;
                    case 2:
                        this.f2018zn = obtainStyledAttributes.getFloat(index, this.f2018zn);
                        break;
                    case 3:
                        this.f2011gv = obtainStyledAttributes.getFloat(index, this.f2011gv);
                        break;
                    case 4:
                        this.f2017v = obtainStyledAttributes.getFloat(index, this.f2017v);
                        break;
                    case 5:
                        this.f2007a = obtainStyledAttributes.getFloat(index, this.f2007a);
                        break;
                    case 6:
                        this.f2010fb = obtainStyledAttributes.getDimension(index, this.f2010fb);
                        break;
                    case 7:
                        this.f2014s = obtainStyledAttributes.getDimension(index, this.f2014s);
                        break;
                    case 8:
                        this.f2008c5 = obtainStyledAttributes.getDimension(index, this.f2008c5);
                        break;
                    case 9:
                        this.f2012i9 = obtainStyledAttributes.getDimension(index, this.f2012i9);
                        break;
                    case 10:
                        this.f2009f = obtainStyledAttributes.getDimension(index, this.f2009f);
                        break;
                    case 11:
                        this.f2015t = true;
                        this.f2016tl = obtainStyledAttributes.getDimension(index, this.f2016tl);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }

        public void y(v vVar) {
            this.y = vVar.y;
            this.f2013n3 = vVar.f2013n3;
            this.f2018zn = vVar.f2018zn;
            this.f2011gv = vVar.f2011gv;
            this.f2017v = vVar.f2017v;
            this.f2007a = vVar.f2007a;
            this.f2010fb = vVar.f2010fb;
            this.f2014s = vVar.f2014s;
            this.f2008c5 = vVar.f2008c5;
            this.f2012i9 = vVar.f2012i9;
            this.f2009f = vVar.f2009f;
            this.f2015t = vVar.f2015t;
            this.f2016tl = vVar.f2016tl;
        }
    }

    /* loaded from: classes.dex */
    public static class y {
        public int y;

        /* renamed from: n3  reason: collision with root package name */
        public final gv f2021n3 = new gv();

        /* renamed from: zn  reason: collision with root package name */
        public final C0017zn f2023zn = new C0017zn();

        /* renamed from: gv  reason: collision with root package name */
        public final n3 f2020gv = new n3();

        /* renamed from: v  reason: collision with root package name */
        public final v f2022v = new v();

        /* renamed from: a  reason: collision with root package name */
        public HashMap<String, androidx.constraintlayout.widget.y> f2019a = new HashMap<>();

        public final void a(int i, ConstraintLayout.n3 n3Var) {
            this.y = i;
            n3 n3Var2 = this.f2020gv;
            n3Var2.f1986s = n3Var.f1652gv;
            n3Var2.f1949c5 = n3Var.f1685v;
            n3Var2.f1966i9 = n3Var.f1632a;
            n3Var2.f1958f = n3Var.f1650fb;
            n3Var2.f1987t = n3Var.f1677s;
            n3Var2.f1989tl = n3Var.f1637c5;
            n3Var2.f1996wz = n3Var.f1655i9;
            n3Var2.f1999xc = n3Var.f1647f;
            n3Var2.f1995w = n3Var.f1679t;
            n3Var2.f1980p = n3Var.f1687w;
            n3Var2.f1974mt = n3Var.f1670p;
            n3Var2.f1950co = n3Var.f1663mt;
            n3Var2.f2003z = n3Var.f1638co;
            n3Var2.f1983r = n3Var.f1636c;
            n3Var2.f1998x4 = n3Var.f1641d0;
            n3Var2.f1965i4 = n3Var.f1651fh;
            n3Var2.f1959f3 = n3Var.f1681tl;
            n3Var2.f1975n = n3Var.f1688wz;
            n3Var2.f1948c = n3Var.f1691xc;
            n3Var2.f1953d0 = n3Var.f1657j5;
            n3Var2.f1962fh = n3Var.f1672qn;
            n3Var2.f1985rz = n3Var.f1667o;
            n3Var2.f1961fb = n3Var.f1697zn;
            n3Var2.f1993v = n3Var.y;
            n3Var2.f1945a = n3Var.f1665n3;
            n3Var2.f2005zn = ((ViewGroup.MarginLayoutParams) n3Var).width;
            n3Var2.f1963gv = ((ViewGroup.MarginLayoutParams) n3Var).height;
            n3Var2.f1973mg = ((ViewGroup.MarginLayoutParams) n3Var).leftMargin;
            n3Var2.f1988ta = ((ViewGroup.MarginLayoutParams) n3Var).rightMargin;
            n3Var2.f1952d = ((ViewGroup.MarginLayoutParams) n3Var).topMargin;
            n3Var2.f2004z6 = ((ViewGroup.MarginLayoutParams) n3Var).bottomMargin;
            n3Var2.f1964hw = n3Var.f1640d;
            n3Var2.f1968j5 = n3Var.f1680ta;
            n3Var2.f1977o = n3Var.f1645ej;
            n3Var2.f1982qn = n3Var.f1696z6;
            n3Var2.f1984rs = n3Var.f1656j;
            n3Var2.f1955eb = n3Var.f1669oz;
            n3Var2.f1967j = n3Var.f1683ud;
            n3Var2.f1979oz = n3Var.f1633a8;
            n3Var2.f1992ut = n3Var.f1660k5;
            n3Var2.f1981q9 = n3Var.f1694yt;
            n3Var2.f1970k = n3Var.f1689x;
            n3Var2.f1960f7 = n3Var.f1635b;
            n3Var2.f1957en = n3Var.f1686vl;
            n3Var2.f1969jz = n3Var.f1653hw;
            n3Var2.f1978o4 = n3Var.f1684ut;
            n3Var2.f1997x = n3Var.f1673r;
            n3Var2.f1971k5 = n3Var.f1654i4;
            n3Var2.f1946a8 = n3Var.f1695z;
            n3Var2.f1947b = n3Var.f1690x4;
            n3Var2.f1994vl = n3Var.f1648f3;
            n3Var2.f2002yt = n3Var.f1664n;
            n3Var2.f1956ej = n3Var.getMarginEnd();
            this.f2020gv.f1991ud = n3Var.getMarginStart();
        }

        public final void fb(int i, gv.y yVar) {
            a(i, yVar);
            this.f2021n3.f1940gv = yVar.f1913yg;
            v vVar = this.f2022v;
            vVar.f2013n3 = yVar.f1908rb;
            vVar.f2018zn = yVar.f1903g3;
            vVar.f2011gv = yVar.f1905m;
            vVar.f2017v = yVar.f1902g;
            vVar.f2007a = yVar.f1910u0;
            vVar.f2010fb = yVar.f1901bk;
            vVar.f2014s = yVar.f1911y4;
            vVar.f2008c5 = yVar.f1909tg;
            vVar.f2012i9 = yVar.f1907pz;
            vVar.f2009f = yVar.f1906pq;
            vVar.f2016tl = yVar.f1904kp;
            vVar.f2015t = yVar.f1912yc;
        }

        public void gv(ConstraintLayout.n3 n3Var) {
            n3 n3Var2 = this.f2020gv;
            n3Var.f1652gv = n3Var2.f1986s;
            n3Var.f1685v = n3Var2.f1949c5;
            n3Var.f1632a = n3Var2.f1966i9;
            n3Var.f1650fb = n3Var2.f1958f;
            n3Var.f1677s = n3Var2.f1987t;
            n3Var.f1637c5 = n3Var2.f1989tl;
            n3Var.f1655i9 = n3Var2.f1996wz;
            n3Var.f1647f = n3Var2.f1999xc;
            n3Var.f1679t = n3Var2.f1995w;
            n3Var.f1687w = n3Var2.f1980p;
            n3Var.f1670p = n3Var2.f1974mt;
            n3Var.f1663mt = n3Var2.f1950co;
            n3Var.f1638co = n3Var2.f2003z;
            ((ViewGroup.MarginLayoutParams) n3Var).leftMargin = n3Var2.f1973mg;
            ((ViewGroup.MarginLayoutParams) n3Var).rightMargin = n3Var2.f1988ta;
            ((ViewGroup.MarginLayoutParams) n3Var).topMargin = n3Var2.f1952d;
            ((ViewGroup.MarginLayoutParams) n3Var).bottomMargin = n3Var2.f2004z6;
            n3Var.f1648f3 = n3Var2.f1994vl;
            n3Var.f1664n = n3Var2.f2002yt;
            n3Var.f1673r = n3Var2.f1997x;
            n3Var.f1654i4 = n3Var2.f1971k5;
            n3Var.f1636c = n3Var2.f1983r;
            n3Var.f1641d0 = n3Var2.f1998x4;
            n3Var.f1681tl = n3Var2.f1959f3;
            n3Var.f1688wz = n3Var2.f1975n;
            n3Var.f1691xc = n3Var2.f1948c;
            n3Var.f1651fh = n3Var2.f1965i4;
            n3Var.f1657j5 = n3Var2.f1953d0;
            n3Var.f1672qn = n3Var2.f1962fh;
            n3Var.f1640d = n3Var2.f1964hw;
            n3Var.f1680ta = n3Var2.f1968j5;
            n3Var.f1645ej = n3Var2.f1977o;
            n3Var.f1696z6 = n3Var2.f1982qn;
            n3Var.f1656j = n3Var2.f1984rs;
            n3Var.f1669oz = n3Var2.f1955eb;
            n3Var.f1683ud = n3Var2.f1967j;
            n3Var.f1633a8 = n3Var2.f1979oz;
            n3Var.f1660k5 = n3Var2.f1992ut;
            n3Var.f1694yt = n3Var2.f1981q9;
            n3Var.f1689x = n3Var2.f1970k;
            n3Var.f1635b = n3Var2.f1960f7;
            n3Var.f1686vl = n3Var2.f1957en;
            n3Var.f1653hw = n3Var2.f1969jz;
            n3Var.f1667o = n3Var2.f1985rz;
            n3Var.f1697zn = n3Var2.f1961fb;
            n3Var.y = n3Var2.f1993v;
            n3Var.f1665n3 = n3Var2.f1945a;
            ((ViewGroup.MarginLayoutParams) n3Var).width = n3Var2.f2005zn;
            ((ViewGroup.MarginLayoutParams) n3Var).height = n3Var2.f1963gv;
            String str = n3Var2.f1978o4;
            if (str != null) {
                n3Var.f1684ut = str;
            }
            n3Var.setMarginStart(n3Var2.f1991ud);
            n3Var.setMarginEnd(this.f2020gv.f1956ej);
            n3Var.y();
        }

        public final void s(androidx.constraintlayout.widget.n3 n3Var, int i, gv.y yVar) {
            fb(i, yVar);
            if (n3Var instanceof Barrier) {
                n3 n3Var2 = this.f2020gv;
                n3Var2.f2000xg = 1;
                Barrier barrier = (Barrier) n3Var;
                n3Var2.f1990u = barrier.getType();
                this.f2020gv.f1954dm = barrier.getReferencedIds();
                this.f2020gv.f2001y5 = barrier.getMargin();
            }
        }

        /* renamed from: v */
        public y clone() {
            y yVar = new y();
            yVar.f2020gv.y(this.f2020gv);
            yVar.f2023zn.y(this.f2023zn);
            yVar.f2021n3.y(this.f2021n3);
            yVar.f2022v.y(this.f2022v);
            yVar.y = this.y;
            return yVar;
        }
    }

    /* renamed from: androidx.constraintlayout.widget.zn$zn  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0017zn {

        /* renamed from: s  reason: collision with root package name */
        public static SparseIntArray f2024s;

        /* renamed from: v  reason: collision with root package name */
        public int f2029v;
        public boolean y;

        /* renamed from: zn  reason: collision with root package name */
        public String f2030zn;

        /* renamed from: n3  reason: collision with root package name */
        public int f2028n3 = -1;

        /* renamed from: gv  reason: collision with root package name */
        public int f2027gv = -1;

        /* renamed from: a  reason: collision with root package name */
        public float f2025a = Float.NaN;

        /* renamed from: fb  reason: collision with root package name */
        public float f2026fb = Float.NaN;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f2024s = sparseIntArray;
            sparseIntArray.append(R$styleable.f1900zr, 1);
            f2024s.append(R$styleable.f1757h4, 2);
            f2024s.append(R$styleable.f1790lw, 3);
            f2024s.append(R$styleable.f1820p7, 4);
            f2024s.append(R$styleable.f1774je, 5);
            f2024s.append(R$styleable.f1733dq, 6);
        }

        public void n3(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f1709af);
            this.y = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                switch (f2024s.get(index)) {
                    case 1:
                        this.f2026fb = obtainStyledAttributes.getFloat(index, this.f2026fb);
                        break;
                    case 2:
                        this.f2027gv = obtainStyledAttributes.getInt(index, this.f2027gv);
                        break;
                    case 3:
                        if (obtainStyledAttributes.peekValue(index).type == 3) {
                            this.f2030zn = obtainStyledAttributes.getString(index);
                            break;
                        } else {
                            this.f2030zn = x4.y.f14917zn[obtainStyledAttributes.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        this.f2029v = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.f2028n3 = zn.p(obtainStyledAttributes, index, this.f2028n3);
                        break;
                    case 6:
                        this.f2025a = obtainStyledAttributes.getFloat(index, this.f2025a);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }

        public void y(C0017zn c0017zn) {
            this.y = c0017zn.y;
            this.f2028n3 = c0017zn.f2028n3;
            this.f2030zn = c0017zn.f2030zn;
            this.f2027gv = c0017zn.f2027gv;
            this.f2029v = c0017zn.f2029v;
            this.f2026fb = c0017zn.f2026fb;
            this.f2025a = c0017zn.f2025a;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f1937v = sparseIntArray;
        sparseIntArray.append(R$styleable.f1791m, 25);
        f1937v.append(R$styleable.f1751g, 26);
        f1937v.append(R$styleable.f1713bk, 29);
        f1937v.append(R$styleable.f1887y4, 30);
        f1937v.append(R$styleable.f1882xb, 36);
        f1937v.append(R$styleable.f1810o0, 35);
        f1937v.append(R$styleable.f1888y5, 4);
        f1937v.append(R$styleable.f1855u, 3);
        f1937v.append(R$styleable.f1741en, 1);
        f1937v.append(R$styleable.f1868vp, 6);
        f1937v.append(R$styleable.f1812oa, 7);
        f1937v.append(R$styleable.f1786lc, 17);
        f1937v.append(R$styleable.f1806nf, 18);
        f1937v.append(R$styleable.f1837ra, 19);
        f1937v.append(R$styleable.f1720co, 27);
        f1937v.append(R$styleable.f1850tg, 32);
        f1937v.append(R$styleable.f1824pz, 33);
        f1937v.append(R$styleable.f1738eb, 10);
        f1937v.append(R$styleable.f1840rs, 9);
        f1937v.append(R$styleable.f1880x5, 13);
        f1937v.append(R$styleable.f1787le, 16);
        f1937v.append(R$styleable.f1827q5, 14);
        f1937v.append(R$styleable.f1872w9, 11);
        f1937v.append(R$styleable.f1797mp, 15);
        f1937v.append(R$styleable.f1870w2, 12);
        f1937v.append(R$styleable.f1724cy, 40);
        f1937v.append(R$styleable.f1838rb, 39);
        f1937v.append(R$styleable.f1780kp, 41);
        f1937v.append(R$styleable.f1708ad, 42);
        f1937v.append(R$styleable.f1890yc, 20);
        f1937v.append(R$styleable.f1873wf, 37);
        f1937v.append(R$styleable.f1811o4, 5);
        f1937v.append(R$styleable.f1752g3, 82);
        f1937v.append(R$styleable.f1721cr, 82);
        f1937v.append(R$styleable.f1856u0, 82);
        f1937v.append(R$styleable.f1777jz, 82);
        f1937v.append(R$styleable.f1745f7, 82);
        f1937v.append(R$styleable.f1743f3, 24);
        f1937v.append(R$styleable.f1717c, 28);
        f1937v.append(R$styleable.f1712b, 31);
        f1937v.append(R$styleable.f1779k5, 8);
        f1937v.append(R$styleable.f1800n, 34);
        f1937v.append(R$styleable.f1726d0, 2);
        f1937v.append(R$styleable.f1879x4, 23);
        f1937v.append(R$styleable.f1766i4, 21);
        f1937v.append(R$styleable.f1835r, 22);
        f1937v.append(R$styleable.f1748fh, 43);
        f1937v.append(R$styleable.f1866vl, 44);
        f1937v.append(R$styleable.f1706a8, 45);
        f1937v.append(R$styleable.f1877x, 46);
        f1937v.append(R$styleable.f1859ud, 60);
        f1937v.append(R$styleable.f1895z6, 47);
        f1937v.append(R$styleable.f1739ej, 48);
        f1937v.append(R$styleable.f1841rz, 49);
        f1937v.append(R$styleable.f1794mg, 50);
        f1937v.append(R$styleable.f1848ta, 51);
        f1937v.append(R$styleable.f1725d, 52);
        f1937v.append(R$styleable.f1893yt, 53);
        f1937v.append(R$styleable.f1832qk, 54);
        f1937v.append(R$styleable.f1735e, 55);
        f1937v.append(R$styleable.f1831qj, 56);
        f1937v.append(R$styleable.f1844s8, 57);
        f1937v.append(R$styleable.f1783l, 58);
        f1937v.append(R$styleable.f1711ap, 59);
        f1937v.append(R$styleable.f1884xg, 61);
        f1937v.append(R$styleable.f1723ct, 62);
        f1937v.append(R$styleable.f1732dm, 63);
        f1937v.append(R$styleable.f1763hw, 64);
        f1937v.append(R$styleable.f1892yk, 65);
        f1937v.append(R$styleable.f1863ut, 66);
        f1937v.append(R$styleable.f1764i2, 67);
        f1937v.append(R$styleable.f1839ro, 79);
        f1937v.append(R$styleable.f1894z, 38);
        f1937v.append(R$styleable.f1722cs, 68);
        f1937v.append(R$styleable.f1754gq, 69);
        f1937v.append(R$styleable.f1891yg, 70);
        f1937v.append(R$styleable.f1771j, 71);
        f1937v.append(R$styleable.f1833qn, 72);
        f1937v.append(R$styleable.f1809o, 73);
        f1937v.append(R$styleable.f1816oz, 74);
        f1937v.append(R$styleable.f1773j5, 75);
        f1937v.append(R$styleable.f1770ix, 76);
        f1937v.append(R$styleable.f1821pq, 77);
        f1937v.append(R$styleable.f1765i3, 78);
        f1937v.append(R$styleable.f1778k, 80);
        f1937v.append(R$styleable.f1828q9, 81);
    }

    public static int p(TypedArray typedArray, int i, int i5) {
        int resourceId = typedArray.getResourceId(i, i5);
        if (resourceId == -1) {
            return typedArray.getInt(i, -1);
        }
        return resourceId;
    }

    public void a(Context context, int i) {
        fb((ConstraintLayout) LayoutInflater.from(context).inflate(i, (ViewGroup) null));
    }

    public void c5(int i, int i5, int i6, int i8) {
        if (!this.f1939zn.containsKey(Integer.valueOf(i))) {
            this.f1939zn.put(Integer.valueOf(i), new y());
        }
        y yVar = this.f1939zn.get(Integer.valueOf(i));
        switch (i5) {
            case 1:
                if (i8 == 1) {
                    n3 n3Var = yVar.f2020gv;
                    n3Var.f1986s = i6;
                    n3Var.f1949c5 = -1;
                    return;
                } else if (i8 == 2) {
                    n3 n3Var2 = yVar.f2020gv;
                    n3Var2.f1949c5 = i6;
                    n3Var2.f1986s = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("left to " + r(i8) + " undefined");
                }
            case 2:
                if (i8 == 1) {
                    n3 n3Var3 = yVar.f2020gv;
                    n3Var3.f1966i9 = i6;
                    n3Var3.f1958f = -1;
                    return;
                } else if (i8 == 2) {
                    n3 n3Var4 = yVar.f2020gv;
                    n3Var4.f1958f = i6;
                    n3Var4.f1966i9 = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + r(i8) + " undefined");
                }
            case 3:
                if (i8 == 3) {
                    n3 n3Var5 = yVar.f2020gv;
                    n3Var5.f1987t = i6;
                    n3Var5.f1989tl = -1;
                    n3Var5.f1995w = -1;
                    return;
                } else if (i8 == 4) {
                    n3 n3Var6 = yVar.f2020gv;
                    n3Var6.f1989tl = i6;
                    n3Var6.f1987t = -1;
                    n3Var6.f1995w = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + r(i8) + " undefined");
                }
            case 4:
                if (i8 == 4) {
                    n3 n3Var7 = yVar.f2020gv;
                    n3Var7.f1999xc = i6;
                    n3Var7.f1996wz = -1;
                    n3Var7.f1995w = -1;
                    return;
                } else if (i8 == 3) {
                    n3 n3Var8 = yVar.f2020gv;
                    n3Var8.f1996wz = i6;
                    n3Var8.f1999xc = -1;
                    n3Var8.f1995w = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + r(i8) + " undefined");
                }
            case 5:
                if (i8 == 5) {
                    n3 n3Var9 = yVar.f2020gv;
                    n3Var9.f1995w = i6;
                    n3Var9.f1999xc = -1;
                    n3Var9.f1996wz = -1;
                    n3Var9.f1987t = -1;
                    n3Var9.f1989tl = -1;
                    return;
                }
                throw new IllegalArgumentException("right to " + r(i8) + " undefined");
            case 6:
                if (i8 == 6) {
                    n3 n3Var10 = yVar.f2020gv;
                    n3Var10.f1974mt = i6;
                    n3Var10.f1980p = -1;
                    return;
                } else if (i8 == 7) {
                    n3 n3Var11 = yVar.f2020gv;
                    n3Var11.f1980p = i6;
                    n3Var11.f1974mt = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + r(i8) + " undefined");
                }
            case 7:
                if (i8 == 7) {
                    n3 n3Var12 = yVar.f2020gv;
                    n3Var12.f2003z = i6;
                    n3Var12.f1950co = -1;
                    return;
                } else if (i8 == 6) {
                    n3 n3Var13 = yVar.f2020gv;
                    n3Var13.f1950co = i6;
                    n3Var13.f2003z = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + r(i8) + " undefined");
                }
            default:
                throw new IllegalArgumentException(r(i5) + " to " + r(i8) + " unknown");
        }
    }

    public void co(int i, String str) {
        wz(i).f2020gv.f1965i4 = str;
    }

    public void f(int i, int i5) {
        wz(i).f2020gv.f2005zn = i5;
    }

    public void fb(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.f1939zn.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            ConstraintLayout.n3 n3Var = (ConstraintLayout.n3) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f1938n3 && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f1939zn.containsKey(Integer.valueOf(id))) {
                this.f1939zn.put(Integer.valueOf(id), new y());
            }
            y yVar = this.f1939zn.get(Integer.valueOf(id));
            yVar.f2019a = androidx.constraintlayout.widget.y.y(this.y, childAt);
            yVar.a(id, n3Var);
            yVar.f2021n3.f1941n3 = childAt.getVisibility();
            yVar.f2021n3.f1940gv = childAt.getAlpha();
            yVar.f2022v.f2013n3 = childAt.getRotation();
            yVar.f2022v.f2018zn = childAt.getRotationX();
            yVar.f2022v.f2011gv = childAt.getRotationY();
            yVar.f2022v.f2017v = childAt.getScaleX();
            yVar.f2022v.f2007a = childAt.getScaleY();
            float pivotX = childAt.getPivotX();
            float pivotY = childAt.getPivotY();
            if (pivotX != 0.0d || pivotY != 0.0d) {
                v vVar = yVar.f2022v;
                vVar.f2010fb = pivotX;
                vVar.f2014s = pivotY;
            }
            yVar.f2022v.f2008c5 = childAt.getTranslationX();
            yVar.f2022v.f2012i9 = childAt.getTranslationY();
            yVar.f2022v.f2009f = childAt.getTranslationZ();
            v vVar2 = yVar.f2022v;
            if (vVar2.f2015t) {
                vVar2.f2016tl = childAt.getElevation();
            }
            if (childAt instanceof Barrier) {
                Barrier barrier = (Barrier) childAt;
                yVar.f2020gv.f1972lc = barrier.xc();
                yVar.f2020gv.f1954dm = barrier.getReferencedIds();
                yVar.f2020gv.f1990u = barrier.getType();
                yVar.f2020gv.f2001y5 = barrier.getMargin();
            }
        }
    }

    public void gv(ConstraintLayout constraintLayout, boolean z2) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f1939zn.keySet());
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (!this.f1939zn.containsKey(Integer.valueOf(id))) {
                Log.w("ConstraintSet", "id unknown " + i4.y.y(childAt));
            } else if (this.f1938n3 && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else {
                if (id != -1 && this.f1939zn.containsKey(Integer.valueOf(id))) {
                    hashSet.remove(Integer.valueOf(id));
                    y yVar = this.f1939zn.get(Integer.valueOf(id));
                    if (childAt instanceof Barrier) {
                        yVar.f2020gv.f2000xg = 1;
                    }
                    int i5 = yVar.f2020gv.f2000xg;
                    if (i5 != -1 && i5 == 1) {
                        Barrier barrier = (Barrier) childAt;
                        barrier.setId(id);
                        barrier.setType(yVar.f2020gv.f1990u);
                        barrier.setMargin(yVar.f2020gv.f2001y5);
                        barrier.setAllowsGoneWidget(yVar.f2020gv.f1972lc);
                        n3 n3Var = yVar.f2020gv;
                        int[] iArr = n3Var.f1954dm;
                        if (iArr != null) {
                            barrier.setReferencedIds(iArr);
                        } else {
                            String str = n3Var.f1951ct;
                            if (str != null) {
                                n3Var.f1954dm = t(barrier, str);
                                barrier.setReferencedIds(yVar.f2020gv.f1954dm);
                            }
                        }
                    }
                    ConstraintLayout.n3 n3Var2 = (ConstraintLayout.n3) childAt.getLayoutParams();
                    n3Var2.y();
                    yVar.gv(n3Var2);
                    if (z2) {
                        androidx.constraintlayout.widget.y.zn(childAt, yVar.f2019a);
                    }
                    childAt.setLayoutParams(n3Var2);
                    gv gvVar = yVar.f2021n3;
                    if (gvVar.f1943zn == 0) {
                        childAt.setVisibility(gvVar.f1941n3);
                    }
                    childAt.setAlpha(yVar.f2021n3.f1940gv);
                    childAt.setRotation(yVar.f2022v.f2013n3);
                    childAt.setRotationX(yVar.f2022v.f2018zn);
                    childAt.setRotationY(yVar.f2022v.f2011gv);
                    childAt.setScaleX(yVar.f2022v.f2017v);
                    childAt.setScaleY(yVar.f2022v.f2007a);
                    if (!Float.isNaN(yVar.f2022v.f2010fb)) {
                        childAt.setPivotX(yVar.f2022v.f2010fb);
                    }
                    if (!Float.isNaN(yVar.f2022v.f2014s)) {
                        childAt.setPivotY(yVar.f2022v.f2014s);
                    }
                    childAt.setTranslationX(yVar.f2022v.f2008c5);
                    childAt.setTranslationY(yVar.f2022v.f2012i9);
                    childAt.setTranslationZ(yVar.f2022v.f2009f);
                    v vVar = yVar.f2022v;
                    if (vVar.f2015t) {
                        childAt.setElevation(vVar.f2016tl);
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            y yVar2 = this.f1939zn.get(num);
            int i6 = yVar2.f2020gv.f2000xg;
            if (i6 != -1 && i6 == 1) {
                Barrier barrier2 = new Barrier(constraintLayout.getContext());
                barrier2.setId(num.intValue());
                n3 n3Var3 = yVar2.f2020gv;
                int[] iArr2 = n3Var3.f1954dm;
                if (iArr2 != null) {
                    barrier2.setReferencedIds(iArr2);
                } else {
                    String str2 = n3Var3.f1951ct;
                    if (str2 != null) {
                        n3Var3.f1954dm = t(barrier2, str2);
                        barrier2.setReferencedIds(yVar2.f2020gv.f1954dm);
                    }
                }
                barrier2.setType(yVar2.f2020gv.f1990u);
                barrier2.setMargin(yVar2.f2020gv.f2001y5);
                ConstraintLayout.n3 generateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                barrier2.wz();
                yVar2.gv(generateDefaultLayoutParams);
                constraintLayout.addView(barrier2, generateDefaultLayoutParams);
            }
            if (yVar2.f2020gv.y) {
                View guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                ConstraintLayout.n3 generateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                yVar2.gv(generateDefaultLayoutParams2);
                constraintLayout.addView(guideline, generateDefaultLayoutParams2);
            }
        }
    }

    public void i9(int i, int i5, int i6, float f4) {
        n3 n3Var = wz(i).f2020gv;
        n3Var.f1959f3 = i5;
        n3Var.f1975n = i6;
        n3Var.f1948c = f4;
    }

    public final void mt(Context context, y yVar, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            if (index != R$styleable.f1894z && R$styleable.f1712b != index && R$styleable.f1779k5 != index) {
                yVar.f2023zn.y = true;
                yVar.f2020gv.f1976n3 = true;
                yVar.f2021n3.y = true;
                yVar.f2022v.y = true;
            }
            switch (f1937v.get(index)) {
                case 1:
                    n3 n3Var = yVar.f2020gv;
                    n3Var.f1995w = p(typedArray, index, n3Var.f1995w);
                    break;
                case 2:
                    n3 n3Var2 = yVar.f2020gv;
                    n3Var2.f2004z6 = typedArray.getDimensionPixelSize(index, n3Var2.f2004z6);
                    break;
                case 3:
                    n3 n3Var3 = yVar.f2020gv;
                    n3Var3.f1999xc = p(typedArray, index, n3Var3.f1999xc);
                    break;
                case 4:
                    n3 n3Var4 = yVar.f2020gv;
                    n3Var4.f1996wz = p(typedArray, index, n3Var4.f1996wz);
                    break;
                case 5:
                    yVar.f2020gv.f1965i4 = typedArray.getString(index);
                    break;
                case 6:
                    n3 n3Var5 = yVar.f2020gv;
                    n3Var5.f1953d0 = typedArray.getDimensionPixelOffset(index, n3Var5.f1953d0);
                    break;
                case 7:
                    n3 n3Var6 = yVar.f2020gv;
                    n3Var6.f1962fh = typedArray.getDimensionPixelOffset(index, n3Var6.f1962fh);
                    break;
                case 8:
                    n3 n3Var7 = yVar.f2020gv;
                    n3Var7.f1956ej = typedArray.getDimensionPixelSize(index, n3Var7.f1956ej);
                    break;
                case 9:
                    n3 n3Var8 = yVar.f2020gv;
                    n3Var8.f2003z = p(typedArray, index, n3Var8.f2003z);
                    break;
                case 10:
                    n3 n3Var9 = yVar.f2020gv;
                    n3Var9.f1950co = p(typedArray, index, n3Var9.f1950co);
                    break;
                case 11:
                    n3 n3Var10 = yVar.f2020gv;
                    n3Var10.f1971k5 = typedArray.getDimensionPixelSize(index, n3Var10.f1971k5);
                    break;
                case 12:
                    n3 n3Var11 = yVar.f2020gv;
                    n3Var11.f2002yt = typedArray.getDimensionPixelSize(index, n3Var11.f2002yt);
                    break;
                case 13:
                    n3 n3Var12 = yVar.f2020gv;
                    n3Var12.f1946a8 = typedArray.getDimensionPixelSize(index, n3Var12.f1946a8);
                    break;
                case 14:
                    n3 n3Var13 = yVar.f2020gv;
                    n3Var13.f1947b = typedArray.getDimensionPixelSize(index, n3Var13.f1947b);
                    break;
                case 15:
                    n3 n3Var14 = yVar.f2020gv;
                    n3Var14.f1994vl = typedArray.getDimensionPixelSize(index, n3Var14.f1994vl);
                    break;
                case 16:
                    n3 n3Var15 = yVar.f2020gv;
                    n3Var15.f1997x = typedArray.getDimensionPixelSize(index, n3Var15.f1997x);
                    break;
                case 17:
                    n3 n3Var16 = yVar.f2020gv;
                    n3Var16.f1993v = typedArray.getDimensionPixelOffset(index, n3Var16.f1993v);
                    break;
                case 18:
                    n3 n3Var17 = yVar.f2020gv;
                    n3Var17.f1945a = typedArray.getDimensionPixelOffset(index, n3Var17.f1945a);
                    break;
                case 19:
                    n3 n3Var18 = yVar.f2020gv;
                    n3Var18.f1961fb = typedArray.getFloat(index, n3Var18.f1961fb);
                    break;
                case 20:
                    n3 n3Var19 = yVar.f2020gv;
                    n3Var19.f1983r = typedArray.getFloat(index, n3Var19.f1983r);
                    break;
                case 21:
                    n3 n3Var20 = yVar.f2020gv;
                    n3Var20.f1963gv = typedArray.getLayoutDimension(index, n3Var20.f1963gv);
                    break;
                case 22:
                    gv gvVar = yVar.f2021n3;
                    gvVar.f1941n3 = typedArray.getInt(index, gvVar.f1941n3);
                    gv gvVar2 = yVar.f2021n3;
                    gvVar2.f1941n3 = f1936gv[gvVar2.f1941n3];
                    break;
                case 23:
                    n3 n3Var21 = yVar.f2020gv;
                    n3Var21.f2005zn = typedArray.getLayoutDimension(index, n3Var21.f2005zn);
                    break;
                case 24:
                    n3 n3Var22 = yVar.f2020gv;
                    n3Var22.f1973mg = typedArray.getDimensionPixelSize(index, n3Var22.f1973mg);
                    break;
                case 25:
                    n3 n3Var23 = yVar.f2020gv;
                    n3Var23.f1986s = p(typedArray, index, n3Var23.f1986s);
                    break;
                case 26:
                    n3 n3Var24 = yVar.f2020gv;
                    n3Var24.f1949c5 = p(typedArray, index, n3Var24.f1949c5);
                    break;
                case 27:
                    n3 n3Var25 = yVar.f2020gv;
                    n3Var25.f1985rz = typedArray.getInt(index, n3Var25.f1985rz);
                    break;
                case 28:
                    n3 n3Var26 = yVar.f2020gv;
                    n3Var26.f1988ta = typedArray.getDimensionPixelSize(index, n3Var26.f1988ta);
                    break;
                case 29:
                    n3 n3Var27 = yVar.f2020gv;
                    n3Var27.f1966i9 = p(typedArray, index, n3Var27.f1966i9);
                    break;
                case 30:
                    n3 n3Var28 = yVar.f2020gv;
                    n3Var28.f1958f = p(typedArray, index, n3Var28.f1958f);
                    break;
                case 31:
                    n3 n3Var29 = yVar.f2020gv;
                    n3Var29.f1991ud = typedArray.getDimensionPixelSize(index, n3Var29.f1991ud);
                    break;
                case 32:
                    n3 n3Var30 = yVar.f2020gv;
                    n3Var30.f1980p = p(typedArray, index, n3Var30.f1980p);
                    break;
                case 33:
                    n3 n3Var31 = yVar.f2020gv;
                    n3Var31.f1974mt = p(typedArray, index, n3Var31.f1974mt);
                    break;
                case 34:
                    n3 n3Var32 = yVar.f2020gv;
                    n3Var32.f1952d = typedArray.getDimensionPixelSize(index, n3Var32.f1952d);
                    break;
                case 35:
                    n3 n3Var33 = yVar.f2020gv;
                    n3Var33.f1989tl = p(typedArray, index, n3Var33.f1989tl);
                    break;
                case 36:
                    n3 n3Var34 = yVar.f2020gv;
                    n3Var34.f1987t = p(typedArray, index, n3Var34.f1987t);
                    break;
                case 37:
                    n3 n3Var35 = yVar.f2020gv;
                    n3Var35.f1998x4 = typedArray.getFloat(index, n3Var35.f1998x4);
                    break;
                case 38:
                    yVar.y = typedArray.getResourceId(index, yVar.y);
                    break;
                case 39:
                    n3 n3Var36 = yVar.f2020gv;
                    n3Var36.f1968j5 = typedArray.getFloat(index, n3Var36.f1968j5);
                    break;
                case 40:
                    n3 n3Var37 = yVar.f2020gv;
                    n3Var37.f1964hw = typedArray.getFloat(index, n3Var37.f1964hw);
                    break;
                case 41:
                    n3 n3Var38 = yVar.f2020gv;
                    n3Var38.f1982qn = typedArray.getInt(index, n3Var38.f1982qn);
                    break;
                case 42:
                    n3 n3Var39 = yVar.f2020gv;
                    n3Var39.f1977o = typedArray.getInt(index, n3Var39.f1977o);
                    break;
                case 43:
                    gv gvVar3 = yVar.f2021n3;
                    gvVar3.f1940gv = typedArray.getFloat(index, gvVar3.f1940gv);
                    break;
                case 44:
                    v vVar = yVar.f2022v;
                    vVar.f2015t = true;
                    vVar.f2016tl = typedArray.getDimension(index, vVar.f2016tl);
                    break;
                case 45:
                    v vVar2 = yVar.f2022v;
                    vVar2.f2018zn = typedArray.getFloat(index, vVar2.f2018zn);
                    break;
                case 46:
                    v vVar3 = yVar.f2022v;
                    vVar3.f2011gv = typedArray.getFloat(index, vVar3.f2011gv);
                    break;
                case 47:
                    v vVar4 = yVar.f2022v;
                    vVar4.f2017v = typedArray.getFloat(index, vVar4.f2017v);
                    break;
                case 48:
                    v vVar5 = yVar.f2022v;
                    vVar5.f2007a = typedArray.getFloat(index, vVar5.f2007a);
                    break;
                case 49:
                    v vVar6 = yVar.f2022v;
                    vVar6.f2010fb = typedArray.getDimension(index, vVar6.f2010fb);
                    break;
                case 50:
                    v vVar7 = yVar.f2022v;
                    vVar7.f2014s = typedArray.getDimension(index, vVar7.f2014s);
                    break;
                case 51:
                    v vVar8 = yVar.f2022v;
                    vVar8.f2008c5 = typedArray.getDimension(index, vVar8.f2008c5);
                    break;
                case 52:
                    v vVar9 = yVar.f2022v;
                    vVar9.f2012i9 = typedArray.getDimension(index, vVar9.f2012i9);
                    break;
                case 53:
                    v vVar10 = yVar.f2022v;
                    vVar10.f2009f = typedArray.getDimension(index, vVar10.f2009f);
                    break;
                case 54:
                    n3 n3Var40 = yVar.f2020gv;
                    n3Var40.f1967j = typedArray.getInt(index, n3Var40.f1967j);
                    break;
                case 55:
                    n3 n3Var41 = yVar.f2020gv;
                    n3Var41.f1979oz = typedArray.getInt(index, n3Var41.f1979oz);
                    break;
                case 56:
                    n3 n3Var42 = yVar.f2020gv;
                    n3Var42.f1992ut = typedArray.getDimensionPixelSize(index, n3Var42.f1992ut);
                    break;
                case 57:
                    n3 n3Var43 = yVar.f2020gv;
                    n3Var43.f1981q9 = typedArray.getDimensionPixelSize(index, n3Var43.f1981q9);
                    break;
                case 58:
                    n3 n3Var44 = yVar.f2020gv;
                    n3Var44.f1970k = typedArray.getDimensionPixelSize(index, n3Var44.f1970k);
                    break;
                case 59:
                    n3 n3Var45 = yVar.f2020gv;
                    n3Var45.f1960f7 = typedArray.getDimensionPixelSize(index, n3Var45.f1960f7);
                    break;
                case 60:
                    v vVar11 = yVar.f2022v;
                    vVar11.f2013n3 = typedArray.getFloat(index, vVar11.f2013n3);
                    break;
                case 61:
                    n3 n3Var46 = yVar.f2020gv;
                    n3Var46.f1959f3 = p(typedArray, index, n3Var46.f1959f3);
                    break;
                case 62:
                    n3 n3Var47 = yVar.f2020gv;
                    n3Var47.f1975n = typedArray.getDimensionPixelSize(index, n3Var47.f1975n);
                    break;
                case 63:
                    n3 n3Var48 = yVar.f2020gv;
                    n3Var48.f1948c = typedArray.getFloat(index, n3Var48.f1948c);
                    break;
                case 64:
                    C0017zn c0017zn = yVar.f2023zn;
                    c0017zn.f2028n3 = p(typedArray, index, c0017zn.f2028n3);
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        yVar.f2023zn.f2030zn = typedArray.getString(index);
                        break;
                    } else {
                        yVar.f2023zn.f2030zn = x4.y.f14917zn[typedArray.getInteger(index, 0)];
                        break;
                    }
                case 66:
                    yVar.f2023zn.f2029v = typedArray.getInt(index, 0);
                    break;
                case 67:
                    C0017zn c0017zn2 = yVar.f2023zn;
                    c0017zn2.f2026fb = typedArray.getFloat(index, c0017zn2.f2026fb);
                    break;
                case 68:
                    gv gvVar4 = yVar.f2021n3;
                    gvVar4.f1942v = typedArray.getFloat(index, gvVar4.f1942v);
                    break;
                case 69:
                    yVar.f2020gv.f1957en = typedArray.getFloat(index, 1.0f);
                    break;
                case 70:
                    yVar.f2020gv.f1969jz = typedArray.getFloat(index, 1.0f);
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    n3 n3Var49 = yVar.f2020gv;
                    n3Var49.f1990u = typedArray.getInt(index, n3Var49.f1990u);
                    break;
                case 73:
                    n3 n3Var50 = yVar.f2020gv;
                    n3Var50.f2001y5 = typedArray.getDimensionPixelSize(index, n3Var50.f2001y5);
                    break;
                case 74:
                    yVar.f2020gv.f1951ct = typedArray.getString(index);
                    break;
                case 75:
                    n3 n3Var51 = yVar.f2020gv;
                    n3Var51.f1972lc = typedArray.getBoolean(index, n3Var51.f1972lc);
                    break;
                case 76:
                    C0017zn c0017zn3 = yVar.f2023zn;
                    c0017zn3.f2027gv = typedArray.getInt(index, c0017zn3.f2027gv);
                    break;
                case 77:
                    yVar.f2020gv.f1978o4 = typedArray.getString(index);
                    break;
                case 78:
                    gv gvVar5 = yVar.f2021n3;
                    gvVar5.f1943zn = typedArray.getInt(index, gvVar5.f1943zn);
                    break;
                case 79:
                    C0017zn c0017zn4 = yVar.f2023zn;
                    c0017zn4.f2025a = typedArray.getFloat(index, c0017zn4.f2025a);
                    break;
                case 80:
                    n3 n3Var52 = yVar.f2020gv;
                    n3Var52.f1984rs = typedArray.getBoolean(index, n3Var52.f1984rs);
                    break;
                case 81:
                    n3 n3Var53 = yVar.f2020gv;
                    n3Var53.f1955eb = typedArray.getBoolean(index, n3Var53.f1955eb);
                    break;
                case 82:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f1937v.get(index));
                    break;
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f1937v.get(index));
                    break;
            }
        }
    }

    public final String r(int i) {
        switch (i) {
            case 1:
                return "left";
            case 2:
                return "right";
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    public void s(androidx.constraintlayout.widget.gv gvVar) {
        int childCount = gvVar.getChildCount();
        this.f1939zn.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = gvVar.getChildAt(i);
            gv.y yVar = (gv.y) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f1938n3 && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f1939zn.containsKey(Integer.valueOf(id))) {
                this.f1939zn.put(Integer.valueOf(id), new y());
            }
            y yVar2 = this.f1939zn.get(Integer.valueOf(id));
            if (childAt instanceof androidx.constraintlayout.widget.n3) {
                yVar2.s((androidx.constraintlayout.widget.n3) childAt, id, yVar);
            }
            yVar2.fb(id, yVar);
        }
    }

    public final int[] t(View view, String str) {
        int i;
        Object fb2;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i5 = 0;
        int i6 = 0;
        while (i5 < split.length) {
            String trim = split[i5].trim();
            try {
                i = R$id.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i = 0;
            }
            if (i == 0) {
                i = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (fb2 = ((ConstraintLayout) view.getParent()).fb(0, trim)) != null && (fb2 instanceof Integer)) {
                i = ((Integer) fb2).intValue();
            }
            iArr[i6] = i;
            i5++;
            i6++;
        }
        if (i6 != split.length) {
            return Arrays.copyOf(iArr, i6);
        }
        return iArr;
    }

    public final y tl(Context context, AttributeSet attributeSet) {
        y yVar = new y();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f1798mt);
        mt(context, yVar, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return yVar;
    }

    public void v(int i, int i5) {
        if (this.f1939zn.containsKey(Integer.valueOf(i))) {
            y yVar = this.f1939zn.get(Integer.valueOf(i));
            switch (i5) {
                case 1:
                    n3 n3Var = yVar.f2020gv;
                    n3Var.f1949c5 = -1;
                    n3Var.f1986s = -1;
                    n3Var.f1973mg = -1;
                    n3Var.f1946a8 = -1;
                    return;
                case 2:
                    n3 n3Var2 = yVar.f2020gv;
                    n3Var2.f1958f = -1;
                    n3Var2.f1966i9 = -1;
                    n3Var2.f1988ta = -1;
                    n3Var2.f1947b = -1;
                    return;
                case 3:
                    n3 n3Var3 = yVar.f2020gv;
                    n3Var3.f1989tl = -1;
                    n3Var3.f1987t = -1;
                    n3Var3.f1952d = -1;
                    n3Var3.f1997x = -1;
                    return;
                case 4:
                    n3 n3Var4 = yVar.f2020gv;
                    n3Var4.f1996wz = -1;
                    n3Var4.f1999xc = -1;
                    n3Var4.f2004z6 = -1;
                    n3Var4.f1971k5 = -1;
                    return;
                case 5:
                    yVar.f2020gv.f1995w = -1;
                    return;
                case 6:
                    n3 n3Var5 = yVar.f2020gv;
                    n3Var5.f1980p = -1;
                    n3Var5.f1974mt = -1;
                    n3Var5.f1991ud = -1;
                    n3Var5.f1994vl = -1;
                    return;
                case 7:
                    n3 n3Var6 = yVar.f2020gv;
                    n3Var6.f1950co = -1;
                    n3Var6.f2003z = -1;
                    n3Var6.f1956ej = -1;
                    n3Var6.f2002yt = -1;
                    return;
                default:
                    throw new IllegalArgumentException("unknown constraint");
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:99:0x017a, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void w(android.content.Context r9, org.xmlpull.v1.XmlPullParser r10) {
        /*
            Method dump skipped, instructions count: 442
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.zn.w(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public final y wz(int i) {
        if (!this.f1939zn.containsKey(Integer.valueOf(i))) {
            this.f1939zn.put(Integer.valueOf(i), new y());
        }
        return this.f1939zn.get(Integer.valueOf(i));
    }

    public void xc(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType != 0) {
                    if (eventType != 2) {
                        continue;
                    } else {
                        String name = xml.getName();
                        y tl2 = tl(context, Xml.asAttributeSet(xml));
                        if (name.equalsIgnoreCase("Guideline")) {
                            tl2.f2020gv.y = true;
                        }
                        this.f1939zn.put(Integer.valueOf(tl2.y), tl2);
                        continue;
                    }
                } else {
                    xml.getName();
                    continue;
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (XmlPullParserException unused) {
        }
    }

    public void z(int i, float f4) {
        wz(i).f2020gv.f1961fb = f4;
        wz(i).f2020gv.f1945a = -1;
        wz(i).f2020gv.f1993v = -1;
    }

    public void zn(ConstraintLayout constraintLayout) {
        gv(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }
}
