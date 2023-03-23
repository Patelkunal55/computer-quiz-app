package mrk2.kunalpatel.com.demoapps;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.QuizViewHolder> {
    private String[] question ,option1 ,option2,option3,option4,answer,userAns;
    private int color;
    public static ArrayList<String> selectedAnswers;
    private Context context;

    int score = 0;

    public QuizAdapter(Context context, String[] question, String[] option1, String[] option2,String[] option3,String[] option4, String[] answer,int color) {
        this.context = context;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = answer;
        this.color = color;

        selectedAnswers = new ArrayList<>();



        for (int i = 0; i < question.length; i++) {
            selectedAnswers.add("Not Attempted");

        }
    }

    @NonNull
    @Override
    public QuizViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_quiz,parent,false);
        QuizViewHolder evh = new QuizViewHolder(view);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull final QuizViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.mRadioButton1.setText(option1[position]);
        holder.mRadioButton2.setText(option2[position]);
        holder.mRadioButton3.setText(option3[position]);
        holder.mRadioButton4.setText(option4[position]);


        holder.mRadioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radio = holder.mRadioGroup.getCheckedRadioButtonId();
                holder.mRadioButton1 = v.findViewById(radio);

                String getAnswer = holder.mRadioButton1.getText().toString();
                if (getAnswer.equals(answer[position])){
                    selectedAnswers.set(position,getAnswer);
                    score++;



                    //Toast.makeText(v.getContext(),"Correct: "+ getAnswer+" Pos: "+position,Toast.LENGTH_SHORT).show();

                    // Toast.makeText(v.getContext(),"Correct: "+ getAnswer,Toast.LENGTH_SHORT).show();
                }else {
                    //Toast.makeText(v.getContext(),"Wrong! "+"Correct answer is: "+ answer[position],Toast.LENGTH_SHORT).show();

                    selectedAnswers.set(position,getAnswer);

                    //Toast.makeText(v.getContext(),"Correct: "+ getAnswer+" Pos: "+position, Toast.LENGTH_SHORT).show();

                }




            }
        });

        holder.mRadioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radio = holder.mRadioGroup.getCheckedRadioButtonId();
                holder.mRadioButton2 = v.findViewById(radio);

                String getAnswer = holder.mRadioButton2.getText().toString();

                if (getAnswer.equals(answer[position])){

                    selectedAnswers.set(position,getAnswer);

                    //Toast.makeText(v.getContext(),"Correct: "+ getAnswer+" Pos: "+position,Toast.LENGTH_SHORT).show();

                    // Toast.makeText(v.getContext(),"Correct: "+ getAnswer,Toast.LENGTH_SHORT).show();
                }else {
                    //Toast.makeText(v.getContext(),"Wrong! "+"Correct answer is: "+ answer[position],Toast.LENGTH_SHORT).show();
                    selectedAnswers.set(position,getAnswer);
                    //Toast.makeText(v.getContext(),"Correct: "+ getAnswer+" Pos: "+position,Toast.LENGTH_SHORT).show();

                }


            }
        });

        holder.mRadioButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int radio = holder.mRadioGroup.getCheckedRadioButtonId();
                holder.mRadioButton3 = view.findViewById(radio);

                String getAnswer = holder.mRadioButton3.getText().toString();

                if (getAnswer.equals(answer[position])) {
                    selectedAnswers.set(position, getAnswer);

                    //Toast.makeText(view.getContext(),"Correct: "+ getAnswer+" Pos: "+position,Toast.LENGTH_SHORT).show();
                }else {
                    selectedAnswers.set(position,getAnswer);
                    //Toast.makeText(view.getContext(),"Correct: "+ getAnswer+" Pos: "+position,Toast.LENGTH_SHORT).show();
                }
            }
        });


        holder.mRadioButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int radio = holder.mRadioGroup.getCheckedRadioButtonId();
                holder.mRadioButton4 = view.findViewById(radio);

                String getAnswer = holder.mRadioButton4.getText().toString();

                if (getAnswer.equals(answer[position])) {

                    selectedAnswers.set(position, getAnswer);
                    //Toast.makeText(view.getContext(),"Correct: "+ getAnswer+" Pos: "+position,Toast.LENGTH_SHORT).show();
                }else {
                    selectedAnswers.set(position,getAnswer);
                    //Toast.makeText(view.getContext(),"Correct: "+ getAnswer+" Pos: "+position,Toast.LENGTH_SHORT).show();
                }
            }
        });

        holder.mTextView.setText(question[position]);

    }

    @Override
    public int getItemCount() {
        return question.length;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public static class QuizViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView mTextView;
        public TextView correctAnswer,insert;
        public Button submit;
        public RadioButton mRadioButton1;
        public RadioButton mRadioButton2;
        public RadioButton mRadioButton3;
        public RadioButton mRadioButton4;
        public RadioGroup mRadioGroup;




        public QuizViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTextView = itemView.findViewById(R.id.textView);
            mRadioGroup = itemView.findViewById(R.id.radioGroup);



            //mButton = itemView.findViewById(R.id.button);
            mRadioButton1 = itemView.findViewById(R.id.mRadio1);
            mRadioButton2 = itemView.findViewById(R.id.mRadio2);
            mRadioButton3 = itemView.findViewById(R.id.mRadio3);
            mRadioButton4 = itemView.findViewById(R.id.mRadio4);

            submit = itemView.findViewById(R.id.submit);






        }
    }
}
