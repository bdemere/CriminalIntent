package com.bignerdranch.android.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by bubujay on 10/14/15.
 */
public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment(){
        return new CrimeListFragment();
    }
}
