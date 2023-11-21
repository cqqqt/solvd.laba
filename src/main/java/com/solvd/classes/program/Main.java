package com.solvd.classes.program;

import com.solvd.classes.menu.Menu;
import com.solvd.exceptions.FileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws FileException {
        Menu menu = new Menu();
        menu.startMenu();
    }
}
