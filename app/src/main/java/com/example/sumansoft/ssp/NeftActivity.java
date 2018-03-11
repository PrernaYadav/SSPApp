package com.example.sumansoft.ssp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
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
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class NeftActivity extends AppCompatActivity {

    EditText name, dob, homeAddress, email, mobile, telephone, date, message;
    Spinner gender, category;
    Button submit, reset;
    String[] genderr = {"Select Gender", "Male", "Female", "Other"};
    String[] categoryy = {"Select category", "Cheque", "Demand Draft", "Neft/Rtgs"};
    String genderrr,categoryyy,namee,dobb,homee,emaill,mobilee,datee,messagee;
    Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neft);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_neft);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setTitle("NEFT/RTGS");
        toolbar.setTitleTextColor(Color.WHITE);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NeftActivity.this, MainActivity.class));
            }
        });
        gender = (Spinner) findViewById(R.id.spiner_neft_gender);

        submit = (Button) findViewById(R.id.btn_neft_submit);
        reset = (Button) findViewById(R.id.btn_neft_reset);

        name = (EditText) findViewById(R.id.et_neft_name);
        dob = (EditText) findViewById(R.id.et_neft_dob);
        homeAddress = (EditText) findViewById(R.id.et_neft_home);
        email = (EditText) findViewById(R.id.et_neft_email);
        mobile = (EditText) findViewById(R.id.et_neft_mobile);
        telephone = (EditText) findViewById(R.id.et_neft_telephone);
        date = (EditText) findViewById(R.id.et_neft_date);
        message = (EditText) findViewById(R.id.et_neft_message);



        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, genderr);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        gender.setAdapter(aa);


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
        final DatePickerDialog.OnDateSetListener datePickerr = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabell();
            }

        };


        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(NeftActivity.this, datePickerr, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });



        date.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(NeftActivity.this, datePicker, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(
                    AdapterView<?> adapterView, View view,
                    int i, long l) {
                genderrr = gender.getItemAtPosition(i).toString();
            }

            public void onNothingSelected(
                    AdapterView<?> adapterView) {

            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                namee=name.getText().toString();
                dobb=dob.getText().toString();
                homee=homeAddress.getText().toString();
                emaill=email.getText().toString();
                mobilee=mobile.getText().toString();
                datee=date.getText().toString();
                messagee=message.getText().toString();

                if (namee.equals("")){
                    name.setError("Please Enter Name");
                }else if (dobb.equals("")){
                    dob.setError("Please Enter Date of Birth");
                }else if (homee.equals("")){
                    homeAddress.setError("Please Enter Address");
                }else if (emaill.equals("")){
                    email.setError("Please Enter Email");
                }else if (mobilee.equals("")){
                    mobile.setError("Please Enter Mobile");
                }else if (datee.equals("")){
                    date.setError("Please Enter Date");
                }else if (messagee.equals("")){
                    message.setError("Please Enter Message");
                }else if (genderrr.equals("Select Gender")){
                    Toast.makeText(NeftActivity.this, "Please Select Gender", Toast.LENGTH_LONG).show();

                }

                else {

                    Toast toast= Toast.makeText(NeftActivity.this,
                            "Data submitted successfully", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER| Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();


                    name.setText("");
                    dob.setText("");
                    homeAddress.setText("");
                    email.setText("");
                    mobile.setText("");
                    telephone.setText("");
                    date.setText("");

                }


            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast toast= Toast.makeText(NeftActivity.this,
                        "Reset successfully", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER| Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();


                name.setText("");
                dob.setText("");
                homeAddress.setText("");
                email.setText("");
                mobile.setText("");
                telephone.setText("");
                date.setText("");

            }
        });


    }
    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        date.setText(sdf.format(myCalendar.getTime()));
    }

    private void updateLabell() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        dob.setText(sdf.format(myCalendar.getTime()));



    }
}
