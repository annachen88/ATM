package ana.com.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int RC_LOGIN = 100;
    boolean login = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(!login){
            Intent intent = new Intent(this,LoginActivity.class);
            startActivityForResult(intent,RC_LOGIN);
        }
        //data
        List<String> fruit = Arrays.asList("香蕉","芭樂","鳳梨");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,fruit);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RC_LOGIN){
            if(resultCode!=RESULT_OK){
               finish();
            }else{
                login=true;
                String nick = getSharedPreferences("nick",MODE_PRIVATE)
                        .getString("nickString",null);
                int age = getSharedPreferences("age",MODE_PRIVATE)
                        .getInt("ageString",0);
                int gender = getSharedPreferences("gender",MODE_PRIVATE)
                        .getInt("genderString",0);
                if(nick==null||age==0||gender==0){
                Intent nickName = new Intent(this,NicknameActivity.class);
                startActivity(nickName);
                }

            }
        }
    }
}
