package com.example.onetaplock;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {
    private DevicePolicyManager policyManager;
    private ComponentName adminComponent;
    private boolean lockRequested = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        policyManager = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
        adminComponent = new ComponentName(this, LockAdminReceiver.class);

        if (!policyManager.isAdminActive(adminComponent)) {
            Intent enableAdmin = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
            enableAdmin.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, adminComponent);
            enableAdmin.putExtra(
                DevicePolicyManager.EXTRA_ADD_EXPLANATION,
                "Enable One Tap Lock so tapping its app icon can lock your screen."
            );
            startActivity(enableAdmin);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!lockRequested && policyManager != null &&
                policyManager.isAdminActive(adminComponent)) {
            lockRequested = true;
            policyManager.lockNow();
            finish();
        }
    }
}
