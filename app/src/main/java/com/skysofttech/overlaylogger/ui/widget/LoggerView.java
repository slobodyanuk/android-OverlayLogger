package com.skysofttech.overlaylogger.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.skysofttech.overlaylogger.domain.Log;
import com.skysofttech.overlaylogger.ui.adapter.LoggerAdapter;

import java.util.List;

/**
 * Author: Serhii Slobodianiuk
 * Date: 8/28/17
 */

@SuppressLint("ViewConstructor")
public class LoggerView extends LinearLayout {

    private final Context context;

    private RecyclerView recyclerView;
    private ScrollingLayoutManager manager;
    private LoggerAdapter adapter;

    public LoggerView(LoggerWidget.Builder builder) {
        super(builder.getContext());
        this.context = builder.getContext();
        setupView();
    }

    private void setupView() {
        recyclerView = new RecyclerView(context);
        recyclerView.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        manager = new ScrollingLayoutManager(context);
        manager.setScrollEnabled(false);

        adapter = new LoggerAdapter(context);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        addView(recyclerView);
    }

    public void setLog(Log log) {
        if (adapter != null) {
            adapter.insertLog(log);
            scrollToBottom();
        }
    }

    public void setLogs(List<Log> logs) {
        if (adapter != null) {
            adapter.setLogs(logs);
            scrollToBottom();
        }
    }

    private void scrollToBottom() {
        if (recyclerView != null) {
            recyclerView.post(new Runnable() {
                @Override
                public void run() {
//                    recyclerView.scrollToPosition(adapter.getItemCount());
                    recyclerView.scrollBy(0, 10000);

                }
            });
        }
    }


}
