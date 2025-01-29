package org.example.deeper.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class ActiveRequestFilter extends OncePerRequestFilter {

    private static final AtomicInteger activeRequests = new AtomicInteger(0);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        activeRequests.incrementAndGet(); // ✅ Increment on request start
        try {
            filterChain.doFilter(request, response);
        } finally {
            activeRequests.decrementAndGet(); // ✅ Decrement when request ends
        }
    }

    public static int getActiveRequests() {
        return activeRequests.get();
    }
}