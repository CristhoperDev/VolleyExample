package crithoper.vrammdev.com.volleyexample;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import crithoper.vrammdev.com.volleyexample.Interface.IResult;
import crithoper.vrammdev.com.volleyexample.Model.VolleyModel;

public class MainActivity extends AppCompatActivity {
    IResult iResult = null;
    VolleyModel volleyModel;
    public static final String URL = "https://tremor.cristhoperdev.com/?op=1";
    RecyclerView recyclerView;
    List<Tremor> tremorList;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerViewInternational);
        tremorList = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new Adapter(this, tremorList);
        recyclerView.setAdapter(adapter);

        initData();
        volleyModel = new VolleyModel(iResult, this);
        volleyModel.getDataArrayVolley(URL);
    }

    void initData() {
        final ProgressDialog progressDialog = ProgressDialog.show(this, "", "Cargando...");
        iResult = new IResult() {
            @Override
            public void notifySuccessObject(JSONObject response) {
                progressDialog.dismiss();
            }

            @Override
            public void notifySuccessArray(JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); ++i) {
                        Tremor tremor = new Tremor();
                        JSONObject row = response.getJSONObject(i);
                        tremor.setPlace(row.optString("place"));
                        tremor.setDatetime(row.optString("dateTime"));
                        tremor.setMagnitude(row.optString("magnitude"));
                        tremor.setEvaluation(row.optString("evaluation"));
                        tremor.setReport(row.optString("report"));
                        tremorList.add(tremor);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                adapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }

            @Override
            public void notifyError(VolleyError error) {
                Log.d("VOLLEY", error.toString());
                progressDialog.dismiss();
            }
        };
    }
}