package com.google.zxing.pdf417.detector;

import com.google.zxing.common.BitMatrix;
import java.util.List;
/* loaded from: classes.dex */
public final class PDF417DetectorResult {
    private final BitMatrix bits;
    private final List points;

    public BitMatrix getBits() {
        return this.bits;
    }

    public List getPoints() {
        return this.points;
    }

    public PDF417DetectorResult(BitMatrix bitMatrix, List list) {
        this.bits = bitMatrix;
        this.points = list;
    }
}
