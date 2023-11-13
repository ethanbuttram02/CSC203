public class Health extends AnimatedEntity {

    protected int health;
    protected int healthLimit;

    public Health(Entity entity, EventScheduler scheduler, int health, int healthLimit) {
        super(entity, entity.repeatCount, scheduler);
        this.health = health;
        this.healthLimit = healthLimit;
    }

    public int getHealth() { return health; }

    public int getHealthLimit() { return healthLimit; }
}
