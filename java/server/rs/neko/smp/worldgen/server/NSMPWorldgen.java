// Copyright 2023 Atakku <https://atakku.dev>
//
// This project is dual licensed under MIT and Apache.

package rs.neko.smp.worldgen.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import net.fabricmc.api.ModInitializer;

public class NSMPWorldgen implements ModInitializer {
  public static final String MOD_ID = "nsmp-worldgen";
  public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

  @Override
  public void onInitialize() {
    LOGGER.info("Initializing NSMP Worldgen");
    Registry.register(Registries.DENSITY_FUNCTION_TYPE, new Identifier(NSMPWorldgen.MOD_ID, "distance"), Distance.CODEC_HOLDER.codec());
    Registry.register(Registries.DENSITY_FUNCTION_TYPE, new Identifier(NSMPWorldgen.MOD_ID, "x_add_z"), XAddZ.CODEC_HOLDER.codec());
    Registry.register(Registries.DENSITY_FUNCTION_TYPE, new Identifier(NSMPWorldgen.MOD_ID, "x_sub_z"), XSubZ.CODEC_HOLDER.codec());
  }
}
