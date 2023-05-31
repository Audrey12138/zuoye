package com.controller;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.beans.UserInfo;
import com.dao.UserDao;
import com.service.UserService;
@Controller
public class UserController {	
		//用于国际化
		@Resource 
		private MessageSource messageSource;
		@Resource
		private UserService userService;
		@Resource
		private UserDao userDao;
	
		//注意,这里配置了访问 login.html 在这处理
		@GetMapping(value={"/login"})
		public String gotoLogin() {
			return "login";  
		}
	
		@PostMapping(value={"/login"})
		public String login(String userName , String passWord,ModelMap m ,HttpSession session) 
					{
			UserInfo user=userService.login(userName, passWord);
						if(user!=null) {
							session.setAttribute("session_user", user);
							return "main";  
						}
						else {
							m.put("msg", "账号或密码错误,登录失败");	
							return "login"; 
						}		
					}
		//查询所有用户列表
		@RequestMapping("/users")
		public String getAll(ModelMap m) {
			List<UserInfo> userList = userService.getAll();
			m.put("usersList", userList);
			return "user-pages/user-manager";
		}
		
		//转到用户添加界面
		@GetMapping("/user")
	    public String toAddPage(){
	        return "user-pages/user-add";
	    }
	
		//真正的进行用户添加,实际上用户修改走的也是这个方法,内部会根据有没有id进行区分
		@RequestMapping("/user")
		public String addUser(UserInfo user,ModelMap m) {
			 userService.addUser(user);
			 m.put("msg", "用户添加成功");
			 return "redirect:/users";
		}
		
		//根据用户id,查询用户信息,转到用户修改页面
		@GetMapping("/user/{id}")    
	       public String toEditPage(@PathVariable("id") Integer id, Model model){
	           UserInfo user = userService.getUserById(id);
		           System.out.println(user);
		           model.addAttribute("user", user);
		           System.out.printf("成功运行");
		           //回到修改页面(user-add是一个修改添加二合一的页面);
		           return "user-pages/user-add";  
		  }

		
				
	    //删除
	  	@GetMapping("/delete/{id}")
	  	public String delete(@PathVariable("id") Integer id,ModelMap m)
	  	{
	  		userService.deleteUser(id);
	  		m.put("msg"	,"删除成功");
	  		return "redirect:/users";
	  	}
    
		//转到收银支付界面
			@GetMapping("/shouyin")
			public String toShouYin(){
				return "shouyin";
				    }
		
		//转到商品库存界面
			@GetMapping("/goods-manager")
			public String toCangKu(){
				return "goods-manager";
	    }
		
		//结算界面
			@GetMapping("/jiesuan")
		    public String toJieSuan(){
		        return "jiesuan";
		    } 
		
	
	    //退回到登录界面
		   @GetMapping("/logout")
	       public String tologinPage(){
	           return "login";
	       }
	    
	  
}

