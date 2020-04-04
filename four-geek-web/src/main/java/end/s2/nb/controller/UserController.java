package end.s2.nb.controller;

import end.s2.nb.api.IUserPageService;
import end.s2.nb.api.IUserService;
import end.s2.nb.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class UserController {
    @Autowired
    private IUserPageService userDetailMapper;
    @RequestMapping("/user")
    public List<UserVo> testMsg(){
        return userDetailMapper.queryUser();
    }
}
