package lfzh.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lfzh.model.User;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
	
		// 转换为HandlerMethod对象
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		// 获取请求的方法
		String methodName = handlerMethod.getMethod().getName();
//		System.out.println(methodName);

		// 如果不是主页和登陆相关的,就判断是否登陆
		if (!methodName.equals("index") && !methodName.equals("login")) {
			// 1 获取session
			HttpSession session = request.getSession(true);
			// 2 获取session中的loginUser
			User loginUser = (User) session.getAttribute("loginUser");
			// 3 判断是否为空
			if (loginUser == null) {
				// 未登录 跳转到登陆页面
				response.sendRedirect(request.getContextPath() + "/");
				/**
				 *  return false 设置不放行
				 *  
				 *  如果不加这句话,最终结果也是跳转到登陆页面,效果是一样的
				 *  
				 *  但是 如果不写false,程序还会继续向下执行,一直执行到放行,那么就会先去执行对应的请求操作
				 *  
				 *  执行完成后,再跳转到登陆页面,因为重定向跳转需要请求完之后 再次发送请求
				 *  
				 *  比如 请求user/list  ,但是没有登陆, 并且 这里也没有写false,那么 最终显示的依旧是登陆页面
				 *  
				 *  但是 会先去执行 UserController中的list方法,执行完成后,再跳转到登陆页面,而不是直接进入登陆页面
				 *  
				 *  所以 我们需要添加return false  不放行
				 */
				return false;
			}
		}
		// 放行
		return super.preHandle(request, response, handler);
	}
}
