package end.s2.nb.page_service;

import end.s2.nb.inner.ITestDemoService;
import end.s2.nb.page.ITestDemoPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: Fyh
 * @Date: 2020/3/9 13:50
 */
@Service
public class TestDemoPageService implements ITestDemoPageService {

    @Autowired
    ITestDemoService testDemoService;
    @Override
    public Object testMsg() {

        return testDemoService.testmsg();
    }
}
