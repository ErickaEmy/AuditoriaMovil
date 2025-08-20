package org.fdroid.fdroid.nearby;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import java.io.IOException;
/* loaded from: classes2.dex */
public class BluetoothClient {
    private static final String TAG = "BluetoothClient";
    private final BluetoothDevice device;

    public BluetoothClient(String str) {
        this.device = BluetoothAdapter.getDefaultAdapter().getRemoteDevice(str);
    }

    public BluetoothConnection openConnection() throws IOException {
        BluetoothConnection bluetoothConnection;
        Throwable th;
        try {
            bluetoothConnection = new BluetoothConnection(this.device.createInsecureRfcommSocketToServiceRecord(BluetoothConstants.fdroidUuid()));
            try {
                bluetoothConnection.open();
                bluetoothConnection.closeQuietly();
                return bluetoothConnection;
            } catch (Throwable th2) {
                th = th2;
                if (bluetoothConnection != null) {
                    bluetoothConnection.closeQuietly();
                }
                throw th;
            }
        } catch (Throwable th3) {
            bluetoothConnection = null;
            th = th3;
        }
    }
}
