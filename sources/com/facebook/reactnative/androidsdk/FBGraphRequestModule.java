package com.facebook.reactnative.androidsdk;

import android.os.Bundle;
import android.util.SparseArray;
import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ReactModule(name = FBGraphRequestModule.NAME)
/* loaded from: classes3.dex */
public class FBGraphRequestModule extends ReactContextBaseJavaModule {
    public static final String NAME = "FBGraphRequest";
    private SparseArray<WritableMap> mResponses;

    private class GraphRequestBatchCallback implements GraphRequestBatch.Callback {
        private int mBatchID;
        private Callback mCallback;

        public GraphRequestBatchCallback(int i, Callback callback) {
            this.mBatchID = i;
            this.mCallback = callback;
        }

        @Override // com.facebook.GraphRequestBatch.Callback
        public void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString("result", "batch finished executing or timed out");
            this.mCallback.invoke(null, writableMapCreateMap, FBGraphRequestModule.this.mResponses.get(this.mBatchID));
            FBGraphRequestModule.this.mResponses.remove(this.mBatchID);
        }
    }

    private class GraphRequestCallback implements GraphRequest.Callback {
        private int mBatchID;
        private String mIndex;

        public GraphRequestCallback(int i, int i2) {
            this.mIndex = String.valueOf(i);
            this.mBatchID = i2;
        }

        @Override // com.facebook.GraphRequest.Callback
        public void onCompleted(GraphResponse graphResponse) {
            WritableArray writableArrayCreateArray = Arguments.createArray();
            writableArrayCreateArray.pushMap(FBGraphRequestModule.this.buildFacebookRequestError(graphResponse.getError()));
            writableArrayCreateArray.pushMap(FBGraphRequestModule.this.buildGraphResponse(graphResponse));
            ((WritableMap) FBGraphRequestModule.this.mResponses.get(this.mBatchID)).putArray(this.mIndex, writableArrayCreateArray);
        }
    }

    public FBGraphRequestModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mResponses = new SparseArray<>();
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void start(ReadableArray readableArray, int i, Callback callback) {
        int i2;
        int i3;
        GraphRequestBatch graphRequestBatch = new GraphRequestBatch();
        synchronized (this) {
            i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (this.mResponses.get(i3) == null) {
                    break;
                } else {
                    i3 = i4;
                }
            }
            this.mResponses.put(i3, Arguments.createMap());
        }
        for (i2 = 0; i2 < readableArray.size(); i2++) {
            GraphRequest graphRequestBuildRequest = buildRequest(readableArray.getMap(i2));
            graphRequestBuildRequest.setCallback(new GraphRequestCallback(i2, i3));
            graphRequestBatch.add(graphRequestBuildRequest);
        }
        graphRequestBatch.setTimeout(i);
        graphRequestBatch.addCallback(new GraphRequestBatchCallback(i3, callback));
        graphRequestBatch.executeAsync();
    }

    private GraphRequest buildRequest(ReadableMap readableMap) {
        GraphRequest graphRequest = new GraphRequest();
        graphRequest.setGraphPath(readableMap.getString("graphPath"));
        setConfig(graphRequest, readableMap.getMap("config"));
        return graphRequest;
    }

    private void setConfig(GraphRequest graphRequest, ReadableMap readableMap) {
        if (readableMap == null) {
            graphRequest.setAccessToken(AccessToken.getCurrentAccessToken());
            return;
        }
        if (readableMap.hasKey("parameters")) {
            graphRequest.setParameters(buildParameters(readableMap.getMap("parameters")));
        }
        if (readableMap.hasKey("httpMethod")) {
            graphRequest.setHttpMethod(HttpMethod.valueOf(readableMap.getString("httpMethod")));
        }
        if (readableMap.hasKey("version")) {
            graphRequest.setVersion(readableMap.getString("version"));
        }
        if (readableMap.hasKey(SDKConstants.PARAM_ACCESS_TOKEN)) {
            graphRequest.setAccessToken(new AccessToken(readableMap.getString(SDKConstants.PARAM_ACCESS_TOKEN), AccessToken.getCurrentAccessToken().getApplicationId(), AccessToken.getCurrentAccessToken().getUserId(), null, null, null, null, null, null, null));
        } else {
            graphRequest.setAccessToken(AccessToken.getCurrentAccessToken());
        }
    }

    private Bundle buildParameters(ReadableMap readableMap) {
        Bundle bundle = new Bundle();
        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = readableMap.keySetIterator();
        while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
            ReadableMap map = readableMap.getMap(strNextKey);
            if (map.hasKey("string")) {
                bundle.putString(strNextKey, map.getString("string"));
            }
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WritableMap buildFacebookRequestError(FacebookRequestError facebookRequestError) {
        if (facebookRequestError == null) {
            return null;
        }
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt("requestStatusCode", facebookRequestError.getRequestStatusCode());
        writableMapCreateMap.putInt("errorCode", facebookRequestError.getErrorCode());
        writableMapCreateMap.putInt("subErrorCode", facebookRequestError.getSubErrorCode());
        if (facebookRequestError.getErrorType() != null) {
            writableMapCreateMap.putString("errorType", facebookRequestError.getErrorType());
        }
        if (facebookRequestError.getErrorMessage() != null) {
            writableMapCreateMap.putString("errorMessage", facebookRequestError.getErrorMessage());
        }
        if (facebookRequestError.getErrorUserTitle() != null) {
            writableMapCreateMap.putString("errorUserTitle", facebookRequestError.getErrorUserTitle());
        }
        if (facebookRequestError.getErrorUserMessage() != null) {
            writableMapCreateMap.putString("errorUserMessage", facebookRequestError.getErrorUserMessage());
        }
        if (facebookRequestError.getRequestResultBody() != null) {
            writableMapCreateMap.putString("requestResultBody", facebookRequestError.getRequestResultBody().toString());
        }
        if (facebookRequestError.getRequestResult() != null) {
            writableMapCreateMap.putString("requestResult", facebookRequestError.getRequestResult().toString());
        }
        if (facebookRequestError.getBatchRequestResult() != null) {
            writableMapCreateMap.putString("batchRequestResult", facebookRequestError.getBatchRequestResult().toString());
        }
        if (facebookRequestError.getException() != null) {
            writableMapCreateMap.putString("exception", facebookRequestError.getException().toString());
        }
        return writableMapCreateMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WritableMap buildGraphResponse(GraphResponse graphResponse) {
        if (graphResponse.getGraphObject() != null) {
            return convertJSONObject(graphResponse.getGraphObject());
        }
        return Arguments.createMap();
    }

    private WritableArray convertJSONArray(JSONArray jSONArray) throws JSONException {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                Object obj = jSONArray.get(i);
                if (obj instanceof JSONObject) {
                    writableArrayCreateArray.pushMap(convertJSONObject((JSONObject) obj));
                } else if (obj instanceof JSONArray) {
                    writableArrayCreateArray.pushArray(convertJSONArray((JSONArray) obj));
                } else if (obj instanceof String) {
                    writableArrayCreateArray.pushString((String) obj);
                } else if (obj instanceof Integer) {
                    writableArrayCreateArray.pushInt(((Integer) obj).intValue());
                } else if (obj instanceof Boolean) {
                    writableArrayCreateArray.pushBoolean(((Boolean) obj).booleanValue());
                } else if (obj instanceof Double) {
                    writableArrayCreateArray.pushDouble(((Double) obj).doubleValue());
                }
            } catch (JSONException unused) {
            }
        }
        return writableArrayCreateArray;
    }

    private WritableMap convertJSONObject(JSONObject jSONObject) throws JSONException {
        WritableMap writableMapCreateMap = Arguments.createMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                Object obj = jSONObject.get(next);
                if (obj instanceof JSONObject) {
                    writableMapCreateMap.putMap(next, convertJSONObject((JSONObject) obj));
                } else if (obj instanceof JSONArray) {
                    writableMapCreateMap.putArray(next, convertJSONArray((JSONArray) obj));
                } else if (obj instanceof String) {
                    writableMapCreateMap.putString(next, (String) obj);
                } else if (obj instanceof Integer) {
                    writableMapCreateMap.putInt(next, ((Integer) obj).intValue());
                } else if (obj instanceof Boolean) {
                    writableMapCreateMap.putBoolean(next, ((Boolean) obj).booleanValue());
                } else if (obj instanceof Double) {
                    writableMapCreateMap.putDouble(next, ((Double) obj).doubleValue());
                }
            } catch (JSONException unused) {
            }
        }
        return writableMapCreateMap;
    }
}
