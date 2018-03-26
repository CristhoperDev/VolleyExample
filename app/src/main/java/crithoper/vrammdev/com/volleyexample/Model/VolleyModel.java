package crithoper.vrammdev.com.volleyexample.Model;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import crithoper.vrammdev.com.volleyexample.Interface.IResult;

public class VolleyModel {
    IResult iResult;
    Context context;

    public VolleyModel(IResult iResult, Context context) {
        this.iResult = iResult;
        this.context = context;
    }

    public void getDataArrayVolley(String url) {
        try {
            RequestQueue requestQueue = Volley.newRequestQueue(context);
            JsonArrayRequest jsonArray = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    iResult.notifySuccessArray(response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    iResult.notifyError(error);
                }
            }
            );
            requestQueue.add(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
