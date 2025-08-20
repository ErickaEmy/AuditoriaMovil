package javax.jmdns.impl.tasks.state;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.jmdns.ServiceInfo;
import javax.jmdns.impl.DNSOutgoing;
import javax.jmdns.impl.DNSStatefulObject;
import javax.jmdns.impl.JmDNSImpl;
import javax.jmdns.impl.ServiceInfoImpl;
import javax.jmdns.impl.constants.DNSConstants;
import javax.jmdns.impl.constants.DNSState;
import javax.jmdns.impl.tasks.DNSTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/* loaded from: classes.dex */
public abstract class DNSStateTask extends DNSTask {
    private DNSState _taskState;
    private final int _ttl;
    static Logger logger = LoggerFactory.getLogger(DNSStateTask.class.getName());
    private static int _defaultTTL = DNSConstants.DNS_TTL;

    public static int defaultTTL() {
        return _defaultTTL;
    }

    protected abstract void advanceTask();

    protected abstract DNSOutgoing buildOutgoingForDNS(DNSOutgoing dNSOutgoing);

    protected abstract DNSOutgoing buildOutgoingForInfo(ServiceInfoImpl serviceInfoImpl, DNSOutgoing dNSOutgoing);

    protected abstract boolean checkRunCondition();

    protected abstract DNSOutgoing createOugoing();

    public int getTTL() {
        return this._ttl;
    }

    public abstract String getTaskDescription();

    /* JADX INFO: Access modifiers changed from: protected */
    public DNSState getTaskState() {
        return this._taskState;
    }

    protected abstract void recoverTask(Throwable th);

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTaskState(DNSState dNSState) {
        this._taskState = dNSState;
    }

    public DNSStateTask(JmDNSImpl jmDNSImpl, int i) {
        super(jmDNSImpl);
        this._taskState = null;
        this._ttl = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void associate(DNSState dNSState) {
        synchronized (getDns()) {
            getDns().associateWithTask(this, dNSState);
        }
        for (ServiceInfo serviceInfo : getDns().getServices().values()) {
            ((ServiceInfoImpl) serviceInfo).associateWithTask(this, dNSState);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void removeAssociation() {
        synchronized (getDns()) {
            getDns().removeAssociationWithTask(this);
        }
        for (ServiceInfo serviceInfo : getDns().getServices().values()) {
            ((ServiceInfoImpl) serviceInfo).removeAssociationWithTask(this);
        }
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        DNSOutgoing createOugoing = createOugoing();
        try {
        } catch (Throwable th) {
            Logger logger2 = logger;
            logger2.warn(getName() + ".run() exception ", th);
            recoverTask(th);
        }
        if (!checkRunCondition()) {
            cancel();
            return;
        }
        ArrayList arrayList = new ArrayList();
        synchronized (getDns()) {
            if (getDns().isAssociatedWithTask(this, getTaskState())) {
                logger.debug("{}.run() JmDNS {} {}", getName(), getTaskDescription(), getDns().getName());
                arrayList.add(getDns());
                createOugoing = buildOutgoingForDNS(createOugoing);
            }
        }
        for (ServiceInfo serviceInfo : getDns().getServices().values()) {
            ServiceInfoImpl serviceInfoImpl = (ServiceInfoImpl) serviceInfo;
            synchronized (serviceInfoImpl) {
                if (serviceInfoImpl.isAssociatedWithTask(this, getTaskState())) {
                    logger.debug("{}.run() JmDNS {} {}", getName(), getTaskDescription(), serviceInfoImpl.getQualifiedName());
                    arrayList.add(serviceInfoImpl);
                    createOugoing = buildOutgoingForInfo(serviceInfoImpl, createOugoing);
                }
            }
        }
        if (!createOugoing.isEmpty()) {
            logger.debug("{}.run() JmDNS {} #{}", getName(), getTaskDescription(), getTaskState());
            getDns().send(createOugoing);
            advanceObjectsState(arrayList);
            advanceTask();
            return;
        }
        advanceObjectsState(arrayList);
        cancel();
    }

    protected void advanceObjectsState(List list) {
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                DNSStatefulObject dNSStatefulObject = (DNSStatefulObject) it.next();
                synchronized (dNSStatefulObject) {
                    dNSStatefulObject.advanceState(this);
                }
            }
        }
    }
}
