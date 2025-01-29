package org.example.deeper.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.geom.Rectangle2D;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SquareRequest {
    private Double x;
    private Double y;
    private Double w;
    private Double h;

    public Rectangle2D buildRectangle2D(){
        return new Rectangle2D.Double(x,y,w,h);
    }
}
