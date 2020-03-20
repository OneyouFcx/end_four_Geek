package end.s2.nb.inner_service;

import end.s2.nb.inner.IUserService;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: Fyh
 * @Date: 2020/3/9 16:54
 */
@Service
public class UserService implements IUserService {
    @Override
    public String msg() {
        return "";
    }
}
