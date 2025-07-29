package com.github.penfeizhou.animation.avif.decode;

import android.content.Context;
import com.github.penfeizhou.animation.avif.io.AVIFReader;
import com.github.penfeizhou.animation.io.Reader;
import com.github.penfeizhou.animation.io.StreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.aomedia.avif.android.AvifDecoder;

/* loaded from: classes3.dex */
public class AVIFParser {

    static class FormatException extends IOException {
        FormatException() {
            super("AVIF Format error");
        }
    }

    public static boolean isAVIF(String str) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            boolean zIsAVIF = isAVIF(new StreamReader(fileInputStream));
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return zIsAVIF;
        } catch (Exception unused2) {
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 == null) {
                return false;
            }
            try {
                fileInputStream2.close();
                return false;
            } catch (IOException e2) {
                e2.printStackTrace();
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static boolean isAVIF(Context context, String str) throws IOException {
        InputStream inputStreamOpen = null;
        try {
            inputStreamOpen = context.getAssets().open(str);
            boolean zIsAVIF = isAVIF(new StreamReader(inputStreamOpen));
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return zIsAVIF;
        } catch (Exception unused) {
            if (inputStreamOpen == null) {
                return false;
            }
            try {
                inputStreamOpen.close();
                return false;
            } catch (IOException e2) {
                e2.printStackTrace();
                return false;
            }
        } catch (Throwable th) {
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static boolean isAVIF(Context context, int i) throws IOException {
        InputStream inputStreamOpenRawResource = null;
        try {
            inputStreamOpenRawResource = context.getResources().openRawResource(i);
            boolean zIsAVIF = isAVIF(new StreamReader(inputStreamOpenRawResource));
            if (inputStreamOpenRawResource != null) {
                try {
                    inputStreamOpenRawResource.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return zIsAVIF;
        } catch (Exception unused) {
            if (inputStreamOpenRawResource == null) {
                return false;
            }
            try {
                inputStreamOpenRawResource.close();
                return false;
            } catch (IOException e2) {
                e2.printStackTrace();
                return false;
            }
        } catch (Throwable th) {
            if (inputStreamOpenRawResource != null) {
                try {
                    inputStreamOpenRawResource.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static boolean isAVIF(Reader reader) {
        try {
            return AvifDecoder.isAvifImage((reader instanceof AVIFReader ? (AVIFReader) reader : new AVIFReader(reader)).toDirectByteBuffer());
        } catch (IOException unused) {
            return false;
        }
    }
}
