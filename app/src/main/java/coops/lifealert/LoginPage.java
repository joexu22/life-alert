package coops.lifealert;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.webkit.WebView;
import android.webkit.WebViewClient;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by zsleiman on 11/19/2015.
 */

public class LoginPage extends AppCompatActivity {
    Button b1, b2;
    EditText ed1, ed2, ed3;
    TextView tx1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        b1 = (Button) findViewById(R.id.button);
        ed1 = (EditText) findViewById(R.id.editText);
        ed2 = (EditText) findViewById(R.id.editText2);
        ed3 = (EditText) findViewById(R.id.editText3);

//        b1.setOnClickListener(new View.OnClickListener() {
//                                  @Override
//                                  public void onClick(View v) {
//                                      QuickstartPreferences.USERNAME = ed1.getText().toString();
//                                      Intent intent = new Intent(LoginPage.this, MainHelpButton.class);
//                                      startActivity(intent);
//                                  }
//                              }
//        );
    }

    public void submit(View v) {
        b1 = (Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              QuickstartPreferences.USERNAME = ed1.getText().toString();
              QuickstartPreferences.LOCATION = ed2.getText().toString();
              QuickstartPreferences.ISSUE = ed3.getText().toString();
              Intent intent = new Intent(LoginPage.this, MainHelpButton.class);
              startActivity(intent);
          }
      });
    }
}
