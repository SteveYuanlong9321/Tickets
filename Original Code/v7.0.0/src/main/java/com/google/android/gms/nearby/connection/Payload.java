package com.google.android.gms.nearby.connection;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.internal.nearby.zzxm;
import com.google.android.gms.internal.nearby.zzyg;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.UUID;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public class Payload {
    public static final zzyg zza = zzyg.zzm("/", "\\", "../");
    public static final zzyg zzb;
    private final long zzc;
    private final int zzd;
    private final byte[] zze;
    private final File zzf;
    private final Stream zzg;
    private long zzh;
    private boolean zzi;
    private long zzj;
    private String zzk;
    private String zzl;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
    public static class File {
        private final java.io.File zza;
        private final ParcelFileDescriptor zzb;
        private final long zzc;
        private final Uri zzd;

        private File(java.io.File file, ParcelFileDescriptor parcelFileDescriptor, long j, Uri uri) {
            this.zza = file;
            this.zzb = parcelFileDescriptor;
            this.zzc = j;
            this.zzd = uri;
        }

        /* synthetic */ File(java.io.File file, ParcelFileDescriptor parcelFileDescriptor, long j, Uri uri, byte[] bArr) {
            this(null, null, j, uri);
        }

        public static File zza(java.io.File file, ParcelFileDescriptor parcelFileDescriptor, long j, Uri uri) {
            return new File((java.io.File) Preconditions.checkNotNull(file, "Cannot create Payload.File from null java.io.File."), (ParcelFileDescriptor) Preconditions.checkNotNull(parcelFileDescriptor, "Cannot create Payload.File from null ParcelFileDescriptor."), j, (Uri) Preconditions.checkNotNull(uri, "Cannot create Payload.File from null Uri"));
        }

        public static File zzb(Uri uri, long j) {
            return new File(null, null, j, (Uri) Preconditions.checkNotNull(uri, "Cannot create Payload.File from null Uri"));
        }

        public static File zzc(Uri uri, ParcelFileDescriptor parcelFileDescriptor, long j) {
            return new File(null, (ParcelFileDescriptor) Preconditions.checkNotNull(parcelFileDescriptor, "Cannot create Payload.File from null ParcelFileDescriptor."), j, (Uri) Preconditions.checkNotNull(uri, "Cannot create Payload.File from null Uri"));
        }

        public static File zzd(ParcelFileDescriptor parcelFileDescriptor) {
            return new File(null, (ParcelFileDescriptor) Preconditions.checkNotNull(parcelFileDescriptor, "Cannot create Payload.File from null ParcelFileDescriptor."), parcelFileDescriptor.getStatSize(), null);
        }

        public static File zze(ParcelFileDescriptor parcelFileDescriptor, long j) {
            return new File(null, (ParcelFileDescriptor) Preconditions.checkNotNull(parcelFileDescriptor, "Cannot create Payload.File from null ParcelFileDescriptor."), j, null);
        }

        public static File zzf() {
            return new File(null, null, 0L, null);
        }

        @Deprecated
        public java.io.File asJavaFile() {
            return this.zza;
        }

        public ParcelFileDescriptor asParcelFileDescriptor() {
            return (ParcelFileDescriptor) Preconditions.checkNotNull(this.zzb, "ParcelFileDescriptor is not available to the File");
        }

        public Uri asUri() {
            return this.zzd;
        }

        @Deprecated
        public void close() {
            IOUtils.closeQuietly(this.zzb);
        }

        public long getSize() {
            return this.zzc;
        }

        public final ParcelFileDescriptor zzg() {
            return this.zzb;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
    public static class Stream {
        private final ParcelFileDescriptor zza;
        private InputStream zzb;

        private Stream(ParcelFileDescriptor parcelFileDescriptor, InputStream inputStream) {
            this.zza = parcelFileDescriptor;
            this.zzb = inputStream;
        }

        public static Stream zza(InputStream inputStream) {
            Preconditions.checkNotNull(inputStream, "Cannot create Payload.Stream from null InputStream.");
            return new Stream(null, inputStream);
        }

        public static Stream zzb(ParcelFileDescriptor parcelFileDescriptor) {
            Preconditions.checkNotNull(parcelFileDescriptor, "Cannot create Payload.Stream from null ParcelFileDescriptor.");
            return new Stream(parcelFileDescriptor, null);
        }

        public InputStream asInputStream() {
            if (this.zzb == null) {
                this.zzb = new ParcelFileDescriptor.AutoCloseInputStream((ParcelFileDescriptor) Preconditions.checkNotNull(this.zza));
            }
            return this.zzb;
        }

        public ParcelFileDescriptor asParcelFileDescriptor() {
            return this.zza;
        }

        @Deprecated
        public void close() {
            IOUtils.closeQuietly(this.zza);
            IOUtils.closeQuietly(this.zzb);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
    public @interface Type {
        public static final int BYTES = 1;
        public static final int FILE = 2;
        public static final int STREAM = 3;
    }

    static {
        zzyg.zzq("../", "/", "\\", "?", "*", "\"", "<", ">", "|", ":", "\u0000", "\n", "\r", "\t", "\f");
        zzyg.zzn("..", ".", "\\", "/");
        zzyg.zzk("\\");
        zzb = zzyg.zzl("../", "..\\");
        zzyg.zzq("?", "*", "\"", "|", ":", "\u0000", "\n", "\r", "\t", "\f", "../", "..", new String[0]);
        zzyg.zzk("\\");
        zzyg.zzl("\\", "/");
    }

    protected Payload(long j, int i, byte[] bArr, File file, Stream stream) {
        this.zzc = j;
        this.zzd = i;
        this.zze = bArr;
        this.zzf = file;
        this.zzg = stream;
    }

    public static Payload fromBytes(byte[] bArr) {
        Preconditions.checkNotNull(bArr, "Cannot create a Payload from null bytes.");
        return new Payload(UUID.randomUUID().getLeastSignificantBits(), 1, bArr, null, null);
    }

    public static Payload fromFile(ParcelFileDescriptor parcelFileDescriptor) {
        return zzc(File.zzd(parcelFileDescriptor), UUID.randomUUID().getLeastSignificantBits());
    }

    public static Payload fromStream(ParcelFileDescriptor parcelFileDescriptor) {
        return new Payload(UUID.randomUUID().getLeastSignificantBits(), 3, null, null, Stream.zzb(parcelFileDescriptor));
    }

    public static Payload zza(byte[] bArr, long j) {
        return new Payload(j, 1, bArr, null, null);
    }

    public static Payload zzb(Uri uri, long j, long j2) {
        return zzc(new File(null, null, j, (Uri) Preconditions.checkNotNull(uri, "Cannot create Payload.File from null Uri"), null), j2);
    }

    public static Payload zzc(File file, long j) {
        Payload payload = new Payload(j, 2, null, file, null);
        if (file.getSize() <= 0) {
            return payload;
        }
        long size = file.getSize();
        if (size < 0) {
            throw new IllegalArgumentException("Payload size must be positive.");
        }
        if (payload.getType() != 3 && payload.getType() != 2) {
            throw new IllegalArgumentException("Payload type must be FILE or STREAM.");
        }
        if (size < payload.zzh) {
            throw new IllegalArgumentException("Payload stream size must be larger than the offset.");
        }
        payload.zzj = size;
        return payload;
    }

    public static Payload zzd(Stream stream, long j) {
        return new Payload(j, 3, null, null, stream);
    }

    public byte[] asBytes() {
        return this.zze;
    }

    public File asFile() {
        return this.zzf;
    }

    public Stream asStream() {
        return this.zzg;
    }

    public void close() {
        File file = this.zzf;
        if (file != null) {
            file.close();
        }
        Stream stream = this.zzg;
        if (stream != null) {
            stream.close();
        }
    }

    public long getId() {
        return this.zzc;
    }

    public long getOffset() {
        return this.zzh;
    }

    public int getType() {
        return this.zzd;
    }

    public void setFileName(String str) {
        if (zzxm.zzc(str)) {
            throw new IllegalArgumentException("Payload file name should not be null or empty.");
        }
        if (getType() != 2) {
            throw new IllegalArgumentException("Payload type must be FILE.");
        }
        zzyg zzygVar = zza;
        int size = zzygVar.size();
        int i = 0;
        while (i < size) {
            String str2 = (String) zzygVar.get(i);
            i++;
            if (str.contains(str2)) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 35 + String.valueOf(str2).length() + 1);
                sb.append("File name ");
                sb.append(str);
                sb.append(" contains illegal string ");
                sb.append(str2);
                sb.append(".");
                throw new IllegalArgumentException(sb.toString());
            }
        }
        this.zzk = str;
    }

    public void setParentFolder(String str) {
        if (zzxm.zzc(str)) {
            throw new IllegalArgumentException("Payload parent folder should not be null or empty.");
        }
        if (getType() != 2) {
            throw new IllegalArgumentException("Payload type must be FILE.");
        }
        zzyg zzygVar = zzb;
        int size = zzygVar.size();
        int i = 0;
        while (i < size) {
            boolean zContains = str.contains((String) zzygVar.get(i));
            i++;
            if (zContains) {
                throw new IllegalArgumentException("Folder name contains illegal string.");
            }
        }
        this.zzl = str;
    }

    public void setSensitive(boolean z) {
        this.zzi = z;
    }

    public final boolean zze() {
        return this.zzi;
    }

    public final long zzf() {
        return this.zzj;
    }

    public final String zzg() {
        return this.zzk;
    }

    public final String zzh() {
        return this.zzl;
    }

    public void setOffset(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Payload offset must be positive or zero.");
        }
        if (getType() != 2 && getType() != 3) {
            throw new IllegalArgumentException("Payload offset only support FILE or STREAM type.");
        }
        File file = this.zzf;
        if (file != null && j >= file.getSize()) {
            throw new IllegalArgumentException("Payload offset should be smaller than the file size.");
        }
        if (getType() == 3) {
            long j2 = this.zzj;
            if (j2 > 0 && j2 <= j) {
                throw new IllegalArgumentException("Payload offset should be smaller than the stream size.");
            }
        }
        this.zzh = j;
    }

    public static Payload fromFile(java.io.File file) throws FileNotFoundException {
        return zzc(File.zza(file, ParcelFileDescriptor.open(file, GroupFlagsKt.IsMovableContentFlag), file.length(), Uri.fromFile(file)), UUID.randomUUID().getLeastSignificantBits());
    }

    public static Payload fromStream(InputStream inputStream) {
        return new Payload(UUID.randomUUID().getLeastSignificantBits(), 3, null, null, Stream.zza(inputStream));
    }
}
