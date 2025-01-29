package org.example.deeper.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PointsResponse {
    private boolean intersects;
    List<PointResponse> points;
}