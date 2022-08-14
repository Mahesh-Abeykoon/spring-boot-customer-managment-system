package com.springboot.customermanagment.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name="customer")

public class Customer {
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Value("${some.key:true,false}")
    private boolean isMarried;
	
    private String contactNumber;

    private String location;

	@CreationTimestamp
	@Column(name="created_at", nullable=false, updatable=false)
	private Date createdTime;
	
	@UpdateTimestamp
	@Column(name="updated_at")
	private Date updatedTime;
}
