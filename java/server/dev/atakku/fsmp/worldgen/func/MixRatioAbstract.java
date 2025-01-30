// Copyright 2025 Atakku <https://atakku.dev>
//
// This project is dual licensed under MIT and Apache.

package dev.atakku.fsmp.worldgen.func;

import net.minecraft.world.gen.densityfunction.DensityFunction;

abstract class MixRatioAbstract implements DensityFunction.Base {
  private static final int SIZE = 256;
  private static final int END = 8192;
  private static final int START = END - SIZE;

  private static final double POS_RATIO = 0.4;
  private static final double NEG_RATIO = 1.0 - POS_RATIO;

  protected static double sample(DensityFunction.NoisePos pos, boolean neg) {
    int absX = Math.min(Math.abs(pos.blockX()), END);
    int absZ = Math.min(Math.abs(pos.blockZ()), END);
    if (absX < START && absZ < START) {
      return 0.5d;
    }
    int point = Math.max(absX, absZ) - START;
    double ratio = ((double) point / (double) SIZE) * NEG_RATIO;
    if (neg) {
      return NEG_RATIO - ratio;
    }
    return POS_RATIO + ratio;
  }

  @Override
  public double minValue() {
    return 0;
  }

  @Override
  public double maxValue() {
    return 1;
  }
}