package com.example.dev.quizflag;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    // String used when logging error messages
    private static final String TAG ="FlagQuiz Activity";

//    The constant TAG is used when we log error messages using class Log to distinguish
//this Activity’s error messages from others that are being written to the device’s log.

    private static final int FLAGS_IN_QUIZ = 10;

    private List<String> fileNameList; // flag file names
    private List<String> quizCountriesList; // countries in current quiz
    private Set<String> regionsSet; // world regions in current quiz
    private String correctAnswer; // correct country for the current flag
    private int totalGuesses; // number of guessws made
    private int correctAnswers; // number of correct guesses
    private int guessRows; // number of rows displaying guess Buttons
    private SecureRandom random; // used to randomize the quiz
    private Handler handler; // used to delay loading next flag
    private Animation shakeAnimation; // animation for incorrect guess

    private LinearLayout quizLinearLayout; // layout that contains the quiz
    private TextView questionNumberTextView; // shows current question #
    private ImageView flagImageView; // display a flag
    private LinearLayout[] guessLinearLayouts; // rows of answer Buttons
    private TextView answerTextView; // displays correct answer

  // configures the Main
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_main,container,false);

        fileNameList = new ArrayList<>();  // diamond operator
        quizCountriesList = new ArrayList<>();
        random = new SecureRandom();
        handler = new Handler();

        // load the shake animation that's used for incorrect answers
        shakeAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.incorrect_shake);
        shakeAnimation.setRepeatCount(3); // animation repeats 3 times

        // get references to GUI components
        quizLinearLayout = (LinearLayout) view.findViewById(R.id.quizLinearLayout);
        questionNumberTextView = (TextView) view.findViewById(R.id.questionNumberTextView);
        flagImageView = (ImageView) view.findViewById(R.id.flagImageView);


        return inflater.inflate(R.layout.fragment_main, container, false);
    }
}
