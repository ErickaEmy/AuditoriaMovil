package org.bouncycastle.tsp.ers;

import java.io.IOException;
import java.util.Date;
import org.bouncycastle.asn1.tsp.ArchiveTimeStamp;
import org.bouncycastle.asn1.tsp.ArchiveTimeStampChain;
import org.bouncycastle.asn1.tsp.EvidenceRecord;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cms.SignerInformationVerifier;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.tsp.TSPException;
/* loaded from: classes2.dex */
public class ERSEvidenceRecord {
    private final DigestCalculatorProvider digestCalculatorProvider;
    private final EvidenceRecord evidenceRecord;
    private final ERSArchiveTimeStamp lastArchiveTimeStamp;

    public ERSEvidenceRecord(EvidenceRecord evidenceRecord, DigestCalculatorProvider digestCalculatorProvider) throws TSPException, ERSException {
        this.evidenceRecord = evidenceRecord;
        this.digestCalculatorProvider = digestCalculatorProvider;
        ArchiveTimeStampChain[] archiveTimeStampChains = evidenceRecord.getArchiveTimeStampSequence().getArchiveTimeStampChains();
        ArchiveTimeStamp[] archiveTimestamps = archiveTimeStampChains[archiveTimeStampChains.length - 1].getArchiveTimestamps();
        this.lastArchiveTimeStamp = new ERSArchiveTimeStamp(archiveTimestamps[archiveTimestamps.length - 1], digestCalculatorProvider);
    }

    public ERSEvidenceRecord(byte[] bArr, DigestCalculatorProvider digestCalculatorProvider) throws TSPException, ERSException {
        this(EvidenceRecord.getInstance(bArr), digestCalculatorProvider);
    }

    public byte[] getEncoded() throws IOException {
        return this.evidenceRecord.getEncoded();
    }

    public ERSArchiveTimeStamp getLastArchiveTimeStamp() {
        return this.lastArchiveTimeStamp;
    }

    public X509CertificateHolder getSigningCertificate() {
        return this.lastArchiveTimeStamp.getSigningCertificate();
    }

    public void validate(SignerInformationVerifier signerInformationVerifier) throws TSPException {
        this.lastArchiveTimeStamp.validate(signerInformationVerifier);
    }

    public void validatePresent(ERSData eRSData, Date date) throws ERSException, OperatorCreationException {
        this.lastArchiveTimeStamp.validatePresent(eRSData, date);
    }

    public void validatePresent(byte[] bArr, Date date) throws ERSException, OperatorCreationException {
        this.lastArchiveTimeStamp.validatePresent(bArr, date);
    }
}
