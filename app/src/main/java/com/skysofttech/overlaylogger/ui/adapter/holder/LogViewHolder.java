package com.skysofttech.overlaylogger.ui.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.skysofttech.overlaylogger.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LogViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tvLog)
    public TextView log;

    public LogViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

}