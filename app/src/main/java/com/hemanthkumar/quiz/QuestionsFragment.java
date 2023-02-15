package com.hemanthkumar.quiz;

import static com.hemanthkumar.quiz.prefs.total;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;


public class QuestionsFragment extends Fragment {
    public static final String question = "question";



    public QuestionsFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_questions, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((TextView)view.findViewById(R.id.question_txt)).setText(getArguments().getStringArrayList(question).get(0));
        String img_txt = getArguments().getStringArrayList(question).get(1);
        ImageView img = ((ImageView)view.findViewById(R.id.imageView));
        String ans = getArguments().getStringArrayList(question).get(6);
        if(img_txt == ""){
            img.setVisibility(View.GONE);
        }else{
            Picasso.get().load(img_txt)
                    .error(R.drawable.ic_baseline_error_24).into(img);
        }
        Button a_opt = ((Button)view.findViewById(R.id.a_opt));
        Button b_opt = ((Button)view.findViewById(R.id.b_opt));
        Button c_opt = ((Button)view.findViewById(R.id.c_opt));
        Button d_opt = ((Button)view.findViewById(R.id.d_opt));
        a_opt.setText("A:"+getArguments().getStringArrayList(question).get(2));
        b_opt.setText("B:"+getArguments().getStringArrayList(question).get(3));
        c_opt.setText("C:"+getArguments().getStringArrayList(question).get(4));
        d_opt.setText("D:"+getArguments().getStringArrayList(question).get(5));
        a_opt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ans == "1"){
                    total++;
                }
                disableOptions(a_opt,b_opt,c_opt,d_opt);
                Toast.makeText(getContext(), "Your response has been submitted", Toast.LENGTH_SHORT).show();

            }


        });
        b_opt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ans == "2"){
                    total++;

                }
                disableOptions(a_opt,b_opt,c_opt,d_opt);
                Toast.makeText(getContext(), "Your response has been submitted", Toast.LENGTH_SHORT).show();


            }
        });
        c_opt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ans == "3"){
                    total++;
                }
                disableOptions(a_opt,b_opt,c_opt,d_opt);
                Toast.makeText(getContext(), "Your response has been submitted", Toast.LENGTH_SHORT).show();

            }
        });
        d_opt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ans == "4"){
                    total++;
                }
                disableOptions(a_opt,b_opt,c_opt,d_opt);
                Toast.makeText(getContext(), "Your response has been submitted", Toast.LENGTH_SHORT).show();

            }
        });



    }
    private void disableOptions(Button a_opt, Button b_opt, Button c_opt, Button d_opt){
        a_opt.setEnabled(false);
        b_opt.setEnabled(false);
        c_opt.setEnabled(false);
        d_opt.setEnabled(false);
    }
}