package com.londonappbrewery.destini;

public class StoryButtons {
    private int mStoryId;
    private int mTopButton;
    private int mBottomButton;
    private boolean mIsEnd;

    StoryButtons(int storyId, int topButton, int bottomButton, boolean isEnd){
        setStoryId(storyId);
        setTopButton(topButton);
        setBottomButton(bottomButton);
        setIsEnd(isEnd);
    }

    public int getStoryId() {
        return mStoryId;
    }

    public void setStoryId(int storyId) {
        mStoryId = storyId;
    }

    public int getTopButton() {
        return mTopButton;
    }

    public void setTopButton(int topButton) {
        mTopButton = topButton;
    }

    public int getBottomButton() {
        return mBottomButton;
    }

    public void setBottomButton(int bottomButton) {
        mBottomButton = bottomButton;
    }

    public boolean isEnd() {
        return mIsEnd;
    }

    public void setIsEnd(boolean end) {
        mIsEnd = end;
    }
}
