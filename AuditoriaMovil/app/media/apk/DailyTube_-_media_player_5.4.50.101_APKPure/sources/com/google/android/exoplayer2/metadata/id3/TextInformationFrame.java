package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import m1.qk;
import v5.j5;
import z0.x4;
/* loaded from: classes.dex */
public final class TextInformationFrame extends Id3Frame {
    public static final Parcelable.Creator<TextInformationFrame> CREATOR = new y();
    @Deprecated

    /* renamed from: fb  reason: collision with root package name */
    public final String f4275fb;

    /* renamed from: s  reason: collision with root package name */
    public final x4<String> f4276s;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public final String f4277v;

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<TextInformationFrame> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public TextInformationFrame[] newArray(int i) {
            return new TextInformationFrame[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public TextInformationFrame createFromParcel(Parcel parcel) {
            return new TextInformationFrame(parcel, null);
        }
    }

    public /* synthetic */ TextInformationFrame(Parcel parcel, y yVar) {
        this(parcel);
    }

    public static List<Integer> y(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (str.length() >= 10) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(8, 10))));
            } else if (str.length() >= 7) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
            } else if (str.length() >= 4) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
            }
            return arrayList;
        } catch (NumberFormatException unused) {
            return new ArrayList();
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TextInformationFrame.class != obj.getClass()) {
            return false;
        }
        TextInformationFrame textInformationFrame = (TextInformationFrame) obj;
        if (j5.zn(this.y, textInformationFrame.y) && j5.zn(this.f4277v, textInformationFrame.f4277v) && this.f4276s.equals(textInformationFrame.f4276s)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        int hashCode = (527 + this.y.hashCode()) * 31;
        String str = this.f4277v;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        return ((hashCode + i) * 31) + this.f4276s.hashCode();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame, com.google.android.exoplayer2.metadata.Metadata.Entry
    public void m(qk.n3 n3Var) {
        Integer num;
        String str = this.y;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 82815:
                if (str.equals("TAL")) {
                    c2 = 0;
                    break;
                }
                break;
            case 82878:
                if (str.equals("TCM")) {
                    c2 = 1;
                    break;
                }
                break;
            case 82897:
                if (str.equals("TDA")) {
                    c2 = 2;
                    break;
                }
                break;
            case 83253:
                if (str.equals("TP1")) {
                    c2 = 3;
                    break;
                }
                break;
            case 83254:
                if (str.equals("TP2")) {
                    c2 = 4;
                    break;
                }
                break;
            case 83255:
                if (str.equals("TP3")) {
                    c2 = 5;
                    break;
                }
                break;
            case 83341:
                if (str.equals("TRK")) {
                    c2 = 6;
                    break;
                }
                break;
            case 83378:
                if (str.equals("TT2")) {
                    c2 = 7;
                    break;
                }
                break;
            case 83536:
                if (str.equals("TXT")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 83552:
                if (str.equals("TYE")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 2567331:
                if (str.equals("TALB")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 2569357:
                if (str.equals("TCOM")) {
                    c2 = 11;
                    break;
                }
                break;
            case 2569891:
                if (str.equals("TDAT")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 2570401:
                if (str.equals("TDRC")) {
                    c2 = '\r';
                    break;
                }
                break;
            case 2570410:
                if (str.equals("TDRL")) {
                    c2 = 14;
                    break;
                }
                break;
            case 2571565:
                if (str.equals("TEXT")) {
                    c2 = 15;
                    break;
                }
                break;
            case 2575251:
                if (str.equals("TIT2")) {
                    c2 = 16;
                    break;
                }
                break;
            case 2581512:
                if (str.equals("TPE1")) {
                    c2 = 17;
                    break;
                }
                break;
            case 2581513:
                if (str.equals("TPE2")) {
                    c2 = 18;
                    break;
                }
                break;
            case 2581514:
                if (str.equals("TPE3")) {
                    c2 = 19;
                    break;
                }
                break;
            case 2583398:
                if (str.equals("TRCK")) {
                    c2 = 20;
                    break;
                }
                break;
            case 2590194:
                if (str.equals("TYER")) {
                    c2 = 21;
                    break;
                }
                break;
        }
        try {
            switch (c2) {
                case 0:
                case '\n':
                    n3Var.yt(this.f4276s.get(0));
                    return;
                case 1:
                case 11:
                    n3Var.o(this.f4276s.get(0));
                    return;
                case 2:
                case '\f':
                    String str2 = this.f4276s.get(0);
                    n3Var.ct(Integer.valueOf(Integer.parseInt(str2.substring(2, 4)))).dm(Integer.valueOf(Integer.parseInt(str2.substring(0, 2))));
                    return;
                case 3:
                case 17:
                    n3Var.vl(this.f4276s.get(0));
                    return;
                case 4:
                case 18:
                    n3Var.k5(this.f4276s.get(0));
                    return;
                case 5:
                case 19:
                    n3Var.j(this.f4276s.get(0));
                    return;
                case 6:
                case 20:
                    String[] ro2 = j5.ro(this.f4276s.get(0), "/");
                    int parseInt = Integer.parseInt(ro2[0]);
                    if (ro2.length > 1) {
                        num = Integer.valueOf(Integer.parseInt(ro2[1]));
                    } else {
                        num = null;
                    }
                    n3Var.yg(Integer.valueOf(parseInt)).ap(num);
                    return;
                case 7:
                case 16:
                    n3Var.e(this.f4276s.get(0));
                    return;
                case '\b':
                case 15:
                    n3Var.kp(this.f4276s.get(0));
                    return;
                case '\t':
                case 21:
                    n3Var.o4(Integer.valueOf(Integer.parseInt(this.f4276s.get(0))));
                    return;
                case '\r':
                    List<Integer> y2 = y(this.f4276s.get(0));
                    int size = y2.size();
                    if (size != 1) {
                        if (size != 2) {
                            if (size == 3) {
                                n3Var.dm(y2.get(2));
                            } else {
                                return;
                            }
                        }
                        n3Var.ct(y2.get(1));
                    }
                    n3Var.o4(y2.get(0));
                    return;
                case 14:
                    List<Integer> y7 = y(this.f4276s.get(0));
                    int size2 = y7.size();
                    if (size2 != 1) {
                        if (size2 != 2) {
                            if (size2 == 3) {
                                n3Var.rs(y7.get(2));
                            } else {
                                return;
                            }
                        }
                        n3Var.eb(y7.get(1));
                    }
                    n3Var.lc(y7.get(0));
                    return;
                default:
                    return;
            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException unused) {
        }
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        return this.y + ": description=" + this.f4277v + ": values=" + this.f4276s;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.y);
        parcel.writeString(this.f4277v);
        parcel.writeStringArray((String[]) this.f4276s.toArray(new String[0]));
    }

    public TextInformationFrame(String str, @Nullable String str2, List<String> list) {
        super(str);
        v5.y.y(!list.isEmpty());
        this.f4277v = str2;
        x4<String> d2 = x4.d(list);
        this.f4276s = d2;
        this.f4275fb = d2.get(0);
    }

    public TextInformationFrame(Parcel parcel) {
        this((String) v5.y.v(parcel.readString()), parcel.readString(), x4.ud((String[]) v5.y.v(parcel.createStringArray())));
    }
}
