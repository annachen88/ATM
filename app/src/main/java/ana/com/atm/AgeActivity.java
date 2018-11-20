package ana.com.atm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AgeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
    }

    public void next2(View view) {
        EditText edAge = findViewById(R.id.age);
        String age = edAge.getText().toString();
        getSharedPreferences("age",MODE_PRIVATE)
                .edit()
                .putString("ageString",age)
                .apply();
        Intent gender = new Intent(AgeActivity.this,GenderActivity.class);
        startActivity(gender);
    }
    public void back(View view) {
        finish();
    }

}
