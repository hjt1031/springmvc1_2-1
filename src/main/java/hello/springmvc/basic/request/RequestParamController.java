package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username ={}, age ={}", username, age);

        response.getWriter().write("ok");
    }

    @ResponseBody
    @RequestMapping("request-param-v2")
    public String requestParmaV2(@RequestParam("username") String memberName,
                                 @RequestParam("age") int memberAge) {
        log.info("username ={}, age ={}", memberName, memberAge);
        //Controller 를 사용하면 view 를 찾게되는데 문자를 보여주고싶으면, ResponseBody 나 RestController 사용
        return "ok";
    }


    @ResponseBody
    @RequestMapping("request-param-v3")
    // 파라미터를 생략 하려면 들어오는 파라미터 키 값이랑 매핑하려는 변수명이랑 일치 해야함.
    public String requestParmaV3(@RequestParam String username,
                                 @RequestParam int age) {

        log.info("username ={}, age ={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("request-param-v4")
    // 파라미터를 생략 하려면 들어오는 파라미터 키 값이랑 매핑하려는 변수명이랑 일치 해야함.
    public String requestParmaV4(String username, int age) {

        log.info("username ={}, age ={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("request-param-required")
    //required = true 면 필수 값
    public String requestParmaRequired(@RequestParam(required = true) String username, @RequestParam(required = false) int age) {

        log.info("username ={}, age ={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("request-param-default")
    //defaultValue : 값 이 안들어오면 설정해둔 값 으로 대체 된다.
    public String requestParmaDefault(@RequestParam(required = true, defaultValue = "guest") String username,
                                       @RequestParam(required = false, defaultValue = "-1") int age) {

        log.info("username ={}, age ={}", username, age);
        return "ok";
    }


    @ResponseBody
    @RequestMapping("request-param-map")
    //defaultValue : 값 이 안들어오면 설정해둔 값 으로 대체 된다.
    public String requestParmaMap(@RequestParam Map<String, Object> parmaMap) {
        log.info("username ={}, age ={}", parmaMap.get("username"), parmaMap.get("age"));
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@RequestParam String username, @RequestParam int age) {
        HelloData helloData = new HelloData();

    }
}
