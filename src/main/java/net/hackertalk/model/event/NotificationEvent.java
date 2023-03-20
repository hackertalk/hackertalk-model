package net.hackertalk.model.event;

import java.io.Serializable;
import java.time.Clock;

public abstract class NotificationEvent<S> implements Serializable {

    public static final String TOPIC = "NOTIFICATION";
    private final String tag;

    private S source;
    private final long timestamp;

    public NotificationEvent(S source, String tag) {
        this.timestamp = System.currentTimeMillis();
        this.source = source;
        this.tag = tag;
    }

    public NotificationEvent(S source, String tag, Clock clock) {
        if (source == null) {
            throw new IllegalArgumentException("null source");
        }
        this.timestamp = clock.millis();
        this.source = source;
        this.tag = tag;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getTag() {
        return this.tag;
    }

    public S getSource() {
        return source;
    }

    public void setSource(S source) {
        this.source = source;
    }
}
