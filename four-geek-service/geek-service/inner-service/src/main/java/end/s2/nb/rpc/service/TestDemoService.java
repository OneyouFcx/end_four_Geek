package end.s2.nb.rpc.service;

import end.s2.nb.entity.Rate;
import end.s2.nb.mapper.RateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: Fyh
 * @Date: 2020/3/9 16:28
 */
@Service
public class TestDemoService implements ITestDemoService {
    @Autowired
    private RateMapper rateMapper;

    @Override
    public Object testmsg() {
        List<Rate> rates = rateMapper.selectAlls();
        return rates;
    }
}
