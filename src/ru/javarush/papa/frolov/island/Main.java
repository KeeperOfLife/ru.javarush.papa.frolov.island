package ru.javarush.papa.frolov.island;

import ru.javarush.papa.frolov.island.settings.Settings;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(Settings.getInstance().getIslandOsX());
    }
}