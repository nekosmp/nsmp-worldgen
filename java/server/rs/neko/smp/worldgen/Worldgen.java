// Copyright 2024 Atakku <https://atakku.dev>
//
// This project is dual licensed under MIT and Apache.

package rs.neko.smp.worldgen;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.dynamic.CodecHolder;
import net.minecraft.world.gen.densityfunction.DensityFunction;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs.neko.smp.worldgen.func.Distance;
import rs.neko.smp.worldgen.func.XAddZ;
import rs.neko.smp.worldgen.func.XSubZ;

public class Worldgen implements ModInitializer {
  public static final String MOD_ID = "nsmp-worldgen";
  public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

  @Override
  public void onInitialize() {
    LOGGER.info("Initializing NSMP Worldgen");
    reg("distance", Distance.CODEC_HOLDER);
    reg("x_add_z", XAddZ.CODEC_HOLDER);
    reg("x_sub_z", XSubZ.CODEC_HOLDER);
  }

  private void reg(String name, CodecHolder<? extends DensityFunction> c) {
    Registry.register(Registries.DENSITY_FUNCTION_TYPE, new Identifier(MOD_ID, name), c.codec());
  }
}
