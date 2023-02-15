package com.hemanthkumar.quiz;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class Adapter  extends FragmentStateAdapter {
    private int size;
    private String[][] questions;
    public Adapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle,int size,String[][] questions) {
        super(fragmentManager, lifecycle);
        this.size = size;
        this.questions = questions;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = new QuestionsFragment();
        ArrayList<String> question = new ArrayList<>();
        question.add(questions[position][0]);
        question.add(questions[position][1]);
        question.add(questions[position][2]);
        question.add(questions[position][3]);
        question.add(questions[position][4]);
        question.add(questions[position][5]);
        question.add(questions[position][6]);
        Bundle args = new Bundle();
        args.putStringArrayList(QuestionsFragment.question,question);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getItemCount() {
        return size;
    }
}
