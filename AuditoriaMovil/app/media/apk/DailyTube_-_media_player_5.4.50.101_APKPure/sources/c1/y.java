package c1;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
/* loaded from: classes.dex */
public final class y {
    public static final BigInteger y = new BigInteger("16a09e667f3bcc908b2fb1366ea957d3e3adec17512775099da2f590b0667322a", 16);

    /* renamed from: n3  reason: collision with root package name */
    public static final double f3975n3 = Math.log(10.0d);

    /* renamed from: zn  reason: collision with root package name */
    public static final double f3976zn = Math.log(2.0d);

    public static BigInteger y(BigInteger bigInteger, BigInteger bigInteger2, RoundingMode roundingMode) {
        return new BigDecimal(bigInteger).divide(new BigDecimal(bigInteger2), 0, roundingMode).toBigIntegerExact();
    }
}
