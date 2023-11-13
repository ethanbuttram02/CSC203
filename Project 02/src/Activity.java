public class Activity {

    public Entity entity;
    public WorldModel world;
    public ImageStore imageStore;
    public EventScheduler scheduler;

    public Activity(Entity entity, WorldModel world, ImageStore imageStore, EventScheduler scheduler) {
        this.entity = entity;
        this.world = world;
        this.imageStore = imageStore;
        this.scheduler = scheduler;
    }

    public Activity createActivityAction(Entity entity) {
        return new Activity(entity, null, null, scheduler);
    }

    public void executeActivity(EventScheduler scheduler) {
        this.executeActivityAction(scheduler);
    }

    public void executeActivityAction(EventScheduler scheduler) {
        ((AnimatedEntity)entity).executeActivity(scheduler);
    }

    /*{
        switch (entity) {
            case SAPLING:
                this.entity.executeSaplingActivity(this.world, this.imageStore, scheduler);
                break;
            case TREE:
                this.entity.executeTreeActivity(this.world, this.imageStore, scheduler);
                break;
            case FAIRY:
                this.entity.executeFairyActivity(this.world, this.imageStore, scheduler);
                break;
            case DUDE_NOT_FULL:
                this.entity.executeDudeNotFullActivity(this.world, this.imageStore, scheduler);
                break;
            case DUDE_FULL:
                this.entity.executeDudeFullActivity(this.world, this.imageStore, scheduler);
                break;
            default:
                throw new UnsupportedOperationException(String.format("executeActivityAction not supported for %s",
                        this.entity.getKind()));
        }
    }*/
}
