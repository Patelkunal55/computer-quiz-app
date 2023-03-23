package mrk2.kunalpatel.com.demoapps;

import static mrk2.kunalpatel.com.demoapps.QuizAdapter.selectedAnswers;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.timqi.sectorprogressview.ColorfulRingProgressView;

public class Score extends AppCompatActivity {

    int score = 0;
    int skip = 0;
    int wrong = 0;
    int negative = 1;
    float percentage,percentage1,percentage2;
    float total_marks = 20;
    private Toolbar toolbar;
    //float scored;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        TextView textView = findViewById(R.id.score_no1);
        TextView textView1 = findViewById(R.id.score_no2);
        TextView textView2 = findViewById(R.id.score_no3);

        Button button = findViewById(R.id.solution);
        Button button1 = findViewById(R.id.retry);

        ColorfulRingProgressView cprv = findViewById(R.id.circular_bar2);
        ColorfulRingProgressView cprvM = findViewById(R.id.circular_bar3);
        ColorfulRingProgressView cprvN = findViewById(R.id.circular_bar4);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Score");
        toolbar.setTitleTextColor(Color.WHITE);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



        Bundle extraBundle = getIntent().getExtras();
        final String[] myAns = extraBundle.getStringArray("ans");
        final String[] question = extraBundle.getStringArray("question");
        final String[] option1 = extraBundle.getStringArray("option1");
        final String[] option2 = extraBundle.getStringArray("option2");
        final String[] option3 = extraBundle.getStringArray("option3");
        final String[] option4 = extraBundle.getStringArray("option4");

        for (int i = 0; i<myAns.length;i++){

            if (selectedAnswers.get(i).equals(myAns[i])){

                score++;

            }
            textView.setText(String.valueOf(score));

            if (selectedAnswers.get(i).equals("Not Attempted")){
                skip++;

            }

            textView1.setText(String.valueOf(skip));

        }


        wrong = 20 - (score + skip);
        textView2.setText(String.valueOf(wrong));

        percentage = (float)((score / total_marks) * 100);//correct answer
        percentage1 = (float)((skip/total_marks)*100);//skip answer
        percentage2 = (float)((wrong/total_marks)*100);//skip answer

        cprv.setPercent(percentage);
        cprvM.setPercent(percentage1);
        cprvN.setPercent(percentage2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Score.this,Result.class);

                intent.putStringArrayListExtra("array_list",selectedAnswers);
                intent.putExtra("question",question);
                intent.putExtra("option1",option1);
                intent.putExtra("option2",option2);
                intent.putExtra("option3",option3);
                intent.putExtra("option4",option4);
                intent.putExtra("ans",myAns);
                startActivity(intent);
                finish();

            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Score.this,Menu.class);
                startActivity(i);
                finish();
            }
        });


    }
}
