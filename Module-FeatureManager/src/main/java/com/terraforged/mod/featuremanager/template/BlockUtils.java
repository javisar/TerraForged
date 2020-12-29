/*
 * MIT License
 *
 * Copyright (c) 2020 TerraForged
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.terraforged.mod.featuremanager.template;

import net.minecraft.block.BlockState;
import net.minecraft.pathfinding.PathType;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraft.world.gen.feature.TreeFeature;

public class BlockUtils {

    public static boolean canTreeReplace(IWorldGenerationBaseReader reader, BlockPos pos) {
        return TreeFeature.isReplaceableAt(reader, pos);
    }

    public static boolean isSolid(IWorldReader reader, BlockPos pos) {
        BlockState state = reader.getBlockState(pos);
        return isSolid(state, reader, pos);
    }

    public static boolean isSolid(BlockState state, IWorldReader reader, BlockPos pos) {
        return state.isSolid() || !state.allowsMovement(reader, pos, PathType.LAND);
    }

    public static boolean isSolidNoIce(IWorldReader reader, BlockPos pos) {
        BlockState state = reader.getBlockState(pos);
        return isSolid(state, reader, pos) && !BlockTags.ICE.contains(state.getBlock());
    }
}
