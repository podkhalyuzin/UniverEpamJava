package com.company.weather;

public interface Observer {
    void update (float temperature, int humidity, float pressure);
}
