package com.example.prerna.sspapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ExpandableListAdapter listAdapter;
    private ExpandableListView listView;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash;
    private int flag = 1;
    private LinearLayout linearLayout;
    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu_white_24dp);
        toolbar.setTitle("SARVA SAMBHAV PARTY");
        toolbar.setTitleTextColor(Color.WHITE);

        listView = (ExpandableListView) findViewById(R.id.lv_expand);
        linearLayout = (LinearLayout) findViewById(R.id.home);
        imageView = (ImageView) findViewById(R.id.arrow);
        textView = (TextView) findViewById(R.id.lblListHeader);
        listView.setDividerHeight(5);


        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag = 1;
                listView.setVisibility(View.GONE);
                toolbar.setTitle("SARVA SAMBHAV PARTY");
                listView.collapseGroup(0);
                listView.collapseGroup(1);
                listView.collapseGroup(2);
                listView.collapseGroup(3);
                listView.collapseGroup(4);
                listView.collapseGroup(5);


            }
        });


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (flag == 1) {
                    flag = 0;

                    listView.setVisibility(View.VISIBLE);
                    toolbar.setTitle("PROFILE");

                } else {
                    listView.setVisibility(View.GONE);
                    toolbar.setTitle("SARVA SAMBHAV PARTY");
                    listView.collapseGroup(0);
                    listView.collapseGroup(1);
                    listView.collapseGroup(2);
                    listView.collapseGroup(3);
                    listView.collapseGroup(4);
                    listView.collapseGroup(5);
                    flag = 1;
                }
            }
        });

        initData();
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listHash);
        listView.setAdapter(listAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                imageView.setBackgroundResource(R.mipmap.orange_arrow);
                textView.setTextColor(getResources().getColor(R.color.orange));
            }
        });

        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                final String selected = (String) listAdapter.getChild(i, i1);
                Toast.makeText(getBaseContext(), selected, Toast.LENGTH_LONG)
                        .show();

                if (selected.equals("Ideology")){
                    startActivity(new Intent(MainActivity.this,IdeologyActivity.class));
                }else if (selected.equals("How are we different")){
                    startActivity(new Intent(MainActivity.this,DifferentActivity.class));
                }else if (selected.equals("Shri Sripal Yadav")){
                    startActivity(new Intent(MainActivity.this,SripalActivity.class));
                }else if (selected.equals("Shri Rajpal Yadav")){
                    startActivity(new Intent(MainActivity.this,RajpalActivity.class));
                }else if (selected.equals("Shri Kuldeep Yadav")){
                    startActivity(new Intent(MainActivity.this,KuldeepActivity.class));
                }else if(selected.equals("Shri Rajesh Yadav")){
                    startActivity(new Intent(MainActivity.this,RajeshActivity.class));

                }else if (selected.equals("SSP video")){
                    startActivity(new Intent(MainActivity.this,VideosActivity.class));

                }else if (selected.equals("Donate Here")){
                    startActivity(new Intent(MainActivity.this,DonationActivity.class));

                }else if (selected.equals("NEFT/RTGS")){
                    startActivity(new Intent(MainActivity.this,NeftActivity.class));

                }else if (selected.equals("Donation FQAs")){
                    startActivity(new Intent(MainActivity.this,FqaActivity.class));
                }else if (selected.equals("Apply Online")){
                    startActivity(new Intent(MainActivity.this,OnlineActivity.class));
                }
                return true;
            }
        });

    }

    public void initData() {

        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();
        listDataHeader.add("About SSP");
        listDataHeader.add("Our Leadership");
        listDataHeader.add("Media Gallery");
        listDataHeader.add("Agenda");
        listDataHeader.add("Donate");
        listDataHeader.add("Membership");
        listDataHeader.add("Contact Us");


        List<String> about = new ArrayList<>();
        about.add("Ideology");
        about.add("How are we different");

        List<String> leader = new ArrayList<>();
        leader.add("Shri Sripal Yadav");
        leader.add("Shri Rajpal Yadav");
        leader.add("Shri Kuldeep Yadav");
        leader.add("Shri Rajesh Yadav");

        List<String> media = new ArrayList<>();
        media.add("SSP latest news");
        media.add("SSP video");
        media.add("SSP Photo");

        List<String> agenda = new ArrayList<>();
        agenda.add("UP Agenda");


        List<String> donate = new ArrayList<>();
        donate.add("Donate Here");
        donate.add("NEFT/RTGS");
        donate.add("Donation FQAs");

        List<String> membership = new ArrayList<>();
        membership.add("Apply Online");
        membership.add("Apply ofline");


        listHash.put(listDataHeader.get(0), about);
        listHash.put(listDataHeader.get(1), leader);
        listHash.put(listDataHeader.get(2), media);
        listHash.put(listDataHeader.get(3), agenda);
        listHash.put(listDataHeader.get(4), donate);
        listHash.put(listDataHeader.get(5), membership);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(MainActivity.this, "ddddddddccccdddd0", Toast.LENGTH_LONG).show();
        return true;
    }
}
