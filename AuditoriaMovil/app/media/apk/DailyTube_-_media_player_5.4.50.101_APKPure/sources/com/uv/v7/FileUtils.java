package com.uv.v7;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class FileUtils {
    private boolean copyToFile(InputStream inputStream, File file) throws Exception {
        FileOutputStream fileOutputStream;
        if (file.exists()) {
            file.delete();
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read >= 0) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.flush();
                        try {
                            fileOutputStream.close();
                            return true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            throw e2;
                        }
                    }
                }
            } catch (FileNotFoundException e3) {
                throw e3;
            } catch (IOException e5) {
                throw e5;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                        throw e6;
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e8) {
            throw e8;
        } catch (IOException e9) {
            throw e9;
        }
    }

    public static boolean deleteFile(File file) {
        if (file.isDirectory()) {
            for (String str : file.list()) {
                if (!deleteFile(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public boolean copyAssetToFiles(Context context, String str, String str2) throws Exception {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        File file = new File(str2);
        if (file.exists() && file.isFile()) {
            file.delete();
        } else {
            file.getParentFile().mkdirs();
        }
        InputStream inputStream = null;
        try {
            try {
                inputStream = context.getAssets().open(str);
                if (copyToFile(inputStream, file)) {
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                return false;
            } catch (IOException e2) {
                throw e2;
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}
