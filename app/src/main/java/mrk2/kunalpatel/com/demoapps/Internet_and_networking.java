package mrk2.kunalpatel.com.demoapps;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.timqi.sectorprogressview.ColorfulRingProgressView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class Internet_and_networking extends AppCompatActivity {

    private Toolbar toolbar;
    Button next, back, finish;
    RadioGroup rg;
    RadioButton rb1, rb2, rb3, rb4;
    TextView setque, textQue;
    int index = 0;
    String MyCAns, UserCAns = "";
    int totalCurrect, totalQues = 20, totalSkeep, totalWrrong;
    int TotalCurrect, TotalQues,TotalSkip,TotalWrong;
    ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
    HashMap<String, String> map;
    Dialog home_dialog, dialog1;
    private FirebaseAnalytics nFBanalytics;
    private final String TAG = "BUTTON";
    private final String TAG_AD = "Banner";
    int sec = 2;

    String name = "Hello";

    int n = 100;

    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;
    private static final long START_TIME_IN_MILLIS = 100000;

    TextView textView,textscore,textquestions;
    int totalques = 1;


    TextView text;

    ColorfulRingProgressView crpv1;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question__quiz);

        Timer();

        //text = (TextView) findViewById(R.id.Percent);

       // crpv1 = (ColorfulRingProgressView) findViewById(R.id.crpv1);


        //MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        //AdView adView = (AdView) findViewById(R.id.adView);
        //AdRequest adRequest = new AdRequest.Builder().build();
        //adView.loadAd(adRequest);
        nFBanalytics = FirebaseAnalytics.getInstance(this);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setTitle("Internet and Networking");
        toolbar.setTitleTextColor(Color.WHITE);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        back = (Button) findViewById(R.id.button1);
        next = (Button) findViewById(R.id.button2);
        finish = (Button) findViewById(R.id.button3);
        rg = (RadioGroup) findViewById(R.id.radioGroup1);
        rb1 = (RadioButton) findViewById(R.id.radio0);
        rb2 = (RadioButton) findViewById(R.id.radio1);
        rb3 = (RadioButton) findViewById(R.id.radio2);
        rb4 = (RadioButton) findViewById(R.id.radio3);
        rb1.setChecked(false);
        rb2.setChecked(false);
        rb3.setChecked(false);
        rb4.setChecked(false);

        setque = (TextView) findViewById(R.id.textView1);
        textQue = (TextView) findViewById(R.id.textqueno);
        back.setVisibility(View.GONE);
        finish.setVisibility(View.GONE);

        textquestions = (TextView)findViewById(R.id.textquestions);
        textscore =(TextView)findViewById(R.id.score);
        set_Your_Ques();
        set_Ques_One();
        rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) findViewById(checkedId);
                UserCAns = rb.getText().toString().trim();
            }
        });


        /*adView.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {
                Bundle Banner = new Bundle();
                Banner.putInt("ButtonID",sec);
                String BannerAd;
                // Code to be executed when an ad finishes loading.
                BannerAd = "BannerLoaded";
                Log.d(TAG_AD,"Button Clicked logged:" + Banner);
                nFBanalytics.logEvent(BannerAd,Banner);
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the sc reen.

            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the user is about to return
                // to the app after tapping on an ad.
            }
        });*/


        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (UserCAns.equals("")) {
                    totalSkeep++;
                } else if (UserCAns.equals(MyCAns)) {
                    totalCurrect++;
                } else {
                    totalWrrong++;
                }
                UserCAns = "";
                rb1.setChecked(false);
                rb2.setChecked(false);
                rb3.setChecked(false);
                rb4.setChecked(false);
                back();
            }
        });

        next.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                back.setVisibility(View.GONE);
                if (UserCAns.equals("")) {
                    totalSkeep++;
                    TotalSkip += 5;

                } else if (UserCAns.equals(MyCAns)) {
                    totalCurrect++;
                    TotalCurrect += 5;
                    Toast.makeText(Internet_and_networking.this,
                            "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    totalWrrong++;
                    TotalWrong += 5;
                    Toast.makeText(Internet_and_networking.this,
                            "Wrong", Toast.LENGTH_SHORT).show();
                }
                UserCAns = "";
                rb1.setChecked(false);
                rb2.setChecked(false);
                rb3.setChecked(false);
                rb4.setChecked(false);
                next();
                correct();

                TotalQues += 5;
            }
        });

        finish.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Internet_and_networking.this, Quiz.class);
                intent.putExtra("totalquestion", "" + totalQues);
                intent.putExtra("totalcurrect", "" + totalCurrect);
                intent.putExtra("totalSkeep", "" + totalSkeep);
                intent.putExtra("totalWrrong", "" + totalWrrong);



                intent.putExtra("Totalquestion",+TotalQues); // circular bar no.
                intent.putExtra("TotalCorrect",+TotalCurrect); // circlar bar no.
                intent.putExtra("TotalSkip",+TotalSkip); // circular bar no.
                intent.putExtra("TotalWrong",+TotalWrong);// circular bar no.
                startActivity(intent);
                finish();

            }
        });


    }


    private void Timer() {


        new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();


                crpv1.setPercent(millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(Internet_and_networking.this, Quiz.class);
                intent.putExtra("totalquestion", "" + totalQues);
                intent.putExtra("totalcurrect",""  + totalCurrect);
                intent.putExtra("totalSkeep", "" + totalSkeep);
                intent.putExtra("totalWrrong", "" + totalWrrong);


                intent.putExtra("Totalquestion",+TotalQues);
                intent.putExtra("TotalCorrect",+TotalCurrect);
                intent.putExtra("TotalSkip",+TotalSkip);
                intent.putExtra("TotalWrong",+TotalWrong);
                startActivity(intent);
                finish();

                //textView.setText("Timer is Finished!");
                //crpv.setPercent(percentage);

            }
        }.start();
    }

    private void updateCountDownText() {

        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        text.setText(timeLeftFormatted);


    }


    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Home:
                home_dialog = new Dialog(Internet_and_networking.this);
                home_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);///This show title of dialog which is disable command.
                home_dialog.setContentView(R.layout.home_dialog);

                Button close = (Button) home_dialog.findViewById(R.id.close_button);
                Button ok = (Button) home_dialog.findViewById(R.id.OK_button);

                close.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        home_dialog.dismiss();
                    }

                });

                ok.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Internet_and_networking.this, mrk2.kunalpatel.com.demoapps.Menu.class);
                        startActivity(intent);
                        finish();

                    }

                });

                home_dialog.setCancelable(true);
                home_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                home_dialog.show();
                return true;


            case R.id.refresh:
                dialog1 = new Dialog(Internet_and_networking.this);
                dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog1.setContentView(R.layout.dialog1);
                Button close5 = (Button) dialog1.findViewById(R.id.button5);
                Button ok6 = (Button) dialog1.findViewById(R.id.button6);

                close5.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog1.dismiss();
                    }

                });

                ok6.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Internet_and_networking.this, Internet_and_networking.class);
                        startActivity(intent);
                        finish();

                    }

                });
                dialog1.setCancelable(true);
                dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog1.show();
                return true;

            case R.id.home:

                home_dialog = new Dialog(Internet_and_networking.this);
                home_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                home_dialog.setContentView(R.layout.home_dialog);
                Button close_button = (Button) home_dialog.findViewById(R.id.close_button);
                Button ok_button = (Button) home_dialog.findViewById(R.id.OK_button);

                close_button.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        home_dialog.dismiss();
                    }

                });

                ok_button.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Internet_and_networking.this, mrk2.kunalpatel.com.demoapps.Menu.class);
                        startActivity(intent);
                        finish();

                    }

                });
                home_dialog.setCancelable(true);
                home_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                home_dialog.show();
                return true;

            default:

                return super.onOptionsItemSelected(item);







        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }*/
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Internet_and_networking.this);
        builder.setMessage("Do you really want to exit?").setCancelable(
                false).setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();


                    }
                }).setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }

    private void set_Ques_One() {
        map = MyArrList.get(index);

        setque.setText(map.get("Ques").toString().trim());
        textQue.setText(map.get("Qno").toString().trim());
        rb1.setText(map.get("A1").toString().trim());
        rb2.setText(map.get("A2").toString().trim());
        rb3.setText(map.get("A3").toString().trim());
        rb4.setText(map.get("A4").toString().trim());
        MyCAns = map.get("CA1").toString().trim();
        //Toast.makeText(getApplicationContext(),"1"+index,2000).show();
    }

    public void next() {
        if (index == 19) {
            back.setVisibility(View.GONE);
            next.setVisibility(View.GONE);
            finish.setVisibility(View.VISIBLE);
        } else {
            index++;
            totalques++;
            //Toast.makeText(getApplicationContext(),""+index,2000).show();
            map = MyArrList.get(index);

            setque.setText(map.get("Ques").toString().trim());
            textQue.setText(map.get("Qno").toString().trim());
            rb1.setText(map.get("A1").toString().trim());
            rb2.setText(map.get("A2").toString().trim());
            rb3.setText(map.get("A3").toString().trim());
            rb4.setText(map.get("A4").toString().trim());
            MyCAns = map.get("CA1").toString().trim();
        }

    }

    void correct(){
        textscore.setText("Score: "+ totalCurrect);
        textquestions.setText("Questions: "+totalques +"/20");
    }

    public void back() {
        if (index == 0) {
            back.setVisibility(View.GONE);
            finish.setVisibility(View.GONE);
        } else {
            index--;
            map = MyArrList.get(index);
            setque.setText(map.get("Ques").toString().trim());
            rb1.setText(map.get("A1").toString().trim());
            rb2.setText(map.get("A2").toString().trim());
            rb3.setText(map.get("A3").toString().trim());
            rb4.setText(map.get("A4").toString().trim());
            MyCAns = map.get("CA1").toString().trim();
        }


    }

    public void set_Your_Ques() {
        //Q 1
        map = new HashMap<String, String>();
        map.put("Qno", "Q1");
        map.put("NO", "Question. 1/20");
        map.put("Ques", "What is internet?");
        map.put("A1", "A. a single network");
        map.put("A2", "B. a vast collection of different networks");
        map.put("A3", "C. interconnection of local area networks");
        map.put("A4", "D. none of the mentioned");
        map.put("CA1", "B. a vast collection of different networks");
        MyArrList.add(map);
        //Q 2
        map = new HashMap<String, String>();
        map.put("Qno", "Q2");
        map.put("NO", "Question. 2/20");
        map.put("Ques", "To join the internet, the computer has to be connected to a");
        map.put("A1", "A. internet architecture board");
        map.put("A2", "B. internet society");
        map.put("A3", "C. internet service provider");
        map.put("A4", "D. none of the mentioned");
        map.put("CA1", "C. internet service provider");
        MyArrList.add(map);
        //Q 3
        map = new HashMap<String, String>();
        map.put("Qno", "Q3");
        map.put("NO", "Question. 3/20");
        map.put("Ques", "ISP exchanges internet traffic between their networks by");
        map.put("A1", "A. internet exchange point");
        map.put("A2", "B. subscriber end point");
        map.put("A3", "C. isp end point");
        map.put("A4", "D. none of the mentioned");
        map.put("CA1", "A. internet exchange point");
        MyArrList.add(map);
        //Q 4
        map = new HashMap<String, String>();
        map.put("Qno", "Q4");
        map.put("NO", "Question. 4/20");
        map.put("Ques", "Which one of the following protocol is not used in internet?");
        map.put("A1", "A. HTTP");
        map.put("A2", "B. DHCP");
        map.put("A3", "C. DNS");
        map.put("A4", "D. None of the mentioned");
        map.put("CA1", "D. None of the mentioned");
        MyArrList.add(map);
        //Q 5
        map = new HashMap<String, String>();
        map.put("Qno", "Q5");
        map.put("NO", "Question. 5/20");
        map.put("Ques", "Internet works on");
        map.put("A1", "A. packet switching");
        map.put("A2", "B. circuit switching");
        map.put("A3", "C. both (a) and (b)");
        map.put("A4", "D. none of the mentioned");
        map.put("CA1", "A. packet switching");
        MyArrList.add(map);
        //Q6
        map = new HashMap<String, String>();
        map.put("Qno", "Q6");
        map.put("NO", "Question. 6/20");
        map.put("Ques", "Mini computers are used as a server in");
        map.put("A1", "A. LAN");
        map.put("A2", "B. MAN");
        map.put("A3", "C. WAN");
        map.put("A4", "D. PROM");
        map.put("CA1", "A. LAN");
        MyArrList.add(map);
        //q7
        map = new HashMap<String, String>();
        map.put("Qno", "Q7");
        map.put("NO", "Question. 7/20");
        map.put("Ques", "Web browser is an example of ");
        map.put("A1", "A. Client agent");
        map.put("A2", "B. Server Agent");
        map.put("A3", "C. User agent");
        map.put("A4", "D. None");
        map.put("CA1", "C. User agent");
        MyArrList.add(map);
        //q8
        map = new HashMap<String, String>();
        map.put("Qno", "Q8");
        map.put("NO", "Question. 8/20");
        map.put("Ques", "Password is a");
        map.put("A1", "A. Dynamic");
        map.put("A2", "B. Case insensitive");
        map.put("A3", "C. Static");
        map.put("A4", "D. Case sensitive");
        map.put("CA1", "D. Case sensitive");
        MyArrList.add(map);
        //q9
        map = new HashMap<String, String>();
        map.put("Qno", "Q9");
        map.put("NO", "Question. 9/20");
        map.put("Ques", "________ allow you to communicate with other computers using a phone line");
        map.put("A1", "A. Cable");
        map.put("A2", "B. Internet");
        map.put("A3", "C. Softwarre");
        map.put("A4", "D. Modern");
        map.put("CA1", "D. Modern");
        MyArrList.add(map);
        //q10
        map = new HashMap<String, String>();
        map.put("Qno", "Q10");
        map.put("NO", "Question. 10/20");
        map.put("Ques", "______ is commonly used data format for exchanging information between computers or programs");
        map.put("A1", "A. ASCII");
        map.put("A2", "B. HTML");
        map.put("A3", "C. XML");
        map.put("A4", "D. DHTML");
        map.put("CA1", "A. ASCII");
        MyArrList.add(map);
        //q11
        map = new HashMap<String, String>();
        map.put("Qno", "Q11");
        map.put("NO", "Question. 11/20");
        map.put("Ques", "Hub is associated with .......... network.");
        map.put("A1", "A. bus");
        map.put("A2", "B. ring");
        map.put("A3", "C. star");
        map.put("A4", "D. mesh");
        map.put("CA1", "C. star");
        MyArrList.add(map);
        //q12
        map = new HashMap<String, String>();
        map.put("Qno", "Q12");
        map.put("NO", "Question. 12/20");
        map.put("Ques", "The advantage of LAN is");
        map.put("A1", "A. sharing peripherals");
        map.put("A2", "B. banking up your data");
        map.put("A3", "C. saving all your data");
        map.put("A4", "D. accessing the web");
        map.put("CA1", "A. sharing peripherals");
        MyArrList.add(map);
        //q13
        map = new HashMap<String, String>();
        map.put("Qno", "Q13");
        map.put("NO", "Question. 13/20");
        map.put("Ques", "Which type of network would use phone lines?");
        map.put("A1", "A. WAN");
        map.put("A2", "B. LAN");
        map.put("A3", "C. WWAN");
        map.put("A4", "D. Wireless");
        map.put("CA1", "A. WAN");
        MyArrList.add(map);
        //q14
        map = new HashMap<String, String>();
        map.put("Qno", "Q14");
        map.put("NO", "Question. 14/20");
        map.put("Ques", "Which of the following is considered a broad band communication channel?");
        map.put("A1", "A. Coaxial cable");
        map.put("A2", "B. Microwave circuits");
        map.put("A3", "C. Fiber optics cable");
        map.put("A4", "D. All of these");
        map.put("CA1", "Answer.D");
        MyArrList.add(map);
        //q15
        map = new HashMap<String, String>();
        map.put("Qno", "Q15");
        map.put("NO", "Question. 15/20");
        map.put("Ques", "Network components are connected to the same cable in the ............ topology.");
        map.put("A1", "A. star");
        map.put("A2", "B. ring");
        map.put("A3", "C. bus");
        map.put("A4", "D. mesh");
        map.put("CA1", "C. bus");
        MyArrList.add(map);
        //q16
        map = new HashMap<String, String>();
        map.put("Qno", "Q16");
        map.put("NO", "Question. 16/20");
        map.put("Ques", "Which of the following is not a network device?");
        map.put("A1", "A. Router");
        map.put("A2", "B. Switch");
        map.put("A3", "C. Modem");
        map.put("A4", "D. Bridge");
        map.put("CA1", "C. Modem");
        MyArrList.add(map);
        //q17
        map = new HashMap<String, String>();
        map.put("Qno", "Q17");
        map.put("NO", "Question. 17/20");
        map.put("Ques", "Networking using fibre optic cable is done as");
        map.put("A1", "A. It has high bandwidth");
        map.put("A2", "B. It is thin and light");
        map.put("A3", "C. It is not affected by electromagnetic");
        map.put("A4", "D. All of the above");
        map.put("CA1", "D. All of the above");
        MyArrList.add(map);
        //q18
        map = new HashMap<String, String>();
        map.put("Qno", "Q18");
        map.put("NO", "Question. 18/20");
        map.put("Ques", "What is the function of modem?");
        map.put("A1", "A. Encryption and decryption");
        map.put("A2", "B. Converts data to voice");
        map.put("A3", "C. Converts analog signals to digitals and vice-versa");
        map.put("A4", "D. Serve as a hardware anti-virus");
        map.put("CA1", "C. Converts analog signals to digitals and vice-versa");
        MyArrList.add(map);
        //q19
        map = new HashMap<String, String>();
        map.put("Qno", "Q19");
        map.put("NO", "Question. 19/20");
        map.put("Ques", "Which of the following items is not used in Local Area Networks (LANs)?");
        map.put("A1", "A. Interface card");
        map.put("A2", "B. Cable");
        map.put("A3", "C. Computer");
        map.put("A4", "D. Moderm");
        map.put("CA1", "D. Moderm");
        MyArrList.add(map);
        //q20
        map = new HashMap<String, String>();
        map.put("Qno", "Q20");
        map.put("NO", "Question. 20/20");
        map.put("Ques", "Which of the following is the fastest communication channel?");
        map.put("A1", "A. Radio wave");
        map.put("A2", "B. Micro Wave");
        map.put("A3", "C. Optical fiber");
        map.put("A4", "D. All are operating at nearly the same propagation speed");
        map.put("CA1", "B. Micro Wave");
        MyArrList.add(map);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            home_dialog = new Dialog(Internet_and_networking.this);
            home_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);///This show title of dialog which is disable command.
            home_dialog.setContentView(R.layout.home_dialog);

            Button close = (Button) home_dialog.findViewById(R.id.close_button);
            Button ok = (Button) home_dialog.findViewById(R.id.OK_button);

            close.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    home_dialog.dismiss();
                }

            });

            ok.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Internet_and_networking.this, mrk2.kunalpatel.com.demoapps.Menu.class);
                    startActivity(intent);
                    finish();

                }

            });

            home_dialog.setCancelable(true);
            home_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            home_dialog.show();
            /*Intent i = new Intent(Internet_and_networking.this, Menu.class);
            startActivity(i);
            finish();*/
        }
        return super.onOptionsItemSelected(item);
    }

}