package com.raniaandrawaa.kau.contacts;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ContactView  extends RelativeLayout {

    private String stringHeader;
    private Drawable drawableIcon;
    private Drawable drawableLoyoutBg;
    private TextView textView1;
    private ImageView icon;
    private RelativeLayout layout;


    public ContactView(Context context) {
        super(context);
    }



    public ContactView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init() {
        inflate(getContext(),R.layout.card, this);
        this.textView1 = (TextView) findViewById(R.id.header);

        this.icon = (ImageView) findViewById(R.id.icon);
        this.layout = (RelativeLayout) findViewById(R.id.layout_bg);
    }

    private void init(Context context, AttributeSet attrs) {

        init();
        // Getting the attributes.
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.Card, 0, 0);
        try {
            stringHeader = a.getString(R.styleable.Card_my_title_1);
            drawableIcon = a.getDrawable(R.styleable.Card_my_icon);
            drawableLoyoutBg = a.getDrawable(R.styleable.Card_my_bg);

        } finally {
            a.recycle();
        }
        // Setting the attributes to view.
        this.textView1.setText(stringHeader);
        this.icon.setImageDrawable(drawableIcon);
        this.layout.setBackgroundDrawable(drawableLoyoutBg);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        // TODO Auto-generated method stub
        super.onWindowFocusChanged(hasFocus);

        // Getting the height of layout.
        int h = layout.getHeight();
        // I can't set icon height here so I set the padding.
        int p = h / 4;
        this.icon.setPadding(p, p, p, p);
    }


}
