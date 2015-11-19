package coops.lifealert;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;



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

    }

    public void submit(View v) {
        b1 = (Button) findViewById(R.id.button);
        QuickstartPreferences.USERNAME = ed1.getText().toString();
        QuickstartPreferences.LOCATION = ed2.getText().toString();
        QuickstartPreferences.ISSUE = ed3.getText().toString();
        Intent intent = new Intent(LoginPage.this, MainHelpButton.class);
        startActivity(intent);
    }

}

