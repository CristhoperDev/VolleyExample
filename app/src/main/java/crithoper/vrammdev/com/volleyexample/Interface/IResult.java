package crithoper.vrammdev.com.volleyexample.Interface;

import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONObject;

public interface IResult {
    void notifySuccessObject(JSONObject response);
    void notifySuccessArray(JSONArray response);
    void notifyError(VolleyError error);
}
