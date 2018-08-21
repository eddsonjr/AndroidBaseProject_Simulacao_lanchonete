package edsonjr.com.br.testsidia.Tasks;


import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import edsonjr.com.br.testsidia.Model.Prato;

public class BaixarPratosTask extends AsyncTask<Void,Void,Void> {


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
    protected Void doInBackground(Void... voids) {
        Log.d(TAG, "Dentro de doInBackGround...\n");
        String result = null;


        try {
            Downloader downloader = new Downloader(this.context,new URL(url));
            result = downloader.GET();
            Log.d(TAG, "Resutl: " + result);

            //Fazendo parser
            Gson gson = new Gson();
            List<Prato> pratos = gson.fromJson(result,new  TypeToken<List<Prato>>() {
            }.getType());
            Log.d(TAG,"Feito parser de " + pratos.size() + " pratos vindos da web!");



        }catch (MalformedURLException e ){
            Log.d(TAG,"Erro de criacao da url e parser");
            e.printStackTrace();

        }catch (ConnectException e){
            Log.d(TAG,"Erro de Conexao com a web!");
            e.printStackTrace();
        }


        return null;
    }


    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

    }


}
