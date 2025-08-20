package com.facebook.ads.redexgen.X;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
/* renamed from: com.facebook.ads.redexgen.X.8H  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class C8H implements SensorEventListener {
    public C8H() {
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        C8J.A0D(sensorEvent.values);
        C8J.A04();
    }
}
