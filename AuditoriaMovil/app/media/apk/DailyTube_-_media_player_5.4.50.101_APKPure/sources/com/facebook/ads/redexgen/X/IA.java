package com.facebook.ads.redexgen.X;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/* loaded from: assets/audience_network.dex */
public final class IA {
    public static String[] A07 = {"5DRquCQGg5fv0P6nja7IsOodPXBGhUeG", "CLJKgVN4XJask5diLy7MGSBxba0Pch5a", "wHftqcE0jDwIdOqBDBC3mNx0B5SBQznZ", "ol9v552kFRhJ1T6A32CtEuz", "A1CuUzQu9jwyUqSqJ17msfwDUTn6GREa", "TbNgrGyLzvQfDvkF0WCoqwQu2K", "lR0XC8VxWttqZJTwOmQs4gh4fjIE6f", "2mBuumTUpjmiSXNoBcdi8fBRoWPOanRf"};
    public static final Comparator<I9> A08 = new I7();
    public static final Comparator<I9> A09 = new I8();
    public int A01;
    public int A02;
    public int A03;
    public final int A04;
    public final I9[] A06 = new I9[5];
    public final ArrayList<I9> A05 = new ArrayList<>();
    public int A00 = -1;

    public IA(int i) {
        this.A04 = i;
    }

    private void A00() {
        if (this.A00 != 1) {
            Collections.sort(this.A05, A08);
            this.A00 = 1;
        }
    }

    private void A01() {
        if (this.A00 != 0) {
            Collections.sort(this.A05, A09);
            this.A00 = 0;
        }
    }

    public final float A02(float f4) {
        A01();
        float f6 = this.A03 * f4;
        int i = 0;
        for (int i5 = 0; i5 < this.A05.size(); i5++) {
            I9 i92 = this.A05.get(i5);
            i += i92.A02;
            float desiredWeight = i;
            if (desiredWeight >= f6) {
                float desiredWeight2 = i92.A00;
                return desiredWeight2;
            }
        }
        if (this.A05.isEmpty()) {
            return Float.NaN;
        }
        ArrayList<I9> arrayList = this.A05;
        int size = arrayList.size();
        int accumulatedWeight = A07[3].length();
        if (accumulatedWeight != 12) {
            A07[3] = "XkLaJBoD11zWycQ";
            float desiredWeight3 = arrayList.get(size - 1).A00;
            return desiredWeight3;
        }
        throw new RuntimeException();
    }

    public final void A03(int i, float f4) {
        I9 oldestSample;
        A00();
        int i5 = this.A02;
        if (i5 > 0) {
            I9[] i9Arr = this.A06;
            int i6 = i5 - 1;
            this.A02 = i6;
            oldestSample = i9Arr[i6];
        } else {
            oldestSample = new I9(null);
        }
        int i8 = this.A01;
        this.A01 = i8 + 1;
        oldestSample.A01 = i8;
        oldestSample.A02 = i;
        oldestSample.A00 = f4;
        this.A05.add(oldestSample);
        this.A03 += i;
        while (true) {
            int i10 = this.A03;
            int i11 = this.A04;
            if (i10 > i11) {
                int excessWeight = i10 - i11;
                I9 i92 = this.A05.get(0);
                if (i92.A02 <= excessWeight) {
                    int i12 = this.A03;
                    int i13 = i92.A02;
                    if (A07[5].length() != 26) {
                        throw new RuntimeException();
                    }
                    A07[6] = "uvvU8EqEwFGMOcNu2z1EziqDegtCkn";
                    this.A03 = i12 - i13;
                    this.A05.remove(0);
                    int excessWeight2 = this.A02;
                    if (excessWeight2 < 5) {
                        I9[] i9Arr2 = this.A06;
                        this.A02 = excessWeight2 + 1;
                        i9Arr2[excessWeight2] = i92;
                    }
                } else {
                    i92.A02 -= excessWeight;
                    this.A03 -= excessWeight;
                }
            } else {
                return;
            }
        }
    }
}
