package filters.utils.kernels;

import filters.utils.Kernel;

public class BlurKernel extends Kernel {
    static float[][] v = {
            { 1,  2,  1 },
            { 2,  4,  2 },
            { 1,  2,  1 }
    };
    public BlurKernel() throws IllegalArgumentException {
        super(v);
    }
}
