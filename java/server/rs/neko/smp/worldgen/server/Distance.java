// Copyright 2024 Atakku <https://atakku.dev>
//
// This project is dual licensed under MIT and Apache.

package rs.neko.smp.worldgen.server;

import net.minecraft.util.dynamic.CodecHolder;
import net.minecraft.world.gen.densityfunction.DensityFunction;

import com.mojang.serialization.MapCodec;

public class Distance implements DensityFunction.Base {
  public static final CodecHolder<Distance> CODEC_HOLDER = CodecHolder.of(MapCodec.unit(Distance::new));

  @Override
  public double sample(DensityFunction.NoisePos pos) {
    return Math.sqrt(pos.blockX() * pos.blockX() + pos.blockZ() * pos.blockZ());
  }

  @Override
  public double minValue() {
    return 0;
  }

  @Override
  public double maxValue() {
    return Double.MAX_VALUE;
  }

  @Override
  public CodecHolder<? extends DensityFunction> getCodecHolder() {
    return CODEC_HOLDER;
  }
}