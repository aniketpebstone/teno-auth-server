package com.teno.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name = "user_master")
public class UserEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer	id;

	@Column(name = "first_name")
	private String	firstName;

	@Column(name = "last_name")
	private String	lastName;

	@Column(name = "email")
	private String	email;

	@Column(name = "phone")
	private String	phone;

	@Column(name = "country_code")
	private String	countryCode;

	@Column(name = "password")
	private String	password;

	@Column(name = "is_email_confirmed")
	private Boolean	isEmailConfirmed;

	@Column(name = "is_phone_confirmed")
	private Boolean	isPhoneConfirmed;

	/*@Column(name = "created_by")
	private Integer	createdBy;*/

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_time", updatable = false, insertable = false)
	private Date	createdTime;

	@Column(name = "modified_by")
	private Integer	modifiedBy;

	/*@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_time", updatable = true, insertable = false)
	private Date			modifiedTime;*/

	@Column(name = "modified_time")
	private Long	modifiedTime;

	@Column(name = "is_active")
	private Boolean	isActive;

	@Column(name = "is_deleted")
	private Boolean	isDeleted;

	@Column(name = "role_id")
	private Integer	roleId;

	@Column(name = "auth_token")
	private String	authToken;

	@Column(name = "jabbered_id")
	private String	jabberedId;

	@Column(name = "jabbered_password")
	private String	jabberedPassword;

	@Column(name = "login_time")
	private Date	loginTime;

	@Column(name = "login_count")
	private Integer	loginCount;

//	@Column(name = "devices")
//	private String	devices;

	//	@Column(name = "child_list")
	@Transient
	private String	childList;

	@Column(name = "school_id")
	private Integer	schoolId;

	@Column(name = "IS_PAYMENT_ENABLED")
	private boolean	isPaymentEnabled	= false;

	@Column(name = "is_tnc_accepted")
	private boolean	isTncAccepted		= false;

	@Column(name = "source")
	private String	source;

	@Column(name = "pincode")
	private String	pincode;

	@Column(name = "ACCOUNT_LIST")
	private String	accountList;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "BIRTH_DATE")
	private Date	birthDate			= null;

	@Column(name = "enrollment_id")
	private String	enrollmentId;

	@Column(name = "roll_number")
	private String	rollNumber;
	

}
