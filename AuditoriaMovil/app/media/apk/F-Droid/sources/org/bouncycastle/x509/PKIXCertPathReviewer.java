package org.bouncycastle.x509;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXParameters;
import java.security.cert.PolicyNode;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1IA5String;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.x509.AccessDescription;
import org.bouncycastle.asn1.x509.AuthorityInformationAccess;
import org.bouncycastle.asn1.x509.AuthorityKeyIdentifier;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.asn1.x509.CRLDistPoint;
import org.bouncycastle.asn1.x509.DistributionPoint;
import org.bouncycastle.asn1.x509.DistributionPointName;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.GeneralSubtree;
import org.bouncycastle.asn1.x509.NameConstraints;
import org.bouncycastle.asn1.x509.qualified.ETSIQCObjectIdentifiers;
import org.bouncycastle.asn1.x509.qualified.MonetaryValue;
import org.bouncycastle.asn1.x509.qualified.QCStatement;
import org.bouncycastle.asn1.x509.qualified.RFC3739QCObjectIdentifiers;
import org.bouncycastle.i18n.ErrorBundle;
import org.bouncycastle.i18n.filter.TrustedInput;
import org.bouncycastle.i18n.filter.UntrustedInput;
import org.bouncycastle.jce.provider.AnnotatedException;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.provider.PKIXNameConstraintValidator;
import org.bouncycastle.jce.provider.PKIXNameConstraintValidatorException;
import org.bouncycastle.util.Integers;
/* loaded from: classes2.dex */
public class PKIXCertPathReviewer extends CertPathValidatorUtilities {
    private static final String RESOURCE_NAME = "org.bouncycastle.x509.CertPathReviewerMessages";
    protected CertPath certPath;
    protected List certs;
    protected Date currentDate;
    protected List[] errors;
    private boolean initialized;
    protected int n;
    protected List[] notifications;
    protected PKIXParameters pkixParams;
    protected PolicyNode policyTree;
    protected PublicKey subjectPublicKey;
    protected TrustAnchor trustAnchor;
    protected Date validDate;
    private static final String QC_STATEMENT = Extension.qCStatements.getId();
    private static final String CRL_DIST_POINTS = Extension.cRLDistributionPoints.getId();
    private static final String AUTH_INFO_ACCESS = Extension.authorityInfoAccess.getId();

    public PKIXCertPathReviewer() {
    }

    public PKIXCertPathReviewer(CertPath certPath, PKIXParameters pKIXParameters) throws CertPathReviewerException {
        init(certPath, pKIXParameters);
    }

    private String IPtoString(byte[] bArr) {
        try {
            return InetAddress.getByAddress(bArr).getHostAddress();
        } catch (Exception unused) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i != bArr.length; i++) {
                stringBuffer.append(Integer.toHexString(bArr[i] & 255));
                stringBuffer.append(' ');
            }
            return stringBuffer.toString();
        }
    }

    private void checkCriticalExtensions() {
        List<PKIXCertPathChecker> certPathCheckers = this.pkixParams.getCertPathCheckers();
        for (PKIXCertPathChecker pKIXCertPathChecker : certPathCheckers) {
            try {
                try {
                    pKIXCertPathChecker.init(false);
                } catch (CertPathValidatorException e) {
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.certPathCheckerError", new Object[]{e.getMessage(), e, e.getClass().getName()}), e);
                }
            } catch (CertPathReviewerException e2) {
                addError(e2.getErrorMessage(), e2.getIndex());
                return;
            }
        }
        for (int size = this.certs.size() - 1; size >= 0; size--) {
            X509Certificate x509Certificate = (X509Certificate) this.certs.get(size);
            Set<String> criticalExtensionOIDs = x509Certificate.getCriticalExtensionOIDs();
            if (criticalExtensionOIDs != null && !criticalExtensionOIDs.isEmpty()) {
                criticalExtensionOIDs.remove(CertPathValidatorUtilities.KEY_USAGE);
                criticalExtensionOIDs.remove(CertPathValidatorUtilities.CERTIFICATE_POLICIES);
                criticalExtensionOIDs.remove(CertPathValidatorUtilities.POLICY_MAPPINGS);
                criticalExtensionOIDs.remove(CertPathValidatorUtilities.INHIBIT_ANY_POLICY);
                criticalExtensionOIDs.remove(CertPathValidatorUtilities.ISSUING_DISTRIBUTION_POINT);
                criticalExtensionOIDs.remove(CertPathValidatorUtilities.DELTA_CRL_INDICATOR);
                criticalExtensionOIDs.remove(CertPathValidatorUtilities.POLICY_CONSTRAINTS);
                criticalExtensionOIDs.remove(CertPathValidatorUtilities.BASIC_CONSTRAINTS);
                criticalExtensionOIDs.remove(CertPathValidatorUtilities.SUBJECT_ALTERNATIVE_NAME);
                criticalExtensionOIDs.remove(CertPathValidatorUtilities.NAME_CONSTRAINTS);
                if (size == 0) {
                    criticalExtensionOIDs.remove(Extension.extendedKeyUsage.getId());
                }
                String str = QC_STATEMENT;
                if (criticalExtensionOIDs.contains(str) && processQcStatements(x509Certificate, size)) {
                    criticalExtensionOIDs.remove(str);
                }
                for (PKIXCertPathChecker pKIXCertPathChecker2 : certPathCheckers) {
                    try {
                        pKIXCertPathChecker2.check(x509Certificate, criticalExtensionOIDs);
                    } catch (CertPathValidatorException e3) {
                        throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.criticalExtensionError", new Object[]{e3.getMessage(), e3, e3.getClass().getName()}), e3.getCause(), this.certPath, size);
                    }
                }
                if (!criticalExtensionOIDs.isEmpty()) {
                    Iterator<String> it = criticalExtensionOIDs.iterator();
                    while (it.hasNext()) {
                        addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.unknownCriticalExt", new Object[]{new ASN1ObjectIdentifier(it.next())}), size);
                    }
                }
            }
        }
    }

    private void checkNameConstraints() {
        PKIXNameConstraintValidator pKIXNameConstraintValidator = new PKIXNameConstraintValidator();
        try {
            for (int size = this.certs.size() - 1; size > 0; size--) {
                X509Certificate x509Certificate = (X509Certificate) this.certs.get(size);
                if (!CertPathValidatorUtilities.isSelfIssued(x509Certificate)) {
                    X500Principal subjectPrincipal = CertPathValidatorUtilities.getSubjectPrincipal(x509Certificate);
                    try {
                        ASN1Sequence aSN1Sequence = (ASN1Sequence) new ASN1InputStream(new ByteArrayInputStream(subjectPrincipal.getEncoded())).readObject();
                        try {
                            pKIXNameConstraintValidator.checkPermittedDN(aSN1Sequence);
                            try {
                                pKIXNameConstraintValidator.checkExcludedDN(aSN1Sequence);
                                try {
                                    ASN1Sequence aSN1Sequence2 = (ASN1Sequence) CertPathValidatorUtilities.getExtensionValue(x509Certificate, CertPathValidatorUtilities.SUBJECT_ALTERNATIVE_NAME);
                                    if (aSN1Sequence2 != null) {
                                        for (int i = 0; i < aSN1Sequence2.size(); i++) {
                                            GeneralName generalName = GeneralName.getInstance(aSN1Sequence2.getObjectAt(i));
                                            try {
                                                pKIXNameConstraintValidator.checkPermitted(generalName);
                                                pKIXNameConstraintValidator.checkExcluded(generalName);
                                            } catch (PKIXNameConstraintValidatorException e) {
                                                throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.notPermittedEmail", new Object[]{new UntrustedInput(generalName)}), e, this.certPath, size);
                                            }
                                        }
                                    }
                                } catch (AnnotatedException e2) {
                                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.subjAltNameExtError"), e2, this.certPath, size);
                                }
                            } catch (PKIXNameConstraintValidatorException e3) {
                                throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.excludedDN", new Object[]{new UntrustedInput(subjectPrincipal.getName())}), e3, this.certPath, size);
                            }
                        } catch (PKIXNameConstraintValidatorException e4) {
                            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.notPermittedDN", new Object[]{new UntrustedInput(subjectPrincipal.getName())}), e4, this.certPath, size);
                        }
                    } catch (IOException e5) {
                        throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.ncSubjectNameError", new Object[]{new UntrustedInput(subjectPrincipal)}), e5, this.certPath, size);
                    }
                }
                try {
                    ASN1Sequence aSN1Sequence3 = (ASN1Sequence) CertPathValidatorUtilities.getExtensionValue(x509Certificate, CertPathValidatorUtilities.NAME_CONSTRAINTS);
                    if (aSN1Sequence3 != null) {
                        NameConstraints nameConstraints = NameConstraints.getInstance(aSN1Sequence3);
                        GeneralSubtree[] permittedSubtrees = nameConstraints.getPermittedSubtrees();
                        if (permittedSubtrees != null) {
                            pKIXNameConstraintValidator.intersectPermittedSubtree(permittedSubtrees);
                        }
                        GeneralSubtree[] excludedSubtrees = nameConstraints.getExcludedSubtrees();
                        if (excludedSubtrees != null) {
                            for (int i2 = 0; i2 != excludedSubtrees.length; i2++) {
                                pKIXNameConstraintValidator.addExcludedSubtree(excludedSubtrees[i2]);
                            }
                        }
                    }
                } catch (AnnotatedException e6) {
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.ncExtError"), e6, this.certPath, size);
                }
            }
        } catch (CertPathReviewerException e7) {
            addError(e7.getErrorMessage(), e7.getIndex());
        }
    }

    private void checkPathLength() {
        BasicConstraints basicConstraints;
        BigInteger pathLenConstraint;
        int intValue;
        int i = this.n;
        int i2 = 0;
        for (int size = this.certs.size() - 1; size > 0; size--) {
            X509Certificate x509Certificate = (X509Certificate) this.certs.get(size);
            if (!CertPathValidatorUtilities.isSelfIssued(x509Certificate)) {
                if (i <= 0) {
                    addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.pathLengthExtended"));
                }
                i--;
                i2++;
            }
            try {
                basicConstraints = BasicConstraints.getInstance(CertPathValidatorUtilities.getExtensionValue(x509Certificate, CertPathValidatorUtilities.BASIC_CONSTRAINTS));
            } catch (AnnotatedException unused) {
                addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.processLengthConstError"), size);
                basicConstraints = null;
            }
            if (basicConstraints != null && (pathLenConstraint = basicConstraints.getPathLenConstraint()) != null && (intValue = pathLenConstraint.intValue()) < i) {
                i = intValue;
            }
        }
        addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.totalPathLength", new Object[]{Integers.valueOf(i2)}));
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x0242 A[Catch: CertPathReviewerException -> 0x00e0, TryCatch #8 {CertPathReviewerException -> 0x00e0, blocks: (B:17:0x006f, B:21:0x007f, B:23:0x008c, B:27:0x009c, B:28:0x00a7, B:30:0x00ad, B:32:0x00ce, B:33:0x00d6, B:35:0x00dc, B:39:0x00e4, B:40:0x00f0, B:44:0x00fc, B:47:0x0103, B:48:0x010c, B:50:0x0112, B:52:0x011c, B:55:0x0123, B:57:0x0127, B:97:0x0213, B:99:0x0219, B:100:0x021c, B:102:0x0222, B:104:0x022e, B:107:0x0236, B:108:0x0239, B:109:0x023c, B:111:0x0242, B:112:0x024b, B:114:0x0251, B:122:0x0274, B:123:0x0280, B:124:0x0281, B:126:0x0285, B:128:0x028d, B:129:0x0291, B:131:0x0297, B:134:0x02b9, B:136:0x02c3, B:137:0x02c8, B:138:0x02d4, B:139:0x02d5, B:140:0x02e1, B:142:0x02e4, B:143:0x02f1, B:145:0x02f7, B:147:0x031d, B:149:0x0335, B:148:0x032c, B:150:0x033c, B:151:0x0342, B:153:0x0348, B:155:0x0350, B:166:0x037a, B:159:0x0358, B:160:0x0364, B:162:0x0366, B:163:0x0375, B:170:0x0388, B:181:0x03a5, B:183:0x03af, B:184:0x03b3, B:186:0x03b9, B:191:0x03c9, B:194:0x03d6, B:197:0x03e3, B:199:0x03ed, B:210:0x042b, B:202:0x03f5, B:203:0x0403, B:204:0x0404, B:205:0x0412, B:207:0x0414, B:208:0x0422, B:61:0x0136, B:62:0x013a, B:64:0x0140, B:66:0x0156, B:68:0x0160, B:69:0x0165, B:71:0x016b, B:72:0x0179, B:74:0x017f, B:76:0x018b, B:80:0x0198, B:81:0x019e, B:83:0x01a4, B:88:0x01bd, B:77:0x018e, B:79:0x0192, B:92:0x01f6, B:95:0x0206, B:96:0x0212, B:212:0x043a, B:213:0x0447, B:214:0x0448, B:218:0x0459, B:220:0x0463, B:221:0x0468, B:223:0x046e, B:226:0x047c, B:233:0x0491, B:310:0x05e1, B:311:0x05ed, B:236:0x049c, B:237:0x04a8, B:238:0x04a9, B:240:0x04af, B:242:0x04b7, B:244:0x04bd, B:246:0x04c7, B:247:0x04ca, B:249:0x04d0, B:251:0x04e0, B:252:0x04e4, B:254:0x04ea, B:255:0x04f2, B:256:0x04f5, B:257:0x04f8, B:258:0x04fc, B:260:0x0502, B:261:0x0510, B:263:0x0518, B:264:0x051b, B:266:0x0521, B:268:0x052d, B:269:0x0531, B:270:0x0534, B:271:0x0537, B:272:0x0543, B:274:0x0548, B:276:0x0552, B:277:0x0555, B:279:0x055b, B:281:0x056b, B:282:0x056f, B:284:0x0575, B:286:0x0585, B:287:0x0589, B:288:0x058c, B:289:0x058f, B:290:0x0595, B:292:0x059b, B:294:0x05ad, B:297:0x05b7, B:299:0x05bd, B:300:0x05c0, B:302:0x05c6, B:304:0x05d2, B:305:0x05d6, B:306:0x05d9, B:312:0x05ee, B:313:0x05fa), top: B:328:0x006f, inners: #0, #1, #2, #3, #4, #6, #9, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0123 A[Catch: CertPathReviewerException -> 0x00e0, TryCatch #8 {CertPathReviewerException -> 0x00e0, blocks: (B:17:0x006f, B:21:0x007f, B:23:0x008c, B:27:0x009c, B:28:0x00a7, B:30:0x00ad, B:32:0x00ce, B:33:0x00d6, B:35:0x00dc, B:39:0x00e4, B:40:0x00f0, B:44:0x00fc, B:47:0x0103, B:48:0x010c, B:50:0x0112, B:52:0x011c, B:55:0x0123, B:57:0x0127, B:97:0x0213, B:99:0x0219, B:100:0x021c, B:102:0x0222, B:104:0x022e, B:107:0x0236, B:108:0x0239, B:109:0x023c, B:111:0x0242, B:112:0x024b, B:114:0x0251, B:122:0x0274, B:123:0x0280, B:124:0x0281, B:126:0x0285, B:128:0x028d, B:129:0x0291, B:131:0x0297, B:134:0x02b9, B:136:0x02c3, B:137:0x02c8, B:138:0x02d4, B:139:0x02d5, B:140:0x02e1, B:142:0x02e4, B:143:0x02f1, B:145:0x02f7, B:147:0x031d, B:149:0x0335, B:148:0x032c, B:150:0x033c, B:151:0x0342, B:153:0x0348, B:155:0x0350, B:166:0x037a, B:159:0x0358, B:160:0x0364, B:162:0x0366, B:163:0x0375, B:170:0x0388, B:181:0x03a5, B:183:0x03af, B:184:0x03b3, B:186:0x03b9, B:191:0x03c9, B:194:0x03d6, B:197:0x03e3, B:199:0x03ed, B:210:0x042b, B:202:0x03f5, B:203:0x0403, B:204:0x0404, B:205:0x0412, B:207:0x0414, B:208:0x0422, B:61:0x0136, B:62:0x013a, B:64:0x0140, B:66:0x0156, B:68:0x0160, B:69:0x0165, B:71:0x016b, B:72:0x0179, B:74:0x017f, B:76:0x018b, B:80:0x0198, B:81:0x019e, B:83:0x01a4, B:88:0x01bd, B:77:0x018e, B:79:0x0192, B:92:0x01f6, B:95:0x0206, B:96:0x0212, B:212:0x043a, B:213:0x0447, B:214:0x0448, B:218:0x0459, B:220:0x0463, B:221:0x0468, B:223:0x046e, B:226:0x047c, B:233:0x0491, B:310:0x05e1, B:311:0x05ed, B:236:0x049c, B:237:0x04a8, B:238:0x04a9, B:240:0x04af, B:242:0x04b7, B:244:0x04bd, B:246:0x04c7, B:247:0x04ca, B:249:0x04d0, B:251:0x04e0, B:252:0x04e4, B:254:0x04ea, B:255:0x04f2, B:256:0x04f5, B:257:0x04f8, B:258:0x04fc, B:260:0x0502, B:261:0x0510, B:263:0x0518, B:264:0x051b, B:266:0x0521, B:268:0x052d, B:269:0x0531, B:270:0x0534, B:271:0x0537, B:272:0x0543, B:274:0x0548, B:276:0x0552, B:277:0x0555, B:279:0x055b, B:281:0x056b, B:282:0x056f, B:284:0x0575, B:286:0x0585, B:287:0x0589, B:288:0x058c, B:289:0x058f, B:290:0x0595, B:292:0x059b, B:294:0x05ad, B:297:0x05b7, B:299:0x05bd, B:300:0x05c0, B:302:0x05c6, B:304:0x05d2, B:305:0x05d6, B:306:0x05d9, B:312:0x05ee, B:313:0x05fa), top: B:328:0x006f, inners: #0, #1, #2, #3, #4, #6, #9, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0140 A[Catch: CertPathReviewerException -> 0x00e0, TRY_LEAVE, TryCatch #8 {CertPathReviewerException -> 0x00e0, blocks: (B:17:0x006f, B:21:0x007f, B:23:0x008c, B:27:0x009c, B:28:0x00a7, B:30:0x00ad, B:32:0x00ce, B:33:0x00d6, B:35:0x00dc, B:39:0x00e4, B:40:0x00f0, B:44:0x00fc, B:47:0x0103, B:48:0x010c, B:50:0x0112, B:52:0x011c, B:55:0x0123, B:57:0x0127, B:97:0x0213, B:99:0x0219, B:100:0x021c, B:102:0x0222, B:104:0x022e, B:107:0x0236, B:108:0x0239, B:109:0x023c, B:111:0x0242, B:112:0x024b, B:114:0x0251, B:122:0x0274, B:123:0x0280, B:124:0x0281, B:126:0x0285, B:128:0x028d, B:129:0x0291, B:131:0x0297, B:134:0x02b9, B:136:0x02c3, B:137:0x02c8, B:138:0x02d4, B:139:0x02d5, B:140:0x02e1, B:142:0x02e4, B:143:0x02f1, B:145:0x02f7, B:147:0x031d, B:149:0x0335, B:148:0x032c, B:150:0x033c, B:151:0x0342, B:153:0x0348, B:155:0x0350, B:166:0x037a, B:159:0x0358, B:160:0x0364, B:162:0x0366, B:163:0x0375, B:170:0x0388, B:181:0x03a5, B:183:0x03af, B:184:0x03b3, B:186:0x03b9, B:191:0x03c9, B:194:0x03d6, B:197:0x03e3, B:199:0x03ed, B:210:0x042b, B:202:0x03f5, B:203:0x0403, B:204:0x0404, B:205:0x0412, B:207:0x0414, B:208:0x0422, B:61:0x0136, B:62:0x013a, B:64:0x0140, B:66:0x0156, B:68:0x0160, B:69:0x0165, B:71:0x016b, B:72:0x0179, B:74:0x017f, B:76:0x018b, B:80:0x0198, B:81:0x019e, B:83:0x01a4, B:88:0x01bd, B:77:0x018e, B:79:0x0192, B:92:0x01f6, B:95:0x0206, B:96:0x0212, B:212:0x043a, B:213:0x0447, B:214:0x0448, B:218:0x0459, B:220:0x0463, B:221:0x0468, B:223:0x046e, B:226:0x047c, B:233:0x0491, B:310:0x05e1, B:311:0x05ed, B:236:0x049c, B:237:0x04a8, B:238:0x04a9, B:240:0x04af, B:242:0x04b7, B:244:0x04bd, B:246:0x04c7, B:247:0x04ca, B:249:0x04d0, B:251:0x04e0, B:252:0x04e4, B:254:0x04ea, B:255:0x04f2, B:256:0x04f5, B:257:0x04f8, B:258:0x04fc, B:260:0x0502, B:261:0x0510, B:263:0x0518, B:264:0x051b, B:266:0x0521, B:268:0x052d, B:269:0x0531, B:270:0x0534, B:271:0x0537, B:272:0x0543, B:274:0x0548, B:276:0x0552, B:277:0x0555, B:279:0x055b, B:281:0x056b, B:282:0x056f, B:284:0x0575, B:286:0x0585, B:287:0x0589, B:288:0x058c, B:289:0x058f, B:290:0x0595, B:292:0x059b, B:294:0x05ad, B:297:0x05b7, B:299:0x05bd, B:300:0x05c0, B:302:0x05c6, B:304:0x05d2, B:305:0x05d6, B:306:0x05d9, B:312:0x05ee, B:313:0x05fa), top: B:328:0x006f, inners: #0, #1, #2, #3, #4, #6, #9, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0219 A[Catch: CertPathReviewerException -> 0x00e0, TryCatch #8 {CertPathReviewerException -> 0x00e0, blocks: (B:17:0x006f, B:21:0x007f, B:23:0x008c, B:27:0x009c, B:28:0x00a7, B:30:0x00ad, B:32:0x00ce, B:33:0x00d6, B:35:0x00dc, B:39:0x00e4, B:40:0x00f0, B:44:0x00fc, B:47:0x0103, B:48:0x010c, B:50:0x0112, B:52:0x011c, B:55:0x0123, B:57:0x0127, B:97:0x0213, B:99:0x0219, B:100:0x021c, B:102:0x0222, B:104:0x022e, B:107:0x0236, B:108:0x0239, B:109:0x023c, B:111:0x0242, B:112:0x024b, B:114:0x0251, B:122:0x0274, B:123:0x0280, B:124:0x0281, B:126:0x0285, B:128:0x028d, B:129:0x0291, B:131:0x0297, B:134:0x02b9, B:136:0x02c3, B:137:0x02c8, B:138:0x02d4, B:139:0x02d5, B:140:0x02e1, B:142:0x02e4, B:143:0x02f1, B:145:0x02f7, B:147:0x031d, B:149:0x0335, B:148:0x032c, B:150:0x033c, B:151:0x0342, B:153:0x0348, B:155:0x0350, B:166:0x037a, B:159:0x0358, B:160:0x0364, B:162:0x0366, B:163:0x0375, B:170:0x0388, B:181:0x03a5, B:183:0x03af, B:184:0x03b3, B:186:0x03b9, B:191:0x03c9, B:194:0x03d6, B:197:0x03e3, B:199:0x03ed, B:210:0x042b, B:202:0x03f5, B:203:0x0403, B:204:0x0404, B:205:0x0412, B:207:0x0414, B:208:0x0422, B:61:0x0136, B:62:0x013a, B:64:0x0140, B:66:0x0156, B:68:0x0160, B:69:0x0165, B:71:0x016b, B:72:0x0179, B:74:0x017f, B:76:0x018b, B:80:0x0198, B:81:0x019e, B:83:0x01a4, B:88:0x01bd, B:77:0x018e, B:79:0x0192, B:92:0x01f6, B:95:0x0206, B:96:0x0212, B:212:0x043a, B:213:0x0447, B:214:0x0448, B:218:0x0459, B:220:0x0463, B:221:0x0468, B:223:0x046e, B:226:0x047c, B:233:0x0491, B:310:0x05e1, B:311:0x05ed, B:236:0x049c, B:237:0x04a8, B:238:0x04a9, B:240:0x04af, B:242:0x04b7, B:244:0x04bd, B:246:0x04c7, B:247:0x04ca, B:249:0x04d0, B:251:0x04e0, B:252:0x04e4, B:254:0x04ea, B:255:0x04f2, B:256:0x04f5, B:257:0x04f8, B:258:0x04fc, B:260:0x0502, B:261:0x0510, B:263:0x0518, B:264:0x051b, B:266:0x0521, B:268:0x052d, B:269:0x0531, B:270:0x0534, B:271:0x0537, B:272:0x0543, B:274:0x0548, B:276:0x0552, B:277:0x0555, B:279:0x055b, B:281:0x056b, B:282:0x056f, B:284:0x0575, B:286:0x0585, B:287:0x0589, B:288:0x058c, B:289:0x058f, B:290:0x0595, B:292:0x059b, B:294:0x05ad, B:297:0x05b7, B:299:0x05bd, B:300:0x05c0, B:302:0x05c6, B:304:0x05d2, B:305:0x05d6, B:306:0x05d9, B:312:0x05ee, B:313:0x05fa), top: B:328:0x006f, inners: #0, #1, #2, #3, #4, #6, #9, #10 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void checkPolicy() {
        /*
            Method dump skipped, instructions count: 1543
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.x509.PKIXCertPathReviewer.checkPolicy():void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:(2:92|93)|(3:(15:95|96|97|(11:99|100|(2:103|101)|104|105|(2:108|106)|109|110|111|112|113)|120|100|(1:101)|104|105|(1:106)|109|110|111|112|113)|112|113)|123|96|97|(0)|120|100|(1:101)|104|105|(1:106)|109|110|111) */
    /* JADX WARN: Can't wrap try/catch for region: R(18:92|93|(15:95|96|97|(11:99|100|(2:103|101)|104|105|(2:108|106)|109|110|111|112|113)|120|100|(1:101)|104|105|(1:106)|109|110|111|112|113)|123|96|97|(0)|120|100|(1:101)|104|105|(1:106)|109|110|111|112|113) */
    /* JADX WARN: Can't wrap try/catch for region: R(19:31|(2:138|139)(2:33|(2:131|132)(20:35|(2:39|(17:41|42|43|44|45|(18:92|93|(15:95|96|97|(11:99|100|(2:103|101)|104|105|(2:108|106)|109|110|111|112|113)|120|100|(1:101)|104|105|(1:106)|109|110|111|112|113)|123|96|97|(0)|120|100|(1:101)|104|105|(1:106)|109|110|111|112|113)(1:47)|(1:91)(1:51)|52|(7:54|(2:56|(1:58))(1:89)|59|60|(2:62|(1:64))(1:86)|65|(9:67|(1:84)|71|72|73|75|76|78|79))(1:90)|85|71|72|73|75|76|78|79))|130|42|43|44|45|(0)(0)|(1:49)|91|52|(0)(0)|85|71|72|73|75|76|78|79))|133|43|44|45|(0)(0)|(0)|91|52|(0)(0)|85|71|72|73|75|76|78|79) */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0325, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0326, code lost:
        r13 = r3;
        r15 = r4;
        r11 = r5;
        r16 = r6;
        r12 = r7;
        r18 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x03e7, code lost:
        r6 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x03e9, code lost:
        addError(new org.bouncycastle.i18n.ErrorBundle(org.bouncycastle.x509.PKIXCertPathReviewer.RESOURCE_NAME, "CertPathReviewer.pubKeyError"), r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0258, code lost:
        r1 = new java.lang.Object[r13];
        r1[r12] = new org.bouncycastle.i18n.filter.TrustedInput(r3.getNotAfter());
        r0 = new org.bouncycastle.i18n.ErrorBundle(org.bouncycastle.x509.PKIXCertPathReviewer.RESOURCE_NAME, "CertPathReviewer.certificateExpired", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x026c, code lost:
        addError(r0, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0270, code lost:
        r1 = new java.lang.Object[r13];
        r1[r12] = new org.bouncycastle.i18n.filter.TrustedInput(r3.getNotBefore());
        r0 = new org.bouncycastle.i18n.ErrorBundle(org.bouncycastle.x509.PKIXCertPathReviewer.RESOURCE_NAME, "CertPathReviewer.certificateNotYetValid", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x02b2, code lost:
        addError(new org.bouncycastle.i18n.ErrorBundle(org.bouncycastle.x509.PKIXCertPathReviewer.RESOURCE_NAME, "CertPathReviewer.crlAuthInfoAccError"), r5);
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x02cf A[LOOP:1: B:99:0x02c9->B:101:0x02cf, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02f3 A[LOOP:2: B:103:0x02ed->B:105:0x02f3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x028d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02ad A[Catch: AnnotatedException -> 0x02b2, TRY_LEAVE, TryCatch #17 {AnnotatedException -> 0x02b2, blocks: (B:92:0x02a5, B:94:0x02ad), top: B:180:0x02a5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void checkSignatures() {
        /*
            Method dump skipped, instructions count: 1034
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.x509.PKIXCertPathReviewer.checkSignatures():void");
    }

    private X509CRL getCRL(String str) throws CertPathReviewerException {
        try {
            URL url = new URL(str);
            if (!url.getProtocol().equals("http") && !url.getProtocol().equals("https")) {
                return null;
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                return (X509CRL) CertificateFactory.getInstance("X.509", BouncyCastleProvider.PROVIDER_NAME).generateCRL(httpURLConnection.getInputStream());
            }
            throw new Exception(httpURLConnection.getResponseMessage());
        } catch (Exception e) {
            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.loadCrlDistPointError", new Object[]{new UntrustedInput(str), e.getMessage(), e, e.getClass().getName()}));
        }
    }

    private boolean processQcStatements(X509Certificate x509Certificate, int i) {
        ErrorBundle errorBundle;
        try {
            ASN1Sequence aSN1Sequence = (ASN1Sequence) CertPathValidatorUtilities.getExtensionValue(x509Certificate, QC_STATEMENT);
            boolean z = false;
            for (int i2 = 0; i2 < aSN1Sequence.size(); i2++) {
                QCStatement qCStatement = QCStatement.getInstance(aSN1Sequence.getObjectAt(i2));
                if (ETSIQCObjectIdentifiers.id_etsi_qcs_QcCompliance.equals((ASN1Primitive) qCStatement.getStatementId())) {
                    errorBundle = new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcEuCompliance");
                } else {
                    if (!RFC3739QCObjectIdentifiers.id_qcs_pkixQCSyntax_v1.equals((ASN1Primitive) qCStatement.getStatementId())) {
                        if (ETSIQCObjectIdentifiers.id_etsi_qcs_QcSSCD.equals((ASN1Primitive) qCStatement.getStatementId())) {
                            errorBundle = new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcSSCD");
                        } else if (ETSIQCObjectIdentifiers.id_etsi_qcs_LimiteValue.equals((ASN1Primitive) qCStatement.getStatementId())) {
                            MonetaryValue monetaryValue = MonetaryValue.getInstance(qCStatement.getStatementInfo());
                            monetaryValue.getCurrency();
                            double doubleValue = monetaryValue.getAmount().doubleValue() * Math.pow(10.0d, monetaryValue.getExponent().doubleValue());
                            addNotification(monetaryValue.getCurrency().isAlphabetic() ? new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcLimitValueAlpha", new Object[]{monetaryValue.getCurrency().getAlphabetic(), new TrustedInput(new Double(doubleValue)), monetaryValue}) : new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcLimitValueNum", new Object[]{Integers.valueOf(monetaryValue.getCurrency().getNumeric()), new TrustedInput(new Double(doubleValue)), monetaryValue}), i);
                        } else {
                            addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcUnknownStatement", new Object[]{qCStatement.getStatementId(), new UntrustedInput(qCStatement)}), i);
                            z = true;
                        }
                    }
                }
                addNotification(errorBundle, i);
            }
            return !z;
        } catch (AnnotatedException unused) {
            addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcStatementExtError"), i);
            return false;
        }
    }

    protected void addError(ErrorBundle errorBundle) {
        this.errors[0].add(errorBundle);
    }

    protected void addError(ErrorBundle errorBundle, int i) {
        if (i < -1 || i >= this.n) {
            throw new IndexOutOfBoundsException();
        }
        this.errors[i + 1].add(errorBundle);
    }

    protected void addNotification(ErrorBundle errorBundle) {
        this.notifications[0].add(errorBundle);
    }

    protected void addNotification(ErrorBundle errorBundle, int i) {
        if (i < -1 || i >= this.n) {
            throw new IndexOutOfBoundsException();
        }
        this.notifications[i + 1].add(errorBundle);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:42:0x016c
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    protected void checkCRLs(java.security.cert.PKIXParameters r21, java.security.cert.X509Certificate r22, java.util.Date r23, java.security.cert.X509Certificate r24, java.security.PublicKey r25, java.util.Vector r26, int r27) throws org.bouncycastle.x509.CertPathReviewerException {
        /*
            Method dump skipped, instructions count: 1059
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.x509.PKIXCertPathReviewer.checkCRLs(java.security.cert.PKIXParameters, java.security.cert.X509Certificate, java.util.Date, java.security.cert.X509Certificate, java.security.PublicKey, java.util.Vector, int):void");
    }

    protected void checkRevocation(PKIXParameters pKIXParameters, X509Certificate x509Certificate, Date date, X509Certificate x509Certificate2, PublicKey publicKey, Vector vector, Vector vector2, int i) throws CertPathReviewerException {
        checkCRLs(pKIXParameters, x509Certificate, date, x509Certificate2, publicKey, vector, i);
    }

    protected void doChecks() {
        if (!this.initialized) {
            throw new IllegalStateException("Object not initialized. Call init() first.");
        }
        if (this.notifications != null) {
            return;
        }
        int i = this.n;
        this.notifications = new List[i + 1];
        this.errors = new List[i + 1];
        int i2 = 0;
        while (true) {
            List[] listArr = this.notifications;
            if (i2 >= listArr.length) {
                checkSignatures();
                checkNameConstraints();
                checkPathLength();
                checkPolicy();
                checkCriticalExtensions();
                return;
            }
            listArr[i2] = new ArrayList();
            this.errors[i2] = new ArrayList();
            i2++;
        }
    }

    protected Vector getCRLDistUrls(CRLDistPoint cRLDistPoint) {
        Vector vector = new Vector();
        if (cRLDistPoint != null) {
            for (DistributionPoint distributionPoint : cRLDistPoint.getDistributionPoints()) {
                DistributionPointName distributionPoint2 = distributionPoint.getDistributionPoint();
                if (distributionPoint2.getType() == 0) {
                    GeneralName[] names = GeneralNames.getInstance(distributionPoint2.getName()).getNames();
                    for (int i = 0; i < names.length; i++) {
                        if (names[i].getTagNo() == 6) {
                            vector.add(((ASN1IA5String) names[i].getName()).getString());
                        }
                    }
                }
            }
        }
        return vector;
    }

    public CertPath getCertPath() {
        return this.certPath;
    }

    public int getCertPathSize() {
        return this.n;
    }

    public List getErrors(int i) {
        doChecks();
        return this.errors[i + 1];
    }

    public List[] getErrors() {
        doChecks();
        return this.errors;
    }

    public List getNotifications(int i) {
        doChecks();
        return this.notifications[i + 1];
    }

    public List[] getNotifications() {
        doChecks();
        return this.notifications;
    }

    protected Vector getOCSPUrls(AuthorityInformationAccess authorityInformationAccess) {
        Vector vector = new Vector();
        if (authorityInformationAccess != null) {
            AccessDescription[] accessDescriptions = authorityInformationAccess.getAccessDescriptions();
            for (int i = 0; i < accessDescriptions.length; i++) {
                if (accessDescriptions[i].getAccessMethod().equals((ASN1Primitive) AccessDescription.id_ad_ocsp)) {
                    GeneralName accessLocation = accessDescriptions[i].getAccessLocation();
                    if (accessLocation.getTagNo() == 6) {
                        vector.add(((ASN1IA5String) accessLocation.getName()).getString());
                    }
                }
            }
        }
        return vector;
    }

    public PolicyNode getPolicyTree() {
        doChecks();
        return this.policyTree;
    }

    public PublicKey getSubjectPublicKey() {
        doChecks();
        return this.subjectPublicKey;
    }

    public TrustAnchor getTrustAnchor() {
        doChecks();
        return this.trustAnchor;
    }

    protected Collection getTrustAnchors(X509Certificate x509Certificate, Set set) throws CertPathReviewerException {
        ArrayList arrayList = new ArrayList();
        Iterator it = set.iterator();
        X509CertSelector x509CertSelector = new X509CertSelector();
        try {
            x509CertSelector.setSubject(CertPathValidatorUtilities.getEncodedIssuerPrincipal(x509Certificate).getEncoded());
            byte[] extensionValue = x509Certificate.getExtensionValue(Extension.authorityKeyIdentifier.getId());
            if (extensionValue != null) {
                AuthorityKeyIdentifier authorityKeyIdentifier = AuthorityKeyIdentifier.getInstance(ASN1Primitive.fromByteArray(((ASN1OctetString) ASN1Primitive.fromByteArray(extensionValue)).getOctets()));
                if (authorityKeyIdentifier.getAuthorityCertSerialNumber() != null) {
                    x509CertSelector.setSerialNumber(authorityKeyIdentifier.getAuthorityCertSerialNumber());
                } else {
                    byte[] keyIdentifier = authorityKeyIdentifier.getKeyIdentifier();
                    if (keyIdentifier != null) {
                        x509CertSelector.setSubjectKeyIdentifier(new DEROctetString(keyIdentifier).getEncoded());
                    }
                }
            }
            while (it.hasNext()) {
                TrustAnchor trustAnchor = (TrustAnchor) it.next();
                if (trustAnchor.getTrustedCert() != null) {
                    if (x509CertSelector.match(trustAnchor.getTrustedCert())) {
                        arrayList.add(trustAnchor);
                    }
                } else if (trustAnchor.getCAName() != null && trustAnchor.getCAPublicKey() != null && CertPathValidatorUtilities.getEncodedIssuerPrincipal(x509Certificate).equals(new X500Principal(trustAnchor.getCAName()))) {
                    arrayList.add(trustAnchor);
                }
            }
            return arrayList;
        } catch (IOException unused) {
            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.trustAnchorIssuerError"));
        }
    }

    public void init(CertPath certPath, PKIXParameters pKIXParameters) throws CertPathReviewerException {
        if (this.initialized) {
            throw new IllegalStateException("object is already initialized!");
        }
        this.initialized = true;
        if (certPath == null) {
            throw new NullPointerException("certPath was null");
        }
        this.certPath = certPath;
        List<? extends Certificate> certificates = certPath.getCertificates();
        this.certs = certificates;
        this.n = certificates.size();
        if (this.certs.isEmpty()) {
            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.emptyCertPath"));
        }
        this.pkixParams = (PKIXParameters) pKIXParameters.clone();
        Date date = new Date();
        this.currentDate = date;
        this.validDate = CertPathValidatorUtilities.getValidityDate(this.pkixParams, date);
        this.notifications = null;
        this.errors = null;
        this.trustAnchor = null;
        this.subjectPublicKey = null;
        this.policyTree = null;
    }

    public boolean isValidCertPath() {
        doChecks();
        int i = 0;
        while (true) {
            List[] listArr = this.errors;
            if (i >= listArr.length) {
                return true;
            }
            if (!listArr[i].isEmpty()) {
                return false;
            }
            i++;
        }
    }
}
