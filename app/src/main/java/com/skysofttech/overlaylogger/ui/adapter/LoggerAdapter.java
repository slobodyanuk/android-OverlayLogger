package com.skysofttech.overlaylogger.ui.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skysofttech.overlaylogger.R;
import com.skysofttech.overlaylogger.domain.Log;
import com.skysofttech.overlaylogger.ui.adapter.holder.LogViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Serhii Slobodianiuk
 * Date: 8/23/17
 */

public class LoggerAdapter extends RecyclerView.Adapter<LogViewHolder> {

    private final Context activity;

    private List<Log> entities;

    public LoggerAdapter(Context activity) {
        this.activity = activity;

        this.entities = new ArrayList<>();
    }

    @Override
    public LogViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_log, parent, false);
        return new LogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LogViewHolder holder, int position) {
        holder.log.setTextColor(ContextCompat.getColor(activity, getLog(position).getType().getColor()));
        holder.log.setText(getLog(position).getLogText());
    }

    public Log getLog(int position) {
        if (entities != null && entities.size() > 0) {
            return entities.get(position);
        }

        return null;
    }

    public void setLogs(List<Log> entities) {
        this.entities = entities;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return entities.size();
    }

    public void insertLog(Log log) {
        entities.add(log);
        notifyItemInserted(getItemCount());
    }
}
