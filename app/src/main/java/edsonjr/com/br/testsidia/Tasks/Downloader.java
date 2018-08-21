package edsonjr.com.br.testsidia.Tasks;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import edsonjr.com.br.testsidia.Utils.IOUtils;


public class Downloader  {

    private Context context;
    private final int TIMEOUT_MILLIS = 15000;
    private URL url;
    private final String TAG = Downloader.class.getCanonicalName();



    //Construtor
    public Downloader(Context context, URL url){
        this.url = url;
        this.context = context;
    }



    public String GET() throws ConnectException{

        String dataParsed = new String();
        String data = "";
        HttpURLConnection connection = null;
        InputStream inputStream;
        BufferedReader bufferedReader;


        if(isOnline()){
            Log.d(TAG, "Conectado a web!");
            //Tentando estabelecer conexao e baixar conteudo da URL
            try{
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(TIMEOUT_MILLIS);
                connection.setRequestProperty("Content-Type","application/json");

                //Verificando a resposta do servidor
                int responseCode = connection.getResponseCode();

                if(responseCode  >= HttpURLConnection.HTTP_BAD_REQUEST){
                    Log.d(TAG, "Erro de conexao ou falha de processamento! Codigo: " + responseCode);
                }else{
                    inputStream = connection.getInputStream();
                    //Convertendo inputstream para string
                    dataParsed = IOUtils.toString(inputStream,"UTF-8");
                }

            }catch (MalformedURLException e){
                Log.d(TAG, "Error...");
                e.printStackTrace();
            } catch (IOException e){
                Log.d(TAG, "Error...");
                e.printStackTrace();
            }
        }else{
            throw new ConnectException("Falha de conexao!");
        }


        //retornando os dados baixados de decodificados em formato
        return dataParsed;
    }



    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager)
                this.context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }







}
