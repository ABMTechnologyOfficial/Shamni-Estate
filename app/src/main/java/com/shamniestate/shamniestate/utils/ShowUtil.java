package com.shamniestate.shamniestate.utils;

import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class ShowUtil {

    public static void longSnack(String text, View view) {
        Snackbar.make(view, text, Snackbar.LENGTH_LONG).show();
    }

    public static void shortSnack(String text, View view) {
        Snackbar.make(view, text, Snackbar.LENGTH_SHORT).show();
    }
}
