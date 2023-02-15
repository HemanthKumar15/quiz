 package com.hemanthkumar.quiz;

import static com.hemanthkumar.quiz.prefs.total;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

 public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ImageButton next_btn;
     private Button finish_btn;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[][] questions = {
                //Enter the question details the array
                {
                    "Solve the below problem: ", // Question(or title)
                    "https://www.financialexpress.com/wp-content/uploads/2022/04/viral.jpg", //Link of the image, or if you don't want an image then type a empty string
                     "29", //OPTION 1
                     "9",  //OPTION 2
                     "30", // OPTION 3
                     "2",   // OPTION 4
                     "2"    // Correct option A - 1, B - 2, C - 3, D - 4
                },
                {"Solve the below problem: ", "https://www.telegraph.co.uk/content/dam/news/2016/05/15/Maths-problem-trending_trans_NvBQzQNjv4BqzTW4Ql1t-1Xt3_aTCx9yp4V4XZMU8yV22wInfrfUWRg.PNG?imwidth=680","1","9","8","5","1"},
                {"Solve the below problem:","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTYGh_oXNU_MJ7XeRkKQf4tFy3lQrqOTJm-Pw&usqp=CAU","3","2","4","2","3"},
                {"Solve the below problem:","https://i.ytimg.com/vi/vFt1wLfPfyA/maxresdefault.jpg","35","17.5","9","70","4"},

        };
        tabLayout = findViewById(R.id.tabLayout);

        ViewPager2 viewPager2 = findViewById(R.id.pager);
        Adapter adapter = new Adapter(getSupportFragmentManager(),getLifecycle(),questions.length,questions);
        viewPager2.setAdapter(adapter);
        next_btn = findViewById(R.id.next_btn);
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager2.setCurrentItem(viewPager2.getCurrentItem()+1);
            }
        });
        finish_btn = findViewById(R.id.finish_btn);
        finish_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("You scored: "+total)
                        .setCancelable(false)
                        .setPositiveButton("Restart quiz", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //do things
                                total = 0;
                                startActivity(new Intent(MainActivity.this,MainActivity.class));
                                finish();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
             tab.setText(""+String.valueOf(position+1));
        }).attach();


    }
}