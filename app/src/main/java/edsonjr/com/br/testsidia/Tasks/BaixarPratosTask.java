package edsonjr.com.br.testsidia.Tasks;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import edsonjr.com.br.testsidia.Model.Prato;

public class BaixarPratosTask extends AsyncTask<Object, Integer, List<Prato>> {


    private final String TAG = BaixarPratosTask.class.getCanonicalName();
    private Context context;
    private String broadCastName;
    private final String url = "https://api.myjson.com/bins/7l8g0";


    //Construtores
    public BaixarPratosTask() {
        //Construtor padrao
    }

    public BaixarPratosTask(Context context) {
        this.context = context;
    }

    public BaixarPratosTask(Context context, String broadCastName){
        this.context = context;
        this.broadCastName = broadCastName;
    }





    @Override
    protected List<Prato> doInBackground(Object... objects) {
        Log.d(TAG, "Dentro de doInBackGround...\n");
        String result = null;
        Gson gson = new Gson();
        List<Prato> pratos = new ArrayList<Prato>();


        try {
            Downloader downloader = new Downloader(this.context,new URL(url));
            result = downloader.GET();
            Log.d(TAG, "Resutl: " + result);

            //Fazendo parser
            pratos = gson.fromJson(result,new  TypeToken<List<Prato>>() {
            }.getType());

            Log.d(TAG,"Feito parser de " + pratos.size() + " pratos vindos da web!");

        }catch (MalformedURLException e ){
            Log.d(TAG,"Erro de criacao da url e parser");
            e.printStackTrace();

        }catch (ConnectException e){
            Log.d(TAG,"Erro de Conexao com a web!");
            e.printStackTrace();
        }

        return pratos;

    }



    protected void onPostExecute(List<Prato> pratos){
        Log.d(TAG,"Dentro de onPostExecute. Recebido " + pratos.size() + " pratos");
        if(pratos != null || pratos.size() != 0){
            dispararBroadcast(pratos);
        }
    }



    protected void dispararBroadcast(List<Prato> pratos) {

        Log.d(TAG,"Disparando broadcast...");

        if(this.context != null){
            Intent atulaizarPratos = new Intent(this.broadCastName);
            atulaizarPratos.putExtra ("listaPratos",(ArrayList<Prato>) pratos);
            LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(this.context);
            broadcastManager.sendBroadcast(atulaizarPratos);
        }else{
            Log.d(TAG, "Contexto nulo!");
        }
    }

}
