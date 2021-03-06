package ana.com.atm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
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
    EditText edAge ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        edAge = findViewById(R.id.age);
        RecyclerView  recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new AgeAdapter());

    }

    public void next2(View view) {
        // edAge = findViewById();
        int age = Integer.parseInt(edAge.getText().toString());
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


        @NonNull
        @Override
        public AgeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.age_row,parent,false);
            return new AgeHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull AgeHolder holder, final int position) {
        holder.textView.setText(age[position]+"");
        if(age[position]==20){
            holder.textView.setTextColor(Color.BLUE);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.util.Log.d("AgeActivity","onClick"+age[position]);
                edAge.setText(age[position]+"");
//TODO:setText & color
            }
        });
        }

        @Override
        public int getItemCount() {
            return age.length;
        }

        class AgeHolder extends RecyclerView.ViewHolder {
            TextView textView;
            public AgeHolder(View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.tv_age);
            }
        }
    }
}
