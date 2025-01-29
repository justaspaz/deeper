package org.example.deeper.controller;

import org.example.deeper.controller.model.IntersectionRequest;
import org.example.deeper.controller.model.PointResponse;
import org.example.deeper.controller.model.PointsResponse;
import org.example.deeper.service.IntersectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.geom.Point2D;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/figures")
public class FigureController {

    private final IntersectionService intersectionService;

    public FigureController(IntersectionService intersectionService) {
        this.intersectionService = intersectionService;
    }

    @PostMapping("/intersect")
    public ResponseEntity<PointsResponse> checkIntersection(@RequestBody IntersectionRequest request){
        HashSet<Point2D> intersections = intersectionService.findIntersections(request.getSquare(),request.getLine());

        if (intersections.isEmpty()) {
            return ResponseEntity.ok(new PointsResponse(false,null));
        } else {
            List<PointResponse> pointResponses = intersections.stream()
                    .map(PointResponse::fromPoint2D)
                    .toList();
            return ResponseEntity.ok(new PointsResponse(true, pointResponses));
        }
    }
}
