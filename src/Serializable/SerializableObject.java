package Serializable;

import java.io.Serializable;

public class SerializableObject implements Serializable {
    private static final long serialVersionUID = 1L;

    private int width;
    private int height;
    private transient int area;

    public SerializableObject(int width, int height) {
        this.width = width;
        this.height = height;
        this.area = width * height;
    }

    public void setArea(){
        this.area = this.width * this.height;
    }


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(40);
        sb.append("width : ");
        sb.append(this.width);
        sb.append("\nheight : ");
        sb.append(this.height);
        sb.append("\narea : ");
        sb.append(this.area);
        return sb.toString();
    }
}
