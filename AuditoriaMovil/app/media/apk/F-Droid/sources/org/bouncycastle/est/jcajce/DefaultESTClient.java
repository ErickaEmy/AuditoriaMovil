package org.bouncycastle.est.jcajce;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.Charset;
import org.bouncycastle.est.ESTClient;
import org.bouncycastle.est.ESTClientSourceProvider;
import org.bouncycastle.est.ESTException;
import org.bouncycastle.est.ESTRequest;
import org.bouncycastle.est.ESTRequestBuilder;
import org.bouncycastle.est.ESTResponse;
/* loaded from: classes2.dex */
class DefaultESTClient implements ESTClient {
    private final ESTClientSourceProvider sslSocketProvider;
    private static final Charset utf8 = Charset.forName("UTF-8");
    private static byte[] CRLF = {13, 10};

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class PrintingOutputStream extends OutputStream {
        private final OutputStream tgt;

        public PrintingOutputStream(OutputStream outputStream) {
            this.tgt = outputStream;
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            System.out.print(String.valueOf((char) i));
            this.tgt.write(i);
        }
    }

    public DefaultESTClient(ESTClientSourceProvider eSTClientSourceProvider) {
        this.sslSocketProvider = eSTClientSourceProvider;
    }

    private static void writeLine(OutputStream outputStream, String str) throws IOException {
        outputStream.write(str.getBytes());
        outputStream.write(CRLF);
    }

    @Override // org.bouncycastle.est.ESTClient
    public ESTResponse doRequest(ESTRequest eSTRequest) throws IOException {
        ESTResponse performRequest;
        int i = 15;
        while (true) {
            performRequest = performRequest(eSTRequest);
            ESTRequest redirectURL = redirectURL(performRequest);
            if (redirectURL == null || i - 1 <= 0) {
                break;
            }
            eSTRequest = redirectURL;
        }
        if (i != 0) {
            return performRequest;
        }
        throw new ESTException("Too many redirects..");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006a A[Catch: all -> 0x0028, TryCatch #0 {all -> 0x0028, blocks: (B:3:0x0003, B:5:0x001f, B:8:0x002b, B:10:0x0039, B:13:0x0042, B:15:0x0050, B:17:0x006a, B:19:0x0075, B:21:0x008b, B:22:0x0090, B:25:0x009e, B:26:0x00b8, B:28:0x00c1, B:29:0x00f1, B:31:0x00f7, B:32:0x0104, B:34:0x0107, B:35:0x0129, B:37:0x013d, B:42:0x014d, B:27:0x00bc, B:14:0x0047), top: B:47:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008b A[Catch: all -> 0x0028, TryCatch #0 {all -> 0x0028, blocks: (B:3:0x0003, B:5:0x001f, B:8:0x002b, B:10:0x0039, B:13:0x0042, B:15:0x0050, B:17:0x006a, B:19:0x0075, B:21:0x008b, B:22:0x0090, B:25:0x009e, B:26:0x00b8, B:28:0x00c1, B:29:0x00f1, B:31:0x00f7, B:32:0x0104, B:34:0x0107, B:35:0x0129, B:37:0x013d, B:42:0x014d, B:27:0x00bc, B:14:0x0047), top: B:47:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009e A[Catch: all -> 0x0028, TRY_ENTER, TryCatch #0 {all -> 0x0028, blocks: (B:3:0x0003, B:5:0x001f, B:8:0x002b, B:10:0x0039, B:13:0x0042, B:15:0x0050, B:17:0x006a, B:19:0x0075, B:21:0x008b, B:22:0x0090, B:25:0x009e, B:26:0x00b8, B:28:0x00c1, B:29:0x00f1, B:31:0x00f7, B:32:0x0104, B:34:0x0107, B:35:0x0129, B:37:0x013d, B:42:0x014d, B:27:0x00bc, B:14:0x0047), top: B:47:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00bc A[Catch: all -> 0x0028, TryCatch #0 {all -> 0x0028, blocks: (B:3:0x0003, B:5:0x001f, B:8:0x002b, B:10:0x0039, B:13:0x0042, B:15:0x0050, B:17:0x006a, B:19:0x0075, B:21:0x008b, B:22:0x0090, B:25:0x009e, B:26:0x00b8, B:28:0x00c1, B:29:0x00f1, B:31:0x00f7, B:32:0x0104, B:34:0x0107, B:35:0x0129, B:37:0x013d, B:42:0x014d, B:27:0x00bc, B:14:0x0047), top: B:47:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f7 A[Catch: all -> 0x0028, TryCatch #0 {all -> 0x0028, blocks: (B:3:0x0003, B:5:0x001f, B:8:0x002b, B:10:0x0039, B:13:0x0042, B:15:0x0050, B:17:0x006a, B:19:0x0075, B:21:0x008b, B:22:0x0090, B:25:0x009e, B:26:0x00b8, B:28:0x00c1, B:29:0x00f1, B:31:0x00f7, B:32:0x0104, B:34:0x0107, B:35:0x0129, B:37:0x013d, B:42:0x014d, B:27:0x00bc, B:14:0x0047), top: B:47:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x013d A[Catch: all -> 0x0028, TRY_LEAVE, TryCatch #0 {all -> 0x0028, blocks: (B:3:0x0003, B:5:0x001f, B:8:0x002b, B:10:0x0039, B:13:0x0042, B:15:0x0050, B:17:0x006a, B:19:0x0075, B:21:0x008b, B:22:0x0090, B:25:0x009e, B:26:0x00b8, B:28:0x00c1, B:29:0x00f1, B:31:0x00f7, B:32:0x0104, B:34:0x0107, B:35:0x0129, B:37:0x013d, B:42:0x014d, B:27:0x00bc, B:14:0x0047), top: B:47:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x014d A[Catch: all -> 0x0028, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0028, blocks: (B:3:0x0003, B:5:0x001f, B:8:0x002b, B:10:0x0039, B:13:0x0042, B:15:0x0050, B:17:0x006a, B:19:0x0075, B:21:0x008b, B:22:0x0090, B:25:0x009e, B:26:0x00b8, B:28:0x00c1, B:29:0x00f1, B:31:0x00f7, B:32:0x0104, B:34:0x0107, B:35:0x0129, B:37:0x013d, B:42:0x014d, B:27:0x00bc, B:14:0x0047), top: B:47:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.bouncycastle.est.ESTResponse performRequest(org.bouncycastle.est.ESTRequest r10) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 345
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.est.jcajce.DefaultESTClient.performRequest(org.bouncycastle.est.ESTRequest):org.bouncycastle.est.ESTResponse");
    }

    protected ESTRequest redirectURL(ESTResponse eSTResponse) throws IOException {
        ESTRequest eSTRequest;
        ESTRequestBuilder withURL;
        if (eSTResponse.getStatusCode() < 300 || eSTResponse.getStatusCode() > 399) {
            eSTRequest = null;
        } else {
            switch (eSTResponse.getStatusCode()) {
                case 301:
                case 302:
                case 303:
                case 306:
                case 307:
                    String header = eSTResponse.getHeader("Location");
                    if (!"".equals(header)) {
                        ESTRequestBuilder eSTRequestBuilder = new ESTRequestBuilder(eSTResponse.getOriginalRequest());
                        if (header.startsWith("http")) {
                            withURL = eSTRequestBuilder.withURL(new URL(header));
                        } else {
                            URL url = eSTResponse.getOriginalRequest().getURL();
                            withURL = eSTRequestBuilder.withURL(new URL(url.getProtocol(), url.getHost(), url.getPort(), header));
                        }
                        eSTRequest = withURL.build();
                        break;
                    } else {
                        throw new ESTException("Redirect status type: " + eSTResponse.getStatusCode() + " but no location header");
                    }
                case 304:
                case 305:
                default:
                    throw new ESTException("Client does not handle http status code: " + eSTResponse.getStatusCode());
            }
        }
        if (eSTRequest != null) {
            eSTResponse.close();
        }
        return eSTRequest;
    }
}
