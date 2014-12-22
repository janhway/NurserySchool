package com.mykidedu.nurseryschool.controller;

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
import com.mykidedu.nurseryschool.dao.SchoolDao;
import com.mykidedu.nurseryschool.dao.SchoolMasterDao;
import com.mykidedu.nurseryschool.dao.UserDao;
import com.mykidedu.nurseryschool.entity.Role;
import com.mykidedu.nurseryschool.entity.Schools;
import com.mykidedu.nurseryschool.entity.SchoolMaster;
import com.mykidedu.nurseryschool.entity.Users;
import com.mykidedu.nurseryschool.msg.CreateSchoolMasterReq;
import com.mykidedu.nurseryschool.msg.CreateSchoolReq;
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
	
	@Autowired
	private SchoolDao schoolDao;
	
	@Autowired
	private SchoolMasterDao schoolMasterDao;

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
		List<Users> ul = userDao.list();
		
		for (Users u:ul) {
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
	@Produces("text/plain;charset=UTF-8")
	public Response createUser(CreateUserReq req) {
		
		if (StringUtils.isEmpty(req.getUserName())
				|| StringUtils.isEmpty(req.getPassword())) {
			return Response.status(Status.BAD_REQUEST).entity("username or password is null").build();
		}
						
		Users existUser = userDao.getUser(req.getUserName());
		if (existUser != null)  {
			return Response.status(Status.BAD_REQUEST).entity("username exists.").build();
		}
		
		Users user = crtUser(req);		
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
			Response rp = Response.status(Status.BAD_REQUEST).entity("username or password is null.").build();
			throw new WebApplicationException(rp);
		}
		
		Users user = userDao.getUser(login.getUserName());
		if (user == null || !user.getPassword().equals(login.getPassword())) {
			Response rp = Response.status(Status.BAD_REQUEST).entity("username or password mismatch.").build();
			throw new WebApplicationException(rp);
		}

		String token = UserToken.makeEncodeToken(user.getId());

		LoginRsp loginRsp = new LoginRsp();
		loginRsp.setUserId(user.getId());
		loginRsp.setEncodedToken(token);

		return loginRsp;
	}


	@POST
    @Path("/school")
	@Consumes("application/json;charset=UTF-8")
	@Produces("text/plain;charset=UTF-8")
	public Response createSchool(CreateSchoolReq req) {
		
		if (StringUtils.isEmpty(req.getName())
				|| StringUtils.isEmpty(req.getAddress())) {
			return Response.status(Status.BAD_REQUEST).entity("username or password is null.").build();
		}
						
		Schools existSchool = schoolDao.getSchool(req.getName());
		if (existSchool != null)  {
			return Response.status(Status.BAD_REQUEST).entity("school exists.").build();
		}
		
		Schools school = new Schools();
		school.setName(req.getName());
		school.setAddress(req.getAddress()); 
		school.setDescription(req.getDescription());
		
		schoolDao.create(school);
		school = schoolDao.getSchool(school.getName());		

		return Response.ok("ok.schoolId="+school.getId()).build();
	}
	
	@POST
    @Path("/schoolMaster")
	@Consumes("application/json;charset=UTF-8")
	@Produces("application/text;charset=UTF-8")
	public Response createSchoolMaster(CreateSchoolMasterReq req) {
		
		if (StringUtils.isEmpty(req.getCrtUserReq().getUserName())
				|| StringUtils.isEmpty(req.getCrtUserReq().getPassword())) {
			//throw new WebApplicationException("username or password is null.", Status.BAD_REQUEST);
			return Response.status(Status.BAD_REQUEST).build();
		}
		
		if (req.getSchoolId() == 0) {
			//throw new WebApplicationException("username or password is null.", Status.BAD_REQUEST);
			return Response.status(Status.BAD_REQUEST).build();
		}
		
		Users existUser = userDao.getUser(req.getCrtUserReq().getUserName());
		if (existUser != null)  {
			//throw new WebApplicationException("user exists.", Status.BAD_REQUEST);
			return Response.status(Status.BAD_REQUEST).build();
		}
						
		Schools existSchool = schoolDao.get(req.getSchoolId());
		if (existSchool == null)  {
			//throw new WebApplicationException("school doesnot exist.", Status.BAD_REQUEST);
			return Response.status(Status.BAD_REQUEST).build();
		}
		
		req.getCrtUserReq().setRole(Role.SCHOOLMASTER);
		Users user = crtUser(req.getCrtUserReq());
		
		SchoolMaster sm = schoolMasterDao.createSchoolMaster(existSchool, user);

		return Response.ok("ok.schoolMasterId="+sm.getSchoolMasterId().getUser().getId()).build();
	}
	
	private Users crtUser(CreateUserReq req) {
		Users user = new Users();
		user.setUserName(req.getUserName());
		user.setPassword(req.getPassword());
		user.setRole(req.getRole());
		return user;
	}	
}
