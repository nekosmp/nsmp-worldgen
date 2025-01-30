// Copyright 2025 Atakku <https://atakku.dev>
//
// This project is dual licensed under MIT and Apache.

package dev.atakku.fsmp.worldgen.func;

import net.minecraft.util.dynamic.CodecHolder;
import net.minecraft.world.gen.densityfunction.DensityFunction;

import com.mojang.serialization.MapCodec;

import dev.atakku.fsmp.worldgen.Worldgen;

public class ContinentalnessMap implements DensityFunction.Base {
  public static final CodecHolder<ContinentalnessMap> CODEC_HOLDER = CodecHolder
      .of(MapCodec.unit(ContinentalnessMap::new));

  @Override
  public double sample(DensityFunction.NoisePos pos) {
    int x = pos.blockX();
    int z = pos.blockZ();
    return (sample(x - 1, z - 1) +
        sample(x - 1, z) +
        sample(x - 1, z + 1) +
        sample(x, z - 1) +
        sample(x, z) +
        sample(x, z + 1) +
        sample(x + 1, z - 1) +
        sample(x + 1, z) +
        sample(x + 1, z + 1)) / 9.0;
  }

  public static final double sample(int bx, int bz) {
    int x = Math.max(Math.min(bx + 8192, 16383), 0) / 4;
    int z = Math.max(Math.min(bz + 8192, 16383), 0) / 4;
    double amplitude = (Worldgen.CONTINENTALNESS_MAP[x + z * 4096] & 0xFF) / 255.0d;
    return amplitude * 2.0d - 1.0d;
  }

  @Override
  public double minValue() {
    return -1.0;
  }

  @Override
  public double maxValue() {
    return 1.0;
  }

  @Override
  public CodecHolder<? extends DensityFunction> getCodecHolder() {
    return CODEC_HOLDER;
  }
}