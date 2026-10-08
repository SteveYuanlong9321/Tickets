package com.google.mlkit.vision.text.pipeline;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class VkpTextRecognizerOptions {

    /* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
    public static abstract class Builder {
        public abstract VkpTextRecognizerOptions build();

        abstract Builder setConfigLabel(String str);

        public abstract Builder setEnableLowLatencyInBackground(boolean z);

        public abstract Builder setLanguageHint(String str);

        public abstract Builder setModelDir(String str);
    }

    public static Builder builder(String str, String str2, String str3) {
        zbc zbcVar = new zbc();
        zbcVar.setConfigLabel(str);
        if (str2 == null) {
            str2 = "mlkit-google-ocr-models";
        }
        zbcVar.setModelDir(str2);
        zbcVar.setLanguageHint(str3);
        zbcVar.setEnableLowLatencyInBackground(false);
        return zbcVar;
    }

    abstract String zba();

    abstract String zbb();

    abstract String zbc();

    abstract boolean zbd();
}
