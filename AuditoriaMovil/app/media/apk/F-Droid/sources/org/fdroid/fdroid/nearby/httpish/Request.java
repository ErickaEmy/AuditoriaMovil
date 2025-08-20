package org.fdroid.fdroid.nearby.httpish;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.fdroid.fdroid.Utils;
import org.fdroid.fdroid.nearby.BluetoothConnection;
/* loaded from: classes2.dex */
public final class Request {
    private static final String TAG = "bluetooth.Request";
    private final BluetoothConnection connection;
    private Map<String, String> headers;
    private final InputStream input;
    private String method;
    private final Writer output;
    private String path;

    /* loaded from: classes2.dex */
    public interface Methods {
        public static final String GET = "GET";
        public static final String HEAD = "HEAD";
    }

    public String getMethod() {
        return this.method;
    }

    public String getPath() {
        return this.path;
    }

    private Request(String str, String str2, BluetoothConnection bluetoothConnection) {
        this.method = str;
        this.path = str2;
        this.connection = bluetoothConnection;
        this.output = new OutputStreamWriter(bluetoothConnection.getOutputStream());
        this.input = bluetoothConnection.getInputStream();
    }

    public static Request createHEAD(String str, BluetoothConnection bluetoothConnection) {
        return new Request(Methods.HEAD, str, bluetoothConnection);
    }

    public static Request createGET(String str, BluetoothConnection bluetoothConnection) {
        return new Request(Methods.GET, str, bluetoothConnection);
    }

    public String getHeaderValue(String str) {
        if (this.headers.containsKey(str)) {
            return this.headers.get(str);
        }
        return null;
    }

    public Response send() throws IOException {
        Utils.debugLog(TAG, "Sending request to server (" + this.path + ")");
        this.output.write(this.method);
        this.output.write(32);
        this.output.write(this.path);
        this.output.write("\n\n");
        this.output.flush();
        Utils.debugLog(TAG, "Finished sending request, now attempting to read response status code...");
        int readResponseCode = readResponseCode();
        Utils.debugLog(TAG, "Read response code " + readResponseCode + " from server, now reading headers...");
        Map<String, String> readHeaders = readHeaders();
        Utils.debugLog(TAG, "Read " + readHeaders.size() + " headers");
        if (this.method.equals(Methods.HEAD)) {
            Utils.debugLog(TAG, "Request was a HEAD request, not including anything other than headers and status...");
            return new Response(readResponseCode, readHeaders);
        }
        Utils.debugLog(TAG, "Request was a GET request, so including content stream in response...");
        return new Response(readResponseCode, readHeaders, this.connection.getInputStream());
    }

    private boolean listen() throws IOException {
        String readLine = readLine();
        if (readLine == null || readLine.trim().length() == 0) {
            return false;
        }
        String[] split = readLine.split("\\s+");
        if (split.length < 2) {
            return false;
        }
        this.method = split[0].toUpperCase(Locale.ENGLISH);
        this.path = split[1];
        this.headers = readHeaders();
        return true;
    }

    public static Request listenForRequest(BluetoothConnection bluetoothConnection) throws IOException {
        Request request = new Request("", "", bluetoothConnection);
        if (request.listen()) {
            return request;
        }
        return null;
    }

    private int readResponseCode() throws IOException {
        String readLine = readLine();
        int indexOf = readLine.indexOf(32) + 1;
        return Integer.parseInt(readLine.substring(indexOf, readLine.indexOf(32, indexOf)));
    }

    private String readLine() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            if (this.input.available() > 0) {
                int read = this.input.read();
                if (((char) read) == '\n') {
                    break;
                }
                byteArrayOutputStream.write(read);
            } else {
                try {
                    Thread.sleep(100L);
                } catch (Exception unused) {
                }
            }
        }
        if (byteArrayOutputStream.size() > 0) {
            return byteArrayOutputStream.toString();
        }
        return null;
    }

    private Map<String, String> readHeaders() throws IOException {
        HashMap hashMap = new HashMap();
        String readLine = readLine();
        while (readLine != null) {
            String[] split = readLine.split(":");
            if (split.length > 1) {
                hashMap.put(split[0].trim(), split[1].trim());
            }
            if (this.input.available() <= 0) {
                break;
            }
            readLine = readLine();
        }
        return hashMap;
    }
}
