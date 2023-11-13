public class Animation {

    public Entity entity;
    public WorldModel world;
    public ImageStore imageStore;
    public int repeatCount;
    public EventScheduler scheduler;

    public Animation(Entity entity, WorldModel world, ImageStore imageStore, int repeatCount, EventScheduler scheduler) {
        this.entity = entity;
        this.world = world;
        this.imageStore = imageStore;
        this.repeatCount = repeatCount;
        this.scheduler = scheduler;
    }

    public Animation createAnimationAction(Entity entity, int repeatCount) {
        return new Animation(entity, null, null,  Math.max(repeatCount - 1, 0), scheduler);
    }

    public void executeAnimationAction(EventScheduler scheduler) {
        this.entity.nextImage();

        if (this.repeatCount != 1) {
            scheduler.scheduleEvent(this.entity, createAnimationAction(this.entity, this.repeatCount), this.entity.getAnimationPeriod());
        }
    }

    public void executeAnimation(EventScheduler scheduler) {
        this.executeAnimationAction(scheduler);
    }

}
