package com.github.penfeizhou.animation.apng.decode;

import android.content.Context;
import com.github.penfeizhou.animation.apng.io.APNGReader;
import com.github.penfeizhou.animation.io.Reader;
import com.github.penfeizhou.animation.io.StreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class APNGParser {

    static class FormatException extends IOException {
        FormatException() {
            super("APNG Format error");
        }
    }

    public static boolean isAPNG(String str) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            boolean zIsAPNG = isAPNG(new StreamReader(fileInputStream));
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return zIsAPNG;
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

    public static boolean isAPNG(Context context, String str) throws IOException {
        InputStream inputStreamOpen = null;
        try {
            inputStreamOpen = context.getAssets().open(str);
            boolean zIsAPNG = isAPNG(new StreamReader(inputStreamOpen));
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return zIsAPNG;
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

    public static boolean isAPNG(Context context, int i) throws IOException {
        InputStream inputStreamOpenRawResource = null;
        try {
            inputStreamOpenRawResource = context.getResources().openRawResource(i);
            boolean zIsAPNG = isAPNG(new StreamReader(inputStreamOpenRawResource));
            if (inputStreamOpenRawResource != null) {
                try {
                    inputStreamOpenRawResource.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return zIsAPNG;
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

    public static boolean isAPNG(Reader reader) throws FormatException {
        APNGReader aPNGReader = reader instanceof APNGReader ? (APNGReader) reader : new APNGReader(reader);
        try {
            if (!aPNGReader.matchFourCC("\u0089PNG") || !aPNGReader.matchFourCC("\r\n\u001a\n")) {
                throw new FormatException();
            }
            while (aPNGReader.available() > 0) {
                if (parseChunk(aPNGReader) instanceof ACTLChunk) {
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            if (e instanceof FormatException) {
                return false;
            }
            e.printStackTrace();
            return false;
        }
    }

    public static List<Chunk> parse(APNGReader aPNGReader) throws IOException {
        if (!aPNGReader.matchFourCC("\u0089PNG") || !aPNGReader.matchFourCC("\r\n\u001a\n")) {
            throw new FormatException();
        }
        ArrayList arrayList = new ArrayList();
        while (aPNGReader.available() > 0) {
            arrayList.add(parseChunk(aPNGReader));
        }
        return arrayList;
    }

    private static Chunk parseChunk(APNGReader aPNGReader) throws IOException {
        Chunk chunk;
        int iPosition = aPNGReader.position();
        int i = aPNGReader.readInt();
        int fourCC = aPNGReader.readFourCC();
        if (fourCC == ACTLChunk.ID) {
            chunk = new ACTLChunk();
        } else if (fourCC == FCTLChunk.ID) {
            chunk = new FCTLChunk();
        } else if (fourCC == FDATChunk.ID) {
            chunk = new FDATChunk();
        } else if (fourCC == IDATChunk.ID) {
            chunk = new IDATChunk();
        } else if (fourCC == IENDChunk.ID) {
            chunk = new IENDChunk();
        } else if (fourCC == IHDRChunk.ID) {
            chunk = new IHDRChunk();
        } else {
            chunk = new Chunk();
        }
        chunk.offset = iPosition;
        chunk.fourcc = fourCC;
        chunk.length = i;
        chunk.parse(aPNGReader);
        chunk.crc = aPNGReader.readInt();
        return chunk;
    }
}
