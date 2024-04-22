package co.pitam.aservice.restInterceptor;

import co.pitam.aservice.controller.HeroController;
import io.micrometer.tracing.Tracer;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;

@RequiredArgsConstructor
@Component
public class PitamRestInterceptor implements HandlerInterceptor {
    private final Tracer tracer;

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (!ObjectUtils.isEmpty(HeroController.emailBaggage)) {
            HeroController.emailBaggage.close();
        }

        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
