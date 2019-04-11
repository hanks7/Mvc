package com.hanks.mvc;

/**
 * @author 侯建军 47466436@qq.com
 * @class com.hanks.mvc.OnWeatherListener
 * @time 2019/4/11 9:47
 * @description 请填写描述
 */
public interface OnWeatherListener {
    void onSuccess(WeatherInfo weather);

    void onError();


}
