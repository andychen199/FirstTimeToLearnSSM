package cn.cerny.controller;

import cn.cerny.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/quick10")
    @ResponseBody
    public User save10() throws JsonProcessingException {
        User user = new User();
        user.setUsername("andy");
        user.setAge(22);

        return user;
    }

    @RequestMapping("/quick9")
    @ResponseBody
    public String save9() throws JsonProcessingException {
        User user = new User();
        user.setUsername("andy");
        user.setAge(22);
        //使用json的转换工具将对象转换成json格式字符串再返回
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        return json;
    }

    @RequestMapping("/quick4")
    public String save4(Model model){
        /*
            Model：模型 作用封装数据
            View：视图 作用展示数据
         */
        model.addAttribute("username","andy");
        return "success";
    }

    @RequestMapping("/quick3")
    public ModelAndView save3(ModelAndView modelAndView){
        /*
            Model：模型 作用封装数据
            View：视图 作用展示数据
         */
        //设置模型数据
        modelAndView.addObject("username","itheima");
        //设置视图名称
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/quick2")
    public ModelAndView save2(){
        /*
            Model：模型 作用封装数据
            View：视图 作用展示数据
         */
        ModelAndView modelAndView = new ModelAndView();
        //设置模型数据
        modelAndView.addObject("username","itcast");
        //设置视图名称
        modelAndView.setViewName("success");
        return modelAndView;
    }

    //请求地址 hhtp://localhost:8080/xxx/quick
    @RequestMapping(value = "/quick",method = RequestMethod.GET,params = {"username"})
    public String save(){
        System.out.println("Controller save running...");
        //return "redirect:/success.jsp";
        return "success";
    }
}
