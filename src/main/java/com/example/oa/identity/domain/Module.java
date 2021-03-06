package com.example.oa.identity.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * @Author xlei @tel 13360026135 @qq 251425887
 * @Date 2015年9月6日下午1:12:37
 * @Email dlei0009@163.com
 * @Version 1.0
 * @From http://www.fkit.org
 *
 */
@Data
@Entity
@Table(name="OA_ID_MODULE")
public class Module implements Serializable {
	
	private static final long serialVersionUID = 5139796285142133024L;
	/**
	 * CODE	VARCHAR2(100)	代码	PK主键
	 */
	@Id @Column(name="CODE", length=100)
	private String code;
	/** 名称  */
	@Column(name="NAME", length=50)
	private String name;
	/**	操作链接 **/
	@Column(name="URL", length=100)
	private String url;
	/** 备注	*/
	@Column(name="REMARK", length=500)
	private String remark;
	/** 模块修改人与用户存在多对一关联(FK(OA_ID_USER)) */
	@ManyToOne(fetch=FetchType.LAZY, targetEntity=User.class)
	@JoinColumn(name="MODIFIER", referencedColumnName="USER_ID", 
				foreignKey=@ForeignKey(name="FK_MODULE_MODIFIER")) // 更改外键约束名
	private User modifier;
	/** 修改时间 */
	@Column(name="MODIFY_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;
	/** 模块创建人与用户存在多对一关联(FK(OA_ID_USER)) */
	@ManyToOne(fetch=FetchType.LAZY, targetEntity=User.class)
	@JoinColumn(name="CREATER", referencedColumnName="USER_ID", 
				foreignKey=@ForeignKey(name="FK_MODULE_CREATER")) // 更改外键约束名
	private User creater;
	/** 创建时间 */
	@Column(name="CREATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
}