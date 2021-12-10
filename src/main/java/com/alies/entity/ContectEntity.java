package com.alies.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contect_info")
public class ContectEntity {
	@Id
    @GeneratedValue
   private Integer id;
	@Column(name = "cont_name")
   private String name;
	@Column(name = "cont_phonumber")
   private long phonenumber;
	@Column(name = "cont_email")
   private String email;
	
	@Column(name = "ACTIVE_SW")
	private String activeSw;

	@Column(name = "CREATED_DATE")
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date createdDate;

	@Column(name = "UPDATED_DATE")
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	private Date updatedDate;
//	  @Column(name = "current_Date") 
//	  @Temporal(TemporalType.DATE)
//	  private Date currentdate;
//	  
//	  @Column(name = "Last_Date") 
//	  @Temporal(TemporalType.DATE)
//	  private Date lastdate;
//	  
//	  @Column(name = "update_Date") 
//	  @Temporal(TemporalType.DATE)
//	  private Date updatedate;
//	 
}
