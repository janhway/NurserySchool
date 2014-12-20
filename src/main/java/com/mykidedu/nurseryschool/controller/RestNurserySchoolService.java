package com.mykidedu.nurseryschool.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import com.mykidedu.nurseryschool.auth.UserToken;
import com.mykidedu.nurseryschool.dao.UserDao;
import com.mykidedu.nurseryschool.entity.User;
import com.mykidedu.nurseryschool.msg.CreateUserReq;
import com.mykidedu.nurseryschool.msg.UserNode;
import com.mykidedu.nurseryschool.msg.UserList;
import com.mykidedu.nurseryschool.msg.LoginReq;
import com.mykidedu.nurseryschool.msg.LoginRsp;

@Controller
@Path("/rest")
public class RestNurserySchoolService {

	@Autowired
	private UserDao userDao;

	@POST
    @Path("/test")
	@Consumes("application/json")
	@Produces("application/json")
	public CreateUserReq test(CreateUserReq user) {
        return user;
	}
	
	@GET
    @Path("/user")
	//@Consumes("application/json;charset=UTF-8")
	@Produces("application/json;charset=UTF-8")
	public UserList getAllUser() {
		
		List<UserNode> ulRsp = new ArrayList<UserNode>();
		List<User> ul = userDao.list();
		
		for (User u:ul) {
			UserNode uRsp = new UserNode();
			uRsp.setUserName(u.getUserName());
			uRsp.setFirstName(u.getFirstName());
			uRsp.setLastName(u.getLastName());
			uRsp.setRole(u.getRole());
			ulRsp.add(uRsp);
		}
		
		return new UserList(ulRsp);
	}

	@POST
    @Path("/user")
	@Consumes("application/json;charset=UTF-8")
	@Produces("application/text;charset=UTF-8")
	public Response createUser(CreateUserReq req) {
		
		if (StringUtils.isEmpty(req.getUserName())
				|| StringUtils.isEmpty(req.getPassword())) {
			//throw new WebApplicationException("username or password is null.", Status.BAD_REQUEST);
			return Response.status(Status.BAD_REQUEST).build();
		}
						
		User existUser = userDao.getUser(req.getUserName());
		if (existUser != null)  {
			//throw new WebApplicationException("username exist.", Status.BAD_REQUEST);
			return Response.status(Status.BAD_REQUEST).build();
		}
		
		User user = new User();
		user.setUserName(req.getUserName());
		user.setPassword(req.getPassword());
		user.setRole(req.getRole());
		
		userDao.create(user);
		user = userDao.getUser(user.getUserName());		

		return Response.ok("ok.userid="+user.getId()).build();
	}
	
	@POST
    @Path("/login")
	@Consumes("application/json;charset=UTF-8")
	@Produces("application/json;charset=UTF-8")
	public LoginRsp login(LoginReq login) {
		
		if (StringUtils.isEmpty(login.getUserName())
				|| login.getPassword() == null) {
			throw new WebApplicationException("username or password is null.", Status.BAD_REQUEST);
		}
		
		User user = userDao.getUser(login.getUserName());
		if (user == null || !user.getPassword().equals(login.getPassword())) {
			throw new WebApplicationException("username or password mismatch.", Status.BAD_REQUEST);
		}

		String token = UserToken.makeEncodeToken(user.getId());

		LoginRsp loginRsp = new LoginRsp();
		loginRsp.setUserId(user.getId());
		loginRsp.setEncodedToken(token);

		return loginRsp;
	}


}
