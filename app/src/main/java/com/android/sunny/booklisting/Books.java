package com.android.sunny.booklisting;

/**
 * Created by Sunny on 1/8/2017.
 */

public class Books {

    public static final String BOOK_ID = "id";
    public static final String BOOK_TITLE = "title";
    public static final String BOOK_PUBLISHER = "publisher";
    public static final String BOOK_IMAGE = "smallThumbnail";
    public static final String BOOK_AUTHORS = "authors";
    public static final String BOOK_VOLUME_INFO = "volumeInfo";
    private String mBookId;
    private String mBookTitle;
    private String[] mBookAuthor;
    private String mBookPosterPath;
    private String mBookPublisher;


    public Books(String mBookId, String mBookTitle, String[] mBookAuthor, String mPosterPath) {
        this.mBookId = mBookId;
        this.mBookAuthor = mBookAuthor;
        this.mBookTitle = mBookTitle;
        this.mBookPosterPath = mPosterPath;
    }

    public Books(String mBookId, String mBookTitle, String[] mBookAuthor) {
        this.mBookId = mBookId;
        this.mBookAuthor = mBookAuthor;
        this.mBookTitle = mBookTitle;
    }


    public String getmBookId() {
        return mBookId;
    }

    public void setmBookId(String mBookId) {
        this.mBookId = mBookId;
    }

    public String getmBookTitle() {
        return mBookTitle;
    }

    public void setmBookTitle(String mBookTitle) {
        this.mBookTitle = mBookTitle;
    }

    public String[] getmBookAuthor() {
        return mBookAuthor;
    }

    public void setmBookAuthor(String[] mBookAuthor) {
        this.mBookAuthor = mBookAuthor;
    }

    public String getmBookPosterPath() {
        return mBookPosterPath;
    }

    public void setmBookPosterPath(String mBookPosterPath) {
        this.mBookPosterPath = mBookPosterPath;
    }

    public String getmBookPublisher() {
        return mBookPublisher;
    }

    public void setmBookPublisher(String mBookPublisher) {
        this.mBookPublisher = mBookPublisher;
    }
}
