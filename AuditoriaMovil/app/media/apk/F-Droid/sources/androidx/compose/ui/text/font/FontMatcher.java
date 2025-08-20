package androidx.compose.ui.text.font;

import androidx.compose.ui.text.font.FontWeight;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FontMatcher.kt */
/* loaded from: classes.dex */
public final class FontMatcher {
    /* renamed from: matchFont-RetOiIg  reason: not valid java name */
    public final List m1637matchFontRetOiIg(List fontList, FontWeight fontWeight, int i) {
        Intrinsics.checkNotNullParameter(fontList, "fontList");
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        ArrayList arrayList = new ArrayList(fontList.size());
        int size = fontList.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = fontList.get(i3);
            Font font = (Font) obj;
            if (Intrinsics.areEqual(font.getWeight(), fontWeight) && FontStyle.m1641equalsimpl0(font.mo1625getStyle_LCdwA(), i)) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(fontList.size());
        int size2 = fontList.size();
        for (int i4 = 0; i4 < size2; i4++) {
            Object obj2 = fontList.get(i4);
            if (FontStyle.m1641equalsimpl0(((Font) obj2).mo1625getStyle_LCdwA(), i)) {
                arrayList2.add(obj2);
            }
        }
        if (!arrayList2.isEmpty()) {
            fontList = arrayList2;
        }
        FontWeight.Companion companion = FontWeight.Companion;
        FontWeight fontWeight2 = null;
        if (fontWeight.compareTo(companion.getW400()) < 0) {
            int size3 = fontList.size();
            FontWeight fontWeight3 = null;
            int i5 = 0;
            while (true) {
                if (i5 >= size3) {
                    break;
                }
                FontWeight weight = ((Font) fontList.get(i5)).getWeight();
                if (weight.compareTo(fontWeight) >= 0) {
                    if (weight.compareTo(fontWeight) <= 0) {
                        fontWeight3 = weight;
                        fontWeight2 = fontWeight3;
                        break;
                    } else if (fontWeight3 == null || weight.compareTo(fontWeight3) < 0) {
                        fontWeight3 = weight;
                    }
                } else if (fontWeight2 == null || weight.compareTo(fontWeight2) > 0) {
                    fontWeight2 = weight;
                }
                i5++;
            }
            if (fontWeight2 != null) {
                fontWeight3 = fontWeight2;
            }
            ArrayList arrayList3 = new ArrayList(fontList.size());
            int size4 = fontList.size();
            while (i2 < size4) {
                Object obj3 = fontList.get(i2);
                if (Intrinsics.areEqual(((Font) obj3).getWeight(), fontWeight3)) {
                    arrayList3.add(obj3);
                }
                i2++;
            }
            return arrayList3;
        } else if (fontWeight.compareTo(companion.getW500()) > 0) {
            int size5 = fontList.size();
            FontWeight fontWeight4 = null;
            int i6 = 0;
            while (true) {
                if (i6 >= size5) {
                    break;
                }
                FontWeight weight2 = ((Font) fontList.get(i6)).getWeight();
                if (weight2.compareTo(fontWeight) >= 0) {
                    if (weight2.compareTo(fontWeight) <= 0) {
                        fontWeight4 = weight2;
                        fontWeight2 = fontWeight4;
                        break;
                    } else if (fontWeight4 == null || weight2.compareTo(fontWeight4) < 0) {
                        fontWeight4 = weight2;
                    }
                } else if (fontWeight2 == null || weight2.compareTo(fontWeight2) > 0) {
                    fontWeight2 = weight2;
                }
                i6++;
            }
            if (fontWeight4 == null) {
                fontWeight4 = fontWeight2;
            }
            ArrayList arrayList4 = new ArrayList(fontList.size());
            int size6 = fontList.size();
            while (i2 < size6) {
                Object obj4 = fontList.get(i2);
                if (Intrinsics.areEqual(((Font) obj4).getWeight(), fontWeight4)) {
                    arrayList4.add(obj4);
                }
                i2++;
            }
            return arrayList4;
        } else {
            FontWeight w500 = companion.getW500();
            int size7 = fontList.size();
            FontWeight fontWeight5 = null;
            FontWeight fontWeight6 = null;
            int i7 = 0;
            while (true) {
                if (i7 >= size7) {
                    break;
                }
                FontWeight weight3 = ((Font) fontList.get(i7)).getWeight();
                if (w500 == null || weight3.compareTo(w500) <= 0) {
                    if (weight3.compareTo(fontWeight) >= 0) {
                        if (weight3.compareTo(fontWeight) <= 0) {
                            fontWeight5 = weight3;
                            fontWeight6 = fontWeight5;
                            break;
                        } else if (fontWeight6 == null || weight3.compareTo(fontWeight6) < 0) {
                            fontWeight6 = weight3;
                        }
                    } else if (fontWeight5 == null || weight3.compareTo(fontWeight5) > 0) {
                        fontWeight5 = weight3;
                    }
                }
                i7++;
            }
            if (fontWeight6 != null) {
                fontWeight5 = fontWeight6;
            }
            ArrayList arrayList5 = new ArrayList(fontList.size());
            int size8 = fontList.size();
            for (int i8 = 0; i8 < size8; i8++) {
                Object obj5 = fontList.get(i8);
                if (Intrinsics.areEqual(((Font) obj5).getWeight(), fontWeight5)) {
                    arrayList5.add(obj5);
                }
            }
            if (arrayList5.isEmpty()) {
                FontWeight w5002 = FontWeight.Companion.getW500();
                int size9 = fontList.size();
                FontWeight fontWeight7 = null;
                int i9 = 0;
                while (true) {
                    if (i9 >= size9) {
                        break;
                    }
                    FontWeight weight4 = ((Font) fontList.get(i9)).getWeight();
                    if (w5002 == null || weight4.compareTo(w5002) >= 0) {
                        if (weight4.compareTo(fontWeight) >= 0) {
                            if (weight4.compareTo(fontWeight) <= 0) {
                                fontWeight2 = weight4;
                                fontWeight7 = fontWeight2;
                                break;
                            } else if (fontWeight7 == null || weight4.compareTo(fontWeight7) < 0) {
                                fontWeight7 = weight4;
                            }
                        } else if (fontWeight2 == null || weight4.compareTo(fontWeight2) > 0) {
                            fontWeight2 = weight4;
                        }
                    }
                    i9++;
                }
                if (fontWeight7 != null) {
                    fontWeight2 = fontWeight7;
                }
                ArrayList arrayList6 = new ArrayList(fontList.size());
                int size10 = fontList.size();
                while (i2 < size10) {
                    Object obj6 = fontList.get(i2);
                    if (Intrinsics.areEqual(((Font) obj6).getWeight(), fontWeight2)) {
                        arrayList6.add(obj6);
                    }
                    i2++;
                }
                return arrayList6;
            }
            return arrayList5;
        }
    }
}
