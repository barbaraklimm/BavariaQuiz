package com.example.android.bavariaquiz;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static android.R.attr.button;
import static android.R.attr.duration;
import static android.R.attr.name;
import static android.R.attr.visible;
import static android.R.id.message;
import static android.view.View.VISIBLE;
import static com.example.android.bavariaquiz.R.id.mCheckMistakes;
import static com.example.android.bavariaquiz.R.id.q8RadioGroup;

public class Questions extends AppCompatActivity {

    private PopupWindow popupWindow;
    private LayoutInflater layoutInflater;
    String name;
    private AlertDialog dialogResult;
    SeekBar q1SeekBarView;
    SeekBar q5SeekBarView;

    @Override
    /* Will be called when activity starts */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        /* Show ActionBar*/
        getSupportActionBar().show();


        /* Get name value from MainActivity */
        Intent intent = getIntent();
        name = intent.getExtras().getString("givenname");
        String namequestion = name + getString(R.string.instructiondialogHeadline);

        /* Build AlertDialog*/
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(Questions.this);


        /* Build layout object*/
        View mView = getLayoutInflater().inflate(R.layout.dialog_instructions, null);

        TextView questionTextView = (TextView) mView.findViewById(R.id.quizquestion);
        questionTextView.setText(namequestion);


        /* Assign layout object to alertdialog */
        mBuilder.setView(mView);


        /* Create alertdialog object*/
        final AlertDialog dialog = mBuilder.create();


        /* Show alertdialog*/
        dialog.show();


        /* Create button*/
        Button mClose = (Button) mView.findViewById(R.id.mclose);


        /* Add event listener to button*/
        mClose.setOnClickListener(new View.OnClickListener(){

            /*Erkennt der Eventlistener einen Klick auf den Button wird diese Methode ausgeführt*/
            public void onClick(View view){
                /*Das AlertDialog Objekt wird ausgeblendet*/
                dialog.hide();
            }
        });

        question1seekbar();
        question5seekbar();

    }

    /* Sets SeekBar function for question 1 */
    public void question1seekbar() {
        q1SeekBarView = (SeekBar) findViewById(R.id.q1SeekBar);
        final TextView seekBarValueView = (TextView) findViewById(R.id.q1SeekBarValue);

        q1SeekBarView.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    int status;

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                        status = progress;

                        switch (status) {

                            case 0:
                                seekBarValueView.setText(getString(R.string.question1selection1));
                                break;

                            case 1:
                                seekBarValueView.setText(getString(R.string.question1selection2));
                               break;

                            case 2:
                                seekBarValueView.setText(getString(R.string.question1selection3));
                                break;
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                            switch (status) {

                                case 0:
                                    seekBarValueView.setText(getString(R.string.question1selection1));
                                    break;

                                case 1:
                                    seekBarValueView.setText(getString(R.string.question1selection2));
                                    break;

                                case 2:
                                    seekBarValueView.setText(getString(R.string.question1selection3));
                                    break;
                            }
                    }
                }
        );
    }

    /* Sets SeekBar function for question 5 */
    public void question5seekbar() {
        q5SeekBarView = (SeekBar) findViewById(R.id.q5SeekBar);
        final TextView seekBarValueView = (TextView) findViewById(R.id.q5SeekBarValue);

        q5SeekBarView.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    int status;

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                        status = progress;

                        switch (status) {

                            case 0:
                                seekBarValueView.setText(getString(R.string.question5selection1));
                                break;

                            case 1:
                                seekBarValueView.setText(getString(R.string.question5selection2));
                                break;

                            case 2:
                                seekBarValueView.setText(getString(R.string.question5selection3));
                                break;
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                        switch (status) {

                            case 0:
                                seekBarValueView.setText(getString(R.string.question5selection1));
                                break;

                            case 1:
                                seekBarValueView.setText(getString(R.string.question5selection2));
                                break;

                            case 2:
                                seekBarValueView.setText(getString(R.string.question5selection3));
                                break;
                        }
                    }
                }
        );
    }

    /* Will be called when the 'result' button is clicked */
    public void goToResult (View view){

        /* Create variable to count correct answers */
            Integer correctAnswers = 0;


         /*Get answers*/

             /*Question 1*/
            LinearLayout q1LLView = (LinearLayout) findViewById(R.id.q1LL);
            TextView q1SeekBarValueView = (TextView) findViewById(R.id.q1SeekBarValue);
            String q1Answer = q1SeekBarValueView.getText().toString();

             /*Question 2 */
            LinearLayout q2LLView = (LinearLayout) findViewById(R.id.q2LL);
            EditText q2TextValueView = (EditText) findViewById(R.id.q2TextValue);
            String q2Answer = q2TextValueView.getText().toString();
            q2Answer = q2Answer.toUpperCase();

             /*Question 3*/
            LinearLayout q3LLView = (LinearLayout) findViewById(R.id.q3LL);
            RadioGroup q3RadioGroupView = (RadioGroup) findViewById(R.id.q3RadioGroup);
            Integer q3RadioButtonID = q3RadioGroupView.getCheckedRadioButtonId();
            View q3RadioButton = q3RadioGroupView.findViewById(q3RadioButtonID);
            int q3Answer = q3RadioGroupView.indexOfChild(q3RadioButton);

             /*Question 4*/
            LinearLayout q4LLView = (LinearLayout) findViewById(R.id.q4LL);
            RadioGroup q4RadioGroupView = (RadioGroup) findViewById(R.id.q4RadioGroup);
            Integer q4RadioButtonID = q4RadioGroupView.getCheckedRadioButtonId();
            View q4RadioButton = q4RadioGroupView.findViewById(q4RadioButtonID);
            int q4Answer = q4RadioGroupView.indexOfChild(q4RadioButton);

             /*Question 5*/
            LinearLayout q5LLView = (LinearLayout) findViewById(R.id.q5LL);
            TextView q5SeekBarValueView = (TextView) findViewById(R.id.q5SeekBarValue);
            String q5Answer = q5SeekBarValueView.getText().toString();

             /*Question 6*/
            LinearLayout q6LLView = (LinearLayout) findViewById(R.id.q6LL);
            RadioGroup q6RadioGroupView = (RadioGroup) findViewById(R.id.q6RadioGroup);
            Integer q6RadioButtonID = q6RadioGroupView.getCheckedRadioButtonId();
            View q6RadioButton = q6RadioGroupView.findViewById(q6RadioButtonID);
            int q6Answer = q6RadioGroupView.indexOfChild(q6RadioButton);

             /*Question 7*/
            LinearLayout q7LLView = (LinearLayout) findViewById(R.id.q7LL);

            CheckBox q7Check1View = (CheckBox) findViewById(R.id.q7Check1);
            CheckBox q7Check2View = (CheckBox) findViewById(R.id.q7Check2);
            CheckBox q7Check3View = (CheckBox) findViewById(R.id.q7Check3);
            CheckBox q7Check4View = (CheckBox) findViewById(R.id.q7Check4);
            CheckBox q7Check5View = (CheckBox) findViewById(R.id.q7Check5);
            CheckBox q7Check6View = (CheckBox) findViewById(R.id.q7Check6);
            CheckBox q7Check7View = (CheckBox) findViewById(R.id.q7Check7);
            CheckBox q7Check8View = (CheckBox) findViewById(R.id.q7Check8);

            Boolean q7Check1checked = q7Check1View.isChecked();
            Boolean q7Check2checked = q7Check2View.isChecked();
            Boolean q7Check3checked = q7Check3View.isChecked();
            Boolean q7Check4checked = q7Check4View.isChecked();
            Boolean q7Check5checked = q7Check5View.isChecked();
            Boolean q7Check6checked = q7Check6View.isChecked();
            Boolean q7Check7checked = q7Check7View.isChecked();
            Boolean q7Check8checked = q7Check8View.isChecked();

             /*Question 8 */
            LinearLayout q8LLView = (LinearLayout) findViewById(R.id.q8LL);

            RadioGroup q8RadioGroupView = (RadioGroup) findViewById(q8RadioGroup);
            Integer q8RadioButtonID = q8RadioGroupView.getCheckedRadioButtonId();
            View q8RadioButton = q8RadioGroupView.findViewById(q8RadioButtonID);
            int q8Answer = q8RadioGroupView.indexOfChild(q8RadioButton);
            int q8AnswerCorrect = 2;

             /*Question 9*/
            LinearLayout q9LLView = (LinearLayout) findViewById(R.id.q9LL);

            CheckBox q9Check1View = (CheckBox) findViewById(R.id.q9Check1);
            CheckBox q9Check2View = (CheckBox) findViewById(R.id.q9Check2);
            CheckBox q9Check3View = (CheckBox) findViewById(R.id.q9Check3);
            CheckBox q9Check4View = (CheckBox) findViewById(R.id.q9Check4);
            CheckBox q9Check5View = (CheckBox) findViewById(R.id.q9Check5);
            CheckBox q9Check6View = (CheckBox) findViewById(R.id.q9Check6);
            CheckBox q9Check7View = (CheckBox) findViewById(R.id.q9Check7);
            CheckBox q9Check8View = (CheckBox) findViewById(R.id.q9Check8);
            CheckBox q9Check9View = (CheckBox) findViewById(R.id.q9Check9);

            Boolean q9Check1checked = q9Check1View.isChecked();
            Boolean q9Check2checked = q9Check2View.isChecked();
            Boolean q9Check3checked = q9Check3View.isChecked();
            Boolean q9Check4checked = q9Check4View.isChecked();
            Boolean q9Check5checked = q9Check5View.isChecked();
            Boolean q9Check6checked = q9Check6View.isChecked();
            Boolean q9Check7checked = q9Check7View.isChecked();
            Boolean q9Check8checked = q9Check8View.isChecked();
            Boolean q9Check9checked = q9Check9View.isChecked();

             /*Question 10*/
            LinearLayout q10LLView = (LinearLayout) findViewById(R.id.q10LL);

            CheckBox q10Check1View = (CheckBox) findViewById(R.id.q10Check1);
            CheckBox q10Check2View = (CheckBox) findViewById(R.id.q10Check2);
            CheckBox q10Check3View = (CheckBox) findViewById(R.id.q10Check3);
            CheckBox q10Check4View = (CheckBox) findViewById(R.id.q10Check4);
            CheckBox q10Check5View = (CheckBox) findViewById(R.id.q10Check5);
            CheckBox q10Check6View = (CheckBox) findViewById(R.id.q10Check6);

            Boolean q10Check1checked = q10Check1View.isChecked();
            Boolean q10Check2checked = q10Check2View.isChecked();
            Boolean q10Check3checked = q10Check3View.isChecked();
            Boolean q10Check4checked = q10Check4View.isChecked();
            Boolean q10Check5checked = q10Check5View.isChecked();
            Boolean q10Check6checked = q10Check6View.isChecked();


        /* Check, if there is an answer for every question*/

            if (q2Answer.matches("")) {
                Toast.makeText(this, getString(R.string.answerQuestion2), Toast.LENGTH_SHORT).show();
                return;
            }
            if (q3RadioButtonID == -1){
                Toast.makeText(this, getString(R.string.answerQuestion3), Toast.LENGTH_SHORT).show();
                return;
            }
            if (q4RadioButtonID == -1){
                Toast.makeText(this, getString(R.string.answerQuestion4), Toast.LENGTH_SHORT).show();
                return;
            }
            if (q6RadioButtonID == -1){
                Toast.makeText(this, getString(R.string.answerQuestion6), Toast.LENGTH_SHORT).show();
                return;
            }
            if(!q7Check1checked && !q7Check2checked && !q7Check3checked && !q7Check4checked && !q7Check5checked
                    && !q7Check6checked && !q7Check7checked && !q7Check8checked){
                Toast.makeText(this, getString(R.string.answerQuestion7), Toast.LENGTH_SHORT).show();
                return;
            }
            if (q8RadioButtonID == -1){
                Toast.makeText(this, getString(R.string.answerQuestion8), Toast.LENGTH_SHORT).show();
                return;
            }
            if ((!q9Check1checked && !q9Check2checked && !q9Check3checked && !q9Check4checked
                    && !q9Check5checked && !q9Check6checked && !q9Check7checked && !q9Check8checked && !q9Check9checked)){
                Toast.makeText(this, getString(R.string.answerQuestion9), Toast.LENGTH_SHORT).show();
            }
            if (!q10Check1checked && !q10Check2checked && !q10Check3checked && !q10Check4checked
                    && !q10Check5checked && !q10Check6checked){
                Toast.makeText(this, getString(R.string.answerQuestion10), Toast.LENGTH_SHORT).show();
                return;
            }


        /* Check if answers are correct
            + count correct answers
            + hide correct answered questions
            + prepare missed questions for review */

            /* Questions 1*/
            String q1AnswerCorrect = "12.8 million";

            if (q1AnswerCorrect.equals(q1Answer)){
                correctAnswers++;
                q1LLView.setVisibility(LinearLayout.GONE);
            } else {
                q1LLView.setBackgroundResource(R.drawable.border);
                q1SeekBarView.setEnabled(false);
            }

            /* Questions 2*/
            String q2AnswerCorrect = "MUNICH";
            if (q2AnswerCorrect.equals(q2Answer)){
                correctAnswers++;
                q2LLView.setVisibility(LinearLayout.GONE);
            } else {
                q2LLView.setBackgroundResource(R.drawable.border);
                q2TextValueView.setFocusable(false);
                q2TextValueView.setClickable(false);
            }

            /* Questions 3*/
            int q3AnswerCorrect = 1;

            if (q3AnswerCorrect == q3Answer){
                correctAnswers++;
                q3LLView.setVisibility(LinearLayout.GONE);
            } else {
                q3LLView.setBackgroundResource(R.drawable.border);
                for(int i = 0; i < q3RadioGroupView.getChildCount(); i++){
                    ((RadioButton)q3RadioGroupView.getChildAt(i)).setEnabled(false);
                }
            }

            /* Questions 4*/
            int q4AnswerCorrect = 2;

            if (q4AnswerCorrect == q4Answer){
                correctAnswers++;
                q4LLView.setVisibility(LinearLayout.GONE);
            } else {
                q4LLView.setBackgroundResource(R.drawable.border);
                q3LLView.setBackgroundResource(R.drawable.border);
                for(int i = 0; i < q4RadioGroupView.getChildCount(); i++){
                    ((RadioButton)q4RadioGroupView.getChildAt(i)).setEnabled(false);
                }
            }

            /* Questions 5*/
            String q5AnswerCorrect = "3 teams";

            if (q5AnswerCorrect.equals(q5Answer)){
                correctAnswers++;
                q5LLView.setVisibility(LinearLayout.GONE);
            } else {
                q5LLView.setBackgroundResource(R.drawable.border);
                q5SeekBarView.setEnabled(false);
            }

            /* Questions 6*/
            int q6AnswerCorrect = 0;

            if (q6AnswerCorrect == q6Answer){
                correctAnswers++;
                q6LLView.setVisibility(LinearLayout.GONE);
            } else {
                q6LLView.setBackgroundResource(R.drawable.border);
                q3LLView.setBackgroundResource(R.drawable.border);
                for(int i = 0; i < q6RadioGroupView.getChildCount(); i++){
                    ((RadioButton)q6RadioGroupView.getChildAt(i)).setEnabled(false);
                }
            }

            /* Questions 7*/
            if(q7Check1checked && q7Check2checked && !q7Check3checked && q7Check4checked
                    && !q7Check5checked && q7Check6checked && !q7Check7checked
                    && !q7Check8checked){
                correctAnswers++;
                q7LLView.setVisibility(LinearLayout.GONE);
            } else {
                q7LLView.setBackgroundResource(R.drawable.border);
                q7Check1View.setEnabled(false);
                q7Check2View.setEnabled(false);
                q7Check3View.setEnabled(false);
                q7Check4View.setEnabled(false);
                q7Check5View.setEnabled(false);
                q7Check6View.setEnabled(false);
                q7Check7View.setEnabled(false);
                q7Check8View.setEnabled(false);
            }

            /* Questions 8*/
            if (q8AnswerCorrect == q8Answer){
                correctAnswers++;
                q8LLView.setVisibility(LinearLayout.GONE);
            } else {
                q8LLView.setBackgroundResource(R.drawable.border);
                q3LLView.setBackgroundResource(R.drawable.border);
                for(int i = 0; i < q8RadioGroupView.getChildCount(); i++){
                    ((RadioButton)q8RadioGroupView.getChildAt(i)).setEnabled(false);
                }
            }

            /* Questions 9*/
            if (q9Check1checked && q9Check2checked && q9Check3checked && q9Check4checked
                    && q9Check5checked && q9Check6checked && !q9Check7checked && q9Check8checked
                    && !q9Check9checked){
                correctAnswers++;
                q9LLView.setVisibility(LinearLayout.GONE);
            } else {
                q9LLView.setBackgroundResource(R.drawable.border);
                q9Check1View.setEnabled(false);
                q9Check2View.setEnabled(false);
                q9Check3View.setEnabled(false);
                q9Check4View.setEnabled(false);
                q9Check5View.setEnabled(false);
                q9Check6View.setEnabled(false);
                q9Check7View.setEnabled(false);
                q9Check8View.setEnabled(false);
                q9Check9View.setEnabled(false);
            }

            /* Questions 10*/
            if (q10Check1checked && !q10Check2checked && !q10Check3checked && !q10Check4checked
                    && !q10Check5checked && !q10Check6checked){
                correctAnswers++;
                q10LLView.setVisibility(LinearLayout.GONE);
            } else {
                q10LLView.setBackgroundResource(R.drawable.border);
                q10Check1View.setEnabled(false);
                q10Check2View.setEnabled(false);
                q10Check3View.setEnabled(false);
                q10Check4View.setEnabled(false);
                q10Check5View.setEnabled(false);
                q10Check6View.setEnabled(false);
            }


        /* Switch buttons*/

            Button buttonGoToResultView = (Button) findViewById(R.id.buttonGoToResult);
            buttonGoToResultView.setVisibility(View.GONE);

            Button buttonBackToResultView = (Button) findViewById(R.id.buttonBackToResult);
            buttonBackToResultView.setVisibility(VISIBLE);


        /* Create content for result message */

            /* Result in numbers*/
            final String  correctAnswersText = correctAnswers.toString() + "/10";

            /* Result text*/
            String resultText;
            if (correctAnswers < 4) {
                resultText = name + getString(R.string.resultless4);
                } else if (correctAnswers < 8) {
                    resultText = getString(R.string.resultless8part1) + name + getString(R.string.resultless8part2);
                    } else {
                        resultText = getString(R.string.resultless10part1) + name + getString(R.string.resultless10part2);
                    }

        /* Create and show an alert dialog to display the result message in it */

            /* Build AlertDialog object */
            AlertDialog.Builder mBuilderResult = new AlertDialog.Builder(Questions.this);

            /* Create view object and initialize it with the layout, that contains the message content */
            View mViewResult = getLayoutInflater().inflate(R.layout.dialog_result, null);


            /* Prepare the message content */

                /* Assign 'result text' value to TextView */
                TextView resultTextView = (TextView) mViewResult.findViewById(R.id.resultText);
                resultTextView.setText(resultText);

                /* Assign 'result in numbers' value to TextView*/
                TextView resultNumberView = (TextView) mViewResult.findViewById(R.id.resultNumber);
                resultNumberView.setText(correctAnswersText);


                /* Button 'Missed questions' */

                    /* Create button object and initialize it with ButtonView*/
                    Button mCheckMistakes = (Button) mViewResult.findViewById(R.id.mCheckMistakes);

                    /* Make sure that Button 'Missed questions' is only visible, if there are missed questions to show*/
                    if (correctAnswers < 10){

                        /* Create EventListener for Button*/
                        mCheckMistakes.setOnClickListener(new View.OnClickListener(){

                            /*Method will be called on click*/
                            public void onClick(View view){

                                /*Method hides alert dialog*/
                                dialogResult.hide();
                            }
                        });
                    } else {

                        /* Button will be hidden if there are no missed questions*/
                        mCheckMistakes.setVisibility(View.GONE);
                        buttonBackToResultView.setVisibility(View.GONE);
                        TextView thankYouTextView = (TextView) findViewById(R.id.thankYouText);
                        thankYouTextView.setVisibility(VISIBLE);
                    }


                /* Button 'Mail a friend' */

                    /* Prepare text for mail*/
                    final String resultMailText;
                    if (correctAnswers < 4) {
                        resultMailText = getString(R.string.resultdescriptionless4);
                    } else if (correctAnswers < 8) {
                        resultMailText = getString(R.string.resultdescriptionless8);
                    } else {
                        resultMailText = getString(R.string.resultdescriptionless10);
                    }

                    /* Create button object and initialize it with ButtonView*/
                    Button mMailAFriend = (Button) mViewResult.findViewById(R.id.mMailAFriend);

                    /* Create EventListener for Button*/
                        mMailAFriend.setOnClickListener(new View.OnClickListener(){

                        /*Method will be called on click*/
                        public void onClick(View view){

                            Intent i = new Intent(Intent.ACTION_SEND);
                            i.setType("message/rfc822");
                            i.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.emailSubject));
                            i.putExtra(Intent.EXTRA_TEXT   , getString(R.string.emailCopyPart1)
                                    + correctAnswersText + getString(R.string.emailCopyPart2)
                                    + resultMailText + getString(R.string.emailCopyPart3) + name);
                            try {
                                startActivity(Intent.createChooser(i, getString(R.string.processMessage)));
                            } catch (android.content.ActivityNotFoundException ex) {
                                Toast.makeText(Questions.this, getString(R.string.exceptionMessage), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

            /* Assign layout object to alert dialog object */
            mBuilderResult.setView(mViewResult);

            /* Create AlertDialog object */
            dialogResult = mBuilderResult.create();

            /* Show AlertDialog object*/
            dialogResult.show();

        }

    /* Will be called when the 'back to result' button is clicked */
        public void backToResult(View view){
                dialogResult.show();
        }
}
