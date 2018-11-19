package ana.com.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;

public class GenderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
    }

    public void next4(View view) {
        Intent main = new Intent(GenderActivity.this,MainActivity.class);
        main.setFlags(FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(main);
    }
}
