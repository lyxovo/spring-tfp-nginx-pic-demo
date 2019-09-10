package cn.ssm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.ssm.dao.StudentMapper;
import cn.ssm.dao.bean.Student;
import cn.ssm.dao.bean.Userinfo;

@Service
public class StudentService {
	@Autowired
	private StudentMapper studentMapper;
	
	public List<Student> queryAll(Student stu) {
		List<Student>list=studentMapper.selectAllOfStu(stu);
		return list;
	}

	public Student queryStu(int i) {
		System.err.println(3);
		Student s = studentMapper.selectByPrimaryKey(i);
		
		return s;
	}
	
	
	
	
//	  public List<Userinfo> selectUserinfo() {
//	 	  PageHelper.startPage(2, 3); //使用分页插件
//		  List<Userinfo> userinfos =studentMapper.selectUserinfo();
//		  PageInfo<Userinfo> infos=new PageInfo<Userinfo>(userinfos); 
//		  List<Userinfo> list = infos.getList(); 
//		  return userinfos; 
//	  }
	 
	
	
	public List<Userinfo> selectUserinfo() {
		Userinfo user=new Userinfo();
				user.setPageNum(2);//设置当前为第2页
				user.setPageSize(3);//设置每页总共3条数据
		List<Userinfo> userinfos = studentMapper.selectUserinfo(user);
		return userinfos;
	}
	
	
//	public void addList() {
//		List<Userinfo> userinfos =new ArrayList<Userinfo>();
//		for(int i=1;i<=3;i++) {
//			Userinfo user=new Userinfo();
//			user.setId(13+i);
//			user.setName("wachs"+i+13);
//			user.setPassword(UUID.randomUUID().toString());
//			userinfos.add(user);
//		}
//		studentMapper.addList(userinfos);
//	}
	
	
	public void addList2() {
	List<Userinfo> userinfos =new ArrayList<Userinfo>();
	for(int i=1;i<=5;i++) {
		Userinfo user=new Userinfo();
		user.setName("wachs"+(i+19));
		user.setPassword(UUID.randomUUID().toString());
		userinfos.add(user);
	}
	studentMapper.addList(userinfos);
}
	
	
	
	

}
