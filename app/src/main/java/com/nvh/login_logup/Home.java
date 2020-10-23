package com.nvh.login_logup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Stack;

public class Home extends AppCompatActivity {
    ListView listView;
    Context context;
    ArrayList<CountriesModel> custListView;
    CustomAdapter customAdapter;
    CountriesModel countriesModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNavigationView = findViewById(R.id.botton_nagivation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.music:
                        startActivity(new Intent(getApplicationContext(), CustListView.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.home:
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), Profile.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });

        //getviews
        listView = findViewById(R.id.lvProfile);
        custListView = new ArrayList<>();
        registerForContextMenu(listView);

        //add Countries Data
        populateCountriesData();

        customAdapter = new CustomAdapter(context,custListView);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(context,custListView.get(position).getName(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater =getMenuInflater();
        menu.setHeaderTitle("Menu context");
        inflater.inflate(R.menu.menu_edit,menu);

    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.menu_add:
                Snackbar.make(findViewById(R.id.acHome),"Add",Snackbar.LENGTH_LONG).show();
                break;
            case R.id.menu_delete:
                Snackbar.make(findViewById(R.id.acHome),"Delete",Snackbar.LENGTH_LONG).show();
                custListView.remove(info.position);
                customAdapter.notifyDataSetChanged();
                break;
            case R.id.menu_update:
                Snackbar.make(findViewById(R.id.acHome),"Update",Snackbar.LENGTH_LONG).show();
                break;
        }
        return super.onContextItemSelected(item);
    }


    private void populateCountriesData() {
        //country 1
        countriesModel = new CountriesModel();
        countriesModel.setId(1);
        countriesModel.setName("Pakistan");
        countriesModel.setImage(R.drawable.anhhai);
        custListView.add(countriesModel);

        //country 2
        countriesModel = new CountriesModel();
        countriesModel.setId(2);
        countriesModel.setName("Afghanistan");
        countriesModel.setImage(R.drawable.anhhai);
        custListView.add(countriesModel);

        //country 3
        countriesModel = new CountriesModel();
        countriesModel.setId(3);
        countriesModel.setName("India");
        countriesModel.setImage(R.drawable.anhhai);
        custListView.add(countriesModel);

        //country 4
        countriesModel = new CountriesModel();
        countriesModel.setId(4);
        countriesModel.setName("Iran");
        countriesModel.setImage(R.drawable.anhhai);
        custListView.add(countriesModel);

        //country 5
        countriesModel = new CountriesModel();
        countriesModel.setId(5);
        countriesModel.setName("China");
        countriesModel.setImage(R.drawable.anhhai);
        custListView.add(countriesModel);

        //country 6
        countriesModel = new CountriesModel();
        countriesModel.setId(6);
        countriesModel.setName("United States");
        countriesModel.setImage(R.drawable.anhhai);
        custListView.add(countriesModel);

        //country 7
        countriesModel = new CountriesModel();
        countriesModel.setId(7);
        countriesModel.setName("Canada");
        countriesModel.setImage(R.drawable.anhhai);

        custListView.add(countriesModel);

        //country 8
        countriesModel = new CountriesModel();
        countriesModel.setId(8);
        countriesModel.setName("Morocco");
        countriesModel.setImage(R.drawable.anhhai);

        custListView.add(countriesModel);

        //country 9
        countriesModel = new CountriesModel();
        countriesModel.setId(9);
        countriesModel.setName("South Africa");
        countriesModel.setImage(R.drawable.anhhai);

        custListView.add(countriesModel);

        //country 10
        countriesModel = new CountriesModel();
        countriesModel.setId(10);
        countriesModel.setName("Zimbabwe");
        countriesModel.setImage(R.drawable.anhhai);
        custListView.add(countriesModel);
    }
}
