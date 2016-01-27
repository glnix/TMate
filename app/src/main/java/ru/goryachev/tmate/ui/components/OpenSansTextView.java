package ru.goryachev.tmate.ui.components;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import ru.goryachev.tmate.R;

public class OpenSansTextView extends TextView {
    public OpenSansTextView(Context context) {
        super(context);

    }

    public OpenSansTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont(context, attrs);
    }

    public OpenSansTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFont();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public OpenSansTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setFont(context, attrs);
    }

    private void setFont() {
        if (!isInEditMode()) {
            Log.d("OpenSansTextView " + getId(), "setFontOpenSans default constructor");
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/OpenSans.ttf");
        }
    }

    private void setFont(Context context, AttributeSet attrs) {
        if (!isInEditMode()) {
            Log.d("View tag", ""+(String) getTag());
            TypedArray a = context.getTheme().obtainStyledAttributes(
                    attrs,
                    R.styleable.OpenSansTextView,
                    0, 0);

            try {
                Typeface tf;
                switch (a.getInt(R.styleable.OpenSansTextView_typeface, 0)) {
                    case 0:
                        Log.d("OpenSansTextView " + getId(), "setFont OpenSans-Normal");
                        tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/OpenSans.ttf");
                        setTypeface(tf);
                        break;
                    case 1:
                        Log.d("OpenSansTextView " + getId(), "setFont OpenSans-Semibold");
                        tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/OpenSans-Semibold.ttf");
                        setTypeface(tf);
                        break;

                    case 2:
                        Log.d("OpenSansTextView " + getId(), "setFont OpenSans-Bold");
                        tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/OpenSans-Bold.ttf");
                        setTypeface(tf);
                        break;

                    case 3:
                        Log.d("OpenSansTextView " + getId(), "setFont OpenSans-Light");
                        tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/OpenSans-Light.ttf");
                        setTypeface(tf);
                        break;
                }
            } finally {
                a.recycle();
            }
        }
    }
}
