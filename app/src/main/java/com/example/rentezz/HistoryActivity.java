package com.example.rentezz;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private RecyclerView recyclerView;
    private HistoryAdaptor adapter;
    private List<HistoryModel> modelList;
    private void fetchDataFromFirestore(String room) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_history);


        recyclerView = findViewById(R.id.history_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        modelList = new ArrayList<>();
        adapter = new HistoryAdaptor(this, modelList);
        recyclerView.setAdapter(adapter);
        String room= getIntent().getStringExtra("room_number");
        db.collection("users").document(room).collection("curr bill")// Main collection
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot userDocument : task.getResult()) {
                                String userDocumentId = userDocument.getId();
                                System.out.println(userDocumentId);
                                for (QueryDocumentSnapshot currBillDoc : task.getResult()) {
                                    try {
                                        int rent = Integer.parseInt(currBillDoc.getString("rent"));
                                        int electric =Integer.parseInt(currBillDoc.getString("electric"));
                                        String date = currBillDoc.getString("date");
                                        String name = currBillDoc.getString("name");
                                        System.out.println(rent+" "+electric+" "+date+" "+name);
                                        HistoryModel model = new HistoryModel(rent, electric, date, name);
                                        modelList.add(model);
                                        adapter.notifyDataSetChanged();
                                    } catch (Exception e) {
                                        Log.e(TAG, "Error mapping data from curr bill: ", e);
                                    }
                                }
                                // Access subcollections for each user document
//                                db.collection("users")
//                                        .document(userDocumentId)
//                                        .collection("curr bill")
//                                        .get()
//                                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                                            @Override
//                                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                                                if (task.isSuccessful()) {
//                                                    for (QueryDocumentSnapshot currBillDoc : task.getResult()) {
//                                                        try {
//                                                            int rent = currBillDoc.getLong("rent").intValue();
//                                                            int electric = currBillDoc.getLong("electric").intValue();
//                                                            String date = currBillDoc.getString("date");
//                                                            String name = currBillDoc.getString("name");
//
//                                                            HistoryModel model = new HistoryModel(rent, electric, date, name);
//                                                            modelList.add(model);
//                                                        } catch (Exception e) {
//                                                            Log.e(TAG, "Error mapping data from curr bill: ", e);
//                                                        }
//                                                    }
//                                                } else {
//                                                    Log.e(TAG, "Error fetching curr bill subcollection", task.getException());
//                                                }
//                                            }
//                                        });

                                // Access another subcollection like "personal info" if needed
//                                db.collection("users")
//                                        .document(userDocumentId)
//                                        .collection("personal info")
//                                        .get()
//                                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                                            @Override
//                                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                                                if (task.isSuccessful()) {
//                                                    for (QueryDocumentSnapshot personalInfoDoc : task.getResult()) {
//                                                        try {
//                                                            // Example: Retrieving personal info fields
//                                                            String phoneNumber = personalInfoDoc.getString("phone_number");
//                                                            String address = personalInfoDoc.getString("address");
//                                                            Log.d(TAG, "Phone: " + phoneNumber + ", Address: " + address);
//                                                        } catch (Exception e) {
//                                                            Log.e(TAG, "Error mapping data from personal info: ", e);
//                                                        }
//                                                    }
//                                                } else {
//                                                    Log.e(TAG, "Error fetching personal info subcollection", task.getException());
//                                                }
//                                            }
//                                        });
                            }
                        } else {
                            Log.e(TAG, "Error fetching users collection", task.getException());
                        }
                    }
                });





        fetchDataFromFirestore(room);

    }


}



//get command from firebase



//        test=findViewById(R.id.textView);
//        db.collection("users")
//                .document("nN7XopK5pL47eZj5ttnr")
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                test.setText(task.getResult().getData().get("first").toString());
//            }
//        });


