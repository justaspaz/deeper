package org.example.deeper.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.geom.Point2D;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PointResponse {
    private double x;
    private double y;

    public static PointResponse fromPoint2D(Point2D point) {
        return new PointResponse(point.getX(), point.getY());
    }
}
