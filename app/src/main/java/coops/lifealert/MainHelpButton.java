package coops.lifealert;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import java.io.IOException;
import com.google.android.gms.gcm.GoogleCloudMessaging;


public class MainHelpButton extends AppCompatActivity {

    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    private static final String TAG = "MainHelpButton";

    private BroadcastReceiver mRegistrationBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_help_button);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Toast.makeText(this, "Token Generated!", Toast.LENGTH_SHORT).show();
        mRegistrationBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                SharedPreferences sharedPreferences =
                        PreferenceManager.getDefaultSharedPreferences(context);
                boolean sentToken = sharedPreferences
                        .getBoolean(QuickstartPreferences.SENT_TOKEN_TO_SERVER, false);
                if (sentToken) {
                    Toast.makeText(MainHelpButton.this, getString(R.string.gcm_send_message),
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainHelpButton.this, getString(R.string.token_error_message),
                            Toast.LENGTH_SHORT).show();
                }
            }
        };

//        if (checkPlayServices()) {
//            // Start IntentService to register this application with GCM.
//            Intent intent = new Intent(this, RegistrationIntentService.class);
//            startService(intent);
//        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
                new IntentFilter(QuickstartPreferences.REGISTRATION_COMPLETE));
    }

    @Override
    protected void onPause() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mRegistrationBroadcastReceiver);
        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_help_button, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    private boolean checkPlayServices() {
//        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
//        int resultCode = apiAvailability.isGooglePlayServicesAvailable(this);
//        if (resultCode != ConnectionResult.SUCCESS) {
//            if (apiAvailability.isUserResolvableError(resultCode)) {
//                apiAvailability.getErrorDialog(this, resultCode, PLAY_SERVICES_RESOLUTION_REQUEST)
//                        .show();
//            } else {
//                Log.i(TAG, "This device is not supported.");
//                finish();
//            }
//            return false;
//        }
//        return true;
//    }

    private void doGcmSendUpstreamMessage() {
    /*    final Activity activity = this;
        final GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(activity);
        final String senderId = getValue(R.id.upstream_sender_id);
        final String msgId = getValue(R.id.upstream_message_id);
        final String ttl = getValue(R.id.upstream_ttl);
        final Bundle data = new Bundle();
        EditableMapView dataView = (EditableMapView) activity.findViewById(R.id.upstream_data);
        for (EditableMapView.MapEntry entry : dataView.getMapEntries()) {
            data.putString(entry.key, entry.value);
        }

        if (senderId.equals(getString(R.string.upstream_sender_id_hint))) {
            Toast.makeText(activity, R.string.upstream_sender_id_not_select, Toast.LENGTH_SHORT)
                    .show();
            return;
        }

        if (msgId.equals("")) {
            Toast.makeText(activity, R.string.upstream_message_id_not_provided, Toast.LENGTH_SHORT)
                    .show();
            return;
        }*/
    }

    public void sendForHelp(View view) {
        final GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);
        String msg = "Message Sent!";
//        try {
//            Bundle data = new Bundle();
//            data.putString("username", QuickstartPreferences.USERNAME);
//            data.putString("location", QuickstartPreferences.LOCATION);
//            data.putString("issue", QuickstartPreferences.ISSUE);
//            String id = Integer.toString(12);
//            gcm.send("lifealert-398b" + "@gcm.googleapis.com", id, data);
//            msg = "Message Sent!";
//        } catch (IOException ex) {
//            msg = "Error :" + ex.getMessage();
//
//        }
        Toast.makeText(MainHelpButton.this, msg, Toast.LENGTH_SHORT).show();

    }
}
