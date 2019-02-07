package com.example.shayanmoradi.realmroyale;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.shayanmoradi.realmroyale.Model.Car;
import com.example.shayanmoradi.realmroyale.Model.Customer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText nameEdit;
    private EditText ageEdit;
    private Button registerBtn;
    private EditText customerNameEdit;
    private EditText carNameEditText;
    private CheckBox isLuxaryCheck;
    private Button buyCarBtn;
    private EditText buyerNameSearchEdit;
    private CheckBox searchForLuxaryCheck;
    private CheckBox descendingSearchCheck;
    private Button searchForCustomerBtn;
    private RecyclerView recyclerView;
    private CustomerAdapter customerAdapter;
    private Customer customer;
    private List<Car> custoemrCars;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        castView();
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ////
                //register new customer
                String customerName = nameEdit.getText().toString();
                int customerAge = Integer.valueOf(ageEdit.getText().toString());
                Customer customer = new Customer();

            }
        });

        buyCarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ///
                //buy new car
                String carName = carNameEditText.getText().toString();
                boolean isLuxary = isLuxaryCheck.isChecked();
            }
        });
        searchForCustomerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // search in customers
                // set cusomer car for rec adapter

                String customerNameForSearch = buyerNameSearchEdit.getText().toString();
                boolean isLuxarForSearch = searchForLuxaryCheck.isChecked();
                boolean descendingSort = descendingSearchCheck.isChecked();
            }
        });
    }


    private void castView() {
        nameEdit = findViewById(R.id.name_edit_text);
        ageEdit = findViewById(R.id.age_edit_text);
        registerBtn = findViewById(R.id.register_btn);
        customerNameEdit = findViewById(R.id.buyer_name_edit_text);
        carNameEditText = findViewById(R.id.car_name_edit_text);
        isLuxaryCheck = findViewById(R.id.is_luxary_check_box);
        buyCarBtn = findViewById(R.id.buy_btn);
        buyerNameSearchEdit = findViewById(R.id.buyer_name_search_edit_text);
        searchForLuxaryCheck = findViewById(R.id.search_for_luxary);
        descendingSearchCheck = findViewById(R.id.descending_search);
        searchForCustomerBtn = findViewById(R.id.search_customer_btn);
        recyclerView = findViewById(R.id.result_rec);

    }

    public void updateUI() {
        /////set cars
        List<Car> cars = new ArrayList<>();
        /////
        if (customerAdapter == null) {
            customerAdapter = new CustomerAdapter(cars);
            recyclerView.setAdapter(customerAdapter);
        } else {
            customerAdapter.setCArs(cars);
            customerAdapter.notifyDataSetChanged();
        }
    }

    private class CustoemrHolder extends RecyclerView.ViewHolder {

        private TextView carName;
        private TextView customerAge;
        private TextView isLyxary;
        private Button saleCar;
        private Car mCAr;

        public CustoemrHolder(@NonNull View itemView) {
            super(itemView);

            carName = itemView.findViewById(R.id.car_name_tv);
            customerAge = itemView.findViewById(R.id.customer_age_tv);
            isLyxary = itemView.findViewById(R.id.is_luxary_tv);
            saleCar = itemView.findViewById(R.id.sale_btn);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });
        }

        public void bind(Car car) {
            mCAr = car;

            carName.setText(mCAr.getCarName());


            //  customerAge.setText();
            //set age

            isLyxary.setText(mCAr.isIsluxary() + "");
        }
    }

    private class CustomerAdapter extends RecyclerView.Adapter<CustoemrHolder> {

        private List<Car> mCars;

        public CustomerAdapter(List<Car> cars) {
            mCars = cars;
        }

        public void setCArs(List<Car> cars) {
            mCars = cars;
        }

        @NonNull
        @Override
        public CustoemrHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            View view = inflater.inflate(R.layout.car_detail_item, parent, false);
            CustoemrHolder custoemrHolder = new CustoemrHolder(view);
            return custoemrHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull CustoemrHolder holder, int position) {
            Car car = mCars.get(position);

            holder.bind(car);
        }

        @Override
        public int getItemCount() {
            return mCars.size();
        }
    }

}


