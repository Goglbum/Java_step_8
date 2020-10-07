package ru.netologi.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class ConditionerTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/increaseCurrentTemperature.csv")
    public void increaseCurrentTemperature(int maxTemperature, int currentTemperature, int expected) {
        Conditioner conditioner = new Conditioner();
        conditioner.setMaxTemperature(maxTemperature);
        conditioner.setCurrentTemperature(currentTemperature);
        conditioner.increaseCurrentTemperature(currentTemperature);
        int actual = conditioner.getCurrentTemperature();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/decreaseCurrentTemperature.csv")
    public void decreaseCurrentTemperature(int minTemperature, int currentTemperature, int expected) {
        Conditioner conditioner = new Conditioner();
        conditioner.setMinTemperature(minTemperature);
        conditioner.setCurrentTemperature(currentTemperature);
        conditioner.decreaseCurrentTemperature(currentTemperature);
        int actual = conditioner.getCurrentTemperature();
        assertEquals(expected, actual);
    }
}