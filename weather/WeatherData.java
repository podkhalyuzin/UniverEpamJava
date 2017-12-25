package com.company.weather;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class WeatherData implements Observable {
    private List<Observer> observers;
    private float temperature;
    private int humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers)
            observer.update(temperature, humidity, pressure);
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    /** метод получает json ответ веб-сервиса и возвращает его в виде строки*/
    public String receiveData(String URLpath) throws IOException {
        URL addr = new URL(URLpath);
        HttpURLConnection connection = (HttpURLConnection) addr.openConnection();
        connection.connect();
        InputStream inputStream = connection.getInputStream();
        StringBuilder response = new StringBuilder();
        int c;
        while((c=inputStream.read())!=-1)
            response.append((char)c);
        return response.toString();
    }

    /** метод строки json вытаскивает температуру , влажность и давление
     * и уведомляет наблюдателей
     */
    public void setMeasurements(String jsonResponse) {
        JSONObject obj1 = new JSONObject(jsonResponse);
        JSONArray jArr1 = obj1.getJSONArray("list");
        JSONObject obj2 = jArr1.getJSONObject(1);
        JSONObject obj3 = obj2.getJSONObject("main");
        this.temperature = (float) (obj3.getDouble("temp") - 273.15);
        this.humidity = obj3.getInt("humidity");
        this.pressure = (float) obj3.getDouble("pressure");
        notifyObservers();
    }
}
