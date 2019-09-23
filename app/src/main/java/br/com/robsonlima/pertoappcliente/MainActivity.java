package br.com.robsonlima.pertoappcliente;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import br.com.robsonlima.pertoappcliente.API.APIClient;
import br.com.robsonlima.pertoappcliente.interfaces.OsInterface;
import br.com.robsonlima.pertoappcliente.models.Os;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    OsInterface osInterface;
    List<Os> osList;
    ListView listOss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_main);

        osInterface = APIClient.getClient().create(OsInterface.class);
        listOss = (ListView) findViewById(R.id.listOss);

        onLoadOss();

        listOss.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                Os os = (Os) parent.getItemAtPosition(pos);
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                intent.putExtra("codOS", os.codOS.toString());
                startActivity(intent);
            }
        });
    }

    private void onLoadOss() {
        Call<List<Os>> call = osInterface.getListOss();
        call.enqueue(new Callback<List<Os>>() {
            @Override
            public void onResponse(Call<List<Os>> call, Response<List<Os>> response) {
                osList = response.body();
                onLoadListOss();
            }

            @Override
            public void onFailure(Call<List<Os>> call, Throwable t) {
                call.cancel();
                finish();
            }
        });
    }

    private void onLoadListOss() {
        ArrayAdapter<Os> adapter = new ArrayAdapter<Os>(MainActivity.this, android.R.layout.simple_list_item_1, osList);
        listOss.setAdapter(adapter);
    }
}