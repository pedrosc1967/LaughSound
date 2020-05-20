package com.aplanetbit.laugh.sound;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.text.SpannableString;
import android.text.util.Linkify;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ShareActionProvider;
import android.widget.TextView;

import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.*;

import static android.content.Intent.ACTION_VIEW;

public class LaugSound extends Activity implements OnInitListener {

    public  MediaPlayer mediaPlayer;
    private ShareActionProvider mShareActionProvider;
    //Definición del menú en menu.xml
    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        /** Inflating the current activity's menu with res/menu/items.xml */
        getMenuInflater().inflate(R.menu.menu, menu);

        /** Getting the actionprovider associated with the menu item whose id is share */
        mShareActionProvider = (ShareActionProvider) menu.findItem(R.id.menu_share).getActionProvider();

        /** Setting a share intent */
        mShareActionProvider.setShareIntent(getDefaultShareIntent());

        return super.onCreateOptionsMenu(menu);
    }

    /** Returns a share intent */
    private Intent getDefaultShareIntent(){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.subject1));
        intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.extra_text1));
        return intent;
    }

    //Lo que hace cada opción del menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.Otras_apps:
                startActivity(new Intent(ACTION_VIEW, Uri.parse("https://play.google.com/store/search?q=com.aplanetbit&c=apps") ) );
                return true;
            case R.id.Rate:
                startActivity(new Intent(ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.aplanetbit.laugh.sound") ) );
                return true;
            case R.id.Salir:
                this.finish();
                return true;
            case R.id.Acerca:
                AlertDialog builder;
                try {
                    builder = AboutDialogBuilder.create(this);
                    builder.show();
                } catch (NameNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void playLocalAudio(int R1)throws Exception
    {
        MediaPlayer mediaPlayer = MediaPlayer.create(this,R1);
        mediaPlayer.start();
    }


    @Override
    protected void onResume() {
        super.onResume();


    }
    @Override
    public void onBackPressed ()
    {
        this.finish();
        System.exit(0);
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        super.onBackPressed();
    }

    @Override
    public void onStop()
    {
        if (isFinishing() || (mediaPlayer != null))  {
            System.exit(0);
            mediaPlayer.pause();
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        super.onStop();
        //Cerrar del todo la aplicaci&oacute;n al Salir y evitar que suene cuando no debe
    }
    @Override
    public void onPause ()
    {
        this.finish();
        if (this.isFinishing()) {
            this.finish();
            if (mediaPlayer != null) {
                mediaPlayer.pause();
                mediaPlayer.stop();
                mediaPlayer.release();
            }
        }
        super.onPause();
    }

    //Facebook Affiliated Network
    private AdView adView;


    //Definicion de la interfaz de usuario
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Initialize the Audience Network SDK
        AudienceNetworkAds.initialize(this);

        // Instantiate an AdView object.
        // NOTE: The placement ID from the Facebook Monetization Manager identifies your App.
        // To get test ads, add IMG_16_9_APP_INSTALL# to your placement id. Remove this when your app is ready to serve real ads.

        adView = new AdView(this, "349902665972350_349903182638965", AdSize.BANNER_HEIGHT_50);

        // Find the Ad Container
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);

        // Add the ad view to your activity layout
        adContainer.addView(adView);

        // Request an ad
        adView.loadAd();

        // para el share de la barra de menus
        Intent mShareIntent = new Intent();
        mShareIntent.setAction(Intent.ACTION_SEND);
        mShareIntent.setType("text/plain");
        mShareIntent.putExtra(Intent.EXTRA_TEXT, "From me to you, this text is new.");

        Button pedounoPlayerBtn = (Button)findViewById(R.id.pedounoPlayerBtn);
        Button pedodosPlayerBtn = (Button)findViewById(R.id.pedodosPlayerBtn);
        Button pedotresPlayerBtn = (Button)findViewById(R.id.pedotresPlayerBtn);
        Button pedocuatroPlayerBtn = (Button)findViewById(R.id.pedocuatroPlayerBtn);
        Button pedocincoPlayerBtn = (Button)findViewById(R.id.pedocincoPlayerBtn);
        Button pedoseisPlayerBtn = (Button)findViewById(R.id.pedoseisPlayerBtn);
        Button pedosietePlayerBtn = (Button)findViewById(R.id.pedosietePlayerBtn);
        Button pedoochoPlayerBtn = (Button)findViewById(R.id.pedoochoPlayerBtn);
        Button pedonuevePlayerBtn = (Button)findViewById(R.id.pedonuevePlayerBtn);
        Button pedodiezPlayerBtn = (Button)findViewById(R.id.pedodiezPlayerBtn);
        Button pedooncePlayerBtn = (Button)findViewById(R.id.pedooncePlayerBtn);
        Button pedodocePlayerBtn = (Button)findViewById(R.id.pedodocePlayerBtn);
        Button pedotrecePlayerBtn = (Button)findViewById(R.id.pedotrecePlayerBtn);
        Button pedocatorcePlayerBtn = (Button)findViewById(R.id.pedocatorcePlayerBtn);
        Button pedoquincePlayerBtn = (Button)findViewById(R.id.pedoquincePlayerBtn);
        Button pedodieciseisPlayerBtn = (Button)findViewById(R.id.pedodieciseisPlayerBtn);
        Button pedodiecisietePlayerBtn = (Button)findViewById(R.id.pedodiecisietePlayerBtn);
        Button pedodieciochoPlayerBtn = (Button)findViewById(R.id.pedodieciochoPlayerBtn);
        Button pedodiecinuevePlayerBtn = (Button)findViewById(R.id.pedodiecinuevePlayerBtn);
        Button pedoveinteplayerBtn = (Button)findViewById(R.id.pedoveintePlayerBtn);
        Button pedoventiunolayerBtn = (Button)findViewById(R.id.pedoventiunoPlayerBtn);
        Button pedoventidoslayerBtn = (Button)findViewById(R.id.pedoventidosPlayerBtn);
        Button pedoventitreslayerBtn = (Button)findViewById(R.id.pedoventitresPlayerBtn);
        Button pedoventicuatrolayerBtn = (Button)findViewById(R.id.pedoventicuatroPlayerBtn);
        Button pedoventicincolayerBtn = (Button)findViewById(R.id.pedoventicincoPlayerBtn);
        Button pedoventiseislayerBtn = (Button)findViewById(R.id.pedoventiseisPlayerBtn);
        Button pedoventisietelayerBtn = (Button)findViewById(R.id.pedoventisietePlayerBtn);
        Button pedoventiocholayerBtn = (Button)findViewById(R.id.pedoventiochoPlayerBtn);


//Lo que hace el botón "Pedouno"
        pedounoPlayerBtn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view)
            {
//Se llama a la funcion playLocalAudio
                try{
// Este es el de la edición de Navidad  --> playLocalAudio(R.raw.fart11800);
// Este es el de la edición normal
                    playLocalAudio(R.raw.risas1);


                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }});

//Lo que hace el botón "Pedodos"
        pedodosPlayerBtn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view)
            {
//Se llama a la funcion playLocalAudio
                try{
                    playLocalAudio(R.raw.risas28);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }});

//Lo que hace el botón "Pedotres"
        pedotresPlayerBtn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view)
            {
//Se llama a la funcion playLocalAudio
                try{
                    playLocalAudio(R.raw.risas29);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }});

//Lo que hace el botón "Pedocuatro"
        pedocuatroPlayerBtn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view)
            {
//Se llama a la funcion playLocalAudio
                try{
                    playLocalAudio(R.raw.risas10);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }});

//Lo que hace el botón "Pedocinco"
        pedocincoPlayerBtn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view)
            {
//Se llama a la funcion playLocalAudio
                try{
                    playLocalAudio(R.raw.risas11);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }});

//Lo que hace el botón "Pedoseis"
        pedoseisPlayerBtn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view)
            {
//Se llama a la funcion playLocalAudio
                try{
                    playLocalAudio(R.raw.risas12);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }});

//Lo que hace el botón "Pedosiete"
        pedosietePlayerBtn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view)
            {
//Se llama a la funcion playLocalAudio
                try{
                    //Este era el original lo cambio por el pedoocho... lo vuelvo a dejar igual
                    playLocalAudio(R.raw.risas13);
                    //playLocalAudio(R.raw.fart22);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }});

//Lo que hace el botón "Pedoocho"
        pedoochoPlayerBtn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view)
            {
//Se llama a la funcion playLocalAudio
                try{
                    //Este era el original y se cambi� pior pedosiete... se deja como estaba
                    playLocalAudio(R.raw.risas14);
                    //playLocalAudio(R.raw.fart20);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }});

//Lo que hace el botón "Pedonueve"
        pedonuevePlayerBtn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view)
            {
//Se llama a la funcion playLocalAudio
                try{
                    playLocalAudio(R.raw.risas15);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }});

//Lo que hace el botón "Pedodiez"
        pedodiezPlayerBtn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view)
            {
//Se llama a la funcion playLocalAudio
                try{
                    playLocalAudio(R.raw.risas16);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }});

//Lo que hace el botón "Pedoonce"
        pedooncePlayerBtn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view)
            {
//Se llama a la funcion playLocalAudio
                try{
                    playLocalAudio(R.raw.risas17);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }});

//Lo que hace el botón "Pedodoce"
        pedodocePlayerBtn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view)
            {
//Se llama a la funcion playLocalAudio
                try{
                    playLocalAudio(R.raw.risas18);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }});

//Lo que hace el botón "Pedotrece"
        pedotrecePlayerBtn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view)
            {
//Se llama a la funcion playLocalAudio
                try{
                    playLocalAudio(R.raw.risas19);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }});

//Lo que hace el botón "Pedocatorce"
        pedocatorcePlayerBtn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view)
            {
//Se llama a la funcion playLocalAudio
                try{
                    playLocalAudio(R.raw.risas21);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }});

//Lo que hace el botón "Pedoquince"
        pedoquincePlayerBtn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view)
            {
//Se llama a la funcion playLocalAudio
                try{
                    playLocalAudio(R.raw.risas22);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }});

//Lo que hace el botón "Pedodieciseis"
        pedodieciseisPlayerBtn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view)
            {
//Se llama a la funcion playLocalAudio
                try{
                    playLocalAudio(R.raw.risas6);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }});

//Lo que hace el botón "Pedodiecisiete"
        pedodiecisietePlayerBtn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view)
            {
//Se llama a la funcion playLocalAudio
                try{
                    playLocalAudio(R.raw.risas7);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }});

//Lo que hace el botón "Pedodieciocho"
        pedodieciochoPlayerBtn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view)
            {
//Se llama a la funcion playLocalAudio
                try{
                    playLocalAudio(R.raw.risas8);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }});

        pedodiecinuevePlayerBtn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view)
            {
//Se llama a la funcion playLocalAudio
                try{
                    playLocalAudio(R.raw.risas9);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }});

        pedoveinteplayerBtn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view)
            {
//Se llama a la funcion playLocalAudio
                try{
                    playLocalAudio(R.raw.risas23);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }});

        pedoventiunolayerBtn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view)
            {
//Se llama a la funcion playLocalAudio
                try{
                    playLocalAudio(R.raw.risas24);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }});

        pedoventidoslayerBtn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view)
            {
//Se llama a la funcion playLocalAudio
                try{
                    playLocalAudio(R.raw.risas25);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }});

        pedoventitreslayerBtn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view)
            {
//Se llama a la funcion playLocalAudio
                try{
                    playLocalAudio(R.raw.risas26);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }});

        pedoventicuatrolayerBtn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view)
            {
//Se llama a la funcion playLocalAudio
                try{
                    playLocalAudio(R.raw.risas27);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }});


        pedoventicincolayerBtn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view)
            {
//Se llama a la funcion playLocalAudio
                try{
                    playLocalAudio(R.raw.risas20);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }});

        pedoventiseislayerBtn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view)
            {
//Se llama a la funcion playLocalAudio
                try{
                    playLocalAudio(R.raw.risas2);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }});

        pedoventisietelayerBtn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view)
            {
//Se llama a la funcion playLocalAudio
                try{
                    playLocalAudio(R.raw.risas18);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }});

        pedoventiocholayerBtn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view)
            {
//Se llama a la funcion playLocalAudio
                try{
                    playLocalAudio(R.raw.risas5);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }});


//Aqui se pondr�an m�s botones
    }

    @Override
    public void onInit(int arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    protected void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }


    //Aqui se ponen nuevos m�todos
//Este di�logo es para contruir el diálogo de acerca de...
    public static class AboutDialogBuilder {
        public static AlertDialog create( Context context ) throws NameNotFoundException {
            // Try to load the a package matching the name of our own package
            PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            String versionInfo = pInfo.versionName;

            String aboutTitle = String.format(context.getString(R.string.about) + " %s", context.getString(R.string.app_name));
            String versionString = String.format(context.getString(R.string.version) +" %s", versionInfo);
            String aboutText = context.getString(R.string.textoabout);

            // Set up the TextView
            final TextView message = new TextView(context);
            // We'll use a spannablestring to be able to make links clickable
            final SpannableString s = new SpannableString(aboutText);

            // Set some padding
            message.setPadding(5, 5, 5, 5);
            // Set up the final string
            message.setText(versionString + "\n\n" + s);
            // Now linkify the text
            Linkify.addLinks(message, Linkify.ALL);
            return new AlertDialog.Builder(context).setTitle(aboutTitle).setCancelable(true).setIcon(R.mipmap.ic_launcher).setPositiveButton(
                    context.getString(android.R.string.ok), null).setView(message).create();


        }
    }
}
