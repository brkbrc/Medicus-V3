package com.neonto.exportedByUser_s3789998859554166.Medicus;

import android.content.*;
import android.content.res.TypedArray;
import android.graphics.*;
import android.text.*;
import android.util.*;
import android.view.*;

public class LoginCapa_1View extends View {



    public LoginCapa_1View(Context context) {
        super(context);
        init(null, 0);
    }
    
    public LoginCapa_1View(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }
    
    public LoginCapa_1View(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }
    
    private void init(AttributeSet attrs, int defStyle) {
        // This method is just a stub that you can extend.
        // If you make this class styleable, you can load XML-declared
        // style attributes using getContext().obtainStyledAttributes().
        
        setLayerType(LAYER_TYPE_HARDWARE, null);
    }


    private int m_realLayoutWidthInPx;
    private int m_realLayoutHeightInPx;

    public void applyLayoutAndContentTransform(int w, int h, String contentTransform, float sc) {
        m_realLayoutWidthInPx = w;
        m_realLayoutHeightInPx = h;
    }
    
    // These drawing objects are created when needed in onDraw().
    // Statics are not thread-safe (reentrant), but this is not an issue
    // because onDraw() is only called on the main thread.
    private static Path[] s_paths = null;
    private static Paint[] s_paints = null;
    
    @Override
    protected void onDraw(Canvas canvas) {
        if (s_paths == null) {
            s_paths = new Path[0];
            s_paints = new Paint[0];
        }
        
        Path path;
        Paint paint;
        
        super.onDraw(canvas);
        
        canvas.save();
        float displayScale = ((m_realLayoutWidthInPx > 0.0f) ? m_realLayoutWidthInPx : canvas.getWidth()) / 202.742603848f;
        canvas.scale(displayScale, displayScale);
        
        canvas.translate(101.371301924f, 70.359393163f);
        //canvas.scale(inff, inff);
        canvas.translate(0.0f, 0.0f);
        
        canvas.save();
        canvas.scale(1.0f, 1.0f);
        
        canvas.restore();
        
        canvas.restore();
    }

}
