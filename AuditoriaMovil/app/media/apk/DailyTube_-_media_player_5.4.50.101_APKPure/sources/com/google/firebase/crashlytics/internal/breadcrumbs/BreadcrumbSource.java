package com.google.firebase.crashlytics.internal.breadcrumbs;

import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public interface BreadcrumbSource {
    void registerBreadcrumbHandler(@Nullable BreadcrumbHandler breadcrumbHandler);
}
