package com.example.rentezz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;


public class Frag_current extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {





        View view= inflater.inflate(R.layout.fragment_frag_current, container, false);
        // Inflate the layout for this fragment
        ImageView profileImage = view.findViewById(R.id.profile_image);
        TextView userName = view.findViewById(R.id.user_name);
        //TextView middleContent = view.findViewById(R.id.middle_content);


        // Load image as a circular profile picture using Glide
        Glide.with(this)
                .load(R.drawable.profile)  // Your downloaded image
                .apply(RequestOptions.circleCropTransform())  // Make it circular
                .into(profileImage);

        // Example: Set user name dynamically
        userName.setText("hii!! om bhardwaj");


        return  view;
    }
}