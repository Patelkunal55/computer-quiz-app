package mrk2.kunalpatel.com.demoapps;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static mrk2.kunalpatel.com.demoapps.QuizAdapter.selectedAnswers;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ResultViewHolder> {



    public ArrayList<ResultItem> mResultItem;
    //private String[] question ,option1 ,option2,option3,option4,userAns;
    //public static ArrayList<String> selectedAnswers;
    private Context context;


    public ResultAdapter (ArrayList<ResultItem> resultItems){

        mResultItem = resultItems;



    }




    public ResultAdapter(){

    }






    @NonNull
    @Override
    public ResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_result,parent,false);
        ResultViewHolder evh = new ResultViewHolder(v);
        return evh;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ResultViewHolder holder, int position) {
        ResultItem currentItem = mResultItem.get(position);
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());
        holder.mTextView3.setText(currentItem.getText3());
        holder.mTextView4.setText(currentItem.getText4());
        holder.mTextView5.setText(currentItem.getText5());
        holder.mTextView6.setText(currentItem.getText6());
        holder.mTextView7.setText(currentItem.getText7());

        String userAns = currentItem.getText6();
        String correctAns = currentItem.getText7();

        String user = holder.mTextView7.getText().toString();


        //holder.cardView.setBackgroundColor(Color.RED);

        holder.mTextView6.setTextColor(Color.RED);


        for (int i = 0; i<selectedAnswers.size();i++) {

            if (selectedAnswers.get(i).equals(user)) {

                //holder.cardView.setBackgroundColor(Color.YELLOW);

                holder.mTextView6.setTextColor(Color.YELLOW);


            }





        }




    }



    @Override
    public int getItemCount() {
        return mResultItem.size();
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


    public static class ResultViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView1;
        public TextView mTextView2;
        public TextView mTextView3;
        public TextView mTextView4;
        public TextView mTextView5;

        public TextView mTextView6;
        public TextView mTextView7,mTextView8;
        public CardView cardView;
        public ResultViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView1 = itemView.findViewById(R.id.question);
            mTextView2 = itemView.findViewById(R.id.option1);
            mTextView3 = itemView.findViewById(R.id.option2);
            mTextView4 = itemView.findViewById(R.id.option3);
            mTextView5 = itemView.findViewById(R.id.option4);

            mTextView6 = itemView.findViewById(R.id.your_answer);
            mTextView7 = itemView.findViewById(R.id.correct_ans);
            mTextView8 = itemView.findViewById(R.id.correct_answer);

            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
