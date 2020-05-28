package cn.net.colin.common.exception;

import cn.net.colin.entity.exception.ApiResult;
import cn.net.colin.entity.exception.ResultCode;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sxf on 2019-5-15.
 */
@Component
public class GlobalExceptionHandler implements HandlerExceptionResolver ,Ordered{
    private static Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);
    private int order = Ordered.HIGHEST_PRECEDENCE;

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ex.printStackTrace();
        ApiResult result = ApiResult.of(ResultCode.UNKNOWN_ERROR);
        ModelAndView mv = new ModelAndView();
        if (ex instanceof BusinessRuntimeException) {
            BusinessRuntimeException bex = (BusinessRuntimeException)ex;
            result = ApiResult.of(bex.getResultCode());
        }
        mv = errorResult(result, "error", request);
        return mv;
    }

    /**
     * 判断是否ajax请求
     *
     * @param request 请求对象
     * @return true:ajax请求  false:非ajax请求
     */
    private boolean isAjax(HttpServletRequest request) {
        return "XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"));
    }

    /**
     * 返回错误信息
     *
     * @param result 错误信息对象
     * @param url     错误页url
     * @param request 请求对象
     * @return 模型视图对象
     */
    private ModelAndView errorResult(ApiResult result, String url, HttpServletRequest request) {
        logger.error("请求处理失败，请求url=[{"+request.getRequestURI()+"}], 失败原因 : {"+result.getMsg()+"}");
        if (isAjax(request)) {
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("code",result.getCode());
            map.put("msg",result.getMsg());
            ModelAndView mv = new ModelAndView(new MappingJackson2JsonView(), map);
            return mv;
        } else {
            Map<String, String> model = new HashMap<String, String>();
            model.put("errorMessage", result.getMsg());
            return new ModelAndView(url, model);
        }
    }

    @Override
    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
