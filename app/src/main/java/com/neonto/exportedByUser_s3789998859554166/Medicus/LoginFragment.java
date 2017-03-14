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

public class LoginFragment extends Fragment {

    private LoginBitmapView mBitmap;
    private LoginCapa_1View mCapa_1;
    private TextView mLAPLAND;
    private EditText mField;
    private EditText mFieldCopy;
    private Button mButton;
    private LoginHeart_BlueView mHeart_Blue;
    private Button mButton2;

    public LoginFragment() {  // fragment must have a constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_login, container, false);
                
        mBitmap = (LoginBitmapView) rootView.findViewById(R.id.mBitmap);
        mCapa_1 = (LoginCapa_1View) rootView.findViewById(R.id.mCapa_1);
        mLAPLAND = (TextView) rootView.findViewById(R.id.mLAPLAND);
        mField = (EditText) rootView.findViewById(R.id.mField);
        mFieldCopy = (EditText) rootView.findViewById(R.id.mFieldCopy);
        mButton = (Button) rootView.findViewById(R.id.mButton);
        mHeart_Blue = (LoginHeart_BlueView) rootView.findViewById(R.id.mHeart_Blue);
        mButton2 = (Button) rootView.findViewById(R.id.mButton2);
        final LoginFragment fragment = this;

        final Context context = getActivity().getBaseContext();
        
        
        mLAPLAND.setTypeface(AppData.getTypeface("AvenirNext-DemiBold.ttf", context));

        
        mField.setBackgroundColor(android.graphics.Color.WHITE);
        mField.setTypeface(AppData.getTypeface("AvenirNext-Regular.ttf", context));

        
        mFieldCopy.setBackgroundColor(android.graphics.Color.WHITE);
        mFieldCopy.setTypeface(AppData.getTypeface("AvenirNext-Regular.ttf", context));

        
        mButton.setTransformationMethod(null);
        mButton.setTypeface(AppData.getTypeface("AvenirNext-Regular.ttf", context));
        mButton.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MedicusbersichtActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                getActivity().startActivity(intent);
        
           }
        });

        
        mButton2.setTransformationMethod(null);
        mButton2.setTypeface(AppData.getTypeface("AvenirNext-Regular.ttf", context));
        mButton2.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Screen4Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                getActivity().startActivity(intent);
        
           }
        });

        
        getActivity().setTitle("Login");
        
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
        
        ArrayList<LayoutDesc> layoutDescs_mBitmap = new ArrayList<LayoutDesc>();
        layoutDescs_mBitmap.add(new LayoutDesc(10, -37.0f, -27.0f, -35.0f, 757.0f, 1342.0f));  // 720*1280 px
        layoutDescs_mBitmap.add(new LayoutDesc(2, -16.0f, -12.0f, -15.0f, 256.0f, 347.0f));  // 240*320 px
        layoutDescs_mBitmap.add(new LayoutDesc(12, -46.0f, -34.0f, -44.0f, 1126.0f, 1998.0f));  // 1080*1920 px
        layoutDescs_mBitmap.add(new LayoutDesc(8, -26.0f, -19.0f, -25.0f, 506.0f, 844.0f));  // 480*800 px
        if (mOverrideElementLayoutDescriptors != null) {
            HashMap<String, ArrayList<LayoutDesc>> override_mBitmap = mOverrideElementLayoutDescriptors.get("bitmap");
            if (override_mBitmap != null) {
                ArrayList<LayoutDesc> layoutDescs = override_mBitmap.get("layoutDescs");
                if (layoutDescs != null) {
                    layoutDescs_mBitmap = layoutDescs;
                }
            }
        }
        layoutDescs_mBitmap.get(0).contentTransformMatricesString = "[1.895480226, 0.0, 0.0, 1.895480226, -178.771186441, 0.0]; [1.895480226, 0.0, 0.0, 1.895480226, -171.189265537, 440.699152542]";
        layoutDescs_mBitmap.get(1).contentTransformMatricesString = "[0.490112994, 0.0, 0.0, 0.490112994, -16.093220339, 0.0]; [0.490112994, 0.0, 0.0, 0.490112994, -14.132768362, 113.951271186]";
        layoutDescs_mBitmap.get(2).contentTransformMatricesString = "[2.822033898, 0.0, 0.0, 2.822033898, -266.677966102, 0.0]; [2.822033898, 0.0, 0.0, 2.822033898, -255.389830508, 656.122881356]";
        layoutDescs_mBitmap.get(3).contentTransformMatricesString = "[1.192090395, 0.0, 0.0, 1.192090395, -97.474576271, 0.0]; [1.192090395, 0.0, 0.0, 1.192090395, -92.706214689, 277.161016949]";
        applyLayoutToView(mBitmap, dm, layoutDescs_mBitmap, true, true);

        ArrayList<LayoutDesc> layoutDescs_mCapa_1 = new ArrayList<LayoutDesc>();
        layoutDescs_mCapa_1.add(new LayoutDesc(10, 280.0f, 109.0f, LayoutDesc.NO_VALUE, 160.74f, 111.57f));  // 720*1280 px
        layoutDescs_mCapa_1.add(new LayoutDesc(2, 85.0f, 47.0f, LayoutDesc.NO_VALUE, 69.87f, 48.49f));  // 240*320 px
        layoutDescs_mCapa_1.add(new LayoutDesc(12, 439.0f, 138.0f, LayoutDesc.NO_VALUE, 202.74f, 140.72f));  // 1080*1920 px
        layoutDescs_mCapa_1.add(new LayoutDesc(8, 183.0f, 77.0f, LayoutDesc.NO_VALUE, 113.99f, 79.12f));  // 480*800 px
        if (mOverrideElementLayoutDescriptors != null) {
            HashMap<String, ArrayList<LayoutDesc>> override_mCapa_1 = mOverrideElementLayoutDescriptors.get("capa_1");
            if (override_mCapa_1 != null) {
                ArrayList<LayoutDesc> layoutDescs = override_mCapa_1.get("layoutDescs");
                if (layoutDescs != null) {
                    layoutDescs_mCapa_1 = layoutDescs;
                }
            }
        }
        applyLayoutToView(mCapa_1, dm, layoutDescs_mCapa_1, true, true);

        ArrayList<LayoutDesc> layoutDescs_mLAPLAND = new ArrayList<LayoutDesc>();
        layoutDescs_mLAPLAND.add(new LayoutDesc(10, 132.0f, 266.0f, LayoutDesc.NO_VALUE, 456.32f, 88.0f));  // 720*1280 px
        layoutDescs_mLAPLAND.add(new LayoutDesc(2, 21.0f, 115.0f, LayoutDesc.NO_VALUE, 198.34f, 41.0f));  // 240*320 px
        layoutDescs_mLAPLAND.add(new LayoutDesc(12, 252.0f, 336.0f, LayoutDesc.NO_VALUE, 575.56f, 108.0f));  // 1080*1920 px
        layoutDescs_mLAPLAND.add(new LayoutDesc(8, 78.0f, 189.0f, LayoutDesc.NO_VALUE, 323.60f, 63.0f));  // 480*800 px
        if (mOverrideElementLayoutDescriptors != null) {
            HashMap<String, ArrayList<LayoutDesc>> override_mLAPLAND = mOverrideElementLayoutDescriptors.get("lAPLAND");
            if (override_mLAPLAND != null) {
                ArrayList<LayoutDesc> layoutDescs = override_mLAPLAND.get("layoutDescs");
                if (layoutDescs != null) {
                    layoutDescs_mLAPLAND = layoutDescs;
                }
            }
        }
        applyLayoutToView(mLAPLAND, dm, layoutDescs_mLAPLAND, true, false);

        ArrayList<LayoutDesc> layoutDescs_mField = new ArrayList<LayoutDesc>();
        layoutDescs_mField.add(new LayoutDesc(10, 106.88f, 558.0f, LayoutDesc.NO_VALUE, 529.75f, 72.26f));  // 720*1280 px
        layoutDescs_mField.add(new LayoutDesc(2, 35.62f, 242.0f, LayoutDesc.NO_VALUE, 177.25f, 31.41f));  // 240*320 px
        layoutDescs_mField.add(new LayoutDesc(12, 160.31f, 704.0f, LayoutDesc.NO_VALUE, 794.12f, 91.14f));  // 1080*1920 px
        layoutDescs_mField.add(new LayoutDesc(8, 71.25f, 395.0f, LayoutDesc.NO_VALUE, 353.5f, 51.24f));  // 480*800 px
        if (mOverrideElementLayoutDescriptors != null) {
            HashMap<String, ArrayList<LayoutDesc>> override_mField = mOverrideElementLayoutDescriptors.get("field");
            if (override_mField != null) {
                ArrayList<LayoutDesc> layoutDescs = override_mField.get("layoutDescs");
                if (layoutDescs != null) {
                    layoutDescs_mField = layoutDescs;
                }
            }
        }
        applyLayoutToView(mField, dm, layoutDescs_mField, true, false);

        ArrayList<LayoutDesc> layoutDescs_mFieldCopy = new ArrayList<LayoutDesc>();
        layoutDescs_mFieldCopy.add(new LayoutDesc(10, 106.88f, 674.0f, LayoutDesc.NO_VALUE, 529.75f, 72.26f));  // 720*1280 px
        layoutDescs_mFieldCopy.add(new LayoutDesc(2, 35.62f, 293.0f, LayoutDesc.NO_VALUE, 177.25f, 31.41f));  // 240*320 px
        layoutDescs_mFieldCopy.add(new LayoutDesc(12, 160.31f, 850.0f, LayoutDesc.NO_VALUE, 794.12f, 91.14f));  // 1080*1920 px
        layoutDescs_mFieldCopy.add(new LayoutDesc(8, 71.25f, 478.0f, LayoutDesc.NO_VALUE, 353.5f, 51.24f));  // 480*800 px
        if (mOverrideElementLayoutDescriptors != null) {
            HashMap<String, ArrayList<LayoutDesc>> override_mFieldCopy = mOverrideElementLayoutDescriptors.get("fieldCopy");
            if (override_mFieldCopy != null) {
                ArrayList<LayoutDesc> layoutDescs = override_mFieldCopy.get("layoutDescs");
                if (layoutDescs != null) {
                    layoutDescs_mFieldCopy = layoutDescs;
                }
            }
        }
        applyLayoutToView(mFieldCopy, dm, layoutDescs_mFieldCopy, true, false);

        ArrayList<LayoutDesc> layoutDescs_mButton = new ArrayList<LayoutDesc>();
        layoutDescs_mButton.add(new LayoutDesc(10, 106.88f, 800.0f, LayoutDesc.NO_VALUE, 529.75f, 63.76f));  // 720*1280 px
        layoutDescs_mButton.add(new LayoutDesc(2, 35.62f, 347.0f, LayoutDesc.NO_VALUE, 177.25f, 27.71f));  // 240*320 px
        layoutDescs_mButton.add(new LayoutDesc(12, 160.31f, 1009.0f, LayoutDesc.NO_VALUE, 794.12f, 80.41f));  // 1080*1920 px
        layoutDescs_mButton.add(new LayoutDesc(8, 71.25f, 567.0f, LayoutDesc.NO_VALUE, 353.5f, 45.21f));  // 480*800 px
        if (mOverrideElementLayoutDescriptors != null) {
            HashMap<String, ArrayList<LayoutDesc>> override_mButton = mOverrideElementLayoutDescriptors.get("button");
            if (override_mButton != null) {
                ArrayList<LayoutDesc> layoutDescs = override_mButton.get("layoutDescs");
                if (layoutDescs != null) {
                    layoutDescs_mButton = layoutDescs;
                }
            }
        }
        applyLayoutToView(mButton, dm, layoutDescs_mButton, true, true);

        ArrayList<LayoutDesc> layoutDescs_mHeart_Blue = new ArrayList<LayoutDesc>();
        layoutDescs_mHeart_Blue.add(new LayoutDesc(10, 356.0f, 120.0f, LayoutDesc.NO_VALUE, 176.0f, 138.0f));  // 720*1280 px
        layoutDescs_mHeart_Blue.add(new LayoutDesc(2, 155.0f, 52.0f, LayoutDesc.NO_VALUE, 77.0f, 60.0f));  // 240*320 px
        layoutDescs_mHeart_Blue.add(new LayoutDesc(12, 450.0f, 152.0f, LayoutDesc.NO_VALUE, 222.0f, 174.0f));  // 1080*1920 px
        layoutDescs_mHeart_Blue.add(new LayoutDesc(8, 253.0f, 85.0f, LayoutDesc.NO_VALUE, 125.0f, 98.0f));  // 480*800 px
        if (mOverrideElementLayoutDescriptors != null) {
            HashMap<String, ArrayList<LayoutDesc>> override_mHeart_Blue = mOverrideElementLayoutDescriptors.get("heart_Blue");
            if (override_mHeart_Blue != null) {
                ArrayList<LayoutDesc> layoutDescs = override_mHeart_Blue.get("layoutDescs");
                if (layoutDescs != null) {
                    layoutDescs_mHeart_Blue = layoutDescs;
                }
            }
        }
        layoutDescs_mHeart_Blue.get(0).contentTransformMatricesString = "[0.228099174, 0.0, 0.0, 0.228099174, -1.300826446, 0.0]; [0.228099174, 0.0, 0.0, 0.228099174, -1.300826446, 0.0]";
        layoutDescs_mHeart_Blue.get(1).contentTransformMatricesString = "[0.099173554, 0.0, 0.0, 0.099173554, -0.326446281, 0.0]; [0.099173554, 0.0, 0.0, 0.099173554, -0.326446281, 0.0]";
        layoutDescs_mHeart_Blue.get(2).contentTransformMatricesString = "[0.287603306, 0.0, 0.0, 0.287603306, -1.596694215, 0.0]; [0.287603306, 0.0, 0.0, 0.287603306, -1.596694215, 0.0]";
        layoutDescs_mHeart_Blue.get(3).contentTransformMatricesString = "[0.161983471, 0.0, 0.0, 0.161983471, -0.916528926, 0.0]; [0.161983471, 0.0, 0.0, 0.161983471, -0.916528926, 0.0]";
        applyLayoutToView(mHeart_Blue, dm, layoutDescs_mHeart_Blue, true, true);

        ArrayList<LayoutDesc> layoutDescs_mButton2 = new ArrayList<LayoutDesc>();
        layoutDescs_mButton2.add(new LayoutDesc(10, 381.0f, 1059.0f, LayoutDesc.NO_VALUE, 212.52f, 63.76f));  // 720*1280 px
        layoutDescs_mButton2.add(new LayoutDesc(2, 165.0f, 460.0f, LayoutDesc.NO_VALUE, 92.37f, 27.71f));  // 240*320 px
        layoutDescs_mButton2.add(new LayoutDesc(12, 480.0f, 1336.0f, LayoutDesc.NO_VALUE, 268.05f, 80.41f));  // 1080*1920 px
        layoutDescs_mButton2.add(new LayoutDesc(8, 270.0f, 751.0f, LayoutDesc.NO_VALUE, 150.71f, 45.21f));  // 480*800 px
        if (mOverrideElementLayoutDescriptors != null) {
            HashMap<String, ArrayList<LayoutDesc>> override_mButton2 = mOverrideElementLayoutDescriptors.get("button2");
            if (override_mButton2 != null) {
                ArrayList<LayoutDesc> layoutDescs = override_mButton2.get("layoutDescs");
                if (layoutDescs != null) {
                    layoutDescs_mButton2 = layoutDescs;
                }
            }
        }
        applyLayoutToView(mButton2, dm, layoutDescs_mButton2, false, true);

    }

}
