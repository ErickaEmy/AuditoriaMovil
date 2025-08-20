package com.facebook.ads.redexgen.X;

import android.os.Parcel;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: assets/audience_network.dex */
public final class Du {
    public static String[] A0B = {"WSNeg6N0n7AIShfXSzX5HQmTc8kFkZEc", "6rZRvoV62oNyzf", "F27AMpNiqyccCa5EB6sKY7eKfEMSqhrd", "FVKbL9f5FAHwz7hiZMN0u1v1YdCbdeYK", "vVfLkZocD1NxPHhP9fXAXrt0GsgaX4xN", "cFmUa63iy9OAJJOa0jT7jB1cdvdJ4hQa", "2QFrNOOxadMtahUuhILPt16xKsmCtJsL", "J"};
    public final int A00;
    public final int A01;
    public final int A02;
    public final long A03;
    public final long A04;
    public final long A05;
    public final List<C0595Dt> A06;
    public final boolean A07;
    public final boolean A08;
    public final boolean A09;
    public final boolean A0A;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static Du A02(C0697Hz c0697Hz) {
        long A0M = c0697Hz.A0M();
        boolean z2 = (c0697Hz.A0E() & NotificationCompat.FLAG_HIGH_PRIORITY) != 0;
        boolean z3 = false;
        boolean z4 = false;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i5 = 0;
        int i6 = 0;
        boolean z5 = false;
        long j2 = -9223372036854775807L;
        if (!z2) {
            int A0E = c0697Hz.A0E();
            z3 = (A0E & NotificationCompat.FLAG_HIGH_PRIORITY) != 0;
            z4 = (A0E & 64) != 0;
            if (A0B[7].length() != 1) {
                throw new RuntimeException();
            }
            A0B[1] = "02B3CRg7kTq01s";
            boolean z7 = (A0E & 32) != 0;
            r14 = z4 ? c0697Hz.A0M() : -9223372036854775807L;
            if (!z4) {
                int A0E2 = c0697Hz.A0E();
                arrayList = new ArrayList(A0E2);
                for (int i8 = 0; i8 < A0E2; i8++) {
                    arrayList.add(new C0595Dt(c0697Hz.A0E(), c0697Hz.A0M(), null));
                }
                String[] strArr = A0B;
                if (strArr[0].charAt(5) == strArr[5].charAt(5)) {
                    A0B[1] = "Wfp3iGqyia9VmI";
                }
            }
            if (z7) {
                long A0E3 = c0697Hz.A0E();
                z5 = (128 & A0E3) != 0;
                j2 = (1000 * (((1 & A0E3) << 32) | c0697Hz.A0M())) / 90;
            }
            i = c0697Hz.A0I();
            i5 = c0697Hz.A0E();
            i6 = c0697Hz.A0E();
        }
        return new Du(A0M, z2, z3, z4, arrayList, r14, z5, j2, i, i5, i6);
    }

    public Du(long j2, boolean z2, boolean z3, boolean z4, List<C0595Dt> list, long j4, boolean z5, long j6, int i, int i5, int i6) {
        this.A04 = j2;
        this.A0A = z2;
        this.A08 = z3;
        this.A09 = z4;
        this.A06 = Collections.unmodifiableList(list);
        this.A05 = j4;
        this.A07 = z5;
        this.A03 = j6;
        this.A02 = i;
        this.A00 = i5;
        this.A01 = i6;
    }

    public Du(Parcel parcel) {
        C0595Dt A00;
        this.A04 = parcel.readLong();
        this.A0A = parcel.readByte() == 1;
        this.A08 = parcel.readByte() == 1;
        this.A09 = parcel.readByte() == 1;
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            A00 = C0595Dt.A00(parcel);
            arrayList.add(A00);
        }
        this.A06 = Collections.unmodifiableList(arrayList);
        this.A05 = parcel.readLong();
        int componentSpliceListLength = parcel.readByte();
        this.A07 = componentSpliceListLength == 1;
        this.A03 = parcel.readLong();
        int componentSpliceListLength2 = parcel.readInt();
        this.A02 = componentSpliceListLength2;
        int componentSpliceListLength3 = parcel.readInt();
        this.A00 = componentSpliceListLength3;
        int componentSpliceListLength4 = parcel.readInt();
        this.A01 = componentSpliceListLength4;
    }

    public static Du A00(Parcel parcel) {
        return new Du(parcel);
    }

    public static /* synthetic */ Du A01(Parcel parcel) {
        return A00(parcel);
    }

    public static /* synthetic */ Du A03(C0697Hz c0697Hz) {
        return A02(c0697Hz);
    }

    public void A04(Parcel parcel) {
        parcel.writeLong(this.A04);
        parcel.writeByte(this.A0A ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.A08 ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.A09 ? (byte) 1 : (byte) 0);
        int size = this.A06.size();
        parcel.writeInt(size);
        for (int i = 0; i < size; i++) {
            this.A06.get(i).A02(parcel);
        }
        parcel.writeLong(this.A05);
        byte b2 = this.A07 ? (byte) 1 : (byte) 0;
        if (A0B[1].length() != 14) {
            throw new RuntimeException();
        }
        A0B[1] = "FoD8YYsiaA11j5";
        parcel.writeByte(b2);
        parcel.writeLong(this.A03);
        int componentSpliceListSize = this.A02;
        parcel.writeInt(componentSpliceListSize);
        int componentSpliceListSize2 = this.A00;
        parcel.writeInt(componentSpliceListSize2);
        int componentSpliceListSize3 = this.A01;
        parcel.writeInt(componentSpliceListSize3);
    }

    public static /* synthetic */ void A05(Du du, Parcel parcel) {
        du.A04(parcel);
    }
}
