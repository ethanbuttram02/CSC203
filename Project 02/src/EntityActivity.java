public class EntityActivity extends Entity {

    protected Entity entity;
    protected WorldModel world;
    protected EventScheduler scheduler;
    protected int resourceCount;
    protected int resourceLimit;

    public EntityActivity(Entity entity, WorldModel world, ImageStore imageStore, EventScheduler scheduler) {
        super(world, imageStore, entity.repeatCount, entity.id, entity.position, entity.images);
        this.entity = entity;
        this.world = world;
        this.scheduler = scheduler;
    }

    public EntityActivity createActivityAction(Entity entity, WorldModel world, ImageStore imageStore) {
        return new EntityActivity(entity, null, null, scheduler);
    }

    public void executeActivityAction(EventScheduler scheduler) {
        ((AnimatedEntity)entity).executeActivity(this.world, this.imageStore, scheduler);
    }
}
