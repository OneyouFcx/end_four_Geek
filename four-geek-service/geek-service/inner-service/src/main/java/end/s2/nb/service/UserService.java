package end.s2.nb.service;

import end.s2.end.utils.BeanUtils;
import end.s2.nb.api.IUserService;
import end.s2.nb.entity.UserDetail;
import end.s2.nb.mapper.UserDetailMapper;
import end.s2.nb.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements IUserService {
    @Autowired
    private UserDetailMapper userDetailMapper;
    @Override
    public  List<UserVo> queryUser() {
        List<UserDetail> userDetails = userDetailMapper.queryALl();
        List<UserVo> userVos = BeanUtils.coventList(userDetails, UserVo.class);
        return userVos;
    }
}
