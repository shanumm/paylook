//package com.myapplication.permission;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AlertDialog;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.app.ActivityCompat;
//import androidx.core.content.ContextCompat;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.Manifest;
//import android.content.DialogInterface;
//import android.content.pm.PackageManager;
//import android.database.Cursor;
//import android.graphics.Color;
//import android.net.Uri;
//import android.os.Bundle;
//import android.provider.Settings;
//import android.text.method.ScrollingMovementMethod;
//import android.view.View;
//import android.widget.Button;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.myapplication.permission.databinding.ActivityMainBinding;
//
//import java.util.ArrayList;
//
//
//public class MainActivity extends AppCompatActivity {
//    private TextView myTextView;
//    ActivityMainBinding  binding;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        binding=ActivityMainBinding.inflate(getLayoutInflater());
////        setContentView(R.layout.activity_main);
//            setContentView(binding.getRoot());
////        myTextView = findViewById(R.id.textView);
//
//
//        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_SMS}, PackageManager.PERMISSION_GRANTED);
//
//
//    }
//
//    public void Read_SMS(View view) {
//        RecyclerView recyclerView = findViewById(R.id.recyclerView);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        MyMovieData[] myMovieData = new MyMovieData[]{
//                new MyMovieData("Avengers", "2019 film", R.drawable.wallet),
//                new MyMovieData("Hulk", "2003 film", R.drawable.wallet),
//                new MyMovieData("Avatar", "2009 film", R.drawable.wallet),
//        };
//
//
//
//        MyMovieAdapter myMovieAdapter = new MyMovieAdapter(myMovieData, MainActivity.this);
//        recyclerView.setAdapter(myMovieAdapter);
//
//        Cursor cursor = getContentResolver().query(Uri.parse("content://sms"), null, null, null, null);
//
//        int indexOfAmountStart = 0;
//        int indexOfAmountEnd = 0;
//        for (int i = 0; i < 100; i++) {
////            TextView MoneyText = new TextView(this);
//            cursor.moveToPosition(i);
//            String str = cursor.getString(12);
//            String totalAmount = "";
//            if (str.contains("debited") || str.contains("credited")) {
////                myTextView.append(str + "\n\n");
//                indexOfAmountStart = str.indexOf("INR");
//                while (str.charAt(indexOfAmountStart) != ' ') {
//                    indexOfAmountStart++;
//                }
//                indexOfAmountEnd = indexOfAmountStart + 1;
//                while (str.charAt(indexOfAmountEnd) != ' ') {
//                    indexOfAmountEnd++;
//                }
//                totalAmount = str.substring(indexOfAmountStart, indexOfAmountEnd);
////               if (str.contains("credited")) {
////                    MoneyText.setTextColor(Color.GREEN);
////                    MoneyText.setText(totalAmount);
////                    myTextView.append("\n Credited : " + totalAmount + " Rs\n\n\n");
////                } else {
////                    MoneyText.setTextColor(Color.GREEN);
////                    MoneyText.setText(totalAmount);
////                    myTextView.append("\n Debited : " + totalAmount + " Rs\n\n\n");
////                }
//            }
//        }
//
//
//    }
//}


package com.myapplication.permission;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;


//import com.myapplication.permission.ActivityMainBinding;
import com.myapplication.permission.databinding.ActivityMainBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextView mytext;
    ActivityMainBinding binding;

    ArrayList<String> name = new ArrayList<String>();
    ArrayList<String> lastMessage = new ArrayList<String>();
    ArrayList<String> lastmsgTime = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_SMS}, PackageManager.PERMISSION_GRANTED);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mytext = findViewById(R.id.textViews);

    }



    @SuppressLint("Range")
    public void Read_SMS(View view) {
        Cursor cursor = getContentResolver().query(Uri.parse("content://sms"), null, null, null, null);
        int indexOfAmountStart = 0;
        int indexOfAmountEnd;
        int numberOfMessages = 0;
        String totalAmount = "9";
        String str = "";
        String date = "";
        String transactionNameString = "";
        String transactionDateAndTime = "";

        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);
//get message body

            str = cursor.getString(cursor.getColumnIndex("body"));


// get sender/reciever name
            transactionNameString = cursor.getString(2);

//get date and time of transaction

            transactionDateAndTime = cursor.getString(cursor.getColumnIndex("date"));
            date = cursor.getString(cursor.getColumnIndex("date"));
            SimpleDateFormat formatter = new SimpleDateFormat("dd, MMM HH:mm");
            date = formatter.format(new Date(Long.parseLong(date)));
//
//
            if ((str.contains("debit") || str.contains("Debit") || str.contains("debited") || str.contains("credited") || str.contains("transferred") || str.contains("Credited") || str.contains("Debited") || str.contains("Received") || str.contains("received")) && (str.contains("A/c") || str.contains("A/C")|| str.contains("a/c"))) {
                numberOfMessages++;

                if (str.contains("INR")) {
                    indexOfAmountStart = str.indexOf("INR");
                    while (!Character.isDigit(str.charAt(indexOfAmountStart))) {
                        indexOfAmountStart++;
                    }
                }
                else if (str.contains("Rs")) {
                    indexOfAmountStart = str.indexOf("Rs");
                    while (!Character.isDigit(str.charAt(indexOfAmountStart))) {
                        indexOfAmountStart++;
                    }
                }
                indexOfAmountEnd = indexOfAmountStart;
                while (Character.isDigit(str.charAt(indexOfAmountEnd))&& indexOfAmountEnd < str.length() ) {
                    indexOfAmountEnd++;
                }
                totalAmount = str.substring(indexOfAmountStart, indexOfAmountEnd);
//               if (str.contains("credited")) {
//                    MoneyText.setTextColor(Color.GREEN);
//                    MoneyText.setText(totalAmount);
//                    myTextView.append("\n Credited : " + totalAmount + " Rs\n\n\n");
//                } else {
//                    MoneyText.setTextColor(Color.GREEN);
//                    MoneyText.setText(totalAmount);
//                    myTextView.append("\n Debited : " + totalAmount + " Rs\n\n\n");
//                }
                name.add(transactionNameString);
                lastMessage.add(date);
                lastmsgTime.add(totalAmount.trim());

            }


        }


        ArrayList<User> userArrayList = new ArrayList<>();

        for (int j = 0; j < numberOfMessages; j++) {

            User user = new User(name.get(j), lastMessage.get(j), lastmsgTime.get(j));
            userArrayList.add(user);

        }


        ListAdapter listAdapter = new ListAdapter(MainActivity.this, userArrayList);

        binding.listview.setAdapter(listAdapter);


    }
}
