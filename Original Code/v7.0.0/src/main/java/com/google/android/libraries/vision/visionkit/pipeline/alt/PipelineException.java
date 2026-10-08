package com.google.android.libraries.vision.visionkit.pipeline.alt;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbki;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbko;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbkx;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtp;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuq;
import com.google.android.libraries.vision.visionkit.pipeline.zbad;
import com.google.android.libraries.vision.visionkit.pipeline.zber;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
public class PipelineException extends Exception {
    private static final String ROOT_CAUSE_DELIMITER = "#vk ";
    private final zbd statusCode;
    private final String statusMessage;
    private final zber visionkitStatus;

    public PipelineException(int i, String str) {
        super(zbd.values()[i].zba() + ": " + str);
        this.statusCode = zbd.values()[i];
        this.statusMessage = str;
        this.visionkitStatus = null;
    }

    public List<zbad> getComponentStatuses() {
        zber zberVar = this.visionkitStatus;
        return zberVar != null ? zberVar.zbf() : zbkx.zbh();
    }

    public zbki<String> getRootCauseMessage() {
        Object next;
        Object obj;
        if (!this.statusMessage.contains(ROOT_CAUSE_DELIMITER)) {
            return zbki.zbd();
        }
        List listZbb = zbko.zba(ROOT_CAUSE_DELIMITER).zbb(this.statusMessage);
        if (!(listZbb instanceof List)) {
            Iterator it = listZbb.iterator();
            do {
                next = it.next();
            } while (it.hasNext());
            obj = next;
        } else {
            if (listZbb.isEmpty()) {
                throw new NoSuchElementException();
            }
            obj = listZbb.get(listZbb.size() - 1);
        }
        return zbki.zbe((String) obj);
    }

    public zbd getStatusCode() {
        return this.statusCode;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    private PipelineException(zber zberVar) {
        super(zbd.values()[zberVar.zba()].zba() + ": " + zberVar.zbe());
        this.statusCode = zbd.values()[zberVar.zba()];
        this.statusMessage = zberVar.zbe();
        this.visionkitStatus = zberVar;
    }

    PipelineException(byte[] bArr) throws zbuq {
        this(zber.zbd(bArr, zbtp.zba()));
    }
}
