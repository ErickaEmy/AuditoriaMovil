package org.fdroid.fdroid;

import java.util.List;
/* loaded from: classes2.dex */
public interface IPreferencesIpfs {
    List<String> getIpfsGwDisabledDefaults();

    List<String> getIpfsGwUserList();

    boolean isIpfsEnabled();

    /* renamed from: setIpfsEnabled */
    void mo2547setIpfsEnabled(boolean z);

    /* renamed from: setIpfsGwDisabledDefaults */
    void mo2548setIpfsGwDisabledDefaults(List<String> list);

    /* renamed from: setIpfsGwUserList */
    void mo2549setIpfsGwUserList(List<String> list);
}
