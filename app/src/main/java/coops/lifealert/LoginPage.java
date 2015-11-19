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
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by zsleiman on 11/19/2015.
 */


public class LoginPage extends AppCompatActivity {
    Button b1,b2;
    EditText ed1,ed2;
    TextView tx1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        b1=(Button)findViewById(R.id.button);
        ed1=(EditText)findViewById(R.id.editText);
        ed2=(EditText)findViewById(R.id.editText2);


    }

}
