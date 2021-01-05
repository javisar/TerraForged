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

package com.terraforged.mod.mixin.client;

import com.terraforged.mod.client.render.TFDimensionRenderInfo;
import net.minecraft.client.world.DimensionRenderInfo;
import net.minecraft.world.DimensionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Non-essential.
 * Modifies the client-side cloud height.
 */
@Mixin(DimensionRenderInfo.class)
public class MixinDimensionRenderInfo {

    @Inject(method = "func_243495_a", at = @At("HEAD"), cancellable = true)
    private static void getRenderType(DimensionType dimType, CallbackInfoReturnable<DimensionRenderInfo> cir) {
        if (dimType.getEffects().equals(DimensionType.OVERWORLD_ID)) {
            cir.setReturnValue(TFDimensionRenderInfo.INSTANCE.init());
        }
    }
}
