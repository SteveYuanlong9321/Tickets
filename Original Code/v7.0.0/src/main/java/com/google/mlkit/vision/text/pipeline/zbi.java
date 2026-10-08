package com.google.mlkit.vision.text.pipeline;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.Image;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbabj;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbbb;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbbe;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbiu;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbix;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbkf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbki;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbku;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbkx;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zblc;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbnx;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zboe;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbog;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zboi;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbok;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zboo;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbpb;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbpf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbpg;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbpi;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbpk;
import com.google.android.libraries.vision.visionkit.pipeline.AndroidAssetUtil;
import com.google.android.libraries.vision.visionkit.pipeline.alt.PipelineException;
import com.google.android.libraries.vision.visionkit.pipeline.zbbz;
import com.google.android.libraries.vision.visionkit.pipeline.zbca;
import com.google.android.libraries.vision.visionkit.pipeline.zbct;
import com.google.android.libraries.vision.visionkit.pipeline.zbcv;
import com.google.android.libraries.vision.visionkit.pipeline.zbcw;
import com.google.android.libraries.vision.visionkit.pipeline.zbcz;
import com.google.android.libraries.vision.visionkit.pipeline.zbdl;
import com.google.android.libraries.vision.visionkit.pipeline.zbdo;
import com.google.android.libraries.vision.visionkit.pipeline.zbfb;
import com.google.android.libraries.vision.visionkit.pipeline.zbfc;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.vision.common.internal.ImageConvertUtils;
import com.google.mlkit.vision.common.internal.ImageUtils;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zbi {
    zbh zba;
    boolean zbb;
    private final Context zbc;
    private final VkpTextRecognizerOptions zbd;
    private boolean zbe = true;

    private zbi(Context context, VkpTextRecognizerOptions vkpTextRecognizerOptions) {
        this.zbc = context;
        this.zbd = vkpTextRecognizerOptions;
    }

    public static zbi zba(Context context, VkpTextRecognizerOptions vkpTextRecognizerOptions) {
        return new zbi(context, vkpTextRecognizerOptions);
    }

    public final zbn zbb(IObjectWrapper iObjectWrapper, zbnx zbnxVar, boolean z) {
        zbki zbkiVarZbe;
        zbku zbkuVar;
        zbku zbkuVar2;
        zbku zbkuVar3;
        zbo zboVarZbc = zbc();
        if (!zboVarZbc.zbd()) {
            return zbn.zbe(zboVarZbc);
        }
        try {
            int i = 1;
            if (zbnxVar.zbb() == -1) {
                Log.d("PipelineManager", "Start process bitmap");
                Bitmap bitmapCopy = (Bitmap) Preconditions.checkNotNull((Bitmap) ObjectWrapper.unwrap(iObjectWrapper));
                if (bitmapCopy.getConfig() != Bitmap.Config.ARGB_8888) {
                    Log.d("PipelineManager", "Input bitmap is not ARGB_8888 config. Converting it to ARGB_8888 from " + String.valueOf(bitmapCopy.getConfig()));
                    bitmapCopy = bitmapCopy.copy(Bitmap.Config.ARGB_8888, bitmapCopy.isMutable());
                }
                zbkiVarZbe = ((zbh) Preconditions.checkNotNull(this.zba)).zbi(SystemClock.elapsedRealtime() * 1000, bitmapCopy, zbj.zbb(zbnxVar.zbc()));
            } else if (zbnxVar.zbb() == 35) {
                Log.d("PipelineManager", "Start process YUV");
                Image.Plane[] planes = ((Image) Preconditions.checkNotNull(ObjectWrapper.unwrap(iObjectWrapper))).getPlanes();
                zbkiVarZbe = ((zbh) Preconditions.checkNotNull(this.zba)).zbj(SystemClock.elapsedRealtime() * 1000, ((Image.Plane) Preconditions.checkNotNull(planes[0])).getBuffer(), ((Image.Plane) Preconditions.checkNotNull(planes[1])).getBuffer(), ((Image.Plane) Preconditions.checkNotNull(planes[2])).getBuffer(), zbnxVar.zbd(), zbnxVar.zba(), ((Image.Plane) Preconditions.checkNotNull(planes[0])).getRowStride(), ((Image.Plane) Preconditions.checkNotNull(planes[1])).getRowStride(), ((Image.Plane) Preconditions.checkNotNull(planes[1])).getPixelStride(), zbj.zbb(zbnxVar.zbc()));
            } else if (zbnxVar.zbb() == 17) {
                Log.d("PipelineManager", "Start process NV21");
                zbkiVarZbe = ((zbh) Preconditions.checkNotNull(this.zba)).zbe(zbj.zba(ImageConvertUtils.bufferWithBackingArray((ByteBuffer) Preconditions.checkNotNull((ByteBuffer) ObjectWrapper.unwrap(iObjectWrapper))), zbnxVar));
            } else {
                if (zbnxVar.zbb() != 842094169) {
                    throw new MlKitException("Unsupported image format: " + zbnxVar.zbb(), 3);
                }
                Log.d("PipelineManager", "Start process YV12");
                zbkiVarZbe = ((zbh) Preconditions.checkNotNull(this.zba)).zbe(zbj.zba(ImageConvertUtils.yv12ToNv21Buffer((ByteBuffer) Preconditions.checkNotNull(ObjectWrapper.unwrap(iObjectWrapper)), true), zbnxVar));
            }
            if (!zbkiVarZbe.zbc()) {
                return zbn.zbe(zbo.zbc(3, new RemoteException("VisionKit pipeline returns empty result.")));
            }
            Log.d("PipelineManager", "OCR process succeeded via visionkit pipeline.");
            zbcz zbczVar = (zbcz) zbkiVarZbe.zba();
            Matrix uprightRotationMatrix = ImageUtils.getInstance().getUprightRotationMatrix(zbnxVar.zbd(), zbnxVar.zba(), zbnxVar.zbc());
            boolean z2 = this.zbe;
            zbb zbbVar = new zbb(0, zbki.zbd());
            List<zbabj> listZbf = zbczVar.zbe().zbf();
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            HashMap map3 = new HashMap();
            for (zbabj zbabjVar : listZbf) {
                if (zbabjVar.zbI() == 6) {
                    zbpb zbpbVarZbb = zbf.zbb(zbabjVar.zbf());
                    List listZbc = zbf.zbc(zbpbVarZbb);
                    zboo zbooVar = new zboo(zbabjVar.zbH(), zbf.zba(listZbc, uprightRotationMatrix), listZbc, zbabjVar.zbc(), zbpbVarZbb.zba());
                    Integer numValueOf = Integer.valueOf(zbabjVar.zbe());
                    if (map2.containsKey(numValueOf)) {
                        zbkuVar3 = (zbku) map2.get(numValueOf);
                    } else {
                        zbku zbkuVar4 = new zbku();
                        map2.put(numValueOf, zbkuVar4);
                        zbkuVar3 = zbkuVar4;
                    }
                    ((zbku) Preconditions.checkNotNull(zbkuVar3)).zba(zbooVar);
                }
            }
            int i2 = 0;
            while (i2 < listZbf.size()) {
                zbabj zbabjVar2 = (zbabj) listZbf.get(i2);
                if (zbabjVar2.zbI() == i) {
                    zbpb zbpbVarZbb2 = zbf.zbb(zbabjVar2.zbf());
                    List listZbc2 = zbf.zbc(zbpbVarZbb2);
                    Integer numValueOf2 = Integer.valueOf(i2);
                    zbog zbogVar = new zbog(zbabjVar2.zbH(), zbf.zba(listZbc2, uprightRotationMatrix), listZbc2, zbg.zba(zbabjVar2.zbh().zbf()), zbabjVar2.zbc(), zbpbVarZbb2.zba(), (List) Preconditions.checkNotNull(map2.containsKey(numValueOf2) ? ((zbku) Preconditions.checkNotNull((zbku) map2.get(numValueOf2))).zbb() : zbkx.zbh()));
                    Integer numValueOf3 = Integer.valueOf(zbabjVar2.zbe());
                    if (map.containsKey(numValueOf3)) {
                        zbkuVar2 = (zbku) map.get(numValueOf3);
                    } else {
                        zbku zbkuVar5 = new zbku();
                        map.put(numValueOf3, zbkuVar5);
                        zbkuVar2 = zbkuVar5;
                    }
                    ((zbku) Preconditions.checkNotNull(zbkuVar2)).zba(zbogVar);
                }
                i2++;
                i = 1;
            }
            for (int i3 = 0; i3 < listZbf.size(); i3++) {
                zbabj zbabjVar3 = (zbabj) listZbf.get(i3);
                if (zbabjVar3.zbI() == 3) {
                    zbpb zbpbVarZbb3 = zbf.zbb(zbabjVar3.zbf());
                    List listZbc3 = zbf.zbc(zbpbVarZbb3);
                    Integer numValueOf4 = Integer.valueOf(i3);
                    zboi zboiVar = new zboi(zbabjVar3.zbH(), zbf.zba(listZbc3, uprightRotationMatrix), listZbc3, zbg.zba(zbabjVar3.zbh().zbf()), (List) Preconditions.checkNotNull(map.containsKey(numValueOf4) ? ((zbku) Preconditions.checkNotNull((zbku) map.get(numValueOf4))).zbb() : zbkx.zbh()), zbabjVar3.zbc(), zbpbVarZbb3.zba());
                    Integer numValueOf5 = Integer.valueOf(zbabjVar3.zbe());
                    if (map3.containsKey(numValueOf5)) {
                        zbkuVar = (zbku) map3.get(numValueOf5);
                    } else {
                        zbku zbkuVar6 = new zbku();
                        map3.put(Integer.valueOf(zbabjVar3.zbe()), zbkuVar6);
                        zbkuVar = zbkuVar6;
                    }
                    ((zbku) Preconditions.checkNotNull(zbkuVar)).zba(zboiVar);
                }
            }
            zbku zbkuVar7 = new zbku();
            for (int i4 = 0; i4 < listZbf.size(); i4++) {
                zbabj zbabjVar4 = (zbabj) listZbf.get(i4);
                if (zbabjVar4.zbI() == 4) {
                    List listZbc4 = zbf.zbc(zbf.zbb(zbabjVar4.zbf()));
                    zbkx zbkxVarZbh = zbkx.zbh();
                    Integer numValueOf6 = Integer.valueOf(i4);
                    if (map3.containsKey(numValueOf6)) {
                        zbkxVarZbh = ((zbku) Preconditions.checkNotNull((zbku) map3.get(numValueOf6))).zbb();
                        map3.remove(numValueOf6);
                    }
                    zbkuVar7.zba(new zboe(zbm.zba.zbb(zblc.zba(zbkxVarZbh, new zbkf() { // from class: com.google.mlkit.vision.text.pipeline.zbk
                        @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbkf
                        public final Object zba(Object obj) {
                            return ((zboi) obj).zbc();
                        }
                    })), zbf.zba(listZbc4, uprightRotationMatrix), listZbc4, zbg.zba(zbabjVar4.zbh().zbf()), (List) Preconditions.checkNotNull(zbkxVarZbh)));
                }
            }
            Iterator it = map3.values().iterator();
            while (it.hasNext()) {
                zbkx zbkxVarZbb = ((zbku) it.next()).zbb();
                int size = zbkxVarZbb.size();
                for (int i5 = 0; i5 < size; i5++) {
                    zboi zboiVar2 = (zboi) zbkxVarZbb.get(i5);
                    zbkuVar7.zba(new zboe(zboiVar2.zbc(), zboiVar2.zba(), zboiVar2.zbd(), zboiVar2.zbb(), zbkx.zbi(zboiVar2)));
                }
            }
            zbkx zbkxVarZbb2 = zbkuVar7.zbb();
            zba zbaVar = new zba(zbbVar, new zbok(zbm.zba.zbb(zblc.zba(zbkxVarZbb2, new zbkf() { // from class: com.google.mlkit.vision.text.pipeline.zbl
                @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbkf
                public final Object zba(Object obj) {
                    return ((zboe) obj).zba();
                }
            })), zbkxVarZbb2), zbkx.zbh(), z2);
            this.zbe = false;
            return zbaVar;
        } catch (MlKitException e) {
            return zbn.zbe(zbo.zbc(2, new RemoteException("Failed to process input image.".concat(String.valueOf(e.getMessage())))));
        }
    }

    public final zbo zbc() {
        if (this.zbb) {
            return new zbb(0, zbki.zbd());
        }
        zbh zbhVar = this.zba;
        if (zbhVar == null) {
            if (!AndroidAssetUtil.zba(this.zbc)) {
                Log.d("PipelineManager", "Failed to initiate native asset manager.");
            }
            VkpTextRecognizerOptions vkpTextRecognizerOptions = this.zbd;
            String strZba = vkpTextRecognizerOptions.zba();
            String strZbc = vkpTextRecognizerOptions.zbc();
            String strZbb = vkpTextRecognizerOptions.zbb();
            boolean zZbd = vkpTextRecognizerOptions.zbd();
            zbbz zbbzVarZbc = zbca.zbc();
            int i = zZbd ? 4 : 0;
            zbdl zbdlVarZba = zbdo.zba();
            zbbb zbbbVarZba = zbbe.zba();
            zbbbVarZba.zbd(strZbc);
            zbbbVarZba.zba(strZba);
            zbbbVarZba.zbe(true);
            zbbbVarZba.zbb(true);
            if (!strZbb.isEmpty()) {
                zbpf zbpfVarZba = zbpg.zba();
                zbpi zbpiVarZba = zbpk.zba();
                zbpiVarZba.zba(strZbb);
                zbpfVarZba.zba(zbpiVarZba);
                zbbbVarZba.zbc(zbpfVarZba);
            }
            zbdlVarZba.zbb(zbbbVarZba);
            int iZba = zbcv.zba(i);
            zbct zbctVarZba = zbcw.zba();
            zbctVarZba.zba(iZba);
            zbdlVarZba.zbc(zbctVarZba);
            zbiu zbiuVarZba = zbix.zba();
            zbiuVarZba.zba("PassThroughCoarseClassifier");
            zbdlVarZba.zba(zbiuVarZba);
            zbbzVarZbc.zba(zbdlVarZba);
            zbfb zbfbVarZba = zbfc.zba();
            zbfbVarZba.zba(2);
            zbbzVarZbc.zbb(zbfbVarZba);
            zbh zbhVar2 = new zbh((zbca) zbbzVarZbc.zbk(), this.zbd.zba(), "mlkit_google_ocr_pipeline");
            this.zba = zbhVar2;
            zbhVar = zbhVar2;
        }
        try {
            ((zbh) Preconditions.checkNotNull(zbhVar)).zbg();
            this.zbb = true;
            return new zbb(0, zbki.zbd());
        } catch (PipelineException e) {
            return zbo.zbc(1, new RemoteException("Failed to initialize detector. ".concat((String) e.getRootCauseMessage().zbb(""))));
        }
    }

    public final void zbd() {
        zbh zbhVar = this.zba;
        if (zbhVar != null) {
            if (this.zbb) {
                zbhVar.zbh();
            }
            this.zba.zbf();
            this.zba = null;
        }
        this.zbb = false;
        this.zbe = true;
    }
}
