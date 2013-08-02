/**
 * 
 */

package com.andrew.apolloMod.ui.adapters;

import java.util.ArrayList;

import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentManager;

import com.actionbarsherlock.app.SherlockFragment;
import com.andrew.apolloMod.helpers.RefreshableFragment;

/**
 * @author Andrew Neal
 */
public class PagerAdapter extends android.support.v4.app.FragmentPagerAdapter {

    private final ArrayList<SherlockFragment> mFragments = new ArrayList<SherlockFragment>();

    public PagerAdapter(FragmentManager manager) {
        super(manager);
    }

    public void addFragment(SherlockFragment fragment) {
        mFragments.add(fragment);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public SherlockFragment getItem(int position) {
        return mFragments.get(position);
    }

    /**
     * This method update the fragments that extends the {@link RefreshableFragment} class
     */
    public void refresh() {
        for (int i = 0; i < mFragments.size(); i++) {
            if( mFragments.get(i) instanceof RefreshableFragment ) {
                ((RefreshableFragment)mFragments.get(i)).refresh();
            }
        }
    }

}
