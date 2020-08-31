package filters.utils.kernels;

import filters.utils.Kernel;

public class SharpenKernel extends Kernel {
    static float[][] v = {
            {     0,   -0.5f,    0 },
            { -0.5f,     3  ,-0.5f },
            {     0,   -0.5f,    0 }
    };
    public SharpenKernel() throws IllegalArgumentException {
        super(v);
    }
}
