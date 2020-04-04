package end.s2.nb.service;

import end.s2.nb.api.IUserPageService;
import end.s2.nb.api.IUserService;
import end.s2.nb.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPageService implements IUserPageService {
    @Autowired
    private IUserService userService;

    @Override
    public List<UserVo> queryUser() {
        List<UserVo> userVos = userService.queryUser();
        //  业务操作
        // 返回.
        return userVos;
    }


}
