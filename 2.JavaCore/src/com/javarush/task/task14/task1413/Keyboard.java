package com.javarush.task.task14.task1413;
import java.lang.Class.*;

public class Keyboard implements CompItem {
    @Override
    public String getName() {

        return this.getClass().getSimpleName();
    }
}
