package com.example.jojolauncher;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.view.MenuItem;
import android.content.Intent;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.ComponentName;
import android.widget.ImageView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.widget.EditText;
import android.text.InputType;
import android.content.DialogInterface;







public class MainActivity extends AppCompatActivity {


    int secretButtonClickCount=0;
    private String m_Text = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        // Hide Status Bar
        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        
        /// Set Icons ///

        // Yammer
        ImageView chromeIcon = (ImageView) findViewById(R.id.ImageViewYammer);
        chromeIcon.setImageDrawable(getActivityIcon(this,"com.yammer.v1","com.yammer.droid.ui.LauncherActivity"));

        // Microsoft Nav
        ImageView navIcon = (ImageView) findViewById(R.id.imageViewNAV);
        //navIcon.setImageDrawable(getActivityIcon(this,"com.microsoft.dynamics.nav","com.microsoft.dynamics.nav.MainActivity"));
        navIcon.setImageResource(R.mipmap.navicon);


        // Microsoft Outlook
        ImageView mailIcon = (ImageView) findViewById(R.id.imageViewEmail);
        mailIcon.setImageDrawable(getActivityIcon(this,"com.microsoft.office.outlook","com.microsoft.office.outlook.MainActivity"));

        // Camera App
        ImageView cameraIcon = (ImageView) findViewById(R.id.imageViewCamera);
        cameraIcon.setImageDrawable(getActivityIcon(this,"com.sec.android.app.camera","com.sec.android.app.camera.Camera"));

        // Gallery App
        ImageView galleryIcon = (ImageView) findViewById(R.id.imageViewGallery);
        galleryIcon.setImageDrawable(getActivityIcon(this,"com.sec.android.gallery3d","com.sec.android.gallery3d.app.GalleryOpaqueActivity"));

        // Intranet (Internet)
        ImageView intranetIcon = (ImageView) findViewById(R.id.imageViewIntranet);
        intranetIcon.setImageDrawable(getActivityIcon(this,"com.sec.android.app.sbrowser","com.sec.android.app.sbrowser.SBrowserMainActivity"));


        // ScreenConnect Control App
        ImageView controlIcon = (ImageView) findViewById(R.id.imageViewControl);
        controlIcon.setImageDrawable(getActivityIcon(this,"com.screenconnect.androidclient","com.screenconnect.androidclient.WebActivity"));
    }

    /// After User Has Navigated Away From JoJo Launcher We Need To Re-Hide StatusBar, So We Call OnResume ///
    @Override
    public void onResume(){
        super.onResume();
        // Hide Status Bar
        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

    }

    // Grab Icons from Android System
    public static Drawable getActivityIcon(Context context, String packageName, String activityName) {
        PackageManager pm = context.getPackageManager();
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(packageName, activityName));
        ResolveInfo resolveInfo = pm.resolveActivity(intent, 0);

        return resolveInfo.loadIcon(pm);
    }

    /// Button Actions ///

    // Yammer App
    public void onYammerButtonClick(View v) {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.yammer.v1");
        startActivity(launchIntent);
    }

    // NAV App
    public void onNavButtonClick(View v) {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.microsoft.dynamics.nav");
        startActivity(launchIntent);
    }

    // Email App
    public void onEmailButtonClick(View v) {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.microsoft.office.outlook");
        startActivity(launchIntent);
    }

    // Camera App
    public void onCameraButtonClick(View v) {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.sec.android.app.camera");
        startActivity(launchIntent);
    }

    // Gallery App
    public void ongalleryButtonClick(View v) {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.sec.android.gallery3d");
        startActivity(launchIntent);
    }

    // Internet App
    public void onintranetButtonClick(View v) {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.sec.android.app.sbrowser");
        startActivity(launchIntent);
    }
    // ScreenConnect App
    public void onControlButtonClick(View v) {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.screenconnect.androidclient");
        startActivity(launchIntent);
    }

    // Secret Button
    public void onSecretButtonClick(View v) {
        secretButtonClickCount=secretButtonClickCount+1;
        if (secretButtonClickCount == 8) {
            Toast.makeText(getApplicationContext(),"2 More Clicks", Toast.LENGTH_LONG).show();
        }
        if (secretButtonClickCount == 9) {
            Toast.makeText(getApplicationContext(),"1 More Click", Toast.LENGTH_LONG).show();
        }

        if(secretButtonClickCount==10)
        {
            // Show Developer Message
            Toast.makeText(getApplicationContext(),"Developer Mode", Toast.LENGTH_LONG).show();
            secretButtonClickCount = 0;

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Enter Password");

            // Set Up The Input
            final EditText input = new EditText(this);

            // Specify The Type Of Input Expected! (Password Masks The Input)
            input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            builder.setView(input);

            // Set Up The Buttons
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    m_Text = input.getText().toString();

                    // Check Password & If Match Then Quit App
                    if (m_Text.equals("belly-zR82LS")) {

                        // Show Quitting Message
                        Log.d("myTag", "Quitting App");
                        Toast.makeText(getApplicationContext(),"Quitting", Toast.LENGTH_LONG).show();

                        // Quit App
//                        moveTaskToBack(true);
//                        android.os.Process.killProcess(android.os.Process.myPid());
//                        System.exit(1);


                        // Enable Launcher Chooser
                        getPackageManager().clearPackagePreferredActivities(getPackageName());
                        finish();
                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);

                    }
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            builder.show();
        }
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
}
