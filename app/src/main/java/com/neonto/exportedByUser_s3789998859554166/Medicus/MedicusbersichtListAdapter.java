package com.neonto.exportedByUser_s3789998859554166.Medicus;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MedicusbersichtListAdapter extends BaseAdapter {

    public int[] filteredRows;

    private DataSheet mDataSheet;

    private Fragment mOwner;

    public MedicusbersichtListAdapter(Fragment owner) {
        mOwner = owner;
    }

    private Activity getActivity() {
        return mOwner.getActivity();
    }
    
    private boolean hasHead() {
        return true;
    }

    @Override
    public int getCount() {
        int numRows;
        if (filteredRows != null) {
            numRows = filteredRows.length;
        } else {
            numRows = (mDataSheet != null) ? mDataSheet.getRows().size() : 0;
        }
        return numRows+(hasHead()?1:0);
    }

    @Override
    public HashMap<String, HashMap<String, Object>> getItem(int position) {
        if ((!hasHead() || position != 0)) {
            int rowIndex = (filteredRows != null && filteredRows.length > 0) ? filteredRows[position] : position;
            return mDataSheet.getRows().get(rowIndex-(hasHead()?1:0));
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        int rowIndex = (filteredRows != null && filteredRows.length > 0) ? filteredRows[position] : position;
        return rowIndex-(hasHead()?1:0);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AdapterView view = (AdapterView) convertView;
        
        boolean isHead = hasHead() && position == 0;

        Class viewClass = (isHead) ? HeadBlockListItemView.class : ListItemView.class;
        if (view == null || !viewClass.isInstance(view)) {
            try {
                view = (AdapterView) viewClass.getConstructor(Fragment.class).newInstance(mOwner);
            }
            catch (Exception e) {
                e.printStackTrace();
                return null;
            }

            view.setOnContentChangeListener(new AdapterView.OnContentChangeListener() {
                @Override
                public void onContentChange() {
                    notifyDataSetChanged();
                }
            });
        }

        if (!isHead) {
            int dataSheetRowIndex = position-(hasHead()?1:0);
            if (filteredRows != null) {
                dataSheetRowIndex = filteredRows[dataSheetRowIndex];
            }
            view.takeValuesFromDataSheet(mDataSheet, dataSheetRowIndex);
        }

        // Expand to fill width of the container.
        View listStencilView = ((ViewGroup) view).getChildAt(0);
        ViewGroup.LayoutParams layoutParams = listStencilView.getLayoutParams();
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        listStencilView.setLayoutParams(layoutParams);
        
        HashMap<String, HashMap<String, ArrayList<LayoutDesc>>> overrides = new HashMap<String, HashMap<String, ArrayList<LayoutDesc>>>();
        HashMap<String, ArrayList<LayoutDesc>> elementDesc;
        ArrayList<LayoutDesc> layoutDescs;
        
        if (isHead) {
            elementDesc = new HashMap();
            layoutDescs = new ArrayList<LayoutDesc>();
            layoutDescs.add(new LayoutDesc(10, 271.25f, 168.0f, LayoutDesc.NO_VALUE, 440.75f, 58.0f));  // 720*1280 px
            layoutDescs.add(new LayoutDesc(2, 44.43f, 73.0f, LayoutDesc.NO_VALUE, 191.57f, 29.0f));  // 240*320 px
            layoutDescs.add(new LayoutDesc(12, 514.08f, 211.0f, LayoutDesc.NO_VALUE, 555.92f, 72.0f));  // 1080*1920 px
            layoutDescs.add(new LayoutDesc(8, 161.44f, 119.0f, LayoutDesc.NO_VALUE, 312.56f, 43.0f));  // 480*800 px
            elementDesc.put("layoutDescs", layoutDescs);
            overrides.put("yourGuide", elementDesc);
            
            elementDesc = new HashMap();
            layoutDescs = new ArrayList<LayoutDesc>();
            layoutDescs.add(new LayoutDesc(10, 0.0f, 0.0f, 5.0f, 791.0f, 378.0f));  // 720*1280 px
            layoutDescs.add(new LayoutDesc(2, 0.0f, 0.0f, 2.0f, 271.0f, 164.0f));  // 240*320 px
            layoutDescs.add(new LayoutDesc(12, 0.0f, 0.0f, 6.0f, 1169.0f, 476.0f));  // 1080*1920 px
            layoutDescs.add(new LayoutDesc(8, 0.0f, 0.0f, 3.0f, 530.0f, 268.0f));  // 480*800 px
            elementDesc.put("layoutDescs", layoutDescs);
            overrides.put("bitmap", elementDesc);
        }
        else {
            elementDesc = new HashMap();
            layoutDescs = new ArrayList<LayoutDesc>();
            layoutDescs.add(new LayoutDesc(10, 418.89f, 22.0f, LayoutDesc.NO_VALUE, 280.11f, 86.0f));  // 720*1280 px
            layoutDescs.add(new LayoutDesc(2, 109.25f, 10.0f, LayoutDesc.NO_VALUE, 121.75f, 42.0f));  // 240*320 px
            layoutDescs.add(new LayoutDesc(12, 699.70f, 28.0f, LayoutDesc.NO_VALUE, 353.30f, 104.0f));  // 1080*1920 px
            layoutDescs.add(new LayoutDesc(8, 266.36f, 16.0f, LayoutDesc.NO_VALUE, 198.64f, 60.0f));  // 480*800 px
            elementDesc.put("layoutDescs", layoutDescs);
            overrides.put("title", elementDesc);
            
            elementDesc = new HashMap();
            layoutDescs = new ArrayList<LayoutDesc>();
            layoutDescs.add(new LayoutDesc(10, 418.89f, 74.0f, LayoutDesc.NO_VALUE, 280.11f, 76.0f));  // 720*1280 px
            layoutDescs.add(new LayoutDesc(2, 109.25f, 32.0f, LayoutDesc.NO_VALUE, 121.75f, 36.0f));  // 240*320 px
            layoutDescs.add(new LayoutDesc(12, 699.70f, 93.0f, LayoutDesc.NO_VALUE, 353.30f, 94.0f));  // 1080*1920 px
            layoutDescs.add(new LayoutDesc(8, 266.36f, 53.0f, LayoutDesc.NO_VALUE, 198.64f, 56.0f));  // 480*800 px
            elementDesc.put("layoutDescs", layoutDescs);
            overrides.put("shortDescription", elementDesc);
            
            elementDesc = new HashMap();
            layoutDescs = new ArrayList<LayoutDesc>();
            layoutDescs.add(new LayoutDesc(10, 0.0f, 0.0f, LayoutDesc.NO_VALUE, 270.0f, 205.0f));  // 720*1280 px
            layoutDescs.add(new LayoutDesc(2, 0.0f, 0.0f, LayoutDesc.NO_VALUE, 117.0f, 89.0f));  // 240*320 px
            layoutDescs.add(new LayoutDesc(12, 0.0f, 0.0f, LayoutDesc.NO_VALUE, 340.0f, 258.0f));  // 1080*1920 px
            layoutDescs.add(new LayoutDesc(8, 0.0f, 0.0f, LayoutDesc.NO_VALUE, 191.0f, 145.0f));  // 480*800 px
            elementDesc.put("layoutDescs", layoutDescs);
            overrides.put("picture", elementDesc);
            
            elementDesc = new HashMap();
            layoutDescs = new ArrayList<LayoutDesc>();
            layoutDescs.add(new LayoutDesc(10, 0.0f, 0.0f, LayoutDesc.NO_VALUE, 720.0f, 204.02f));  // 720*1280 px
            layoutDescs.add(new LayoutDesc(2, 0.0f, 0.0f, LayoutDesc.NO_VALUE, 240.0f, 88.68f));  // 240*320 px
            layoutDescs.add(new LayoutDesc(12, 0.0f, 0.0f, LayoutDesc.NO_VALUE, 1080.0f, 257.32f));  // 1080*1920 px
            layoutDescs.add(new LayoutDesc(8, 0.0f, 0.0f, LayoutDesc.NO_VALUE, 480.0f, 144.68f));  // 480*800 px
            elementDesc.put("layoutDescs", layoutDescs);
            overrides.put("rectangle", elementDesc);
        }
        
        view.setOverrideElementLayoutDescriptors(overrides);
        
        view.sizeToFitContentHeight();

        return (View) view;
    }

    public DataSheet getDataSheet() {
        return mDataSheet;
    }

    public void setDataSheet(DataSheet d) {
        mDataSheet = d;
    }

    public int getColumnWidth() {
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        return 604 * Math.min(dm.widthPixels, dm.heightPixels)/720;
    }

}
