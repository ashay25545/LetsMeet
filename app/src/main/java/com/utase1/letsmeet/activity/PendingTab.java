package com.utase1.letsmeet.activity;

/**
 * Created by akilesh on 10/16/2015.
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.utase1.letsmeet.R;

/**
 * Created by hp1 on 21-01-2015.
 */
public class PendingTab extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_pending_tab,container,false);
        return v;
    }
}