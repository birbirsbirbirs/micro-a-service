package co.pitam.aservice.restInterceptor;

import co.pitam.aservice.controller.HeroController;
import io.micrometer.tracing.Tracer;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Component
public class PitamRestInterceptor implements HandlerInterceptor {
    private final Tracer tracer;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HeroController.emailBaggage.close();
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
