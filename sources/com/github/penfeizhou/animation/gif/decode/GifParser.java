package com.github.penfeizhou.animation.gif.decode;

import android.content.Context;
import com.github.penfeizhou.animation.gif.io.GifReader;
import com.github.penfeizhou.animation.io.Reader;
import com.github.penfeizhou.animation.io.StreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class GifParser {

    static class FormatException extends IOException {
        FormatException() {
            super("Gif Format error");
        }
    }

    public static boolean isGif(String str) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            boolean zIsGif = isGif(new StreamReader(fileInputStream));
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return zIsGif;
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

    public static boolean isGif(Context context, String str) throws IOException {
        InputStream inputStreamOpen = null;
        try {
            inputStreamOpen = context.getAssets().open(str);
            boolean zIsGif = isGif(new StreamReader(inputStreamOpen));
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return zIsGif;
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

    public static boolean isGif(Context context, int i) throws IOException {
        InputStream inputStreamOpenRawResource = null;
        try {
            inputStreamOpenRawResource = context.getResources().openRawResource(i);
            boolean zIsGif = isGif(new StreamReader(inputStreamOpenRawResource));
            if (inputStreamOpenRawResource != null) {
                try {
                    inputStreamOpenRawResource.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return zIsGif;
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

    public static boolean isGif(Reader reader) {
        try {
            checkHeader(reader instanceof GifReader ? (GifReader) reader : new GifReader(reader));
            return true;
        } catch (IOException e) {
            if (e instanceof FormatException) {
                return false;
            }
            e.printStackTrace();
            return false;
        }
    }

    public static List<Block> parse(GifReader gifReader) throws IOException {
        Block blockRetrieve;
        checkHeader(gifReader);
        ArrayList arrayList = new ArrayList();
        LogicalScreenDescriptor logicalScreenDescriptor = new LogicalScreenDescriptor();
        logicalScreenDescriptor.receive(gifReader);
        arrayList.add(logicalScreenDescriptor);
        if (logicalScreenDescriptor.gColorTableFlag()) {
            ColorTable colorTable = new ColorTable(logicalScreenDescriptor.gColorTableSize());
            colorTable.receive(gifReader);
            arrayList.add(colorTable);
        }
        while (true) {
            try {
                byte bPeek = gifReader.peek();
                if (bPeek == 59) {
                    break;
                }
                if (bPeek == 33) {
                    blockRetrieve = ExtensionBlock.retrieve(gifReader);
                } else {
                    blockRetrieve = bPeek != 44 ? null : new ImageDescriptor();
                }
                if (blockRetrieve != null) {
                    blockRetrieve.receive(gifReader);
                    arrayList.add(blockRetrieve);
                } else {
                    throw new FormatException();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    private static void checkHeader(GifReader gifReader) throws IOException {
        byte bPeek;
        if (gifReader.peek() != 71 || gifReader.peek() != 73 || gifReader.peek() != 70 || gifReader.peek() != 56 || (((bPeek = gifReader.peek()) != 55 && bPeek != 57) || gifReader.peek() != 97)) {
            throw new FormatException();
        }
    }
}
