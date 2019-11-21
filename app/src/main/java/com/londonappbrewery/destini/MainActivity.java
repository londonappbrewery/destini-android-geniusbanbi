package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView storyTextView;
    Button topButton;
    Button bottomButton;

    int currentStoryId = 1;

    private StoryButtons[] mStoryBank = {
            new StoryButtons(R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2, false),
            new StoryButtons(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2, false),
            new StoryButtons(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2, false),
            new StoryButtons(R.string.T4_End, 0, 0, true),
            new StoryButtons(R.string.T5_End, 0, 0, true),
            new StoryButtons(R.string.T6_End, 0, 0, true),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        storyTextView = findViewById(R.id.storyTextView);
        topButton = findViewById(R.id.buttonTop);
        bottomButton = findViewById(R.id.buttonBottom);

        updateStory();

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        topButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StoryButtons currentStory = mStoryBank[(currentStoryId - 1)];
                if( ! currentStory.isEnd() ){
                    nextStory(true);
                } else {
                    restartStory();
                }
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        bottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StoryButtons currentStory = mStoryBank[(currentStoryId - 1)];
                if( ! currentStory.isEnd() ){
                    nextStory(false);
                } else {
                    restartStory();
                }
            }
        });


    }

    private void nextStory(boolean selectTop){
        int originalStoryId = currentStoryId;

        if( originalStoryId == 1 ){
            if( selectTop ){
                currentStoryId = 3;
            } else {
                currentStoryId = 2;
            }
        } else if ( originalStoryId == 2 ) {
            if( selectTop ){
                currentStoryId = 3;
            } else {
                currentStoryId = 4;
            }
        } else if ( originalStoryId == 3 ) {
            if( selectTop ){
                currentStoryId = 6;
            } else {
                currentStoryId = 5;
            }
        }

        updateStory();
    }

    private void restartStory(){
        currentStoryId = 1;

        updateStory();
    }

    private void updateStory(){
        StoryButtons currentStory = mStoryBank[ (currentStoryId - 1) ];
        storyTextView.setText( currentStory.getStoryId() );

        int topButtonId = currentStory.getTopButton();
        if( topButtonId != 0 ){
            topButton.setText( topButtonId );
            topButton.setVisibility(View.VISIBLE);
        } else {
            topButton.setText( R.string.button_end );
            topButton.setVisibility(View.INVISIBLE);
        }

        int bottomButtonId = currentStory.getBottomButton();
        if( bottomButtonId != 0 ){
            bottomButton.setText( bottomButtonId );
//            bottomButton.setVisibility(View.VISIBLE);
        } else {
            bottomButton.setText( R.string.button_end );
//            bottomButton.setVisibility(View.INVISIBLE);
        }
    }
}
