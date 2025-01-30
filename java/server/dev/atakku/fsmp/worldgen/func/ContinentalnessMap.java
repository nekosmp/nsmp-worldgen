// Copyright 2025 Atakku <https://atakku.dev>
//
// This project is dual licensed under MIT and Apache.

package dev.atakku.fsmp.worldgen.func;

import net.minecraft.util.dynamic.CodecHolder;
import net.minecraft.world.gen.densityfunction.DensityFunction;

import com.mojang.serialization.MapCodec;

import dev.atakku.fsmp.worldgen.Worldgen;

public class ContinentalnessMap implements DensityFunction.Base {
  public static final CodecHolder<ContinentalnessMap> CODEC_HOLDER = CodecHolder.of(MapCodec.unit(ContinentalnessMap::new));

  @Override
  public double sample(DensityFunction.NoisePos pos) {
    // 7680 -> 8192
    int x = Math.max(Math.min(pos.blockX() + 8192, 16383), 0) / 4;
    int z = Math.max(Math.min(pos.blockZ() + 8192, 16383), 0) / 4;
    double amplitude = (Worldgen.CONTINENTALNESS_MAP[x+z*4096] & 0xFF)/256.0d;
    double r = (1.0 - amplitude * 2.0); // 0 - 1 to -0.125 - 0.125;
    return r * r * r * r;
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