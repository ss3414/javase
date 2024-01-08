package mvc.controller;

import mvc.model.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/mvc")
public class MVCController {

    private static final Logger logger = Logger.getLogger(MVCController.class);

    @RequestMapping("/home")
    public ModelAndView home() {
        logger.info("/mvc/home");
        return new ModelAndView("/mvc/home");
    }

    /************************************************************分割线************************************************************/

    @RequestMapping("/jsp")
    public ModelAndView jsp() {
        /*
         * ①通过Map方式传值和View本质相同？
         * ②view.add
         * */
        Map result = new HashMap();

        /* 对象集合 */
        User u1 = new User();
        u1.setId(1);
        User u2 = new User();
        u2.setId(1);
        List userList = new ArrayList();
        userList.add(u1);
        userList.add(u2);
        Map userMap = new HashMap(); /* Map看作JavaBean */
        userMap.put("userList1", userList);
        userMap.put("userList2", userList);
        result.put("userMap", userMap);

        /* Date/String型时间 */
//        List<User> userList = new ArrayList<User>();
//        User user = new User();
//        user.setId(1);
//        user.setDateDate(new Date());
//        user.setStringDate("2018-12-27 14:52:54");
//        userList.add(user);
//        result.put("userList", userList);

        return new ModelAndView("/mvc/view/jsp", result);
    }

    @RequestMapping("/freemarker")
    public ModelAndView freemarker() {
        List<User> userList = new ArrayList<User>();
        userList.add(User.builder().id(1).name("name1").password("pwd1").build());
        userList.add(User.builder().id(2).name("name2").password("pwd2").build());

        Map result = new HashMap();
        result.put("userList", userList);
        return new ModelAndView("/mvc/view/freemarker", result);
    }

    /************************************************************分割线************************************************************/

    @RequestMapping("/mvc/i18n")
    public ModelAndView i18n() {
        return new ModelAndView("/mvc/mvc/i18n");
    }

    @RequestMapping("/redirect")
    public ModelAndView redirect() {
        return new ModelAndView("redirect:/");
    }

    /************************************************************分割线************************************************************/

    @RequestMapping("/websocket")
    public ModelAndView websocket() {
        return new ModelAndView("/mvc/websocket/websocket");
    }

    @RequestMapping("/log")
    public ModelAndView log() {
        return new ModelAndView("/mvc/websocket/log");
    }

}
