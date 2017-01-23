package com.example.kevin.couchbase_lite_demo;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

/**
 * @author by kevin.
 */

public class DemoApplication extends Application {
  private static Context sContext;


  public static Context getContext() {
    return sContext;
  }


  @Override public void onCreate() {
    sContext = getApplicationContext();
    super.onCreate();
  }


  @Override protected void attachBaseContext(Context base) {
    super.attachBaseContext(base);
    MultiDex.install(this);
  }
}
