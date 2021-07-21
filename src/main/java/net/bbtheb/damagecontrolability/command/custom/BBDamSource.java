package net.bbtheb.damagecontrolability.command.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractFireballEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.WitherSkullEntity;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.explosion.Explosion;
import org.jetbrains.annotations.Nullable;

public class BBDamSource extends DamageSource {
    public static final BBDamSource IN_FIRE = (new BBDamSource("inFire")).setBypassesArmor().setFire();
    public static final BBDamSource LIGHTNING_BOLT = new BBDamSource("lightningBolt");
    public static final BBDamSource ON_FIRE = (new BBDamSource("onFire")).setBypassesArmor().setFire();
    public static final BBDamSource LAVA = (new BBDamSource("lava")).setFire();
    public static final BBDamSource HOT_FLOOR = (new BBDamSource("hotFloor")).setFire();
    public static final BBDamSource IN_WALL = (new BBDamSource("inWall")).setBypassesArmor();
    public static final BBDamSource CRAMMING = (new BBDamSource("cramming")).setBypassesArmor();
    public static final BBDamSource DROWN = (new BBDamSource("drown")).setBypassesArmor();
    public static final BBDamSource STARVE = (new BBDamSource("starve")).setBypassesArmor().setUnblockable();
    public static final BBDamSource CACTUS = new BBDamSource("cactus");
    public static final BBDamSource FALL = (new BBDamSource("fall")).setBypassesArmor();
    public static final BBDamSource FLY_INTO_WALL = (new BBDamSource("flyIntoWall")).setBypassesArmor();
    public static final BBDamSource OUT_OF_WORLD = (new BBDamSource("outOfWorld")).setBypassesArmor().setOutOfWorld();
    public static final BBDamSource GENERIC = (new BBDamSource("generic")).setBypassesArmor();
    public static final BBDamSource MAGIC = (new BBDamSource("magic")).setBypassesArmor().setUsesMagic();
    public static final BBDamSource WITHER = (new BBDamSource("wither")).setBypassesArmor();
    public static final BBDamSource ANVIL = new BBDamSource("anvil");
    public static final BBDamSource FALLING_BLOCK = new BBDamSource("fallingBlock");
    public static final BBDamSource DRAGON_BREATH = (new BBDamSource("dragonBreath")).setBypassesArmor();
    public static final BBDamSource DRYOUT = new BBDamSource("dryout");
    public static final BBDamSource SWEET_BERRY_BUSH = new BBDamSource("sweetBerryBush");
    private boolean bypassesArmor;
    private boolean outOfWorld;
    private boolean unblockable;
    private float exhaustion = 0.1F;
    private boolean fire;
    private boolean projectile;
    private boolean scaleWithDifficulty;
    private boolean magic;
    private boolean explosive;
    public final String name;

    public static BBDamSource sting(LivingEntity attacker) {
        return new BBEntDamSource("sting", attacker);
    }

    public static BBDamSource mob(LivingEntity attacker) {
        return new BBEntDamSource("mob", attacker);
    }

    public static BBDamSource mobProjectile(Entity projectile, LivingEntity attacker) {
        return new BBProjectileDamageSource("mob", projectile, attacker);
    }

    public static BBDamSource player(PlayerEntity attacker) {
        return new BBEntDamSource("player", attacker);
    }

    public static BBDamSource arrow(@Nullable Entity attacker,@Nullable PersistentProjectileEntity projectile) {
        return (new BBProjectileDamageSource("arrow", projectile, attacker)).setProjectile();
    }

    public static BBDamSource bbtrident(@Nullable Entity attacker,@Nullable Entity trident) {
        return (new BBProjectileDamageSource("trident", trident, attacker)).setProjectile();
    }

    public static BBDamSource bbfirework(@Nullable Entity attacker,@Nullable FireworkRocketEntity firework) {
        return (new BBProjectileDamageSource("fireworks", firework, attacker)).setExplosive();
    }

    public static BBDamSource bbfireball(@Nullable Entity attacker,@Nullable AbstractFireballEntity fireball) {
        return attacker == null ? (new BBProjectileDamageSource("onFire", fireball, fireball)).setFire().setProjectile() : (new BBProjectileDamageSource("fireball", fireball, attacker)).setFire().setProjectile();
    }

    public static BBDamSource bbwitherSkull(@Nullable Entity attacker,@Nullable WitherSkullEntity witherSkull) {
        return (new BBProjectileDamageSource("witherSkull", witherSkull, attacker)).setProjectile();
    }

    public static BBDamSource bbthrownProjectile(@Nullable Entity attacker, @Nullable Entity projectile) {
        return (new BBProjectileDamageSource("thrown", projectile, attacker)).setProjectile();
    }

    public static BBDamSource bbmagic(@Nullable Entity attacker,@Nullable Entity magic) {
        return (new BBProjectileDamageSource("indirectMagic", magic, attacker)).setBypassesArmor().setUsesMagic();
    }

    public static BBDamSource thorns(Entity attacker) {
        return (new BBEntDamSource("thorns", attacker)).setThorns().setUsesMagic();
    }

    public static BBDamSource explosion(@Nullable Explosion explosion) {
        return explosion(explosion != null ? explosion.getCausingEntity() : null);
    }

    public static BBDamSource explosion(@Nullable LivingEntity attacker) {
        return attacker != null ? (new BBEntDamSource("explosion.player", attacker)).setScaledWithDifficulty().setExplosive() : (new BBDamSource("explosion")).setScaledWithDifficulty().setExplosive();
    }

    public static BBDamSource bbarrow(@Nullable Entity attacker, @Nullable PersistentProjectileEntity projectile) {
        return (new BBProjectileDamageSource("arrow", projectile, attacker)).setProjectile();
    }

    public String toString() {
        return "DamageSource (" + this.name + ")";
    }

    public boolean isProjectile() {
        return this.projectile;
    }

    public BBDamSource setProjectile() {
        this.projectile = true;
        return this;
    }

    public boolean isExplosive() {
        return this.explosive;
    }

    public BBDamSource setExplosive() {
        this.explosive = true;
        return this;
    }

    public boolean bypassesArmor() {
        return this.bypassesArmor;
    }

    public float getExhaustion() {
        return this.exhaustion;
    }

    public boolean isOutOfWorld() {
        return this.outOfWorld;
    }

    public boolean isUnblockable() {
        return this.unblockable;
    }

    protected BBDamSource(String name) {
        super(name);
        this.name = name;
    }

    @Nullable
    public Entity getSource() {
        return this.getAttacker();
    }

    @Nullable
    public Entity getAttacker() {
        return null;
    }

    protected BBDamSource setBypassesArmor() {
        this.bypassesArmor = true;
        this.exhaustion = 0.0F;
        return this;
    }

    protected BBDamSource setOutOfWorld() {
        this.outOfWorld = true;
        return this;
    }

    protected BBDamSource setUnblockable() {
        this.unblockable = true;
        this.exhaustion = 0.0F;
        return this;
    }

    protected BBDamSource setFire() {
        this.fire = true;
        return this;
    }

    public Text getDeathMessage(LivingEntity entity) {
        LivingEntity livingEntity = entity.getPrimeAdversary();
        String string = "death.attack." + this.name;
        String string2 = string + ".player";
        return livingEntity != null ? new TranslatableText(string2, new Object[]{entity.getDisplayName(), livingEntity.getDisplayName()}) : new TranslatableText(string, new Object[]{entity.getDisplayName()});
    }

    public boolean isFire() {
        return this.fire;
    }

    public String getName() {
        return this.name;
    }

    public BBDamSource setScaledWithDifficulty() {
        this.scaleWithDifficulty = true;
        return this;
    }

    public boolean isScaledWithDifficulty() {
        return this.scaleWithDifficulty;
    }

    public boolean isMagic() {
        return this.magic;
    }

    public BBDamSource setUsesMagic() {
        this.magic = true;
        return this;
    }

    public boolean isSourceCreativePlayer() {
        Entity entity = this.getAttacker();
        return entity instanceof PlayerEntity && ((PlayerEntity)entity).getAbilities().creativeMode;
    }

    @Nullable
    public Vec3d getPosition() {
        return null;
    }
}
