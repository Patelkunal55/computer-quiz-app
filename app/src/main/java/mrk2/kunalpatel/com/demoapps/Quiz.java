package mrk2.kunalpatel.com.demoapps;


import static mrk2.kunalpatel.com.demoapps.QuizAdapter.selectedAnswers;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.littlemango.stacklayoutmanager.StackLayoutManager;

public class Quiz extends AppCompatActivity {
    public RecyclerView mRecyclerView;
    public RecyclerView.Adapter mAdapter;
    public RecyclerView.LayoutManager mLayoutManger;

    public ImageView imageView;
    public String [] question,option1,option2,option3,option4,answer,UserAns;
    public Button submit;
    public TextView yourAns,number;
    public String title;
    public int color;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        toolbar();

        color = getResources().getColor(R.color.dialog_Color);


        submit = (Button) findViewById(R.id.submit);

        questionSet();

        button();

        adapterView();




    }


    private void questionSet(){
        int set = getIntent().getExtras().getInt("pos");



        switch (set){


            case 0:


                ////Basic of Computer
                String a = "Basic of Computer";
                getSupportActionBar().setTitle(a);
                question = getResources().getStringArray(R.array.question);
                option1 = getResources().getStringArray(R.array.option1);
                option2 = getResources().getStringArray(R.array.option2);
                option3 = getResources().getStringArray(R.array.option3);
                option4 = getResources().getStringArray(R.array.option4);
                answer = getResources().getStringArray(R.array.answer);
                break;
            case 1:

                /////Internet and Networking
                title = "Internet and Networking";
                getSupportActionBar().setTitle(title);
                question = getResources().getStringArray(R.array.question3);
                option1 = getResources().getStringArray(R.array.opt1Set3);
                option2 = getResources().getStringArray(R.array.opt2Set3);
                option3 = getResources().getStringArray(R.array.opt3Set3);
                option4 = getResources().getStringArray(R.array.opt4Set3);
                answer = getResources().getStringArray(R.array.answer3);
                break;

            case 2:
                ///////Software
                title = "Software";
                getSupportActionBar().setTitle(title);
                question = getResources().getStringArray(R.array.question4);
                option1 = getResources().getStringArray(R.array.opt1Set4);
                option2 = getResources().getStringArray(R.array.opt2Set4);
                option3 = getResources().getStringArray(R.array.opt3Set4);
                option4 = getResources().getStringArray(R.array.opt4Set4);
                answer = getResources().getStringArray(R.array.answer4);
                break;

            case 3:
                ////////Hardware
                title = "Hardware";
                getSupportActionBar().setTitle(title);
                question = getResources().getStringArray(R.array.question5);
                option1 = getResources().getStringArray(R.array.opt1Set5);
                option2 = getResources().getStringArray(R.array.opt2Set5);
                option3 = getResources().getStringArray(R.array.opt3Set5);
                option4 = getResources().getStringArray(R.array.opt4Set5);
                answer = getResources().getStringArray(R.array.answer5);
                break;

            case 4:
                ///////ShortCut key
                title = "ShortCut key";
                getSupportActionBar().setTitle(title);
                question = getResources().getStringArray(R.array.question6);
                option1 = getResources().getStringArray(R.array.opt1Set6);
                option2 = getResources().getStringArray(R.array.opt2Set6);
                option3 = getResources().getStringArray(R.array.opt3Set6);
                option4 = getResources().getStringArray(R.array.opt4Set6);
                answer = getResources().getStringArray(R.array.answer6);
                break;

            case 5:
                break;

            case 6:
                break;
            default:
        }






    }

    private void button(){
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(Quiz.this);

                dialog.setContentView(R.layout.activity_custom_dialog);
                dialog.setCancelable(true);
                dialog.setCanceledOnTouchOutside(true);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                //Button button1 = dialog.findViewById(R.id.rate_us);

                TextView yes = dialog.findViewById(R.id.yes);
                TextView no = dialog.findViewById(R.id.no);


                yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialogShow();

                    }
                });

                no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });


    }




    private void dialogShow(){

        String message = "";
        // get the value of selected answers from custom adapter
        for (int i = 0; i < selectedAnswers.size(); i++) {
            message = message + "\n" + (i + 1) + " " + selectedAnswers.get(i);
            //mes = mes  + save.get(i);
        }

        // display the message on screen with the help of Toast.
        //Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();


        Intent intent = new Intent(Quiz.this,Score.class);
        intent.putStringArrayListExtra("array_list",selectedAnswers);
        //Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        //answer = getResources().getStringArray(R.array.answer2);


        intent.putExtra("question",question);
        intent.putExtra("option1",option1);
        intent.putExtra("option2",option2);
        intent.putExtra("option3",option3);
        intent.putExtra("option4",option4);
        intent.putExtra("ans",answer);
        startActivity(intent);
        finish();

    }

    private void adapterView(){
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManger = new LinearLayoutManager(this);
        mAdapter = new QuizAdapter(getApplication(),question,option1,option2,option3,option4,answer,color);


        StackLayoutManager managers = new StackLayoutManager(StackLayoutManager.ScrollOrientation.RIGHT_TO_LEFT);

        managers.setPagerMode(true);

        managers.setPagerFlingVelocity(3000);

        mRecyclerView.setLayoutManager(mLayoutManger);
        //mRecyclerView.managers = mLayoutManger;


        mRecyclerView.setAdapter(mAdapter);


    }


    @Override
    public void onBackPressed() {
        final Dialog dialog = new Dialog(Quiz.this);

        dialog.setContentView(R.layout.exit_dialog);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //Button button1 = dialog.findViewById(R.id.rate_us);

        TextView discard = dialog.findViewById(R.id.mYes);
        TextView cancel = dialog.findViewById(R.id.mNo);

        discard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Quiz.this,Menu.class);
                startActivity(intent);
                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }


    private void toolbar(){

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        toolbar.setTitleTextColor(Color.WHITE);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}
