package com.google.firebase.heartbeatinfo;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes.dex */
class HeartBeatInfoStorage {
    private static HeartBeatInfoStorage instance;
    private final SharedPreferences sharedPreferences;

    private HeartBeatInfoStorage(Context context) {
        this.sharedPreferences = context.getSharedPreferences("FirebaseAppHeartBeat", 0);
    }

    public static synchronized HeartBeatInfoStorage getInstance(Context context) {
        HeartBeatInfoStorage heartBeatInfoStorage;
        synchronized (HeartBeatInfoStorage.class) {
            try {
                if (instance == null) {
                    instance = new HeartBeatInfoStorage(context);
                }
                heartBeatInfoStorage = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return heartBeatInfoStorage;
    }

    public synchronized boolean shouldSendGlobalHeartBeat(long j2) {
        return shouldSendSdkHeartBeat("fire-global", j2);
    }

    public synchronized boolean shouldSendSdkHeartBeat(String str, long j2) {
        if (this.sharedPreferences.contains(str)) {
            if (j2 - this.sharedPreferences.getLong(str, -1L) >= 86400000) {
                this.sharedPreferences.edit().putLong(str, j2).apply();
                return true;
            }
            return false;
        }
        this.sharedPreferences.edit().putLong(str, j2).apply();
        return true;
    }

    public HeartBeatInfoStorage(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }
}
