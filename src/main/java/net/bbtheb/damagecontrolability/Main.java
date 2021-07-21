package net.bbtheb.damagecontrolability;

import net.bbtheb.damagecontrolability.command.damage;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "damcont";
    public static final String MOD_NAME = "Damage Control";

    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing");
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            damage.register(dispatcher);
        });
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

}