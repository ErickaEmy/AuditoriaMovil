package okhttp3.internal.http;

import okhttp3.Interceptor;
/* compiled from: CallServerInterceptor.kt */
/* loaded from: classes2.dex */
public final class CallServerInterceptor implements Interceptor {
    private final boolean forWebSocket;

    private final boolean shouldIgnoreAndWaitForRealResponse(int i) {
        if (i == 100) {
            return true;
        }
        return 102 <= i && i < 200;
    }

    public CallServerInterceptor(boolean z) {
        this.forWebSocket = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x0156, code lost:
        if (r0 != false) goto L61;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e5 A[Catch: IOException -> 0x00b8, TryCatch #2 {IOException -> 0x00b8, blocks: (B:39:0x00aa, B:41:0x00b3, B:44:0x00bb, B:46:0x00e5, B:48:0x00ee, B:49:0x00f1, B:50:0x0115, B:54:0x0120, B:56:0x013f, B:58:0x014d, B:65:0x0163, B:67:0x0169, B:71:0x0176, B:73:0x0190, B:74:0x0198, B:75:0x01a2, B:60:0x0158, B:55:0x012f), top: B:87:0x00aa }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x014d A[Catch: IOException -> 0x00b8, TryCatch #2 {IOException -> 0x00b8, blocks: (B:39:0x00aa, B:41:0x00b3, B:44:0x00bb, B:46:0x00e5, B:48:0x00ee, B:49:0x00f1, B:50:0x0115, B:54:0x0120, B:56:0x013f, B:58:0x014d, B:65:0x0163, B:67:0x0169, B:71:0x0176, B:73:0x0190, B:74:0x0198, B:75:0x01a2, B:60:0x0158, B:55:0x012f), top: B:87:0x00aa }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0169 A[Catch: IOException -> 0x00b8, TryCatch #2 {IOException -> 0x00b8, blocks: (B:39:0x00aa, B:41:0x00b3, B:44:0x00bb, B:46:0x00e5, B:48:0x00ee, B:49:0x00f1, B:50:0x0115, B:54:0x0120, B:56:0x013f, B:58:0x014d, B:65:0x0163, B:67:0x0169, B:71:0x0176, B:73:0x0190, B:74:0x0198, B:75:0x01a2, B:60:0x0158, B:55:0x012f), top: B:87:0x00aa }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0176 A[Catch: IOException -> 0x00b8, TryCatch #2 {IOException -> 0x00b8, blocks: (B:39:0x00aa, B:41:0x00b3, B:44:0x00bb, B:46:0x00e5, B:48:0x00ee, B:49:0x00f1, B:50:0x0115, B:54:0x0120, B:56:0x013f, B:58:0x014d, B:65:0x0163, B:67:0x0169, B:71:0x0176, B:73:0x0190, B:74:0x0198, B:75:0x01a2, B:60:0x0158, B:55:0x012f), top: B:87:0x00aa }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r9v13, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v26 */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r14) {
        /*
            Method dump skipped, instructions count: 429
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.CallServerInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
