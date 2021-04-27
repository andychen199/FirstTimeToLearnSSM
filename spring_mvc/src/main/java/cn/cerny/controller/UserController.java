package cn.cerny.controller;

import cn.cerny.domain.User;
import cn.cerny.domain.VO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/quick23")
    @ResponseBody
    public void save23(String username,MultipartFile[] uploadFile) throws Exception{
        System.out.println(username);
//        System.out.println(uploadFile);
        //uploadFile.for
        for (MultipartFile multipartFile : uploadFile) {
            String originalFilename = multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File("D:\\upload\\"+originalFilename));
        }
    }

    @RequestMapping(value = "/quick22")
    @ResponseBody
    public void save22(String username,MultipartFile uploadFile) throws Exception{
        System.out.println(username);
//        System.out.println(uploadFile);
        String originalFilename = uploadFile.getOriginalFilename();
        uploadFile.transferTo(new File("D:\\upload\\"+originalFilename));
    }

    @RequestMapping(value = "/quick21")
    @ResponseBody
    public void save21(@CookieValue(value = "JSESSIONID") String jsessionId){
        System.out.println(jsessionId);
    }

    @RequestMapping(value = "/quick20")
    @ResponseBody
    public void save20(@RequestHeader(value = "User-Agent",required = false) String user_agent){
        System.out.println(user_agent);
    }

    @RequestMapping(value = "/quick19")
    @ResponseBody
    public void save19(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
    }

    @RequestMapping(value = "/quick18")
    @ResponseBody
    public void save18(Date date){
        System.out.println(date);

    }

    @RequestMapping(value = "/quick17/{name}",method = RequestMethod.POST)
    @ResponseBody
    public void save17(@PathVariable(value = "name",required = true) String name) throws JsonProcessingException {
        System.out.println(name);

    }

    @RequestMapping("/quick16")
    @ResponseBody
    public void save16(@RequestParam(value = "name",required = false,defaultValue = "itcast") String username) throws JsonProcessingException {
        System.out.println(username);

    }

    //如果使用ajax传输数据就可以在方法参数中直接传入一个数组而不用创建对象
    @RequestMapping("/quick15")
    @ResponseBody
    public void save15(@RequestBody List<User> userList) throws JsonProcessingException {
        System.out.println(userList);

    }

    @RequestMapping("/quick14")
    @ResponseBody
    public void save14(VO vo) throws JsonProcessingException {
        System.out.println(vo);

    }

    @RequestMapping("/quick13")
    @ResponseBody
    //localhost:8080/user/quick13?strs=aaa&strs=bbb&strs=ccc
    public void save13(String[] strs) throws JsonProcessingException {
        System.out.println(Arrays.asList(strs));
    }

    @RequestMapping("/quick12")
    @ResponseBody
    public void save12(User user) throws JsonProcessingException {
        System.out.println(user);
    }

    @RequestMapping("/quick11")
    @ResponseBody
    public void save11(String username,int age) throws JsonProcessingException {
        System.out.println(username);
        System.out.println(age);
    }

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
