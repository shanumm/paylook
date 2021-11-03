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
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;


//import com.myapplication.permission.ActivityMainBinding;
import com.myapplication.permission.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_SMS}, PackageManager.PERMISSION_GRANTED);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }


    public void Read_SMS(View view) {
        Cursor cursor = getContentResolver().query(Uri.parse("content://sms"), null, null, null, null);
        int indexOfAmountStart = 0;
        int indexOfAmountEnd = 0;
        String totalAmount="";
        ArrayList<String> name = new ArrayList<String>(50);
        for (int i = 0; i < 50; i++) {
            cursor.moveToPosition(i);
            String str = cursor.getString(12);
            totalAmount = "";
            if (str.contains("debited") || str.contains("credited")) {
                indexOfAmountStart = str.indexOf("INR");
                while (str.charAt(indexOfAmountStart) != ' ') {
                    indexOfAmountStart++;
                }
                indexOfAmountEnd = indexOfAmountStart + 1;
                while (str.charAt(indexOfAmountEnd) != ' ') {
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

            }
            name.add(totalAmount);

        }
        String[] lastMessage = {"Heye", "Supp", "Let's Catchup", "Dinner tonight?", "Gotta go",
                "i'm in meeting", "Gotcha", "Let's Go", "any Weekend Plans?"};
        String[] lastmsgTime = {"8:45 pm", "9:00 am", "7:34 pm", "6:32 am", "5:76 am",
                "5:00 am", "7:34 pm", "2:32 am", "7:76 am"};


        ArrayList<User> userArrayList = new ArrayList<>();

        for (int j = 0; j < 6; j++) {

            User user = new User(name.get(j), lastMessage[j], lastmsgTime[j]);
            userArrayList.add(user);

        }


        ListAdapter listAdapter = new ListAdapter(MainActivity.this, userArrayList);

        binding.listview.setAdapter(listAdapter);


    }
}