public class Obstacle extends AnimatedEntity {

    public Obstacle(Entity entity, int repeatCount, EventScheduler scheduler) {
        super(entity, repeatCount, scheduler);
    }

    public void scheduleActions(EventScheduler scheduler, WorldModel world, ImageStore imageStore) {
        scheduler.scheduleEvent(this, this.createAnimationAction(this, 0), getAnimationPeriod());
    }

    public double getAnimationPeriod() { return this.animationPeriod; }
}
