package com.example.rentezz;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Frag_history extends Fragment {
    private RecyclerView recyclerView;
    private HistoryAdaptor adapter;
    private List<HistoryModel> modelList;
    private FirebaseFirestore db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frag_history, container, false);

        recyclerView = view.findViewById(R.id.history_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        modelList = new ArrayList<>();
        adapter = new HistoryAdaptor(getContext(), modelList);
        recyclerView.setAdapter(adapter);

        db = FirebaseFirestore.getInstance();
        fetchHistoryData();

        return view;
    }

    private void fetchHistoryData() {
        String room = "room 8";

        db.collection("users").document(room).collection("curr bill")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            modelList.clear();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                try {
                                    int rent = Integer.parseInt(document.getString("rent"));
                                    int electric = Integer.parseInt(document.getString("electric"));
                                    String date = document.getString("date");
                                    String name = document.getString("name");

                                    modelList.add(new HistoryModel(rent, electric, date, name));
                                } catch (Exception e) {
                                    Log.e("FirestoreError", "Error parsing data", e);
                                }
                            }
                            adapter.notifyDataSetChanged();
                        } else {
                            Log.e("FirestoreError", "Error fetching data", task.getException());
                        }
                    }
                });
    }
}
