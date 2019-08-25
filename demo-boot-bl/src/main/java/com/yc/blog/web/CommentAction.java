package com.yc.blog.web;

import java.util.Date;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.yc.blog.bean.Comment;
import com.yc.blog.bean.User;
import com.yc.blog.biz.CommentBiz;
import com.yc.blog.vo.Result;

@RestController
public class CommentAction {

	@Resource
	private CommentBiz cbiz;
	
	@PostMapping("comment")
	public Result comment( @Valid Comment comm,Errors errors,
			@SessionAttribute(name = "loginedUser" ,required=false) User user) {		
//		/**
//		 * 练习题：
//		 * 1、评论数更新
//		 * 2、运行期异常捕获
//		 * 
//		 */
//		if (user == null) {
//			return new Result(0, "请先登陆系统!"); 
//
//		}
		//设置评论人id
		comm.setCreateby(user.getId());
		//设置创建时间
		comm.setCreatetime(new Date());

		if (errors.hasErrors()) {
			return new Result(-1, "评论失败!",errors.getAllErrors());
		}
		try {
			cbiz.comment(comm);				
			return new Result(1, "评论成功!",comm); //结果码  返回值 		
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new Result(0, "业务繁忙，请稍后再试!"); 	
		}		
	}
}
