package helloworl.home.evigkum.helloworld;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class AddSwitchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_switch);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    public void doAction(View view){



        EditText editText = (EditText) findViewById(R.id.ipaddr);
        String ipaddres = editText.getText().toString();
        Log.d("Main#doAction"," -------------------------------- Hey addSwitch --------------------------"+ipaddres);
        SharedPreferences sharedPref = getSharedPreferences("IP",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("switchIP", ipaddres);
        editor.commit();


        Log.d("Main#doAction"," -------------------------------- commited preference now back to main --------------------------");

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
