package androidx.compose.animation.core;
/* compiled from: SpringEstimation.kt */
/* loaded from: classes.dex */
public abstract class SpringEstimationKt {
    public static final long estimateAnimationDurationMillis(float f, float f2, float f3, float f4, float f5) {
        return estimateAnimationDurationMillis(f, f2, f3, f4, f5);
    }

    public static final long estimateAnimationDurationMillis(double d, double d2, double d3, double d4, double d5) {
        double d6;
        double d7;
        double d8;
        double d9;
        double d10;
        double d11;
        double d12;
        double d13;
        double sqrt = 2.0d * d2 * Math.sqrt(d);
        double d14 = (sqrt * sqrt) - (4.0d * d);
        double d15 = -sqrt;
        ComplexDouble complexSqrt = ComplexDoubleKt.complexSqrt(d14);
        d6 = complexSqrt._real;
        complexSqrt._real = d6 + d15;
        d7 = complexSqrt._real;
        complexSqrt._real = d7 * 0.5d;
        d8 = complexSqrt._imaginary;
        complexSqrt._imaginary = d8 * 0.5d;
        ComplexDouble complexSqrt2 = ComplexDoubleKt.complexSqrt(d14);
        d9 = complexSqrt2._real;
        double d16 = -1;
        complexSqrt2._real = d9 * d16;
        d10 = complexSqrt2._imaginary;
        complexSqrt2._imaginary = d10 * d16;
        d11 = complexSqrt2._real;
        complexSqrt2._real = d11 + d15;
        d12 = complexSqrt2._real;
        complexSqrt2._real = d12 * 0.5d;
        d13 = complexSqrt2._imaginary;
        complexSqrt2._imaginary = d13 * 0.5d;
        return estimateDurationInternal(complexSqrt, complexSqrt2, d2, d3, d4, d5);
    }

    private static final double estimateUnderDamped(ComplexDouble complexDouble, double d, double d2, double d3) {
        double real = complexDouble.getReal();
        double imaginary = (d2 - (real * d)) / complexDouble.getImaginary();
        return Math.log(d3 / Math.sqrt((d * d) + (imaginary * imaginary))) / real;
    }

    private static final double estimateCriticallyDamped(ComplexDouble complexDouble, double d, double d2, double d3) {
        double d4;
        int i;
        double d5 = d3;
        double real = complexDouble.getReal();
        double d6 = real * d;
        double d7 = d2 - d6;
        double log = Math.log(Math.abs(d5 / d)) / real;
        double log2 = Math.log(Math.abs(d5 / d7));
        double d8 = log2;
        for (int i2 = 0; i2 < 6; i2++) {
            d8 = log2 - Math.log(Math.abs(d8 / real));
        }
        double d9 = d8 / real;
        if (!((Double.isInfinite(log) || Double.isNaN(log)) ? false : true)) {
            log = d9;
        } else if (!(!((Double.isInfinite(d9) || Double.isNaN(d9)) ? false : true))) {
            log = Math.max(log, d9);
        }
        double d10 = (-(d6 + d7)) / (real * d7);
        double d11 = real * d10;
        double exp = (Math.exp(d11) * d) + (d7 * d10 * Math.exp(d11));
        if (!Double.isNaN(d10) && d10 > 0.0d) {
            if (d10 <= 0.0d || (-exp) >= d5) {
                log = (-(2.0d / real)) - (d / d7);
                d4 = Double.MAX_VALUE;
                i = 0;
                while (d4 > 0.001d && i < 100) {
                    i++;
                    double d12 = real * log;
                    double d13 = d5;
                    double exp2 = log - ((((d + (d7 * log)) * Math.exp(d12)) + d5) / ((((1 + d12) * d7) + d6) * Math.exp(d12)));
                    d4 = Math.abs(log - exp2);
                    log = exp2;
                    d5 = d13;
                }
                return log;
            } else if (d7 < 0.0d && d > 0.0d) {
                log = 0.0d;
            }
        }
        d5 = -d5;
        d4 = Double.MAX_VALUE;
        i = 0;
        while (d4 > 0.001d) {
            i++;
            double d122 = real * log;
            double d132 = d5;
            double exp22 = log - ((((d + (d7 * log)) * Math.exp(d122)) + d5) / ((((1 + d122) * d7) + d6) * Math.exp(d122)));
            d4 = Math.abs(log - exp22);
            log = exp22;
            d5 = d132;
        }
        return log;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00c9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final double estimateOverDamped(androidx.compose.animation.core.ComplexDouble r29, androidx.compose.animation.core.ComplexDouble r30, double r31, double r33, double r35) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SpringEstimationKt.estimateOverDamped(androidx.compose.animation.core.ComplexDouble, androidx.compose.animation.core.ComplexDouble, double, double, double):double");
    }

    private static final double estimateOverDamped$xInflection(double d, double d2, double d3, double d4, double d5) {
        return (d * Math.exp(d2 * d3)) + (d4 * Math.exp(d5 * d3));
    }

    private static final long estimateDurationInternal(ComplexDouble complexDouble, ComplexDouble complexDouble2, double d, double d2, double d3, double d4) {
        double estimateCriticallyDamped;
        double d5 = d2;
        int i = (d3 > 0.0d ? 1 : (d3 == 0.0d ? 0 : -1));
        if (i == 0 && d5 == 0.0d) {
            return 0L;
        }
        if (i < 0) {
            d5 = -d5;
        }
        double abs = Math.abs(d3);
        if (d > 1.0d) {
            estimateCriticallyDamped = estimateOverDamped(complexDouble, complexDouble2, abs, d5, d4);
        } else if (d < 1.0d) {
            estimateCriticallyDamped = estimateUnderDamped(complexDouble, abs, d5, d4);
        } else {
            estimateCriticallyDamped = estimateCriticallyDamped(complexDouble, abs, d5, d4);
        }
        return (long) (estimateCriticallyDamped * 1000.0d);
    }
}
