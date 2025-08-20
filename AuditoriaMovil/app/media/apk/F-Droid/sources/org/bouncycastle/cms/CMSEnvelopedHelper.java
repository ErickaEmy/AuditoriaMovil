package org.bouncycastle.cms;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.cms.KEKRecipientInfo;
import org.bouncycastle.asn1.cms.KeyAgreeRecipientInfo;
import org.bouncycastle.asn1.cms.KeyTransRecipientInfo;
import org.bouncycastle.asn1.cms.PasswordRecipientInfo;
import org.bouncycastle.asn1.cms.RecipientInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.operator.DigestCalculator;
/* loaded from: classes2.dex */
class CMSEnvelopedHelper {

    /* loaded from: classes2.dex */
    static class CMSAuthenticatedSecureReadable implements CMSSecureReadable {
        private AlgorithmIdentifier algorithm;
        private final ASN1ObjectIdentifier contentType;
        private CMSReadable readable;

        /* JADX INFO: Access modifiers changed from: package-private */
        public CMSAuthenticatedSecureReadable(AlgorithmIdentifier algorithmIdentifier, ASN1ObjectIdentifier aSN1ObjectIdentifier, CMSReadable cMSReadable) {
            this.algorithm = algorithmIdentifier;
            this.contentType = aSN1ObjectIdentifier;
            this.readable = cMSReadable;
        }

        @Override // org.bouncycastle.cms.CMSSecureReadable
        public ASN1ObjectIdentifier getContentType() {
            return this.contentType;
        }

        @Override // org.bouncycastle.cms.CMSSecureReadable
        public InputStream getInputStream() throws IOException, CMSException {
            return this.readable.getInputStream();
        }
    }

    /* loaded from: classes2.dex */
    static class CMSDigestAuthenticatedSecureReadable implements CMSSecureReadable {
        private final ASN1ObjectIdentifier contentType;
        private DigestCalculator digestCalculator;
        private CMSReadable readable;

        public CMSDigestAuthenticatedSecureReadable(DigestCalculator digestCalculator, ASN1ObjectIdentifier aSN1ObjectIdentifier, CMSReadable cMSReadable) {
            this.digestCalculator = digestCalculator;
            this.contentType = aSN1ObjectIdentifier;
            this.readable = cMSReadable;
        }

        @Override // org.bouncycastle.cms.CMSSecureReadable
        public ASN1ObjectIdentifier getContentType() {
            return this.contentType;
        }

        public byte[] getDigest() {
            return this.digestCalculator.getDigest();
        }

        @Override // org.bouncycastle.cms.CMSSecureReadable
        public InputStream getInputStream() throws IOException, CMSException {
            return new FilterInputStream(this.readable.getInputStream()) { // from class: org.bouncycastle.cms.CMSEnvelopedHelper.CMSDigestAuthenticatedSecureReadable.1
                @Override // java.io.FilterInputStream, java.io.InputStream
                public int read() throws IOException {
                    int read = ((FilterInputStream) this).in.read();
                    if (read >= 0) {
                        CMSDigestAuthenticatedSecureReadable.this.digestCalculator.getOutputStream().write(read);
                    }
                    return read;
                }

                @Override // java.io.FilterInputStream, java.io.InputStream
                public int read(byte[] bArr, int i, int i2) throws IOException {
                    int read = ((FilterInputStream) this).in.read(bArr, i, i2);
                    if (read >= 0) {
                        CMSDigestAuthenticatedSecureReadable.this.digestCalculator.getOutputStream().write(bArr, i, read);
                    }
                    return read;
                }
            };
        }
    }

    /* loaded from: classes2.dex */
    static class CMSEnvelopedSecureReadable implements CMSSecureReadable {
        private AlgorithmIdentifier algorithm;
        private final ASN1ObjectIdentifier contentType;
        private CMSReadable readable;

        /* JADX INFO: Access modifiers changed from: package-private */
        public CMSEnvelopedSecureReadable(AlgorithmIdentifier algorithmIdentifier, ASN1ObjectIdentifier aSN1ObjectIdentifier, CMSReadable cMSReadable) {
            this.algorithm = algorithmIdentifier;
            this.contentType = aSN1ObjectIdentifier;
            this.readable = cMSReadable;
        }

        @Override // org.bouncycastle.cms.CMSSecureReadable
        public ASN1ObjectIdentifier getContentType() {
            return this.contentType;
        }

        @Override // org.bouncycastle.cms.CMSSecureReadable
        public InputStream getInputStream() throws IOException, CMSException {
            return this.readable.getInputStream();
        }
    }

    CMSEnvelopedHelper() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RecipientInformationStore buildRecipientInformationStore(ASN1Set aSN1Set, AlgorithmIdentifier algorithmIdentifier, CMSSecureReadable cMSSecureReadable) {
        return buildRecipientInformationStore(aSN1Set, algorithmIdentifier, cMSSecureReadable, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RecipientInformationStore buildRecipientInformationStore(ASN1Set aSN1Set, AlgorithmIdentifier algorithmIdentifier, CMSSecureReadable cMSSecureReadable, AuthAttributesProvider authAttributesProvider) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i != aSN1Set.size(); i++) {
            readRecipientInfo(arrayList, RecipientInfo.getInstance(aSN1Set.getObjectAt(i)), algorithmIdentifier, cMSSecureReadable, authAttributesProvider);
        }
        return new RecipientInformationStore(arrayList);
    }

    private static void readRecipientInfo(List list, RecipientInfo recipientInfo, AlgorithmIdentifier algorithmIdentifier, CMSSecureReadable cMSSecureReadable, AuthAttributesProvider authAttributesProvider) {
        Object passwordRecipientInformation;
        ASN1Encodable info2 = recipientInfo.getInfo();
        if (info2 instanceof KeyTransRecipientInfo) {
            passwordRecipientInformation = new KeyTransRecipientInformation((KeyTransRecipientInfo) info2, algorithmIdentifier, cMSSecureReadable, authAttributesProvider);
        } else if (info2 instanceof KEKRecipientInfo) {
            passwordRecipientInformation = new KEKRecipientInformation((KEKRecipientInfo) info2, algorithmIdentifier, cMSSecureReadable, authAttributesProvider);
        } else if (info2 instanceof KeyAgreeRecipientInfo) {
            KeyAgreeRecipientInformation.readRecipientInfo(list, (KeyAgreeRecipientInfo) info2, algorithmIdentifier, cMSSecureReadable, authAttributesProvider);
            return;
        } else if (!(info2 instanceof PasswordRecipientInfo)) {
            return;
        } else {
            passwordRecipientInformation = new PasswordRecipientInformation((PasswordRecipientInfo) info2, algorithmIdentifier, cMSSecureReadable, authAttributesProvider);
        }
        list.add(passwordRecipientInformation);
    }
}
