package net.bbtheb.damagecontrolability.command;

import net.bbtheb.damagecontrolability.command.custom.BBDamSource;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;

import java.util.Collection;

import static net.minecraft.server.command.CommandManager.*;

public class damage {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("damage").requires(cs -> cs.hasPermissionLevel(2))
                .then(CommandManager.argument("target", EntityArgumentType.entities()).executes((commandContext) -> {
                            return hurt((ServerCommandSource)commandContext.getSource(), DamageSource.GENERIC,EntityArgumentType.getEntities(commandContext, "target"), 1);
                        })
                                .then(CommandManager.literal("minecraft:Generic").executes((commandContext) -> {
                                    return hurt((ServerCommandSource)commandContext.getSource(), DamageSource.GENERIC,EntityArgumentType.getEntities(commandContext, "target"), 1);
                                }).then(CommandManager.argument("amount", FloatArgumentType.floatArg()).executes((commandContext) -> {
                                    return hurt((ServerCommandSource)commandContext.getSource(), DamageSource.GENERIC,EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                })))
                                .then(CommandManager.literal("minecraft:On_Fire").executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.ON_FIRE;
                                    return hurt((ServerCommandSource)commandContext.getSource(), damagetype,EntityArgumentType.getEntities(commandContext, "target"), 1);
                                }).then(CommandManager.argument("amount", FloatArgumentType.floatArg()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.ON_FIRE;
                                    return hurt((ServerCommandSource)commandContext.getSource(), damagetype,EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                })))
                                .then(CommandManager.literal("minecraft:Starve").executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.STARVE;
                                    return hurt((ServerCommandSource)commandContext.getSource(), damagetype,EntityArgumentType.getEntities(commandContext, "target"), 1);
                                }).then(CommandManager.argument("amount", FloatArgumentType.floatArg()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.STARVE;
                                    return hurt((ServerCommandSource)commandContext.getSource(), damagetype,EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                })))
                                .then(CommandManager.literal("minecraft:Out_Of_World").executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.OUT_OF_WORLD;
                                    return hurt((ServerCommandSource)commandContext.getSource(), damagetype,EntityArgumentType.getEntities(commandContext, "target"), 1);
                                }).then(CommandManager.argument("amount", FloatArgumentType.floatArg()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.OUT_OF_WORLD;
                                    return hurt((ServerCommandSource)commandContext.getSource(), damagetype,EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                })))
                                .then(CommandManager.literal("minecraft:Dragon_Breath").executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DRAGON_BREATH;
                                    return hurt((ServerCommandSource)commandContext.getSource(), damagetype,EntityArgumentType.getEntities(commandContext, "target"), 1);
                                }).then(CommandManager.argument("amount", FloatArgumentType.floatArg()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DRAGON_BREATH;
                                    return hurt((ServerCommandSource)commandContext.getSource(), damagetype,EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                })))
                                .then(CommandManager.literal("minecraft:Anvil").executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.ANVIL;
                                    return hurt((ServerCommandSource)commandContext.getSource(), damagetype,EntityArgumentType.getEntities(commandContext, "target"), 1);
                                }).then(CommandManager.argument("amount", FloatArgumentType.floatArg()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.ANVIL;
                                    return hurt((ServerCommandSource)commandContext.getSource(), damagetype,EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                })))
                                .then(CommandManager.literal("minecraft:Cactus").executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.CACTUS;
                                    return hurt((ServerCommandSource)commandContext.getSource(), damagetype,EntityArgumentType.getEntities(commandContext, "target"), 1);
                                }).then(CommandManager.argument("amount", FloatArgumentType.floatArg()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.CACTUS;
                                    return hurt((ServerCommandSource)commandContext.getSource(), damagetype,EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                })))
                                .then(CommandManager.literal("minecraft:Fall").executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.FALL;
                                    return hurt((ServerCommandSource)commandContext.getSource(), damagetype,EntityArgumentType.getEntities(commandContext, "target"), 1);
                                }).then(CommandManager.argument("amount", FloatArgumentType.floatArg()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.FALL;
                                    return hurt((ServerCommandSource)commandContext.getSource(), damagetype,EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                })))
                                .then(CommandManager.literal("minecraft:Falling_Block").executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.FALLING_BLOCK;
                                    return hurt((ServerCommandSource)commandContext.getSource(), damagetype,EntityArgumentType.getEntities(commandContext, "target"), 1);
                                }).then(CommandManager.argument("amount", FloatArgumentType.floatArg()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.FALLING_BLOCK;
                                    return hurt((ServerCommandSource)commandContext.getSource(), damagetype,EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                })))
                                .then(CommandManager.literal("minecraft:Lightning_Bolt").executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.LIGHTNING_BOLT;
                                    return hurt((ServerCommandSource)commandContext.getSource(), damagetype,EntityArgumentType.getEntities(commandContext, "target"), 1);
                                }).then(CommandManager.argument("amount", FloatArgumentType.floatArg()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.LIGHTNING_BOLT;
                                    return hurt((ServerCommandSource)commandContext.getSource(), damagetype,EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                })))
                                .then(CommandManager.literal("minecraft:Wither").executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.WITHER;
                                    return hurt((ServerCommandSource)commandContext.getSource(), damagetype,EntityArgumentType.getEntities(commandContext, "target"), 1);
                                }).then(CommandManager.argument("amount", FloatArgumentType.floatArg()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.WITHER;
                                    return hurt((ServerCommandSource)commandContext.getSource(), damagetype,EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                })))
                                .then(CommandManager.literal("minecraft:Sweet_Berry_Bush").executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.SWEET_BERRY_BUSH;
                                    return hurt((ServerCommandSource)commandContext.getSource(), damagetype,EntityArgumentType.getEntities(commandContext, "target"), 1);
                                }).then(CommandManager.argument("amount", FloatArgumentType.floatArg()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.SWEET_BERRY_BUSH;
                                    return hurt((ServerCommandSource)commandContext.getSource(), damagetype,EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                })))
                                .then(CommandManager.literal("minecraft:Cramming").executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.CRAMMING;
                                    return hurt((ServerCommandSource)commandContext.getSource(), damagetype,EntityArgumentType.getEntities(commandContext, "target"), 1);
                                }).then(CommandManager.argument("amount", FloatArgumentType.floatArg()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.CRAMMING;
                                    return hurt((ServerCommandSource)commandContext.getSource(), damagetype,EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                })))
                                .then(CommandManager.literal("minecraft:Magic").executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.MAGIC;
                                    return hurt((ServerCommandSource)commandContext.getSource(), damagetype,EntityArgumentType.getEntities(commandContext, "target"), 1);
                                }).then(CommandManager.argument("amount", FloatArgumentType.floatArg()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.MAGIC;
                                    return hurt((ServerCommandSource)commandContext.getSource(), damagetype,EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                })))
                                .then(CommandManager.literal("minecraft:In_Fire").executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.IN_FIRE;
                                    return hurt((ServerCommandSource)commandContext.getSource(), damagetype,EntityArgumentType.getEntities(commandContext, "target"), 1);
                                }).then(CommandManager.argument("amount", FloatArgumentType.floatArg()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.IN_FIRE;
                                    return hurt((ServerCommandSource)commandContext.getSource(), damagetype,EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                })))
                                .then(CommandManager.literal("minecraft:Lava").executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.LAVA;
                                    return hurt((ServerCommandSource)commandContext.getSource(), damagetype,EntityArgumentType.getEntities(commandContext, "target"), 1);
                                }).then(CommandManager.argument("amount", FloatArgumentType.floatArg()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.LAVA;
                                    return hurt((ServerCommandSource)commandContext.getSource(), damagetype,EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                })))
                                .then(CommandManager.literal("minecraft:In_Wall").executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.IN_WALL;
                                    return hurt((ServerCommandSource)commandContext.getSource(), damagetype,EntityArgumentType.getEntities(commandContext, "target"), 1);
                                }).then(CommandManager.argument("amount", FloatArgumentType.floatArg()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.IN_WALL;
                                    return hurt((ServerCommandSource)commandContext.getSource(), damagetype,EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                })))
                                .then(CommandManager.literal("minecraft:Hot_Floor").executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.HOT_FLOOR;
                                    return hurt((ServerCommandSource)commandContext.getSource(), damagetype,EntityArgumentType.getEntities(commandContext, "target"), 1);
                                }).then(CommandManager.argument("amount", FloatArgumentType.floatArg()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.HOT_FLOOR;
                                    return hurt((ServerCommandSource)commandContext.getSource(), damagetype,EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                })))
                                .then(CommandManager.literal("minecraft:Fly_Into_Wall").executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.FLY_INTO_WALL;
                                    return hurt((ServerCommandSource)commandContext.getSource(), damagetype,EntityArgumentType.getEntities(commandContext, "target"), 1);
                                }).then(CommandManager.argument("amount", FloatArgumentType.floatArg()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.FLY_INTO_WALL;
                                    return hurt((ServerCommandSource)commandContext.getSource(), damagetype,EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                })))
                                .then(CommandManager.literal("minecraft:Dryout").executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DRYOUT;
                                    return hurt((ServerCommandSource)commandContext.getSource(), damagetype,EntityArgumentType.getEntities(commandContext, "target"), 1);
                                }).then(CommandManager.argument("amount", FloatArgumentType.floatArg()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DRYOUT;
                                    return hurt((ServerCommandSource)commandContext.getSource(), damagetype,EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                })))
                                .then(CommandManager.literal("minecraft:Drown").executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DROWN;
                                    return hurt((ServerCommandSource)commandContext.getSource(), damagetype,EntityArgumentType.getEntities(commandContext, "target"), 1);
                                }).then(CommandManager.argument("amount", FloatArgumentType.floatArg()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DROWN;
                                    return hurt((ServerCommandSource)commandContext.getSource(), damagetype,EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                })))
                                .then(CommandManager.literal("minecraft:Arrow").executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DROWN;
                                    return prohurt((ServerCommandSource)commandContext.getSource(), BBDamSource.bbarrow(commandContext.getSource().getEntity(), null),EntityArgumentType.getEntities(commandContext, "target"), 1);
                                }).then(CommandManager.argument("amount", FloatArgumentType.floatArg()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DROWN;
                                    return prohurt((ServerCommandSource)commandContext.getSource(), BBDamSource.bbarrow(commandContext.getSource().getEntity(), null),EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                }).then(CommandManager.argument("source", EntityArgumentType.entity()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DROWN;
                                    return prohurt((ServerCommandSource)commandContext.getSource(), BBDamSource.bbarrow(EntityArgumentType.getEntity(commandContext, "source"), null),EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                }))))
                                .then(CommandManager.literal("minecraft:Fireball").executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DROWN;
                                    return prohurt((ServerCommandSource)commandContext.getSource(), BBDamSource.bbfireball(commandContext.getSource().getEntity(), null),EntityArgumentType.getEntities(commandContext, "target"), 1);
                                }).then(CommandManager.argument("amount", FloatArgumentType.floatArg()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DROWN;
                                    return prohurt((ServerCommandSource)commandContext.getSource(), BBDamSource.bbfireball(commandContext.getSource().getEntity(), null),EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                }).then(CommandManager.argument("source", EntityArgumentType.entity()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DROWN;
                                    return prohurt((ServerCommandSource)commandContext.getSource(), BBDamSource.bbfireball(EntityArgumentType.getEntity(commandContext, "source"), null),EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                }))))
                                .then(CommandManager.literal("minecraft:Firework").executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DROWN;
                                    return prohurt((ServerCommandSource)commandContext.getSource(), BBDamSource.bbfirework(commandContext.getSource().getEntity(), null),EntityArgumentType.getEntities(commandContext, "target"), 1);
                                }).then(CommandManager.argument("amount", FloatArgumentType.floatArg()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DROWN;
                                    return prohurt((ServerCommandSource)commandContext.getSource(), BBDamSource.bbfirework(commandContext.getSource().getEntity(), null),EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                }).then(CommandManager.argument("source", EntityArgumentType.entity()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DROWN;
                                    return prohurt((ServerCommandSource)commandContext.getSource(), BBDamSource.bbfirework(EntityArgumentType.getEntity(commandContext, "source"), null),EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                }))))
                                .then(CommandManager.literal("minecraft:Thrown_Magic").executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DROWN;
                                    return prohurt((ServerCommandSource)commandContext.getSource(), BBDamSource.bbmagic(commandContext.getSource().getEntity(), null),EntityArgumentType.getEntities(commandContext, "target"), 1);
                                }).then(CommandManager.argument("amount", FloatArgumentType.floatArg()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DROWN;
                                    return prohurt((ServerCommandSource)commandContext.getSource(), BBDamSource.bbmagic(commandContext.getSource().getEntity(), null),EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                }).then(CommandManager.argument("source", EntityArgumentType.entity()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DROWN;
                                    return prohurt((ServerCommandSource)commandContext.getSource(), BBDamSource.bbmagic(EntityArgumentType.getEntity(commandContext, "source"), null),EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                }))))
                                .then(CommandManager.literal("minecraft:Throw_Projectile").executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DROWN;
                                    return prohurt((ServerCommandSource)commandContext.getSource(), BBDamSource.bbthrownProjectile(commandContext.getSource().getEntity(), null),EntityArgumentType.getEntities(commandContext, "target"), 1);
                                }).then(CommandManager.argument("amount", FloatArgumentType.floatArg()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DROWN;
                                    return prohurt((ServerCommandSource)commandContext.getSource(), BBDamSource.bbthrownProjectile(commandContext.getSource().getEntity(), null),EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                }).then(CommandManager.argument("source", EntityArgumentType.entity()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DROWN;
                                    return prohurt((ServerCommandSource)commandContext.getSource(), BBDamSource.bbthrownProjectile(EntityArgumentType.getEntity(commandContext, "source"), null),EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                }))))
                                .then(CommandManager.literal("minecraft:Trident").executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DROWN;
                                    return prohurt((ServerCommandSource)commandContext.getSource(), BBDamSource.bbtrident(commandContext.getSource().getEntity(), null),EntityArgumentType.getEntities(commandContext, "target"), 1);
                                }).then(CommandManager.argument("amount", FloatArgumentType.floatArg()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DROWN;
                                    return prohurt((ServerCommandSource)commandContext.getSource(), BBDamSource.bbtrident(commandContext.getSource().getEntity(), null),EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                }).then(CommandManager.argument("source", EntityArgumentType.entity()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DROWN;
                                    return prohurt((ServerCommandSource)commandContext.getSource(), BBDamSource.bbtrident(EntityArgumentType.getEntity(commandContext, "source"), null),EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                }))))
                                .then(CommandManager.literal("minecraft:Wither_Skull").executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DROWN;
                                    return prohurt((ServerCommandSource)commandContext.getSource(), BBDamSource.bbwitherSkull(commandContext.getSource().getEntity(), null),EntityArgumentType.getEntities(commandContext, "target"), 1);
                                }).then(CommandManager.argument("amount", FloatArgumentType.floatArg()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DROWN;
                                    return prohurt((ServerCommandSource)commandContext.getSource(), BBDamSource.bbwitherSkull(commandContext.getSource().getEntity(), null),EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                }).then(CommandManager.argument("source", EntityArgumentType.entity()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DROWN;
                                    return prohurt((ServerCommandSource)commandContext.getSource(), BBDamSource.bbwitherSkull(EntityArgumentType.getEntity(commandContext, "source"), null),EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                }))))
                                .then(CommandManager.literal("minecraft:Thorns").executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DROWN;
                                    return hurt((ServerCommandSource)commandContext.getSource(), DamageSource.thorns(commandContext.getSource().getEntity()),EntityArgumentType.getEntities(commandContext, "target"), 1);
                                }).then(CommandManager.argument("amount", FloatArgumentType.floatArg()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DROWN;
                                    return hurt((ServerCommandSource)commandContext.getSource(), DamageSource.thorns(commandContext.getSource().getEntity()),EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                }).then(CommandManager.argument("source", EntityArgumentType.entity()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DROWN;
                                    return hurt((ServerCommandSource)commandContext.getSource(), DamageSource.thorns(EntityArgumentType.getEntity(commandContext, "source")),EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                }))))
                                .then(CommandManager.literal("minecraft:Explosion").executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DROWN;
                                    return hurt((ServerCommandSource)commandContext.getSource(), DamageSource.explosion(commandContext.getSource().getPlayer()),EntityArgumentType.getEntities(commandContext, "target"), 1);
                                }).then(CommandManager.argument("amount", FloatArgumentType.floatArg()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DROWN;
                                    return hurt((ServerCommandSource)commandContext.getSource(), DamageSource.explosion(commandContext.getSource().getPlayer()),EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                }).then(CommandManager.argument("source", EntityArgumentType.entity()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DROWN;
                                    return hurt((ServerCommandSource)commandContext.getSource(), DamageSource.explosion((LivingEntity) EntityArgumentType.getEntity(commandContext, "source")),EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                }))))
                                .then(CommandManager.literal("minecraft:Sting").executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DROWN;
                                    return hurt((ServerCommandSource)commandContext.getSource(), DamageSource.sting(commandContext.getSource().getPlayer()),EntityArgumentType.getEntities(commandContext, "target"), 1);
                                }).then(CommandManager.argument("amount", FloatArgumentType.floatArg()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DROWN;
                                    return hurt((ServerCommandSource)commandContext.getSource(), DamageSource.sting(commandContext.getSource().getPlayer()),EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                }).then(CommandManager.argument("source", EntityArgumentType.entity()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DROWN;
                                    return hurt((ServerCommandSource)commandContext.getSource(), DamageSource.sting((LivingEntity) EntityArgumentType.getEntity(commandContext, "source")),EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                }))))
                                .then(CommandManager.literal("minecraft:Player").executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DROWN;
                                    return hurt((ServerCommandSource)commandContext.getSource(), DamageSource.player(commandContext.getSource().getPlayer()),EntityArgumentType.getEntities(commandContext, "target"), 1);
                                }).then(CommandManager.argument("amount", FloatArgumentType.floatArg()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DROWN;
                                    return hurt((ServerCommandSource)commandContext.getSource(), DamageSource.player(commandContext.getSource().getPlayer()),EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                }).then(CommandManager.argument("source", EntityArgumentType.player()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DROWN;
                                    return hurt((ServerCommandSource)commandContext.getSource(), DamageSource.player(EntityArgumentType.getPlayer(commandContext, "source")),EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                }))))
                                .then(CommandManager.literal("minecraft:Mob").executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DROWN;
                                    return hurt((ServerCommandSource)commandContext.getSource(), DamageSource.mob(commandContext.getSource().getPlayer()),EntityArgumentType.getEntities(commandContext, "target"), 1);
                                }).then(CommandManager.argument("amount", FloatArgumentType.floatArg()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DROWN;
                                    return hurt((ServerCommandSource)commandContext.getSource(), DamageSource.mob(commandContext.getSource().getPlayer()),EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                }).then(CommandManager.argument("source", EntityArgumentType.entity()).executes((commandContext) -> {
                                    DamageSource damagetype = DamageSource.DROWN;
                                    return hurt((ServerCommandSource)commandContext.getSource(), DamageSource.mob((LivingEntity) EntityArgumentType.getEntity(commandContext, "source")),EntityArgumentType.getEntities(commandContext, "target"), FloatArgumentType.getFloat(commandContext, "amount"));
                                }))))



                )
        );
    }
    private static int hurt(ServerCommandSource source, DamageSource dmg, Collection<? extends Entity> targets, float amount) throws CommandSyntaxException {
        for (Entity target: targets) {
            target.damage(dmg, amount);
        }
        return 1;
    };
    private static int prohurt(ServerCommandSource source, BBDamSource dmg, Collection<? extends Entity> targets, float amount) throws CommandSyntaxException {
        for (Entity target: targets) {
            target.damage(dmg, amount);
        }
        return 1;
    };
}
