package com.google.mlkit.vision.text.pipeline;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zbe extends VkpTextRecognizerOptions {
    private final String zba;
    private final String zbb;
    private final String zbc;
    private final boolean zbd;

    /* synthetic */ zbe(String str, String str2, String str3, boolean z, zbd zbdVar) {
        this.zba = str;
        this.zbb = str2;
        this.zbc = str3;
        this.zbd = z;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof VkpTextRecognizerOptions) {
            VkpTextRecognizerOptions vkpTextRecognizerOptions = (VkpTextRecognizerOptions) obj;
            if (this.zba.equals(vkpTextRecognizerOptions.zba()) && this.zbb.equals(vkpTextRecognizerOptions.zbc()) && this.zbc.equals(vkpTextRecognizerOptions.zbb()) && this.zbd == vkpTextRecognizerOptions.zbd()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (true != this.zbd ? 1237 : 1231) ^ ((((((this.zba.hashCode() ^ 1000003) * 1000003) ^ this.zbb.hashCode()) * 1000003) ^ this.zbc.hashCode()) * 1000003);
    }

    public final String toString() {
        return "VkpTextRecognizerOptions{configLabel=" + this.zba + ", modelDir=" + this.zbb + ", languageHint=" + this.zbc + ", enableLowLatencyInBackground=" + this.zbd + "}";
    }

    @Override // com.google.mlkit.vision.text.pipeline.VkpTextRecognizerOptions
    final String zba() {
        return this.zba;
    }

    @Override // com.google.mlkit.vision.text.pipeline.VkpTextRecognizerOptions
    final String zbb() {
        return this.zbc;
    }

    @Override // com.google.mlkit.vision.text.pipeline.VkpTextRecognizerOptions
    final String zbc() {
        return this.zbb;
    }

    @Override // com.google.mlkit.vision.text.pipeline.VkpTextRecognizerOptions
    final boolean zbd() {
        return this.zbd;
    }
}
