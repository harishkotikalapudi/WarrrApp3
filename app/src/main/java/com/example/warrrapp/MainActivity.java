package com.example.warrrapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.warrrapp.adapter.AdapterForList;
import com.example.warrrapp.model.Ammunition;
import com.example.warrrapp.model.Guns;
import com.example.warrrapp.model.Horses;
import com.example.warrrapp.model.Item;
import com.example.warrrapp.reciever.MyReceiver;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    ArrayList<Item> displaySelectedList = new ArrayList<>();
    ListView listView;
    AdapterForList adapter;
    String contactName;
    Boolean isGunSelected = false;
    Boolean isHorseSelected =false;
    Boolean isTeamSelected =false;
    Boolean isAmmoSelected = false;
    private IntentFilter filter =
            new IntentFilter("com.example.warrrapp_ACTION");

    private MyReceiver receiver = new MyReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.disListView);
      //  if (!displaySelectedList.isEmpty())
        adapter = new AdapterForList(this, R.layout.list_item, displaySelectedList);
        listView.setAdapter(adapter);

    }
    public void horsesList(View view){
        disPlayList(Types.HORSE);
    }
    public void gunsList(View view){
        disPlayList(Types.GUN);
    }
    public void ammunitionList(View view){
        disPlayList(Types.AMMUNITION);
    }

    private void disPlayList(int type) {
        Intent intent = new Intent(this,DisplayList.class);
        Bundle bundle = new Bundle();
        bundle.putInt(Types.TYPE,type);
        intent.putExtras(bundle);
        startActivityForResult(intent,type);
    }
    public void getConatact(View view){
        Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
        startActivityForResult(intent, Types.PICK_CONTACT_SUBACTIVITY);
    }
    public void viewSelectedData(View view){
        Intent intent = new Intent(this,DisplaySelectedData.class);
        Bundle bundle = new Bundle();
        bundle.putString("contact",contactName);
        bundle.putString("data1",displaySelectedList.get(0).getName());
        bundle.putString("data2",displaySelectedList.get(1).getName());
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case (Types.HORSE) :
                if(data!=null){
                    int hPostion = data.getIntExtra("position",-1);
                    displaySelectedList.add(new Horses().getHorses().get(hPostion));
                    adapter.notifyDataSetChanged();
                    isHorseSelected = true;
                }
                break;

            case (Types.GUN) :
                if(data!=null) {
                    int gPostion = data.getIntExtra("position", -1);
                    displaySelectedList.add(new Guns().getGuns().get(gPostion));
                    adapter.notifyDataSetChanged();
                    isGunSelected=true;
                }
                break;


            case (Types.AMMUNITION) :
                if(data!=null) {
                    int gPostion = data.getIntExtra("position", -1);
                    displaySelectedList.add(new Ammunition().getAmmunition().get(gPostion));
                    adapter.notifyDataSetChanged();
                    isAmmoSelected=true;
                }
                break;

            case (Types.PICK_CONTACT_SUBACTIVITY) :
                if (resultCode == RESULT_OK) {
                try {
                    Uri uri = data.getData();
                    Cursor cursor = getContentResolver().query(uri, null, null, null, null);
                    cursor.moveToFirst();
                    int  phoneIndex =cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                    int  nameIndex =cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
                    String phoneNo = cursor.getString(phoneIndex);
                    contactName = cursor.getString(nameIndex);
                    displaySelectedList.add(new Item( contactName, 0, phoneNo,1f));
                    adapter.notifyDataSetChanged();
                    isTeamSelected = true;

                } catch (Exception e) {
                    e.printStackTrace();
                }


            } else {
                Log.e("Failed", "Not able to pick contact");
            }
                break;

                default: break;
        }
        checkTeamCmpltd();
    }

    private void checkTeamCmpltd(){
        if (isHorseSelected && isAmmoSelected && isGunSelected && isTeamSelected){
            Intent intent = new Intent();
            intent.setAction("com.example.warrrapp_ACTION");
            intent.putExtra("data","War!");
            sendBroadcast(intent);
            Toast.makeText(this, "War Started.. " ,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }


    @Override
    public synchronized void onResume()
    {
        super.onResume();

        // Register the broadcast receiver.
        registerReceiver(receiver, filter);
    }

    @Override
    public synchronized void onPause()
    {
        super.onPause();
        // Unregister the receiver
        unregisterReceiver(receiver);


    }

}
