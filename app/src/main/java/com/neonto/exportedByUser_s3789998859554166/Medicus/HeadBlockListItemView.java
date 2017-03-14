/*
  This code was generated in Neonto Studio Personal Edition:
  
    http://www.neonto.com
  
  You may use this code ONLY for non-commercial purposes and evaluation.
  Reusing any part of this code for commercial purposes is not permitted.
  
  Would you like to remove this restriction?
  With Neonto's flexible licensing options, you can have your own copyright
  in all this code.
  
  Find out more -- click 'Upgrade to Pro' in Neonto Studio's toolbar.
  
*/

package com.neonto.exportedByUser_s3789998859554166.Medicus;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.*;
import android.util.*;
import android.view.*;
import android.webkit.WebView;
import android.widget.*;

import com.neonto.exportedByUser_s3789998859554166.Medicus.R;

public class HeadBlockListItemView extends FrameLayout implements AdapterView {

    private HeadBlockListItemBitmapView mBitmap;
    private TextView mYourGuide;
    private DataSheet mDataSheet;
    private int mDataSheetRowIndex;
    private ArrayList<AppData.OnLoadingDrawableFinishedListener> mPendingLoadImageListeners = new ArrayList<>();
    private OnContentChangeListener mOnContentChangeListener;
    private Fragment mOwner;
    
    public HeadBlockListItemView(Fragment owner) {
        super(owner.getActivity());
        mOwner = owner;
        init();
    }
    
    public Activity getActivity() {
        return (Activity) getContext();
    }
    
    public FragmentManager getFragmentManager() {
        return getActivity().getFragmentManager();
    }
    
    public void init() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        
        addView(createView(inflater, this, null));
    }

    public View createView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.view_head_block_list_item, container, false);
                
        mBitmap = (HeadBlockListItemBitmapView) rootView.findViewById(R.id.mBitmap);
        mYourGuide = (TextView) rootView.findViewById(R.id.mYourGuide);

        final Context context = getActivity().getBaseContext();
        
        
        mYourGuide.setTypeface(AppData.getTypeface("AvenirNext-DemiBold.ttf", context));

        
        try {
            Bundle bundle = getActivity().getIntent().getExtras();
            final DataSheet dataSheet = AppData.getDataSheetByName(bundle.getString("dataSheetName"));
            final int dataSheetRowIndex = bundle.getInt("dataSheetRowIndex");
            takeValuesFromDataSheet(dataSheet, dataSheetRowIndex);
        } catch (Exception e) {}
        
        rootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (android.os.Build.VERSION.SDK_INT >= 16) {
                    rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                } else {
                    rootView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
                repositionElements();
            }
        });
        
        return rootView;
    }

    @Override
    public void onConfigurationChanged(Configuration config) {
        super.onConfigurationChanged(config);
        
        repositionElements();
    }

    public void sizeToFitContentHeight() {
        // Intentionally left empty.
    }

    public void takeValuesFromDataSheet(DataSheet dataSheet, int rowIndex) {
        HashMap<String, HashMap<String, Object>> row = dataSheet.getRows().get(rowIndex);
        HashMap<String, Object> val;
        
        // Clear pending listeners that were waiting data for the previous values.
        for (AppData.OnLoadingDrawableFinishedListener listener : mPendingLoadImageListeners) {
            mDataSheet.invalidateLoadImageListener(listener);
        }
        mPendingLoadImageListeners = new ArrayList<>();
        
        {
            val = row.get("Bitmap");
            if (val == null) val = row.get("bitmap");  // check lowercase version too
            if (val != null) {
                Object value = val.get("value");
                String type = (String) val.get("type");
                if (value != null && type.equals("image")) {
                    String url = (String) value;
                    final boolean isWebUrl = url.startsWith("http");
                    mBitmap.setVisibility((isWebUrl) ? View.INVISIBLE : View.VISIBLE);  // Prevent flash of old content when loading from a web url
                    AppData.OnLoadingDrawableFinishedListener listener = new AppData.OnLoadingDrawableFinishedListener() {
                        @Override
                        public void onLoadingDrawableFinished(Drawable d) {
                            mBitmap.setImageDrawable(d);
                            repositionElements();
                            if (isWebUrl) {
                                mBitmap.setVisibility(View.VISIBLE);
                                mOnContentChangeListener.onContentChange();
                            }
                            mPendingLoadImageListeners.remove(this);
                        }
                    };
                    mPendingLoadImageListeners.add(listener);
                    dataSheet.loadImage("bitmap", rowIndex, listener);
                } else {
                    mBitmap.setImageDrawable(null);
                }
            }
        }
        {
            val = row.get("Your guide");
            if (val == null) val = row.get("your guide");  // check lowercase version too
            if (val != null) {
                Object value = val.get("value");
                String type = (String) val.get("type");
                if (value != null && type.equals("text")) {
                    mYourGuide.setText((String) value);
                }
            }
        }
        
        mDataSheet = dataSheet;
        mDataSheetRowIndex = rowIndex;
    }

    private HashMap<String, HashMap<String, ArrayList<LayoutDesc>>> mOverrideElementLayoutDescriptors;

    public void setOverrideElementLayoutDescriptors(HashMap<String, HashMap<String, ArrayList<LayoutDesc>>> d)
    {
        mOverrideElementLayoutDescriptors = d;
        repositionElements();
    }

    private static LayoutDesc layoutDescInListForFormat(List<LayoutDesc> layoutDescs, int format) {
        for (LayoutDesc ld : layoutDescs) {
            if (ld.format == format)
                return ld;
        }
        return null;
    }

    private void applyLayoutToView(View v, DisplayMetrics dm, List<LayoutDesc> layoutDescs, boolean affectW, boolean affectH) {
        int winW = dm.widthPixels;
        int winH = dm.heightPixels;
        int dpi = dm.densityDpi;
        boolean isPortrait = winH > winW;
        
        View rootView = getChildAt(0);
        int layoutH = rootView.getLayoutParams().height;

        LayoutDesc ld = null;
        float scale = 1.0f;
        float verticalScale = 1.0f;
        float flowOffset = 0.0f;
        if (isPortrait) {
            if (winW > 768 && dpi < 320 && (ld = layoutDescInListForFormat(layoutDescs, 12)) != null) {
                // use layout 'large phone FullHD'
                scale = winW / 1080.0f;
                verticalScale = winH / 1920.0f;
                flowOffset = 0.0f;
            } else if (winW > 480 && (ld = layoutDescInListForFormat(layoutDescs, 10)) != null) {
                // use layout 'mid-size phone 720p'
                scale = winW / 720.0f;
                verticalScale = winH / 1280.0f;
                flowOffset = 0.0f;
            } else if (winW > 240 && (ld = layoutDescInListForFormat(layoutDescs, 8)) != null) {
                // use layout 'mid-size phone 480p'
                scale = winW / 480.0f;
                verticalScale = winH / 800.0f;
                flowOffset = 0.0f;
            } else {
                // use layout 'small phone 240p'
                ld = layoutDescInListForFormat(layoutDescs, 2);
                scale = winW / 240.0f;
                verticalScale = winH / 320.0f;
                flowOffset = 0.0f;
            }
        } else {
            if (winW > 1280 && (ld = layoutDescInListForFormat(layoutDescs, 11)) != null) {
                // use layout 'large phone FullHD'
                scale = winW / 1920.0f;
                verticalScale = winH / 1080.0f;
                flowOffset = 0.0f;
            } else if (winW > 800.0 && (ld = layoutDescInListForFormat(layoutDescs, 9)) != null) {
                // use layout 'mid-size phone 720p'
                scale = winW / 1280.0f;
                verticalScale = winH / 720.0f;
                flowOffset = 0.0f;
            } else if (winW > 320.0 && (ld = layoutDescInListForFormat(layoutDescs, 7)) != null) {
                // use layout 'mid-size phone 480p'
                scale = winW / 800.0f;
                verticalScale = winH / 480.0f;
                flowOffset = 0.0f;
            } else {
                // use layout 'small phone 240p'
                ld = layoutDescInListForFormat(layoutDescs, 1);
                scale = winW / 320.0f;
                verticalScale = winH / 240.0f;
                flowOffset = 0.0f;
            }
        }
        if (ld == null) {
            Log.d("Fragment", String.format("could not find suitable layout for view %d, window %d*%d", v.getId(), winW, winH));
            return;
        }

        int lx = (int) (ld.x * scale);
        int lt = (ld.t != LayoutDesc.NO_VALUE) ? (int) (ld.t * scale) : -1;
        int lb = (ld.b != LayoutDesc.NO_VALUE) ? (int) (ld.b * scale) : -1;
        int lw = (int) (ld.w * scale);
        // determine height dynamically if it's aligned from both top and bottom
        int lh = (lt != -1 && lb != -1) ? (layoutH - lb - lt) : (int) (ld.h * scale);

        if (v.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) v.getLayoutParams();
            lp.topMargin = lt;
            lp.bottomMargin = lb;
            lp.leftMargin = lx;
            if (affectW) {
                lp.width = lw;
            }
            if (affectH) {
                lp.height = lh;
            }
            v.setLayoutParams(lp);
        } else if (v.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) v.getLayoutParams();
            lp.topMargin = (int) ld.offsetInFlow;
            lp.leftMargin = lx;
            if (affectW) {
                lp.width = lw;
            }
            if (affectH) {
                lp.height = lh;
            }
            v.setLayoutParams(lp);
        } else if (v.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) v.getLayoutParams();
            lp.topMargin = lt;
            lp.bottomMargin = lb;
            lp.leftMargin = lx;
            if (affectW) {
                lp.width = lw;
            }
            if (affectH) {
                lp.height = lh;
            }
            v.setLayoutParams(lp);
        }

        Method m = null;
        try {
            m = v.getClass().getMethod("applyLayoutAndContentTransform", Integer.TYPE, Integer.TYPE, String.class, Float.TYPE);
        } catch (Exception e) {
            // doesn't implement this method, we can safely ignore this exception
        }
        if (m != null) {
            try {
                m.invoke(v, lw, lh, ld.contentTransformMatricesString, scale);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void repositionElements() {
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        
        ArrayList<LayoutDesc> layoutDescs_mBitmap = new ArrayList<LayoutDesc>();
        layoutDescs_mBitmap.add(new LayoutDesc(10, 0.0f, 0.0f, 5.0f, 1015.0f, 378.0f));  // 720*1280 px
        layoutDescs_mBitmap.add(new LayoutDesc(2, 0.0f, 0.0f, 2.0f, 441.0f, 164.0f));  // 240*320 px
        layoutDescs_mBitmap.add(new LayoutDesc(12, 0.0f, 0.0f, 6.0f, 1279.0f, 476.0f));  // 1080*1920 px
        layoutDescs_mBitmap.add(new LayoutDesc(8, 0.0f, 0.0f, 3.0f, 719.0f, 268.0f));  // 480*800 px
        if (mOverrideElementLayoutDescriptors != null) {
            HashMap<String, ArrayList<LayoutDesc>> override_mBitmap = mOverrideElementLayoutDescriptors.get("bitmap");
            if (override_mBitmap != null) {
                ArrayList<LayoutDesc> layoutDescs = override_mBitmap.get("layoutDescs");
                if (layoutDescs != null) {
                    layoutDescs_mBitmap = layoutDescs;
                }
            }
        }
        layoutDescs_mBitmap.get(0).contentTransformMatricesString = "[1.198347107, 0.0, 0.0, 1.198347107, 0.0, -111.185950413]; [1.198347107, 0.0, 0.0, 1.198347107, 0.0, -111.185950413]";
        layoutDescs_mBitmap.get(1).contentTransformMatricesString = "[0.520661157, 0.0, 0.0, 0.520661157, 0.0, -48.425619835]; [0.520661157, 0.0, 0.0, 0.520661157, 0.0, -48.425619835]";
        layoutDescs_mBitmap.get(2).contentTransformMatricesString = "[1.510035419, 0.0, 0.0, 1.510035419, 0.0, -140.263872491]; [1.510035419, 0.0, 0.0, 1.510035419, 0.0, -140.263872491]";
        layoutDescs_mBitmap.get(3).contentTransformMatricesString = "[0.848878394, 0.0, 0.0, 0.848878394, 0.0, -78.644037780]; [0.848878394, 0.0, 0.0, 0.848878394, 0.0, -78.644037780]";
        applyLayoutToView(mBitmap, dm, layoutDescs_mBitmap, true, true);

        ArrayList<LayoutDesc> layoutDescs_mYourGuide = new ArrayList<LayoutDesc>();
        layoutDescs_mYourGuide.add(new LayoutDesc(10, 495.25f, 168.0f, LayoutDesc.NO_VALUE, 440.75f, 214.0f));  // 720*1280 px
        layoutDescs_mYourGuide.add(new LayoutDesc(2, 214.43f, 73.0f, LayoutDesc.NO_VALUE, 191.57f, 98.0f));  // 240*320 px
        layoutDescs_mYourGuide.add(new LayoutDesc(12, 624.08f, 211.0f, LayoutDesc.NO_VALUE, 555.92f, 270.0f));  // 1080*1920 px
        layoutDescs_mYourGuide.add(new LayoutDesc(8, 350.44f, 119.0f, LayoutDesc.NO_VALUE, 312.56f, 154.0f));  // 480*800 px
        if (mOverrideElementLayoutDescriptors != null) {
            HashMap<String, ArrayList<LayoutDesc>> override_mYourGuide = mOverrideElementLayoutDescriptors.get("yourGuide");
            if (override_mYourGuide != null) {
                ArrayList<LayoutDesc> layoutDescs = override_mYourGuide.get("layoutDescs");
                if (layoutDescs != null) {
                    layoutDescs_mYourGuide = layoutDescs;
                }
            }
        }
        applyLayoutToView(mYourGuide, dm, layoutDescs_mYourGuide, true, false);

    }

    public void setOnContentChangeListener(OnContentChangeListener l) {
        mOnContentChangeListener = l;
    }

}
