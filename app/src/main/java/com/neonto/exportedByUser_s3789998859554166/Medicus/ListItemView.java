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

public class ListItemView extends FrameLayout implements AdapterView {

    private ListItemRectangleView mRectangle;
    private ListItemPictureView mPicture;
    private TextView mShortDescription;
    private TextView mTitle;
    private DataSheet mDataSheet;
    private int mDataSheetRowIndex;
    private ArrayList<AppData.OnLoadingDrawableFinishedListener> mPendingLoadImageListeners = new ArrayList<>();
    private OnContentChangeListener mOnContentChangeListener;
    private Fragment mOwner;
    
    public ListItemView(Fragment owner) {
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
        final View rootView = inflater.inflate(R.layout.view_list_item, container, false);
                
        mRectangle = (ListItemRectangleView) rootView.findViewById(R.id.mRectangle);
        mPicture = (ListItemPictureView) rootView.findViewById(R.id.mPicture);
        mShortDescription = (TextView) rootView.findViewById(R.id.mShortDescription);
        mTitle = (TextView) rootView.findViewById(R.id.mTitle);
        final Fragment fragment = mOwner;

        final Context context = getActivity().getBaseContext();
        
        mRectangle.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                if (mDataSheet != null) {
                    intent.putExtra("dataSheetName", mDataSheet.getName());
                    intent.putExtra("dataSheetRowIndex", mDataSheetRowIndex);
                }
                getActivity().startActivity(intent);
        
           }
        });

        
        mShortDescription.setTypeface(AppData.getTypeface("AvenirNext-Regular.ttf", context));

        
        mTitle.setTypeface(AppData.getTypeface("AvenirNext-Medium.ttf", context));

        
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
                                mOnContentChangeListener.onContentChange();
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
            val = row.get("short description");
            if (val != null) {
                Object value = val.get("value");
                String type = (String) val.get("type");
                if (value != null && type.equals("text")) {
                    mShortDescription.setText((String) value);
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
        
        ArrayList<LayoutDesc> layoutDescs_mRectangle = new ArrayList<LayoutDesc>();
        layoutDescs_mRectangle.add(new LayoutDesc(10, 0.0f, 0.0f, LayoutDesc.NO_VALUE, 604.0f, 204.02f));  // 720*1280 px
        layoutDescs_mRectangle.add(new LayoutDesc(2, 0.0f, 0.0f, LayoutDesc.NO_VALUE, 262.0f, 88.68f));  // 240*320 px
        layoutDescs_mRectangle.add(new LayoutDesc(12, 0.0f, 0.0f, LayoutDesc.NO_VALUE, 761.0f, 257.32f));  // 1080*1920 px
        layoutDescs_mRectangle.add(new LayoutDesc(8, 0.0f, 0.0f, LayoutDesc.NO_VALUE, 428.0f, 144.68f));  // 480*800 px
        if (mOverrideElementLayoutDescriptors != null) {
            HashMap<String, ArrayList<LayoutDesc>> override_mRectangle = mOverrideElementLayoutDescriptors.get("rectangle");
            if (override_mRectangle != null) {
                ArrayList<LayoutDesc> layoutDescs = override_mRectangle.get("layoutDescs");
                if (layoutDescs != null) {
                    layoutDescs_mRectangle = layoutDescs;
                }
            }
        }
        applyLayoutToView(mRectangle, dm, layoutDescs_mRectangle, true, true);

        ArrayList<LayoutDesc> layoutDescs_mPicture = new ArrayList<LayoutDesc>();
        layoutDescs_mPicture.add(new LayoutDesc(10, 0.0f, 0.0f, LayoutDesc.NO_VALUE, 270.0f, 205.0f));  // 720*1280 px
        layoutDescs_mPicture.add(new LayoutDesc(2, 0.0f, 0.0f, LayoutDesc.NO_VALUE, 117.0f, 89.0f));  // 240*320 px
        layoutDescs_mPicture.add(new LayoutDesc(12, 0.0f, 0.0f, LayoutDesc.NO_VALUE, 340.0f, 258.0f));  // 1080*1920 px
        layoutDescs_mPicture.add(new LayoutDesc(8, 0.0f, 0.0f, LayoutDesc.NO_VALUE, 191.0f, 145.0f));  // 480*800 px
        if (mOverrideElementLayoutDescriptors != null) {
            HashMap<String, ArrayList<LayoutDesc>> override_mPicture = mOverrideElementLayoutDescriptors.get("picture");
            if (override_mPicture != null) {
                ArrayList<LayoutDesc> layoutDescs = override_mPicture.get("layoutDescs");
                if (layoutDescs != null) {
                    layoutDescs_mPicture = layoutDescs;
                }
            }
        }
        layoutDescs_mPicture.get(0).contentTransformMatricesString = "[0.332252836, 0.0, 0.0, 0.332252836, -1.555915721, 0.0]; [0.332252836, 0.0, 0.0, 0.332252836, -1.555915721, 0.0]";
        layoutDescs_mPicture.get(1).contentTransformMatricesString = "[0.144246353, 0.0, 0.0, 0.144246353, -0.785251216, 0.0]; [0.144246353, 0.0, 0.0, 0.144246353, -0.785251216, 0.0]";
        layoutDescs_mPicture.get(2).contentTransformMatricesString = "[0.418152350, 0.0, 0.0, 0.418152350, -1.860615883, 0.0]; [0.418152350, 0.0, 0.0, 0.418152350, -1.860615883, 0.0]";
        layoutDescs_mPicture.get(3).contentTransformMatricesString = "[0.235008104, 0.0, 0.0, 0.235008104, -1.088330632, 0.0]; [0.235008104, 0.0, 0.0, 0.235008104, -1.088330632, 0.0]";
        applyLayoutToView(mPicture, dm, layoutDescs_mPicture, true, true);

        ArrayList<LayoutDesc> layoutDescs_mShortDescription = new ArrayList<LayoutDesc>();
        layoutDescs_mShortDescription.add(new LayoutDesc(10, 302.89f, 74.0f, LayoutDesc.NO_VALUE, 280.11f, 76.0f));  // 720*1280 px
        layoutDescs_mShortDescription.add(new LayoutDesc(2, 131.25f, 32.0f, LayoutDesc.NO_VALUE, 121.75f, 36.0f));  // 240*320 px
        layoutDescs_mShortDescription.add(new LayoutDesc(12, 380.70f, 93.0f, LayoutDesc.NO_VALUE, 353.30f, 94.0f));  // 1080*1920 px
        layoutDescs_mShortDescription.add(new LayoutDesc(8, 214.36f, 53.0f, LayoutDesc.NO_VALUE, 198.64f, 56.0f));  // 480*800 px
        if (mOverrideElementLayoutDescriptors != null) {
            HashMap<String, ArrayList<LayoutDesc>> override_mShortDescription = mOverrideElementLayoutDescriptors.get("shortDescription");
            if (override_mShortDescription != null) {
                ArrayList<LayoutDesc> layoutDescs = override_mShortDescription.get("layoutDescs");
                if (layoutDescs != null) {
                    layoutDescs_mShortDescription = layoutDescs;
                }
            }
        }
        applyLayoutToView(mShortDescription, dm, layoutDescs_mShortDescription, true, false);

        ArrayList<LayoutDesc> layoutDescs_mTitle = new ArrayList<LayoutDesc>();
        layoutDescs_mTitle.add(new LayoutDesc(10, 302.89f, 22.0f, LayoutDesc.NO_VALUE, 280.11f, 46.0f));  // 720*1280 px
        layoutDescs_mTitle.add(new LayoutDesc(2, 131.25f, 10.0f, LayoutDesc.NO_VALUE, 121.75f, 24.0f));  // 240*320 px
        layoutDescs_mTitle.add(new LayoutDesc(12, 380.70f, 28.0f, LayoutDesc.NO_VALUE, 353.30f, 55.0f));  // 1080*1920 px
        layoutDescs_mTitle.add(new LayoutDesc(8, 214.36f, 16.0f, LayoutDesc.NO_VALUE, 198.64f, 33.0f));  // 480*800 px
        if (mOverrideElementLayoutDescriptors != null) {
            HashMap<String, ArrayList<LayoutDesc>> override_mTitle = mOverrideElementLayoutDescriptors.get("title");
            if (override_mTitle != null) {
                ArrayList<LayoutDesc> layoutDescs = override_mTitle.get("layoutDescs");
                if (layoutDescs != null) {
                    layoutDescs_mTitle = layoutDescs;
                }
            }
        }
        applyLayoutToView(mTitle, dm, layoutDescs_mTitle, true, false);

    }

    public void setOnContentChangeListener(OnContentChangeListener l) {
        mOnContentChangeListener = l;
    }

}
