package org.fdroid.fdroid.nearby;

import android.content.Context;
import android.net.Uri;
import ch.qos.logback.core.spi.AbstractComponentTracker;
import fi.iki.elonen.NanoHTTPD;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.TimeZone;
import org.fdroid.fdroid.nearby.LocalRepoKeyStore;
/* loaded from: classes2.dex */
public class LocalHTTPD extends NanoHTTPD {
    public static final String[] INDEX_FILE_NAMES = {"index.html"};
    private static final DateFormat RFC_1123;
    private static final String TAG = "LocalHTTPD";
    private final WeakReference<Context> context;
    protected List<File> rootDirs;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        RFC_1123 = simpleDateFormat;
        simpleDateFormat.setLenient(false);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    }

    public LocalHTTPD(Context context, String str, int i, File file, boolean z) {
        super(str, i);
        this.rootDirs = Collections.singletonList(file);
        this.context = new WeakReference<>(context.getApplicationContext());
        if (z) {
            enableHTTPS();
        }
        HashMap hashMap = new HashMap();
        NanoHTTPD.MIME_TYPES = hashMap;
        hashMap.put("apk", "application/vnd.android.package-archive");
        NanoHTTPD.MIME_TYPES.put("html", NanoHTTPD.MIME_HTML);
        NanoHTTPD.MIME_TYPES.put("png", "image/png");
        NanoHTTPD.MIME_TYPES.put("xml", "application/xml");
    }

    private boolean canServeUri(String str, File file) {
        return new File(file, str).exists();
    }

    private String encodeUri(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, "/ ", true);
        String str2 = "";
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if ("/".equals(nextToken)) {
                str2 = str2 + "/";
            } else if (" ".equals(nextToken)) {
                str2 = str2 + "%20";
            } else {
                try {
                    str2 = str2 + URLEncoder.encode(nextToken, "UTF-8");
                } catch (UnsupportedEncodingException unused) {
                }
            }
        }
        return str2;
    }

    private String findIndexFileInDirectory(File file) {
        String[] strArr;
        for (String str : INDEX_FILE_NAMES) {
            if (new File(file, str).isFile()) {
                return str;
            }
        }
        return null;
    }

    protected NanoHTTPD.Response getForbiddenResponse(String str) {
        NanoHTTPD.Response.Status status = NanoHTTPD.Response.Status.FORBIDDEN;
        return newFixedLengthResponse(status, NanoHTTPD.MIME_PLAINTEXT, "FORBIDDEN: " + str);
    }

    protected NanoHTTPD.Response getInternalErrorResponse(String str) {
        NanoHTTPD.Response.Status status = NanoHTTPD.Response.Status.INTERNAL_ERROR;
        return newFixedLengthResponse(status, NanoHTTPD.MIME_PLAINTEXT, "INTERNAL ERROR: " + str);
    }

    protected NanoHTTPD.Response getNotFoundResponse() {
        return newFixedLengthResponse(NanoHTTPD.Response.Status.NOT_FOUND, NanoHTTPD.MIME_PLAINTEXT, "Error 404, file not found.");
    }

    protected String listDirectory(String str, File file) {
        String substring;
        int lastIndexOf;
        String str2 = "Directory " + str;
        StringBuilder sb = new StringBuilder("<html><head><title>" + str2 + "</title><style><!--\nspan.dirname { font-weight: bold; }\nspan.filesize { font-size: 75%; }\n// -->\n</style></head><body><h1>" + str2 + "</h1>");
        String substring2 = (str.length() <= 1 || (lastIndexOf = (substring = str.substring(0, str.length() - 1)).lastIndexOf(47)) < 0 || lastIndexOf >= substring.length()) ? null : str.substring(0, lastIndexOf + 1);
        String[] list = file.list(new FilenameFilter() { // from class: org.fdroid.fdroid.nearby.LocalHTTPD$$ExternalSyntheticLambda0
            @Override // java.io.FilenameFilter
            public final boolean accept(File file2, String str3) {
                boolean lambda$listDirectory$0;
                lambda$listDirectory$0 = LocalHTTPD.lambda$listDirectory$0(file2, str3);
                return lambda$listDirectory$0;
            }
        });
        Objects.requireNonNull(list);
        List<String> asList = Arrays.asList(list);
        Collections.sort(asList);
        String[] list2 = file.list(new FilenameFilter() { // from class: org.fdroid.fdroid.nearby.LocalHTTPD$$ExternalSyntheticLambda1
            @Override // java.io.FilenameFilter
            public final boolean accept(File file2, String str3) {
                boolean lambda$listDirectory$1;
                lambda$listDirectory$1 = LocalHTTPD.lambda$listDirectory$1(file2, str3);
                return lambda$listDirectory$1;
            }
        });
        Objects.requireNonNull(list2);
        List asList2 = Arrays.asList(list2);
        Collections.sort(asList2);
        if (substring2 != null || asList2.size() + asList.size() > 0) {
            sb.append("<ul>");
            if (substring2 != null || asList2.size() > 0) {
                sb.append("<section class=\"directories\">");
                if (substring2 != null) {
                    sb.append("<li><a rel=\"directory\" href=\"");
                    sb.append(substring2);
                    sb.append("\"><span class=\"dirname\">..</span></a></li>");
                }
                Iterator it = asList2.iterator();
                while (it.hasNext()) {
                    String str3 = ((String) it.next()) + "/";
                    sb.append("<li><a rel=\"directory\" href=\"");
                    sb.append(encodeUri(str + str3));
                    sb.append("\"><span class=\"dirname\">");
                    sb.append(str3);
                    sb.append("</span></a></li>");
                }
                sb.append("</section>");
            }
            if (asList.size() > 0) {
                sb.append("<section class=\"files\">");
                for (String str4 : asList) {
                    sb.append("<li><a href=\"");
                    sb.append(encodeUri(str + str4));
                    sb.append("\"><span class=\"filename\">");
                    sb.append(str4);
                    sb.append("</span></a>");
                    long length = new File(file, str4).length();
                    sb.append("&nbsp;<span class=\"filesize\">(");
                    if (length < 1024) {
                        sb.append(length);
                        sb.append(" bytes");
                    } else if (length < 1048576) {
                        sb.append(length / 1024);
                        sb.append(".");
                        sb.append(((length % 1024) / 10) % 100);
                        sb.append(" KB");
                    } else {
                        sb.append(length / 1048576);
                        sb.append(".");
                        sb.append(((length % 1048576) / AbstractComponentTracker.LINGERING_TIMEOUT) % 100);
                        sb.append(" MB");
                    }
                    sb.append(")</span></li>");
                }
                sb.append("</section>");
            }
            sb.append("</ul>");
        }
        sb.append("</body></html>");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$listDirectory$0(File file, String str) {
        return new File(file, str).isFile();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$listDirectory$1(File file, String str) {
        return new File(file, str).isDirectory();
    }

    public static NanoHTTPD.Response addResponseHeaders(NanoHTTPD.Response response) {
        response.setKeepAlive(false);
        response.setGzipEncoding(false);
        response.addHeader("Connection", "close");
        response.addHeader("Content-Security-Policy", "default-src 'none'; img-src 'self'; style-src 'self' 'unsafe-inline';");
        return response;
    }

    public static NanoHTTPD.Response newFixedLengthResponse(String str) {
        return addResponseHeaders(NanoHTTPD.newFixedLengthResponse(str));
    }

    public static NanoHTTPD.Response newFixedLengthResponse(NanoHTTPD.Response.IStatus iStatus, String str, InputStream inputStream, long j) {
        return addResponseHeaders(NanoHTTPD.newFixedLengthResponse(iStatus, str, inputStream, j));
    }

    public static NanoHTTPD.Response newFixedLengthResponse(NanoHTTPD.Response.IStatus iStatus, String str, String str2) {
        NanoHTTPD.Response newFixedLengthResponse = NanoHTTPD.newFixedLengthResponse(iStatus, str, str2);
        addResponseHeaders(newFixedLengthResponse);
        newFixedLengthResponse.addHeader("Accept-Ranges", "bytes");
        return newFixedLengthResponse;
    }

    private NanoHTTPD.Response respond(Map<String, String> map, NanoHTTPD.IHTTPSession iHTTPSession, String str) {
        return defaultRespond(map, iHTTPSession, str);
    }

    private NanoHTTPD.Response defaultRespond(Map<String, String> map, NanoHTTPD.IHTTPSession iHTTPSession, String str) {
        String replace = str.trim().replace(File.separatorChar, '/');
        boolean z = false;
        if (replace.indexOf(63) >= 0) {
            replace = replace.substring(0, replace.indexOf(63));
        }
        if (replace.contains("../")) {
            return getForbiddenResponse("Won't serve ../ for security reasons.");
        }
        File file = null;
        for (int i = 0; !z && i < this.rootDirs.size(); i++) {
            file = this.rootDirs.get(i);
            z = canServeUri(replace, file);
        }
        if (!z) {
            return getNotFoundResponse();
        }
        File file2 = new File(file, replace);
        if (file2.isDirectory() && !replace.endsWith("/")) {
            String str2 = replace + "/";
            NanoHTTPD.Response newFixedLengthResponse = newFixedLengthResponse(NanoHTTPD.Response.Status.REDIRECT, NanoHTTPD.MIME_HTML, "<html><body>Redirected: <a href=\"" + str2 + "\">" + str2 + "</a></body></html>");
            newFixedLengthResponse.addHeader("Location", str2);
            return newFixedLengthResponse;
        } else if (file2.isDirectory()) {
            String findIndexFileInDirectory = findIndexFileInDirectory(file2);
            if (findIndexFileInDirectory == null) {
                if (file2.canRead()) {
                    return newFixedLengthResponse(NanoHTTPD.Response.Status.OK, NanoHTTPD.MIME_HTML, listDirectory(replace, file2));
                }
                return getForbiddenResponse("No directory listing.");
            }
            return respond(map, iHTTPSession, replace + findIndexFileInDirectory);
        } else {
            NanoHTTPD.Response serveFile = serveFile(replace, map, file2, NanoHTTPD.getMimeTypeForFile(replace));
            return serveFile != null ? serveFile : getNotFoundResponse();
        }
    }

    @Override // fi.iki.elonen.NanoHTTPD
    public NanoHTTPD.Response serve(NanoHTTPD.IHTTPSession iHTTPSession) {
        Map headers = iHTTPSession.getHeaders();
        iHTTPSession.getParms();
        String uri = iHTTPSession.getUri();
        if (iHTTPSession.getMethod() == NanoHTTPD.Method.POST) {
            try {
                iHTTPSession.parseBody(new HashMap());
                return handlePost(iHTTPSession);
            } catch (NanoHTTPD.ResponseException e) {
                return newFixedLengthResponse(e.getStatus(), NanoHTTPD.MIME_PLAINTEXT, e.getMessage());
            } catch (IOException unused) {
                return newFixedLengthResponse(NanoHTTPD.Response.Status.INTERNAL_ERROR, NanoHTTPD.MIME_PLAINTEXT, "Internal server error, check logcat on server for details.");
            }
        }
        for (File file : this.rootDirs) {
            if (!file.isDirectory()) {
                return getInternalErrorResponse("given path is not a directory (" + file + ").");
            }
        }
        return respond(Collections.unmodifiableMap(headers), iHTTPSession, uri);
    }

    private NanoHTTPD.Response handlePost(NanoHTTPD.IHTTPSession iHTTPSession) {
        String path = Uri.parse(iHTTPSession.getUri()).getPath();
        path.hashCode();
        if (path.equals("/request-swap")) {
            if (!iHTTPSession.getParms().containsKey("repo")) {
                return newFixedLengthResponse(NanoHTTPD.Response.Status.BAD_REQUEST, NanoHTTPD.MIME_PLAINTEXT, "Requires 'repo' parameter to be posted.");
            }
            SwapWorkflowActivity.requestSwap(this.context.get(), (String) iHTTPSession.getParms().get("repo"));
            return newFixedLengthResponse(NanoHTTPD.Response.Status.OK, NanoHTTPD.MIME_PLAINTEXT, "Swap request received.");
        }
        return newFixedLengthResponse("");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(24:1|(2:2|3)|(24:9|10|11|12|13|14|(11:19|20|(1:69)(1:26)|27|28|29|(2:51|(1:(1:(5:63|64|65|40|41)(1:62))(1:59))(1:56))(1:(1:37)(8:43|(1:45)|46|(1:48)(1:50)|49|39|40|41))|38|39|40|41)|70|20|(2:22|24)|69|27|28|29|(0)|51|(0)|(0)|(0)|63|64|65|40|41)|75|14|(18:16|19|20|(0)|69|27|28|29|(0)|51|(0)|(0)|(0)|63|64|65|40|41)|70|20|(0)|69|27|28|29|(0)|51|(0)|(0)|(0)|63|64|65|40|41|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c5, code lost:
        r0 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01bc, code lost:
        r2 = r0.getForbiddenResponse("Reading file failed.");
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0088 A[Catch: IOException -> 0x01bc, TryCatch #3 {IOException -> 0x01bc, blocks: (B:3:0x000a, B:5:0x0041, B:7:0x0049, B:9:0x0056, B:11:0x005f, B:14:0x006a, B:16:0x0074, B:21:0x007e, B:23:0x0088, B:25:0x0090, B:29:0x0099, B:64:0x018f), top: B:77:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0145 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x016e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x017d A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    fi.iki.elonen.NanoHTTPD.Response serveFile(java.lang.String r21, java.util.Map<java.lang.String, java.lang.String> r22, java.io.File r23, java.lang.String r24) {
        /*
            Method dump skipped, instructions count: 455
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.fdroid.nearby.LocalHTTPD.serveFile(java.lang.String, java.util.Map, java.io.File, java.lang.String):fi.iki.elonen.NanoHTTPD$Response");
    }

    private NanoHTTPD.Response newFixedFileResponse(File file, String str) throws FileNotFoundException {
        NanoHTTPD.Response newFixedLengthResponse = newFixedLengthResponse(NanoHTTPD.Response.Status.OK, str, new FileInputStream(file), (int) file.length());
        addResponseHeaders(newFixedLengthResponse);
        newFixedLengthResponse.addHeader("Accept-Ranges", "bytes");
        return newFixedLengthResponse;
    }

    private void enableHTTPS() {
        try {
            LocalRepoKeyStore localRepoKeyStore = LocalRepoKeyStore.get(this.context.get());
            makeSecure(NanoHTTPD.makeSSLSocketFactory(localRepoKeyStore.getKeyStore(), localRepoKeyStore.getKeyManagers()), null);
        } catch (IOException | LocalRepoKeyStore.InitException e) {
            e.printStackTrace();
        }
    }
}
