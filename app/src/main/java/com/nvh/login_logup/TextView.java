package com.nvh.login_logup;

public class TextView {
    private int textViewId;
    private String textViewName;

    public TextView(int textViewId, String textViewName) {
        this.textViewId = textViewId;
        this.textViewName = textViewName;
    }

    public int getTextViewId() {
        return textViewId;
    }

    public String getTextViewName() {
        return textViewName;
    }
}
