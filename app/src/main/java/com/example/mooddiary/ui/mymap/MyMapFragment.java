package com.example.mooddiary.ui.mymap;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.mooddiary.MapsActivity;
import com.example.mooddiary.R;
import com.example.mooddiary.ui.home.HomeViewModel;

/**
 * This is MyMapFragment which shows user's mood event map
 */
public class MyMapFragment extends Fragment {

    private MyMapViewModel myMapViewModel;
    private HomeViewModel viewModelFromHome;
  
    /**
     * This creates the view for the user's mood event map.
     * @param inflater
     *      This is a LayoutInflater object that can be used to inflate any views in the fragment.
     * @param container
     *      This can be null. If non-null, this is the parent view that the fragment's UI should be attached to.
     * @param savedInstanceState
     *      If non-null, this fragment is being re-constructed from a previous saved state as given here.
     * @return
     *      Return the view for the fragment UI
     */
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        myMapViewModel =
                ViewModelProviders.of(this).get(MyMapViewModel.class);
        View root = inflater.inflate(R.layout.fragment_my_map, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);

        viewModelFromHome = ViewModelProviders.of(getActivity()).get(HomeViewModel.class);

        Intent intent = new Intent(getActivity(),MapsActivity.class);
        intent.putExtra("map","mymap");
        intent.putExtra("moodlist",viewModelFromHome.getMoodList().getAllMoodList());
        startActivity(intent);


        return root;
    }
}