package com.example.oa.identity.domain;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Data
@Entity
@Table(name="OA_ID_USER", indexes={@Index(columnList="NAME", name="IDX_USER_NAME")})
public class User implements Serializable {
	
	private static final long serialVersionUID = -3417930882448168081L;

	/** 用户ID	PK，大小写英文和数字 */
	@Id
	@Column(name="USER_ID", length=50)
	private String userId;

	/** 密码	MD5加密 */	
	@Column(name="PASS_WORD", length=50)
	private String passWord;

	/** 姓名 */
	@Column(name="NAME", length=50)
	private String name;

	/** 性别	1:男 2:女 */
	@Column(name="SEX")
	private Integer sex = 1;

	/** 用户与部门存在多对一关联    部门	FK(OA_ID_DEPT) */
	@ManyToOne(fetch=FetchType.LAZY, targetEntity=Dept.class)
	@JoinColumn(name="DEPT_ID", referencedColumnName="ID", foreignKey=@ForeignKey(name="FK_USER_DEPT"))
	private Dept dept;  // select u from User u where u.dept.id = ?
	
	/** 用户与职位存在多对一关联    职位	FK(OA_ID_JOB) */
	@ManyToOne(fetch=FetchType.LAZY, targetEntity=Job.class)
	@JoinColumn(name="JOB_CODE", referencedColumnName="CODE",
			foreignKey=@ForeignKey(name="FK_USER_JOB"))
	private Job job;

	/** 邮箱 */
	@Column(name="EMAIL", length=50)
	private String email;

	/** 电话号码 */
	@Column(name="TEL", length=50)
	private String tel;

	/** 手机号码 */
	@Column(name="PHONE", length=50)
	private String phone;

	/** QQ号码 */
	@Column(name="QQ_NUM", length=50)
	private String qqNum;

	/** 问题编号 */
	@Column(name="QUESTION")
	private Integer question;

	/** 回答结果 */
	@Column(name="ANSWER", length=200)
	private String answer;

	/** 状态	0新建,1审核,2不通过审核,3冻结  */
	@Column(name="STATUS")
	private Integer status = 0;

	/** 用户创建人与用户存在多对一关联(FK(OA_ID_USER)) */
	@ManyToOne(fetch=FetchType.LAZY, targetEntity=User.class)
	@JoinColumn(name="CREATER", referencedColumnName="USER_ID", 
				foreignKey=@ForeignKey(name="FK_USER_CREATER")) // 更改外键约束名
	private User creater;

	/** 创建时间 */
	@Column(name="CREATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	/** 用户修改人与用户存在多对一关联(FK(OA_ID_USER)) */
	@ManyToOne(fetch=FetchType.LAZY, targetEntity=User.class)
	@JoinColumn(name="MODIFIER", referencedColumnName="USER_ID", 
				foreignKey=@ForeignKey(name="FK_USER_MODIFIER")) // 更改外键约束名
	private User modifier;

	/** 修改时间 */
	@Column(name="MODIFY_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;

	/** 部门审核人与用户存在多对一关联(FK(OA_ID_USER)) */
	@ManyToOne(fetch=FetchType.LAZY, targetEntity=User.class)
	@JoinColumn(name="CHECKER", referencedColumnName="USER_ID", 
				foreignKey=@ForeignKey(name="FK_USER_CHECKER")) // 更改外键约束名
	private User checker;

	/** 审核时间 */
	@Column(name="CHECK_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date checkDate;

	/** 用户与角色存在N-N关联  */
	@ManyToMany(fetch=FetchType.LAZY, targetEntity=Role.class, mappedBy="users")
	private Set<Role> roles = new HashSet<>();
}