package com.example.usmanahmed.phonelogtwo;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activityimplements BlankFragment.OnFragmentInteractionListener,DetailFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
        {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
        }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
        {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
        return true;
        }

        return super.onOptionsItemSelected(item);
        }
    @Override
    public void onFragmentInteraction(String string) {
        DataModel dataModel=new Gson().fromJson(string,DataModel.class);
        ((TextView) findViewById(R.id.detailname)).setText(dataModel.getName());
        ((TextView) findViewById(R.id.detailnumber)).setText(dataModel.getVersion_number());
        Picasso.with(this).load(dataModel.getImgurl()).resize(550,550).into(((ImageView)findViewById(R.id.detailimage)));

        }

    @Override
    public void onFragmentInteraction(Uri uri)
        {

        }
        }
