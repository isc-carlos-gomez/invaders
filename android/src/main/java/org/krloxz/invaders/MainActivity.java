package org.krloxz.invaders;

import com.jme3.app.AndroidHarness;

public class MainActivity extends AndroidHarness {

    public MainActivity() {
        // Set the application class to run
        appClass = "mygame.Main";

        // Try ConfigType.FASTEST; or ConfigType.LEGACY if you have problems
//        eglConfigType = ConfigType.BEST;

        // Exit Dialog title & message
        exitDialogTitle = "Quit game?";
        exitDialogMessage = "Do you really want to quit the game?";

        // Choose screen orientation
//        screenOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;

        // Invert the MouseEvents X (default = true)
        mouseEventsInvertX = true;

        // Invert the MouseEvents Y (default = true)
        mouseEventsInvertY = true;
    }
}
