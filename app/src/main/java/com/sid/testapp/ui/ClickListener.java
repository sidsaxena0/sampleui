package com.sid.testapp.ui;

import android.view.View;

import com.sid.testapp.model.Suggestion;

public interface ClickListener {

    void click(View view, Suggestion suggestion);
}
