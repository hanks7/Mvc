package com.hanks.mvc.Controller;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hanks.mvc.OnWeatherListener;
import com.hanks.mvc.R;
import com.hanks.mvc.WeatherInfo;
import com.hanks.mvc.model.WeatherModel;
import com.hanks.mvc.model.WeatherModelImpl;
import com.hanks.mvc.utils.Ulog;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

/**
 * mvc m  网路请求层,
 */
public class MainActivity extends Activity implements View.OnClickListener {

    private WeatherModel weatherModel;
    private ProgressDialog loadingDialog;
    TextView city;
    EditText cityNOInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weatherModel = new WeatherModelImpl();
        initView();
        Ulog.e("getMessage", "");
    }

    /**
     * 初始化View
     */
    private void initView() {
        findView(R.id.btn_go).setOnClickListener(this);
        cityNOInput = findView(R.id.editText);
        city = findView(R.id.textView);
        loadingDialog = new ProgressDialog(this);
        loadingDialog.setCancelable(true);//是否可以被取消
        loadingDialog.setMessage("loading...");//加载显示的信息
        loadingDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);//圆环风格
    }

    /**
     * 显示结果
     *
     * @param weather
     */
    public void displayResult(WeatherInfo weather) {
        city.setText(weather.getCity());
    }

    /**
     * 隐藏进度对话框
     */
    public void hideLoadingDialog() {
        loadingDialog.dismiss();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_go:
                Ulog.i3("btn_go");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        test();
                    }
                }).start();
                break;
        }
    }

    private void async() {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... params) {
                test();
                return null;
            }


            @Override
            protected void onPostExecute(Void aVoid) {

            }
        }.execute();

        return;
    }

    private void main() {
        loadingDialog.show();
        weatherModel.getWeather(cityNOInput.getText().toString().trim(), new OnWeatherListener() {
            @Override
            public void onSuccess(WeatherInfo weather) {
                hideLoadingDialog();
                displayResult(weather);
            }

            @Override
            public void onError() {
                hideLoadingDialog();
                Toast.makeText(MainActivity.this, "获取天气信息失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void test() {
        String url = "http://easyway.com.cn:8080/CustomServicesApi/ScannerDownload?type=0&verify=1&code=281816&msg=20190410";
        EasyHttp.get(url)
                .syncRequest(true)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Ulog.i3(e.getDisplayMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        Ulog.i3(s);
                    }
                });
    }


    private <T extends View> T findView(int id) {
        return (T) findViewById(id);
    }

}