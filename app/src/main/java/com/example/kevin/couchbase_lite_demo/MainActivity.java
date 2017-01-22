package com.example.kevin.couchbase_lite_demo;

import com.couchbase.lite.CouchbaseLiteException;
import com.couchbase.lite.Database;
import com.couchbase.lite.Document;
import com.couchbase.lite.Manager;
import com.couchbase.lite.android.AndroidContext;
import com.example.kevin.couchbase_lite_demo.utils.LoggerUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  private final String TAG = MainActivity.class.getSimpleName();
  private TextView mTextView;
  private Manager mManager;
  private Database mDatabase;




  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mTextView = (TextView) findViewById(R.id.text);
    try {
      mManager = new Manager(new AndroidContext(getApplicationContext()), Manager.DEFAULT_OPTIONS);
    } catch (IOException e) {
      e.printStackTrace();
    }
    try {
      mDatabase = mManager.getDatabase("order");
    } catch (CouchbaseLiteException e) {
      e.printStackTrace();
    }

    Map<String, Object> mStringObjectMap = new HashMap<>();
    mStringObjectMap.put("restaurantId", "test111");
    mStringObjectMap.put("orderId", "sdjdjdldl");
    Document document = mDatabase.createDocument();
    try {
      document.putProperties(mStringObjectMap);
    } catch (CouchbaseLiteException e) {
      e.printStackTrace();
    }
    mTextView.setText(document.getProperty("restaurantId") + "<-->" + document.getProperty("orderId"));
    LoggerUtils.d(TAG, document.getId());
    LoggerUtils.d(TAG, (String) document.getProperty("restaurantId"));
    LoggerUtils.d(TAG, (String) document.getProperty("orderId"));
  }
}
