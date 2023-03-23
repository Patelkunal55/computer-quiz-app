package mrk2.kunalpatel.com.demoapps;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Result extends AppCompatActivity {

    public RecyclerView mRecyclerView;
    public RecyclerView.Adapter mAdapter;
    public RecyclerView.LayoutManager mLayoutManger;

    ArrayList<ResultItem> mResultItem;
    ArrayList<String> stock_list;
    private Toolbar toolbar;

    CardView cardView;



    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mResultItem = new ArrayList<>();

        cardView = findViewById(R.id.cardView);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Solution");
        toolbar.setTitleTextColor(Color.WHITE);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



        Intent j = getIntent();
        stock_list = new ArrayList<String>();
        stock_list = j.getStringArrayListExtra("array_list");

        Button button = findViewById(R.id.finish);


        Bundle extraBundle = getIntent().getExtras();
        String[] myAns = extraBundle.getStringArray("ans");
        String[] question = extraBundle.getStringArray("question");
        String[] option1 = extraBundle.getStringArray("option1");
        String[] option2 = extraBundle.getStringArray("option2");
        String[] option3 = extraBundle.getStringArray("option3");
        String[] option4 = extraBundle.getStringArray("option4");
        int color = getResources().getColor(R.color.dialog_Color);




        for (int i = 0; QuizAdapter.selectedAnswers.size() > i; i++) {

            String message = null;
            for (int k = 0; k < QuizAdapter.selectedAnswers.size(); k++) {

                message = "";
                message = message +  stock_list.get(i);

            }


            mResultItem.add(new ResultItem(question[i],option1[i],option2[i],option3[i],option4[i],"Your Answer: "+message,myAns[i],color,myAns ));


        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Result.this,Menu.class);
                startActivity(intent);
                finish();
            }
        });



        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManger = new LinearLayoutManager(this);
        mAdapter = new ResultAdapter(mResultItem);

        mRecyclerView.setLayoutManager(mLayoutManger);
        mRecyclerView.setAdapter(mAdapter);
    }



}
