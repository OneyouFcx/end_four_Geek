package end.s2.nb.rpc.service;

import end.s2.nb.rpc.api.ITestService;

import org.apache.dubbo.config.annotation.Service;

@Service(version="1.0.0",interfaceClass = ITestService.class)
public class TestService implements ITestService {
    @Override
    public void queryMsg() {
        System.out.println("调用提供方成功~~~~~");
    }
}
