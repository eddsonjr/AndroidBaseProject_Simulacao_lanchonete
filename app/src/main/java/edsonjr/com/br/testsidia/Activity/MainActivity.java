package edsonjr.com.br.testsidia.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edsonjr.com.br.testsidia.R;
import edsonjr.com.br.testsidia.Tasks.BaixarPratosTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new BaixarPratosTask(this).execute();

    }
}
