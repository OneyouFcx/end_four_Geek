package end.s2.nb.api;

import end.s2.nb.vo.UserVo;

import java.util.List;

public interface IUserService {
    List<UserVo> queryUser();
}
