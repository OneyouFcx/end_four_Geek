package end.s2.nb.controller;

import end.s2.nb.page.ITestDemoPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Fyh
 * @Date: 2020/3/9 13:16
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    ITestDemoPageService testDemoPageService;

    @GetMapping("/msg")
    public Object test() {
        return testDemoPageService.testMsg();
    }

}
