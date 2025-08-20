package io.ktor.utils.io.jvm.javaio;
/* compiled from: Pollers.kt */
/* loaded from: classes.dex */
public abstract class PollersKt {
    private static final ThreadLocal parkingImplLocal = new ThreadLocal();

    public static final Parking getParkingImpl() {
        Parking parking = (Parking) parkingImplLocal.get();
        return parking == null ? DefaultParking.INSTANCE : parking;
    }

    public static final boolean isParkingAllowed() {
        return getParkingImpl() != ProhibitParking.INSTANCE;
    }
}
