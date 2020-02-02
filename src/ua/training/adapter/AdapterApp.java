package ua.training.adapter;

public class AdapterApp {

    public static void main(String[] args) {
        VectorGraphicsInterface adapter = new VectorAdapterFromRaster2();
        adapter.drawLine();
        adapter.drawSquare();
    }
}

interface VectorGraphicsInterface{
    void drawLine();
    void drawSquare();
}

class RasterGraphics{
    void drawRasterLine(){
        System.out.println("Рисуем линию");
    }

    void drawRasterSquare() {
        System.out.println("Рисуем квадрат");
    }
}

class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphicsInterface{

    @Override
    public void drawLine() {
        drawRasterLine();
    }

    @Override
    public void drawSquare() {
        drawRasterSquare();
    }

}

class VectorAdapterFromRaster2 implements VectorGraphicsInterface{
    RasterGraphics rg = new RasterGraphics();
//    RasterGraphics rg1;
//
//    public VectorAdapterFromRaster2(RasterGraphics rasterGraphics){
//        this.rg1 = rasterGraphics;
//    }
    @Override
    public void drawLine() {
        rg.drawRasterLine();
    }

    @Override
    public void drawSquare() {
        rg.drawRasterSquare();
    }
}


