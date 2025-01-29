package org.example.deeper.service;

import org.example.deeper.controller.model.LineRequest;
import org.example.deeper.controller.model.SquareRequest;
import org.springframework.stereotype.Service;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IntersectionService {
    public HashSet<Point2D> findIntersections (SquareRequest square, LineRequest line) {
        HashSet<Point2D> intersections = new HashSet<>();
        Line2D line2D = line.buildLine2D();
        Rectangle2D rectangle2D = square.buildRectangle2D();

        List<Line2D> edges = findEdges(rectangle2D);

        for (Line2D edge : edges) {
            checkAndAddIntersection(line2D, edge, intersections);
        }

        return intersections;
    }

    private List<Line2D> findEdges(Rectangle2D rectangle) {
        double x1 = rectangle.getMinX();
        double x2 = rectangle.getMaxX();
        double y1 = rectangle.getMinY();
        double y2 = rectangle.getMaxY();

        List<Line2D> edges = new ArrayList<>();
        edges.add(new Line2D.Double(x1, y2, x2, y2));
        edges.add(new Line2D.Double(x1, y1, x2, y1));
        edges.add(new Line2D.Double(x1, y1, x1, y2));
        edges.add(new Line2D.Double(x2, y1, x2, y2));

        return edges;
    }


    private void checkAndAddIntersection(Line2D line, Line2D edge, HashSet<Point2D> intersections) {
        if (line.intersectsLine(edge)) {
            Point2D intersection = getIntersectionPoint(line, edge);
            if (intersection != null) {
                intersections.add(intersection);
            }
        }
    }

    private Point2D getIntersectionPoint(Line2D line1, Line2D line2) {
        double x1 = line1.getX1(), y1 = line1.getY1(), x2 = line1.getX2(), y2 = line1.getY2();
        double x3 = line2.getX1(), y3 = line2.getY1(), x4 = line2.getX2(), y4 = line2.getY2();

        double denominator = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
        if (denominator == 0) {
            return null;
        }

        double px = ((x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3 * x4)) / denominator;
        double py = ((x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3 * x4)) / denominator;

        return new Point2D.Double(px, py);
    }
}
