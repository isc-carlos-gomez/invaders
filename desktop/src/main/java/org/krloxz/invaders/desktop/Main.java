package org.krloxz.invaders.desktop;

import com.jme3.app.SimpleApplication;
import com.jme3.renderer.RenderManager;
import com.jme3.system.AppSettings;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.Arrays;
import java.util.Comparator;
import mygame.BulletAppState;
import mygame.CollisionAppState;
import mygame.ControlAppState;
import mygame.DecayAppState;
import mygame.EntityDataState;
import mygame.ExplosionAppState;
import mygame.GameAppState;
import mygame.InvadersAIAppState;
import mygame.VisualAppState;

/**
 * test
 *
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    public Main() {
        super(new VisualAppState(),
            new ExplosionAppState(),
            new DecayAppState(),
            new ControlAppState(),
            new InvadersAIAppState(),
            new CollisionAppState(),
            new BulletAppState(),
            new GameAppState(),
            new EntityDataState());
        this.showSettings = false;
    }

    public static void main(final String[] args) {
        final DisplayMode mode = getFullscreenDisplayMode();
        final AppSettings settings = new AppSettings(true);
        settings.setHeight(mode.getHeight());
        settings.setWidth(mode.getWidth());
        settings.setFullscreen(true);
        settings.setBitsPerPixel(mode.getBitDepth());
        settings.setFrequency(mode.getRefreshRate());

        final Main app = new Main();
        app.setShowSettings(false);
        app.setSettings(settings);
        app.start();
    }

    private static DisplayMode getFullscreenDisplayMode() {
        final GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment()
            .getDefaultScreenDevice();

        final DisplayMode[] modes = device.getDisplayModes();
        Arrays.sort(modes, new DisplayModeSorter());
        return modes[modes.length - 1];
    }

    @Override
    public void simpleInitApp() {
    }

    @Override
    public void simpleUpdate(final float tpf) {
    }

    @Override
    public void simpleRender(final RenderManager rm) {
    }

    /**
     * Utility class for sorting <code>DisplayMode</code>s. Sorts by
     * resolution, then bit depth, and then finally refresh rate.
     */
    private static class DisplayModeSorter implements Comparator<DisplayMode> {

        /**
         * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
         */
        @Override
        public int compare(final DisplayMode a, final DisplayMode b) {
            // Width
            if (a.getWidth() != b.getWidth()) {
                return (a.getWidth() > b.getWidth()) ? 1 : -1;
            }
            // Height
            if (a.getHeight() != b.getHeight()) {
                return (a.getHeight() > b.getHeight()) ? 1 : -1;
            }
            // Bit depth
            if (a.getBitDepth() != b.getBitDepth()) {
                return (a.getBitDepth() > b.getBitDepth()) ? 1 : -1;
            }
            // Refresh rate
            if (a.getRefreshRate() != b.getRefreshRate()) {
                return (a.getRefreshRate() > b.getRefreshRate()) ? 1 : -1;
            }
            // All fields are equal
            return 0;
        }
    }
}
