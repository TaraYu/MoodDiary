package com.example.mooddiary.ui.friendmap;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.mooddiary.R;

public class FriendMapFragment extends Fragment {

    private FriendMapViewModel friendMapViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        friendMapViewModel =
                ViewModelProviders.of(this).get(FriendMapViewModel.class);
        View root = inflater.inflate(R.layout.fragment_friend_map, container, false);
        final TextView textView = root.findViewById(R.id.text_tools);
        friendMapViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}