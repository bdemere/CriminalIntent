package com.bignerdranch.android.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by bubujay on 10/6/15.
 */
public class Crime {
    private UUID mld;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public Crime(){
        mld = UUID.randomUUID();
        mDate = new Date();
    }

    public Date getDate() {return mDate;}

    public void setDate(Date mDate) {this.mDate = mDate;}

    public void setMld(UUID mld) {this.mld = mld;}

    public void setSolved(boolean mSolved) {this.mSolved = mSolved;}

    public void setTitle(String mTitle) {this.mTitle = mTitle;}

    public UUID getMld() {return mld;}

    public boolean isSolved() {return mSolved;}

    public String getTitle() {return mTitle;}


}
