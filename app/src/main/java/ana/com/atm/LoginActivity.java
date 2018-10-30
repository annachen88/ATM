package ana.com.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void login(View view){
        String user = ((EditText) findViewById(R.id.userId)).getText().toString();
        //user.getText().toString();
        String password = ((EditText)findViewById(R.id.passWord)).getText().toString();
        if ("jack".equals(user) && "1234".equals(password)) {
            setResult(RESULT_OK);
            finish();
        }

    }
}
