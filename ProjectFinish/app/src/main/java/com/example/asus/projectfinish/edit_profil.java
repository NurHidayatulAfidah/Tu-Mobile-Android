package com.example.asus.projectfinish;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.example.asus.projectfinish.Login.TAG_USERNAME;

public class edit_profil extends AppCompatActivity {
    EditText txt_nama, txt_alamat, txt_no_hp, txt_id;
    Button btn_simpan;
    int success;

    private String url = Server.URL +"profil.php";
    private String url_edit = Server.URL +"edit_profil.php";
    private static final String TAG = edit_profil.class.getSimpleName();

    public static final String TAG_NAMA = "nama";
    public static final String TAG_ALAMAT = "alamat";
    public static final String TAG_NO_HP = "no_hp";
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

    String tag_json_obj = "json_obj_req";
    ConnectivityManager conMgr;

    public static final String TAG_ID = "id";
    SharedPreferences sharedpreferences;
    String id;

    public static final String my_shared_preferences = "my_shared_preferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profil);

        txt_nama = (EditText) findViewById(R.id.nama);
        txt_alamat = (EditText) findViewById(R.id.alamat);
        txt_no_hp = (EditText) findViewById(R.id.no_hp);
        btn_simpan = (Button)findViewById(R.id.btn_simpan);

        sharedpreferences = getSharedPreferences(my_shared_preferences, Context.MODE_PRIVATE);
        id = sharedpreferences.getString(TAG_ID, null);

        txt_id = (EditText) findViewById(R.id.id);
        txt_id.setText(id);

        tampilData(id);
        /*conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        {
            if (conMgr.getActiveNetworkInfo() != null
                    && conMgr.getActiveNetworkInfo().isAvailable()
                    && conMgr.getActiveNetworkInfo().isConnected()) {
                tampilData(id);
            } else {
                Toast.makeText(getApplicationContext() ,"No Internet Connection", Toast.LENGTH_LONG).show();
            }
        }*/

        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idx = txt_id.getText().toString();
                String nama = txt_nama.getText().toString();
                String alamat = txt_alamat.getText().toString();
                String no_hp = txt_no_hp.getText().toString();

                if (conMgr.getActiveNetworkInfo() != null
                        && conMgr.getActiveNetworkInfo().isAvailable()
                        && conMgr.getActiveNetworkInfo().isConnected()) {
                    simpan_update(idx, nama, alamat, no_hp);
                } else {
                    Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void tampilData(final String id) {
        StringRequest strReq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e(TAG, "Data Response: " + response);

                try {
                    JSONObject jObj = new JSONObject(response);

                    String nama = jObj.getString(TAG_NAMA);
                    String alamat = jObj.getString(TAG_ALAMAT);
                    String no_hp = jObj.getString(TAG_NO_HP);

                    txt_nama.setText(nama);
                    txt_alamat.setText(alamat);
                    txt_no_hp.setText(no_hp);

                    Log.e("Successfully Get Data!", jObj.toString());

                } catch (JSONException e) {
                    // JSON error
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("id", id);

                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_json_obj);
    }

    private void simpan_update(final String id, final String nama, final String alamat, final String no_hp) {
        StringRequest strReq = new StringRequest(Request.Method.POST, url_edit, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Response: " + response.toString());

                try {
                    JSONObject jObj = new JSONObject(response);
                    success = jObj.getInt(TAG_SUCCESS);

                    // Cek error node pada json
                    if (success == 1) {

                        Log.e("Berhasil Menyimpan Data!", jObj.toString());

                        Toast.makeText(getApplicationContext(),
                                jObj.getString(TAG_MESSAGE), Toast.LENGTH_SHORT).show();

                        txt_nama.setText("");
                        txt_alamat.setText("");
                        txt_no_hp.setText("");

                        Intent intent = new Intent(edit_profil.this, ProfilActivity.class);
                        finish();
                        startActivity(intent);

                    } else {
                        Toast.makeText(getApplicationContext(),
                                jObj.getString(TAG_MESSAGE), Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    // JSON error
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Error Update: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("id", id);
                params.put("nama", nama);
                params.put("alamat", alamat);
                params.put("no_hp", no_hp);

                return params;
            }

        };

        AppController.getInstance().addToRequestQueue(strReq, tag_json_obj);
    }
}
