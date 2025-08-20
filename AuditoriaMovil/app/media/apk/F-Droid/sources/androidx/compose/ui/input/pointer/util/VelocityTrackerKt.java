package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.HistoricalChange;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: VelocityTracker.kt */
/* loaded from: classes.dex */
public abstract class VelocityTrackerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void set(DataPointAtTime[] dataPointAtTimeArr, int i, long j, float f) {
        DataPointAtTime dataPointAtTime = dataPointAtTimeArr[i];
        if (dataPointAtTime == null) {
            dataPointAtTimeArr[i] = new DataPointAtTime(j, f);
            return;
        }
        dataPointAtTime.setTime(j);
        dataPointAtTime.setDataPoint(f);
    }

    public static final void addPointerInputChange(VelocityTracker velocityTracker, PointerInputChange event) {
        Intrinsics.checkNotNullParameter(velocityTracker, "<this>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (PointerEventKt.changedToDownIgnoreConsumed(event)) {
            velocityTracker.m1232setCurrentPointerPositionAccumulatork4lQ0M$ui_release(event.m1196getPositionF1C5BW0());
            velocityTracker.resetTracking();
        }
        long m1197getPreviousPositionF1C5BW0 = event.m1197getPreviousPositionF1C5BW0();
        List historical = event.getHistorical();
        int size = historical.size();
        int i = 0;
        while (i < size) {
            HistoricalChange historicalChange = (HistoricalChange) historical.get(i);
            long m713minusMKHz9U = Offset.m713minusMKHz9U(historicalChange.m1162getPositionF1C5BW0(), m1197getPreviousPositionF1C5BW0);
            long m1162getPositionF1C5BW0 = historicalChange.m1162getPositionF1C5BW0();
            velocityTracker.m1232setCurrentPointerPositionAccumulatork4lQ0M$ui_release(Offset.m714plusMKHz9U(velocityTracker.m1231getCurrentPointerPositionAccumulatorF1C5BW0$ui_release(), m713minusMKHz9U));
            velocityTracker.m1229addPositionUv8p0NA(historicalChange.getUptimeMillis(), velocityTracker.m1231getCurrentPointerPositionAccumulatorF1C5BW0$ui_release());
            i++;
            m1197getPreviousPositionF1C5BW0 = m1162getPositionF1C5BW0;
        }
        velocityTracker.m1232setCurrentPointerPositionAccumulatork4lQ0M$ui_release(Offset.m714plusMKHz9U(velocityTracker.m1231getCurrentPointerPositionAccumulatorF1C5BW0$ui_release(), Offset.m713minusMKHz9U(event.m1196getPositionF1C5BW0(), m1197getPreviousPositionF1C5BW0)));
        velocityTracker.m1229addPositionUv8p0NA(event.getUptimeMillis(), velocityTracker.m1231getCurrentPointerPositionAccumulatorF1C5BW0$ui_release());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculateImpulseVelocity(float[] fArr, float[] fArr2, int i, boolean z) {
        float f;
        float f2;
        float f3 = 0.0f;
        if (i < 2) {
            return 0.0f;
        }
        if (i == 2) {
            float f4 = fArr2[0];
            float f5 = fArr2[1];
            if (f4 == f5) {
                return 0.0f;
            }
            if (z) {
                f2 = fArr[0];
            } else {
                f2 = fArr[0] - fArr[1];
            }
            return f2 / (f4 - f5);
        }
        int i2 = i - 1;
        for (int i3 = i2; i3 > 0; i3--) {
            int i4 = i3 - 1;
            if (fArr2[i3] != fArr2[i4]) {
                float signum = Math.signum(f3) * ((float) Math.sqrt(2 * Math.abs(f3)));
                if (z) {
                    f = -fArr[i4];
                } else {
                    f = fArr[i3] - fArr[i4];
                }
                float f6 = f / (fArr2[i3] - fArr2[i4]);
                f3 += (f6 - signum) * Math.abs(f6);
                if (i3 == i2) {
                    f3 *= 0.5f;
                }
            }
        }
        return Math.signum(f3) * ((float) Math.sqrt(2 * Math.abs(f3)));
    }

    private static final float dot(float[] fArr, float[] fArr2) {
        int length = fArr.length;
        float f = 0.0f;
        for (int i = 0; i < length; i++) {
            f += fArr[i] * fArr2[i];
        }
        return f;
    }

    public static final float[] polyFitLeastSquares(float[] x, float[] y, int i, int i2, float[] coefficients) {
        int i3 = i2;
        Intrinsics.checkNotNullParameter(x, "x");
        Intrinsics.checkNotNullParameter(y, "y");
        Intrinsics.checkNotNullParameter(coefficients, "coefficients");
        if (i3 >= 1) {
            if (i == 0) {
                throw new IllegalArgumentException("At least one point must be provided");
            }
            if (i3 >= i) {
                i3 = i - 1;
            }
            int i4 = i3 + 1;
            float[][] fArr = new float[i4];
            for (int i5 = 0; i5 < i4; i5++) {
                fArr[i5] = new float[i];
            }
            for (int i6 = 0; i6 < i; i6++) {
                fArr[0][i6] = 1.0f;
                for (int i7 = 1; i7 < i4; i7++) {
                    fArr[i7][i6] = fArr[i7 - 1][i6] * x[i6];
                }
            }
            float[][] fArr2 = new float[i4];
            for (int i8 = 0; i8 < i4; i8++) {
                fArr2[i8] = new float[i];
            }
            float[][] fArr3 = new float[i4];
            for (int i9 = 0; i9 < i4; i9++) {
                fArr3[i9] = new float[i4];
            }
            int i10 = 0;
            while (i10 < i4) {
                float[] fArr4 = fArr2[i10];
                float[] fArr5 = fArr[i10];
                for (int i11 = 0; i11 < i; i11++) {
                    fArr4[i11] = fArr5[i11];
                }
                for (int i12 = 0; i12 < i10; i12++) {
                    float[] fArr6 = fArr2[i12];
                    float dot = dot(fArr4, fArr6);
                    for (int i13 = 0; i13 < i; i13++) {
                        fArr4[i13] = fArr4[i13] - (fArr6[i13] * dot);
                    }
                }
                float sqrt = (float) Math.sqrt(dot(fArr4, fArr4));
                if (sqrt < 1.0E-6f) {
                    throw new IllegalArgumentException("Vectors are linearly dependent or zero so no solution. TODO(shepshapard), actually determine what this means");
                }
                float f = 1.0f / sqrt;
                for (int i14 = 0; i14 < i; i14++) {
                    fArr4[i14] = fArr4[i14] * f;
                }
                float[] fArr7 = fArr3[i10];
                int i15 = 0;
                while (i15 < i4) {
                    fArr7[i15] = i15 < i10 ? 0.0f : dot(fArr4, fArr[i15]);
                    i15++;
                }
                i10++;
            }
            for (int i16 = i3; -1 < i16; i16--) {
                coefficients[i16] = dot(fArr2[i16], y);
                int i17 = i16 + 1;
                if (i17 <= i3) {
                    int i18 = i3;
                    while (true) {
                        coefficients[i16] = coefficients[i16] - (fArr3[i16][i18] * coefficients[i18]);
                        if (i18 != i17) {
                            i18--;
                        }
                    }
                }
                coefficients[i16] = coefficients[i16] / fArr3[i16][i16];
            }
            return coefficients;
        }
        throw new IllegalArgumentException("The degree must be at positive integer");
    }
}
