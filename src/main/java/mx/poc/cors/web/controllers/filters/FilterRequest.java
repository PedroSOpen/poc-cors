package mx.poc.cors.web.controllers.filters;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class FilterRequest  implements Filter {

    public static final String REQUEST_ID = "X-Request-ID";
    public static final String AUTHORIZATION = "Authorization";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        try {
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            final String idRequest = UUID.randomUUID().toString();
            MDC.put(REQUEST_ID, idRequest);
            response.addHeader(REQUEST_ID, idRequest);
            log.info("Peticion recibida:" + request.getMethod());
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            MDC.remove(REQUEST_ID);
        }

    }
}
