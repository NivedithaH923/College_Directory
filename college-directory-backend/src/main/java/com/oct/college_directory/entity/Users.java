//package com.oct.college_directory.entity;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name="users")
//public class Users {
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="id")
//	private Long id;
//	@Column(name="username")
//    private String username;
//	@Column(name="password")
//    private String password;
//	@Enumerated(EnumType.STRING)
//	@Column(name="role")
//    private Role role;
//	@Column(name="name")
//    private String name;
//	@Column(name="email")
//    private String email;
//	@Column(name="phone")
//    private String phone;
//	
//	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//	//@JsonManagedReference
//	private StudentsProfile studentsProfile;
//	
//	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//	@JsonManagedReference
//	//@JsonIgnore
//	private AdministratorProfile administratorProfile;
//
//	
//	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//	//@JsonManagedReference
//    private FacultyProfile facultyProfile; 
//	public Users() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	public Users(Long id, String username, String password, Role role, String name, String email, String phone) {
//		super();
//		this.id = id;
//		this.username = username;
//		this.password = password;
//		this.role = role;
//		this.name = name;
//		this.email = email;
//		this.phone = phone;
//	}
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public String getUsername() {
//		return username;
//	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	public Role getRole() {
//		return role;
//	}
//	public void setRole(Role role) {
//		this.role = role;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public String getPhone() {
//		return phone;
//	}
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//	public AdministratorProfile getAdministratorProfile() {
//        return administratorProfile;
//    }
//
//    public void setAdministratorProfile(AdministratorProfile administratorProfile) {
//        this.administratorProfile = administratorProfile;
//    }
//    public StudentsProfile getStudentsProfile() {
//        return studentsProfile;
//    }
//
//    public void setStudentsProfile(StudentsProfile studentsProfile) {
//        this.studentsProfile = studentsProfile;
//    }
//    public FacultyProfile getFacultyProfile() {
//        return facultyProfile;
//    }
//
//    public void setFacultyProfile(FacultyProfile facultyProfile) {
//        this.facultyProfile = facultyProfile;
//    }
//	
//}
package com.oct.college_directory.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private AdministratorProfile administratorProfile;

    // Default constructor
    public Users() {
    }

    // Parameterized constructor
    public Users(Long id, String username, String password, Role role, String name, String email, String phone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public AdministratorProfile getAdministratorProfile() {
        return administratorProfile;
    }

    public void setAdministratorProfile(AdministratorProfile administratorProfile) {
        this.administratorProfile = administratorProfile;
    }
}
