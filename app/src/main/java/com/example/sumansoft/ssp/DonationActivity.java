package com.example.sumansoft.ssp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class DonationActivity extends AppCompatActivity {

    EditText name, dob, homeAddress, email, mobile, telephone, date, amount, number;
    Spinner gender, category;
    Button submit, reset;
    String[] genderr = {"Select Gender", "Male", "Female", "Other"};
    String[] categoryy = {"Select category", "Cheque", "Demand Draft", "Neft/Rtgs"};
    String genderrr,categoryyy,namee,dobb,homee,emaill,mobilee,datee,amountt,numberr;
    Calendar myCalendar = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_donation);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setTitle("Donate Here");
        toolbar.setTitleTextColor(Color.WHITE);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DonationActivity.this, MainActivity.class));
            }
        });

        gender = (Spinner) findViewById(R.id.spiner_gender);
        category = (Spinner) findViewById(R.id.sppiner_category);

        submit = (Button) findViewById(R.id.btn_submit);
        reset = (Button) findViewById(R.id.btn_reset);

        name = (EditText) findViewById(R.id.et_name);
        dob = (EditText) findViewById(R.id.et_dob);
        homeAddress = (EditText) findViewById(R.id.et_address);
        email = (EditText) findViewById(R.id.et_email);
        mobile = (EditText) findViewById(R.id.et_mobile);
        telephone = (EditText) findViewById(R.id.et_telephone);
        date = (EditText) findViewById(R.id.et_date);
        amount = (EditText) findViewById(R.id.et_amount);
        number = (EditText) findViewById(R.id.et_number);


        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, genderr);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        gender.setAdapter(aa);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aaa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, categoryy);
        aaa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        category.setAdapter(aaa);

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
                new DatePickerDialog(DonationActivity.this, datePickerr, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });



        date.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(DonationActivity.this, datePicker, myCalendar
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


        category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(
                    AdapterView<?> adapterView, View view,
                    int i, long l) {
                categoryyy = category.getItemAtPosition(i).toString();
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
                 amountt=amount.getText().toString();
                 numberr=number.getText().toString();

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
                }else if (amountt.equals("")){
                    amount.setError("Please Enter Amount");
                }else if (numberr.equals("")){
                    number.setError("Please Enter Number");
                }else if (genderrr.equals("Select Gender")){
                    Toast.makeText(DonationActivity.this, "Please Select Gender", Toast.LENGTH_LONG).show();

                }else if (categoryyy.equals("Select category")){
                    Toast.makeText(DonationActivity.this, "Please Select category", Toast.LENGTH_LONG).show();
                }

                else {

                    Toast toast= Toast.makeText(DonationActivity.this,
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
                    amount.setText("");
                    number.setText("");
                }


            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast toast= Toast.makeText(DonationActivity.this,
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
                amount.setText("");
                number.setText(""
                );
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
