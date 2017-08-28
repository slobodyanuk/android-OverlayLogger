package com.skysofttech.overlaylogger.domain;

/**
 * Author: Serhii Slobodianiuk
 * Date: 8/28/17
 */

public class Log {

    private static final int VERBOSE_LOG_COLOR = android.R.color.black;
    private static final int DEBUG_LOG_COLOR = android.R.color.holo_blue_dark;
    private static final int INFO_LOG_COLOR = android.R.color.holo_green_dark;
    private static final int WARN_LOG_COLOR = android.R.color.black;
    private static final int ERROR_LOG_COLOR = android.R.color.holo_red_dark;
    private static final int ASSERT_LOG_COLOR = android.R.color.holo_orange_dark;

    private Type type = Type.VERBOSE;

    private String log;

    public Log(Type type, String log) {
        this.type = type;
        this.log = log;
    }

    public Type getType() {
        return type;
    }

    public String getLogText() {
        return log;
    }

    public enum Type{
        VERBOSE(VERBOSE_LOG_COLOR),
        DEBUG(DEBUG_LOG_COLOR),
        INFO(INFO_LOG_COLOR),
        WARN(WARN_LOG_COLOR),
        ERROR(ERROR_LOG_COLOR),
        ASSERT(ASSERT_LOG_COLOR);

        private final int color;

        Type(int color) {
            this.color = color;
        }

        public int getColor() {
            return color;
        }
    }

}
