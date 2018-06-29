package onlyleo.telegram.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import onlyleo.telegram.messenger.AndroidUtilities;
import onlyleo.telegram.messenger.LocaleController;
import onlyleo.telegram.messenger.MessagesController;
import onlyleo.telegram.messenger.R;
import onlyleo.telegram.tgnet.ConnectionsManager;
import onlyleo.telegram.tgnet.RequestDelegate;
import onlyleo.telegram.tgnet.TLObject;
import onlyleo.telegram.tgnet.TLRPC;
import onlyleo.telegram.ui.ActionBar.AlertDialog;
import onlyleo.telegram.ui.ActionBar.Theme;
import onlyleo.telegram.ui.Components.BetterRatingView;
import onlyleo.telegram.ui.Components.LayoutHelper;
import onlyleo.telegram.ui.Components.voip.VoIPHelper;

public class VoIPFeedbackActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
		super.onCreate(savedInstanceState);

		overridePendingTransition(0, 0);

		setContentView(new View(this));

		VoIPHelper.showRateAlert(this, new Runnable(){
			@Override
			public void run(){
				finish();
			}
		}, getIntent().getLongExtra("call_id", 0), getIntent().getLongExtra("call_access_hash", 0));
	}

	@Override
	public void finish() {
		super.finish();
		overridePendingTransition(0, 0);
	}
}
