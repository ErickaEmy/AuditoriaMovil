package org.acra.file;

import android.content.Context;
import java.io.File;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ReportLocator.kt */
/* loaded from: classes2.dex */
public final class ReportLocator {
    public static final Companion Companion = new Companion(null);
    private final Context context;

    /* compiled from: ReportLocator.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ReportLocator(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final File getUnapprovedFolder() {
        File dir = this.context.getDir("ACRA-unapproved", 0);
        Intrinsics.checkNotNullExpressionValue(dir, "getDir(...)");
        return dir;
    }

    public final File[] getUnapprovedReports() {
        File[] listFiles = getUnapprovedFolder().listFiles();
        return listFiles == null ? new File[0] : listFiles;
    }

    public final File getApprovedFolder() {
        File dir = this.context.getDir("ACRA-approved", 0);
        Intrinsics.checkNotNullExpressionValue(dir, "getDir(...)");
        return dir;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000b, code lost:
        r0 = kotlin.collections.ArraysKt___ArraysKt.sortedWith(r0, new org.acra.file.ReportLocator$special$$inlined$sortedBy$1());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.io.File[] getApprovedReports() {
        /*
            r3 = this;
            java.io.File r0 = r3.getApprovedFolder()
            java.io.File[] r0 = r0.listFiles()
            r1 = 0
            if (r0 == 0) goto L20
            org.acra.file.ReportLocator$special$$inlined$sortedBy$1 r2 = new org.acra.file.ReportLocator$special$$inlined$sortedBy$1
            r2.<init>()
            java.util.List r0 = kotlin.collections.ArraysKt.sortedWith(r0, r2)
            if (r0 == 0) goto L20
            java.io.File[] r2 = new java.io.File[r1]
            java.lang.Object[] r0 = r0.toArray(r2)
            java.io.File[] r0 = (java.io.File[]) r0
            if (r0 != 0) goto L22
        L20:
            java.io.File[] r0 = new java.io.File[r1]
        L22:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.acra.file.ReportLocator.getApprovedReports():java.io.File[]");
    }
}
