package edsonjr.com.br.testsidia.Tasks;


import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import edsonjr.com.br.testsidia.Utils.IOUtils;


public class Downloader  {


    public final int TIMEOUT_MILLIS = 15000;
    private URL url;
    private final String TAG = Downloader.class.getCanonicalName();



    //Construtor
    public Downloader(URL url){
        this.url = url;
    }



    public String GET(){

        String dataParsed = new String();
        String data = "";
        HttpURLConnection connection = null;
        InputStream inputStream;
        BufferedReader bufferedReader;


        //Tentando estabelecer conexao e baixar conteudo da URL
        try{
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(TIMEOUT_MILLIS);

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
        //retornando os dados baixados de decodificados em formato
        return dataParsed;
    }










}
