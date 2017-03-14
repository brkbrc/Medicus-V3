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

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.MarkerOptions;
import android.location.Geocoder;
import android.location.Address;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.CameraUpdate;

import com.neonto.exportedByUser_s3789998859554166.Medicus.R;

public class Screen4Fragment extends Fragment {

    private Screen4BackgroundShapeView mBackgroundShape;
    private ListView mList;
    private android.support.v7.widget.SwitchCompat mSwitch;
    private com.google.android.gms.maps.MapView mMap;
    private Screen4PickerView mPicker;
    private Screen4Heart5View mHeart5;

    public Screen4Fragment() {  // fragment must have a constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_screen4, container, false);
                
        mBackgroundShape = (Screen4BackgroundShapeView) rootView.findViewById(R.id.mBackgroundShape);
        mList = (ListView) rootView.findViewById(R.id.mList);
        mSwitch = (android.support.v7.widget.SwitchCompat) rootView.findViewById(R.id.mSwitch);
        mMap = (com.google.android.gms.maps.MapView) rootView.findViewById(R.id.mMap);
        mPicker = (Screen4PickerView) rootView.findViewById(R.id.mPicker);
        mHeart5 = (Screen4Heart5View) rootView.findViewById(R.id.mHeart5);

        final Context context = getActivity().getBaseContext();
        
        
        final Screen4ListAdapter screen4ListAdapter = new Screen4ListAdapter(this);
        mList.setAdapter(screen4ListAdapter);

        
        mMap.onCreate(savedInstanceState);
        mMap.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                googleMap.setMyLocationEnabled(true);
                
                MapsInitializer.initialize(getActivity());
                CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(60.170689, 24.942556), 13);
                googleMap.moveCamera(cameraUpdate);
            }
        });

        
        mPicker.setTypeface(AppData.getTypeface("AvenirNext-Regular.ttf", context));

        
        getActivity().setTitle("Screen 4");
        
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
    public void onDestroy() {
        super.onDestroy();
        
        mMap.onDestroy();
        
    }

    @Override
    public void onPause() {
        super.onPause();
        
        mMap.onPause();
        
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        
        mMap.onLowMemory();
        
    }

    @Override
    public void onResume() {
        super.onResume();
        
        mMap.onResume();
        
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
        if (ld.offsetToHorizontalKeylineT != LayoutDesc.NO_VALUE) {
            lt = (int)((ld.t + ld.offsetToHorizontalKeylineT) * verticalScale - ld.offsetToHorizontalKeylineT * scale);
        }
        int lb = (ld.b != LayoutDesc.NO_VALUE) ? (int) (ld.b * scale) : -1;
        if (ld.offsetToHorizontalKeylineB != LayoutDesc.NO_VALUE) {
            lb = (int)((ld.b - ld.offsetToHorizontalKeylineB) * verticalScale + ld.offsetToHorizontalKeylineB * scale);
        }
        int lw = (int) (ld.w * scale);
        // determine height dynamically if it's aligned from both top and bottom
        int lh = (lt != -1 && lb != -1) ? (winH - lb - lt) : (int) (ld.h * scale);

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
        
        ArrayList<LayoutDesc> layoutDescs_mBackgroundShape = new ArrayList<LayoutDesc>();
        layoutDescs_mBackgroundShape.add(new LayoutDesc(10, 0.0f, -48.0f, 0.0f, 720.0f, 1328.0f));  // 720*1280 px
        layoutDescs_mBackgroundShape.add(new LayoutDesc(2, 0.0f, -21.0f, 0.0f, 240.0f, 341.0f));  // 240*320 px
        layoutDescs_mBackgroundShape.add(new LayoutDesc(12, 0.0f, -60.0f, 0.0f, 1080.0f, 1980.0f));  // 1080*1920 px
        layoutDescs_mBackgroundShape.add(new LayoutDesc(8, 0.0f, -34.0f, 0.0f, 480.0f, 834.0f));  // 480*800 px
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

        ArrayList<LayoutDesc> layoutDescs_mList = new ArrayList<LayoutDesc>();
        layoutDescs_mList.add(new LayoutDesc(10, 199.0f, 186.0f, LayoutDesc.NO_VALUE, 468.0f, 426.0f));  // 720*1280 px
        layoutDescs_mList.add(new LayoutDesc(2, 87.0f, 81.0f, LayoutDesc.NO_VALUE, 204.0f, 185.0f));  // 240*320 px
        layoutDescs_mList.add(new LayoutDesc(12, 251.0f, 235.0f, LayoutDesc.NO_VALUE, 590.0f, 537.0f));  // 1080*1920 px
        layoutDescs_mList.add(new LayoutDesc(8, 141.0f, 132.0f, LayoutDesc.NO_VALUE, 332.0f, 302.0f));  // 480*800 px
        if (mOverrideElementLayoutDescriptors != null) {
            HashMap<String, ArrayList<LayoutDesc>> override_mList = mOverrideElementLayoutDescriptors.get("list");
            if (override_mList != null) {
                ArrayList<LayoutDesc> layoutDescs = override_mList.get("layoutDescs");
                if (layoutDescs != null) {
                    layoutDescs_mList = layoutDescs;
                }
            }
        }
        applyLayoutToView(mList, dm, layoutDescs_mList, true, true);

        ArrayList<LayoutDesc> layoutDescs_mSwitch = new ArrayList<LayoutDesc>();
        layoutDescs_mSwitch.add(new LayoutDesc(10, 690.0f, 1028.0f, LayoutDesc.NO_VALUE, 96.0f, 59.0f));  // 720*1280 px
        layoutDescs_mSwitch.add(new LayoutDesc(2, 300.0f, 447.0f, LayoutDesc.NO_VALUE, 42.0f, 26.0f));  // 240*320 px
        layoutDescs_mSwitch.add(new LayoutDesc(12, 870.0f, 1297.0f, LayoutDesc.NO_VALUE, 121.0f, 74.0f));  // 1080*1920 px
        layoutDescs_mSwitch.add(new LayoutDesc(8, 489.0f, 729.0f, LayoutDesc.NO_VALUE, 68.0f, 42.0f));  // 480*800 px
        if (mOverrideElementLayoutDescriptors != null) {
            HashMap<String, ArrayList<LayoutDesc>> override_mSwitch = mOverrideElementLayoutDescriptors.get("switch");
            if (override_mSwitch != null) {
                ArrayList<LayoutDesc> layoutDescs = override_mSwitch.get("layoutDescs");
                if (layoutDescs != null) {
                    layoutDescs_mSwitch = layoutDescs;
                }
            }
        }
        applyLayoutToView(mSwitch, dm, layoutDescs_mSwitch, true, true);

        ArrayList<LayoutDesc> layoutDescs_mMap = new ArrayList<LayoutDesc>();
        layoutDescs_mMap.add(new LayoutDesc(10, 104.0f, 928.0f, LayoutDesc.NO_VALUE, 425.03f, 425.03f));  // 720*1280 px
        layoutDescs_mMap.add(new LayoutDesc(2, 45.0f, 403.0f, LayoutDesc.NO_VALUE, 184.74f, 184.74f));  // 240*320 px
        layoutDescs_mMap.add(new LayoutDesc(12, 131.0f, 1171.0f, LayoutDesc.NO_VALUE, 536.09f, 536.09f));  // 1080*1920 px
        layoutDescs_mMap.add(new LayoutDesc(8, 74.0f, 658.0f, LayoutDesc.NO_VALUE, 301.41f, 301.41f));  // 480*800 px
        if (mOverrideElementLayoutDescriptors != null) {
            HashMap<String, ArrayList<LayoutDesc>> override_mMap = mOverrideElementLayoutDescriptors.get("map");
            if (override_mMap != null) {
                ArrayList<LayoutDesc> layoutDescs = override_mMap.get("layoutDescs");
                if (layoutDescs != null) {
                    layoutDescs_mMap = layoutDescs;
                }
            }
        }
        applyLayoutToView(mMap, dm, layoutDescs_mMap, true, true);

        ArrayList<LayoutDesc> layoutDescs_mPicker = new ArrayList<LayoutDesc>();
        layoutDescs_mPicker.add(new LayoutDesc(10, 307.0f, 730.0f, LayoutDesc.NO_VALUE, 340.03f, 49.0f));  // 720*1280 px
        layoutDescs_mPicker.add(new LayoutDesc(2, 133.0f, 317.0f, LayoutDesc.NO_VALUE, 147.79f, 25.0f));  // 240*320 px
        layoutDescs_mPicker.add(new LayoutDesc(12, 387.0f, 921.0f, LayoutDesc.NO_VALUE, 428.87f, 60.0f));  // 1080*1920 px
        layoutDescs_mPicker.add(new LayoutDesc(8, 218.0f, 518.0f, LayoutDesc.NO_VALUE, 241.13f, 37.0f));  // 480*800 px
        if (mOverrideElementLayoutDescriptors != null) {
            HashMap<String, ArrayList<LayoutDesc>> override_mPicker = mOverrideElementLayoutDescriptors.get("picker");
            if (override_mPicker != null) {
                ArrayList<LayoutDesc> layoutDescs = override_mPicker.get("layoutDescs");
                if (layoutDescs != null) {
                    layoutDescs_mPicker = layoutDescs;
                }
            }
        }
        applyLayoutToView(mPicker, dm, layoutDescs_mPicker, true, true);

        ArrayList<LayoutDesc> layoutDescs_mHeart5 = new ArrayList<LayoutDesc>();
        layoutDescs_mHeart5.add(new LayoutDesc(10, 68.0f, 95.0f, LayoutDesc.NO_VALUE, 417.65f, 192.87f));  // 720*1280 px
        layoutDescs_mHeart5.add(new LayoutDesc(2, 30.0f, 41.0f, LayoutDesc.NO_VALUE, 181.53f, 83.83f));  // 240*320 px
        layoutDescs_mHeart5.add(new LayoutDesc(12, 86.0f, 120.0f, LayoutDesc.NO_VALUE, 526.78f, 243.27f));  // 1080*1920 px
        layoutDescs_mHeart5.add(new LayoutDesc(8, 48.0f, 67.0f, LayoutDesc.NO_VALUE, 296.18f, 136.78f));  // 480*800 px
        if (mOverrideElementLayoutDescriptors != null) {
            HashMap<String, ArrayList<LayoutDesc>> override_mHeart5 = mOverrideElementLayoutDescriptors.get("heart5");
            if (override_mHeart5 != null) {
                ArrayList<LayoutDesc> layoutDescs = override_mHeart5.get("layoutDescs");
                if (layoutDescs != null) {
                    layoutDescs_mHeart5 = layoutDescs;
                }
            }
        }
        applyLayoutToView(mHeart5, dm, layoutDescs_mHeart5, true, true);

    }

}
