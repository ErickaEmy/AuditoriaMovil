package com.facebook.ads.internal.exoplayer2.thirdparty.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import com.facebook.ads.redexgen.X.C0591Dp;
import com.facebook.ads.redexgen.X.C0592Dq;
import com.facebook.ads.redexgen.X.C0697Hz;
import com.facebook.ads.redexgen.X.IB;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: assets/audience_network.dex */
public final class SpliceInsertCommand extends SpliceCommand {
    public static String[] A0D = {"rwcuqOJ6EdQ67q2Mv0J2HHeiL", "WP4j4wUrwc9dHeO22M7i1JH5Vq97obJg", "mJZdPTUXLZu74", "VLU2rxkJGeQdQarAjhhUo7gMPCvQOQS9", "TorhhvAEpNk7fEbKtUMeNjy7yeYkErzW", "2cgHesvtXq3tKj0PCMbQTWS3l1m9KzOv", "jB5ZWs0uqsLPN", "ipEqGNR1nINtqeP5fHPEDulQW"};
    public static final Parcelable.Creator<SpliceInsertCommand> CREATOR = new C0591Dp();
    public final int A00;
    public final int A01;
    public final int A02;
    public final long A03;
    public final long A04;
    public final long A05;
    public final long A06;
    public final List<C0592Dq> A07;
    public final boolean A08;
    public final boolean A09;
    public final boolean A0A;
    public final boolean A0B;
    public final boolean A0C;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public SpliceInsertCommand(long j2, boolean z2, boolean z3, boolean z4, boolean z5, long j4, long j6, List<C0592Dq> list, boolean z7, long j7, int i, int i5, int i6) {
        this.A06 = j2;
        this.A0B = z2;
        this.A09 = z3;
        this.A0A = z4;
        this.A0C = z5;
        this.A05 = j4;
        this.A04 = j6;
        this.A07 = Collections.unmodifiableList(list);
        this.A08 = z7;
        this.A03 = j7;
        this.A02 = i;
        this.A00 = i5;
        this.A01 = i6;
    }

    public SpliceInsertCommand(Parcel parcel) {
        this.A06 = parcel.readLong();
        this.A0B = parcel.readByte() == 1;
        this.A09 = parcel.readByte() == 1;
        this.A0A = parcel.readByte() == 1;
        this.A0C = parcel.readByte() == 1;
        this.A05 = parcel.readLong();
        this.A04 = parcel.readLong();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add(C0592Dq.A00(parcel));
        }
        this.A07 = Collections.unmodifiableList(arrayList);
        int componentSpliceListSize = parcel.readByte();
        this.A08 = componentSpliceListSize == 1;
        this.A03 = parcel.readLong();
        int componentSpliceListSize2 = parcel.readInt();
        this.A02 = componentSpliceListSize2;
        int componentSpliceListSize3 = parcel.readInt();
        this.A00 = componentSpliceListSize3;
        int componentSpliceListSize4 = parcel.readInt();
        this.A01 = componentSpliceListSize4;
    }

    public /* synthetic */ SpliceInsertCommand(Parcel parcel, C0591Dp c0591Dp) {
        this(parcel);
    }

    public static SpliceInsertCommand A00(C0697Hz c0697Hz, long j2, IB ib) {
        long A0M = c0697Hz.A0M();
        boolean z2 = (c0697Hz.A0E() & NotificationCompat.FLAG_HIGH_PRIORITY) != 0;
        boolean z3 = false;
        boolean outOfNetworkIndicator = false;
        boolean z4 = false;
        long j4 = -9223372036854775807L;
        List emptyList = Collections.emptyList();
        int i = 0;
        int i5 = 0;
        int i6 = 0;
        boolean z5 = false;
        long j6 = -9223372036854775807L;
        if (!z2) {
            int A0E = c0697Hz.A0E();
            if (A0D[1].charAt(24) == '7') {
                throw new RuntimeException();
            }
            A0D[4] = "wCIdN9eSc7apWAr1IiSVHk4IDh7dTuFq";
            z3 = (A0E & NotificationCompat.FLAG_HIGH_PRIORITY) != 0;
            outOfNetworkIndicator = (A0E & 64) != 0;
            boolean autoReturn = (A0E & 32) != 0;
            z4 = (A0E & 16) != 0;
            if (outOfNetworkIndicator && !z4) {
                j4 = TimeSignalCommand.A00(c0697Hz, j2);
            }
            if (!outOfNetworkIndicator) {
                int componentCount = c0697Hz.A0E();
                emptyList = new ArrayList(componentCount);
                for (int i8 = 0; i8 < componentCount; i8++) {
                    int componentTag = c0697Hz.A0E();
                    long j7 = -9223372036854775807L;
                    if (!z4) {
                        j7 = TimeSignalCommand.A00(c0697Hz, j2);
                    }
                    emptyList.add(new C0592Dq(componentTag, j7, ib.A07(j7), null));
                }
            }
            if (autoReturn) {
                long A0E2 = c0697Hz.A0E();
                z5 = (A0E2 & 128) != 0;
                j6 = (1000 * (((A0E2 & 1) << 32) | c0697Hz.A0M())) / 90;
            }
            i = c0697Hz.A0I();
            i5 = c0697Hz.A0E();
            i6 = c0697Hz.A0E();
        }
        return new SpliceInsertCommand(A0M, z2, z3, outOfNetworkIndicator, z4, j4, ib.A07(j4), emptyList, z5, j6, i, i5, i6);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.A06);
        parcel.writeByte(this.A0B ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.A09 ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.A0A ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.A0C ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.A05);
        parcel.writeLong(this.A04);
        int size = this.A07.size();
        parcel.writeInt(size);
        for (int i5 = 0; i5 < size; i5++) {
            List<C0592Dq> list = this.A07;
            int i6 = A0D[3].length();
            if (i6 != 32) {
                throw new RuntimeException();
            }
            String[] strArr = A0D;
            strArr[6] = "cIZczz40pT0Gu";
            strArr[2] = "8BKfMUSS1QcQc";
            list.get(i5).A01(parcel);
        }
        parcel.writeByte(this.A08 ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.A03);
        int componentSpliceListSize = this.A02;
        parcel.writeInt(componentSpliceListSize);
        int componentSpliceListSize2 = this.A00;
        parcel.writeInt(componentSpliceListSize2);
        int componentSpliceListSize3 = this.A01;
        parcel.writeInt(componentSpliceListSize3);
    }
}
