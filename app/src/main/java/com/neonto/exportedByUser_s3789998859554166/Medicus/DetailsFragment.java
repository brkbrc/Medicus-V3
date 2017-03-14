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

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

import com.neonto.exportedByUser_s3789998859554166.Medicus.R;

public class DetailsFragment extends Fragment {

    private DetailsBackgroundShapeView mBackgroundShape;
    private DetailsPictureView mPicture;
    private TextView mTitle;
    private DetailsLineView mLine;
    private TextView mPraesentEtDiamEge;
    private ScrollView mFlowScrollView;
    private float mFlowPos;
    private DataSheet mDataSheet;
    private int mDataSheetRowIndex;
    private ArrayList<AppData.OnLoadingDrawableFinishedListener> mPendingLoadImageListeners = new ArrayList<>();

    public DetailsFragment() {  // fragment must have a constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_details, container, false);
                
        mBackgroundShape = (DetailsBackgroundShapeView) rootView.findViewById(R.id.mBackgroundShape);
        mPicture = (DetailsPictureView) rootView.findViewById(R.id.mPicture);
        mTitle = (TextView) rootView.findViewById(R.id.mTitle);
        mLine = (DetailsLineView) rootView.findViewById(R.id.mLine);
        mPraesentEtDiamEge = (TextView) rootView.findViewById(R.id.mPraesentEtDiamEge);

        final Context context = getActivity().getBaseContext();
        
        
        mTitle.setTypeface(AppData.getTypeface("AvenirNext-Medium.ttf", context));

        
        mPraesentEtDiamEge.setTypeface(AppData.getTypeface("AvenirNext-Regular.ttf", context));

        
        getActivity().setTitle("Details");
        mFlowScrollView = (ScrollView) rootView.findViewById(R.id.flowScrollView);
        mFlowScrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
        
            private int m_prevPos = 0;
        
            @Override
            public void onScrollChanged() {
                int scrollPos = mFlowScrollView.getScrollY();
        
                m_prevPos = scrollPos;
            }
        });
        
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
        
        setHasOptionsMenu(true);
        
        return rootView;
    }

    
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        
        ActionBar actionBar = ((ActionBarActivity) getActivity()).getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getActivity().finish();
                return true;
        }
        return false;
    }

    @Override
    public void onConfigurationChanged(Configuration config) {
        super.onConfigurationChanged(config);
        
        final View rootView = getView();
        if (rootView != null) {
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
        }
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
            val = row.get("picture");
            if (val != null) {
                Object value = val.get("value");
                String type = (String) val.get("type");
                if (value != null && type.equals("image")) {
                    String url = (String) value;
                    final boolean isWebUrl = url.startsWith("http");
                    mPicture.setVisibility((isWebUrl) ? View.INVISIBLE : View.VISIBLE);  // Prevent flash of old content when loading from a web url
                    AppData.OnLoadingDrawableFinishedListener listener = new AppData.OnLoadingDrawableFinishedListener() {
                        @Override
                        public void onLoadingDrawableFinished(Drawable d) {
                            mPicture.setImageDrawable(d);
                            repositionElements();
                            if (isWebUrl) {
                                mPicture.setVisibility(View.VISIBLE);
                            }
                            mPendingLoadImageListeners.remove(this);
                        }
                    };
                    mPendingLoadImageListeners.add(listener);
                    dataSheet.loadImage("picture", rowIndex, listener);
                } else {
                    mPicture.setImageDrawable(null);
                }
            }
        }
        {
            val = row.get("title");
            if (val != null) {
                Object value = val.get("value");
                String type = (String) val.get("type");
                if (value != null && type.equals("text")) {
                    mTitle.setText((String) value);
                }
            }
        }
        {
            val = row.get("Praesent et diam ege");
            if (val == null) val = row.get("praesent et diam ege");  // check lowercase version too
            if (val != null) {
                Object value = val.get("value");
                String type = (String) val.get("type");
                if (value != null && type.equals("text")) {
                    mPraesentEtDiamEge.setText((String) value);
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

        LayoutDesc ld = null;
        float scale = 1.0f;
        float verticalScale = 1.0f;
        float flowOffset = 0.0f;
        if (isPortrait) {
            if (winW > 768 && dpi < 320 && (ld = layoutDescInListForFormat(layoutDescs, 12)) != null) {
                // use layout 'large phone FullHD'
                scale = winW / 1080.0f;
                verticalScale = winH / 1920.0f;
                flowOffset = -210.0f;
            } else if (winW > 480 && (ld = layoutDescInListForFormat(layoutDescs, 10)) != null) {
                // use layout 'mid-size phone 720p'
                scale = winW / 720.0f;
                verticalScale = winH / 1280.0f;
                flowOffset = -182.0f;
            } else if (winW > 240 && (ld = layoutDescInListForFormat(layoutDescs, 8)) != null) {
                // use layout 'mid-size phone 480p'
                scale = winW / 480.0f;
                verticalScale = winH / 800.0f;
                flowOffset = -151.0f;
            } else {
                // use layout 'small phone 240p'
                ld = layoutDescInListForFormat(layoutDescs, 2);
                scale = winW / 240.0f;
                verticalScale = winH / 320.0f;
                flowOffset = -122.0f;
            }
        } else {
            if (winW > 1280 && (ld = layoutDescInListForFormat(layoutDescs, 11)) != null) {
                // use layout 'large phone FullHD'
                scale = winW / 1920.0f;
                verticalScale = winH / 1080.0f;
                flowOffset = -210.0f;
            } else if (winW > 800.0 && (ld = layoutDescInListForFormat(layoutDescs, 9)) != null) {
                // use layout 'mid-size phone 720p'
                scale = winW / 1280.0f;
                verticalScale = winH / 720.0f;
                flowOffset = -182.0f;
            } else if (winW > 320.0 && (ld = layoutDescInListForFormat(layoutDescs, 7)) != null) {
                // use layout 'mid-size phone 480p'
                scale = winW / 800.0f;
                verticalScale = winH / 480.0f;
                flowOffset = -151.0f;
            } else {
                // use layout 'small phone 240p'
                ld = layoutDescInListForFormat(layoutDescs, 1);
                scale = winW / 320.0f;
                verticalScale = winH / 240.0f;
                flowOffset = -122.0f;
            }
        }
        if (ld == null) {
            Log.d("Fragment", String.format("could not find suitable layout for view %d, window %d*%d", v.getId(), winW, winH));
            return;
        }

        int lx = (int) (ld.x * scale);
        int lt = (ld.t != LayoutDesc.NO_VALUE) ? (int) (ld.t * scale) : -1;
        if (ld.offsetToHorizontalKeylineT != LayoutDesc.NO_VALUE) {
            lt = (int)((ld.t + ld.offsetToHorizontalKeylineT) * verticalScale - ld.offsetToHorizontalKeylineT * scale);
        }
        if (ld.offsetInFlow != LayoutDesc.NO_VALUE) {
            lt = (int) (mFlowPos + (ld.offsetInFlow + flowOffset) * scale);
        }
        int lb = (ld.b != LayoutDesc.NO_VALUE) ? (int) (ld.b * scale) : -1;
        if (ld.offsetToHorizontalKeylineB != LayoutDesc.NO_VALUE) {
            lb = (int)((ld.b - ld.offsetToHorizontalKeylineB) * verticalScale + ld.offsetToHorizontalKeylineB * scale);
        }
        int lw = (int) (ld.w * scale);
        // determine height dynamically if it's aligned from both top and bottom
        int lh = (lt != -1 && lb != -1) ? (winH - lb - lt) : (int) (ld.h * scale);
        if (ld.offsetInFlow != LayoutDesc.NO_VALUE && !ld.floatsInFlow) {
            mFlowPos += ld.offsetInFlow * scale + lh;
        }

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
        
        View rootView = getView();
        if (rootView != null) {
            // use actual layout dimensions if available.
            if (rootView.getWidth() > 0) dm.widthPixels = rootView.getWidth();
            if (rootView.getHeight() > 0) dm.heightPixels = rootView.getHeight();
        }
        
        mFlowPos = 0.0f;

        ArrayList<LayoutDesc> layoutDescs_mBackgroundShape = new ArrayList<LayoutDesc>();
        layoutDescs_mBackgroundShape.add(new LayoutDesc(10, 0.0f, -182.0f, 0.0f, 720.0f, 1462.0f));  // 720*1280 px
        layoutDescs_mBackgroundShape.add(new LayoutDesc(2, 0.0f, -80.0f, 0.0f, 240.0f, 400.0f));  // 240*320 px
        layoutDescs_mBackgroundShape.add(new LayoutDesc(12, 0.0f, -185.0f, 0.0f, 1080.0f, 2105.0f));  // 1080*1920 px
        layoutDescs_mBackgroundShape.add(new LayoutDesc(8, 0.0f, -151.0f, 0.0f, 480.0f, 951.0f));  // 480*800 px
        if (mOverrideElementLayoutDescriptors != null) {
            HashMap<String, ArrayList<LayoutDesc>> override_mBackgroundShape = mOverrideElementLayoutDescriptors.get("backgroundShape");
            if (override_mBackgroundShape != null) {
                ArrayList<LayoutDesc> layoutDescs = override_mBackgroundShape.get("layoutDescs");
                if (layoutDescs != null) {
                    layoutDescs_mBackgroundShape = layoutDescs;
                }
            }
        }
        applyLayoutToView(mBackgroundShape, dm, layoutDescs_mBackgroundShape, true, true);

        ArrayList<LayoutDesc> layoutDescs_mPicture = new ArrayList<LayoutDesc>();
        layoutDescs_mPicture.add(new LayoutDesc(10, 0.0f, -63.0f, LayoutDesc.NO_VALUE, 720.0f, 435.0f));  // 720*1280 px
        layoutDescs_mPicture.add(new LayoutDesc(2, 0.0f, -28.0f, LayoutDesc.NO_VALUE, 240.0f, 189.0f));  // 240*320 px
        layoutDescs_mPicture.add(new LayoutDesc(12, 0.0f, -35.0f, LayoutDesc.NO_VALUE, 1080.0f, 548.0f));  // 1080*1920 px
        layoutDescs_mPicture.add(new LayoutDesc(8, 0.0f, -67.0f, LayoutDesc.NO_VALUE, 480.0f, 308.0f));  // 480*800 px
        if (mOverrideElementLayoutDescriptors != null) {
            HashMap<String, ArrayList<LayoutDesc>> override_mPicture = mOverrideElementLayoutDescriptors.get("picture");
            if (override_mPicture != null) {
                ArrayList<LayoutDesc> layoutDescs = override_mPicture.get("layoutDescs");
                if (layoutDescs != null) {
                    layoutDescs_mPicture = layoutDescs;
                }
            }
        }
        layoutDescs_mPicture.get(0).contentTransformMatricesString = "[0.875912409, 0.0, 0.0, 0.875912409, 0.0, -52.718978102]; [0.875912409, 0.0, 0.0, 0.875912409, 0.0, -52.718978102]";
        layoutDescs_mPicture.get(1).contentTransformMatricesString = "[0.306320908, 0.0, 0.0, 0.306320908, -5.897893031, 0.0]; [0.306320908, 0.0, 0.0, 0.306320908, -5.897893031, 0.0]";
        layoutDescs_mPicture.get(2).contentTransformMatricesString = "[1.313868613, 0.0, 0.0, 1.313868613, 0.0, -131.328467153]; [1.313868613, 0.0, 0.0, 1.313868613, 0.0, -131.328467153]";
        layoutDescs_mPicture.get(3).contentTransformMatricesString = "[0.583941606, 0.0, 0.0, 0.583941606, 0.0, -26.145985401]; [0.583941606, 0.0, 0.0, 0.583941606, 0.0, -26.145985401]";
        layoutDescs_mPicture.get(0).offsetInFlow = 119.0f;
        layoutDescs_mPicture.get(1).offsetInFlow = 52.0f;
        layoutDescs_mPicture.get(2).offsetInFlow = 150.0f;
        layoutDescs_mPicture.get(3).offsetInFlow = 84.0f;
        applyLayoutToView(mPicture, dm, layoutDescs_mPicture, true, true);

        ArrayList<LayoutDesc> layoutDescs_mTitle = new ArrayList<LayoutDesc>();
        layoutDescs_mTitle.add(new LayoutDesc(10, 59.0f, 431.0f, LayoutDesc.NO_VALUE, 481.95f, 58.0f));  // 720*1280 px
        layoutDescs_mTitle.add(new LayoutDesc(2, 26.0f, 187.0f, LayoutDesc.NO_VALUE, 209.48f, 29.0f));  // 240*320 px
        layoutDescs_mTitle.add(new LayoutDesc(12, 75.0f, 588.0f, LayoutDesc.NO_VALUE, 607.89f, 72.0f));  // 1080*1920 px
        layoutDescs_mTitle.add(new LayoutDesc(8, 42.0f, 283.0f, LayoutDesc.NO_VALUE, 341.78f, 43.0f));  // 480*800 px
        if (mOverrideElementLayoutDescriptors != null) {
            HashMap<String, ArrayList<LayoutDesc>> override_mTitle = mOverrideElementLayoutDescriptors.get("title");
            if (override_mTitle != null) {
                ArrayList<LayoutDesc> layoutDescs = override_mTitle.get("layoutDescs");
                if (layoutDescs != null) {
                    layoutDescs_mTitle = layoutDescs;
                }
            }
        }
        layoutDescs_mTitle.get(0).offsetInFlow = 59.0f;
        layoutDescs_mTitle.get(1).offsetInFlow = 26.0f;
        layoutDescs_mTitle.get(2).offsetInFlow = 75.0f;
        layoutDescs_mTitle.get(3).offsetInFlow = 42.0f;
        applyLayoutToView(mTitle, dm, layoutDescs_mTitle, true, false);

        ArrayList<LayoutDesc> layoutDescs_mLine = new ArrayList<LayoutDesc>();
        layoutDescs_mLine.add(new LayoutDesc(10, 64.0f, 492.0f, LayoutDesc.NO_VALUE, 592.0f, 2.82f));  // 720*1280 px
        layoutDescs_mLine.add(new LayoutDesc(2, 28.0f, 214.0f, LayoutDesc.NO_VALUE, 184.0f, 1.22f));  // 240*320 px
        layoutDescs_mLine.add(new LayoutDesc(12, 81.0f, 665.0f, LayoutDesc.NO_VALUE, 919.0f, 3.55f));  // 1080*1920 px
        layoutDescs_mLine.add(new LayoutDesc(8, 45.0f, 326.0f, LayoutDesc.NO_VALUE, 390.0f, 2.0f));  // 480*800 px
        if (mOverrideElementLayoutDescriptors != null) {
            HashMap<String, ArrayList<LayoutDesc>> override_mLine = mOverrideElementLayoutDescriptors.get("line");
            if (override_mLine != null) {
                ArrayList<LayoutDesc> layoutDescs = override_mLine.get("layoutDescs");
                if (layoutDescs != null) {
                    layoutDescs_mLine = layoutDescs;
                }
            }
        }
        layoutDescs_mLine.get(0).offsetInFlow = 9.0f;
        layoutDescs_mLine.get(1).offsetInFlow = 4.0f;
        layoutDescs_mLine.get(2).offsetInFlow = 11.0f;
        layoutDescs_mLine.get(3).offsetInFlow = 6.0f;
        applyLayoutToView(mLine, dm, layoutDescs_mLine, true, true);

        ArrayList<LayoutDesc> layoutDescs_mPraesentEtDiamEge = new ArrayList<LayoutDesc>();
        layoutDescs_mPraesentEtDiamEge.add(new LayoutDesc(10, 60.0f, 539.82f, LayoutDesc.NO_VALUE, 600.0f, 88.0f));  // 720*1280 px
        layoutDescs_mPraesentEtDiamEge.add(new LayoutDesc(2, 26.0f, 234.22f, LayoutDesc.NO_VALUE, 188.0f, 60.0f));  // 240*320 px
        layoutDescs_mPraesentEtDiamEge.add(new LayoutDesc(12, 75.0f, 724.55f, LayoutDesc.NO_VALUE, 930.0f, 110.0f));  // 1080*1920 px
        layoutDescs_mPraesentEtDiamEge.add(new LayoutDesc(8, 42.0f, 360.0f, LayoutDesc.NO_VALUE, 396.0f, 64.0f));  // 480*800 px
        if (mOverrideElementLayoutDescriptors != null) {
            HashMap<String, ArrayList<LayoutDesc>> override_mPraesentEtDiamEge = mOverrideElementLayoutDescriptors.get("praesentEtDiamEge");
            if (override_mPraesentEtDiamEge != null) {
                ArrayList<LayoutDesc> layoutDescs = override_mPraesentEtDiamEge.get("layoutDescs");
                if (layoutDescs != null) {
                    layoutDescs_mPraesentEtDiamEge = layoutDescs;
                }
            }
        }
        layoutDescs_mPraesentEtDiamEge.get(0).offsetInFlow = 45.0f;
        layoutDescs_mPraesentEtDiamEge.get(1).offsetInFlow = 19.0f;
        layoutDescs_mPraesentEtDiamEge.get(2).offsetInFlow = 56.0f;
        layoutDescs_mPraesentEtDiamEge.get(3).offsetInFlow = 32.0f;
        applyLayoutToView(mPraesentEtDiamEge, dm, layoutDescs_mPraesentEtDiamEge, true, false);

    }

}
