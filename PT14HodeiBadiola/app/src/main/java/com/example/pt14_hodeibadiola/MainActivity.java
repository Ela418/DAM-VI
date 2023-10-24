package com.example.pt14_hodeibadiola;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.app.SharedElementCallback;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return  true;
    }
    @Override
    protected void onStart() {
        super.onStart();
        textView = (TextView) findViewById(R.id.actmain_edittext_textaskfor);
        registerForContextMenu(textView);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this /* Activity context */);
        String text = sharedPreferences.getString("edit_text_preference_1", "");

        Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
        toast.show();

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menu_main_ayuda:
                OnClickGoToUrl();
                return true;

            case R.id.menu_main_preferencias:
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void OnClickMayus(View view){

        EditText texto_escrito = (EditText)findViewById(R.id.actmain_edittext_textaskfor);
        TextView tview = (TextView)findViewById(R.id.actmain_textview_textprint);
        String result = texto_escrito.getText().toString().toUpperCase();
        tview.setText(result);
    }
    private void OnClickGoToUrl(){

        String InstitutoWeb = "http://www.institutpedralbes.cat/";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(InstitutoWeb));
        startActivity(intent);

    }
    public void OnClickMinus(View view){

        EditText texto_escrito = (EditText)findViewById(R.id.actmain_edittext_textaskfor);
        TextView tview = (TextView)findViewById(R.id.actmain_textview_textprint);
        String result = texto_escrito.getText().toString().toLowerCase();
        tview.setText(result);
    }
    public void OnClickFirstCap(View view){

        EditText texto_escrito = (EditText)findViewById(R.id.actmain_edittext_textaskfor);
        TextView tview = (TextView)findViewById(R.id.actmain_textview_textprint);
        String result = texto_escrito.getText().toString();
         result = toTitleCase(result);
        tview.setText(result);
    }
    public static String toTitleCase(String givenString) {

        String[] arr = givenString.split(" ");
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < arr.length; i++) {
            sb.append(Character.toUpperCase(arr[i].charAt(0)))
                    .append(arr[i].substring(1)).append(" ");
        }
        return sb.toString().trim();

        /* String [] parts = text.split(" ");
        String nou = " ";

        for(String part:parts){
        String primera = part.substring(0,1).toUpperCase();
        String resat = part.substrins(1, part.length()).to upper case();
        nou += primera + resta;
        }
        textView tv= findedviewById(R.id. nombre)
        tv.setText(nou);
         */
    }
}