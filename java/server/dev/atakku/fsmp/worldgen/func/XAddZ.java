// Copyright 2024 Atakku <https://atakku.dev>
//
// This project is dual licensed under MIT and Apache.

package dev.atakku.fsmp.worldgen.func;

import net.minecraft.util.dynamic.CodecHolder;
import net.minecraft.world.gen.densityfunction.DensityFunction;

import com.mojang.serialization.MapCodec;

public class XAddZ implements DensityFunction.Base {
  public static final CodecHolder<XAddZ> CODEC_HOLDER = CodecHolder.of(MapCodec.unit(XAddZ::new));

  @Override
  public double sample(DensityFunction.NoisePos pos) {
    return pos.blockX() + pos.blockZ();
  }

  @Override
  public double minValue() {
    return -Double.MAX_VALUE;
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