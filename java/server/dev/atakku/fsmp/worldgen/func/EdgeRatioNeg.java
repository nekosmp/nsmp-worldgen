// Copyright 2025 Atakku <https://atakku.dev>
//
// This project is dual licensed under MIT and Apache.

package dev.atakku.fsmp.worldgen.func;

import net.minecraft.util.dynamic.CodecHolder;
import net.minecraft.world.gen.densityfunction.DensityFunction;

import com.mojang.serialization.MapCodec;

public class EdgeRatioNeg extends EdgeRatioAbstract {
  public static final CodecHolder<EdgeRatioNeg> CODEC_HOLDER = CodecHolder.of(MapCodec.unit(EdgeRatioNeg::new));

  @Override
  public double sample(DensityFunction.NoisePos pos) {
    return sample(pos, true);
  }

  @Override
  public CodecHolder<? extends DensityFunction> getCodecHolder() {
    return CODEC_HOLDER;
  }
}