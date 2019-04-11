package com.hanks.mvc.model;

import android.os.Handler;

import com.hanks.mvc.OnWeatherListener;
import com.hanks.mvc.WeatherInfo;

/**
 * @author 侯建军 47466436@qq.com
 * @class com.hanks.mvc.model.WeatherModelImpl
 * @time 2019/4/11 9:46
 * @description 请填写描述
 */
public class WeatherModelImpl implements WeatherModel {

    @Override
    public void getWeather(final String cityNumber, final OnWeatherListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (cityNumber.contains("1")) {
                    WeatherInfo weather = new WeatherInfo("shanghai", "123213", "fasdfdas", "fasdfasdf");
                    listener.onSuccess(weather);
                } else {
                    listener.onError();
                }

            }
        }, 1500);


    }

}
