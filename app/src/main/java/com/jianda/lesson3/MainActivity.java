package com.jianda.lesson3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.jianda.lesson3.adapters.ItemAdapter;
import com.jianda.lesson3.utils.Item;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit.Converter;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity implements retrofit.Callback<List<Item>> {

  /*  private Call call;*/
    private ListView listView;

//    private ArrayAdapter<String> adapter;
    private ItemAdapter adapter;
    private retrofit.Call<List<Item>> call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.main_list);
        adapter = new ItemAdapter(this);
        listView.setAdapter(adapter);
        Retrofit build = new Retrofit.Builder().baseUrl("http://pic.qiushibaike.com")
                .addConverterFactory(new Converter.Factory() {
                    @Override
                    public Converter<ResponseBody, ?> fromResponseBody(Type type, final Annotation[] annotations) {
                        return new Converter<ResponseBody, List<Item>>() {
                            @Override
                            public List<Item> convert(ResponseBody value) throws IOException {
                                String s = value.string();
                                JSONObject object = null;
                                List<Item> list = new ArrayList<>();
                                try {
                                    object = new JSONObject(s);
                                    JSONArray items = object.getJSONArray("items");

                                    for (int i = 0; i < items.length(); i++) {
                                        list.add(new Item(items.getJSONObject(i)));
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                                return list;
                            }
                        };
                    }
                })
                .build();

        //得到糗事百科的实例
        QsbkService service = build.create(QsbkService.class);
        call = service.getList("image", 1);
        call.enqueue(this);
//        textView = (TextView) findViewById(R.id.main_text);
  /*      listView = (ListView) findViewById(R.id.main_list);
//        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,new ArrayList<String>());
        adapter = new ItemAdapter(this);
        listView.setAdapter(adapter);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("http://m2.qiushibaike.com/article/list/suggest?page=").get().build();
        call = client.newCall(request);
        call.enqueue(this);*/
    }

    @Override
    public void onResponse(retrofit.Response<List<Item>> response, Retrofit retrofit) {
        adapter.addAll(response.body());
    }

    @Override
    public void onFailure(Throwable t) {
        t.printStackTrace();
        Toast.makeText(this,"网络错误",Toast.LENGTH_SHORT).show();
    }

//    @Override
//    public void onFailure(Request request, IOException e) {
//        e.printStackTrace();
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                Toast.makeText(MainActivity.this,"网络问题",Toast.LENGTH_SHORT).show();
//
//            }
//        });
//    }
//
//    @Override
//    public void onResponse(Response response) throws IOException {
//        final String s = response.body().string();
//        try {
//            JSONObject object = new JSONObject(s);
//            JSONArray items = object.getJSONArray("items");
////            final List<String> list = new ArrayList<>();
//            final List<Item> list = new ArrayList<>();
//            for (int i = 0; i < items.length(); i++) {
////                list.add(items.getJSONObject(i).getString("content"));
//                list.add(new Item(items.getJSONObject(i)));
//            }
//
//            runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
////            textView.setText(s);
////                    for (String  s: list) {
////                        adapter.add(s);
////                    }
//                adapter.addAll(list);
//                }
//            });
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        call.cancel();
//    }
}
