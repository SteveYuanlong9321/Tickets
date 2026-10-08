package com.google.android.gms.internal.nearby;

import android.accounts.Account;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzqr extends zzrp {
    private final Context zza;
    private final zzro zzb;
    private final Object zzc = new Object();

    @Nullable
    private volatile String zzd;

    /* synthetic */ zzqr(zzqq zzqqVar, byte[] bArr) {
        this.zzb = new zzqx(zzqqVar.zzc());
        this.zza = zzqqVar.zzb();
    }

    public static zzqq zza(Context context) {
        return new zzqq(context, null);
    }

    private final boolean zzh(Uri uri) {
        return (TextUtils.isEmpty(uri.getAuthority()) || this.zza.getPackageName().equals(uri.getAuthority())) ? false : true;
    }

    private static final void zzi() throws zzra {
        throw new zzra("Android backend cannot perform remote operations without a remote backend");
    }

    @Override // com.google.android.gms.internal.nearby.zzrp
    protected final zzro zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.nearby.zzro
    public final String zzc() {
        return "android";
    }

    @Override // com.google.android.gms.internal.nearby.zzro
    public final InputStream zzd(Uri uri) throws IOException {
        if (!zzh(uri)) {
            return zzrf.zzb(zzqw.zza(zzf(uri)));
        }
        zzi();
        throw null;
    }

    @Override // com.google.android.gms.internal.nearby.zzro
    public final boolean zze(Uri uri) throws IOException {
        if (!zzh(uri)) {
            return zzqw.zza(zzf(uri)).exists();
        }
        zzi();
        throw null;
    }

    @Override // com.google.android.gms.internal.nearby.zzrp
    protected final Uri zzf(Uri uri) throws IOException {
        if (zzh(uri)) {
            throw new zzrc("Operation across authorities is not allowed.");
        }
        File fileZzg = zzg(uri);
        zzqv zzqvVar = new zzqv(null);
        zzqvVar.zza(fileZzg);
        return zzqvVar.zzb();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:53:0x010f  */
    /* JADX WARN: Code duplicated, block: B:55:0x0113  */
    /* JADX WARN: Code duplicated, block: B:59:0x011a A[Catch: all -> 0x012e, TryCatch #1 {, blocks: (B:57:0x0116, B:59:0x011a, B:60:0x012c), top: B:82:0x0116 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x013c  */
    /* JADX WARN: Code duplicated, block: B:82:0x0116 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.google.android.gms.internal.nearby.zzro
    public final File zzg(Uri uri) throws IOException {
        File externalFilesDir;
        Account account;
        File file;
        String absolutePath;
        if (zzh(uri)) {
            throw new IOException("operation is not permitted in other authorities.");
        }
        Context context = this.zza;
        if (!uri.getScheme().equals("android")) {
            throw new zzrc("Scheme must be 'android'");
        }
        if (uri.getPathSegments().isEmpty()) {
            throw new zzrc(String.format("Path must start with a valid logical location: %s", uri));
        }
        if (!TextUtils.isEmpty(uri.getQuery())) {
            throw new zzrc("Did not expect uri to have query");
        }
        ArrayList arrayList = new ArrayList(uri.getPathSegments());
        String str = (String) arrayList.get(0);
        switch (str.hashCode()) {
            case -1820761141:
                if (str.equals("external")) {
                    externalFilesDir = context.getExternalFilesDir(null);
                    file = new File(externalFilesDir, TextUtils.join(File.separator, arrayList.subList(1, arrayList.size())));
                    if (!zzkf.zzb(context)) {
                        absolutePath = this.zzd;
                        if (absolutePath == null) {
                            synchronized (this.zzc) {
                                absolutePath = this.zzd;
                                if (absolutePath == null) {
                                    absolutePath = zzqs.zza(context.createDeviceProtectedStorageContext()).getParentFile().getAbsolutePath();
                                    this.zzd = absolutePath;
                                }
                            }
                        }
                        if (!file.getAbsolutePath().startsWith(absolutePath)) {
                            throw new zzra("Cannot access credential-protected data from direct boot");
                        }
                        break;
                    }
                    return file;
                }
                throw new zzrc(String.format("Path must start with a valid logical location: %s", uri));
            case 94416770:
                if (str.equals("cache")) {
                    externalFilesDir = context.getCacheDir();
                    file = new File(externalFilesDir, TextUtils.join(File.separator, arrayList.subList(1, arrayList.size())));
                    if (!zzkf.zzb(context)) {
                        absolutePath = this.zzd;
                        if (absolutePath == null) {
                            synchronized (this.zzc) {
                                absolutePath = this.zzd;
                                if (absolutePath == null) {
                                    absolutePath = zzqs.zza(context.createDeviceProtectedStorageContext()).getParentFile().getAbsolutePath();
                                    this.zzd = absolutePath;
                                }
                            }
                        }
                        if (!file.getAbsolutePath().startsWith(absolutePath)) {
                            throw new zzra("Cannot access credential-protected data from direct boot");
                        }
                    }
                    return file;
                }
                throw new zzrc(String.format("Path must start with a valid logical location: %s", uri));
            case 97434231:
                if (str.equals("files")) {
                    externalFilesDir = zzqs.zza(context);
                    file = new File(externalFilesDir, TextUtils.join(File.separator, arrayList.subList(1, arrayList.size())));
                    if (!zzkf.zzb(context)) {
                        absolutePath = this.zzd;
                        if (absolutePath == null) {
                            synchronized (this.zzc) {
                                absolutePath = this.zzd;
                                if (absolutePath == null) {
                                    absolutePath = zzqs.zza(context.createDeviceProtectedStorageContext()).getParentFile().getAbsolutePath();
                                    this.zzd = absolutePath;
                                }
                            }
                        }
                        if (!file.getAbsolutePath().startsWith(absolutePath)) {
                            throw new zzra("Cannot access credential-protected data from direct boot");
                        }
                    }
                    return file;
                }
                throw new zzrc(String.format("Path must start with a valid logical location: %s", uri));
            case 835260319:
                if (str.equals("managed")) {
                    File file2 = new File(zzqs.zza(context), "managed");
                    if (arrayList.size() >= 3) {
                        try {
                            String str2 = (String) arrayList.get(2);
                            Account account2 = zzqp.zza;
                            if ("shared".equals(str2)) {
                                account = zzqp.zza;
                            } else {
                                int iIndexOf = str2.indexOf(58);
                                zzrk.zza(iIndexOf >= 0, "Malformed account", new Object[0]);
                                account = new Account(str2.substring(iIndexOf + 1), str2.substring(0, iIndexOf));
                            }
                            if (!zzqp.zza.equals(account)) {
                                throw new zzrc("AccountManager cannot be null");
                            }
                        } catch (IllegalArgumentException e) {
                            throw new zzrc(e);
                        }
                    }
                    externalFilesDir = file2;
                    file = new File(externalFilesDir, TextUtils.join(File.separator, arrayList.subList(1, arrayList.size())));
                    if (!zzkf.zzb(context)) {
                        absolutePath = this.zzd;
                        if (absolutePath == null) {
                            synchronized (this.zzc) {
                                absolutePath = this.zzd;
                                if (absolutePath == null) {
                                    absolutePath = zzqs.zza(context.createDeviceProtectedStorageContext()).getParentFile().getAbsolutePath();
                                    this.zzd = absolutePath;
                                }
                            }
                        }
                        if (!file.getAbsolutePath().startsWith(absolutePath)) {
                            throw new zzra("Cannot access credential-protected data from direct boot");
                        }
                    }
                    return file;
                }
                throw new zzrc(String.format("Path must start with a valid logical location: %s", uri));
            case 988548496:
                if (str.equals("directboot-cache")) {
                    externalFilesDir = context.createDeviceProtectedStorageContext().getCacheDir();
                    file = new File(externalFilesDir, TextUtils.join(File.separator, arrayList.subList(1, arrayList.size())));
                    if (!zzkf.zzb(context)) {
                        absolutePath = this.zzd;
                        if (absolutePath == null) {
                            synchronized (this.zzc) {
                                absolutePath = this.zzd;
                                if (absolutePath == null) {
                                    absolutePath = zzqs.zza(context.createDeviceProtectedStorageContext()).getParentFile().getAbsolutePath();
                                    this.zzd = absolutePath;
                                }
                            }
                        }
                        if (!file.getAbsolutePath().startsWith(absolutePath)) {
                            throw new zzra("Cannot access credential-protected data from direct boot");
                        }
                    }
                    return file;
                }
                throw new zzrc(String.format("Path must start with a valid logical location: %s", uri));
            case 991565957:
                if (str.equals("directboot-files")) {
                    externalFilesDir = context.createDeviceProtectedStorageContext().getFilesDir();
                    file = new File(externalFilesDir, TextUtils.join(File.separator, arrayList.subList(1, arrayList.size())));
                    if (!zzkf.zzb(context)) {
                        absolutePath = this.zzd;
                        if (absolutePath == null) {
                            synchronized (this.zzc) {
                                absolutePath = this.zzd;
                                if (absolutePath == null) {
                                    absolutePath = zzqs.zza(context.createDeviceProtectedStorageContext()).getParentFile().getAbsolutePath();
                                    this.zzd = absolutePath;
                                }
                            }
                        }
                        if (!file.getAbsolutePath().startsWith(absolutePath)) {
                            throw new zzra("Cannot access credential-protected data from direct boot");
                        }
                    }
                    return file;
                }
                throw new zzrc(String.format("Path must start with a valid logical location: %s", uri));
            default:
                throw new zzrc(String.format("Path must start with a valid logical location: %s", uri));
        }
    }
}
