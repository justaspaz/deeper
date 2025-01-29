package org.example.deeper.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IntersectionRequest {
    private LineRequest line;
    private SquareRequest square;
}