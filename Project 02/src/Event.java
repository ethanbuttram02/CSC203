/**
 * An event is made up of an Entity that is taking an
 * Action a specified time.
 */
public final class Event {
    private Object action;
    private double time;
    private Entity entity;

    public Event(Object action, double time, Entity entity) {
        this.action = action;
        this.time = time;
        this.entity = entity;
    }

    public Object action(){return this.action;}
    public double time(){return this.time;}
    public Entity entity(){return this.entity;}
}
