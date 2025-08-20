package com.google.firebase.crashlytics.internal.report;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
/* loaded from: classes.dex */
public interface ReportUploader$Provider {
    ReportUploader createReportUploader(@NonNull AppSettingsData appSettingsData);
}
