package org.lanqiao.entity;

public class Rectangle implements Figure{
    // 宽
    private double width;
    // 高
    private double height;

    /**
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * @return the width
     */
    public double getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(double width) {
        this.width = width;
    }

    public Rectangle(){

    }

    public Rectangle(double width,double height){
        this.width = width;
        this.height = height;
    }

    @Override
    public double getPerimeter() {
        return width*2+height*2;
    }

    @Override
    public double getArea() {
        return width*height;
    }

}