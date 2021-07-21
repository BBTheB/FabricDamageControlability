package net.bbtheb.damagecontrolability.command.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import org.jetbrains.annotations.Nullable;

public class BBProjectileDamageSource extends BBEntDamSource {
    private final Entity attacker;

    public BBProjectileDamageSource(String name,@Nullable Entity projectile, @Nullable Entity attacker) {
        super(name, attacker);
        this.attacker = attacker;
    }

    @Nullable
    public Entity getSource() {
        return this.source;
    }

    @Nullable
    public Entity getAttacker() {
        return this.attacker;
    }

    public Text getDeathMessage(LivingEntity entity) {
        Text text = this.attacker == null ? Text.of(this.name) : this.attacker.getDisplayName();
        ItemStack itemStack = this.attacker instanceof LivingEntity ? ((LivingEntity)this.attacker).getMainHandStack() : ItemStack.EMPTY;
        String string = "death.attack." + this.name;
        String string2 = string + ".item";
        return !itemStack.isEmpty() && itemStack.hasCustomName() ? new TranslatableText(string2, new Object[]{entity.getDisplayName(), text, itemStack.toHoverableText()}) : new TranslatableText(string, new Object[]{entity.getDisplayName(), text});
    }
}
