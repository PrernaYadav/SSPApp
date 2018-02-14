package com.example.prerna.sspapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
                Toast.makeText(getBaseContext(), selected, Toast.LENGTH_LONG).show();

                if (selected.equals("Ideology")) {
                    startActivity(new Intent(MainActivity.this, IdeologyActivity.class));
                } else if (selected.equals("How are we different")) {
                    startActivity(new Intent(MainActivity.this, DifferentActivity.class));
                } else if (selected.equals("Shri Sripal Yadav")) {
                    startActivity(new Intent(MainActivity.this, SripalActivity.class));
                } else if (selected.equals("Shri Rajpal Yadav")) {
                    startActivity(new Intent(MainActivity.this, RajpalActivity.class));
                } else if (selected.equals("Shri Kuldeep Yadav")) {
                    startActivity(new Intent(MainActivity.this, KuldeepActivity.class));
                } else if (selected.equals("Shri Rajesh Yadav")) {
                    startActivity(new Intent(MainActivity.this, RajeshActivity.class));
                } else if (selected.equals("SSP Photo")) {
                    startActivity(new Intent(MainActivity.this, PhotoActivity.class));
                } else if (selected.equals("UP Agenda")) {
                    startActivity(new Intent(MainActivity.this, UPAgendaActivity.class));
                } else if (selected.equals("SSP video")) {
                    Uri uri = Uri.parse("https://www.youtube.com/channel/UCqI4tttImpfn6EfOglIlz4A"); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                } else if (selected.equals("Donate Here")) {
                    startActivity(new Intent(MainActivity.this, DonationActivity.class));
                } else if (selected.equals("NEFT/RTGS")) {
                    startActivity(new Intent(MainActivity.this, NeftActivity.class));
                } else if (selected.equals("Donation FQAs")) {
                    startActivity(new Intent(MainActivity.this, FqaActivity.class));
                } else if (selected.equals("Apply Online")) {
                    startActivity(new Intent(MainActivity.this, OnlineActivity.class));
                } else if (selected.equals("Apply ofline")) {
                    Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.offlineform);
                    String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
                    File file = new File(extStorageDirectory, "offlineform.PNG");

                    try {
                        FileOutputStream outStream = new FileOutputStream(file);
                        bm.compress(Bitmap.CompressFormat.PNG, 100, outStream);
                        outStream.flush();
                        outStream.close();

                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Image Downloaded.Check Gallery", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
                        toast.show();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (selected.equals("Information")) {
                    startActivity(new Intent(MainActivity.this, ContactInfoActivity.class));
                } else if (selected.equals("Facebook")) {
                    Uri uri = Uri.parse("https://www.facebook.com/SSPartyIndia/?hc_ref=SEARCH&fref=nf"); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                } else if (selected.equals("Twitter")) {
                    Uri uri = Uri.parse("https://twitter.com/SSPartyIndia"); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                } else if (selected.equals("Google+")) {
                    final Intent emailIntent = new Intent(
                            android.content.Intent.ACTION_SEND);
                    emailIntent.setType("plain/text");
                    emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
                            new String[]{"info@ssparty.in"});
                    emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Information");
                    startActivity(Intent.createChooser(emailIntent, "Send mail..."));

                } else if (selected.equals("Youtube")) {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=X9rTM9_seiw"); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
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


        List<String> contact = new ArrayList<>();
        contact.add("Information");
        contact.add("Facebook");
        contact.add("Twitter");
        contact.add("Google+");
        contact.add("Youtube");


        listHash.put(listDataHeader.get(0), about);
        listHash.put(listDataHeader.get(1), leader);
        listHash.put(listDataHeader.get(2), media);
        listHash.put(listDataHeader.get(3), agenda);
        listHash.put(listDataHeader.get(4), donate);
        listHash.put(listDataHeader.get(5), membership);
        listHash.put(listDataHeader.get(6), contact);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(MainActivity.this, "ddddddddccccdddd0", Toast.LENGTH_LONG).show();
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(a);
    }
}
