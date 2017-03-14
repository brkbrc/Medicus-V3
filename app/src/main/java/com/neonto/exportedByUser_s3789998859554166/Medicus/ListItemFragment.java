package com.neonto.exportedByUser_s3789998859554166.Medicus;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ListItemFragment extends Fragment {

    private ListItemView mView;

    public ListItemFragment() {  // fragment must have a constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = new ListItemView(this);

        return mView;
    }

}
