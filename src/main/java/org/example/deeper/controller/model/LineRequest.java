package org.example.deeper.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.geom.Line2D;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LineRequest {
    private Double x1;
    private Double y1;
    private Double x2;
    private Double y2;

    public Line2D buildLine2D(){
        return new Line2D.Double(x1, y1, x2, y2);
    }
}


