package com.example.sumansoft.ssp;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class OnlineActivity extends AppCompatActivity {

    Button image, submit, reset;
    ImageView pic;
    String[] genderrr = {"Select Gender", "Male", "Female", "Other"};
    Calendar myCalendar = Calendar.getInstance();


    EditText name, dob, basic, home, state, lok, assembly, pin, mobile, email, telephone, date;
    Spinner gender;

    String namee, dobb, basicc, homee, statee, lokk, assemblyy, pinn, mobilee, emaill, telephonee, datee, genderr;
    private static int RESULT_LOAD_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_online);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setTitle("Apply Online");
        toolbar.setTitleTextColor(Color.WHITE);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OnlineActivity.this, MainActivity.class));
            }
        });

        image = (Button) findViewById(R.id.btn_online_image);
        pic = (ImageView) findViewById(R.id.img_photo);

        name = (EditText) findViewById(R.id.et_online_name);
        dob = (EditText) findViewById(R.id.et_online_dob);
        basic = (EditText) findViewById(R.id.et_online_basic);
        home = (EditText) findViewById(R.id.et_online_home);
        state = (EditText) findViewById(R.id.et_online_state);
        lok = (EditText) findViewById(R.id.et_online_loksabha);
        assembly = (EditText) findViewById(R.id.et_online_assembly);
        pin = (EditText) findViewById(R.id.et_online_pincode);
        mobile = (EditText) findViewById(R.id.et_online_mobile);
        email = (EditText) findViewById(R.id.et_online_email);
        telephone = (EditText) findViewById(R.id.et_online_telephone);
        date = (EditText) findViewById(R.id.et_online_date);

        gender = (Spinner) findViewById(R.id.spiner_online_gender);


        submit = (Button) findViewById(R.id.btn_online_submit);
        reset = (Button) findViewById(R.id.btn_online_reset);


        ActivityCompat.requestPermissions(OnlineActivity.this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                1);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, genderrr);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        gender.setAdapter(aa);

        gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(
                    AdapterView<?> adapterView, View view,
                    int i, long l) {
                genderr = gender.getItemAtPosition(i).toString();
            }

            public void onNothingSelected(
                    AdapterView<?> adapterView) {

            }
        });


        final DatePickerDialog.OnDateSetListener datePicker = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        date.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(OnlineActivity.this, datePicker, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                namee = name.getText().toString();
                dobb = dob.getText().toString();
                basicc = basic.getText().toString();
                homee = home.getText().toString();
                statee = state.getText().toString();
                lokk = lok.getText().toString();
                assemblyy = assembly.getText().toString();
                pinn = pin.getText().toString();
                mobilee = mobile.getText().toString();
                emaill = email.getText().toString();
                telephonee = telephone.getText().toString();
                datee = date.getText().toString();


                if (namee.equals(" ")) {
                    Toast.makeText(OnlineActivity.this, "Enter Name", Toast.LENGTH_LONG).show();

                } else if (dobb.equals(" ")) {
                    Toast.makeText(OnlineActivity.this, "Enter Date Of Birth", Toast.LENGTH_LONG).show();

                } else if (basicc.equals("")) {
                    Toast.makeText(OnlineActivity.this, "Enter Basic Profile", Toast.LENGTH_LONG).show();

                } else if (homee.equals("")) {
                    Toast.makeText(OnlineActivity.this, "Enter Home Address", Toast.LENGTH_LONG).show();
                } else if (statee.equals("")) {
                    Toast.makeText(OnlineActivity.this, "Enter State", Toast.LENGTH_LONG).show();
                } else if (lokk.equals("")) {
                    Toast.makeText(OnlineActivity.this, "Enter Lok Sabha Seat", Toast.LENGTH_LONG).show();

                } else if (assemblyy.equals("")) {
                    Toast.makeText(OnlineActivity.this, "Enter Assembly Seat", Toast.LENGTH_LONG).show();


                } else if (pinn.equals("")) {
                    Toast.makeText(OnlineActivity.this, "Enter PIN Code", Toast.LENGTH_LONG).show();


                } else if (mobilee.equals("")) {
                    Toast.makeText(OnlineActivity.this, "Enter Mobile Number", Toast.LENGTH_LONG).show();


                } else if (emaill.equals("")) {
                    Toast.makeText(OnlineActivity.this, "Enter Email", Toast.LENGTH_LONG).show();

                } else if (telephonee.equals("")) {
                    Toast.makeText(OnlineActivity.this, "Enter Telephone Number", Toast.LENGTH_LONG).show();

                } else if (datee.equals("")) {
                    Toast.makeText(OnlineActivity.this, "Enter Date", Toast.LENGTH_LONG).show();

                } else {

                    Toast toast= Toast.makeText(OnlineActivity.this,
                            "Data submitted successfully", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER| Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();

/*

                    String mail = "name  :" +namee+"Date of birth   :"+dobb+"Mobile   :"+mobilee;
                    Intent i = new Intent(Intent.ACTION_SEND); // start the activity for sending an email
                    i.setType("sumansoft/email"); //set the mime type for the Email
                    i.putExtra(android.content.Intent.EXTRA_SUBJECT, "Online apply " + namee);
                    String[] to = {"prernasyadav027@gmail.com"};
                    i.putExtra(android.content.Intent.EXTRA_EMAIL, to);

                    i.putExtra(android.content.Intent.EXTRA_TEXT, Html.fromHtml(mail));
                    startActivity(Intent.createChooser(i, "EMAIL"));
*/


                    name.setText("");
                    dob.setText("");
                    basic.setText("");
                    home.setText("");
                    state.setText("");
                    lok.setText("");
                    assembly.setText("");
                    pin.setText("");
                    mobile.setText("");
                    email.setText("");
                    telephone.setText("");
                    date.setText("");



                }


            }
        });


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast toast= Toast.makeText(OnlineActivity.this,
                        "Reset Successfully", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER| Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();

                name.setText("");
                dob.setText("");
                basic.setText("");
                home.setText("");
                state.setText("");
                lok.setText("");
                assembly.setText("");
                pin.setText("");
                mobile.setText("");
                email.setText("");
                telephone.setText("");
                date.setText("");

            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            Bitmap path = BitmapFactory.decodeFile(picturePath);
            pic.setImageBitmap(path);

        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(OnlineActivity.this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        date.setText(sdf.format(myCalendar.getTime()));
    }
}
