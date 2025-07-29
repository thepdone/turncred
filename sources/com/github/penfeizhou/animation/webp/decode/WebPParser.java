package com.github.penfeizhou.animation.webp.decode;

import android.content.Context;
import com.github.penfeizhou.animation.io.Reader;
import com.github.penfeizhou.animation.io.StreamReader;
import com.github.penfeizhou.animation.webp.io.WebPReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class WebPParser {

    static class FormatException extends IOException {
        FormatException() {
            super("WebP Format error");
        }
    }

    public static boolean isAWebP(String str) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            boolean zIsAWebP = isAWebP(new StreamReader(fileInputStream));
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return zIsAWebP;
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

    public static boolean isAWebP(Context context, String str) throws IOException {
        InputStream inputStreamOpen = null;
        try {
            inputStreamOpen = context.getAssets().open(str);
            boolean zIsAWebP = isAWebP(new StreamReader(inputStreamOpen));
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return zIsAWebP;
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

    public static boolean isAWebP(Context context, int i) throws IOException {
        InputStream inputStreamOpenRawResource = null;
        try {
            inputStreamOpenRawResource = context.getResources().openRawResource(i);
            boolean zIsAWebP = isAWebP(new StreamReader(inputStreamOpenRawResource));
            if (inputStreamOpenRawResource != null) {
                try {
                    inputStreamOpenRawResource.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return zIsAWebP;
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

    public static boolean isAWebP(Reader reader) {
        WebPReader webPReader = reader instanceof WebPReader ? (WebPReader) reader : new WebPReader(reader);
        try {
        } catch (IOException e) {
            if (!(e instanceof FormatException)) {
                e.printStackTrace();
            }
        }
        if (!webPReader.matchFourCC("RIFF")) {
            return false;
        }
        webPReader.skip(4L);
        if (!webPReader.matchFourCC("WEBP")) {
            return false;
        }
        while (webPReader.available() > 0) {
            BaseChunk chunk = parseChunk(webPReader);
            if (chunk instanceof VP8XChunk) {
                return ((VP8XChunk) chunk).animation();
            }
        }
        return false;
    }

    public static List<BaseChunk> parse(WebPReader webPReader) throws IOException {
        if (!webPReader.matchFourCC("RIFF")) {
            throw new FormatException();
        }
        webPReader.skip(4L);
        if (!webPReader.matchFourCC("WEBP")) {
            throw new FormatException();
        }
        ArrayList arrayList = new ArrayList();
        while (webPReader.available() > 0) {
            arrayList.add(parseChunk(webPReader));
        }
        return arrayList;
    }

    static BaseChunk parseChunk(WebPReader webPReader) throws IOException {
        BaseChunk baseChunk;
        int iPosition = webPReader.position();
        int fourCC = webPReader.getFourCC();
        int uInt32 = webPReader.getUInt32();
        if (VP8XChunk.ID == fourCC) {
            baseChunk = new VP8XChunk();
        } else if (ANIMChunk.ID == fourCC) {
            baseChunk = new ANIMChunk();
        } else if (ANMFChunk.ID == fourCC) {
            baseChunk = new ANMFChunk();
        } else if (ALPHChunk.ID == fourCC) {
            baseChunk = new ALPHChunk();
        } else if (VP8Chunk.ID == fourCC) {
            baseChunk = new VP8Chunk();
        } else if (VP8LChunk.ID == fourCC) {
            baseChunk = new VP8LChunk();
        } else if (ICCPChunk.ID == fourCC) {
            baseChunk = new ICCPChunk();
        } else if (XMPChunk.ID == fourCC) {
            baseChunk = new XMPChunk();
        } else if (EXIFChunk.ID == fourCC) {
            baseChunk = new EXIFChunk();
        } else {
            baseChunk = new BaseChunk();
        }
        baseChunk.chunkFourCC = fourCC;
        baseChunk.payloadSize = uInt32;
        baseChunk.offset = iPosition;
        baseChunk.parse(webPReader);
        return baseChunk;
    }
}
