package kellinwood.security.zipsigner;

import android.util.Base64;
import ch.qos.logback.core.CoreConstants;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.security.DigestOutputStream;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.TreeMap;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.EncryptedPrivateKeyInfo;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import kellinwood.logging.LoggerInterface;
import kellinwood.logging.LoggerManager;
import kellinwood.security.zipsigner.ResourceAdapter;
import kellinwood.security.zipsigner.optional.SignatureBlockGenerator;
import kellinwood.zipio.ZioEntry;
import kellinwood.zipio.ZipInput;
import kellinwood.zipio.ZipOutput;
import org.fdroid.fdroid.nearby.LocalRepoKeyStore;
/* loaded from: classes.dex */
public class ZipSigner {
    private static final String CERT_RSA_NAME = "META-INF/CERT.RSA";
    private static final String CERT_SF_NAME = "META-INF/CERT.SF";
    static LoggerInterface log;
    private static Pattern stripPattern = Pattern.compile("^META-INF/(.*)[.](SF|RSA|DSA)$");
    public static final String MODE_AUTO_TESTKEY = "auto-testkey";
    public static final String MODE_AUTO = "auto";
    public static final String MODE_AUTO_NONE = "auto-none";
    public static final String KEY_TESTKEY = "testkey";
    public static final String KEY_NONE = "none";
    public static final String[] SUPPORTED_KEY_MODES = {MODE_AUTO_TESTKEY, MODE_AUTO, MODE_AUTO_NONE, "media", "platform", "shared", KEY_TESTKEY, KEY_NONE};
    private boolean canceled = false;
    private ProgressHelper progressHelper = new ProgressHelper();
    private ResourceAdapter resourceAdapter = new DefaultResourceAdapter();
    Map<String, KeySet> loadedKeys = new HashMap();
    KeySet keySet = null;
    String keymode = KEY_TESTKEY;
    Map<String, String> autoKeyDetect = new HashMap();
    AutoKeyObservable autoKeyObservable = new AutoKeyObservable();

    public static String[] getSupportedKeyModes() {
        return SUPPORTED_KEY_MODES;
    }

    public void cancel() {
        this.canceled = true;
    }

    public KeySet getKeySet() {
        return this.keySet;
    }

    public String getKeymode() {
        return this.keymode;
    }

    public ResourceAdapter getResourceAdapter() {
        return this.resourceAdapter;
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    public void resetCanceled() {
        this.canceled = false;
    }

    public void setResourceAdapter(ResourceAdapter resourceAdapter) {
        this.resourceAdapter = resourceAdapter;
    }

    public static LoggerInterface getLogger() {
        if (log == null) {
            log = LoggerManager.getLogger(ZipSigner.class.getName());
        }
        return log;
    }

    public ZipSigner() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        this.autoKeyDetect.put("aa9852bc5a53272ac8031d49b65e4b0e", "media");
        this.autoKeyDetect.put("e60418c4b638f20d0721e115674ca11f", "platform");
        this.autoKeyDetect.put("3e24e49741b60c215c010dc6048fca7d", "shared");
        this.autoKeyDetect.put("dab2cead827ef5313f28e22b6fa8479f", KEY_TESTKEY);
    }

    public void addAutoKeyObserver(Observer observer) {
        this.autoKeyObservable.addObserver(observer);
    }

    public void setKeymode(String str) throws IOException, GeneralSecurityException {
        if (getLogger().isDebugEnabled()) {
            LoggerInterface logger = getLogger();
            logger.debug("setKeymode: " + str);
        }
        this.keymode = str;
        if (str.startsWith(MODE_AUTO)) {
            this.keySet = null;
            return;
        }
        this.progressHelper.initProgress();
        loadKeys(this.keymode);
    }

    protected String autoDetectKey(String str, Map<String, ZioEntry> map) throws NoSuchAlgorithmException, IOException {
        boolean isDebugEnabled = getLogger().isDebugEnabled();
        if (str.startsWith(MODE_AUTO)) {
            String str2 = null;
            for (Map.Entry<String, ZioEntry> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key.startsWith("META-INF/") && key.endsWith(".RSA")) {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    byte[] data = entry.getValue().getData();
                    if (data.length < 1458) {
                        break;
                    }
                    messageDigest.update(data, 0, 1458);
                    byte[] digest = messageDigest.digest();
                    StringBuilder sb = new StringBuilder();
                    int length = digest.length;
                    for (int i = 0; i < length; i++) {
                        sb.append(String.format("%02x", Byte.valueOf(digest[i])));
                    }
                    String sb2 = sb.toString();
                    String str3 = this.autoKeyDetect.get(sb2);
                    if (isDebugEnabled) {
                        if (str3 != null) {
                            getLogger().debug(String.format("Auto-determined key=%s using md5=%s", str3, sb2));
                        } else {
                            getLogger().debug(String.format("Auto key determination failed for md5=%s", sb2));
                        }
                    }
                    if (str3 != null) {
                        return str3;
                    }
                    str2 = str3;
                }
            }
            if (str.equals(MODE_AUTO_TESTKEY)) {
                if (isDebugEnabled) {
                    getLogger().debug("Falling back to key=" + str2);
                    return KEY_TESTKEY;
                } else {
                    return KEY_TESTKEY;
                }
            }
            if (str.equals(MODE_AUTO_NONE)) {
                if (isDebugEnabled) {
                    getLogger().debug("Unable to determine key, returning: none");
                    return KEY_NONE;
                }
                return KEY_NONE;
            }
            return null;
        }
        return str;
    }

    public void issueLoadingCertAndKeysProgressEvent() {
        this.progressHelper.progress(1, this.resourceAdapter.getString(ResourceAdapter.Item.LOADING_CERTIFICATE_AND_KEY, new Object[0]));
    }

    public void loadKeys(String str) throws IOException, GeneralSecurityException {
        KeySet keySet = this.loadedKeys.get(str);
        this.keySet = keySet;
        if (keySet != null) {
            return;
        }
        KeySet keySet2 = new KeySet();
        this.keySet = keySet2;
        keySet2.setName(str);
        this.loadedKeys.put(str, this.keySet);
        if (KEY_NONE.equals(str)) {
            return;
        }
        issueLoadingCertAndKeysProgressEvent();
        Class<?> cls = getClass();
        this.keySet.setPrivateKey(readPrivateKey(cls.getResource("/keys/" + str + ".pk8"), null));
        Class<?> cls2 = getClass();
        this.keySet.setPublicKey(readPublicKey(cls2.getResource("/keys/" + str + ".x509.pem")));
        Class<?> cls3 = getClass();
        URL resource = cls3.getResource("/keys/" + str + ".sbt");
        if (resource != null) {
            this.keySet.setSigBlockTemplate(readContentAsBytes(resource));
        }
    }

    public void setKeys(String str, X509Certificate x509Certificate, PrivateKey privateKey, byte[] bArr) {
        this.keySet = new KeySet(str, x509Certificate, privateKey, bArr);
    }

    public void setKeys(String str, X509Certificate x509Certificate, PrivateKey privateKey, String str2, byte[] bArr) {
        this.keySet = new KeySet(str, x509Certificate, privateKey, str2, bArr);
    }

    public void loadProvider(String str) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Security.insertProviderAt((Provider) Class.forName(str).newInstance(), 1);
    }

    public X509Certificate readPublicKey(URL url) throws IOException, GeneralSecurityException {
        InputStream openStream = url.openStream();
        try {
            return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(openStream);
        } finally {
            openStream.close();
        }
    }

    private KeySpec decryptPrivateKey(byte[] bArr, String str) throws GeneralSecurityException {
        try {
            EncryptedPrivateKeyInfo encryptedPrivateKeyInfo = new EncryptedPrivateKeyInfo(bArr);
            SecretKey generateSecret = SecretKeyFactory.getInstance(encryptedPrivateKeyInfo.getAlgName()).generateSecret(new PBEKeySpec(str.toCharArray()));
            Cipher cipher = Cipher.getInstance(encryptedPrivateKeyInfo.getAlgName());
            cipher.init(2, generateSecret, encryptedPrivateKeyInfo.getAlgParameters());
            try {
                return encryptedPrivateKeyInfo.getKeySpec(cipher);
            } catch (InvalidKeySpecException e) {
                getLogger().error("signapk: Password for private key may be bad.");
                throw e;
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public byte[] readContentAsBytes(URL url) throws IOException {
        return readContentAsBytes(url.openStream());
    }

    public byte[] readContentAsBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        int read = inputStream.read(bArr);
        while (read != -1) {
            byteArrayOutputStream.write(bArr, 0, read);
            read = inputStream.read(bArr);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public PrivateKey readPrivateKey(URL url, String str) throws IOException, GeneralSecurityException {
        KeySpec decryptPrivateKey;
        DataInputStream dataInputStream = new DataInputStream(url.openStream());
        try {
            byte[] readContentAsBytes = readContentAsBytes(dataInputStream);
            decryptPrivateKey = decryptPrivateKey(readContentAsBytes, str);
            if (decryptPrivateKey == null) {
                decryptPrivateKey = new PKCS8EncodedKeySpec(readContentAsBytes);
            }
            return KeyFactory.getInstance("RSA").generatePrivate(decryptPrivateKey);
        } catch (InvalidKeySpecException unused) {
            return KeyFactory.getInstance("DSA").generatePrivate(decryptPrivateKey);
        } finally {
            dataInputStream.close();
        }
    }

    private Manifest addDigestsToManifest(Map<String, ZioEntry> map) throws IOException, GeneralSecurityException {
        Manifest manifest;
        Pattern pattern;
        Attributes attributes;
        ZioEntry zioEntry = map.get("META-INF/MANIFEST.MF");
        if (zioEntry != null) {
            manifest = new Manifest();
            manifest.read(zioEntry.getInputStream());
        } else {
            manifest = null;
        }
        Manifest manifest2 = new Manifest();
        Attributes mainAttributes = manifest2.getMainAttributes();
        if (manifest != null) {
            mainAttributes.putAll(manifest.getMainAttributes());
        } else {
            mainAttributes.putValue("Manifest-Version", "1.0");
            mainAttributes.putValue("Created-By", "1.0 (Android SignApk)");
        }
        MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
        byte[] bArr = new byte[512];
        TreeMap treeMap = new TreeMap();
        treeMap.putAll(map);
        boolean isDebugEnabled = getLogger().isDebugEnabled();
        if (isDebugEnabled) {
            getLogger().debug("Manifest entries:");
        }
        for (ZioEntry zioEntry2 : treeMap.values()) {
            if (this.canceled) {
                break;
            }
            String name = zioEntry2.getName();
            if (isDebugEnabled) {
                getLogger().debug(name);
            }
            if (!zioEntry2.isDirectory() && !name.equals("META-INF/MANIFEST.MF") && !name.equals(CERT_SF_NAME) && !name.equals(CERT_RSA_NAME) && ((pattern = stripPattern) == null || !pattern.matcher(name).matches())) {
                this.progressHelper.progress(0, this.resourceAdapter.getString(ResourceAdapter.Item.GENERATING_MANIFEST, new Object[0]));
                InputStream inputStream = zioEntry2.getInputStream();
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                Attributes attributes2 = (manifest == null || (attributes = manifest.getAttributes(name)) == null) ? null : new Attributes(attributes);
                if (attributes2 == null) {
                    attributes2 = new Attributes();
                }
                attributes2.putValue("SHA1-Digest", Base64.encodeToString(messageDigest.digest(), 2));
                manifest2.getEntries().put(name, attributes2);
            }
        }
        return manifest2;
    }

    private void generateSignatureFile(Manifest manifest, OutputStream outputStream) throws IOException, GeneralSecurityException {
        MessageDigest messageDigest;
        outputStream.write("Signature-Version: 1.0\r\n".getBytes());
        outputStream.write("Created-By: 1.0 (Android SignApk)\r\n".getBytes());
        PrintStream printStream = new PrintStream(new DigestOutputStream(new ByteArrayOutputStream(), MessageDigest.getInstance("SHA1")), true, "UTF-8");
        manifest.write(printStream);
        printStream.flush();
        outputStream.write(("SHA1-Digest-Manifest: " + Base64.encodeToString(messageDigest.digest(), 2) + "\r\n\r\n").getBytes());
        for (Map.Entry<String, Attributes> entry : manifest.getEntries().entrySet()) {
            if (this.canceled) {
                return;
            }
            this.progressHelper.progress(0, this.resourceAdapter.getString(ResourceAdapter.Item.GENERATING_SIGNATURE_FILE, new Object[0]));
            String str = "Name: " + entry.getKey() + "\r\n";
            printStream.print(str);
            for (Map.Entry<Object, Object> entry2 : entry.getValue().entrySet()) {
                printStream.print(entry2.getKey() + ": " + entry2.getValue() + "\r\n");
            }
            printStream.print("\r\n");
            printStream.flush();
            outputStream.write(str.getBytes());
            outputStream.write(("SHA1-Digest: " + Base64.encodeToString(messageDigest.digest(), 2) + "\r\n\r\n").getBytes());
        }
    }

    private void writeSignatureBlock(KeySet keySet, byte[] bArr, OutputStream outputStream) throws IOException, GeneralSecurityException {
        if (keySet.getSigBlockTemplate() != null) {
            Signature signature = Signature.getInstance(LocalRepoKeyStore.DEFAULT_SIG_ALG);
            signature.initSign(keySet.getPrivateKey());
            signature.update(bArr);
            byte[] sign = signature.sign();
            outputStream.write(keySet.getSigBlockTemplate());
            outputStream.write(sign);
            if (getLogger().isDebugEnabled()) {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                messageDigest.update(bArr);
                byte[] digest = messageDigest.digest();
                LoggerInterface logger = getLogger();
                logger.debug("Sig File SHA1: \n" + HexDumpEncoder.encode(digest));
                LoggerInterface logger2 = getLogger();
                logger2.debug("Signature: \n" + HexDumpEncoder.encode(sign));
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(2, keySet.getPublicKey());
                byte[] doFinal = cipher.doFinal(sign);
                LoggerInterface logger3 = getLogger();
                logger3.debug("Signature Decrypted: \n" + HexDumpEncoder.encode(doFinal));
                return;
            }
            return;
        }
        try {
            outputStream.write((byte[]) SignatureBlockGenerator.class.getMethod("generate", KeySet.class, new byte[1].getClass()).invoke(null, keySet, bArr));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private void copyFiles(Manifest manifest, Map<String, ZioEntry> map, ZipOutput zipOutput, long j) throws IOException {
        ArrayList<String> arrayList = new ArrayList(manifest.getEntries().keySet());
        Collections.sort(arrayList);
        int i = 1;
        for (String str : arrayList) {
            if (this.canceled) {
                return;
            }
            this.progressHelper.progress(0, this.resourceAdapter.getString(ResourceAdapter.Item.COPYING_ZIP_ENTRY, Integer.valueOf(i), Integer.valueOf(arrayList.size())));
            i++;
            ZioEntry zioEntry = map.get(str);
            zioEntry.setTime(j);
            zipOutput.write(zioEntry);
        }
    }

    private void copyFiles(Map<String, ZioEntry> map, ZipOutput zipOutput) throws IOException {
        int i = 1;
        for (ZioEntry zioEntry : map.values()) {
            if (this.canceled) {
                return;
            }
            this.progressHelper.progress(0, this.resourceAdapter.getString(ResourceAdapter.Item.COPYING_ZIP_ENTRY, Integer.valueOf(i), Integer.valueOf(map.size())));
            i++;
            zipOutput.write(zioEntry);
        }
    }

    public void signZip(URL url, String str, String str2, String str3, String str4, String str5, String str6) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException, GeneralSecurityException {
        signZip(url, str, str2.toCharArray(), str3, str4.toCharArray(), LocalRepoKeyStore.DEFAULT_SIG_ALG, str5, str6);
    }

    public void signZip(URL url, String str, char[] cArr, String str2, char[] cArr2, String str3, String str4, String str5) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException, GeneralSecurityException {
        InputStream inputStream = null;
        if (str == null) {
            try {
                str = KeyStore.getDefaultType();
            } catch (Throwable th) {
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
        }
        KeyStore keyStore = KeyStore.getInstance(str);
        inputStream = url.openStream();
        keyStore.load(inputStream, cArr);
        setKeys("custom", (X509Certificate) keyStore.getCertificate(str2), (PrivateKey) keyStore.getKey(str2, cArr2), str3, null);
        signZip(str4, str5);
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public void signZip(Map<String, ZioEntry> map, String str) throws IOException, GeneralSecurityException {
        this.progressHelper.initProgress();
        signZip(map, new FileOutputStream(str), str);
    }

    public void signZip(String str, String str2) throws IOException, GeneralSecurityException {
        FileOutputStream fileOutputStream;
        if (new File(str).getCanonicalFile().equals(new File(str2).getCanonicalFile())) {
            throw new IllegalArgumentException(this.resourceAdapter.getString(ResourceAdapter.Item.INPUT_SAME_AS_OUTPUT_ERROR, new Object[0]));
        }
        this.progressHelper.initProgress();
        this.progressHelper.progress(1, this.resourceAdapter.getString(ResourceAdapter.Item.PARSING_CENTRAL_DIRECTORY, new Object[0]));
        ZipInput zipInput = null;
        try {
            ZipInput read = ZipInput.read(str);
            try {
                fileOutputStream = new FileOutputStream(str2);
                try {
                    signZip(read.getEntries(), fileOutputStream, str2);
                    read.close();
                    fileOutputStream.close();
                } catch (Throwable th) {
                    th = th;
                    zipInput = read;
                    if (zipInput != null) {
                        zipInput.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    public void signZip(Map<String, ZioEntry> map, OutputStream outputStream, String str) throws IOException, GeneralSecurityException {
        ZipOutput zipOutput;
        Pattern pattern;
        boolean isDebugEnabled = getLogger().isDebugEnabled();
        this.progressHelper.initProgress();
        if (this.keySet == null) {
            if (!this.keymode.startsWith(MODE_AUTO)) {
                throw new IllegalStateException("No keys configured for signing the file!");
            }
            String autoDetectKey = autoDetectKey(this.keymode, map);
            if (autoDetectKey == null) {
                throw new AutoKeyException(this.resourceAdapter.getString(ResourceAdapter.Item.AUTO_KEY_SELECTION_ERROR, new File(str).getName()));
            }
            this.autoKeyObservable.notifyObservers(autoDetectKey);
            loadKeys(autoDetectKey);
        }
        ZipOutput zipOutput2 = null;
        try {
            zipOutput = new ZipOutput(outputStream);
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (KEY_NONE.equals(this.keySet.getName())) {
                this.progressHelper.setProgressTotalItems(map.size());
                this.progressHelper.setProgressCurrentItem(0);
                copyFiles(map, zipOutput);
                zipOutput.close();
                if (!this.canceled || str == null) {
                    return;
                }
                try {
                    new File(str).delete();
                    return;
                } catch (Throwable th2) {
                    getLogger().warning(th2.getClass().getName() + ":" + th2.getMessage());
                    return;
                }
            }
            int i = 0;
            for (ZioEntry zioEntry : map.values()) {
                String name = zioEntry.getName();
                if (!zioEntry.isDirectory() && !name.equals("META-INF/MANIFEST.MF") && !name.equals(CERT_SF_NAME) && !name.equals(CERT_RSA_NAME) && ((pattern = stripPattern) == null || !pattern.matcher(name).matches())) {
                    i += 3;
                }
            }
            this.progressHelper.setProgressTotalItems(i + 1);
            this.progressHelper.setProgressCurrentItem(0);
            long time = CoreConstants.MILLIS_IN_ONE_HOUR + this.keySet.getPublicKey().getNotBefore().getTime();
            Manifest addDigestsToManifest = addDigestsToManifest(map);
            if (this.canceled) {
                zipOutput.close();
                if (!this.canceled || str == null) {
                    return;
                }
                try {
                    new File(str).delete();
                    return;
                } catch (Throwable th3) {
                    getLogger().warning(th3.getClass().getName() + ":" + th3.getMessage());
                    return;
                }
            }
            ZioEntry zioEntry2 = new ZioEntry("META-INF/MANIFEST.MF");
            zioEntry2.setTime(time);
            addDigestsToManifest.write(zioEntry2.getOutputStream());
            zipOutput.write(zioEntry2);
            ZioEntry zioEntry3 = new ZioEntry(CERT_SF_NAME);
            zioEntry3.setTime(time);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            generateSignatureFile(addDigestsToManifest, byteArrayOutputStream);
            if (this.canceled) {
                zipOutput.close();
                if (!this.canceled || str == null) {
                    return;
                }
                try {
                    new File(str).delete();
                    return;
                } catch (Throwable th4) {
                    getLogger().warning(th4.getClass().getName() + ":" + th4.getMessage());
                    return;
                }
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (isDebugEnabled) {
                getLogger().debug("Signature File: \n" + new String(byteArray) + "\n" + HexDumpEncoder.encode(byteArray));
            }
            zioEntry3.getOutputStream().write(byteArray);
            zipOutput.write(zioEntry3);
            this.progressHelper.progress(0, this.resourceAdapter.getString(ResourceAdapter.Item.GENERATING_SIGNATURE_BLOCK, new Object[0]));
            ZioEntry zioEntry4 = new ZioEntry(CERT_RSA_NAME);
            zioEntry4.setTime(time);
            writeSignatureBlock(this.keySet, byteArray, zioEntry4.getOutputStream());
            zipOutput.write(zioEntry4);
            if (this.canceled) {
                zipOutput.close();
                if (!this.canceled || str == null) {
                    return;
                }
                try {
                    new File(str).delete();
                    return;
                } catch (Throwable th5) {
                    getLogger().warning(th5.getClass().getName() + ":" + th5.getMessage());
                    return;
                }
            }
            copyFiles(addDigestsToManifest, map, zipOutput, time);
            if (this.canceled) {
                zipOutput.close();
                if (!this.canceled || str == null) {
                    return;
                }
                try {
                    new File(str).delete();
                    return;
                } catch (Throwable th6) {
                    getLogger().warning(th6.getClass().getName() + ":" + th6.getMessage());
                    return;
                }
            }
            zipOutput.close();
            if (!this.canceled || str == null) {
                return;
            }
            try {
                new File(str).delete();
            } catch (Throwable th7) {
                getLogger().warning(th7.getClass().getName() + ":" + th7.getMessage());
            }
        } catch (Throwable th8) {
            th = th8;
            zipOutput2 = zipOutput;
            if (zipOutput2 != null) {
                zipOutput2.close();
            }
            if (this.canceled && str != null) {
                try {
                    new File(str).delete();
                } catch (Throwable th9) {
                    getLogger().warning(th9.getClass().getName() + ":" + th9.getMessage());
                }
            }
            throw th;
        }
    }

    public void addProgressListener(ProgressListener progressListener) {
        this.progressHelper.addProgressListener(progressListener);
    }

    public synchronized void removeProgressListener(ProgressListener progressListener) {
        this.progressHelper.removeProgressListener(progressListener);
    }

    /* loaded from: classes.dex */
    public static class AutoKeyObservable extends Observable {
        @Override // java.util.Observable
        public void notifyObservers(Object obj) {
            super.setChanged();
            super.notifyObservers(obj);
        }
    }
}
