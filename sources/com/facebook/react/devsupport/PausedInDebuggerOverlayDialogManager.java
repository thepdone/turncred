package com.facebook.react.devsupport;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.core.util.Supplier;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.R;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.PausedInDebuggerOverlayManager;

/* loaded from: classes4.dex */
class PausedInDebuggerOverlayDialogManager implements PausedInDebuggerOverlayManager {
    private final Supplier<Context> mContextSupplier;
    private Dialog mPausedInDebuggerDialog;

    public PausedInDebuggerOverlayDialogManager(Supplier<Context> supplier) {
        this.mContextSupplier = supplier;
    }

    @Override // com.facebook.react.devsupport.interfaces.PausedInDebuggerOverlayManager
    public void showPausedInDebuggerOverlay(final String str, final DevSupportManager.PausedInDebuggerOverlayCommandListener pausedInDebuggerOverlayCommandListener) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.devsupport.PausedInDebuggerOverlayDialogManager$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showPausedInDebuggerOverlay$1(pausedInDebuggerOverlayCommandListener, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPausedInDebuggerOverlay$1(final DevSupportManager.PausedInDebuggerOverlayCommandListener pausedInDebuggerOverlayCommandListener, String str) {
        Dialog dialog = this.mPausedInDebuggerDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        Context context = this.mContextSupplier.get();
        if (context == null) {
            return;
        }
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.paused_in_debugger_view, (ViewGroup) null);
        ((View) Assertions.assertNotNull(viewInflate.findViewById(R.id.button))).setOnClickListener(new View.OnClickListener() { // from class: com.facebook.react.devsupport.PausedInDebuggerOverlayDialogManager$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                pausedInDebuggerOverlayCommandListener.onResume();
            }
        });
        ((TextView) Assertions.assertNotNull((TextView) viewInflate.findViewById(R.id.button_text))).setText(str);
        Dialog dialog2 = new Dialog(context, R.style.NoAnimationDialog);
        this.mPausedInDebuggerDialog = dialog2;
        dialog2.setContentView(viewInflate);
        this.mPausedInDebuggerDialog.setCancelable(false);
        Window window = this.mPausedInDebuggerDialog.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.2f;
            window.setAttributes(attributes);
            window.addFlags(2);
            window.setGravity(48);
            window.setElevation(0.0f);
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setBackgroundDrawableResource(R.drawable.paused_in_debugger_background);
        }
        this.mPausedInDebuggerDialog.show();
    }

    @Override // com.facebook.react.devsupport.interfaces.PausedInDebuggerOverlayManager
    public void hidePausedInDebuggerOverlay() {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.devsupport.PausedInDebuggerOverlayDialogManager$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$hidePausedInDebuggerOverlay$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hidePausedInDebuggerOverlay$2() {
        Dialog dialog = this.mPausedInDebuggerDialog;
        if (dialog != null) {
            dialog.dismiss();
            this.mPausedInDebuggerDialog = null;
        }
    }
}
