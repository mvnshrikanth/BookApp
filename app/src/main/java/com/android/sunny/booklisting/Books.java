package com.android.sunny.booklisting;

/**
 * Created by Sunny on 1/8/2017.
 */

public class Books {

    private int mBookId;
    private String mBookTitle;
    private String mBookAuthor;
    private String mPosterPath;

    public Books(int mBookId, String mBookTitle, String mBookAuthor, String mPosterPath) {
        this.mBookId = mBookId;
        this.mBookAuthor = mBookAuthor;
        this.mBookTitle = mBookTitle;
        this.mPosterPath = mPosterPath;
    }

    public Books(int mBookId, String mBookTitle, String mBookAuthor) {
        this.mBookId = mBookId;
        this.mBookAuthor = mBookAuthor;
        this.mBookTitle = mBookTitle;
    }


    public int getmBookId() {
        return mBookId;
    }

    public void setmBookId(int mBookId) {
        this.mBookId = mBookId;
    }

    public String getmBookTitle() {
        return mBookTitle;
    }

    public void setmBookTitle(String mBookTitle) {
        this.mBookTitle = mBookTitle;
    }

    public String getmBookAuthor() {
        return mBookAuthor;
    }

    public void setmBookAuthor(String mBookAuthor) {
        this.mBookAuthor = mBookAuthor;
    }

    public String getmPosterPath() {
        return mPosterPath;
    }

    public void setmPosterPath(String mPosterPath) {
        this.mPosterPath = mPosterPath;
    }
}
