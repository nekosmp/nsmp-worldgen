// Copyright 2025 Atakku <https://atakku.dev>
//
// This project is dual licensed under MIT and Apache.

package dev.atakku.fsmp.worldgen.func;

import net.minecraft.world.gen.densityfunction.DensityFunction;

abstract class EdgeRatioAbstract implements DensityFunction.Base {
  private static final int SIZE = 256;
  private static final int END = 8192;
  private static final int START = END - SIZE;

  protected static double sample(DensityFunction.NoisePos pos, boolean neg) {
    int absX = Math.min(Math.abs(pos.blockX()), END);
    int absZ = Math.min(Math.abs(pos.blockZ()), END);
    if (absX < START && absZ < START) {
      return neg ? 1 : 0;
    }
    int point = Math.max(absX, absZ) - START;
    double r = ((double) point / (double) SIZE);
    return neg ? 1 - r : r;
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