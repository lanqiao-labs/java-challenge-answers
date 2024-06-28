package org.lanqiao.entity;

public class Rectangle implements Figure{
    private double width;
    private double height;
    
    public Rectangle(){}
    
    public Rectangle(double width,double height){
        this.width = width;
        this.height = height;
    }

    @Override
    public double getPerimeter() {
        // TODO Auto-generated method stub
        return width*2+height*2;
    }

    @Override
    public double getArea() {
        // TODO Auto-generated method stub
        return width*height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    
}
