package filters.utils;

public class Kernel {
    float [][] values;
    int sizeXORY;
    Kernel(float[][] v) throws IllegalArgumentException{
        double sqrt = Math.sqrt(v.length - Math.floor(v.length));
        if(sqrt - Math.floor(sqrt) != 0)
            throw new IllegalArgumentException(new Error("the kernel is not square!"));
        sizeXORY = (int) sqrt;
        values = v;
    }

    public int getSizeXORY() {
        return sizeXORY;
    }

    public float[][] getValues() {
        return values;
    }

    Kernel multiply(Kernel k){
        float [][] v = new float[k.getSizeXORY()][k.getSizeXORY()];
        for(int y = 0; y < k.getSizeXORY(); y++){
            for(int x = 0; x < k.getSizeXORY(); x++){
                v[x][y] = k.getValues()[x][y] * this.values[x][y];
            }
        }
        return new Kernel(v);
    }
}
