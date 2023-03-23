package mrk2.kunalpatel.com.demoapps;

public class QuizItem {
    private int mImage;
    private String mTextView1;
    private String mTextView2;
    private int visible;
    private String insert;


    public QuizItem (int mImage,String mTextView1 ,String mTextView2,int visible,String insert){

        this.mImage = mImage;
        this.mTextView1 = mTextView1;
        this.mTextView2 = mTextView2;
        this.visible = visible;
        this.insert = insert;

    }

    public int getmImage() {
        return mImage;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }

    public String getmTextView1() {
        return mTextView1;
    }

    public void setmTextView1(String mTextView1) {
        this.mTextView1 = mTextView1;
    }

    public String getmTextView2() {
        return mTextView2;
    }

    public void setmTextView2(String mTextView2) {
        this.mTextView2 = mTextView2;
    }

    public int getVisible(){
        return visible;
    }
    public void setVisible(int visible){
        this.visible = visible;
    }
}
