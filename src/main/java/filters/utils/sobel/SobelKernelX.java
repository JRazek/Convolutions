package filters.utils.sobel;

import filters.utils.Kernel;

public class SobelKernelX extends Kernel {
    static float[][] v = {
            { 1,  2,  1 },
            { 0,  0,  0 },
            {-1, -2, -1 }
    };
    SobelKernelX() throws IllegalArgumentException {
        super(v);
    }
}
