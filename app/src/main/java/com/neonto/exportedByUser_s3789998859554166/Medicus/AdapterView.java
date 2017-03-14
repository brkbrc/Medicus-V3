package com.neonto.exportedByUser_s3789998859554166.Medicus;

import java.util.ArrayList;
import java.util.HashMap;

public interface AdapterView {

    void setOverrideElementLayoutDescriptors(HashMap<String, HashMap<String, ArrayList<LayoutDesc>>> d);

    void takeValuesFromDataSheet(DataSheet dataSheet, int rowIndex);

    void sizeToFitContentHeight();

    void setOnContentChangeListener(OnContentChangeListener l);

    interface OnContentChangeListener {
        void onContentChange();
    }

}
