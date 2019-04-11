package com.hanks.mvc.model;

import com.hanks.mvc.OnWeatherListener;

/**
 * @author 侯建军 47466436@qq.com
 * @class com.hanks.mvc.model.WeatherModel
 * @time 2019/4/11 9:46
 * @description 请填写描述
 */
public interface WeatherModel {
    void getWeather(String cityNumber, OnWeatherListener listener);
}
