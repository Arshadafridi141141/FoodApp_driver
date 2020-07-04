package com.example.foodorder_driver.driver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Spinner;

import com.example.foodorder_driver.Model.Request;
import com.example.foodorder_driver.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jaredrummler.materialspinner.MaterialSpinner;

public class Orders extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    FirebaseRecyclerAdapter<Request,OrderViewHolder> adapter;
    FirebaseDatabase database;
    DatabaseReference requets;
    MaterialSpinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        database=FirebaseDatabase.getInstance();
        requets=database.getReference("Requests");
        recyclerView=(RecyclerView) findViewById(R.id.list_orders);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        loadOrders();
    }

    private void loadOrders() {
        adapter=new FirebaseRecyclerAdapter<Request, OrderViewHolder>(
                Request.class,
                R.layout.order_layout,
                OrderViewHolder.class,
                requets.orderByChild("status").equalTo("1")

        ) {
            @Override
            protected void populateViewHolder(OrderViewHolder orderViewHolder, Request request, int i) {
                orderViewHolder.order_id.setText(adapter.getRef(i).getKey());
                orderViewHolder.order_status.setText(convertcode(request.getStatus()));
                orderViewHolder.order_address.setText(request.getAddress());
                orderViewHolder.order_phone.setText(request.getPhone());
            }


        };
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

    }

    private String convertcode(String status) {
        if(status.equals("0"))
            return "Placed";
        else if(status.equals("1"))
            return "On way";
        else
            return "Shipped";
    }


}
