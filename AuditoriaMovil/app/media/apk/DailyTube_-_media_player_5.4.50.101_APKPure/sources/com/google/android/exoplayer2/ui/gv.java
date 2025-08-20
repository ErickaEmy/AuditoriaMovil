package com.google.android.exoplayer2.ui;

import android.text.Html;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ui.gv;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import v5.j5;
import z0.f3;
/* loaded from: classes.dex */
public final class gv {
    public static final Pattern y = Pattern.compile("(&#13;)?&#10;");

    /* renamed from: com.google.android.exoplayer2.ui.gv$gv  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0054gv {
        public final List<zn> y = new ArrayList();

        /* renamed from: n3  reason: collision with root package name */
        public final List<zn> f4833n3 = new ArrayList();
    }

    /* loaded from: classes.dex */
    public static class n3 {

        /* renamed from: n3  reason: collision with root package name */
        public final Map<String, String> f4834n3;
        public final String y;

        public n3(String str, Map<String, String> map) {
            this.y = str;
            this.f4834n3 = map;
        }
    }

    /* loaded from: classes.dex */
    public static final class zn {

        /* renamed from: gv  reason: collision with root package name */
        public final String f4837gv;

        /* renamed from: n3  reason: collision with root package name */
        public final int f4838n3;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final String f4839zn;

        /* renamed from: v  reason: collision with root package name */
        public static final Comparator<zn> f4836v = new Comparator() { // from class: mn.c5
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int v2;
                v2 = gv.zn.v((gv.zn) obj, (gv.zn) obj2);
                return v2;
            }
        };

        /* renamed from: a  reason: collision with root package name */
        public static final Comparator<zn> f4835a = new Comparator() { // from class: mn.i9
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int a2;
                a2 = gv.zn.a((gv.zn) obj, (gv.zn) obj2);
                return a2;
            }
        };

        public static /* synthetic */ int a(zn znVar, zn znVar2) {
            int compare = Integer.compare(znVar2.y, znVar.y);
            if (compare != 0) {
                return compare;
            }
            int compareTo = znVar2.f4839zn.compareTo(znVar.f4839zn);
            if (compareTo != 0) {
                return compareTo;
            }
            return znVar2.f4837gv.compareTo(znVar.f4837gv);
        }

        public static /* synthetic */ int v(zn znVar, zn znVar2) {
            int compare = Integer.compare(znVar2.f4838n3, znVar.f4838n3);
            if (compare != 0) {
                return compare;
            }
            int compareTo = znVar.f4839zn.compareTo(znVar2.f4839zn);
            if (compareTo != 0) {
                return compareTo;
            }
            return znVar.f4837gv.compareTo(znVar2.f4837gv);
        }

        public zn(int i, int i5, String str, String str2) {
            this.y = i;
            this.f4838n3 = i5;
            this.f4839zn = str;
            this.f4837gv = str2;
        }
    }

    public static C0054gv a(SparseArray<C0054gv> sparseArray, int i) {
        C0054gv c0054gv = sparseArray.get(i);
        if (c0054gv == null) {
            C0054gv c0054gv2 = new C0054gv();
            sparseArray.put(i, c0054gv2);
            return c0054gv2;
        }
        return c0054gv;
    }

    public static String fb(int i) {
        if (i != 2) {
            return "over right";
        }
        return "under left";
    }

    @Nullable
    public static String gv(Object obj) {
        if ((obj instanceof StrikethroughSpan) || (obj instanceof ForegroundColorSpan) || (obj instanceof BackgroundColorSpan) || (obj instanceof xp.y) || (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan) || (obj instanceof xp.v)) {
            return "</span>";
        }
        if (obj instanceof TypefaceSpan) {
            if (((TypefaceSpan) obj).getFamily() != null) {
                return "</span>";
            }
            return null;
        }
        if (obj instanceof StyleSpan) {
            int style = ((StyleSpan) obj).getStyle();
            if (style != 1) {
                if (style != 2) {
                    if (style == 3) {
                        return "</i></b>";
                    }
                } else {
                    return "</i>";
                }
            } else {
                return "</b>";
            }
        } else if (obj instanceof xp.zn) {
            return "<rt>" + n3(((xp.zn) obj).y) + "</rt></ruby>";
        } else if (obj instanceof UnderlineSpan) {
            return "</u>";
        }
        return null;
    }

    public static String n3(CharSequence charSequence) {
        return y.matcher(Html.escapeHtml(charSequence)).replaceAll("<br>");
    }

    public static String s(int i, int i5) {
        StringBuilder sb = new StringBuilder();
        if (i5 != 1) {
            if (i5 == 2) {
                sb.append("open ");
            }
        } else {
            sb.append("filled ");
        }
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        sb.append("unset");
                    } else {
                        sb.append("sesame");
                    }
                } else {
                    sb.append("dot");
                }
            } else {
                sb.append("circle");
            }
        } else {
            sb.append("none");
        }
        return sb.toString();
    }

    @Nullable
    public static String v(Object obj, float f4) {
        float size;
        if (obj instanceof StrikethroughSpan) {
            return "<span style='text-decoration:line-through;'>";
        }
        if (obj instanceof ForegroundColorSpan) {
            return j5.rz("<span style='color:%s;'>", mn.a.n3(((ForegroundColorSpan) obj).getForegroundColor()));
        }
        if (obj instanceof BackgroundColorSpan) {
            return j5.rz("<span class='bg_%s'>", Integer.valueOf(((BackgroundColorSpan) obj).getBackgroundColor()));
        }
        if (obj instanceof xp.y) {
            return "<span style='text-combine-upright:all;'>";
        }
        if (obj instanceof AbsoluteSizeSpan) {
            AbsoluteSizeSpan absoluteSizeSpan = (AbsoluteSizeSpan) obj;
            if (absoluteSizeSpan.getDip()) {
                size = absoluteSizeSpan.getSize();
            } else {
                size = absoluteSizeSpan.getSize() / f4;
            }
            return j5.rz("<span style='font-size:%.2fpx;'>", Float.valueOf(size));
        } else if (obj instanceof RelativeSizeSpan) {
            return j5.rz("<span style='font-size:%.2f%%;'>", Float.valueOf(((RelativeSizeSpan) obj).getSizeChange() * 100.0f));
        } else {
            if (obj instanceof TypefaceSpan) {
                String family = ((TypefaceSpan) obj).getFamily();
                if (family == null) {
                    return null;
                }
                return j5.rz("<span style='font-family:\"%s\";'>", family);
            } else if (obj instanceof StyleSpan) {
                int style = ((StyleSpan) obj).getStyle();
                if (style != 1) {
                    if (style != 2) {
                        if (style != 3) {
                            return null;
                        }
                        return "<b><i>";
                    }
                    return "<i>";
                }
                return "<b>";
            } else if (obj instanceof xp.zn) {
                int i = ((xp.zn) obj).f14956n3;
                if (i != -1) {
                    if (i != 1) {
                        if (i != 2) {
                            return null;
                        }
                        return "<ruby style='ruby-position:under;'>";
                    }
                    return "<ruby style='ruby-position:over;'>";
                }
                return "<ruby style='ruby-position:unset;'>";
            } else if (obj instanceof UnderlineSpan) {
                return "<u>";
            } else {
                if (!(obj instanceof xp.v)) {
                    return null;
                }
                xp.v vVar = (xp.v) obj;
                return j5.rz("<span style='-webkit-text-emphasis-style:%1$s;text-emphasis-style:%1$s;-webkit-text-emphasis-position:%2$s;text-emphasis-position:%2$s;display:inline-block;'>", s(vVar.y, vVar.f14954n3), fb(vVar.f14955zn));
            }
        }
    }

    public static n3 y(@Nullable CharSequence charSequence, float f4) {
        int i = 0;
        if (charSequence == null) {
            return new n3("", f3.x4());
        }
        if (!(charSequence instanceof Spanned)) {
            return new n3(n3(charSequence), f3.x4());
        }
        Spanned spanned = (Spanned) charSequence;
        HashSet<Integer> hashSet = new HashSet();
        for (BackgroundColorSpan backgroundColorSpan : (BackgroundColorSpan[]) spanned.getSpans(0, spanned.length(), BackgroundColorSpan.class)) {
            hashSet.add(Integer.valueOf(backgroundColorSpan.getBackgroundColor()));
        }
        HashMap hashMap = new HashMap();
        for (Integer num : hashSet) {
            int intValue = num.intValue();
            hashMap.put(mn.a.y("bg_" + intValue), j5.rz("background-color:%s;", mn.a.n3(intValue)));
        }
        SparseArray<C0054gv> zn2 = zn(spanned, f4);
        StringBuilder sb = new StringBuilder(spanned.length());
        int i5 = 0;
        while (i < zn2.size()) {
            int keyAt = zn2.keyAt(i);
            sb.append(n3(spanned.subSequence(i5, keyAt)));
            C0054gv c0054gv = zn2.get(keyAt);
            Collections.sort(c0054gv.f4833n3, zn.f4835a);
            for (zn znVar : c0054gv.f4833n3) {
                sb.append(znVar.f4837gv);
            }
            Collections.sort(c0054gv.y, zn.f4836v);
            for (zn znVar2 : c0054gv.y) {
                sb.append(znVar2.f4839zn);
            }
            i++;
            i5 = keyAt;
        }
        sb.append(n3(spanned.subSequence(i5, spanned.length())));
        return new n3(sb.toString(), hashMap);
    }

    public static SparseArray<C0054gv> zn(Spanned spanned, float f4) {
        Object[] spans;
        SparseArray<C0054gv> sparseArray = new SparseArray<>();
        for (Object obj : spanned.getSpans(0, spanned.length(), Object.class)) {
            String v2 = v(obj, f4);
            String gv2 = gv(obj);
            int spanStart = spanned.getSpanStart(obj);
            int spanEnd = spanned.getSpanEnd(obj);
            if (v2 != null) {
                v5.y.v(gv2);
                zn znVar = new zn(spanStart, spanEnd, v2, gv2);
                a(sparseArray, spanStart).y.add(znVar);
                a(sparseArray, spanEnd).f4833n3.add(znVar);
            }
        }
        return sparseArray;
    }
}
