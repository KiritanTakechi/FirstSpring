import com.ouka.config.MainConfiguration;
import com.ouka.mapper.UserMapper;
import com.ouka.model.User;
import com.ouka.service.RegisterService;
import com.ouka.service.UserService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

/*
class Main {
    @Test
    public void login() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);
        User user = (User) context.getBean("user");
        user.setNickname("丁真").setUsername("Kiritan").setPassword("123456");
        System.out.println(user.toString());
        */
/*UserService service = (UserService) context.getBean("userService");
        service.getUserAll().forEach(System.out::println);*//*

    }
}
*/

@ContextConfiguration(classes = { MainConfiguration.class }, loader = AnnotationConfigWebContextLoader.class)
@SpringJUnitConfig(classes = MainConfiguration.class)
@WebAppConfiguration
public class MyTest {
    @Resource
    private User user;
    @Resource
    private RegisterService registerService;
    @Resource
    private UserService userService;
    @Resource
    private UserMapper userMapper;

    @Test
    public void login() {
        user.setNickname("丁真").setUsername("222").setPassword("123456");
        System.out.println(user.toString());
        //registerService.register("111", "222", "333");
        userMapper.getUserAll().forEach(System.out::println);
        userMapper.insertUser(user);
    }
}
