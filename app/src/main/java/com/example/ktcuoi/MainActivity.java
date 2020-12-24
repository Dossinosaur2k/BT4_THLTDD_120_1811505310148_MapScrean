package com.example.ktcuoi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    Spinner spinner1;
    RecyclerView recycler_quan;
    Adapter Adapter;
    String namequan;
    private GoogleMap gm;
    double vx,vy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        creatMap();
        Intent intent = getIntent();
        vx=intent.getDoubleExtra("X",16.047199);
        vy=intent.getDoubleExtra("Y",108.219955);
        namequan=intent.getStringExtra("namequan");

        Employee[] employees = EmployeeDataUtils.getEmployee();
        spinner1= (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<Employee> LTRadapter1 = new ArrayAdapter<Employee>(MainActivity.this,R.layout.spinner_item,employees);
        LTRadapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner1.setAdapter(LTRadapter1);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.store);

        List<itemmap> mapquan= new ArrayList<>();
        mapquan.add(new itemmap("THE COFFEE HOUSE Nguyễn Văn Linh","2 Nguyễn Văn Linh",16.0606967,108.2218018,R.drawable.housenguyenvanlinh));
        mapquan.add(new itemmap("THE COFFEE HOUSE Pasteur ","80 pasteur",16.0697464,108.2172623,R.drawable.housepasteur));
        mapquan.add(new itemmap("THE COFFEE HOUSE Núi Thành","1 Núi Thành",16.0545827,108.2203984,R.drawable.housenuithanh));
        mapquan.add(new itemmap("THE COFFEE HOUSE Trần Hưng Đạo","461 Trần Hưng Đạo",16.0643676, 108.2301452,R.drawable.housetranhungdao));
        mapquan.add(new itemmap("THE COFFEE HOUSE Nguyễn Chí Thanh","80A Nguyễn Chí Thanh",16.0726908,108.2206852,R.drawable.housenguyenchithanh));

        setRecyle_mapquan(mapquan);

    }


    public void setRecyle_mapquan(List<itemmap> itemlist){
            recycler_quan=findViewById(R.id.recycle_quan);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
            recycler_quan.setLayoutManager(layoutManager);
            Adapter = new Adapter(this,itemlist);
            recycler_quan.setAdapter(Adapter);
    }
    public  void creatMap(){
        SupportMapFragment smf= (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        smf.getMapAsync(this);
    }
    public void onResume() {
        super.onResume();
        creatMap();
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng hcm = new LatLng(vx,vy);
        gm =googleMap;
        gm.addMarker(new MarkerOptions().position(hcm).title(namequan));
        CameraPosition cp = new CameraPosition.Builder().target(hcm).zoom(18).build();
        gm.animateCamera(CameraUpdateFactory.newCameraPosition(cp));

    }

}