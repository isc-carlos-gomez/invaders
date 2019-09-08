package mygame;

import com.simsilica.es.EntityComponent;

public class Decay implements EntityComponent {

    private final long start;
    private final long delta;

    /**
     * @param deltaMillis
     */
    public Decay(final long deltaMillis) {
        this.start = System.nanoTime();
        this.delta = deltaMillis * 1000000;
    }

    /**
     * @return
     */
    public double getPercent() {
        final long time = System.nanoTime();
        return (double) (time - this.start) / this.delta;
    }

    @Override
    public String toString() {
        return "Decay[" + (this.delta / 1000000.0) + " ms]";
    }
}