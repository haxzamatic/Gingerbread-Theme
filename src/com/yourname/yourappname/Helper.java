package com.yourname.yourappname;

import android.app.Activity;
import android.app.AlertDialog;
import android.net.Uri;
import android.os.Bundle;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Helper extends Activity {	
        
        private Button cmtheme, adwtheme, wallpaper, web, marketinfo, filebugs, lpsetting;
        
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.helper);
                
        cmtheme = (Button) findViewById(R.id.cmtheme);
        cmtheme.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                	try {
                		Intent intent = new Intent(Intent.ACTION_MAIN);
                    	intent.setComponent(new ComponentName("com.tmobile.themechooser","com.tmobile.themechooser.ThemeChooser"));
                    	startActivity(intent);
                	} 
                	catch (ActivityNotFoundException e) {
                		AlertDialog.Builder alert = new AlertDialog.Builder(Helper.this);

                		alert.setTitle("App Not Found");
                		alert.setMessage("This feature requires a custom ROM like Cyanogen Mod! Do you want to visit Cyanogen Mod webpage for more info?");
                		alert.setIcon(R.drawable.themechooser_icon);
                		alert.setPositiveButton("Yes",
                		 new DialogInterface.OnClickListener() {
                		  public void onClick(DialogInterface dialog, int id) {
                			  final Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://www.cyanogenmod.com/"));
                      		  startActivity(intent);
                		  }
                		 });
                		alert.setNegativeButton("No",
                		 new DialogInterface.OnClickListener() {
                		  public void onClick(DialogInterface dialog, int id) {
                		   Toast.makeText(Helper.this, "Y U NO BACON?!?", Toast.LENGTH_SHORT).show();
                		  }
                		 });

                		alert.show();
                	}
                }
        });
        
        adwtheme = (Button) findViewById(R.id.adwtheme);
        adwtheme.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                	try {
                		Intent intent = new Intent("org.adw.launcher.SET_THEME");
                        intent.putExtra("org.adw.launcher.theme.NAME","com.yourname.yourappname");
                        startActivity(Intent.createChooser(intent,"ADW Not Installed"));
                	} 
                	catch (ActivityNotFoundException e) {
                		AlertDialog.Builder alert = new AlertDialog.Builder(Helper.this);

                		alert.setTitle("ADW Not Found");
                		alert.setMessage("Do you want to vist the ADW Launcher Android Market page?");
                		alert.setIcon(R.drawable.adwex_icon);
                		alert.setPositiveButton("Yes",
                		 new DialogInterface.OnClickListener() {
                		  public void onClick(DialogInterface dialog, int id) {
                			  final Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("market://details?id=org.adwfreak.launcher"));
                      		  startActivity(intent);
                		  }
                		 });
                		alert.setNegativeButton("No",
                		 new DialogInterface.OnClickListener() {
                		  public void onClick(DialogInterface dialog, int id) {
                		   Toast.makeText(Helper.this, "There's too many shirtcuts anyway...", Toast.LENGTH_SHORT).show();
                		  }
                		 });

                		alert.show();
                	}
                }
        });
        
        lpsetting = (Button) findViewById(R.id.lpsetting);
        lpsetting.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                	try {
                		Intent intent = new Intent(Intent.ACTION_MAIN);
                    	intent.setComponent(new ComponentName("com.fede.launcher","com.fede.launcher.LauncherPreferencesActivity"));
                    	startActivity(intent);
                	} 
                	catch (ActivityNotFoundException e) {
                		AlertDialog.Builder alert = new AlertDialog.Builder(Helper.this);

                		alert.setTitle("LP Not Found");
                		alert.setMessage("Do you want to vist the Launcher Pro Android Market page?");
                		alert.setIcon(R.drawable.lp_icon);
                		alert.setPositiveButton("Yes",
                		 new DialogInterface.OnClickListener() {
                		  public void onClick(DialogInterface dialog, int id) {
                			  final Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("market://details?id=com.fede.launcher"));
                      		  startActivity(intent);
                		  }
                		 });
                		alert.setNegativeButton("No",
                		 new DialogInterface.OnClickListener() {
                		  public void onClick(DialogInterface dialog, int id) {
                		   Toast.makeText(Helper.this, "No widgets for you!", Toast.LENGTH_SHORT).show();
                		  }
                		 });

                		alert.show();
                	}
                }
        });
        
        wallpaper = (Button) findViewById(R.id.wallpaper);
        wallpaper.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                	try {
                		Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.setComponent(new ComponentName("com.yourname.yourappname","com.yourname.yourappname.wallpaper"));
                        startActivity(intent);
                	} 
                	catch (RuntimeException ex) {
                		makeToast("If you see this ask me for a free cookie!");
                	}
                }
        });
		
		filebugs = (Button) findViewById(R.id.filebugs);
        filebugs.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                	final Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://google.com"));
                	startActivity(intent);
                }        
        });
        
        web = (Button) findViewById(R.id.web);
        web.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                	final Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://www.google.com"));
                	startActivity(intent);
                }
        });
               
        marketinfo = (Button) findViewById(R.id.marketinfo);
        marketinfo.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                	final Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("market://details?id=com.yourname.yourappname"));
                	startActivity(intent);
                }
        });
    }
    
    
    public void makeToast(String msg) {
        Context context = getApplicationContext();
        CharSequence text = msg;
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
