package com.skysofttech.overlaylogger.ui.widget;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

/**
 * Author: Serhii Slobodianiuk
 * Date: 8/28/17
 */

public class ScrollingLayoutManager extends LinearLayoutManager {

    private boolean isScrollEnabled;

    public ScrollingLayoutManager(Context context) {
        super(context);
    }

    public void setScrollEnabled(boolean scrollEnabled) {
        isScrollEnabled = scrollEnabled;
    }

    @Override
    public boolean canScrollVertically() {
        return isScrollEnabled && super.canScrollVertically();
    }
}
