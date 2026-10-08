package com.google.android.gms.nearby.internal.connection;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import androidx.collection.ArraySet;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.nearby.zzxb;
import com.google.android.gms.internal.nearby.zzxd;
import com.google.android.gms.internal.nearby.zzyg;
import com.google.android.gms.nearby.connection.ConnectionsOptions;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.nearby.connection.Payload;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaw extends GmsClient {
    public static final /* synthetic */ int zze = 0;
    private long zzf;
    private final Set zzg;
    private final Set zzh;
    private final Set zzi;
    private final Set zzj;
    private final Set zzk;
    private final Set zzl;
    private zzgc zzm;

    protected zzaw(Context context, Looper looper, ClientSettings clientSettings, ConnectionsOptions connectionsOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 54, clientSettings, (ConnectionCallbacks) connectionCallbacks, (OnConnectionFailedListener) onConnectionFailedListener);
        this.zzg = new ArraySet();
        this.zzh = new ArraySet();
        this.zzi = new ArraySet();
        this.zzj = new ArraySet();
        this.zzk = new ArraySet();
        this.zzl = new ArraySet();
        zzgy.zzb(context.getCacheDir());
    }

    private final void zzJ() {
        Set set = this.zzg;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((zzaf) it.next()).zze();
        }
        Set set2 = this.zzh;
        Iterator it2 = set2.iterator();
        while (it2.hasNext()) {
            ((zzaa) it2.next()).zza();
        }
        Set set3 = this.zzi;
        Iterator it3 = set3.iterator();
        while (it3.hasNext()) {
            ((zzaj) it3.next()).zzg();
        }
        Set set4 = this.zzj;
        Iterator it4 = set4.iterator();
        while (it4.hasNext()) {
            ((zzaj) it4.next()).zzg();
        }
        Set set5 = this.zzk;
        Iterator it5 = set5.iterator();
        while (it5.hasNext()) {
            ((zzaj) it5.next()).zzg();
        }
        Set set6 = this.zzl;
        Iterator it6 = set6.iterator();
        while (it6.hasNext()) {
            ((zzaj) it6.next()).zzg();
        }
        set.clear();
        set2.clear();
        set3.clear();
        set4.clear();
        set5.clear();
        set6.clear();
        zzgc zzgcVar = this.zzm;
        if (zzgcVar != null) {
            zzgcVar.zzc();
            this.zzm = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Status zzK(int i) {
        return new Status(i, ConnectionsStatusCodes.getStatusCodeString(i));
    }

    public static zzaw zzu(Context context, Looper looper, ClientSettings clientSettings, ConnectionsOptions connectionsOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzaw zzawVar = new zzaw(context, looper, clientSettings, connectionsOptions, connectionCallbacks, onConnectionFailedListener);
        zzawVar.zzf = zzawVar.hashCode();
        return zzawVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
        return iInterfaceQueryLocalInterface instanceof zzee ? (zzee) iInterfaceQueryLocalInterface : new zzee(iBinder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final void disconnect() {
        if (isConnected()) {
            try {
                ((zzee) getService()).zzn(new zzj());
            } catch (RemoteException e) {
                Log.w("NearbyConnectionsClient", "Failed to notify client disconnect.", e);
            }
        }
        zzJ();
        super.disconnect();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Feature[] getApiFeatures() {
        return new Feature[]{com.google.android.gms.nearby.zza.zza, com.google.android.gms.nearby.zza.zzr, com.google.android.gms.nearby.zza.zzs, com.google.android.gms.nearby.zza.zzw, com.google.android.gms.nearby.zza.zzu, com.google.android.gms.nearby.zza.zzx, com.google.android.gms.nearby.zza.zzt, com.google.android.gms.nearby.zza.zzb, com.google.android.gms.nearby.zza.zzv, com.google.android.gms.nearby.zza.zzc, com.google.android.gms.nearby.zza.zzy, com.google.android.gms.nearby.zza.zzz};
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final Bundle getGetServiceRequestExtraArgs() {
        Bundle bundle = new Bundle();
        bundle.putLong("clientId", this.zzf);
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getServiceDescriptor() {
        return "com.google.android.gms.nearby.internal.connection.INearbyConnectionService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServiceAction() {
        return "com.google.android.gms.nearby.connection.service.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final /* bridge */ /* synthetic */ void onConnectedLocked(IInterface iInterface) {
        super.onConnectedLocked((zzee) iInterface);
        this.zzm = new zzgc();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final void onConnectionSuspended(int i) {
        if (i == 1) {
            zzJ();
            i = 1;
        }
        super.onConnectionSuspended(i);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final boolean usesClientTelemetry() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzA(BaseImplementation.ResultHolder resultHolder, String str) throws RemoteException {
        zzee zzeeVar = (zzee) getService();
        zzgz zzgzVar = new zzgz();
        zzgzVar.zza(new zzat(resultHolder));
        zzgzVar.zzb(str);
        zzeeVar.zzj(zzgzVar.zzc());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzB(BaseImplementation.ResultHolder resultHolder, String[] strArr, Payload payload, boolean z) throws Throwable {
        Pair pairCreate;
        zzgq zzgqVarZzs;
        try {
            if (payload instanceof com.google.android.gms.nearby.connection.v3.dct.zzj) {
                com.google.android.gms.nearby.connection.v3.dct.zzj zzjVar = (com.google.android.gms.nearby.connection.v3.dct.zzj) payload;
                com.google.android.gms.nearby.connection.v3.dct.zzg zzgVarZzm = zzjVar.zzm();
                com.google.android.gms.nearby.connection.v3.dct.zzh zzhVarZzn = zzjVar.zzn();
                com.google.android.gms.nearby.connection.v3.dct.zzi zziVarZzo = zzjVar.zzo();
                int iZzp = zzjVar.zzp();
                if (iZzp == 1) {
                    if (zzhVarZzn == null) {
                        throw new IllegalArgumentException("DctPayload is not request.");
                    }
                    Uri uriZza = zzhVarZzn.zza();
                    ArrayList arrayList = new ArrayList();
                    Map mapZze = zzhVarZzn.zze();
                    zzgh[] zzghVarArr = new zzgh[0];
                    if (mapZze != null) {
                        for (Map.Entry entry : mapZze.entrySet()) {
                            zzgg zzggVar = new zzgg();
                            zzggVar.zza((String) entry.getKey());
                            zzggVar.zzb((String) entry.getValue());
                            arrayList.add(zzggVar.zzc());
                        }
                        zzghVarArr = (zzgh[]) zzyg.zzs(arrayList).toArray(new zzgh[0]);
                    }
                    zzgs zzgsVar = new zzgs();
                    zzgsVar.zzb(uriZza);
                    zzgsVar.zza(zzhVarZzn.zzb());
                    zzgsVar.zzc(zzhVarZzn.zzc());
                    zzgsVar.zzd(zzghVarArr);
                    zzgt zzgtVarZze = zzgsVar.zze();
                    zzgp zzgpVar = new zzgp();
                    zzgpVar.zzb(zzjVar.getType());
                    zzgpVar.zza(zzjVar.getId());
                    zzgpVar.zzo(zzgtVarZze);
                    zzgpVar.zzr(1);
                    zzgy.zzd(zzgpVar, zzhVarZzn.zzd());
                    zzgqVarZzs = zzgpVar.zzs();
                } else if (iZzp == 2) {
                    if (zziVarZzo == null) {
                        throw new IllegalArgumentException("DctPayload is not response.");
                    }
                    if (!(zziVarZzo instanceof com.google.android.gms.nearby.connection.v3.dct.zzd)) {
                        throw new IllegalArgumentException("DctPayload response is not bytes response.");
                    }
                    com.google.android.gms.nearby.connection.v3.dct.zzd zzdVar = (com.google.android.gms.nearby.connection.v3.dct.zzd) zziVarZzo;
                    LinkedList linkedList = new LinkedList();
                    for (byte[] bArr : zzdVar.zza()) {
                        zzge zzgeVar = new zzge();
                        zzgeVar.zza(bArr);
                        linkedList.add(zzgeVar.zzb());
                    }
                    zzgp zzgpVar2 = new zzgp();
                    zzgpVar2.zzb(zzjVar.getType());
                    zzgpVar2.zza(zzjVar.getId());
                    zzgpVar2.zzr(2);
                    zzgv zzgvVar = new zzgv();
                    zzgvVar.zza(zzdVar.zzb());
                    zzgvVar.zzb(zzdVar.zzd());
                    zzgvVar.zzc(zzdVar.zzc());
                    zzgvVar.zzf((ParcelByteArray[]) zzyg.zzs(linkedList).toArray(new ParcelByteArray[0]));
                    zzgvVar.zza(zzdVar.zzb());
                    zzgvVar.zze(zzdVar.zze());
                    zzgpVar2.zzp(zzgvVar.zzg());
                    zzgqVarZzs = zzgpVar2.zzs();
                } else if (iZzp != 3) {
                    if (zzgVarZzm == null) {
                        throw new IllegalArgumentException("DctPayload is not one way message.");
                    }
                    zzgm zzgmVar = new zzgm();
                    zzgmVar.zza(zzgVarZzm.zza());
                    zzge zzgeVar2 = new zzge();
                    zzgeVar2.zza(zzgVarZzm.zzb());
                    zzgmVar.zzb(zzgeVar2.zzb());
                    zzgn zzgnVarZzc = zzgmVar.zzc();
                    zzgp zzgpVar3 = new zzgp();
                    zzgpVar3.zzb(zzjVar.getType());
                    zzgpVar3.zza(zzjVar.getId());
                    zzgpVar3.zzq(zzgnVarZzc);
                    zzgpVar3.zzr(4);
                    zzgqVarZzs = zzgpVar3.zzs();
                } else {
                    if (zziVarZzo == null) {
                        throw new IllegalArgumentException("DctPayload is not response.");
                    }
                    if (!(zziVarZzo instanceof com.google.android.gms.nearby.connection.v3.dct.zzf)) {
                        throw new IllegalArgumentException("DctPayload response is not files response.");
                    }
                    com.google.android.gms.nearby.connection.v3.dct.zzf zzfVar = (com.google.android.gms.nearby.connection.v3.dct.zzf) zziVarZzo;
                    LinkedList linkedList2 = new LinkedList();
                    for (Pair pair : zzfVar.zza()) {
                        zzgj zzgjVar = new zzgj();
                        zzgjVar.zza((byte[]) pair.first);
                        zzgjVar.zzb(((Payload.File) pair.second).zzg());
                        zzgjVar.zzc(((Payload.File) pair.second).getSize());
                        zzgjVar.zzd(((Payload.File) pair.second).asUri());
                        linkedList2.add(zzgjVar.zze());
                    }
                    zzyg zzygVarZzs = zzyg.zzs(linkedList2);
                    zzgp zzgpVar4 = new zzgp();
                    zzgpVar4.zzb(zzjVar.getType());
                    zzgpVar4.zza(zzjVar.getId());
                    zzgpVar4.zzr(3);
                    zzgv zzgvVar2 = new zzgv();
                    zzgvVar2.zza(zzfVar.zzb());
                    zzgvVar2.zzb(zzfVar.zzd());
                    zzgvVar2.zzc(zzfVar.zzc());
                    zzgvVar2.zzd((zzgk[]) zzygVarZzs.toArray(new zzgk[0]));
                    zzgvVar2.zza(zzfVar.zzb());
                    zzgvVar2.zze(zzfVar.zze());
                    zzgpVar4.zzp(zzgvVar2.zzg());
                    zzgqVarZzs = zzgpVar4.zzs();
                }
                pairCreate = Pair.create(zzgqVarZzs, zzxb.zze());
            } else {
                int type = payload.getType();
                if (type == 1) {
                    zzgp zzgpVar5 = new zzgp();
                    zzgpVar5.zza(payload.getId());
                    zzgpVar5.zzb(payload.getType());
                    zzgy.zzd(zzgpVar5, payload.asBytes());
                    pairCreate = Pair.create(zzgpVar5.zzs(), zzxb.zze());
                } else if (type == 2) {
                    Payload.File fileAsFile = payload.asFile();
                    zzxd.zzg(fileAsFile, "File cannot be null for Payload.Type.FILE");
                    Payload.File file = fileAsFile;
                    File fileAsJavaFile = fileAsFile.asJavaFile();
                    String absolutePath = fileAsJavaFile == null ? null : fileAsJavaFile.getAbsolutePath();
                    Uri uriAsUri = fileAsFile.asUri();
                    zzgp zzgpVar6 = new zzgp();
                    zzgpVar6.zza(payload.getId());
                    zzgpVar6.zzb(payload.getType());
                    zzgpVar6.zzd(fileAsFile.zzg());
                    zzgpVar6.zzh(uriAsUri);
                    zzgpVar6.zze(absolutePath);
                    zzgpVar6.zzf(fileAsFile.getSize());
                    zzgpVar6.zzi(payload.getOffset());
                    zzgpVar6.zzj(payload.zze());
                    zzgpVar6.zzl(payload.zzf());
                    zzgpVar6.zzm(payload.zzg());
                    zzgpVar6.zzn(payload.zzh());
                    pairCreate = Pair.create(zzgpVar6.zzs(), zzxb.zze());
                } else {
                    if (type != 3) {
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Outgoing Payload %d has unknown type %d", Long.valueOf(payload.getId()), Integer.valueOf(payload.getType())));
                        Log.wtf("NearbyConnections", "Unknown payload type!", illegalArgumentException);
                        throw illegalArgumentException;
                    }
                    try {
                        ParcelFileDescriptor[] parcelFileDescriptorArrCreatePipe = ParcelFileDescriptor.createPipe();
                        ParcelFileDescriptor[] parcelFileDescriptorArrCreatePipe2 = ParcelFileDescriptor.createPipe();
                        zzgp zzgpVar7 = new zzgp();
                        zzgpVar7.zza(payload.getId());
                        zzgpVar7.zzb(payload.getType());
                        zzgpVar7.zzd(parcelFileDescriptorArrCreatePipe[0]);
                        zzgpVar7.zzg(parcelFileDescriptorArrCreatePipe2[0]);
                        zzgpVar7.zzi(payload.getOffset());
                        zzgpVar7.zzl(payload.zzf());
                        pairCreate = Pair.create(zzgpVar7.zzs(), zzxb.zzf(Pair.create(parcelFileDescriptorArrCreatePipe[1], parcelFileDescriptorArrCreatePipe2[1])));
                    } catch (IOException e) {
                        Log.e("NearbyConnections", String.format("Unable to create PFD pipe for streaming payload %d from client to service.", Long.valueOf(payload.getId())), e);
                        throw e;
                    }
                }
            }
            zzee zzeeVar = (zzee) getService();
            zzhf zzhfVar = new zzhf();
            zzhfVar.zza(new zzat(resultHolder));
            zzhfVar.zzb(strArr);
            zzhfVar.zzc((zzgq) pairCreate.first);
            zzeeVar.zzk(zzhfVar.zzd());
            if (((zzxb) pairCreate.second).zza()) {
                Pair pair2 = (Pair) ((zzxb) pairCreate.second).zzb();
                zzgc zzgcVar = this.zzm;
                if (zzgcVar != null) {
                    zzgcVar.zza(((Payload.Stream) Preconditions.checkNotNull(payload.asStream())).asInputStream(), new ParcelFileDescriptor.AutoCloseOutputStream((ParcelFileDescriptor) pair2.first), new ParcelFileDescriptor.AutoCloseOutputStream((ParcelFileDescriptor) pair2.second), (zzgq) pairCreate.first, payload.getId());
                }
            }
        } catch (IOException e2) {
            Log.w("NearbyConnectionsClient", "Failed to create a Parcelable Payload.", e2);
            resultHolder.setResult(zzK(ConnectionsStatusCodes.STATUS_PAYLOAD_IO_ERROR));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzC(BaseImplementation.ResultHolder resultHolder, byte[] bArr, String str, ListenerHolder listenerHolder, zze zzeVar) throws RemoteException {
        zzv zzvVar = new zzv(listenerHolder);
        this.zzk.add(zzvVar);
        zzee zzeeVar = (zzee) getService();
        zzhi zzhiVar = new zzhi();
        zzhiVar.zza(new zzav(resultHolder));
        zzhiVar.zzh(bArr);
        zzhiVar.zzd(str);
        zzhiVar.zzf(zzeVar);
        zzhiVar.zzg(zzvVar);
        zzeeVar.zzd(zzhiVar.zzi());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzD(BaseImplementation.ResultHolder resultHolder, String str, String str2, ListenerHolder listenerHolder, zze zzeVar) throws RemoteException {
        zzv zzvVar = new zzv(listenerHolder);
        this.zzk.add(zzvVar);
        zzee zzeeVar = (zzee) getService();
        zzhi zzhiVar = new zzhi();
        zzhiVar.zza(new zzav(resultHolder));
        zzhiVar.zzc(str);
        zzhiVar.zzd(str2);
        zzhiVar.zzf(zzeVar);
        zzhiVar.zzg(zzvVar);
        zzeeVar.zzd(zzhiVar.zzi());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzE(BaseImplementation.ResultHolder resultHolder, String str, ListenerHolder listenerHolder, zzdl zzdlVar) throws RemoteException {
        zzaf zzafVar = new zzaf(listenerHolder);
        this.zzg.add(zzafVar);
        zzee zzeeVar = (zzee) getService();
        zzhl zzhlVar = new zzhl();
        zzhlVar.zza(new zzat(resultHolder));
        zzhlVar.zzb(str);
        zzhlVar.zzd(zzdlVar);
        zzhlVar.zze(zzafVar);
        zzeeVar.zzf(zzhlVar.zzf());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzF(BaseImplementation.ResultHolder resultHolder, long j) throws RemoteException {
        zzee zzeeVar = (zzee) getService();
        zzg zzgVar = new zzg();
        zzgVar.zza(new zzat(resultHolder));
        zzgVar.zzb(j);
        zzeeVar.zzo(zzgVar.zzc());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzG(String str) throws RemoteException {
        zzee zzeeVar = (zzee) getService();
        zzdh zzdhVar = new zzdh();
        zzdhVar.zza(str);
        zzeeVar.zzl(zzdhVar.zzb());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzH() throws RemoteException {
        ((zzee) getService()).zzm(new zzhr());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzv(BaseImplementation.ResultHolder resultHolder, String str, String str2, ListenerHolder listenerHolder, zzm zzmVar) throws RemoteException {
        zzv zzvVar = new zzv(listenerHolder);
        this.zzk.add(zzvVar);
        zzee zzeeVar = (zzee) getService();
        zzhc zzhcVar = new zzhc();
        zzhcVar.zza(new zzat(resultHolder));
        zzhcVar.zzd(str);
        zzhcVar.zze(str2);
        zzhcVar.zzg(zzvVar);
        zzhcVar.zzi(zzmVar);
        zzeeVar.zzh(zzhcVar.zzj());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzw(BaseImplementation.ResultHolder resultHolder, byte[] bArr, String str, ListenerHolder listenerHolder, zzm zzmVar) throws RemoteException {
        zzv zzvVar = new zzv(listenerHolder);
        this.zzk.add(zzvVar);
        zzee zzeeVar = (zzee) getService();
        zzhc zzhcVar = new zzhc();
        zzhcVar.zza(new zzat(resultHolder));
        zzhcVar.zzh(bArr);
        zzhcVar.zze(str);
        zzhcVar.zzg(zzvVar);
        zzhcVar.zzi(zzmVar);
        zzeeVar.zzh(zzhcVar.zzj());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzx(BaseImplementation.ResultHolder resultHolder, byte[] bArr, String str, ListenerHolder listenerHolder) throws RemoteException {
        zzv zzvVar = new zzv(listenerHolder);
        this.zzk.add(zzvVar);
        zzee zzeeVar = (zzee) getService();
        zzhc zzhcVar = new zzhc();
        zzhcVar.zza(new zzat(resultHolder));
        zzhcVar.zzh(bArr);
        zzhcVar.zze(str);
        zzhcVar.zzg(zzvVar);
        zzeeVar.zzh(zzhcVar.zzj());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzy(BaseImplementation.ResultHolder resultHolder, String str, String str2, ListenerHolder listenerHolder) throws RemoteException {
        zzv zzvVar = new zzv(listenerHolder);
        this.zzk.add(zzvVar);
        zzee zzeeVar = (zzee) getService();
        zzhc zzhcVar = new zzhc();
        zzhcVar.zza(new zzat(resultHolder));
        zzhcVar.zzd(str);
        zzhcVar.zze(str2);
        zzhcVar.zzg(zzvVar);
        zzeeVar.zzh(zzhcVar.zzj());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzz(BaseImplementation.ResultHolder resultHolder, String str, ListenerHolder listenerHolder) throws RemoteException {
        zzas zzasVar = new zzas(getContext(), listenerHolder, this.zzm);
        this.zzi.add(zzasVar);
        zzee zzeeVar = (zzee) getService();
        zza zzaVar = new zza();
        zzaVar.zza(new zzat(resultHolder));
        zzaVar.zzc(str);
        zzaVar.zze(zzasVar);
        zzeeVar.zzi(zzaVar.zzf());
    }
}
