package ana.com.atm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class AgeActivity extends BaseActivity {
    int[] age = {19, 20, 21, 22, 23, 24, 25};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new AgeAdapter());

    }

    public void next2(View view) {
        // edAge = findViewById();
        int age = Integer.parseInt(((EditText) findViewById(R.id.age)).getText().toString());
        user.setAge(age);
//        getSharedPreferences("age",MODE_PRIVATE)
//                .edit()
//                .putString("ageString",age)
//                .apply();
        Intent gender = new Intent(AgeActivity.this, GenderActivity.class);
        startActivity(gender);
    }

    public void back(View view) {
        finish();
    }

    class AgeAdapter extends RecyclerView.Adapter<AgeAdapter.AgeHolder> {
        TextView textView;

        @NonNull
        @Override
        public AgeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.age_row,parent,false);
            return new AgeHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull AgeHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return age.length;
        }

        class AgeHolder extends RecyclerView.ViewHolder {
            public AgeHolder(View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.tv_age);
            }
        }
    }
}
