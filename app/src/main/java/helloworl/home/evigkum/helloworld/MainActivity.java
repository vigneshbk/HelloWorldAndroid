package helloworl.home.evigkum.helloworld;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d("MainActivity","---------------------------------------------------");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }


    @Override
    protected void onStart() {
        super.onStart();

        TextView message = (TextView) findViewById(R.id.message);
        Log.d("MainActivityonStart","--------------------------------------------------- onStart");
        //Show the switch preference
        SharedPreferences sharedPref = getSharedPreferences("IP",Context.MODE_PRIVATE);

        Log.d("MainActivityonStart","All prefs : "+sharedPref.getAll());


        String ip = sharedPref.getString("switchIP",null);
        Log.d("MainActivityonStart","All switchIP : "+ip);
        if(ip==null)
        {
            message.setText("Please Add a Switch Using Config Option");
        }
        else
        {
            message.setText("IP :"+ip);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Called on getQuote

    /*public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        Log.d("Main#sendMessage"," -------------------------------- Hey sendMessage --------------------------");
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        Log.d("Main#sendMessage"," -------------------------------- Hey get Quote for --------------------------"+message);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }*/



    public void addSwitch(View view) {
        Intent intent = new Intent(this, AddSwitchActivity.class);
        Log.d("Main#addSwitch"," -------------------------------- Hey addSwitch --------------------------");
          startActivity(intent);

    }
}
