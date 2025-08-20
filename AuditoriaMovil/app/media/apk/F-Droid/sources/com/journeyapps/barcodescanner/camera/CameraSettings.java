package com.journeyapps.barcodescanner.camera;
/* loaded from: classes.dex */
public class CameraSettings {
    private int requestedCameraId = -1;
    private boolean scanInverted = false;
    private boolean barcodeSceneModeEnabled = false;
    private boolean meteringEnabled = false;
    private boolean autoFocusEnabled = true;
    private boolean continuousFocusEnabled = false;
    private boolean exposureEnabled = false;
    private boolean autoTorchEnabled = false;
    private FocusMode focusMode = FocusMode.AUTO;

    /* loaded from: classes.dex */
    public enum FocusMode {
        AUTO,
        CONTINUOUS,
        INFINITY,
        MACRO
    }

    public FocusMode getFocusMode() {
        return this.focusMode;
    }

    public int getRequestedCameraId() {
        return this.requestedCameraId;
    }

    public boolean isAutoFocusEnabled() {
        return this.autoFocusEnabled;
    }

    public boolean isAutoTorchEnabled() {
        return this.autoTorchEnabled;
    }

    public boolean isBarcodeSceneModeEnabled() {
        return this.barcodeSceneModeEnabled;
    }

    public boolean isExposureEnabled() {
        return this.exposureEnabled;
    }

    public boolean isMeteringEnabled() {
        return this.meteringEnabled;
    }

    public boolean isScanInverted() {
        return this.scanInverted;
    }

    public void setRequestedCameraId(int i) {
        this.requestedCameraId = i;
    }
}
