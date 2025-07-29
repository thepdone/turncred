package com.facebook.react.devsupport;

import com.facebook.react.bridge.JavaOnlyArray;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.devsupport.interfaces.StackFrame;
import com.facebook.react.interfaces.exceptionmanager.ReactJsExceptionHandler;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class StackTraceHelper {
    public static final String COLUMN_KEY = "column";
    public static final String FILE_KEY = "file";
    public static final String ID_KEY = "id";
    public static final String IS_FATAL_KEY = "isFatal";
    public static final String LINE_NUMBER_KEY = "lineNumber";
    public static final String MESSAGE_KEY = "message";
    public static final String METHOD_NAME_KEY = "methodName";
    private static final Pattern STACK_FRAME_PATTERN1 = Pattern.compile("^(?:(.*?)@)?(.*?)\\:([0-9]+)\\:([0-9]+)$");
    private static final Pattern STACK_FRAME_PATTERN2 = Pattern.compile("\\s*(?:at)\\s*(.+?)\\s*[@(](.*):([0-9]+):([0-9]+)[)]$");
    public static final String STACK_KEY = "stack";

    public static class StackFrameImpl implements StackFrame {
        private final int mColumn;
        private final String mFile;
        private final String mFileName;
        private final boolean mIsCollapsed;
        private final int mLine;
        private final String mMethod;

        private StackFrameImpl(String str, String str2, int i, int i2, boolean z) {
            this.mFile = str;
            this.mMethod = str2;
            this.mLine = i;
            this.mColumn = i2;
            this.mFileName = str != null ? new File(str).getName() : "";
            this.mIsCollapsed = z;
        }

        private StackFrameImpl(String str, String str2, int i, int i2) {
            this(str, str2, i, i2, false);
        }

        private StackFrameImpl(String str, String str2, String str3, int i, int i2) {
            this.mFile = str;
            this.mFileName = str2;
            this.mMethod = str3;
            this.mLine = i;
            this.mColumn = i2;
            this.mIsCollapsed = false;
        }

        @Override // com.facebook.react.devsupport.interfaces.StackFrame
        public String getFile() {
            return this.mFile;
        }

        @Override // com.facebook.react.devsupport.interfaces.StackFrame
        public String getMethod() {
            return this.mMethod;
        }

        @Override // com.facebook.react.devsupport.interfaces.StackFrame
        public int getLine() {
            return this.mLine;
        }

        @Override // com.facebook.react.devsupport.interfaces.StackFrame
        public int getColumn() {
            return this.mColumn;
        }

        @Override // com.facebook.react.devsupport.interfaces.StackFrame
        public String getFileName() {
            return this.mFileName;
        }

        @Override // com.facebook.react.devsupport.interfaces.StackFrame
        public boolean isCollapsed() {
            return this.mIsCollapsed;
        }

        @Override // com.facebook.react.devsupport.interfaces.StackFrame
        public JSONObject toJSON() {
            return new JSONObject(MapBuilder.of("file", getFile(), "methodName", getMethod(), "lineNumber", Integer.valueOf(getLine()), "column", Integer.valueOf(getColumn()), "collapse", Boolean.valueOf(isCollapsed())));
        }
    }

    public static StackFrame[] convertJsStackTrace(ReadableArray readableArray) {
        int size = readableArray != null ? readableArray.size() : 0;
        StackFrame[] stackFrameArr = new StackFrame[size];
        for (int i = 0; i < size; i++) {
            ReadableType type = readableArray.getType(i);
            if (type == ReadableType.Map) {
                ReadableMap map = readableArray.getMap(i);
                String string = map.getString("methodName");
                stackFrameArr[i] = new StackFrameImpl(map.getString("file"), string, (!map.hasKey("lineNumber") || map.isNull("lineNumber")) ? -1 : map.getInt("lineNumber"), (!map.hasKey("column") || map.isNull("column")) ? -1 : map.getInt("column"), map.hasKey("collapse") && !map.isNull("collapse") && map.getBoolean("collapse"));
            } else if (type == ReadableType.String) {
                stackFrameArr[i] = new StackFrameImpl((String) null, readableArray.getString(i), -1, -1);
            }
        }
        return stackFrameArr;
    }

    public static StackFrame[] convertJsStackTrace(JSONArray jSONArray) throws JSONException {
        int length = jSONArray != null ? jSONArray.length() : 0;
        StackFrame[] stackFrameArr = new StackFrame[length];
        for (int i = 0; i < length; i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                stackFrameArr[i] = new StackFrameImpl(jSONObject.getString("file"), jSONObject.getString("methodName"), (!jSONObject.has("lineNumber") || jSONObject.isNull("lineNumber")) ? -1 : jSONObject.getInt("lineNumber"), (!jSONObject.has("column") || jSONObject.isNull("column")) ? -1 : jSONObject.getInt("column"), jSONObject.has("collapse") && !jSONObject.isNull("collapse") && jSONObject.getBoolean("collapse"));
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        return stackFrameArr;
    }

    public static StackFrame[] convertJsStackTrace(String str) {
        String[] strArrSplit = str.split("\n");
        StackFrame[] stackFrameArr = new StackFrame[strArrSplit.length];
        for (int i = 0; i < strArrSplit.length; i++) {
            Matcher matcher = STACK_FRAME_PATTERN1.matcher(strArrSplit[i]);
            Matcher matcher2 = STACK_FRAME_PATTERN2.matcher(strArrSplit[i]);
            if (matcher2.find()) {
                matcher = matcher2;
            } else {
                if (!matcher.find()) {
                    stackFrameArr[i] = new StackFrameImpl((String) null, strArrSplit[i], -1, -1);
                }
            }
            stackFrameArr[i] = new StackFrameImpl(matcher.group(2), matcher.group(1) == null ? "(unknown)" : matcher.group(1), Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)));
        }
        return stackFrameArr;
    }

    public static StackFrame[] convertJavaStackTrace(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StackFrame[] stackFrameArr = new StackFrame[stackTrace.length];
        for (int i = 0; i < stackTrace.length; i++) {
            stackFrameArr[i] = new StackFrameImpl(stackTrace[i].getClassName(), stackTrace[i].getFileName(), stackTrace[i].getMethodName(), stackTrace[i].getLineNumber(), -1);
        }
        return stackFrameArr;
    }

    public static String formatFrameSource(StackFrame stackFrame) {
        StringBuilder sb = new StringBuilder();
        sb.append(stackFrame.getFileName());
        int line = stackFrame.getLine();
        if (line > 0) {
            sb.append(":").append(line);
            int column = stackFrame.getColumn();
            if (column > 0) {
                sb.append(":").append(column);
            }
        }
        return sb.toString();
    }

    public static String formatStackTrace(String str, StackFrame[] stackFrameArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append("\n");
        for (StackFrame stackFrame : stackFrameArr) {
            sb.append(stackFrame.getMethod()).append("\n    ").append(formatFrameSource(stackFrame)).append("\n");
        }
        return sb.toString();
    }

    public static JavaOnlyMap convertParsedError(ReactJsExceptionHandler.ParsedError parsedError) {
        List<ReactJsExceptionHandler.ParsedError.StackFrame> frames = parsedError.getFrames();
        ArrayList arrayList = new ArrayList();
        for (ReactJsExceptionHandler.ParsedError.StackFrame stackFrame : frames) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            javaOnlyMap.putDouble("column", stackFrame.getColumnNumber());
            javaOnlyMap.putDouble("lineNumber", stackFrame.getLineNumber());
            javaOnlyMap.putString("file", stackFrame.getFileName());
            javaOnlyMap.putString("methodName", stackFrame.getMethodName());
            arrayList.add(javaOnlyMap);
        }
        JavaOnlyMap javaOnlyMap2 = new JavaOnlyMap();
        javaOnlyMap2.putString("message", parsedError.getMessage());
        javaOnlyMap2.putArray(STACK_KEY, JavaOnlyArray.from(arrayList));
        javaOnlyMap2.putInt("id", parsedError.getExceptionId());
        javaOnlyMap2.putBoolean(IS_FATAL_KEY, parsedError.isFatal());
        return javaOnlyMap2;
    }
}
