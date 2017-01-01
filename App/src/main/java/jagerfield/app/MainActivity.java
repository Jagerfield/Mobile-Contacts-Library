package jagerfield.app;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import jagerfield.app.ContactList.ListFragment.ContactListFragment;
import jagerfield.mobilecontactslibrary.R;
import utilities.lib.AppUtilities;
import utilities.lib.PermissionsUtil.PermissionsUtil;
import utilities.lib.PermissionsUtil.Results.IGetPermissionResult;


public class MainActivity extends AppCompatActivity {
    private static final int READ_CONTACT_PERMISSION_REQUEST_CODE = 76;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPermission();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

    }

    private void launchFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.root_container, new ContactListFragment())
                .commit();
    }

    private void checkPermission()
    {
        PermissionsUtil permissionsUtil = AppUtilities.getPermissionUtil(MainActivity.this);
        IGetPermissionResult result = permissionsUtil.getPermissionResults(Manifest.permission.READ_CONTACTS);

        if (result.arePermissionsGranted())
        {
            launchFragment();
        }
        else
        {
            permissionsUtil.requestPermissions(Manifest.permission.READ_CONTACTS);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults)
    {
        PermissionsUtil permissionsUtil = AppUtilities.getPermissionUtil(MainActivity.this);

        if (requestCode == permissionsUtil.getPermissionsReqCodeId())
        {
            IGetPermissionResult result = null;
            result = permissionsUtil.getPermissionResults(Manifest.permission.READ_CONTACTS);
            if (result == null)
            {
                return;
            }
            else
            {
                if (result.arePermissionsGranted())
                {
                    launchFragment();
                }
                else
                {
                    return;
                }
            }
        }
    }
}
