package com.android.sunny.booklisting;

/**
 * Created by Sunny on 1/8/2017.
 */

public class Books {


    public static final String BOOK_TITLE = "title";
    public static final String BOOK_IMAGE = "smallThumbnail";
    public static final String BOOK_AUTHORS = "authors";
    public static final String BOOK_VOLUME_INFO = "volumeInfo";

    private String mBookTitle;
    private String[] mBookAuthor;
    private String mBookPosterPath;

    public Books(String mBookTitle, String[] mBookAuthor, String mPosterPath) {

        this.mBookAuthor = mBookAuthor;
        this.mBookTitle = mBookTitle;
        this.mBookPosterPath = mPosterPath;
    }

    public String getmBookTitle() {
        return mBookTitle;
    }

    public void setmBookTitle(String mBookTitle) {
        this.mBookTitle = mBookTitle;
    }

    public String getmBookAuthor() {
        String authors = "";
        for (int i = 0; i < mBookAuthor.length; i++) {
            authors = authors + mBookAuthor[i];
        }
        return authors;
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

}
