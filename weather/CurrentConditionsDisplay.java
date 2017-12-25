package com.company.weather;

class CurrentConditionsDisplay implements Observer {
    private float temperature;
    private int humidity;
    private float pressure;
    private WeatherData weatherData;

    public float getTemperature() {
        return temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public CurrentConditionsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public WeatherData getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    @Override
    public void update(float temperature, int humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public void display() {
        System.out.println("В Киеве сейчас");
        System.out.println((int)temperature+" градусa(oв)");
        System.out.println("Влажность - "+humidity+"%");
        System.out.println("Давление -"+pressure+" рт.ст.");
    }
}