package com.example.oa.identity.domain;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.*;

@Data
@Entity
@Table(name="OA_ID_JOB")
//@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Job implements Serializable {
	
	private static final long serialVersionUID = 459497377750274376L;

	/** CODE VARCHAR2(100) 代码 PK主键 */
	@Id
	@Column(name="CODE", length=100)
	private String code;

	/** NAME VARCHAR2(50) 名称 */
	@Column(name="NAME", length=50)
	private String name;

	/** REMARK	VARCHAR2(300) 职位说明*/
	@Column(name="REMARK", length=300)
	private String remark;
}
