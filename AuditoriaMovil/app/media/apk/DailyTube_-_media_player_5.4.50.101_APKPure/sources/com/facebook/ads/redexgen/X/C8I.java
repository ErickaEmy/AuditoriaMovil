package com.facebook.ads.redexgen.X;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
/* renamed from: com.facebook.ads.redexgen.X.8I  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class C8I implements SensorEventListener {
    public C8I() {
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        float[] unused = C8J.A0B = sensorEvent.values;
        C8J.A07();
    }
}
