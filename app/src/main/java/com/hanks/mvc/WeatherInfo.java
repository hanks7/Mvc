package com.hanks.mvc;

/**
 * @author 侯建军 47466436@qq.com
 * @class com.hanks.mvc.WeatherInfo
 * @time 2019/4/11 9:48
 * @description 请填写描述
 */
public class WeatherInfo {
    String city;
    String cityid;
    String temp;
    String WD;
    String WS;
    String SD;
    String WSE;
    String time;
    String njd;

    public WeatherInfo(String city, String cityid, String temp, String WD) {
        this.city = city;
        this.cityid = cityid;
        this.temp = temp;
        this.WD = WD;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getWD() {
        return WD;
    }

    public void setWD(String WD) {
        this.WD = WD;
    }

    public String getWS() {
        return WS;
    }

    public void setWS(String WS) {
        this.WS = WS;
    }

    public String getSD() {
        return SD;
    }

    public void setSD(String SD) {
        this.SD = SD;
    }

    public String getWSE() {
        return WSE;
    }

    public void setWSE(String WSE) {
        this.WSE = WSE;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNjd() {
        return njd;
    }

    public void setNjd(String njd) {
        this.njd = njd;
    }
}
